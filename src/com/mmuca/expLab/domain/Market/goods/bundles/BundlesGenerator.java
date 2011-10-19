package com.mmuca.expLab.domain.Market.goods.bundles;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.collections.GoodBundlesSet;
import com.mmuca.expLab.domain.Require;
import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.domain.distributions.ITargetedDistribution;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.distributions.ValueRange;

import java.util.ArrayList;
import java.util.Collections;

public class BundlesGenerator {
    private ITargetedDistribution goodsLevelDistribution;
    private IDistribution numberOfBundlesDistribution;

    public BundlesGenerator(ITargetedDistribution goodsLevelDistribution, IDistribution numberOfBundlesDistribution) {
        this.goodsLevelDistribution = goodsLevelDistribution;
        this.numberOfBundlesDistribution = numberOfBundlesDistribution;
    }

    public GoodBundlesSet generate(Market market, int targetLevelIndex) {
        Require.that(targetLevelIndex >= 0 && targetLevelIndex < market.getAllLevels().size(), "Targeted Level index should correspond to existing Level in range (0," + (market.getAllLevels().size()-1) + "); was " + targetLevelIndex);
        numberOfBundlesDistribution.setValueRange(new ValueRange(1, market.getAllGoods().size()-1));
        goodsLevelDistribution.setValueRange(new ValueRange(0,market.getAllLevels().size()-1));
        goodsLevelDistribution.setTarget(targetLevelIndex);
        return createBundles(getShuffledGoodsPool(market));
    }

    private GoodBundlesSet createBundles(ArrayList<Good> goods) {
        GoodBundlesSet bundles = new GoodBundlesSet();
        for (int i = numberOfBundles(goods); i> 0; i--){
            GoodBundle bundle = new GoodBundle(goods.get(i-1),1);
            bundles.add(bundle);
        }
        return bundles;
    }

    private int numberOfBundles(ArrayList<Good> goods) {
        int numberOfBundles = numberOfBundlesDistribution.nextInt();
        Require.that(numberOfBundles > 0, "distribution should always return a positive value");
        return Math.min(goods.size(), numberOfBundles);
    }

    private ArrayList<Good> getShuffledGoodsPool(Market market) {
        ArrayList<Good> goods = market.getLevel(goodsLevelDistribution.nextInt()).getAllGoods();
        Collections.shuffle(goods);
        return goods;
    }
}
