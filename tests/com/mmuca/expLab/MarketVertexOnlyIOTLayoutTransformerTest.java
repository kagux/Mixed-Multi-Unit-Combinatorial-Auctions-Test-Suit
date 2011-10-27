package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketLevel;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;
import com.mmuca.expLab.domain.Market.graphs.MarketVertexOnlyIOTLayoutTransformer;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

///MarketVertexOnlyIOTLayoutTransformer
public class MarketVertexOnlyIOTLayoutTransformerTest {

    @Test
    public void onlyIOT_VerticalAndHorizontalPositions_ShouldBeCalculatedOnlyForIOT(){
        Market market = newMarket(1,1);

        Transformation ioTransformation_1 = ioTransformation();
        Transformation ioTransformation_2 = ioTransformation();
        Transformation inputTransformation = inputTransformation();
        Transformation outputTransformation = outputTransformation();

        market.getLevel(0).addTransformation(ioTransformation_1);
        market.getLevel(0).addTransformation(ioTransformation_2);
        market.getLevel(0).addTransformation(inputTransformation);
        market.getLevel(0).addTransformation(outputTransformation);

        int width = 100;
        int height = 100;
        Dimension size = new Dimension(width, height);

        MarketVertexOnlyIOTLayoutTransformer transformer = new MarketVertexOnlyIOTLayoutTransformer(market, size);

        double verticalGap = 100.0 / 3;
        double transformationsHorizontalGap = 100.0/3;

        Point2D firstTransformationPosition = new Point2D.Double(transformationsHorizontalGap, verticalGap);
        Point2D secondTransformationPosition = new Point2D.Double(transformationsHorizontalGap*2, verticalGap);

        assertTrue("transformation at first position", firstTransformationPosition.equals(transformer.transform(ioTransformation_1)) || firstTransformationPosition.equals(transformer.transform(ioTransformation_2)));
        assertTrue("transformation at second position", secondTransformationPosition.equals(transformer.transform(ioTransformation_1)) || secondTransformationPosition.equals(transformer.transform(ioTransformation_2)));
        assertFalse("transformations are at different positions", transformer.transform(ioTransformation_1).equals(transformer.transform(ioTransformation_2)));
    }

    @Test
    public void onlyIOT_Scaling_ScaleShouldBeTakenIntoAccount(){
        Market market = newMarket(1,1);
        Transformation transformation_1 = ioTransformation();
        Transformation transformation_2 = ioTransformation();
        market.getLevel(0).addTransformation(transformation_1);
        market.getLevel(0).addTransformation(transformation_2);

        int width=100;
        int height=100;
        double scale=0.8;
        Dimension size = new Dimension(width, height);
        MarketVertexOnlyIOTLayoutTransformer transformer = new MarketVertexOnlyIOTLayoutTransformer(market, size, scale);

        ArrayList<Point2D> expectedPositions = new ArrayList<Point2D>();
        double scalingOffset = 100 * (1-0.8) / 2;
        double horizontalOffset = 80.0 / 3;
        double verticalOffset = 80.0 / 3;
        expectedPositions.add(new Point2D.Double(horizontalOffset + scalingOffset, verticalOffset + scalingOffset));
        expectedPositions.add(new Point2D.Double(horizontalOffset*2+scalingOffset,verticalOffset+scalingOffset));

        ArrayList<Point2D> actualPositions = new ArrayList<Point2D>();
        actualPositions.add(transformer.transform(transformation_1));
        actualPositions.add(transformer.transform(transformation_2));

        assertTrue("positions should take scaling into account", expectedPositions.containsAll(actualPositions));
    }

    private Transformation outputTransformation() {
        Transformation outputTransformation = new Transformation();
        outputTransformation.addOutput(newBundle());
        return outputTransformation;
    }

    private Transformation inputTransformation() {
        Transformation inputTransformation = new Transformation();
        inputTransformation.addInput(newBundle());
        return inputTransformation;
    }

    private Transformation ioTransformation() {
        Transformation ioTransformation = new Transformation();
        ioTransformation.addInput(newBundle());
        ioTransformation.addOutput(newBundle());
        return ioTransformation;
    }

    private GoodBundle newBundle() {
        return new GoodBundle(new Good("good"),1);
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
