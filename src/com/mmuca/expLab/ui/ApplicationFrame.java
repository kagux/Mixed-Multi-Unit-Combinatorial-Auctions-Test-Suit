package com.mmuca.expLab.ui;

import com.mmuca.expLab.domain.Market.MarketDistribution;
import com.mmuca.expLab.domain.Market.graphs.*;
import com.mmuca.expLab.ui.market.design.controllers.DistributionController;
import com.mmuca.expLab.ui.market.design.controllers.GraphController;
import com.mmuca.expLab.ui.market.design.controllers.SettingsController;
import com.mmuca.expLab.ui.market.design.models.MarketModel;
import com.mmuca.expLab.ui.market.design.views.DistributionSelectionPanel;
import com.mmuca.expLab.ui.market.design.views.GraphPanel;
import com.mmuca.expLab.ui.market.design.views.MarketDesignPanel;
import com.mmuca.expLab.ui.market.design.views.SettingsPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ApplicationFrame extends JFrame{
    public static final String MARKET_DESIGN_TAB = "Market Design";
    public static final String WINDOW_TITLE = "Mixed Multi-Unit Combinatorial Auctions Test Suit";
    JTabbedPane tabbedPanel;
    JPanel marketDesignPanel;

    public ApplicationFrame(){
        super(WINDOW_TITLE);
        initComponents();
        layoutComponents();
    }

    private void initComponents() {
        tabbedPanel = new JTabbedPane();
        initMarketDesignPanel();
    }

    private void layoutComponents() {
        setLayout(new MigLayout(
                "",       //Layout Constraints
                "5[]5", //Column Constraints
                "5[]5"  //Rows Constraints
        ));
        getContentPane().add(tabbedPanel, "span, push, grow");
        tabbedPanel.addTab(MARKET_DESIGN_TAB, marketDesignPanel);
    }

    private void initMarketDesignPanel() {
        MarketModel marketModel = new MarketModel();



        MarketGraphVisualizationServerProvider.GraphTransformers graphTransformers= new MarketGraphVisualizationServerProvider.GraphTransformers(
                new MarketVertexShapeTransformer(),
                new MarketVertexColorTransformer(),
                new MarketEdgeColorTransformer()
        );
        MarketGraphVisualizationServerProvider visualizationServerProvider = new MarketGraphVisualizationServerProvider(graphTransformers, new MarketGraphProvider());
        GraphPanel graphPanel = new GraphPanel(marketModel, visualizationServerProvider);

        DistributionSelectionPanel goodLevelDistrPanel = new DistributionSelectionPanel("Goods between levels are", MarketDistribution.GOOD_LEVEL.validDistributions());
        SettingsPanel settingsPanel = new SettingsPanel(marketModel,goodLevelDistrPanel);

        new DistributionController(marketModel.getGoodLevelDistrModel(), goodLevelDistrPanel);
        new SettingsController(marketModel,settingsPanel);
        new GraphController(graphPanel);
        marketDesignPanel=new MarketDesignPanel(settingsPanel, graphPanel);
    }

}
