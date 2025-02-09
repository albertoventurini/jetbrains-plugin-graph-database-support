/**
 * Copied and adapted from plugin
 * <a href="https://github.com/neueda/jetbrains-plugin-graph-database-support">Graph Database Support</a>
 * by Neueda Technologies, Ltd.
 * Modified by Alberto Venturini, 2022
 */
package com.albertoventurini.graphdbplugin.jetbrains.component.settings;

import com.intellij.ide.util.PropertiesComponent;

import java.util.UUID;

public class SettingsComponentImpl implements SettingsComponent {

    private static final String USE_FILE_SPECIFIC_PARAMS_KEY = "GraphDbSupport.UseFileSpecificParams";
    private static final String USER_ID = "GraphDbSupport.UserId";
    private static final String KNOWN_PLUGIN_VERSION = "GraphDbSupport.KnownPluginVersion";
    private static final String GRAPH_VIEW_INVERT_ZOOM = "GraphDbSupport.GraphViewInvertZoom";

    @Override
    public String getUserId() {
        if (!properties().isValueSet(USER_ID)) {
            properties().setValue(USER_ID, UUID.randomUUID().toString());
        }
        return properties().getValue(USER_ID);
    }

    @Override
    public boolean isGraphViewZoomInverted() {
        return properties().getBoolean(GRAPH_VIEW_INVERT_ZOOM, true);
    }

    @Override
    public void invertGraphViewZoom(boolean state) {
        properties().setValue(GRAPH_VIEW_INVERT_ZOOM, state, true);
    }

    @Override
    public String getKnownPluginVersion() {
        return properties().getValue(KNOWN_PLUGIN_VERSION, "unknown");
    }

    @Override
    public void setKnownPluginVersion(String version) {
        properties().setValue(KNOWN_PLUGIN_VERSION, version);
    }

    private PropertiesComponent properties() {
        return PropertiesComponent.getInstance();
    }
}
