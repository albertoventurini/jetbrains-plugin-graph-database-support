/**
 * Copied and adapted from plugin
 * <a href="https://github.com/neueda/jetbrains-plugin-graph-database-support">Graph Database Support</a>
 * by Neueda Technologies, Ltd.
 * Modified by Alberto Venturini, 2022
 */
package com.albertoventurini.graphdbplugin.jetbrains.actions.execute;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.messages.MessageBus;
import com.albertoventurini.graphdbplugin.jetbrains.ui.console.event.QueryParametersRetrievalErrorEvent;
import com.albertoventurini.graphdbplugin.jetbrains.ui.console.params.ParametersService;
import com.albertoventurini.graphdbplugin.jetbrains.util.Notifier;

import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.Map;

import static com.albertoventurini.graphdbplugin.language.cypher.util.PsiTraversalUtilities.Cypher.getCypherStatementAtOffset;
import static com.albertoventurini.graphdbplugin.platform.SupportedLanguage.isSupported;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public abstract class QueryAction extends AnAction {

    private static final String QUERY_EXECUTION_ERROR_TITLE = "Query execution error";
    private static final String NO_PROJECT_PRESENT_MESSAGE = "No project present.";
    private static final String NO_EDITOR_PRESENT_MESSAGE = "No editor present.";
    private static final String NO_QUERY_SELECTED_MESSAGE = "No query selected";

    private static final String EXECUTE_WITH_SHORTCUT_ACTION = "executeWithShortcut";
    private static final String EXECUTE_WITH_MOUSE_ACTION = "executeWithMouse";
    private static final String CONTENT_FROM_SELECT_ACTION = "contentFromSelect";
    private static final String CONTENT_FROM_CARET_ACTION = "contentFromCaret";
    private static final String CONTENT_FROM_LINE_MARKER_ACTION = "contentFromLineMarker";

    public QueryAction() {
    }

    private PsiElement preSetQuery;

    public QueryAction(PsiElement element) {
        preSetQuery = element;
    }

    @Override
    public void update(AnActionEvent e) {
        Editor editor = e.getData(CommonDataKeys.EDITOR_EVEN_IF_INACTIVE);

        if (nonNull(editor)) {
            e.getPresentation().setEnabled(true);
        } else {
            e.getPresentation().setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(AnActionEvent e) {

        Project project = getEventProject(e);
        Editor editor = e.getData(CommonDataKeys.EDITOR_EVEN_IF_INACTIVE);
        PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);

        if (isNull(project)) {
            Notifier.error(QUERY_EXECUTION_ERROR_TITLE, NO_PROJECT_PRESENT_MESSAGE);
            return;
        }
        if (isNull(editor)) {
            Notifier.error(QUERY_EXECUTION_ERROR_TITLE, NO_EDITOR_PRESENT_MESSAGE);
            return;
        }

        String query = null;
        Map<String, Object> parameters = Collections.emptyMap();
        if (preSetQuery == null) {
            Caret caret = editor.getCaretModel().getPrimaryCaret();

            if (caret.hasSelection()) {
                query = caret.getSelectedText();
            } else if (nonNull(psiFile)) {
                String languageId = psiFile.getLanguage().getID();
                if (isSupported(languageId)) {
                    PsiElement cypherStatement = getCypherStatementAtOffset(psiFile, caret.getOffset());
                    if (nonNull(cypherStatement)) {
                        query = cypherStatement.getText();
                        parameters = getParametersFromQuery(cypherStatement, project, editor);
                    }
                }
            }
        } else {
            query = preSetQuery.getText();
            parameters = getParametersFromQuery(preSetQuery, project, editor);
        }

        if (isNull(query)) {
            Notifier.error(QUERY_EXECUTION_ERROR_TITLE, NO_QUERY_SELECTED_MESSAGE);
            return;
        }

        actionPerformed(e, project, editor, query, parameters);
    }

    protected abstract void actionPerformed(AnActionEvent e, Project project, Editor editor, String query, Map<String, Object> parameters);

    private Map<String, Object> getParametersFromQuery(PsiElement query, Project project, Editor editor) {
        try { // support parameters for PsiElement only
            ParametersService service = ServiceManager.getService(project, ParametersService.class);
            return service.getParameters(query);
        } catch (Exception exception) {
            sendParametersRetrievalErrorEvent(project.getMessageBus(), exception, editor);
            return Collections.emptyMap();
        }
    }

    private String getQueryExecutionAction(AnActionEvent e) {
        return e.getInputEvent() instanceof KeyEvent ? EXECUTE_WITH_SHORTCUT_ACTION : EXECUTE_WITH_MOUSE_ACTION;
    }


    private void sendParametersRetrievalErrorEvent(MessageBus messageBus, Exception exception, Editor editor) {
        QueryParametersRetrievalErrorEvent event = messageBus
                .syncPublisher(QueryParametersRetrievalErrorEvent.QUERY_PARAMETERS_RETRIEVAL_ERROR_EVENT_TOPIC);
        event.handleError(exception, editor);
    }
}
