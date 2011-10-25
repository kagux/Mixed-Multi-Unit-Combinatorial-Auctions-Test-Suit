package com.mmuca.expLab.ui.market.design.controllers;

import com.mmuca.expLab.domain.distributions.CenteredDistribution;
import com.mmuca.expLab.domain.distributions.Distribution;
import com.mmuca.expLab.domain.distributions.UniformDistribution;
import com.mmuca.expLab.ui.market.design.models.DistributionModel;
import com.mmuca.expLab.ui.market.design.views.DistributionSelectionPanel;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
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
        view.getCenteredDistributionPanel().getAlphaSpinner().addChangeListener(new CenteredDistrChangeListener());
        view.getCenteredDistributionPanel().getCenterSpinner().addChangeListener(new CenteredDistrChangeListener());
    }

    private void updateCenteredDistribution() {
        int center = (Integer)view.getCenteredDistributionPanel().getCenterSpinner().getValue()-1;
        double alpha = (Double)view.getCenteredDistributionPanel().getAlphaSpinner().getValue();
        model.setDistribution(new CenteredDistribution(center,alpha));
    }

    private class CenteredDistrChangeListener implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            updateCenteredDistribution();
        }

    }

    private class ComboBoxItemListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED){
                CardLayout layout = (CardLayout)view.getDistributionSettingsPanel().getLayout();
                Distribution selectedItem = (Distribution) view.getDistributionsComboBox().getSelectedItem();
                layout.show(view.getDistributionSettingsPanel(), selectedItem.toString());
                if (selectedItem == Distribution.UNIFORM){
                    model.setDistribution(new UniformDistribution());
                }
                else if(selectedItem == Distribution.CENTERED){
                    updateCenteredDistribution();
                }
            }
        }
    }
}
