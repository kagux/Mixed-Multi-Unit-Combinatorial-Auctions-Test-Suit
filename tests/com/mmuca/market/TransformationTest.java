package com.mmuca.market;

import org.junit.Test;

import static junit.framework.Assert.*;

public class TransformationTest {
   
    @Test
    public void hasInputAndOutputGoodsBundles(){
        Transformation transformation = new Transformation();

        Good flour = new Good("flour");
        GoodBundle inputBundle = new GoodBundle(flour, 2);
        transformation.addInput(inputBundle);
        assertEquals("get input bundle", inputBundle, transformation.getInput().iterator().next());

        Good bread = new Good("bread");
        GoodBundle outputBundle = new GoodBundle(bread, 1);
        transformation.addOutput(outputBundle);
        assertEquals("get output bundle", outputBundle, transformation.getOutput().iterator().next());

    }
    
    @Test
    public  void addingBundleWithAGoodThatAlreadyUsedInPreviousBundles(){
        Transformation transformation = new Transformation();

        Good flour = new Good("flour");
        GoodBundle bundle_1 = new GoodBundle(flour, 1);
        transformation.addInput(bundle_1);
        assertEquals("adding non-existing good in a bundle to input", 1, transformation.getInput().size());
        assertEquals("amount is same with bundle",1,transformation.getInput().iterator().next().getAmount());
        transformation.addOutput(bundle_1);
        assertEquals("adding non-existing good in a bundle to output", 1, transformation.getOutput().size());
        assertEquals("amount is same with bundle",1,transformation.getOutput().iterator().next().getAmount());

        GoodBundle bundle_2=new GoodBundle(flour,2);
        transformation.addInput(bundle_2);
        assertEquals("adding already existing good in a bundle to input",1,transformation.getInput().size());
        assertEquals("amount is combined", 3, transformation.getInput().iterator().next().getAmount());

        transformation.addOutput(bundle_2);
        assertEquals("adding already existing good in a bundle to input",1,transformation.getOutput().size());
        assertEquals("amount is combined", 3, transformation.getOutput().iterator().next().getAmount());
    }
    
}
