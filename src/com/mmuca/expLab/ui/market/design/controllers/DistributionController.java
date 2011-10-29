package com.mmuca.expLab.ui.market.design.controllers;

import com.mmuca.expLab.domain.distributions.*;
import com.mmuca.expLab.ui.market.design.models.DistributionModel;
import com.mmuca.expLab.ui.market.design.views.CenteredDistributionPanel;
import com.mmuca.expLab.ui.market.design.views.ConstantDistributionPanel;
import com.mmuca.expLab.ui.market.design.views.DistributionSelectionPanel;
import com.mmuca.expLab.ui.market.design.views.MarkovDistributionPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DistributionController {
    private DistributionModel model;
    private DistributionSelectionPanel selectionView;

    public DistributionController(DistributionModel model, DistributionSelectionPanel view){
        this.model = model;
        this.selectionView = view;
        addChildControllers();
    }

    private void addChildControllers() {
        new ConstantDistributionController(model, selectionView.getConstantDistributionPanel());
        new CenteredDistributionController(model, selectionView.getCenteredDistributionPanel());
        new MarkovForwardDistributionController(model, selectionView.getMarkovForwardDistributionPanel());
        new MarkovBackwardDistributionController(model, selectionView.getMarkovBackwardDistributionPanel());
        new UniformDistributionController(model, selectionView.getUniformDistributionPanel());
    }

    public abstract class AbstractDistributionController {
        protected DistributionModel model;
        protected JPanel view;

        public AbstractDistributionController(DistributionModel model, JPanel view) {
            this.model = model;
            this.view = view;
            addDefaultListeners();
            addCustomListeners();
        }

        protected void addDefaultListeners(){
            selectionView.getDistributionsComboBox().addItemListener(new ComboBoxItemListener());
        }

        protected class SpinnerListener implements ChangeListener{
            @Override
            public void stateChanged(ChangeEvent e) {
                if (isViewSelected(selectionView.selectedDistribution()))
                    updateDistribution();
            }
        }

        protected class ComboBoxItemListener implements ItemListener{
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    Distribution selectedItem = selectionView.selectedDistribution();
                    if (isViewSelected(selectedItem)){
                        selectionView.showSettingsFor(selectedItem);
                        updateDistribution();
                    }
                }
            }
        }
        protected boolean isViewSelected(Distribution selectedDistribution){
           return view.getName().equals(selectedDistribution.toString());
        }
        protected abstract void addCustomListeners();
        protected abstract void updateDistribution();
    }

    public class UniformDistributionController extends  AbstractDistributionController{
        public UniformDistributionController(DistributionModel model, JPanel view) {
            super(model, view);
        }

        @Override
        protected void addCustomListeners() { }

        @Override
        public void updateDistribution() {
            model.setDistribution(new UniformDistribution());
        }
    }

    public class ConstantDistributionController extends AbstractDistributionController{

        public ConstantDistributionController(DistributionModel model, ConstantDistributionPanel view){
            super(model, view);
        }

        @Override
        protected void addCustomListeners() {
           ((ConstantDistributionPanel)view).getValueSpinner().addChangeListener(new SpinnerListener());
        }

        @Override
        public void updateDistribution(){
            int value = (Integer)((ConstantDistributionPanel)view).getValueSpinner().getRealValue();
            model.setDistribution(new ConstantDistribution(value));
        }

    }

    public class CenteredDistributionController extends AbstractDistributionController{
        public CenteredDistributionController(DistributionModel model, CenteredDistributionPanel view) {
            super(model, view);
        }

        @Override
        protected void addCustomListeners() {
           ((CenteredDistributionPanel)view).getAlphaSpinner().addChangeListener(new SpinnerListener());
           ((CenteredDistributionPanel)view).getCenterSpinner().addChangeListener(new SpinnerListener());
        }

        @Override
        public void updateDistribution() {
            int center = (Integer)((CenteredDistributionPanel)view).getCenterSpinner().getRealValue();
            double alpha = (Double)((CenteredDistributionPanel)view).getAlphaSpinner().getRealValue();
            model.setDistribution(new CenteredDistribution(center, alpha));
        }
    }

    public abstract class MarkovDistributionController extends AbstractDistributionController{
        public MarkovDistributionController(DistributionModel model, MarkovDistributionPanel view) {
            super(model, view);
        }

        @Override
        protected void addCustomListeners() {
            ((MarkovDistributionPanel)view).getpChangeDirectionSpinner().addChangeListener(new SpinnerListener());
            ((MarkovDistributionPanel)view).getpChangeValueSpinner().addChangeListener(new SpinnerListener());
        }

        protected double pChangeValue(){
            return (Double)((MarkovDistributionPanel)view).getpChangeValueSpinner().getRealValue();
        }

        protected double pChangeDirection(){
            return (Double)((MarkovDistributionPanel)view).getpChangeDirectionSpinner().getRealValue();
        }
    }

    public class MarkovForwardDistributionController extends MarkovDistributionController{
        public MarkovForwardDistributionController(DistributionModel model, MarkovDistributionPanel view) {
            super(model, view);
        }

        @Override
        public void updateDistribution() {
            model.setDistribution(new MarkovForwardDistribution(pChangeValue(),pChangeDirection()));
        }
    }

    public class MarkovBackwardDistributionController extends MarkovDistributionController{
        public MarkovBackwardDistributionController(DistributionModel model, MarkovDistributionPanel view) {
            super(model, view);
        }

        @Override
        public void updateDistribution() {
            model.setDistribution(new MarkovBackwardDistribution(pChangeValue(),pChangeDirection()));
        }
    }
}
