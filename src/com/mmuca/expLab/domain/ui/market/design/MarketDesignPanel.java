package com.mmuca.expLab.domain.ui.market.design;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class MarketDesignPanel extends JPanel{
    public static final String GENERATE_GRAPH_BUTTON = "Generate Graph";
    private SettingsPanel settingsPanel;
    private GraphPanel graphPanel;
    private JButton generateGraphButton;

    public MarketDesignPanel(SettingsPanel settingsPanel, GraphPanel graphPanel){
        this.settingsPanel = settingsPanel;
        this.graphPanel = graphPanel;
        createGUI();
    }

    public JButton getGenerateGraphButton() {
        return generateGraphButton;
    }

    private void createGUI() {
        setLayout(new MigLayout());
        settingsPanel.setBorder(new EtchedBorder());
        graphPanel.setBorder(new EtchedBorder());
        add(createScrollPanel(), "grow, pushy, spany, w 300");
        add(graphPanel, "grow, push, wrap");
        generateGraphButton = new JButton(GENERATE_GRAPH_BUTTON);
        add(generateGraphButton,"skip, grow");
    }

    private JScrollPane createScrollPanel() {
        JScrollPane scrollPanel = new JScrollPane();
        scrollPanel.setBorder(new EtchedBorder());
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setViewportView(settingsPanel);
        return scrollPanel;
    }
}
