package com.mmuca.expLab.ui.market.design.controllers;

import com.mmuca.expLab.ui.components.NumberSpinner;
import com.mmuca.expLab.ui.market.design.models.MarketModel;
import com.mmuca.expLab.ui.market.design.views.SettingsPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingsController {
    private MarketModel model;
    private SettingsPanel view;

    public SettingsController(MarketModel model, SettingsPanel view){
        this.model = model;
        this.view = view;
        initChildControllers();
        addListeners();
    }

    private void initChildControllers() {
        new DistributionController(model.getGoodLevelDistrModel(), view.getGoodLevelDistrPanel());
        new DistributionController(model.getIotLevelDistrModel(), view.getIotLevelDistrPanel());
        new DistributionController(model.getInputBundlesNumDistrModel(), view.getInputBundlesNumDistrPanel());
        new DistributionController(model.getInputBundleGoodLevelDistrModel(), view.getInputBundleGoodLevelDistrPanel());
        new DistributionController(model.getOutputBundlesNumDistrModel(), view.getOutputBundlesNumDistrPanel());
        new DistributionController(model.getOutputBundleGoodLevelDistrModel(), view.getOutputBundleGoodLevelDistrPanel());
    }

    private void addListeners() {
        view.getNumGoodsSpinner().addChangeListener(new SpinnerChangeListener(new UpdateNumGoods()));
        view.getMinGoodsPerLevelSpinner().addChangeListener(new SpinnerChangeListener(new UpdateMinGoodsPerLevel()));
        view.getNumLevelsSpinner().addChangeListener(new SpinnerChangeListener(new UpdateNumLevels()));
        view.getNumIOTSpinner().addChangeListener(new SpinnerChangeListener(new UpdateNumIOT()));
        view.getShowOnlyIOTCheckBox().addChangeListener(new CheckBoxListener(new UpdateShowOnlyIOT()));
    }

    private abstract class ViewChangeListener implements ChangeListener{
        protected UpdateModelCommand command;

        public ViewChangeListener(UpdateModelCommand command){
            this.command = command;
        }
        @Override
        public void stateChanged(ChangeEvent e) {
            if (abortCommandCondition(e)) return;
            command.execute(commandParameter(e));
        }

        protected boolean abortCommandCondition(ChangeEvent e){return false;}
        protected abstract Object commandParameter(ChangeEvent e);
    }

    private class CheckBoxListener extends ViewChangeListener{
        public CheckBoxListener(UpdateModelCommand command) {
            super(command);
        }

        @Override
        protected boolean abortCommandCondition(ChangeEvent e) {
            return model.isShowOnlyIOT() == ((JCheckBox)e.getSource()).isSelected();
        }

        @Override
        protected Object commandParameter(ChangeEvent e) {
            return ((JCheckBox)e.getSource()).isSelected();
        }
    }

    private class SpinnerChangeListener extends ViewChangeListener {

        public SpinnerChangeListener(UpdateModelCommand command) {
            super(command);
        }

        @Override
        protected Object commandParameter(ChangeEvent e) {
            return ((NumberSpinner)e.getSource()).getRealValue();
        }
    }

    private interface UpdateModelCommand{
        public void execute(Object newValue);
    }

    private class UpdateNumGoods implements UpdateModelCommand{
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

    private class UpdateShowOnlyIOT implements UpdateModelCommand{
        @Override
        public void execute(Object newValue) {
            model.setShowOnlyIOT((Boolean)newValue);
        }
    }
}
