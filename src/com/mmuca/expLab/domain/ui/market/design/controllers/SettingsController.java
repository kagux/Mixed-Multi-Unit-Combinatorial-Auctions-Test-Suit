package com.mmuca.expLab.domain.ui.market.design.controllers;

import com.mmuca.expLab.domain.ui.market.design.models.MarketModel;
import com.mmuca.expLab.domain.ui.market.design.views.SettingsPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingsController {
    private MarketModel model;
    private SettingsPanel view;

    public SettingsController(MarketModel model, SettingsPanel view){
        this.model = model;
        this.view = view;
        addListeners();
    }

    private void addListeners() {
        view.getNumGoodsSpinner().addChangeListener(new SpinnerChangeListener(new UpdateNumGoodsCommand()));
    }

    private class SpinnerChangeListener implements ChangeListener {
        private UpdateModelCommand command;

        public SpinnerChangeListener(UpdateModelCommand command){
            this.command = command;
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            command.execute(((JSpinner)e.getSource()).getValue());
        }
    }

    private interface UpdateModelCommand{
        public void execute(Object newValue);
    }

    private class UpdateNumGoodsCommand implements UpdateModelCommand{
        @Override
        public void execute(Object newValue) {
            model.setNumGoods((Integer)newValue);
        }
    }
     private class UpdateMinGoodsPerLevel implements UpdateModelCommand {
        @Override
        public void execute(Object newValue) {
            model.setMinGoodsPerLevel((Integer) newValue);
        }
    }

    private class UpdateNumLevels implements UpdateModelCommand{
        @Override
        public void execute(Object newValue) {
            model.setNumLevels((Integer) newValue);
        }
    }

    private class UpdateNumIOT implements UpdateModelCommand{
        @Override
        public void execute(Object newValue) {
            model.setNumIOT((Integer) newValue);

        }
    }
}
