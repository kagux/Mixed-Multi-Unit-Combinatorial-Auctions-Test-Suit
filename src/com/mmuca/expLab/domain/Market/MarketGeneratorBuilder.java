package com.mmuca.expLab.domain.Market;

import com.mmuca.expLab.domain.Market.goods.GoodsGenerator;
import com.mmuca.expLab.domain.Market.goods.bundles.BundlesGenerator;
import com.mmuca.expLab.domain.Market.transformations.IOTGenerator;
import com.mmuca.expLab.domain.Market.transformations.ITGenerator;
import com.mmuca.expLab.domain.Market.transformations.OTGenerator;

public class MarketGeneratorBuilder {
    private MarketGenerator.Parameters parameters;
    private MarketGenerator.Distributions distributions;

    public MarketGeneratorBuilder(MarketGenerator.Parameters marketParameters, MarketGenerator.Distributions distributions) {
        this.parameters = marketParameters;
        this.distributions = distributions;
    }

    public MarketGenerator build() {
        return new MarketGenerator(
                parameters,
                new GoodsGenerator(distributions.getGoodLevelDistribution()),
                new ITGenerator(),
                new OTGenerator(),
                new IOTGenerator(
                        distributions.getIOTLevelDistribution(),
                        new BundlesGenerator(
                            distributions.getInputBundlesGoodLevelDistribution(),
                            distributions.getInputBundlesNumDistribution()
                        ),
                        new BundlesGenerator(
                            distributions.getOutputBundlesGoodLevelDistribution(),
                            distributions.getOutputBundlesNumDistribution()
                        )
                )
        );
    }

}
