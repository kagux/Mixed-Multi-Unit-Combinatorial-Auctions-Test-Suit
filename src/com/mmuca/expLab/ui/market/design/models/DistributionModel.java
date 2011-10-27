package com.mmuca.expLab.ui.market.design.models;

import com.mmuca.expLab.domain.distributions.Distribution;
import com.mmuca.expLab.domain.distributions.ValueRange;
import com.mmuca.expLab.ui.market.design.views.ObserverView;

import java.util.ArrayList;

public class DistributionModel {
    private Object distribution;
    private Distribution[] validDistributions;
    private ValueRange range;
    private ArrayList<ObserverView> views;

    public DistributionModel(Object distribution, Distribution[] validDistributions, ValueRange range){
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

    public Object getDistribution() {
        return distribution;
    }

    public void setDistribution(Object distribution) {
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
