package com.mmuca.expLab;

import com.mmuca.expLab.domain.distributions.ValueRange;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ValueRangeTest {

    @Test
    public void numberOfValuesInRange(){
        assertEquals("should be # of values in range", 5, new ValueRange(1, 5).size());
    }

    @Test
    public void valuePosition(){
        assertEquals("should be serial order of value in range", 0, new ValueRange(1,5).indexOf(1));
        assertEquals("should be serial order of value in range", 2, new ValueRange(1,5).indexOf(3));
        assertEquals("should be serial order of value in range", 4, new ValueRange(1,5).indexOf(5));
    }
}
