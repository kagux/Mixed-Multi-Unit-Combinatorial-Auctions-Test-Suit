package com.mmuca.expLab.domain.Market;

import com.mmuca.expLab.domain.Market.goods.GoodsGenerator;
import com.mmuca.expLab.domain.Market.goods.bundles.BundlesGenerator;
import com.mmuca.expLab.domain.Market.transformations.IOTGenerator;
import com.mmuca.expLab.domain.Market.transformations.ITGenerator;
import com.mmuca.expLab.domain.Market.transformations.OTGenerator;
import com.mmuca.expLab.domain.distributions.*;

public class MarketGeneratorBuilder {
    private MarketGenerator.Parameters parameters;
    private IDistribution goodLevelDistribution;
    private IDistribution iotLevelDistribution;
    private ITargetedDistribution inputBundlesGoodLevelDistribution;
    private ITargetedDistribution outputBundlesGoodLevelDistribution;
    private IDistribution numberOfInputBundlesDistribution;
    private IDistribution numberOfOutputBundlesDistribution;

    public MarketGeneratorBuilder(
            MarketGenerator.Parameters parameters,
            IDistribution goodLevelDistribution,
            IDistribution iotLevelDistribution,
            ITargetedDistribution inputBundlesGoodLevelDistribution,
            ITargetedDistribution outputBundlesGoodLevelDistribution,
            IDistribution numberOfInputBundlesDistribution,
            IDistribution numberOfOutputBundlesDistribution
    ) {
        this.parameters = parameters;
        this.goodLevelDistribution = goodLevelDistribution;
        this.iotLevelDistribution = iotLevelDistribution;
        this.inputBundlesGoodLevelDistribution = inputBundlesGoodLevelDistribution;
        this.outputBundlesGoodLevelDistribution = outputBundlesGoodLevelDistribution;
        this.numberOfInputBundlesDistribution = numberOfInputBundlesDistribution;
        this.numberOfOutputBundlesDistribution = numberOfOutputBundlesDistribution;
    }

    public MarketGenerator build() {
        return new MarketGenerator(
                parameters,
                new GoodsGenerator(goodLevelDistribution),
                new ITGenerator(),
                new OTGenerator(),
                new IOTGenerator(
                        iotLevelDistribution,
                        new BundlesGenerator(
                              inputBundlesGoodLevelDistribution,
                              numberOfInputBundlesDistribution
                        ),
                        new BundlesGenerator(
                            outputBundlesGoodLevelDistribution,
                            numberOfOutputBundlesDistribution
                        )
                )
        );
    }
}
