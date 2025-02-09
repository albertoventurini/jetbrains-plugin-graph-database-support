/**
 * Copied and adapted from plugin
 * <a href="https://github.com/neueda/jetbrains-plugin-graph-database-support">Graph Database Support</a>
 * by Neueda Technologies, Ltd.
 * Modified by Alberto Venturini, 2022
 */
package com.albertoventurini.graphdbplugin.jetbrains.ui.datasource.interactions;

import com.albertoventurini.graphdbplugin.jetbrains.ui.datasource.interactions.neo4j.bolt.Neo4jBoltDataSourceDialog;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.albertoventurini.graphdbplugin.jetbrains.ui.datasource.DataSourcesView;
import icons.GraphIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NewDataSourceActionGroup extends ActionGroup {

    NewDataSourceAction neo4jBoltDataSource;

    public NewDataSourceActionGroup(Project project, DataSourcesView dataSourcesView) {
        neo4jBoltDataSource = new NewDataSourceAction(
                dataSourcesView, new Neo4jBoltDataSourceDialog(project, dataSourcesView),
                "Neo4j - Bolt", "Create Neo4j 3.0+ Bolt data source", GraphIcons.Database.NEO4J);
    }

    @Override
    public AnAction @NotNull [] getChildren(@Nullable AnActionEvent e) {
        return new AnAction[]{neo4jBoltDataSource};
    }
}
