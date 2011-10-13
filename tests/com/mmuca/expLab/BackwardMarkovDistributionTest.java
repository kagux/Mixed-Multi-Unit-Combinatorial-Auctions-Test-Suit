package com.mmuca.expLab;

import com.mmuca.expLab.domain.distributions.BackwardMarkovDistribution;
import com.mmuca.expLab.domain.distributions.ITargetedDistribution;
import com.mmuca.expLab.domain.distributions.MarkovDistribution;
import com.mmuca.expLab.domain.distributions.ValueRange;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class BackwardMarkovDistributionTest {

    @Test
    public void valuesAreInRange(){
      ITargetedDistribution distribution = backwardMarkovDistribution(0, 3);
      int testRuns = 20;
      distribution.setTarget(1);
      for (int i=0; i<testRuns;i++){
          int distributedValue = distribution.flipCoin();
          assertTrue("values should be in specified range", distributedValue >= 0 && distributedValue <= 3);
      }

      distribution = backwardMarkovDistribution(4, 6);
      distribution.setTarget(6);
      for (int i=0; i<testRuns;i++){
          int distributedValue = distribution.flipCoin();
          assertTrue("values should be in specified range", distributedValue >= 4 && distributedValue <= 6);
      }

  }
  private ITargetedDistribution backwardMarkovDistribution(int start, int end) {
      ValueRange range = new ValueRange(start, end);
      MarkovDistribution.Parameters parameters = new MarkovDistribution.Parameters(0.3, 0.2);
      return new BackwardMarkovDistribution(range, parameters);
  }
}
