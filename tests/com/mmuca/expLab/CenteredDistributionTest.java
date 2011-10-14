package com.mmuca.expLab;

import com.mmuca.expLab.domain.distributions.CenteredDistribution;
import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.domain.distributions.ValueRange;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;

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

    @Test
    @Ignore
    public void histogram(){
        IDistribution distribution = centeredDistribution(1, 40, 2);
        HashMap<Integer, Integer> histogram = new HashMap<Integer, Integer>();
        int testRuns = 1000;
        for (int i=0; i<testRuns;i++){
           int value =distribution.flipCoin();
           histogram.put(value,histogram.get(value) == null ?1:histogram.get(value)+1);
        }
        histogram.size();
    }

  private IDistribution centeredDistribution(int start, int end, int center) {
      ValueRange range = new ValueRange(start, end);
      CenteredDistribution.Parameters parameters = new CenteredDistribution.Parameters(center, 0.8);
      return new CenteredDistribution(range, parameters);
  }
}
