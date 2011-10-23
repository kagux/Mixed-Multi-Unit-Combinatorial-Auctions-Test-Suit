package spikes.ui_mocks;

import com.mmuca.expLab.domain.distributions.*;
import spikes.ui_mocks.panels.CenteredDistrPane;
import spikes.ui_mocks.panels.DistributionPane;
import spikes.ui_mocks.panels.MarkovDistrPanel;

public class DistributionFactory {
    public static IDistribution create(Distribution distribution) {
        if (isUniform(distribution))  return new UniformDistribution();
        throw new IllegalArgumentException("Unknown distribution" + distribution);
    }

    public static IDistribution create(Distribution distribution, DistributionPane panel) {
        return create(distribution,panel,0);
    }

    public static IDistribution create(Distribution distribution, DistributionPane panel, int valueOffset) {
        if (isCentered(distribution))              return createCenteredDistribution(panel, valueOffset);
        else if (isUniform(distribution))          return new UniformDistribution();
        else if (isMarkovForward(distribution))    return createMarkovForwardDistribution(panel);
        else if (isMarkovBackward(distribution))   return createMarkovBackwardDistribution(panel);
        throw new IllegalArgumentException("Unknown distribution" + distribution);
    }

    private static boolean isUniform(Distribution distribution) {
        return distribution == Distribution.UNIFORM;
    }

    private static boolean isCentered(Distribution distribution) {
        return Distribution.CENTERED == distribution;
    }

    private static boolean  isMarkovForward(Distribution distribution){
        return Distribution.MARKOV_FORWARD == distribution;
    }

    private static boolean  isMarkovBackward(Distribution distribution){
        return Distribution.MARKOV_BACKWARD == distribution;
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
