package com.mmuca.expLab.domain.Market.transformations;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketLevel;
import com.mmuca.expLab.domain.Market.goods.Good;

import java.util.ArrayList;

abstract public class SingleBundleTransformationsGenerator {
    abstract protected ArrayList<Good> getGoodsList(Market market, int currentKey) ;
    abstract protected void addBundle(Good good, Transformation transformation) ;
    abstract protected int fromLevelOffset();


    public void populate(Market market) {
        for (int i=market.getAllLevels().size()-1; i>= fromLevelOffset();  i--){
           populateLevel(market.getLevel(i), getGoodsList(market,i));
       }
    }

    protected void populateLevel(MarketLevel level, ArrayList<Good> goods) {
        for (Good good : goods){
            level.addTransformation(createTransformation(good));
        }
    }

    public  Transformation createTransformation(Good good){
        Transformation transformation = new Transformation();
        addBundle(good, transformation);
        return  transformation;
    }


}
