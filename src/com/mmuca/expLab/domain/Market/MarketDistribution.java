package com.mmuca.expLab.domain.Market;

import com.mmuca.expLab.domain.distributions.Distribution;
import com.mmuca.expLab.domain.distributions.MarkovBackwardDistribution;
import com.mmuca.expLab.domain.distributions.MarkovForwardDistribution;
import com.mmuca.expLab.domain.distributions.UniformDistribution;

public enum MarketDistribution {
    GOOD_LEVEL(new Distribution[]{Distribution.UNIFORM, Distribution.CENTERED}, new UniformDistribution()),
    IOT_LEVEL(new Distribution[]{Distribution.UNIFORM, Distribution.CENTERED}, new UniformDistribution()),
    INPUT_BUNDLES_NUM(new Distribution[]{Distribution.UNIFORM, Distribution.CENTERED}, new UniformDistribution()),
    OUTPUT_BUNDLES_NUM(new Distribution[]{Distribution.UNIFORM, Distribution.CENTERED}, new UniformDistribution()),
    INPUT_BUNDLE_GOOD_LEVEL(new Distribution[]{Distribution.MARKOV_FORWARD},new MarkovForwardDistribution(0.1,0.1)),
    OUTPUT_BUNDLE_GOOD_LEVEL(new Distribution[]{Distribution.MARKOV_BACKWARD},new MarkovBackwardDistribution(0.1,0.1));

    private Distribution[] distributions;
    private Object defaultDistribution;

    private MarketDistribution(Distribution[] distributions, Object defaultDistribution) {
        this.defaultDistribution = defaultDistribution;
        this.distributions = distributions;
    }
    public Distribution[] validDistributions(){
        return distributions;
    }
    public Object defaultDistribution(){
        return defaultDistribution;
    }
}
