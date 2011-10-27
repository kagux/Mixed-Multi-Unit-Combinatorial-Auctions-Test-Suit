package com.mmuca.expLab.ui;

import com.mmuca.expLab.ui.market.design.controllers.MarketDesignController;
import com.mmuca.expLab.ui.market.design.models.MarketModel;
import com.mmuca.expLab.ui.market.design.views.MarketDesignPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ApplicationFrame extends JFrame{
    public static final String MARKET_DESIGN_TAB = "Market Design";
    public static final String WINDOW_TITLE = "Mixed Multi-Unit Combinatorial Auctions Test Suit";
    JTabbedPane tabbedPanel;
    MarketDesignPanel marketDesignPanel;
    private MarketModel marketModel;

    public ApplicationFrame(){
        super(WINDOW_TITLE);
        initComponents();
        layoutComponents();
    }

    private void initComponents() {
        initModels();
        initViews();
        initControllers();
    }

    private void initControllers() {
        new MarketDesignController(marketModel, marketDesignPanel);
    }

    private void initModels() {
        marketModel = new MarketModel();
    }

    private void initViews() {
        tabbedPanel = new JTabbedPane();
        marketDesignPanel=new MarketDesignPanel(marketModel);
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

}
