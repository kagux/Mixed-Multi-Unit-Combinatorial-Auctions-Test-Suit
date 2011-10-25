package com.mmuca.expLab.ui.market.design.models;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketDistribution;
import com.mmuca.expLab.domain.Market.MarketGenerator;
import com.mmuca.expLab.domain.Market.MarketGeneratorBuilder;
import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.domain.distributions.MarkovBackwardDistribution;
import com.mmuca.expLab.domain.distributions.MarkovForwardDistribution;
import com.mmuca.expLab.domain.distributions.UniformDistribution;
import com.mmuca.expLab.ui.market.design.views.ObserverView;

import java.util.ArrayList;
import java.util.Observable;

public class MarketModel extends Observable{
    public static final int DEFAULT_NUM_LEVELS = 6;
    public static final int DEFAULT_NUM_GOODS = 10;
    public static final int DEFAULT_MIN_GOODS_PER_LEVEL = 2;
    public static final int DEFAULT_NUM_IOT = 5;
    public static final int MINIMUM_NUM_GOODS = 1;
    public static final int MINIMUM_MIN_NUM_GOODS_PER_LEVEL = 1;
    public static final int MINIMUM_NUM_LEVELS = 3;
    public static final int MINIMUM_NUM_IOT = 0;
    public static final boolean DEFAULT_SHOW_ONLY_IOT = true;

    private MarketGenerator.Parameters generatorParameters;
    private MarketGenerator.Distributions generatorDistributions;
    private ArrayList<ObserverView> views;
    private boolean showOnlyIOT;
    private DistributionModel goodLevelDistrModel;

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
        showOnlyIOT= DEFAULT_SHOW_ONLY_IOT;
        goodLevelDistrModel = new DistributionModel(MarketDistribution.GOOD_LEVEL.defaultDistribution());

    }

    public void addView(ObserverView view){
        views.add(view);
        goodLevelDistrModel.addView(view);
    }

    public  void refreshViews(){
        for(ObserverView view: views)
            view.refresh();
    }

    public DistributionModel getGoodLevelDistrModel() {
        return goodLevelDistrModel;
    }

    public boolean isShowOnlyIOT() {
        return showOnlyIOT;
    }

    public void setShowOnlyIOT(boolean showOnlyIOT) {
        this.showOnlyIOT = showOnlyIOT;
        refreshViews();
    }

    public int getNumGoods(){
       return generatorParameters.getNumGoods();
    }

    public void setNumGoods(int numGoods){
        generatorParameters.setNumGoods(numGoods);
        refreshViews();
    }

    public int getMinGoodsPerLevel(){
        return generatorParameters.getMinGoodsPerLevel();
    }

    public void setMinGoodsPerLevel(int minNumGoodsPerLevel){
        generatorParameters.setMinGoodsPerLevel(minNumGoodsPerLevel);
        refreshViews();
    }

    public int getNumLevels(){
        return generatorParameters.getNumLevels();
    }

    public void setNumLevels(int numLevels){
        generatorParameters.setNumLevels(numLevels);
        refreshViews();
    }

    public int getNumIOT(){
        return generatorParameters.getNumIOT();
    }

    public void setNumIOT(int numIOT){
        generatorParameters.setNumIOT(numIOT);
        refreshViews();
    }

    public Market market(){
        generatorDistributions.setGoodLevelDistribution((IDistribution)goodLevelDistrModel.getDistribution());
        return new MarketGeneratorBuilder(generatorParameters, generatorDistributions).build().nextMarket();
    }


}
