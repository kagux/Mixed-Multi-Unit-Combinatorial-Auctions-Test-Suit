package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.MarketLevel;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;
import com.mmuca.expLab.domain.Market.transformations.ITGenerator;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ITGeneratorTest {

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

        ITGenerator generator = new ITGenerator();
        generator.populate(levels);
    }

    @Test
    public void numberOfTransformations(){
        for (MarketLevel level: levels){
            assertEquals("number of transformations should equal to number of goods", level.getAllGoods().size(),level.getAllTransformations().size());
        }
    }
    
    @Test
    public void GoodBundles(){
        HashSet<GoodBundle> bundles = new HashSet<GoodBundle>();
        for (MarketLevel level : levels){
            for(Transformation transformation: level.getAllTransformations()){
                assertEquals("only one input bundle",1,transformation.getInput().size());
                assertEquals("No output bundles",0,transformation.getOutput().size());
                assertTrue("bundle should be unique", bundles.add(transformation.getInput().iterator().next()));
            }
        }
    }

    @Test
    public void transformationsUseGoodsFromSameLevel(){
        for (MarketLevel level : levels){
            for(Transformation transformation: level.getAllTransformations()){
                assertTrue("goods are from same level", level.getAllGoods().contains(transformation.getInput().iterator().next().getGood()));
            }
        }
    }

}
