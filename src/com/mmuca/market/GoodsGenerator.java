package com.mmuca.market;

import com.mmuca.market.distributions.IDistribution;

import java.util.ArrayList;
import java.util.Iterator;

public class GoodsGenerator {
    private IDistribution levelDistribution;
    private int numberOfGoodsToCreate;
    private int minimumGoodsPerLevel;
    private int numberOfCreatedGoods;

    public GoodsGenerator(IDistribution levelDistribution, int numberOfGoodsToCreate, int minimumGoodsPerLevel) {
        this.levelDistribution = levelDistribution;
        this.numberOfGoodsToCreate = numberOfGoodsToCreate;
        this.minimumGoodsPerLevel = minimumGoodsPerLevel;
    }

    public void populate(ArrayList<MarketLevel> levels) {
        numberOfCreatedGoods =0;
        fulfilMinimumRequirement(levels.iterator());
        distributeLeftOverGoods(levels);
        
    }

    private void fulfilMinimumRequirement(Iterator<MarketLevel> levelsIterator) {
        while (levelsIterator.hasNext()){
            populateSingleLevel(levelsIterator.next());
        }
    }

    private void populateSingleLevel(MarketLevel level) {
        for (int i=0; i < minimumGoodsPerLevel; i++){
            addGoodToLevel(level);
        }
    }

    private void addGoodToLevel(MarketLevel level){
        level.addGood(createUniqueGood());
    }

    private void distributeLeftOverGoods(ArrayList<MarketLevel> levels) {
        for (int i=numberOfCreatedGoods; i< numberOfGoodsToCreate;i++){
            addGoodToLevel(levels.get(levelDistribution.flipCoin()));
        }
    }
    
    private Good createUniqueGood(){
        Good good = new Good(String.format("Good_%03d", numberOfCreatedGoods +1));
        numberOfCreatedGoods++;
        return good;
    }

}
