package com.mmuca.expLab.ui;

import com.mmuca.expLab.ui.panels.DistributionPane;

public class BundlesNumDistributionAbstractFactory extends DistributionAbstractFactory{
    @Override
    protected CenteredDistributionFactory centeredDistributionFactory(DistributionPane panel) {
        return new BundleNumCenteredDistributionFactory(panel.getCenteredDistrPane());
    }
}
