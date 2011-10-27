package com.mmuca.expLab.ui.market.design.controllers;

import com.mmuca.expLab.domain.distributions.*;
import com.mmuca.expLab.ui.market.design.models.DistributionModel;
import com.mmuca.expLab.ui.market.design.views.DistributionSelectionPanel;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DistributionController {
    private DistributionModel model;
    private DistributionSelectionPanel view;

    public DistributionController(DistributionModel model, DistributionSelectionPanel view){
        this.model = model;
        this.view = view;
        addListeners();
    }

    private void addListeners() {
        view.getDistributionsComboBox().addItemListener(new ComboBoxItemListener());
        view.getCenteredDistributionPanel().getAlphaSpinner().addChangeListener(new SpinnerChangeListener());
        view.getCenteredDistributionPanel().getCenterSpinner().addChangeListener(new SpinnerChangeListener());
        view.getMarkovForwardDistributionPanel().getpChangeDirectionSpinner().addChangeListener(new SpinnerChangeListener());
        view.getMarkovForwardDistributionPanel().getpChangeValueSpinner().addChangeListener(new SpinnerChangeListener());
        view.getMarkovBackwardDistributionPanel().getpChangeDirectionSpinner().addChangeListener(new SpinnerChangeListener());
        view.getMarkovBackwardDistributionPanel().getpChangeValueSpinner().addChangeListener(new SpinnerChangeListener());
    }

    private void setCenteredDistribution() {
        int center = (Integer)view.getCenteredDistributionPanel().getCenterSpinner().getValue()-1;
        double alpha = (Double)view.getCenteredDistributionPanel().getAlphaSpinner().getValue();
        model.setDistribution(new CenteredDistribution(center, alpha));
    }

    private void setMarkovForwardDistribution(){
        double pChangeValue = (Double)view.getMarkovForwardDistributionPanel().getpChangeValueSpinner().getValue();
        double pChangeDirection = (Double)view.getMarkovForwardDistributionPanel().getpChangeDirectionSpinner().getValue();
        model.setDistribution(new MarkovForwardDistribution(pChangeValue,pChangeDirection));
    }

    private void setMarkovBackwardDistribution(){
        double pChangeValue = (Double)view.getMarkovBackwardDistributionPanel().getpChangeValueSpinner().getValue();
        double pChangeDirection = (Double)view.getMarkovBackwardDistributionPanel().getpChangeDirectionSpinner().getValue();
        model.setDistribution(new MarkovBackwardDistribution(pChangeValue,pChangeDirection));
    }

    private class SpinnerChangeListener implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            if (view.getDistributionsComboBox().getSelectedItem() == Distribution.CENTERED)
                setCenteredDistribution();
            else if (view.getDistributionsComboBox().getSelectedItem() == Distribution.MARKOV_FORWARD){
                setMarkovForwardDistribution();
            }
            else if (view.getDistributionsComboBox().getSelectedItem() == Distribution.MARKOV_BACKWARD){
                setMarkovBackwardDistribution();
            }
        }

    }

    private class ComboBoxItemListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED){

                Distribution selectedItem = (Distribution) view.getDistributionsComboBox().getSelectedItem();
                view.getDistributionSettingsPanel().showCard(selectedItem.toString());
                if (selectedItem == Distribution.UNIFORM){
                    model.setDistribution(new UniformDistribution());
                }
                else if(selectedItem == Distribution.CENTERED){
                    setCenteredDistribution();
                }
                else if (selectedItem == Distribution.MARKOV_FORWARD){
                    setMarkovForwardDistribution();
                }
                else if (selectedItem == Distribution.MARKOV_BACKWARD){
                    setMarkovBackwardDistribution();
                }
            }
        }
    }
}
