package com.mmuca.expLab.domain.Market;

import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.transformations.Transformation;

import java.util.ArrayList;

public class Market {
    private ArrayList<MarketLevel> levels;

    public Market(){
        this.levels=new ArrayList<MarketLevel>();
    }

    public void add(MarketLevel level) {
        this.levels.add(level);
    }

    public MarketLevel getLevel(int serialNumber) {
        //TODO Fast fail
        return levels.get(serialNumber);
    }

    public ArrayList<MarketLevel> getAllLevels() {
        return levels;
    }

    public ArrayList<Good> getAllGoods() {
        ArrayList<Good> goods = new ArrayList<Good>();
        for(MarketLevel level: levels){
           goods.addAll(level.getAllGoods());
        }
        return goods;
    }

    public ArrayList<Transformation> getAllTransformations() {
        ArrayList<Transformation> transformations = new ArrayList<Transformation>();
        for(MarketLevel level: levels){
            transformations.addAll(level.getAllTransformations());
        }
        return transformations;
    }

}
