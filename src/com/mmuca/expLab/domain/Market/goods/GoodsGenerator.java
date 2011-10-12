package com.mmuca.expLab.domain.Market.goods;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketLevel;
import com.mmuca.expLab.domain.distributions.IDistribution;

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

    public void populate(Market market) {
        numberOfCreatedGoods =0;
        fulfilMinimumRequirement(market);
        distributeLeftOverGoods(market);
        
    }

    private void fulfilMinimumRequirement(Market market) {
        for (MarketLevel level : market.getAllLevels()){
            addMinimumGoods(level);
        }
    }

    private void distributeLeftOverGoods(Market market) {
        for (int i=numberOfCreatedGoods; i< numberOfGoodsToCreate;i++){
            addGoodToLevel(market.getLevel(levelDistribution.flipCoin()));
        }
    }


    private void addMinimumGoods(MarketLevel level) {
        for (int i=0; i < minimumGoodsPerLevel; i++){
            addGoodToLevel(level);
        }
    }

    private void addGoodToLevel(MarketLevel level){
        level.addGood(createUniqueGood());
    }

    private Good createUniqueGood(){
        Good good = new Good(String.format("Good_%03d", numberOfCreatedGoods +1));
        numberOfCreatedGoods++;
        return good;
    }
}
