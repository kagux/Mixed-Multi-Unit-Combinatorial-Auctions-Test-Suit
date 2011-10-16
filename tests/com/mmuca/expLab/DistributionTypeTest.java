package com.mmuca.expLab;

import com.mmuca.expLab.domain.distributions.DistributionType;
import com.mmuca.expLab.domain.distributions.Distributions;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DistributionTypeTest {
    @Test
    @Ignore
    public void test(){
        DistributionType distribution = DistributionType.uniform();
        assertEquals("should be same distribution", Distributions.UNIFORM, distribution.getDistribution());
    }
}
