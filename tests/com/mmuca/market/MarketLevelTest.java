package com.mmuca.market;

import org.junit.Test;

import static junit.framework.Assert.*;

public class MarketLevelTest {
    
    @Test
    public void Goods(){
        MarketLevel level = new MarketLevel();
        Good car =  new Good("car");  
        Good rocket  =  new Good("rocket");  
        level.addGood(car);
        assertEquals("Number of goods in a level", 1, level.getGoods().size());
        assertEquals("Good is the same", car, level.getGoods().iterator().next());
        assertEquals("fetching good by key", car, level.getGood(0));
        level.addGood(rocket);
        assertEquals("Number of goods in a level", 2, level.getGoods().size());
        assertEquals("fetching another good by key", rocket, level.getGood(1));
        
    }

    @Test
    public void Transformations(){
       MarketLevel level = new MarketLevel();
       Transformation transformation1a=new Transformation();
       Good car =  new Good("car");
       GoodBundle bundle = new GoodBundle(car,1);
       transformation1a.addInput(bundle);
       level.addTransformation(transformation1a);
       assertTrue("when we get all transformations they should be references",level.getTransformations().contains(transformation1a));

       Transformation transformation1b=level.getTransformation(0);
       assertEquals("input bundles should be same", transformation1a.getInput(), transformation1b.getInput());
       assertEquals("output bundles  should be same", transformation1a.getOutput(),transformation1b.getOutput());
       assertEquals("input size should be same",1,transformation1b.getInput().size());
       assertFalse("transformation should be a copy", transformation1a.equals(transformation1b));
    }

}
