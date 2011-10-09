package com.mmuca.market.Stubs;

import com.mmuca.market.distributions.IDistribution;

public class StubIOTLevelDistribution implements IDistribution {
    private int value;

    public StubIOTLevelDistribution(){}

    public StubIOTLevelDistribution(int value){
        this.value = value;
    }

    public void setIOTLevel(int value){
        this.value = value;
    }

    public int flipCoin() {
       return value;
    }
}
