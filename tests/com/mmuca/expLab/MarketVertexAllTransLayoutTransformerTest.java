package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketLevel;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.graphs.MarketVertexAllTransLayoutTransformer;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static junit.framework.Assert.*;

public class MarketVertexAllTransLayoutTransformerTest {

    @Test
    public void multipleTransformations_MultipleGoods_OneOfEachPerLevel_VerticesPositions(){
        Market market = newMarket(2,1);

        Transformation transformation_1 = new Transformation();
        Transformation transformation_2 = new Transformation();
        market.getLevel(0).addTransformation(transformation_1);
        market.getLevel(1).addTransformation(transformation_2);

        int width = 100;
        int height = 100;
        Dimension size = new Dimension(width, height);

        MarketVertexAllTransLayoutTransformer transformer = new MarketVertexAllTransLayoutTransformer(market, size);

        double verticalGap = 100.0 / 5;

        Point2D firstTransformationPosition = new Point2D.Double(50, verticalGap);
        Point2D secondTransformationPosition = new Point2D.Double(50, verticalGap*3);

        Point2D firstGoodPosition = new Point2D.Double(50,verticalGap*2);
        Point2D secondGoodPosition = new Point2D.Double(50, verticalGap*4);

        assertEquals("position of first transformation", firstTransformationPosition, transformer.transform(transformation_1));
        assertEquals("position of second transformation", secondTransformationPosition, transformer.transform(transformation_2));

        assertEquals("position of first good", firstGoodPosition, transformer.transform(new Good("good 0:0")));
        assertEquals("position of second good", secondGoodPosition, transformer.transform(new Good("good 1:0")));
    }

    @Test
    public void multipleTransformations_MultipleGoods_MultipleOfEachPerLevel_VerticesPositions(){
        Market market = newMarket(1,3);

        Transformation transformation_1 = new Transformation();
        Transformation transformation_2 = new Transformation();
        market.getLevel(0).addTransformation(transformation_1);
        market.getLevel(0).addTransformation(transformation_2);

        int width = 100;
        int height = 100;
        Dimension size = new Dimension(width, height);

        MarketVertexAllTransLayoutTransformer transformer = new MarketVertexAllTransLayoutTransformer(market, size);

        double verticalGap = 100.0 / 3;
        double goodsHorizontalGap = 100.0/4;
        double transformationsHorizontalGap = 100.0/3;

        Point2D firstTransformationPosition = new Point2D.Double(transformationsHorizontalGap, verticalGap);
        Point2D secondTransformationPosition = new Point2D.Double(transformationsHorizontalGap*2, verticalGap);

        Point2D firstGoodPosition = new Point2D.Double(goodsHorizontalGap, verticalGap*2);
        Point2D secondGoodPosition = new Point2D.Double(goodsHorizontalGap*2, verticalGap*2);
        Point2D thirdGoodPosition = new Point2D.Double(goodsHorizontalGap*3, verticalGap*2);

        assertTrue("transformation at first position", firstTransformationPosition.equals(transformer.transform(transformation_1)) || firstTransformationPosition.equals(transformer.transform(transformation_2)));
        assertTrue("transformation at second position", secondTransformationPosition.equals(transformer.transform(transformation_1)) || secondTransformationPosition.equals(transformer.transform(transformation_2)));
        assertFalse("transformations are at different positions", transformer.transform(transformation_1).equals(transformer.transform(transformation_2)));

        assertEquals("position of first good", firstGoodPosition, transformer.transform(new Good("good 0:0")));
        assertEquals("position of second good", secondGoodPosition, transformer.transform(new Good("good 0:1")));
        assertEquals("position of third good", thirdGoodPosition, transformer.transform(new Good("good 0:2")));
    }


    private Market newMarket(int numLevels, int goodsPerLevel) {
        Market market = new Market();
        createLevels(market, numLevels);
        for (int i=0; i<market.getAllLevels().size();i++)
            createGoods(market.getLevel(i),i,goodsPerLevel);
        return market;
    }

    private void createLevels(Market market, int amount) {
        for (int i=0;i<amount;i++)
            market.addLevel(new MarketLevel());
    }

    private void createGoods(MarketLevel level, int levelIndex, int amount){
        for (int i=0;i<amount;i++)
            level.addGood(new Good("good "+levelIndex+":"+i));
    }
}
