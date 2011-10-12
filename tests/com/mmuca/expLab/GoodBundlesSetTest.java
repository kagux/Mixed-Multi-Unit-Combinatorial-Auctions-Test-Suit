package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.collections.GoodBundlesSet;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;
import org.junit.Test;

import static junit.framework.Assert.*;

public class GoodBundlesSetTest {


    @Test
    public void workingWithBundles(){
        GoodBundlesSet bundles = new GoodBundlesSet();
        Good car = new Good("car");
        Good rocket = new Good("rocket");
        GoodBundle bundle1a= new GoodBundle(car, 1);
        GoodBundle bundle1b=new GoodBundle(car,2);
        GoodBundle bundle2=new GoodBundle(rocket,2);

        bundles.add(bundle1a);
        assertEquals("adding single bundle", 1, bundles.size());
        assertEquals("getting a bundle",bundle1a, bundles.iterator().next());

        bundles.add(bundle1b);
        assertEquals("adding multiple bundles with same good", 1, bundles.size());
        assertEquals("only the amount changes",3,bundles.iterator().next().getAmount());

        bundles.add(bundle2);
        assertEquals("adding different bundles", 2, bundles.size());


        assertEquals("getting all goods", 2, bundles.getAllGoods().size());
        assertEquals("should be car", car, bundles.getAllGoods().get(0));
        assertEquals("should be car", rocket, bundles.getAllGoods().get(1));
    }

    @Test
    public void foreachLoop(){
        GoodBundlesSet bundles = new GoodBundlesSet();
        bundles.add(new GoodBundle(new Good("good 1"),1));
        bundles.add(new GoodBundle(new Good("good 2"),1));
        for(GoodBundle bundle : bundles){
            assertTrue("loop should work", true);
        }
    }

    @Test
    public void containsAll(){
        GoodBundlesSet bundles_1 = new GoodBundlesSet();
        bundles_1.add(new GoodBundle(new Good("good 1"), 1));
        GoodBundlesSet bundles_2 = new GoodBundlesSet();
        bundles_2.add(new GoodBundle(new Good("good 1"), 1));
        bundles_2.add(new GoodBundle(new Good("good 2"), 1));
        GoodBundlesSet bundles_3 = new GoodBundlesSet();
        bundles_3.add(new GoodBundle(new Good("other good"),1));
        assertTrue("should contain all", bundles_2.containsAll(bundles_1));
        assertFalse("should not contain", bundles_2.containsAll(bundles_3));
    }


}
