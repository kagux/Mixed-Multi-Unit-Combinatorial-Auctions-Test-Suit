package com.mmuca.expLab.domain.Market.graphs;

import org.apache.commons.collections15.Transformer;

import java.awt.*;

public class MarketEdgeColorTransformer implements Transformer<MarketEdge, Paint>{
    public static final Color DARK_COLOR = Color.DARK_GRAY;
    public static final Color LIGHT_COLOR = Color.LIGHT_GRAY;

    @Override
    public Paint transform(MarketEdge marketEdge) {
        return isIOTransformation(marketEdge) ?DARK_COLOR:LIGHT_COLOR;
    }

    private boolean isIOTransformation(MarketEdge marketEdge) {
        return marketEdge.getTransformation().getOutput().size()>0 && marketEdge.getTransformation().getInput().size()>0;
    }
}
