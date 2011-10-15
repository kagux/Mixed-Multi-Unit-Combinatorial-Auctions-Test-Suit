package com.mmuca.expLab.domain.Market;

import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import com.mmuca.expLab.domain.Require;

import java.util.ArrayList;

public class Market {
    private ArrayList<MarketLevel> levels;

    public Market(){
        this.levels=new ArrayList<MarketLevel>();
    }

    public void addLevel(MarketLevel level) {
        this.levels.add(level);
    }

    public MarketLevel getLevel(int levelIndex) {
        Require.that(levelIndex >= 0 && levelIndex < levels.size(), "Level Index should correspond to existing Level in range (0," + (levels.size()-1) + "); was " + levelIndex);
        return levels.get(levelIndex);
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
