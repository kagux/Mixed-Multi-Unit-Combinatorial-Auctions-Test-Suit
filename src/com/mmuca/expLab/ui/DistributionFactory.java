package com.mmuca.expLab.ui;

import com.mmuca.expLab.domain.distributions.CenteredDistribution;
import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.domain.distributions.UniformDistribution;
import com.mmuca.expLab.ui.panels.CenteredDistrPane;
import com.mmuca.expLab.ui.panels.DistributionPane;

public class DistributionFactory {
    public static IDistribution create(String distributionName) {
        if (isUniform(distributionName))  return new UniformDistribution();
        throw new IllegalArgumentException("Unknown distribution" + distributionName);
    }

    public static IDistribution create(String distributionName, DistributionPane panel) {
        return create(distributionName,panel,0);
    }

    public static IDistribution create(String distributionName, DistributionPane panel, int valueOffset) {
        if (icCentered(distributionName))              return createCenteredDistribution(panel, valueOffset);
        else if (isUniform(distributionName))          return new UniformDistribution();
        throw new IllegalArgumentException("Unknown distribution" + distributionName);
    }

    private static boolean isUniform(String distributionName) {
        return distributionName.toLowerCase().equals("uniform");
    }

    private static boolean icCentered(String distributionName) {
        return distributionName.toLowerCase().equals("centered");
    }

    private static IDistribution createCenteredDistribution(DistributionPane panel, int valueOffset) {
        CenteredDistrPane centeredDistrPane = panel.getCenteredDistrPane();
        int center = Integer.parseInt(centeredDistrPane.getCenterTextField().getText())+valueOffset;
        double alpha = Double.parseDouble(centeredDistrPane.getAlphaTextField().getText());
        return new CenteredDistribution(center,alpha);
    }
}
