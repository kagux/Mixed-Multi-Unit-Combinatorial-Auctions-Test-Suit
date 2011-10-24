package com.mmuca.expLab.domain.ui.market.design.views;

import com.jgoodies.forms.factories.Borders;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

public class MarketDesignPanel extends JPanel{
    public static final String GENERATE_GRAPH_BUTTON = "Generate Graph";
    public static final String SETTINGS_PANEL_CAPTION = "Market Settings";
    public static final String GRAPH_PANEL_CAPTION = "Market Graph";
    private SettingsPanel settingsPanel;
    private GraphPanel graphPanel;

    public MarketDesignPanel(SettingsPanel settingsPanel, GraphPanel graphPanel){
        this.settingsPanel = settingsPanel;
        this.graphPanel = graphPanel;
        layoutComponents();
    }

    private void layoutComponents() {
        setLayout(new MigLayout());
        settingsPanel.setBorder(
                new CompoundBorder(
                        new TitledBorder(SETTINGS_PANEL_CAPTION),
                        Borders.DLU2_BORDER
                )
        );
        graphPanel.setBorder(
                new CompoundBorder(
                        new TitledBorder(GRAPH_PANEL_CAPTION),
                        Borders.DLU2_BORDER
                )
        );
        add(createScrollPanel(), "grow, pushy, spany, w 300!");
        add(graphPanel, "push, grow");
    }

    private JScrollPane createScrollPanel() {
        JScrollPane scrollPanel = new JScrollPane();
        scrollPanel.setBorder(null);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setViewportView(settingsPanel);
        return scrollPanel;
    }
}
