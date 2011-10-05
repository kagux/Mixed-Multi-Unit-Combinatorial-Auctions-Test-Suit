package com.mmuca.market;

import org.junit.Test;

import static junit.framework.Assert.*;

public class GoodBundleTest {

    @Test
    public void GoodBundle(){
        Good car = new Good("car");
        GoodBundle bundle = new GoodBundle(car, 1);
        assertEquals(car, bundle.getGood());
        assertEquals(1, bundle.getAmount());
    }
    
    @Test
    public void ValueObject(){
        Good car = new Good("car");
        Good rocket = new Good("rocket");
        GoodBundle bundle1a=new GoodBundle(car, 1);
        GoodBundle bundle1b=new GoodBundle(car, 1);
        GoodBundle bundle2a = new GoodBundle(rocket, 1);
        GoodBundle bundle2b=new GoodBundle(car,2);
        
        assertTrue("same bundles should be equal", bundle1a.equals(bundle1b));
        assertFalse("bundles with diff amount are not equal", bundle1a.equals(bundle2b));
        assertFalse("bundles with diff goods are not equal", bundle1a.equals(bundle2a));
        assertTrue("same bundles should have equal hashCodes",bundle1a.hashCode() == bundle1b.hashCode());
    }
}
