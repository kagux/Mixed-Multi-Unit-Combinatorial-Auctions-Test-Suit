package com.mmuca.market;

import java.util.Collection;
import java.util.HashMap;

public class MarketLevel {
    private HashMap<Integer,Good> goods;
    private HashMap<Integer,Transformation> transformations;

    public MarketLevel(){
       goods = new HashMap<Integer,Good>();
       transformations=new HashMap<Integer,Transformation>();
    }

    public void addGood(Good newGood) {
       goods.put(goods.size(),newGood);
    }

    public Good getGood(int key) {
        return goods.get(key);
    }

    public Collection<Good> getGoods() {
        return goods.values();
    }

    public void addTransformation(Transformation transformation) {
       transformations.put(transformations.size(),transformation);
    }

    public Transformation getTransformation(int key) {
        return transformations.get(key).clone();
    }

    public Collection<Transformation> getTransformations() {
        return transformations.values();
    }
}
