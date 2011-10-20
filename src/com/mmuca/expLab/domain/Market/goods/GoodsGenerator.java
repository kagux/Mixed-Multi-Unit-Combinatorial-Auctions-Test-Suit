package com.mmuca.expLab.domain.Market.goods;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketLevel;
import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.domain.distributions.ValueRange;

public class GoodsGenerator {
    private IDistribution levelDistribution;
    private static int goodSerialNumber =1;

    public GoodsGenerator(IDistribution levelDistribution) {
        this.levelDistribution = levelDistribution;
    }

    public void populate(Market market, int numberOfGoodsToCreate, int minimumGoodsPerLevel) {
        levelDistribution.setValueRange(new ValueRange(0,market.getAllLevels().size()-1));
        fulfilMinimumRequirement(market, minimumGoodsPerLevel);
        distributeLeftOverGoods(market, amountLeftToCreate(market.getAllLevels().size(), numberOfGoodsToCreate, minimumGoodsPerLevel));
        
    }

    private int amountLeftToCreate(int levelsCount, int totalNumOfGoodsToCreate, int minGoodsPerLevel) {
        return totalNumOfGoodsToCreate - minGoodsPerLevel * levelsCount;
    }

    private void fulfilMinimumRequirement(Market market, int minimumGoodsPerLevel) {
        for (MarketLevel level : market.getAllLevels()){
            addGoodsToLevel(level, minimumGoodsPerLevel);
        }
    }

    private void distributeLeftOverGoods(Market market, int numberOfGoodsToCreate) {
        for (int i=0; i< numberOfGoodsToCreate;i++){
            market.getLevel(levelDistribution.nextInt()).addGood(createUniqueGood());
        }
    }

    private void addGoodsToLevel(MarketLevel level, int amount) {
        for (int i=0; i < amount; i++){
            level.addGood(createUniqueGood());
        }
    }

    private Good createUniqueGood(){
        return new Good(String.format("Good_%03d", goodSerialNumber++));
    }
}
