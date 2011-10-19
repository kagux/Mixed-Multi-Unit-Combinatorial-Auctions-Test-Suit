package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.graphs.MarketVertexShape;
import com.mmuca.expLab.domain.Market.graphs.MarketVertexShapeTransformer;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MarketVertexShapeTransformerTest {

    @Test
    public void vertexForGood(){
        Good good = new Good("good");
        MarketVertexShapeTransformer transformer = new MarketVertexShapeTransformer();
        assertEquals("good's shape", MarketVertexShape.CIRCLE.shape(), transformer.transform(good));
    }

    @Test
    public void vertexForTransformation(){
        Transformation transformation = new Transformation();
        MarketVertexShapeTransformer transformer = new MarketVertexShapeTransformer();
        assertEquals("transformation's vertex", MarketVertexShape.BOX.shape(), transformer.transform(transformation));
    }
}
