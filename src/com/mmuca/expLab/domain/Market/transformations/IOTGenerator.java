package com.mmuca.expLab.domain.Market.transformations;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.goods.bundles.BundlesGenerator;
import com.mmuca.expLab.domain.Require;
import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.domain.distributions.ValueRange;

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
        levelDistribution.setValueRange(new ValueRange(1,market.getAllLevels().size()-2));
        for (int i=0; i<numberOfIOTransformations; i++){
            addTransformation(market);
        }
    }

    private void addTransformation(Market market) {
        int levelSerialNumber = levelDistribution.nextInt();
        Transformation transformation = new Transformation();
        transformation.addAllOutput(outputBundlesGenerator.generate(market, levelSerialNumber-1));
        transformation.addAllInput(inputBundlesGenerator.generate(market, levelSerialNumber));
        market.getLevel(levelSerialNumber).addTransformation(transformation);
    }

}
