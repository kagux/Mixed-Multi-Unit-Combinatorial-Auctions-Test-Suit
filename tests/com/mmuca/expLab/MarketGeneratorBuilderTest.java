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

    @Test
    public void builder(){
        MarketGenerator.Parameters parameters = new MarketGenerator.Parameters(
                NUMBER_OF_LEVELS,
                NUMBER_OF_GOODS,
                MINIMUM_NUM_GOODS_PER_LEVEL,
                NUMBER_OF_IO_TRANSFORMATIONS
        );
        IDistribution goodLevelDistribution = new UniformDistribution();
        IDistribution iotLevelDistribution = new UniformDistribution();
        ITargetedDistribution inputBundlesGoodLevelDistribution = new ForwardMarkovDistribution(0.1,0.1);
        ITargetedDistribution outputBundlesGoodLevelDistribution = new BackwardMarkovDistribution(0.1,0.1);
        IDistribution numberOfInputBundlesDistribution = new UniformDistribution();
        IDistribution numberOfOutputBundlesDistribution = new UniformDistribution();

        MarketGeneratorBuilder builder = new MarketGeneratorBuilder(
                parameters,
                goodLevelDistribution,iotLevelDistribution,
                inputBundlesGoodLevelDistribution,
                outputBundlesGoodLevelDistribution,
                numberOfInputBundlesDistribution,
                numberOfOutputBundlesDistribution

                );
        MarketGenerator generator = builder.build();
        Market market = generator.generate();
    }

}
