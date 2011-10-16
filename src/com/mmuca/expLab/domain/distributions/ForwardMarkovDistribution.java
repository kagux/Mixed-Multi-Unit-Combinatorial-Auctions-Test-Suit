package com.mmuca.expLab.domain.distributions;

public class ForwardMarkovDistribution extends MarkovDistribution{

    public ForwardMarkovDistribution(double probabilityOfChangingValue, double probabilityOfSwitchingDirection) {
        super(probabilityOfChangingValue, probabilityOfSwitchingDirection);
    }

    protected int directStep(int value) {
        return value+1;
    }

    protected int reverseStep(int value) {
        return value-1;
    }
}
