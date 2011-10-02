package com.mmuca.market;

import java.util.HashMap;
import java.util.HashSet;

public class GoodBundleSet extends HashSet<GoodBundle> {
    private HashMap<Good, GoodBundle> goodsMap;

    public GoodBundleSet(){
        this.goodsMap=new HashMap<Good, GoodBundle>();
    }
    @Override
    public boolean add(GoodBundle bundle) {
        prepareSet(bundle.getGood());

        GoodBundle adjustedBundle = adjustBundle(bundle);
        addBundleToMap(adjustedBundle);
        return super.add(adjustedBundle);
    }

    private void prepareMap(Good good) {
        if (goodsMap.containsKey(good))
            goodsMap.remove(good);
    }

    private void prepareSet(Good good) {
        super.remove(goodsMap.get(good));
    }

    private void addBundleToMap(GoodBundle bundle){
            prepareMap(bundle.getGood());
            goodsMap.put(bundle.getGood(),bundle);
    }

    private GoodBundle adjustBundle(GoodBundle bundle){
        if (!goodsMap.containsKey(bundle.getGood())) return bundle;
        return new GoodBundle(bundle.getGood(), getAdjustedGoodsAmount(bundle));
    }

    private int getAdjustedGoodsAmount(GoodBundle bundle) {
        return bundle.getAmount()+goodsMap.get(bundle.getGood()).getAmount();
    }

}
