package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;
import com.mmuca.expLab.domain.Market.graphs.MarketEdge;
import com.mmuca.expLab.domain.Market.graphs.MarketEdgeColorTransformer;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MarketEdgeColorTransformerTest {
    @Test
    public void edgeForIOTransformation(){
        Transformation transformation = new Transformation();
        transformation.addInput(newBundle());
        transformation.addOutput(newBundle());
        assertEquals("IO transformation edge color", MarketEdgeColorTransformer.DARK_COLOR, newTransformer().transform(new MarketEdge(transformation, new Good("good"))));
    }

    @Test
    public void edgeForInputTransformation(){
        Transformation transformation = new Transformation();
        transformation.addInput(newBundle());
        assertEquals("Input transformation edge color", MarketEdgeColorTransformer.LIGHT_COLOR, newTransformer().transform(new MarketEdge(transformation, new Good("good"))));
    }

    @Test
    public void edgeForOutputTransformation(){
        Transformation transformation = new Transformation();
        transformation.addOutput(newBundle());
        assertEquals("Output transformation edge color", MarketEdgeColorTransformer.LIGHT_COLOR, newTransformer().transform(new MarketEdge(transformation, new Good("good"))));
    }

    private MarketEdgeColorTransformer newTransformer() {
        return new MarketEdgeColorTransformer();
    }

    private GoodBundle newBundle() {
        return new GoodBundle(new Good("good"),1);
    }
}
