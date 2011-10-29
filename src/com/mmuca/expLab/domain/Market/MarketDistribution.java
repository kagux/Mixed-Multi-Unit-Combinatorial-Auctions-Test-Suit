package com.mmuca.expLab.domain.Market;

import com.mmuca.expLab.domain.distributions.*;

public enum MarketDistribution {
    GOOD_LEVEL(new Distribution[]{Distribution.UNIFORM, Distribution.CENTERED, Distribution.CONSTANT}, new UniformDistribution(),0,0,-2),
    IOT_LEVEL(new Distribution[]{Distribution.UNIFORM, Distribution.CENTERED, Distribution.CONSTANT}, new UniformDistribution(),0,1,-2),
    INPUT_BUNDLES_NUM(new Distribution[]{Distribution.CONSTANT, Distribution.UNIFORM, Distribution.CENTERED}, new ConstantDistribution(1),1,1,0),
    OUTPUT_BUNDLES_NUM(new Distribution[]{Distribution.CONSTANT, Distribution.UNIFORM, Distribution.CENTERED}, new ConstantDistribution(1),1,1,0),
    INPUT_BUNDLE_GOOD_LEVEL(new Distribution[]{Distribution.MARKOV_FORWARD},new MarkovForwardDistribution(0.1,0.1),0,1,-2),
    OUTPUT_BUNDLE_GOOD_LEVEL(new Distribution[]{Distribution.MARKOV_BACKWARD},new MarkovBackwardDistribution(0.1,0.1),0,0,-2);

    private Distribution[] distributions;
    private int rangeOrigin;
    private ValueRange range;
    private int rangeEndOffset;
    private IDistribution defaultDistribution;

    private MarketDistribution(Distribution[] distributions, IDistribution defaultDistribution, int rangeOrigin, int rangeStart, int rangeEndOffset) {
        this.defaultDistribution = defaultDistribution;
        this.distributions = distributions;
        this.rangeOrigin = rangeOrigin;
        this.range =  new ValueRange(rangeStart,rangeStart);
        this.rangeEndOffset = rangeEndOffset;
    }

    public Distribution[] validDistributions(){
        return distributions;
    }
    public IDistribution defaultDistribution(){
        return defaultDistribution;
    }
    public int rangeOrigin(){
        return rangeOrigin;
    }

    public ValueRange valueRange(){
        return range;
    }
    public ValueRange setRangeEnd(int end){
        range.setEnd(end + rangeEndOffset);
        return range;
    }
}
