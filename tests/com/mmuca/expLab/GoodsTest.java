package com.mmuca.expLab;


import com.mmuca.expLab.domain.Market.goods.Good;
import org.junit.*;

import static org.junit.Assert.*;

public class GoodsTest{
    
    @Test
    public void NewGood(){
        Good good = new Good("car");
        assertEquals("Good's name is set", "car",good.getName());
    }
    
    @Test
    public void IsValueObject(){
        Good good1a = new Good("car");
        Good good1b = new Good("car");
        Good good2 = new Good("rocket");
        
        assertTrue("same goods should be equal", good1a.equals(good1b));
        assertFalse("different goods should not be equal", good1a.equals(good2));
        assertTrue("same goods should have equal hashCodes", good1a.hashCode() == good1b.hashCode());
    }
    
}
