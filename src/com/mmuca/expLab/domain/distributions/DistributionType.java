package com.mmuca.expLab.domain.distributions;

public class DistributionType {
    private Distributions distribution;

    public DistributionType(Distributions distribution) {
        this.distribution = distribution;
    }

    public Distributions getDistribution() {
        return distribution;
    }

    public static DistributionType uniform() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
