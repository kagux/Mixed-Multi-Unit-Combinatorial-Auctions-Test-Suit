package com.mmuca.expLab;

import com.mmuca.expLab.domain.distributions.UniformDistribution;
import com.mmuca.expLab.ui.UniformDistributionFactory;import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class UniformDistributionFactoryTest {
    @Test
    public void uniformDistribution(){
        assertTrue("uniform distribution", new UniformDistributionFactory().create() instanceof UniformDistribution);
    }
}
