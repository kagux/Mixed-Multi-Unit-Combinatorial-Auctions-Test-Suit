package com.mmuca.expLab.ui;

import com.mmuca.expLab.ui.panels.DistributionPane;

public class DistributionAbstractFactory {
    public DistributionFactory getFactory(String distributionName, DistributionPane panel) {
        if (isUniform(distributionName))    return uniformDistributionFactory();
        else if (isCentered(distributionName))   return centeredDistributionFactory(panel);
        else    throw new IllegalArgumentException("Invalid distribution name");
    }

    private boolean isCentered(String distributionName) {
        return distributionName.toLowerCase().equals("centered");
    }

    private boolean isUniform(String distributionName) {
        return distributionName.toLowerCase().equals("uniform");
    }

    protected UniformDistributionFactory uniformDistributionFactory() {
        return new UniformDistributionFactory();
    }

    protected CenteredDistributionFactory centeredDistributionFactory(DistributionPane panel) {
        return new CenteredDistributionFactory(panel.getCenteredDistrPane());
    }
}
