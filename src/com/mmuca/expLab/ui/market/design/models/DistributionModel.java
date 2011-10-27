package com.mmuca.expLab.ui.market.design.models;

import com.mmuca.expLab.domain.distributions.Distribution;
import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.domain.distributions.ValueRange;
import com.mmuca.expLab.ui.market.design.views.ObserverView;

import java.util.ArrayList;

public class DistributionModel {
    private IDistribution distribution;
    private Distribution[] validDistributions;
    private ValueRange range;
    private ArrayList<ObserverView> views;

    public DistributionModel(IDistribution distribution, Distribution[] validDistributions, ValueRange range){
        this.distribution = distribution;
        this.validDistributions = validDistributions;
        this.range = range;
        views = new ArrayList<ObserverView>();
    }

    public void addView(ObserverView view){
        views.add(view);
    }

    public  void refreshViews(){
        for(ObserverView view: views)
            view.refresh();
    }

    public IDistribution getDistribution() {
        return distribution;
    }

    public void setDistribution(IDistribution distribution) {
        this.distribution = distribution;
        refreshViews();
    }

    public int getRangeStart(){
         return range.getStart();
    }

    public void setRangeStart(int start){
        range.setStart(start);
    }

    public int getRangeEnd(){
        return range.getEnd();
    }

    public void setRangeEnd(int end){
        range.setEnd(end);
        refreshViews();
    }

    public Distribution[] validDistributions(){
        return  validDistributions;
    }
}
