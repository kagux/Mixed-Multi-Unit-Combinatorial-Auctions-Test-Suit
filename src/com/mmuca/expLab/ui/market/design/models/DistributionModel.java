package com.mmuca.expLab.ui.market.design.models;

import com.mmuca.expLab.ui.market.design.views.ObserverView;

import java.util.ArrayList;

public class DistributionModel {
    private Object distribution;
    private ArrayList<ObserverView> views;

    public DistributionModel(Object distribution){
        this.distribution = distribution;
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
}
