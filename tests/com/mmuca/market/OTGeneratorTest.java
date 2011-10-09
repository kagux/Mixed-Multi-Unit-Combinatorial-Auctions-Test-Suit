package com.mmuca.market;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class OTGeneratorTest {

    private ArrayList<MarketLevel> levels;

    @Before
    public void setUp(){
        MarketLevel level_1 = new MarketLevel();
        MarketLevel level_2 = new MarketLevel();
        MarketLevel level_3 = new MarketLevel();
        MarketLevel level_4 = new MarketLevel();

        levels= new ArrayList<MarketLevel>();
        levels.add(level_1);
        levels.add(level_2);
        levels.add(level_3);
        levels.add(level_4);

        Good good_1 = new Good("good 1");
        Good good_2 = new Good("good 2");
        Good good_3 = new Good("good 3");
        Good good_4 = new Good("good 4");
        Good good_5 = new Good("good 5");
        Good good_6 = new Good("good 6");

        level_1.addGood(good_1);
        level_1.addGood(good_2);

        level_2.addGood(good_3);
        level_2.addGood(good_4);

        level_3.addGood(good_5);
        level_3.addGood(good_6);

        OTGenerator generator = new OTGenerator();
        generator.populate(levels);
    }

    @Test
    public void numberOfTransformations(){
       int numberOfTransformations=0;
       for (MarketLevel level: levels)
           numberOfTransformations+=level.getAllTransformations().size();
       assertEquals("number of transformations should equal to number of goods", 6,numberOfTransformations);
    }


    @Test
    public void GoodBundles(){
        HashSet<GoodBundle> bundles = new HashSet<GoodBundle>();
        for (MarketLevel level : levels){
            for(Transformation transformation: level.getAllTransformations()){
                assertEquals("only one output bundle",1,transformation.getOutput().size());
                assertEquals("No input bundles",0,transformation.getInput().size());
                assertTrue("bundle should be unique", bundles.add(transformation.getOutput().iterator().next()));
            }
        }
    }

    @Test
    public void goodsAreFromPreviousLevel(){
        for (int i =1; i< levels.size();i++){
            MarketLevel currentLevel=levels.get(i);
            MarketLevel previousLevel = levels.get(i-1);
            for(Transformation transformation: currentLevel.getAllTransformations()){
                GoodBundle bundle = transformation.getOutput().iterator().next();
                Good good = bundle.getGood();
                assertTrue("Transformation should use good from previous level", previousLevel.getAllGoods().contains(good));
            }
        } 
    }



}
