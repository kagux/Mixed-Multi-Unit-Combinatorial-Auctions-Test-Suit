package com.mmuca.expLab.domain.Market.graphs;

import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.transformations.Transformation;

public class MarketEdge {

    private Transformation transformation;
    private Good good;

    public MarketEdge(Transformation transformation, Good good){

        this.transformation = transformation;
        this.good = good;
    }

    public Transformation getTransformation() {
        return transformation;
    }

    public Good getGood() {
        return good;
    }
}
