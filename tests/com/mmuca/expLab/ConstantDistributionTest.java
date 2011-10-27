package com.mmuca.expLab;

import com.mmuca.expLab.domain.distributions.ConstantDistribution;
import com.mmuca.expLab.domain.distributions.IDistribution;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class ConstantDistributionTest {
    @Test
    public void shouldAlwaysReturnSameValue(){
        int value = 5;
        IDistribution distribution = new ConstantDistribution(value);
        assertTrue(distribution.nextInt() == value);
        assertTrue(distribution.nextInt() == value);
        assertTrue(distribution.nextInt() == value);
    }
}
