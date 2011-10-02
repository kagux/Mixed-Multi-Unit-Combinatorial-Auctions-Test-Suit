package com.mmuca.market;


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
        Good car1 = new Good("car");
        Good car2 = new Good("car");
        Good rocket = new Good("rocket");
        
        assertTrue("same goods should be equal", car1.equals(car2));
        assertFalse("different goods should not be equal", car1.equals(rocket));
    }
    
}
