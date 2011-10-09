package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.collections.GoodBundlesSet;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TransformationTest {
   
    @Test
    public void addingInputBundle(){
        Transformation transformation = new Transformation();

        Good flour = new Good("flour");
        GoodBundle inputBundle = new GoodBundle(flour, 2);
        transformation.addInput(inputBundle);
        assertEquals("input bundle should have been added", inputBundle, transformation.getInput().iterator().next());
    }

    @Test
    public void addingInputInBulk(){
        Transformation transformation = new Transformation();
        GoodBundlesSet bundles = bundlesFixture();
        transformation.addAllInput(bundles);
        assertEquals("input bundles should have been added", bundles.size(),transformation.getInput().size());
        for (Iterator<GoodBundle> iterator=bundles.iterator();iterator.hasNext();){
            assertTrue("input bundles should be same", bundles.contains(iterator.next()));
        }
    }

    @Test
    public void addingOutputBundle(){
        Transformation transformation = new Transformation();
        Good bread = new Good("bread");
        GoodBundle outputBundle = new GoodBundle(bread, 1);
        transformation.addOutput(outputBundle);
        assertEquals("output bundle bundle should have been added", outputBundle, transformation.getOutput().iterator().next());
    }


    @Test
    public void addingOutputInBulk(){
        Transformation transformation = new Transformation();
        GoodBundlesSet bundles = bundlesFixture();
        transformation.addAllOutput(bundles);
        assertEquals("output bundles should have been added", bundles.size(),transformation.getOutput().size());
        for (Iterator<GoodBundle> iterator=bundles.iterator();iterator.hasNext();){
            assertTrue("output bundles should be same", bundles.contains(iterator.next()));
        }
    }

    @Test
    public  void AddingBundleWithAGoodThatAlreadyUsedInPreviousBundles(){
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

    private GoodBundlesSet bundlesFixture() {
        GoodBundlesSet bundles = new GoodBundlesSet();
        bundles.add(new GoodBundle(new Good("good 1"),1));
        bundles.add(new GoodBundle(new Good("good 2"),1));
        bundles.add(new GoodBundle(new Good("good 3"),1));
        return bundles;
    }

    
}
