package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketGenerator;
import com.mmuca.expLab.domain.Market.MarketLevel;
import com.mmuca.expLab.domain.Market.goods.GoodsGenerator;
import com.mmuca.expLab.domain.Market.goods.bundles.BundlesGenerator;
import com.mmuca.expLab.domain.Market.transformations.IOTGenerator;
import com.mmuca.expLab.domain.Market.transformations.ITGenerator;
import com.mmuca.expLab.domain.Market.transformations.OTGenerator;
import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.domain.distributions.ITargetedDistribution;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MarketGeneratorTest {

    public static final int NUMBER_OF_LEVELS = 5;
    public static final int NUMBER_OF_GOODS = 10;
    public static final int MINIMUM_NUM_GOODS_PER_LEVEL = 2;
    public static final int NUMBER_OF_IO_TRANSFORMATIONS = 10;

    @Test
    public void numberOfLevels(){
        assertEquals("# of levels should be as requested", NUMBER_OF_LEVELS, generateDefaultMarket().getAllLevels().size());
    }
    
    @Test
    public void goodsGeneration(){
        GoodsGenerator goodsGenerator = spy(goodsGenerator());
        Market market =  generateMarket(goodsGenerator, itGenerator(), otGenerator(), iotGenerator());
        verify(goodsGenerator).populate(market,NUMBER_OF_GOODS,MINIMUM_NUM_GOODS_PER_LEVEL);
        MarketLevel lastLevel = market.getLevel(NUMBER_OF_LEVELS-1);
        assertEquals("last level should have no goods",0,lastLevel.getAllGoods().size());
    }
    
    @Test
    public void inputTransformationsGeneration(){
        ITGenerator inputTransformationsGenerator = spy(itGenerator()); 
        Market market = generateMarket(goodsGenerator(),inputTransformationsGenerator, otGenerator(), iotGenerator());
        verify(inputTransformationsGenerator).populate(market);
    }

    @Test
    public void outputTransformationsGeneration(){
        OTGenerator outputTransformationsGenerator = spy(otGenerator());
        Market market = generateMarket(goodsGenerator(), itGenerator(),outputTransformationsGenerator, iotGenerator());
        verify(outputTransformationsGenerator).populate(market);
    }

    @Test
    public void ioTransformationsGeneration(){
        IOTGenerator ioTransformationsGenerator = spy(iotGenerator());
        Market market = generateMarket(goodsGenerator(), itGenerator(), otGenerator(),ioTransformationsGenerator);
        verify(ioTransformationsGenerator).populate(market, NUMBER_OF_IO_TRANSFORMATIONS);
    }

    private IOTGenerator iotGenerator() {
        Integer targetLevelIndex=1;
        IDistribution numberOfBundlesDistribution = when(mock(IDistribution.class).nextInt()).thenReturn(1).getMock();
        ITargetedDistribution bundleGoodLevelDistribution = when(mock(ITargetedDistribution.class).nextInt()).thenReturn(targetLevelIndex).getMock();
        BundlesGenerator bundlesGenerator = new BundlesGenerator(bundleGoodLevelDistribution, numberOfBundlesDistribution);
        IDistribution ioTransformationLevelDistribution = when(mock(IDistribution.class).nextInt()).thenReturn(targetLevelIndex).getMock();
        return new IOTGenerator(ioTransformationLevelDistribution, bundlesGenerator,bundlesGenerator);
    }

    private Market generateDefaultMarket() {
        return generateMarket(goodsGenerator(), itGenerator(), otGenerator(), iotGenerator());
    }

    private OTGenerator otGenerator() {
        return new OTGenerator();
    }

    private ITGenerator itGenerator(){
        return new ITGenerator();
    }

    private GoodsGenerator goodsGenerator() {
        return new GoodsGenerator(goodLevelDistribution());
    }

    private Market generateMarket(GoodsGenerator goodsGenerator, ITGenerator itGenerator, OTGenerator otGenerator, IOTGenerator iotGenerator) {
        MarketGenerator.Parameters parameters = new MarketGenerator.Parameters(
                NUMBER_OF_LEVELS,
                NUMBER_OF_GOODS,
                MINIMUM_NUM_GOODS_PER_LEVEL,
                NUMBER_OF_IO_TRANSFORMATIONS
        );
        MarketGenerator generator = new MarketGenerator(parameters,goodsGenerator, itGenerator, otGenerator,iotGenerator);
        return generator.nextMarket();
    }

    private IDistribution goodLevelDistribution() {
        return when(mock(IDistribution.class).nextInt()).thenReturn(0).getMock();
    }


}
