package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;
import com.mmuca.expLab.domain.Market.graphs.MarketVertex;
import com.mmuca.expLab.domain.Market.graphs.MarketVertexColorTransformer;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MarketVertexColorTransformerTest {
    @Test
    public void vertexForGood(){
        Good good = new Good("good");
        assertEquals("color of good vertex", MarketVertex.GOOD.color(), newTransformer().transform(good));
    }

    private MarketVertexColorTransformer newTransformer() {
        return new MarketVertexColorTransformer();
    }

    @Test
    public void vertexForIOTransformation(){
        Transformation transformation = new Transformation();
        transformation.addInput(newBundle());
        transformation.addOutput(newBundle());
        assertEquals("color of transformation vertex", MarketVertex.IOT_TRANSFORMATION.color(), newTransformer().transform(transformation));

    }

    @Test
    public void vertexForInputOnlyTransformations(){
        Transformation transformation = new Transformation();
        transformation.addInput(newBundle());
        assertEquals("color of input transformation vertex",MarketVertex.DEFAULT_TRANSFORMATION.color(), newTransformer().transform(transformation));
    }
    @Test
    public void vertexForOutputOnlyTransformations(){
        Transformation transformation = new Transformation();
        transformation.addOutput(newBundle());
        assertEquals("color of output transformation vertex", MarketVertex.DEFAULT_TRANSFORMATION.color(), newTransformer().transform(transformation));
    }

    private GoodBundle newBundle() {
        return new GoodBundle(new Good("good"),1);
    }
}
