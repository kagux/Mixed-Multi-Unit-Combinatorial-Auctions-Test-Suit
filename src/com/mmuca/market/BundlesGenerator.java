package com.mmuca.market;

import com.mmuca.market.collections.GoodBundlesSet;
import com.mmuca.market.distributions.IDistribution;
import com.mmuca.market.distributions.ISeededDistribution;

import java.util.ArrayList;
import java.util.Collections;

public class BundlesGenerator {
    private ISeededDistribution goodsLevelDistribution;
    private IDistribution numberOfBundlesDistribution;

    public BundlesGenerator(ISeededDistribution goodsLevelDistribution, IDistribution numberOfBundlesDistribution) {
        this.goodsLevelDistribution = goodsLevelDistribution;
        this.numberOfBundlesDistribution = numberOfBundlesDistribution;
    }

    public GoodBundlesSet generate(Market market, int targetLevelSerialNum) {
        goodsLevelDistribution.setSeed(targetLevelSerialNum);
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
