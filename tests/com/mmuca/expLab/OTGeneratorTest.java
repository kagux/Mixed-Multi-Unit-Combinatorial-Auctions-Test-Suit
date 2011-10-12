package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketLevel;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;
import com.mmuca.expLab.domain.Market.transformations.OTGenerator;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class OTGeneratorTest {

    private Market market;

    @Before
    public void setUp(){
        MarketLevel level_1 = new MarketLevel();
        MarketLevel level_2 = new MarketLevel();
        MarketLevel level_3 = new MarketLevel();
        MarketLevel level_4 = new MarketLevel();

        market = new Market();
        market.add(level_1);
        market.add(level_2);
        market.add(level_3);
        market.add(level_4);

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
        generator.populate(market);
    }

    @Test
    public void numberOfTransformations(){
       assertEquals("number of transformations should equal to number of goods", 6,market.getAllTransformations().size());
    }


    @Test
    public void GoodBundles(){
        HashSet<GoodBundle> bundles = new HashSet<GoodBundle>();
        for(Transformation transformation: market.getAllTransformations()){
            assertEquals("only one output bundle",1,transformation.getOutput().size());
            assertEquals("No input bundles",0,transformation.getInput().size());
            assertTrue("bundle should be unique", bundles.add(transformation.getOutput().iterator().next()));
        }
    }

    @Test
    public void goodsAreFromPreviousLevel(){
        for (int i =1; i< market.getAllLevels().size();i++){
            MarketLevel currentLevel= market.getLevel(i);
            MarketLevel previousLevel = market.getLevel(i-1);
            for(Transformation transformation: currentLevel.getAllTransformations()){
                assertTrue("Transformation should use good from previous level", previousLevel.getAllGoods().containsAll(transformation.getOutput().getAllGoods()));
            }
        } 
    }



}
