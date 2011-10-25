package com.mmuca.expLab.domain.Market;

import com.mmuca.expLab.domain.distributions.Distribution;
import com.mmuca.expLab.domain.distributions.UniformDistribution;

import java.util.ArrayList;
import java.util.Arrays;

public enum MarketDistribution {
    GOOD_LEVEL(new Distribution[]{Distribution.UNIFORM, Distribution.CENTERED}, new UniformDistribution());
    private ArrayList<Distribution> distributionsList;
    private Object defaultDistribution;

    private MarketDistribution(Distribution[] distributions, Object defaultDistribution) {
        this.defaultDistribution = defaultDistribution;
        this.distributionsList = new ArrayList<Distribution>(Arrays.asList(distributions));
    }
    public ArrayList<Distribution> validDistributions(){
        return distributionsList;
    }
    public Object defaultDistribution(){
        return defaultDistribution;
    }
}
