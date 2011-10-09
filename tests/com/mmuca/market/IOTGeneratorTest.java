package com.mmuca.market;

import com.mmuca.market.Stubs.StubBundlesDistribution;
import com.mmuca.market.Stubs.StubBundlesGenerator;
import com.mmuca.market.Stubs.StubIOTGoodsLevelDistribution;
import com.mmuca.market.Stubs.StubIOTLevelDistribution;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import static junit.framework.Assert.*;

public class IOTGeneratorTest {

    public static final int NUMBER_OF_IO_TRANSFORMATIONS = 10;
    public static final int NUMBER_OF_BUNDLES_IN_INPUT_OR_OUTPUT = 4;
    public static final int IOT_LEVEL = 2;

    @Test
    public  void numberOfTransformationsShouldBeAsRequested(){
        HashSet<Transformation> transformations = new HashSet<Transformation>();
        for (MarketLevel level : newPopulatedMarket(defaultGenerator()).getAllLevels())
            transformations.addAll(level.getAllTransformations());
        assertEquals("number of transformations should be equal to requested", NUMBER_OF_IO_TRANSFORMATIONS, transformations.size() );
    }

    @Test
    public  void transformationsUseGoodsFromMarket(){
        Market market = newPopulatedMarket(defaultGenerator());
        ArrayList<Good> goods=market.getAllGoods();
        for(Transformation transformation: market.getAllTransformations()){
            for (Iterator<GoodBundle> iterator=transformation.getInput().iterator();iterator.hasNext();) {
               assertTrue("goods should be from market only",goods.contains(iterator.next().getGood()));
            }
        }
    }

    @Test
    public void eachTransformationContainsBothInputAndOutput(){
        for(Transformation transformation: newPopulatedMarket(defaultGenerator()).getAllTransformations()){
            assertFalse("transformation should contain input", transformation.getInput().isEmpty());
            assertFalse("transformation should contain output", transformation.getOutput().isEmpty());
        }
    }
    
    @Test
    public void transformationLevelIsDeterminedByDistribution(){
        //this stub distribution returns fixed value
        StubIOTLevelDistribution levelDistribution = new StubIOTLevelDistribution();
        IOTGenerator generator = new IOTGenerator(levelDistribution, bundlesGenerator(),bundlesGenerator());

        //predefined fixed values for stub distribution
        ArrayList<Integer> levelSerialNumbers = new ArrayList<Integer>();
        levelSerialNumbers.add(1);
        levelSerialNumbers.add(2);

        for (Integer IOTLevel: levelSerialNumbers){
            levelDistribution.setIOTLevel(IOTLevel);
            Market market =  newPopulatedMarket(generator);
            assertEquals("transformations should have levels according to distribution", NUMBER_OF_IO_TRANSFORMATIONS, market.getLevel(IOTLevel).getAllTransformations().size());
            assertEquals("levels not mentioned in distribution should not have transformations", NUMBER_OF_IO_TRANSFORMATIONS, market.getAllTransformations().size());
        }
    }
    
    @Test
    public void bundlesAreFormedByBundlesGenerator(){
        StubBundlesGenerator bundlesGenerator = new StubBundlesGenerator(null,null);
        IOTGenerator generator = new IOTGenerator(IOTLevelDistribution(), bundlesGenerator,bundlesGenerator);
        
        ArrayList<Integer> possibleNumberOfBundles = new ArrayList<Integer>();
        possibleNumberOfBundles.add(1);
        possibleNumberOfBundles.add(2);
        
        ArrayList<Integer> possibleLevelsToPickGoodsFrom = new ArrayList<Integer>();
        possibleLevelsToPickGoodsFrom.add(1);
        possibleLevelsToPickGoodsFrom.add(2);
        
        for(Integer numberOfBundles: possibleNumberOfBundles){
            bundlesGenerator.setNumberOfBundles(numberOfBundles);
            for(Integer levelSerialNumToPickGoodFrom: possibleLevelsToPickGoodsFrom){
                bundlesGenerator.setGoodsLevel(levelSerialNumToPickGoodFrom);
                Market market = newPopulatedMarket(generator);
                for (Transformation transformation : market.getAllTransformations()){
                   assertEquals("number of input bundles should be defined by bundles generator", numberOfBundles.intValue(),transformation.getInput().size());
                   assertEquals("number of output bundles should be defined by bundles generator", numberOfBundles.intValue(),transformation.getOutput().size());

                   ArrayList<Good> goods = market.getLevel(levelSerialNumToPickGoodFrom).getAllGoods();
                   for (Iterator<GoodBundle> iterator=transformation.getInput().iterator();iterator.hasNext();) {
                       assertTrue("Goods for input should be picked by bundles generator",goods.contains(iterator.next().getGood()));
                   }
                   for (Iterator<GoodBundle> iterator=transformation.getOutput().iterator();iterator.hasNext();) {
                       assertTrue("Goods for output should be picked by bundles generator",goods.contains(iterator.next().getGood()));
                   }
                }
            }
        }
    }

    private IOTGenerator defaultGenerator(){
        return new IOTGenerator(IOTLevelDistribution(), bundlesGenerator(), bundlesGenerator());
    }

    private StubIOTLevelDistribution IOTLevelDistribution() {
        return new StubIOTLevelDistribution(IOT_LEVEL);
    }

    private BundlesGenerator bundlesGenerator() {
        return new BundlesGenerator(goodsLevelDistribution(), new StubBundlesDistribution(NUMBER_OF_BUNDLES_IN_INPUT_OR_OUTPUT));
    }

    private StubIOTGoodsLevelDistribution goodsLevelDistribution() {
        return new StubIOTGoodsLevelDistribution();
    }

    private Market newPopulatedMarket(IOTGenerator generator) {
        Market market  = newMarket();
        generator.populate(market, NUMBER_OF_IO_TRANSFORMATIONS);
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
        market.add(level_1);
        market.add(level_2);
        market.add(level_3);
        market.add(level_4);
        return market;
    }


}
