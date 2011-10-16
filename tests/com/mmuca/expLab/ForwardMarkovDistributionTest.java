package com.mmuca.expLab;

import com.mmuca.expLab.domain.distributions.ForwardMarkovDistribution;
import com.mmuca.expLab.domain.distributions.ITargetedDistribution;
import com.mmuca.expLab.domain.distributions.ValueRange;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.Assert.assertTrue;

public class ForwardMarkovDistributionTest {

    @Test
    public void valuesAreInRange(){
      ITargetedDistribution distribution = forwardMarkovDistribution(0, 3);
      int testRuns = 20;
      distribution.setTarget(1);
      for (int i=0; i<testRuns;i++){
          int distributedValue = distribution.nextInt();
          assertTrue("values should be in specified range", distributedValue >= 0 && distributedValue <= 3);
      }

      distribution = forwardMarkovDistribution(4, 6);
      distribution.setTarget(6);
      for (int i=0; i<testRuns;i++){
          int distributedValue = distribution.nextInt();
          assertTrue("values should be in specified range", distributedValue >= 4 && distributedValue <= 6);
      }

  }

    @Test
    @Ignore
    public void histogram(){
        ITargetedDistribution distribution = forwardMarkovDistribution(1, 40);
        distribution.setTarget(20);
        HashMap<Integer, Integer> histogram = new HashMap<Integer, Integer>();
        int testRuns = 1000;
        for (int i=0; i<testRuns;i++){
           int value =distribution.nextInt();
           histogram.put(value,histogram.get(value) == null ?1:histogram.get(value)+1);
        }
        histogram.size();
    }


  private ITargetedDistribution forwardMarkovDistribution(int start, int end) {
      ITargetedDistribution distribution =  new ForwardMarkovDistribution(0.2, 0.1);
      distribution.setValueRange(new ValueRange(start, end));
      return distribution;
  }
}
