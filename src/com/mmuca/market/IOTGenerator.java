package com.mmuca.market;

import com.mmuca.market.distributions.IDistribution;

public class IOTGenerator {
    private IDistribution levelDistribution;
    private BundlesGenerator inputBundlesGenerator;
    private BundlesGenerator outputBundlesGenerator;


    public IOTGenerator(IDistribution levelDistribution, BundlesGenerator inputBundlesGenerator, BundlesGenerator outputBundlesGenerator) {
        this.levelDistribution = levelDistribution;
        this.inputBundlesGenerator = inputBundlesGenerator;
        this.outputBundlesGenerator = outputBundlesGenerator;
    }

    public void populate(Market market, int numberOfIOTransformations) {
        for (int i=0; i<numberOfIOTransformations; i++){
            addTransformation(market);
        }
    }

    private void addTransformation(Market market) {
        int levelSerialNumber = levelDistribution.flipCoin();
        Transformation transformation = new Transformation();
        transformation.addAllOutput(outputBundlesGenerator.generate(market, levelSerialNumber));
        transformation.addAllInput(inputBundlesGenerator.generate(market, levelSerialNumber));
        market.getLevel(levelSerialNumber).addTransformation(transformation);
    }

}
