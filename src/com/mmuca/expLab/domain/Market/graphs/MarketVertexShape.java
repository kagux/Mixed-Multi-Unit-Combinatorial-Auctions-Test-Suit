package com.mmuca.expLab.domain.Market.graphs;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public enum MarketVertexShape {
    CIRCLE(new Ellipse2D.Double(0,0,20,20)),
    BOX(new Rectangle(20,20));

    private Shape shape;
    private MarketVertexShape(Shape shape) {
        this.shape=shape;
    }

    public Shape shape(){
        return shape;
    }

}
