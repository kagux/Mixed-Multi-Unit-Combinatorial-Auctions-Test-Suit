package com.mmuca.expLab.Stubs.distributions;

import com.mmuca.expLab.domain.distributions.ISeededDistribution;

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
