/**
 * Copied and adapted from plugin
 * <a href="https://github.com/neueda/jetbrains-plugin-graph-database-support">Graph Database Support</a>
 * by Neueda Technologies, Ltd.
 * Modified by Alberto Venturini, 2022
 */
package com.albertoventurini.graphdbplugin.jetbrains.ui.console.status;

import com.albertoventurini.graphdbplugin.jetbrains.actions.execute.ExecuteQueryPayload;
import com.albertoventurini.graphdbplugin.jetbrains.component.datasource.state.DataSourceApi;
import com.intellij.openapi.wm.CustomStatusBarWidget;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.util.messages.MessageBus;
import com.intellij.util.ui.AsyncProcessIcon;
import com.albertoventurini.graphdbplugin.database.api.query.GraphQueryResult;
import com.albertoventurini.graphdbplugin.jetbrains.ui.console.event.QueryExecutionProcessEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class ExecutionStatusBarWidget extends JPanel implements CustomStatusBarWidget {

    public ExecutionStatusBarWidget(MessageBus messageBus) {
        setOpaque(false);
        setLayout(new BorderLayout());

        AsyncProcessIcon graphDatabaseExecution = new AsyncProcessIcon("GraphDatabaseExecution");
        ExecutionTextPanel executionTextPanel = new ExecutionTextPanel();
        executionTextPanel.setText("Executing graph query...");
        add(graphDatabaseExecution, BorderLayout.WEST);
        add(executionTextPanel, BorderLayout.CENTER);
        setVisible(false);

        messageBus.connect().subscribe(QueryExecutionProcessEvent.QUERY_EXECUTION_PROCESS_TOPIC, new QueryExecutionProcessEvent() {
            @Override
            public void executionStarted(DataSourceApi dataSource, ExecuteQueryPayload payload) {
                setVisible(true);
            }

            @Override
            public void resultReceived(ExecuteQueryPayload payload, GraphQueryResult result) {
                setVisible(false);
            }

            @Override
            public void postResultReceived(ExecuteQueryPayload payload) {
            }

            @Override
            public void handleError(ExecuteQueryPayload payload, Exception exception) {
                setVisible(false);
            }

            @Override
            public void executionCompleted(ExecuteQueryPayload payload) {
            }
        });
    }

    @NotNull
    @Override
    public String ID() {
        return "GraphDatabaseSupport.ExecutionStatusBarWidget";
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    @Nullable
    @Override
    public WidgetPresentation getPresentation(@NotNull PlatformType type) {
        return null;
    }

    @Override
    public void install(@NotNull StatusBar statusBar) {
    }

    @Override
    public void dispose() {
    }
}
