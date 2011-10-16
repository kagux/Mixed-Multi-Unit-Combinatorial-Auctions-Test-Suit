package com.mmuca.expLab;

import com.mmuca.expLab.domain.distributions.ValueRange;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

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

    @Test
    public void valueObject(){
        ValueRange range1a = new ValueRange(0,2);
        ValueRange range1b = new ValueRange(0,2);
        ValueRange range2 = new ValueRange(0,3);
        assertTrue("ranges with same end and start should be equal", range1a.equals(range1b));
        assertTrue("equal ranges should have equal hash codes", range1a.hashCode() == range1b.hashCode());
        assertFalse("ranges with different end or start should not be equal", range1a.equals(range2));
    }

}
