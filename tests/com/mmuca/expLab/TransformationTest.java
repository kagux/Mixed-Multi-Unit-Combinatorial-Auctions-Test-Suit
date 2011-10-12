package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.collections.GoodBundlesSet;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TransformationTest {

    @Test
    public  void inputAndOutputBundlesSetsBehaveIdentically(){

        Transformation transformation = new Transformation();
        assertTrue("input and output are instances of same class", transformation.getInput().getClass() == transformation.getOutput().getClass());
    }

    @Test
    public void addingABundle(){
        Transformation transformation = new Transformation();
        Good flour = new Good("flour");
        GoodBundle inputBundle = new GoodBundle(flour, 2);
        transformation.addInput(inputBundle);
        assertEquals("input bundle should have been added", inputBundle, transformation.getInput().iterator().next());
    }

    @Test
    public void addingBundlesInBulk(){
        Transformation transformation = new Transformation();
        GoodBundlesSet bundles = bundlesFixture();
        transformation.addAllInput(bundles);
        assertEquals("input bundles should have been added", bundles.size(),transformation.getInput().size());
        assertTrue("input bundles should be same", bundles.containsAll(transformation.getInput()));
    }

    @Test
    public  void AddingBundleWithAGoodThatWasAlreadyUsedInPreviousBundles(){
        Transformation transformation = new Transformation();
        transformation.addInput(new GoodBundle(new Good("good"), 1));
        GoodBundle bundle_2=new GoodBundle(new Good("good"),2);

        assertEquals("bundle should have been added", 1, transformation.getInput().size());
        assertEquals("amount of good should be same",1,transformation.getInput().iterator().next().getAmount());

        transformation.addInput(bundle_2);
        assertEquals("adding same good, # of bundles should not change",1,transformation.getInput().size());
        assertEquals("amount of good should be combined from both bundles", 3, transformation.getInput().iterator().next().getAmount());

    }

    private GoodBundlesSet bundlesFixture() {
        GoodBundlesSet bundles = new GoodBundlesSet();
        bundles.add(new GoodBundle(new Good("good 1"),1));
        bundles.add(new GoodBundle(new Good("good 2"),1));
        bundles.add(new GoodBundle(new Good("good 3"),1));
        return bundles;
    }

    
}
