package com.mmuca.expLab;

import com.mmuca.expLab.domain.distributions.CenteredDistribution;
import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.domain.distributions.ValueRange;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class CenteredDistributionTest {

    @Test
    public void valuesAreInRange(){
      IDistribution distribution = centeredDistribution(0, 3, 2);
      int testRuns = 20;
      for (int i=0; i<testRuns;i++){
          int distributedValue = distribution.flipCoin();
          assertTrue("values should be in specified range", distributedValue >= 0 && distributedValue <= 3);
      }

      distribution = centeredDistribution(4, 6, 5);
      for (int i=0; i<testRuns;i++){
          int distributedValue = distribution.flipCoin();
          assertTrue("values should be in specified range", distributedValue >= 4 && distributedValue <= 6);
      }

  }
  private IDistribution centeredDistribution(int start, int end, int center) {
      ValueRange range = new ValueRange(start, end);
      CenteredDistribution.Parameters parameters = new CenteredDistribution.Parameters(center, 0.5);
      return new CenteredDistribution(range, parameters);
  }
}
