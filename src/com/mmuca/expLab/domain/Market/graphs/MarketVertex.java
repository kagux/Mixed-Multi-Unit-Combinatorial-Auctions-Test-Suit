package com.mmuca.expLab.domain.Market.graphs;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public enum MarketVertex {
    IOT_TRANSFORMATION (new Rectangle2D.Double(-10, -10, 20, 20),new Color(140, 140, 140)),
    DEFAULT_TRANSFORMATION (new Rectangle2D.Double(-10,-10,20,20),new Color(230, 230, 230)),
    GOOD(new Ellipse2D.Double(-10,-10,20,20),Color.YELLOW);

    private Shape shape;
    private Color color;

    MarketVertex(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    public Color color(){
        return color;
    }

    public Shape shape() {
        return shape;
    }
}
