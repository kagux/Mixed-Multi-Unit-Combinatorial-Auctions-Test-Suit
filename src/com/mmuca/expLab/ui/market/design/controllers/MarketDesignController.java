package com.mmuca.expLab.ui.market.design.controllers;

import com.mmuca.expLab.ui.market.design.models.MarketModel;
import com.mmuca.expLab.ui.market.design.views.MarketDesignPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarketDesignController {
    private MarketModel model;
    private MarketDesignPanel view;

    public MarketDesignController(MarketModel model, MarketDesignPanel view){
        this.model = model;
        this.view = view;
        addListeners();
        initChildControllers();
    }

    private void addListeners() {
        view.getGenerateMarketButton().addActionListener(new ButtonActionListener());
    }

    private void initChildControllers() {
        new SettingsController(model,view.getSettingsPanel());
        new GraphController(view.getGraphPanel());
    }


    private class ButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            model.recreateMarket();
        }
    }


}
