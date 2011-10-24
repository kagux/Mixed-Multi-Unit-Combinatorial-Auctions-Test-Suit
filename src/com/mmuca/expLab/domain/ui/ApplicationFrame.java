package com.mmuca.expLab.domain.ui;

import com.mmuca.expLab.domain.ui.market.design.views.GraphPanel;
import com.mmuca.expLab.domain.ui.market.design.views.MarketDesignPanel;
import com.mmuca.expLab.domain.ui.market.design.views.SettingsPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ApplicationFrame extends JFrame{
    public static final String MARKET_DESIGN_TAB = "Market Design";
    public static final String WINDOW_TITLE = "Mixed Multi-Unit Combinatorial Auctions Test Suit";
    JTabbedPane tabbedPanel;

    public ApplicationFrame(){
        super(WINDOW_TITLE);
        initComponents();
        createGUI();
    }

    private void initComponents() {
        tabbedPanel = new JTabbedPane();
    }

    private void createGUI() {
        setLayout(new MigLayout(
                "",       //Layout Constraints
                "5[]5", //Column Constraints
                "5[]5"  //Rows Constraints
        ));
        getContentPane().add(tabbedPanel, "span, push, grow");
        tabbedPanel.addTab(MARKET_DESIGN_TAB, createMarketDesignGUI());
    }

    private MarketDesignPanel createMarketDesignGUI() {
        MarketDesignPanel marketDesignPanel = new MarketDesignPanel(new SettingsPanel(), new GraphPanel());
        return marketDesignPanel;
    }
}
