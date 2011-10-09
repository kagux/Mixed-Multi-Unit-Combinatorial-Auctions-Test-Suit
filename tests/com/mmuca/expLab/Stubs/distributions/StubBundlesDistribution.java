package com.mmuca.expLab.Stubs.distributions;

import com.mmuca.expLab.domain.distributions.IDistribution;

public class StubBundlesDistribution implements IDistribution {
    private int value;

    public void setNumberOfBundles(int value) {
        this.value = value;
    }

    public StubBundlesDistribution(int value){
        this.value = value;
    }

    public StubBundlesDistribution(){}

    @Override
    public int flipCoin() {
        return value;
    }
}
