package com.mmuca.market.Stubs;

import com.mmuca.market.distributions.ISeededDistribution;

public class StubIOTGoodsLevelDistribution implements ISeededDistribution {
    private int seed;

    @Override
    public void setSeed(int seed) {
        this.seed = seed;
    }

    @Override
    public int flipCoin() {
        return seed;
    }
}
