package com.mmuca.expLab.domain.Market;

import com.mmuca.expLab.domain.Market.goods.GoodsGenerator;
import com.mmuca.expLab.domain.Market.transformations.IOTGenerator;
import com.mmuca.expLab.domain.Market.transformations.ITGenerator;
import com.mmuca.expLab.domain.Market.transformations.OTGenerator;
import com.mmuca.expLab.domain.Require;
import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.domain.distributions.ITargetedDistribution;

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

    public static class Distributions {
        private IDistribution goodLevel;
        private IDistribution iotLevel;
        private ITargetedDistribution inputBundleGoodLevel;
        private ITargetedDistribution outputBundleGoodLevel;
        private IDistribution inputBundlesNum;
        private IDistribution outputBundlesNum;

        public Distributions(
                IDistribution goodLevel,
                IDistribution iotLevel,
                ITargetedDistribution inputBundleGoodLevel,
                ITargetedDistribution outputBundleGoodLevel,
                IDistribution inputBundlesNum,
                IDistribution outputBundlesNum
        ) {
            this.goodLevel = goodLevel;
            this.iotLevel = iotLevel;
            this.inputBundleGoodLevel = inputBundleGoodLevel;
            this.outputBundleGoodLevel = outputBundleGoodLevel;
            this.inputBundlesNum = inputBundlesNum;
            this.outputBundlesNum = outputBundlesNum;
        }

        public IDistribution getGoodLevel() {
            return goodLevel;
        }

        public void setGoodLevel(IDistribution goodLevel) {
            this.goodLevel = goodLevel;
        }

        public IDistribution getIOTLevelDistribution() {
            return iotLevel;
        }

        public void setIotLevel(IDistribution iotLevel) {
            this.iotLevel = iotLevel;
        }

        public ITargetedDistribution getInputBundleGoodLevel() {
            return inputBundleGoodLevel;
        }

        public void setInputBundleGoodLevel(ITargetedDistribution inputBundleGoodLevel) {
            this.inputBundleGoodLevel = inputBundleGoodLevel;
        }

        public ITargetedDistribution getOutputBundleGoodLevel() {
            return outputBundleGoodLevel;
        }

        public void setOutputBundleGoodLevel(ITargetedDistribution outputBundleGoodLevel) {
            this.outputBundleGoodLevel = outputBundleGoodLevel;
        }

        public IDistribution getInputBundlesNum() {
            return inputBundlesNum;
        }

        public void setInputBundlesNum(IDistribution inputBundlesNum) {
            this.inputBundlesNum = inputBundlesNum;
        }

        public IDistribution getOutputBundlesNum() {
            return outputBundlesNum;
        }

        public void setOutputBundlesNum(IDistribution outputBundlesNum) {
            this.outputBundlesNum = outputBundlesNum;
        }
    }
}
