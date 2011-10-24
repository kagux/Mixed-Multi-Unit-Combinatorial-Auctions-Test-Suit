package com.mmuca.expLab.domain.ui.market.design.models;

import com.mmuca.expLab.domain.Market.MarketGenerator;
import com.mmuca.expLab.domain.Market.MarketGeneratorBuilder;
import com.mmuca.expLab.domain.Market.graphs.MarketEdge;
import com.mmuca.expLab.domain.Market.graphs.MarketGraphProvider;
import com.mmuca.expLab.domain.distributions.MarkovBackwardDistribution;
import com.mmuca.expLab.domain.distributions.MarkovForwardDistribution;
import com.mmuca.expLab.domain.distributions.UniformDistribution;
import com.mmuca.expLab.domain.ui.market.design.views.ObserverView;
import edu.uci.ics.jung.graph.Graph;

import java.util.ArrayList;
import java.util.Observable;

public class MarketGraphModel extends Observable{
    public static final int DEFAULT_NUM_LEVELS = 6;
    public static final int DEFAULT_NUM_GOODS = 10;
    public static final int DEFAULT_MIN_GOODS_PER_LEVEL = 2;
    public static final int DEFAULT_NUM_IOT = 5;
    private MarketGenerator.Parameters generatorParameters;
    private MarketGenerator.Distributions generatorDistributions;
    private ArrayList<ObserverView> views;
    private MarketGraphProvider graphProvider;

    public MarketGraphModel(MarketGraphProvider graphProvider){
        this.graphProvider = graphProvider;
        generatorDistributions = new MarketGenerator.Distributions(
                new UniformDistribution(),
                new UniformDistribution(),
                new MarkovForwardDistribution(0.1,0.1),
                new MarkovBackwardDistribution(0.1,0.1),
                new UniformDistribution(),
                new UniformDistribution()
        );
        generatorParameters = new MarketGenerator.Parameters(DEFAULT_NUM_LEVELS, DEFAULT_NUM_GOODS, DEFAULT_MIN_GOODS_PER_LEVEL, DEFAULT_NUM_IOT);
    }

    public void addView(ObserverView view){
        views.add(view);
    }

    public  void refreshViews(){
        for(ObserverView view: views)
            view.refresh();
    }

    public String getNumGoods(){
       return String.valueOf(generatorParameters.getNumGoods());
    }

    public void setNumGoods(String numGoods){
        generatorParameters.setNumGoods(Integer.parseInt(numGoods));
        refreshViews();
    }

    public String getMinGoodsPerLevel(){
        return String.valueOf(generatorParameters.getMinGoodsPerLevel());
    }

    public void setMinGoodsPerLevel(String minNumGoodsPerLevel){
        generatorParameters.setMinGoodsPerLevel(Integer.parseInt(minNumGoodsPerLevel));
        refreshViews();
    }

    public String getNumLevels(){
        return String.valueOf(generatorParameters.getNumLevels());
    }

    public void setNumLevels(String numLevels){
        generatorParameters.setNumLevels(Integer.parseInt(numLevels));
        refreshViews();
    }

    public String getNumIOT(){
        return String.valueOf(generatorParameters.getNumIOT());
    }

    public void setNumIOT(String numIOT){
        generatorParameters.setNumIOT(Integer.parseInt(numIOT));
        refreshViews();
    }

    public Graph<Object, MarketEdge> marketGraph(){
        return graphProvider.graphFor(new MarketGeneratorBuilder(generatorParameters, generatorDistributions).build().nextMarket());
    }




}
