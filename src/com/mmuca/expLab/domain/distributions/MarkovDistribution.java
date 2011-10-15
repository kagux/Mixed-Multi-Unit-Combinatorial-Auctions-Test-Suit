package com.mmuca.expLab.domain.distributions;

import java.util.Random;

abstract public class MarkovDistribution implements ITargetedDistribution {
    protected Parameters parameters;
    protected int initialValue;
    protected Random randomGenerator;

    public MarkovDistribution(Parameters parameters) {
        this.randomGenerator = new Random();
        this.parameters = parameters;
        this.initialValue =parameters.range.getStart();
    }

    public void setTarget(int initialValue) {
       this.initialValue =initialValue;
    }

    public int nextInt() {
        int currentValue = this.initialValue;
        while (changeValue()){
            currentValue= nextValueTo(currentValue);
        }
        return currentValue;
    }

    private boolean changeValue() {
        return randomGenerator.nextDouble() < parameters.probabilityOfChangingValue;
    }

    protected int nextValueTo(int value) {
        if (value == parameters.range.getStart())  return value+1;
        if (value == parameters.range.getEnd())    return value-1;
        return switchDirection() ? reverseStep(value): directStep(value);
    }

    protected boolean switchDirection() {
        return (randomGenerator.nextDouble() < parameters.probabilityOfSwitchingDirection);
    }

    protected abstract int directStep(int value);
    protected abstract int reverseStep(int value);

    public static class Parameters{
        private ValueRange range;
        private double probabilityOfChangingValue;
        private double probabilityOfSwitchingDirection;

        public Parameters(ValueRange range, double probabilityOfChangingValue, double probabilityOfSwitchingDirection) {
            this.range = range;
            this.probabilityOfSwitchingDirection = probabilityOfSwitchingDirection;
            this.probabilityOfChangingValue = probabilityOfChangingValue;
        }

        public double getProbabilityOfSwitchingDirection() {
            return probabilityOfSwitchingDirection;
        }

        public double getProbabilityOfChangingValue() {
            return probabilityOfChangingValue;
        }

        public ValueRange getRange() {
            return range;
        }
    }
}
