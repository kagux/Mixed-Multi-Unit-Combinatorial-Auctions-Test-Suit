package com.mmuca.expLab.domain.distributions;

import java.util.Random;

public class UniformDistribution implements IDistribution {
    private ValueRange range;
    private Random randomGenerator;

    public UniformDistribution(ValueRange range) {
        this.range = range;
        this.randomGenerator = new Random();
    }

    @Override
    public int flipCoin() {
        return randomGenerator.nextInt(range.getEnd() - range.getStart()+1) + range.getStart();
    }
}
