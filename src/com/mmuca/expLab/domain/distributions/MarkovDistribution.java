package com.mmuca.expLab.domain.distributions;

import com.mmuca.expLab.domain.Require;

import java.util.Random;

abstract public class MarkovDistribution implements ITargetedDistribution {
    protected int initialValue;
    protected Random randomGenerator;
    private ValueRange range;
    private double probabilityOfChangingValue;
    private double probabilityOfSwitchingDirection;

    public MarkovDistribution(double probabilityOfChangingValue, double probabilityOfSwitchingDirection) {
        this.probabilityOfChangingValue = probabilityOfChangingValue;
        this.probabilityOfSwitchingDirection = probabilityOfSwitchingDirection;
        this.randomGenerator = new Random();
    }

    public void setTarget(int initialValue) {
       this.initialValue =initialValue;
    }

    public void setValueRange(ValueRange range) {
        this.range = range;
    }

    public int nextInt() {
        int currentValue = this.initialValue;
        while (changeValue()){
            currentValue= nextValueTo(currentValue);
        }
        return currentValue;
    }

    private boolean changeValue() {
        return randomGenerator.nextDouble() < probabilityOfChangingValue;
    }

    protected int nextValueTo(int value) {
        Require.that(range != null, "Value range has to be set before generating next value");
        if (value == range.getStart())  return value+1;
        if (value == range.getEnd())    return value-1;
        return switchDirection() ? reverseStep(value): directStep(value);
    }

    protected boolean switchDirection() {
        return (randomGenerator.nextDouble() < probabilityOfSwitchingDirection);
    }

    protected abstract int directStep(int value);
    protected abstract int reverseStep(int value);
}
