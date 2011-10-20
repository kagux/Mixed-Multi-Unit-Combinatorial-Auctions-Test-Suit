package com.mmuca.expLab.domain.Market.graphs;

import com.mmuca.expLab.domain.Market.Market;
import org.apache.commons.collections15.Transformer;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MarketVertexLayoutTransformer implements Transformer<Object, Point2D>{
    private Market market;
    private Dimension size;
    private HashMap<Object, Point2D> layoutMap;

    public MarketVertexLayoutTransformer(Market market, Dimension size) {
        this.market = market;
        this.size = size;
    }

    @Override
    public Point2D transform(Object o) {
        if (layoutMapIsNotInitialized()) initializeLayoutMap();
        return layoutMap.get(o);
    }

    private boolean layoutMapIsNotInitialized() {
        return layoutMap == null;
    }

    private void initializeLayoutMap() {
        layoutMap = new HashMap<Object, Point2D>();
        for (int levelIndex=0; levelIndex< market.getAllLevels().size(); levelIndex++){
            layout(shuffle(market.getLevel(levelIndex).getAllTransformations()),levelIndex*2+1);
            layout(market.getLevel(levelIndex).getAllGoods(),levelIndex*2+2);
        }
    }

    private ArrayList shuffle(ArrayList vertices) {
        Collections.shuffle(vertices);
        return vertices;
    }

    private void layout(ArrayList vertices, int row){
       for (int col=0; col< vertices.size(); col++){
           layoutMap.put(vertices.get(col),new Point2D.Double(getX(col, vertices.size()), getY(row)));
        }
    }

    private double getY(int row) {
        return verticalDistance() *(row);
    }

    private double getX(int col, int verticesCount) {
        return horizontalDistance(verticesCount) *(col+1);
    }

    private double horizontalDistance(int verticesCount){
        return size.getWidth()/(verticesCount + 1);
    }

    private double verticalDistance() {
        return size.getHeight()/(market.getAllLevels().size()*2+1);
    }
}
