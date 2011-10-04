package com.mmuca.market;

import collections.ForwardingHashSet;

import java.util.HashMap;

public class GoodBundlesSet extends ForwardingHashSet<GoodBundle> {
    private HashMap<Good, GoodBundle> goodsMap;

    public GoodBundlesSet(){
        this.goodsMap=new HashMap<Good, GoodBundle>();
    }
    @Override
    public boolean add(GoodBundle bundle) {
        prepareSet(bundle.getGood());
        GoodBundle adjustedBundle = adjustBundle(bundle);
        addBundleToMap(adjustedBundle);
        return set.add(adjustedBundle);
    }

    private void prepareSet(Good good) {
            set.remove(goodsMap.get(good));
    }

    private GoodBundle adjustBundle(GoodBundle bundle){
        if (!goodsMap.containsKey(bundle.getGood())) return bundle;
        return new GoodBundle(bundle.getGood(), getAdjustedGoodsAmount(bundle));
    }

    private int getAdjustedGoodsAmount(GoodBundle bundle) {
        return bundle.getAmount()+goodsMap.get(bundle.getGood()).getAmount();
    }

    private void addBundleToMap(GoodBundle bundle){
            prepareMap(bundle.getGood());
            goodsMap.put(bundle.getGood(),bundle);
    }

    private void prepareMap(Good good) {
        if (goodsMap.containsKey(good))
            goodsMap.remove(good);
    }



}
