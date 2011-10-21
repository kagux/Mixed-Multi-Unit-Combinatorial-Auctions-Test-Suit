package com.mmuca.expLab.ui;

import com.mmuca.expLab.ui.panels.CenteredDistrPane;

public class BundleNumCenteredDistributionFactory extends CenteredDistributionFactory{
    public BundleNumCenteredDistributionFactory(CenteredDistrPane panel) {
        super(panel);
    }

    @Override
    protected int center() {
        return super.center()+1;
    }
}
