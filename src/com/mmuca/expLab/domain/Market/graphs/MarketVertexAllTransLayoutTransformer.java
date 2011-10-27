package com.mmuca.expLab.domain.Market.graphs;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import com.mmuca.expLab.domain.Require;
import org.apache.commons.collections15.Transformer;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MarketVertexAllTransLayoutTransformer implements Transformer<Object, Point2D>{
    protected Market market;
    protected Dimension size;
    private double scale;
    protected HashMap<Object, Point2D> layoutMap;

    public MarketVertexAllTransLayoutTransformer(Market market, Dimension size) {
        this.market = market;
        this.size = size;
        this.scale=1;
    }

    public MarketVertexAllTransLayoutTransformer(Market market, Dimension size, double scale) {
        Require.that(scale <=1 && scale >0, "Scale should be in range (0,1]; was "+size);
        this.market = market;
        this.size = size;
        this.scale = scale;
    }

    @Override
    public Point2D transform(Object o) {
        Require.that(o instanceof Good || o instanceof Transformation, "vertex needs to be either good or transformation");
        if (layoutMapIsNotInitialized()) initializeLayoutMap();
        return layoutMap.get(o);
    }

    private boolean layoutMapIsNotInitialized() {
        return layoutMap == null;
    }

    protected void initializeLayoutMap() {
        layoutMap = new HashMap<Object, Point2D>();
        for (int levelIndex=0; levelIndex< market.getAllLevels().size(); levelIndex++){
            layout(createTransformationsPool(market.getLevel(levelIndex).getAllTransformations()),levelIndex*2+1);
            layout(market.getLevel(levelIndex).getAllGoods(),levelIndex*2+2);
        }
    }

    protected ArrayList createTransformationsPool(ArrayList vertices) {
        Collections.shuffle(vertices);
        return vertices;
    }

    protected void layout(ArrayList vertices, int row){
        for (int col=0; col< vertices.size(); col++){
           layoutMap.put(vertices.get(col),new Point2D.Double(getX(col, vertices.size()), getY(row)));
        }
    }

    protected double getY(int row) {
        return verticalDistance() *(row) + verticalScaleOffset();
    }

    private double verticalScaleOffset() {
        return (size.getHeight()*(1-scale)/2);
    }

    protected double getX(int col, int verticesCount) {
        return horizontalDistance(verticesCount) *(col+1)+ horizontalScaleOffset();
    }

    private double horizontalScaleOffset() {
        return (size.getWidth()*(1-scale)/2);
    }

    protected double horizontalDistance(int verticesCount){
        return (size.getWidth()*scale)/(verticesCount + 1);
    }

    protected double verticalDistance() {
        return (size.getHeight()*scale)/(market.getAllLevels().size()*2+1);
    }
}
