package com.mmuca.expLab.domain.distributions;

public class BackwardMarkovDistribution extends MarkovDistribution {

    public BackwardMarkovDistribution(Parameters parameters) {
        super(parameters);
    }

    protected int directStep(int value) {
        return value-1;
    }

    protected int reverseStep(int value) {
        return value+1;
    }

}
