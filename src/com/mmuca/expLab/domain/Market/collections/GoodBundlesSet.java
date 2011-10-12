package com.mmuca.expLab.domain.Market.collections;

import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;
import com.mmuca.expLab.domain.collections.ForwardingHashSet;

import java.util.ArrayList;
import java.util.HashMap;

public class GoodBundlesSet extends ForwardingHashSet<GoodBundle>{
    private HashMap<Good, GoodBundle> goodsMap;

    public GoodBundlesSet(){
        this.goodsMap=new HashMap<Good, GoodBundle>();
    }

    public ArrayList<Good> getAllGoods() {
        return new ArrayList<Good>(goodsMap.keySet());
    }

    public boolean containsAll(GoodBundlesSet bundles) {
        return goodsMap.values().containsAll(bundles.goodsMap.values());
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
