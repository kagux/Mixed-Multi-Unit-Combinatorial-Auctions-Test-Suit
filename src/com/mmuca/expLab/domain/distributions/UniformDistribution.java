package com.mmuca.expLab.domain.distributions;

import com.mmuca.expLab.domain.Require;

import java.util.Random;

public class UniformDistribution implements IDistribution {
    private ValueRange range;
    private Random randomGenerator;

    public UniformDistribution() {
        this.randomGenerator = new Random();
    }

    @Override
    public int nextInt() {
        Require.that(range != null, "Value range has to be set before generating next value");
        return randomGenerator.nextInt(range.getEnd() - range.getStart()+1) + range.getStart();
    }

    public void setValueRange(ValueRange range){
        this.range = range;
    }

    @Override
    public void setTarget(int index) {}
}
