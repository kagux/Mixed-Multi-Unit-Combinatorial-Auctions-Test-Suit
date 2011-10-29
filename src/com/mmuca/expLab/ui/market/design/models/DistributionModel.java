package com.mmuca.expLab.ui.market.design.models;

import com.mmuca.expLab.domain.Market.MarketDistribution;
import com.mmuca.expLab.domain.distributions.Distribution;
import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.ui.market.design.views.ObserverView;

import java.util.ArrayList;

public class DistributionModel {
    private IDistribution distribution;
    private ArrayList<ObserverView> views;
    private MarketDistribution marketDistribution;

    public DistributionModel(MarketDistribution marketDistribution){
        this.marketDistribution = marketDistribution;
        views = new ArrayList<ObserverView>();
    }

    public void addView(ObserverView view){
        views.add(view);
    }

    public  void refreshViews(){
        for(ObserverView view: views)
            view.update();
    }

    public IDistribution getDistribution() {
        if (distribution == null) return marketDistribution.defaultDistribution();
        return distribution;
    }

    public void setDistribution(IDistribution distribution) {
        this.distribution = distribution;
        refreshViews();
    }

    public int getRangeStart(){
         return marketDistribution.valueRange().getStart();
    }

    public int getRangeEnd(){
        return marketDistribution.valueRange().getEnd();
    }

    public void setRangeEnd(int end){
        marketDistribution.setRangeEnd(end);
        refreshViews();
    }

    public int rangeOrigin(){
        return marketDistribution.rangeOrigin();
    }

    public Distribution[] validDistributions(){
        return  marketDistribution.validDistributions();
    }
}
