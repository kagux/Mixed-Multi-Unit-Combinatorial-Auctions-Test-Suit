package com.mmuca.expLab.domain.Market;

import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import com.mmuca.expLab.domain.Require;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class MarketLevel {
    private ArrayList<Good> goods;
    private HashSet<Good> uniqueGoods;
    private HashMap<Integer,Transformation> transformations;

    public MarketLevel(){
       goods = new ArrayList<Good>();
       uniqueGoods= new HashSet<Good>();
       transformations=new HashMap<Integer,Transformation>();
    }

    public boolean addGood(Good newGood) {
        return uniqueGoods.add(newGood) && goods.add(newGood);
    }

    public Good getGood(int key) {
        Require.that(key >=0 && key < goods.size(), "Good Index should correspond to existing Good in range (0,"+(goods.size()-1)+"); was "+key);
        return goods.get(key);
    }

    public ArrayList<Good> getAllGoods() {
        return goods;
    }

    public void addTransformation(Transformation transformation) {
       transformations.put(transformations.size(),transformation);
    }

    public Transformation getTransformation(int key) {
        Require.that(key >=0 && key < transformations.size(), "Transformation index should correspond to existing Transformation in range (0,"+(transformations.size()-1)+"); was "+key);
        return transformations.get(key).clone();
    }

    public Collection<Transformation> getAllTransformations() {
        return transformations.values();
    }
}
