package com.mmuca.expLab.ui;

import com.mmuca.expLab.domain.distributions.*;
import com.mmuca.expLab.ui.panels.CenteredDistrPane;
import com.mmuca.expLab.ui.panels.DistributionPane;
import com.mmuca.expLab.ui.panels.MarkovDistrPanel;

public class DistributionFactory {
    public static IDistribution create(String distributionName) {
        if (isUniform(distributionName))  return new UniformDistribution();
        throw new IllegalArgumentException("Unknown distribution" + distributionName);
    }

    public static IDistribution create(String distributionName, DistributionPane panel) {
        return create(distributionName,panel,0);
    }

    public static IDistribution create(String distributionName, DistributionPane panel, int valueOffset) {
        if (isCentered(distributionName))              return createCenteredDistribution(panel, valueOffset);
        else if (isUniform(distributionName))          return new UniformDistribution();
        else if (isMarkovForward(distributionName))    return createMarkovForwardDistribution(panel);
        else if (isMarkovBackward(distributionName))   return createMarkovBackwardDistribution(panel);
        throw new IllegalArgumentException("Unknown distribution" + distributionName);
    }

    private static boolean isUniform(String distributionName) {
        return distributionName.toLowerCase().equals("uniform");
    }

    private static boolean isCentered(String distributionName) {
        return distributionName.toLowerCase().equals("centered");
    }

    private static boolean  isMarkovForward(String distributionName){
        return distributionName.toLowerCase().equals("markov forward");
    }

    private static boolean  isMarkovBackward(String distributionName){
        return distributionName.toLowerCase().equals("markov backward");
    }

    private static IDistribution createMarkovBackwardDistribution(DistributionPane panel) {
        MarkovDistrPanel markovDistrPanel = panel.getMarkovBackwardDistrPanel();
        return new MarkovBackwardDistribution(pChangeValue(markovDistrPanel), pChangeDirection(markovDistrPanel));
    }

    private static IDistribution createMarkovForwardDistribution(DistributionPane panel) {
        MarkovDistrPanel markovDistrPanel = panel.getMarkovForwardDistrPanel();
        return new MarkovForwardDistribution(pChangeValue(markovDistrPanel), pChangeDirection(markovDistrPanel));
    }

    private static double pChangeDirection(MarkovDistrPanel markovDistrPanel) {
        return Double.parseDouble(markovDistrPanel.getDirectionChangeProbability().getText());
    }

    private static double pChangeValue(MarkovDistrPanel markovDistrPanel) {
        return Double.parseDouble(markovDistrPanel.getValueChangeProbabilityTextField().getText());
    }

    private static IDistribution createCenteredDistribution(DistributionPane panel, int valueOffset) {
        CenteredDistrPane centeredDistrPane = panel.getCenteredDistrPane();
        int center = Integer.parseInt(centeredDistrPane.getCenterTextField().getText())+valueOffset;
        double alpha = Double.parseDouble(centeredDistrPane.getAlphaTextField().getText());
        return new CenteredDistribution(center,alpha);
    }
}
