package com.mmuca.expLab.domain.distributions;

public class ForwardMarkovDistribution extends MarkovDistribution{

    public ForwardMarkovDistribution(Parameters parameters) {
        super(parameters);
    }

    protected int directStep(int value) {
        return value+1;
    }

    protected int reverseStep(int value) {
        return value-1;
    }
}
