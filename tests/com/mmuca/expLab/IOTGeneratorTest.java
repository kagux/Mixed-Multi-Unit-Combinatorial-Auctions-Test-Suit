package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketLevel;
import com.mmuca.expLab.domain.Market.collections.GoodBundlesSet;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.BundlesGenerator;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;
import com.mmuca.expLab.domain.Market.transformations.IOTGenerator;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import com.mmuca.expLab.domain.distributions.IDistribution;
import org.junit.Test;
import org.mockito.internal.matchers.InstanceOf;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.*;

public class IOTGeneratorTest {

    public static final int NUMBER_OF_IO_TRANSFORMATIONS = 10;
    public static final int NUMBER_OF_BUNDLES_IN_INPUT_OR_OUTPUT = 4;
    public static final int IOT_LEVEL = 2;

    @Test
    public  void numberOfTransformationsShouldBeAsRequested(){
        assertEquals("number of transformations should be equal to requested", NUMBER_OF_IO_TRANSFORMATIONS, newPopulatedMarket(defaultGenerator(),NUMBER_OF_IO_TRANSFORMATIONS).getAllTransformations().size() );
    }

    @Test
    public void eachTransformationContainsBothInputAndOutput(){
        for(Transformation transformation: newPopulatedMarket(defaultGenerator(), NUMBER_OF_IO_TRANSFORMATIONS).getAllTransformations()){
            assertFalse("transformation should contain input", transformation.getInput().isEmpty());
            assertFalse("transformation should contain output", transformation.getOutput().isEmpty());
        }
    }
    
    @Test
    public void transformationLevelIsSubjectToDistribution(){
        IDistribution levelDistribution = mock(IDistribution.class);
        when(levelDistribution.nextInt()).thenReturn(1,1,2,2);
        IOTGenerator generator = new IOTGenerator(levelDistribution,bundlesGenerator(),bundlesGenerator());
        //first run
        assertEquals("transformations should have levels according to distribution", 2, newPopulatedMarket(generator,2).getLevel(1).getAllTransformations().size());
        assertEquals("levels not mentioned in distribution should not have transformations", 2, newPopulatedMarket(generator, 2).getAllTransformations().size());
        //second run
        assertEquals("transformations should have levels according to distribution", 2, newPopulatedMarket(generator,2).getLevel(2).getAllTransformations().size());
        assertEquals("levels not mentioned in distribution should not have transformations", 2, newPopulatedMarket(generator, 2).getAllTransformations().size());


    }

    @Test
    public void bundlesGeneratorIsUsed(){
        int targetLevelIndex = 1;
        BundlesGenerator inputGenerator = bundlesGenerator();
        BundlesGenerator outputGenerator = bundlesGenerator();
        IOTGenerator generator = new IOTGenerator(IOTLevelDistribution(targetLevelIndex),inputGenerator,outputGenerator);
        Market market = newMarket();
        generator.populate(market,NUMBER_OF_IO_TRANSFORMATIONS);
        verify(inputGenerator,times(NUMBER_OF_IO_TRANSFORMATIONS)).generate(eq(market), anyInt());
        verify(outputGenerator,times(NUMBER_OF_IO_TRANSFORMATIONS)).generate(eq(market), anyInt());
    }

    @Test
    public void forInputBundles_BundlesGeneratorIsTargetingSameLevel(){
        int targetLevelIndex = 2;
        BundlesGenerator inputGenerator = bundlesGenerator();
        IOTGenerator generator = new IOTGenerator(IOTLevelDistribution(targetLevelIndex),inputGenerator,bundlesGenerator());
        generator.populate(newMarket(), NUMBER_OF_IO_TRANSFORMATIONS);
        verify(inputGenerator, atLeastOnce()).generate(anyMarket(), eq(targetLevelIndex));
    }

    @Test
    public void forOutputBundles_BundlesGeneratorIsTargetingPreviousLevel(){
        int targetLevelIndex = 2;
        BundlesGenerator outputGenerator = bundlesGenerator();
        IOTGenerator generator = new IOTGenerator(IOTLevelDistribution(targetLevelIndex),bundlesGenerator(),outputGenerator);
        generator.populate(newMarket(),NUMBER_OF_IO_TRANSFORMATIONS);
        verify(outputGenerator, atLeastOnce()).generate(anyMarket(), eq(targetLevelIndex-1));
    }


    private Market anyMarket() {
        return (Market)argThat(new InstanceOf(Market.class));
    }

    private IOTGenerator defaultGenerator(){
        return new IOTGenerator(IOTLevelDistribution(1), bundlesGenerator(), bundlesGenerator());
    }

    private IDistribution IOTLevelDistribution(int targetLevel) {
        return when( mock(IDistribution.class).nextInt()).thenReturn(targetLevel).getMock();
    }

    private BundlesGenerator bundlesGenerator() {
        GoodBundlesSet bundles = new GoodBundlesSet();
        bundles.add(new GoodBundle(new Good("good 1"),1));
        bundles.add(new GoodBundle(new Good("good 2"),1));
        return when(mock(BundlesGenerator.class).generate(anyMarket(), anyInt())).thenReturn(bundles).getMock();
    }

    private Market newPopulatedMarket(IOTGenerator generator, int numberOfTransformations) {
        Market market  = newMarket();
        generator.populate(market, numberOfTransformations);
        return market;
    }


    private Market newMarket() {
        MarketLevel level_1 = new MarketLevel();
        MarketLevel level_2 = new MarketLevel();
        MarketLevel level_3 = new MarketLevel();
        MarketLevel level_4 = new MarketLevel();

        Good good_1 = new Good("good 1");
        Good good_2 = new Good("good 2");
        Good good_3 = new Good("good 3");
        Good good_4 = new Good("good 4");
        Good good_5 = new Good("good 5");
        Good good_6 = new Good("good 6");
        Good good_7 = new Good("good 7");

        level_1.addGood(good_1);
        level_1.addGood(good_2);

        level_2.addGood(good_3);
        level_2.addGood(good_4);

        level_3.addGood(good_5);
        level_3.addGood(good_6);

        level_4.addGood(good_7);

        Market market= new Market();
        market.addLevel(level_1);
        market.addLevel(level_2);
        market.addLevel(level_3);
        market.addLevel(level_4);
        return market;
    }


}
