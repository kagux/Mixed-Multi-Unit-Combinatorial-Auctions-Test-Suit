package com.mmuca.expLab.domain.Market;

import com.mmuca.expLab.domain.Market.goods.GoodsGenerator;
import com.mmuca.expLab.domain.Market.goods.bundles.BundlesGenerator;
import com.mmuca.expLab.domain.Market.transformations.IOTGenerator;
import com.mmuca.expLab.domain.Market.transformations.ITGenerator;
import com.mmuca.expLab.domain.Market.transformations.OTGenerator;
import com.mmuca.expLab.domain.distributions.*;

public class MarketGeneratorBuilder {
    private MarketGenerator.Parameters parameters;
    private Distributions distributions;

    public MarketGeneratorBuilder(MarketGenerator.Parameters marketParameters, Distributions distributions) {
        this.parameters = marketParameters;
        this.distributions = distributions;
    }

    public MarketGenerator build() {
        return new MarketGenerator(
                parameters,
                new GoodsGenerator(distributions.goodLevelDistribution),
                new ITGenerator(),
                new OTGenerator(),
                new IOTGenerator(
                        distributions.iotLevelDistribution,
                        new BundlesGenerator(
                            distributions.inputBundlesGoodLevelDistribution,
                            distributions.numberOfInputBundlesDistribution
                        ),
                        new BundlesGenerator(
                            distributions.outputBundlesGoodLevelDistribution,
                            distributions.numberOfOutputBundlesDistribution
                        )
                )
        );
    }

    public static class Distributions {
        private final IDistribution goodLevelDistribution;
        private final IDistribution iotLevelDistribution;
        private final ITargetedDistribution inputBundlesGoodLevelDistribution;
        private final ITargetedDistribution outputBundlesGoodLevelDistribution;
        private final IDistribution numberOfInputBundlesDistribution;
        private final IDistribution numberOfOutputBundlesDistribution;

        public Distributions(
                IDistribution goodLevelDistribution,
                IDistribution iotLevelDistribution,
                ITargetedDistribution inputBundlesGoodLevelDistribution,
                ITargetedDistribution outputBundlesGoodLevelDistribution,
                IDistribution numberOfInputBundlesDistribution,
                IDistribution numberOfOutputBundlesDistribution
        ) {
            this.goodLevelDistribution = goodLevelDistribution;
            this.iotLevelDistribution = iotLevelDistribution;
            this.inputBundlesGoodLevelDistribution = inputBundlesGoodLevelDistribution;
            this.outputBundlesGoodLevelDistribution = outputBundlesGoodLevelDistribution;
            this.numberOfInputBundlesDistribution = numberOfInputBundlesDistribution;
            this.numberOfOutputBundlesDistribution = numberOfOutputBundlesDistribution;
        }
    }
}
