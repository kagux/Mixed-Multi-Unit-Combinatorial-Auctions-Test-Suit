package com.mmuca.expLab.ui;

import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.domain.distributions.UniformDistribution;

import javax.swing.*;

public class UniformDistributionFactory  implements DistributionFactory{
    public IDistribution create() {
        return new UniformDistribution();
    }

    @Override
    public JPanel getPanel() {
        return null;
    }
}
