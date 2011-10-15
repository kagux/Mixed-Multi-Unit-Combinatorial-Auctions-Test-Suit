package com.mmuca.expLab.domain.Market.goods;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketLevel;
import com.mmuca.expLab.domain.distributions.IDistribution;

public class GoodsGenerator {
    private IDistribution levelDistribution;
    private static int goodSerialNumber =1;

    public GoodsGenerator(IDistribution levelDistribution) {
        this.levelDistribution = levelDistribution;
    }

    public void populate(Market market, int numberOfGoodsToCreate, int minimumGoodsPerLevel) {
        fulfilMinimumRequirement(market,minimumGoodsPerLevel);
        int amountLeftToCreate = numberOfGoodsToCreate - minimumGoodsPerLevel * market.getAllLevels().size();
        distributeLeftOverGoods(market, amountLeftToCreate);
        
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
