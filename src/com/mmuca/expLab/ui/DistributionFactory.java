package com.mmuca.expLab.ui;

import com.mmuca.expLab.domain.distributions.IDistribution;

import javax.swing.*;

public interface DistributionFactory {
    public IDistribution create();
    public JPanel getPanel();
}
