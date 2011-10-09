package com.mmuca.market.Stubs;

import com.mmuca.market.distributions.IDistribution;

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
