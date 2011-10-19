package com.mmuca.expLab.domain.Market.graphs;

import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import com.mmuca.expLab.domain.Require;
import org.apache.commons.collections15.Transformer;

import java.awt.*;

public class MarketVertexColorTransformer implements Transformer<Object, Paint>{
    @Override
    public Paint transform(Object o) {
        Require.that(o instanceof Good || o instanceof Transformation, "vertex needs to be either good or transformation");
        if (o instanceof  Good)
            return Color.YELLOW;
        else
            return Color.LIGHT_GRAY;
    }
}
