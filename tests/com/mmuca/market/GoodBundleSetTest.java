package com.mmuca.market;

import org.junit.*;

import static junit.framework.Assert.assertEquals;

public class GoodBundleSetTest {


    @Test
    public void addingBundlesWithSameGood(){
        GoodBundleSet bundles = new GoodBundleSet();
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
    }

}
