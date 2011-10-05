package com.mmuca.market;

import java.util.ArrayList;

public class ITGenerator {

    public void populate(ArrayList<MarketLevel> levels) {
       for (MarketLevel level : levels){
           populateLevel(level);
       }
    }

    private void populateLevel(MarketLevel level) {
        for (int i=0; i<level.getGoods().size();i++){
            level.addTransformation(createTransformation(level.getGood(i)));
        }
    }

    public  Transformation createTransformation(Good good){
        Transformation transformation = new Transformation();
        transformation.addInput(new GoodBundle(good, 1));
        return  transformation;
    }
}
