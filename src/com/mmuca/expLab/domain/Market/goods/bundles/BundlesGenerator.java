package com.mmuca.expLab.domain.Market.goods.bundles;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.collections.GoodBundlesSet;
import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.domain.distributions.ITargetedDistribution;
import com.mmuca.expLab.domain.Market.goods.Good;

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
        goodsLevelDistribution.setTarget(targetLevelIndex);
        ArrayList<Good> goods = getShuffledGoodsPool(market);
        GoodBundlesSet bundles = new GoodBundlesSet();
        for (int i = numberOfBundles(goods); i> 0; i--){
            GoodBundle bundle = new GoodBundle(goods.get(i-1),1);
            bundles.add(bundle);
        }
        return bundles;
    }

    private int numberOfBundles(ArrayList<Good> goods) {
        return Math.min(goods.size(), numberOfBundlesDistribution.flipCoin());
    }

    private ArrayList<Good> getShuffledGoodsPool(Market market) {
        ArrayList<Good> goods = market.getLevel(goodsLevelDistribution.flipCoin()).getAllGoods();
        Collections.shuffle(goods);
        return goods;
    }
}
