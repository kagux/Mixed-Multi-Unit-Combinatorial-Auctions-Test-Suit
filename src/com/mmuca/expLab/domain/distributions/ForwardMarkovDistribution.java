package com.mmuca.expLab.domain.distributions;

public class ForwardMarkovDistribution extends MarkovDistribution{

    public ForwardMarkovDistribution(ValueRange range, Parameters parameters) {
        super(range, parameters);
    }

    protected int directStep(int value) {
        return value+1;
    }

    protected int reverseStep(int value) {
        return value-1;
    }
}
