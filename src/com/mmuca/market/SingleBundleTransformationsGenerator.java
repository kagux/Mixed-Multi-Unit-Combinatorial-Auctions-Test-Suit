package com.mmuca.market;

import java.util.ArrayList;

abstract public class SingleBundleTransformationsGenerator {
    abstract protected ArrayList<Good> getGoodsList(ArrayList<MarketLevel> levels, int currentKey) ;
    abstract protected void populateTransformation(Good good, Transformation transformation) ;
    abstract protected int fromLevelOffset();
    abstract protected int toLevelOffset();


    public void populate(ArrayList<MarketLevel> levels) {
       for (int i=0+fromLevelOffset(); i<levels.size()-toLevelOffset(); i++){
           populateLevel(levels.get(i), getGoodsList(levels,i));
       }
    }

    protected void populateLevel(MarketLevel level, ArrayList<Good> goods) {
        for (Good good : goods){
            level.addTransformation(createTransformation(good));
        }
    }

    public  Transformation createTransformation(Good good){
        Transformation transformation = new Transformation();
        populateTransformation(good, transformation);
        return  transformation;
    }


}
