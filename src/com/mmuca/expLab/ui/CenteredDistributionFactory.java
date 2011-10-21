package com.mmuca.expLab.ui;

import com.mmuca.expLab.domain.distributions.CenteredDistribution;
import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.ui.panels.CenteredDistrPane;

import javax.swing.*;

public class CenteredDistributionFactory  implements DistributionFactory{
    private CenteredDistrPane panel;

    public CenteredDistributionFactory(CenteredDistrPane panel) {
        this.panel = panel;
    }

    public IDistribution create() {
        return new CenteredDistribution(center(), alpha());
    }

    @Override
    public JPanel getPanel() {
        return (JPanel)panel;
    }

    protected double alpha() {
        return Double.parseDouble(panel.getAlphaTextField().getText());
    }

    protected int center() {
        return Integer.parseInt(panel.getCenterTextField().getText()) - 1;
    }
}
