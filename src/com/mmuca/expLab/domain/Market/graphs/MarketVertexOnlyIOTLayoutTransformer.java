package com.mmuca.expLab.domain.Market.graphs;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.transformations.Transformation;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MarketVertexOnlyIOTLayoutTransformer extends MarketVertexAllTransLayoutTransformer {

    public MarketVertexOnlyIOTLayoutTransformer(Market market, Dimension size) {
        super(market, size);
    }

    @Override
    protected ArrayList createTransformationsPool(ArrayList vertices) {
        for (Iterator iterator = vertices.iterator(); iterator.hasNext();) {
            if (notIOTransformation(iterator.next())) iterator.remove();
        }
        return vertices;
    }

    private boolean notIOTransformation(Object vertex) {
        return notTransformation(vertex) || ((Transformation) vertex).getInput().isEmpty() || ((Transformation) vertex).getOutput().isEmpty();
    }

    private boolean notTransformation(Object vertex) {
        return !(vertex instanceof Transformation);
    }
}
