package com.mmuca.expLab.Stubs;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketLevel;
import com.mmuca.expLab.domain.Market.collections.GoodBundlesSet;
import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.domain.distributions.ISeededDistribution;
import com.mmuca.expLab.domain.Market.goods.bundles.BundlesGenerator;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;

public class StubBundlesGenerator extends BundlesGenerator {
    private int numberOfBundles;
    private int goodsLevelSerialNum;

    public StubBundlesGenerator(ISeededDistribution goodsLevelDistribution, IDistribution numberOfBundlesDistribution) {
        super(goodsLevelDistribution, numberOfBundlesDistribution);
        numberOfBundles=0;
    }
    
    @Override
    public GoodBundlesSet generate(Market market, int targetLevelSerialNum){
        GoodBundlesSet bundles = new GoodBundlesSet();
        MarketLevel level = market.getLevel(goodsLevelSerialNum);
        for (int i=numberOfBundles; i> 0; i--){
            bundles.add(new GoodBundle(level.getGood(i-1),1));
        }
        return bundles;

    }

    public void setNumberOfBundles(int numberOfBundles) {
        this.numberOfBundles = numberOfBundles;
    }

    public  void setGoodsLevel(int levelSerialNum){
        this.goodsLevelSerialNum=levelSerialNum;
    }
}
