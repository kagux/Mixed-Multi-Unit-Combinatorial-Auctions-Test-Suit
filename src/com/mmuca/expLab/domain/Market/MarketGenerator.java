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
        createLevels(market, parameters.numLevels -1);
        goodsGenerator.populate(market, parameters.numGoods, parameters.minGoodsPerLevel);
        market.addLevel(new MarketLevel());
        inputTransformationsGenerator.populate(market);
        outputTransformationsGenerator.populate(market);
        ioTransformationsGenerator.populate(market,parameters.numIOT);
        return market;
    }

    private void createLevels(Market market, int numberOfLevels) {
        for (int i=0; i< numberOfLevels; i++)
            market.addLevel(new MarketLevel());
    }

    public static class Parameters {
        private int numLevels;
        private int numGoods;
        private int minGoodsPerLevel;
        private int numIOT;
        public Parameters(int numLevels, int numGoods, int minGoodsPerLevel, int numIOT) {
            this.numLevels = numLevels;
            Require.that(numLevels > 2, "there should be at least three levels in the market");
            this.numGoods = numGoods;
            this.minGoodsPerLevel = minGoodsPerLevel;
            this.numIOT = numIOT;
        }
        public int getNumLevels() {
            return numLevels;
        }
        public void setNumLevels(int numLevels) {
            this.numLevels = numLevels;
        }
        public int getNumGoods() {
            return numGoods;
        }
        public void setNumGoods(int numGoods) {
            this.numGoods = numGoods;
        }
        public int getMinGoodsPerLevel() {
            return minGoodsPerLevel;
        }
        public void setMinGoodsPerLevel(int minGoodsPerLevel) {
            this.minGoodsPerLevel = minGoodsPerLevel;
        }
        public int getNumIOT() {
            return numIOT;
        }
        public void setNumIOT(int numIOT) {
            this.numIOT = numIOT;
        }
    }
}
