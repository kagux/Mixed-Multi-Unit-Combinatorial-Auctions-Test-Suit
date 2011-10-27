package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketGenerator;
import com.mmuca.expLab.domain.Market.MarketGeneratorBuilder;
import com.mmuca.expLab.domain.distributions.*;
import org.junit.Test;

public class MarketGeneratorBuilderTest {
    public static final int NUMBER_OF_LEVELS = 5;
    public static final int NUMBER_OF_GOODS = 10;
    public static final int MINIMUM_NUM_GOODS_PER_LEVEL = 2;
    public static final int NUMBER_OF_IO_TRANSFORMATIONS = 10;

    //not a proper test to be honest, since I dont know how to test private fields for correct distributions and yet I dont feel like
    //making getters just for testing purposes
    @Test
    public void builder(){
        MarketGenerator.Parameters marketParameters = new MarketGenerator.Parameters(
                NUMBER_OF_LEVELS,
                NUMBER_OF_GOODS,
                MINIMUM_NUM_GOODS_PER_LEVEL,
                NUMBER_OF_IO_TRANSFORMATIONS
        );

        IDistribution goodLevelDistribution = new UniformDistribution();
        IDistribution iotLevelDistribution = new UniformDistribution();
        IDistribution inputBundlesGoodLevelDistribution = new MarkovForwardDistribution(0.1,0.1);
        IDistribution outputBundlesGoodLevelDistribution = new MarkovBackwardDistribution(0.1,0.1);
        IDistribution numberOfInputBundlesDistribution = new UniformDistribution();
        IDistribution numberOfOutputBundlesDistribution = new UniformDistribution();

        MarketGenerator.Distributions distributions = new MarketGenerator.Distributions(
                goodLevelDistribution,
                iotLevelDistribution,
                inputBundlesGoodLevelDistribution,
                outputBundlesGoodLevelDistribution,
                numberOfInputBundlesDistribution,
                numberOfOutputBundlesDistribution
        );

        MarketGeneratorBuilder builder = new MarketGeneratorBuilder(marketParameters, distributions);
        MarketGenerator generator = builder.build();
        Market market = generator.nextMarket();
    }

}
