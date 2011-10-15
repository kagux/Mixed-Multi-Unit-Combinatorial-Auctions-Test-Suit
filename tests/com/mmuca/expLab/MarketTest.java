package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketLevel;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class MarketTest {
    private Market market;
    private ArrayList<Good> goods;
    private ArrayList<Transformation> transformations;
    private ArrayList<MarketLevel> levels;
    
    @Before
    public void setUp(){
        

        goods =  new ArrayList<Good>();
        goods.add(new Good("good 1"));
        goods.add(new Good("good 2"));
        goods.add(new Good("good 3"));
        goods.add(new Good("good 4"));
        goods.add(new Good("good 5"));
        goods.add(new Good("good 6"));

        transformations = new ArrayList<Transformation>();
        transformations.add(new Transformation());
        transformations.add(new Transformation());
        transformations.add(new Transformation());
        transformations.add(new Transformation());

        levels = new ArrayList<MarketLevel>();
        levels.add(new MarketLevel());
        levels.add(new MarketLevel());
        levels.add(new MarketLevel());
        levels.add(new MarketLevel());

        levels.get(0).addGood(goods.get(0));
        levels.get(0).addGood(goods.get(1));
        levels.get(0).addTransformation(transformations.get(0));
        levels.get(0).addTransformation(transformations.get(1));

        levels.get(1).addGood(goods.get(2));
        levels.get(1).addGood(goods.get(3));
        levels.get(1).addTransformation(transformations.get(2));

        levels.get(2).addGood(goods.get(4));
        levels.get(2).addGood(goods.get(5));
        levels.get(2).addTransformation(transformations.get(3));

        market = new Market();
        market.addLevel(levels.get(0));
        market.addLevel(levels.get(1));
        market.addLevel(levels.get(2));
        market.addLevel(levels.get(3));
    }
    
    @Test
    public void addingLevels(){
        assertEquals("all levels should be added", levels.size(), market.getAllLevels().size());
    }
    
    @Test
    public void gettingAllGoods(){
        assertEquals("should return all goods", goods.size(),market.getAllGoods().size());
        for(Good good: market.getAllGoods()){
            assertTrue("good should be from initial pool", goods.contains(good));
        }
    }
    
    @Test
    public void gettingAllTransformations(){
       assertEquals("should return all transformations", transformations.size(),market.getAllTransformations().size());
    }

    @Test
    public void gettingSingleLevel(){
       assertEquals("levels should be equal", levels.get(0), market.getLevel(0));
    }
}
