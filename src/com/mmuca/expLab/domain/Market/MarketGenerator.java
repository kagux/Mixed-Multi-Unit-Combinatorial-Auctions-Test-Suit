package com.mmuca.expLab.domain.Market;

import com.mmuca.expLab.domain.Market.goods.GoodsGenerator;
import com.mmuca.expLab.domain.Market.transformations.IOTGenerator;
import com.mmuca.expLab.domain.Market.transformations.ITGenerator;
import com.mmuca.expLab.domain.Market.transformations.OTGenerator;
import com.mmuca.expLab.domain.Require;

public class MarketGenerator {
    private Parameters parameters;
    private GoodsGenerator goodsGenerator;
    private ITGenerator inputTransformationsGenerator;
    private OTGenerator outputTransformationsGenerator;
    private IOTGenerator ioTransformationsGenerator;

    public MarketGenerator(Parameters parameters,GoodsGenerator goodsGenerator, ITGenerator itGenerator, OTGenerator otGenerator, IOTGenerator iotGenerator) {
        this.parameters = parameters;
        this.goodsGenerator = goodsGenerator;
        this.inputTransformationsGenerator = itGenerator;
        this.outputTransformationsGenerator = otGenerator;
        this.ioTransformationsGenerator = iotGenerator;
    }

    public Market nextMarket() {
        Market market = new Market();
        createLevels(market, parameters.numberOfLevels-1);
        goodsGenerator.populate(market, parameters.numberOfGoodsToCreate, parameters.minimumGoodsPerLevel);
        market.addLevel(new MarketLevel());
        inputTransformationsGenerator.populate(market);
        outputTransformationsGenerator.populate(market);
        ioTransformationsGenerator.populate(market,parameters.numberOfIOTransformations);
        return market;
    }

    private void createLevels(Market market, int numberOfLevels) {
        for (int i=0; i< numberOfLevels; i++)
            market.addLevel(new MarketLevel());
    }

    public static class Parameters {
        private final int numberOfLevels;

        private final int numberOfGoodsToCreate;

        private final int minimumGoodsPerLevel;
        private final int numberOfIOTransformations;
        public Parameters(int numberOfLevels, int numberOfGoodsToCreate, int minimumGoodsPerLevel, int numberOfIOTransformations) {
            this.numberOfLevels = numberOfLevels;
            Require.that(numberOfLevels > 2, "there should be at least three levels in the market");
            this.numberOfGoodsToCreate = numberOfGoodsToCreate;
            this.minimumGoodsPerLevel = minimumGoodsPerLevel;
            this.numberOfIOTransformations = numberOfIOTransformations;
        }
        public int getNumberOfLevels() {
            return numberOfLevels;
        }
        public int getNumberOfGoodsToCreate() {
            return numberOfGoodsToCreate;
        }
        public int getMinimumGoodsPerLevel() {
            return minimumGoodsPerLevel;
        }
        public int getNumberOfIOTransformations() {
            return numberOfIOTransformations;
        }
    }
}
