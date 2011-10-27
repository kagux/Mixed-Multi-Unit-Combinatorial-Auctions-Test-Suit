package com.mmuca.expLab.domain.Market;

import com.mmuca.expLab.domain.distributions.*;

public enum MarketDistribution {
    GOOD_LEVEL(new Distribution[]{Distribution.UNIFORM, Distribution.CENTERED, Distribution.CONSTANT}, new UniformDistribution()),
    IOT_LEVEL(new Distribution[]{Distribution.UNIFORM, Distribution.CENTERED, Distribution.CONSTANT}, new UniformDistribution()),
    INPUT_BUNDLES_NUM(new Distribution[]{Distribution.UNIFORM, Distribution.CENTERED, Distribution.CONSTANT}, new ConstantDistribution(1)),
    OUTPUT_BUNDLES_NUM(new Distribution[]{Distribution.UNIFORM, Distribution.CENTERED, Distribution.CONSTANT}, new ConstantDistribution(1)),
    INPUT_BUNDLE_GOOD_LEVEL(new Distribution[]{Distribution.MARKOV_FORWARD},new MarkovForwardDistribution(0.1,0.1)),
    OUTPUT_BUNDLE_GOOD_LEVEL(new Distribution[]{Distribution.MARKOV_BACKWARD},new MarkovBackwardDistribution(0.1,0.1));

    private Distribution[] distributions;
    private IDistribution defaultDistribution;

    private MarketDistribution(Distribution[] distributions, IDistribution defaultDistribution) {
        this.defaultDistribution = defaultDistribution;
        this.distributions = distributions;
    }
    public Distribution[] validDistributions(){
        return distributions;
    }
    public IDistribution defaultDistribution(){
        return defaultDistribution;
    }
}
