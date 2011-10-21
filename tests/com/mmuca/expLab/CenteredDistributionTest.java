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
          int distributedValue = distribution.nextInt();
          assertTrue("values should be in specified range", distributedValue >= 0 && distributedValue <= 3);
      }

      distribution = centeredDistribution(4, 6, 5);
      for (int i=0; i<testRuns;i++){
          int distributedValue = distribution.nextInt();
          assertTrue("values should be in specified range", distributedValue >= 4 && distributedValue <= 6);
      }

    }

    @Test
    @Ignore
    public void histogram(){
        IDistribution distribution = centeredDistribution(1, 40, 20);
        HashMap<Integer, Integer> histogram = new HashMap<Integer, Integer>();
        int testRuns = 1000;
        for (int i=0; i<testRuns;i++){
           int value =distribution.nextInt();
           histogram.put(value,histogram.get(value) == null ?1:histogram.get(value)+1);
        }
        histogram.size();
    }

  private IDistribution centeredDistribution(int start, int end, int center) {
      IDistribution distribution = new CenteredDistribution(center, 0.7);
      distribution.setValueRange(new ValueRange(start, end));
      return distribution;
  }
}
