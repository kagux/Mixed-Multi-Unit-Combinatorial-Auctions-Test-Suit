package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.graphs.MarketVertexColorTransformer;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import org.junit.Test;

import java.awt.*;

import static junit.framework.Assert.assertEquals;

public class MarketVertexColorTransformerTest {
    @Test
    public void vertexForGood(){
        Good good = new Good("good");
        MarketVertexColorTransformer transformer = new MarketVertexColorTransformer();
        assertEquals("color of good vertex", Color.YELLOW, transformer.transform(good));
    }

    @Test
    public void vertexForTransformation(){
        Transformation transformation = new Transformation();
        MarketVertexColorTransformer transformer = new MarketVertexColorTransformer();
        assertEquals("color of transformation vertex", Color.LIGHT_GRAY, transformer.transform(transformation));

    }
}
