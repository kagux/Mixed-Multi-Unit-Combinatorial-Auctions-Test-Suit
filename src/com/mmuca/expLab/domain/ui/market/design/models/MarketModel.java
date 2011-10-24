package com.mmuca.expLab.domain.ui.market.design.models;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketGenerator;
import com.mmuca.expLab.domain.Market.MarketGeneratorBuilder;
import com.mmuca.expLab.domain.distributions.MarkovBackwardDistribution;
import com.mmuca.expLab.domain.distributions.MarkovForwardDistribution;
import com.mmuca.expLab.domain.distributions.UniformDistribution;
import com.mmuca.expLab.domain.ui.market.design.views.ObserverView;

import java.util.ArrayList;
import java.util.Observable;

public class MarketModel extends Observable{
    public static final int DEFAULT_NUM_LEVELS = 6;
    public static final int DEFAULT_NUM_GOODS = 10;
    public static final int DEFAULT_MIN_GOODS_PER_LEVEL = 2;
    public static final int DEFAULT_NUM_IOT = 5;
    private MarketGenerator.Parameters generatorParameters;
    private MarketGenerator.Distributions generatorDistributions;
    private ArrayList<ObserverView> views;
    private boolean marketUpToDate;
    private Market market;

    public MarketModel(){
        views = new ArrayList<ObserverView>();
        generatorDistributions = new MarketGenerator.Distributions(
                new UniformDistribution(),
                new UniformDistribution(),
                new MarkovForwardDistribution(0.1,0.1),
                new MarkovBackwardDistribution(0.1,0.1),
                new UniformDistribution(),
                new UniformDistribution()
        );
        generatorParameters = new MarketGenerator.Parameters(DEFAULT_NUM_LEVELS, DEFAULT_NUM_GOODS, DEFAULT_MIN_GOODS_PER_LEVEL, DEFAULT_NUM_IOT);
        marketUpToDate=false;
    }

    public void addView(ObserverView view){
        views.add(view);
    }

    public  void refreshViews(){
        marketUpToDate=false;
        for(ObserverView view: views)
            view.refresh();
    }

    public String getNumGoods(){
       return String.valueOf(generatorParameters.getNumGoods());
    }

    public void setNumGoods(int numGoods){
        generatorParameters.setNumGoods(numGoods);
        refreshViews();
    }

    public String getMinGoodsPerLevel(){
        return String.valueOf(generatorParameters.getMinGoodsPerLevel());
    }

    public void setMinGoodsPerLevel(int minNumGoodsPerLevel){
        generatorParameters.setMinGoodsPerLevel(minNumGoodsPerLevel);
        refreshViews();
    }

    public String getNumLevels(){
        return String.valueOf(generatorParameters.getNumLevels());
    }

    public void setNumLevels(int numLevels){
        generatorParameters.setNumLevels(numLevels);
        refreshViews();
    }

    public String getNumIOT(){
        return String.valueOf(generatorParameters.getNumIOT());
    }

    public void setNumIOT(int numIOT){
        generatorParameters.setNumIOT(numIOT);
        refreshViews();
    }

    public Market market(){
        if (marketUpToDate) return market;
        market = new MarketGeneratorBuilder(generatorParameters, generatorDistributions).build().nextMarket();
        marketUpToDate=true;
        return market;
    }


}
