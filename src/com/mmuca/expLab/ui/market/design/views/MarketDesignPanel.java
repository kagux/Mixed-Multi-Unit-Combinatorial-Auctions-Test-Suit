package com.mmuca.expLab.ui.market.design.views;

import com.jgoodies.forms.factories.Borders;
import com.mmuca.expLab.domain.Market.graphs.*;
import com.mmuca.expLab.ui.market.design.models.MarketModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

public class MarketDesignPanel extends JPanel{
    public static final String GENERATE_MARKET_BUTTON = "Generate Graph";
    public static final String SETTINGS_PANEL_CAPTION = "Market Settings";
    public static final String GRAPH_PANEL_CAPTION = "Market Graph";
    private SettingsPanel settingsPanel;
    private GraphPanel graphPanel;
    private MarketModel model;
    private JButton generateMarketButton;

    public MarketDesignPanel(MarketModel model){
        this.model = model;
        initComponents();
        layoutComponents();
    }

    public JButton getGenerateMarketButton() {
        return generateMarketButton;
    }

    public SettingsPanel getSettingsPanel() {
        return settingsPanel;
    }

    public GraphPanel getGraphPanel() {
        return graphPanel;
    }

    private void initComponents() {
        generateMarketButton = new JButton(GENERATE_MARKET_BUTTON);
        initGraphPanel();
        settingsPanel = new SettingsPanel(model);
    }

    private void initGraphPanel() {
        MarketGraphVisualizationServerProvider.GraphTransformers graphTransformers= new MarketGraphVisualizationServerProvider.GraphTransformers(
                new MarketVertexShapeTransformer(),
                new MarketVertexColorTransformer(),
                new MarketEdgeColorTransformer()
        );
        MarketGraphVisualizationServerProvider visualizationServerProvider = new MarketGraphVisualizationServerProvider(graphTransformers, new MarketGraphProvider());
        graphPanel = new GraphPanel(model, visualizationServerProvider);
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
        add(graphPanel, "push, grow, wrap");
        add(generateMarketButton,"skip,grow");
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
