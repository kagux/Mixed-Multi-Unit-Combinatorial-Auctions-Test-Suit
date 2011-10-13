package com.mmuca.expLab;

import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.domain.distributions.UniformDistribution;
import com.mmuca.expLab.domain.distributions.ValueRange;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class UniformDistributionTest {
    @Test
      public void valuesAreInRange(){
        IDistribution distribution = uniformDistribution(0,3);
        int testRuns = 20;
        for (int i=0; i<testRuns;i++){
            int distributedValue = distribution.flipCoin();
            assertTrue("values should be in specified range", distributedValue >= 0 && distributedValue <= 3);
        }

        distribution = uniformDistribution(4,6);
        for (int i=0; i<testRuns;i++){
            int distributedValue = distribution.flipCoin();
            assertTrue("values should be in specified range", distributedValue >= 4 && distributedValue <= 6);
        }

    }
    private IDistribution uniformDistribution(int start, int end) {
        ValueRange range = new ValueRange(start, end);
        return new UniformDistribution(range);
    }

}
