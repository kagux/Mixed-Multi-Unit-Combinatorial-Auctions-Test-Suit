package com.mmuca.expLab;

import com.mmuca.expLab.domain.distributions.MarkovBackwardDistribution;
import com.mmuca.expLab.domain.distributions.CenteredDistribution;
import com.mmuca.expLab.domain.distributions.MarkovForwardDistribution;
import com.mmuca.expLab.domain.distributions.UniformDistribution;
import com.mmuca.expLab.ui.DistributionFactory;
import com.mmuca.expLab.ui.panels.CenteredDistrPane;
import com.mmuca.expLab.ui.panels.DistributionPane;
import com.mmuca.expLab.ui.panels.MarkovDistrPanel;
import org.junit.Test;

import javax.swing.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DistributionFactoryTest {

    @Test
    public void uniformDistribution(){
        assertTrue("uniform centeredDistribution", DistributionFactory.create("uniform") instanceof UniformDistribution);
        DistributionPane noPanel = null;
        assertTrue("uniform centeredDistribution", DistributionFactory.create("uniform", noPanel) instanceof UniformDistribution);
    }

    @Test
    public void centeredDistribution_noInputOffset_CenterValueIsEqualToProvided(){
        int noValueOffset = 0;
        assertEquals("center value", 1, centeredDistribution("1", "0.5", noValueOffset).getCenter());
       assertEquals("center value", 2, centeredDistribution("2", "0.5", noValueOffset).getCenter());
       assertEquals("center value", 3, centeredDistribution("3", "0.5", noValueOffset).getCenter());
    }

    @Test
    public void centeredDistribution_inputOffset_CenterValueIsOffsetCorrectly(){
       assertEquals("center value", 2, centeredDistribution("1", "0.5",1).getCenter());
       assertEquals("center value", 3, centeredDistribution("1", "0.5",2).getCenter());
       assertEquals("center value", 4, centeredDistribution("1", "0.5",3).getCenter());
    }

    @Test
    public void centeredDistribution_AlphaValueAlwaysEqualsToProvidedRegardlessOfValueOffset(){
        assertEquals("alpha value", 0.5, centeredDistribution("1","0.5",0).getAlpha());
        assertEquals("alpha value", 0.5, centeredDistribution("1","0.5",1).getAlpha());
        assertEquals("alpha value", 0.5, centeredDistribution("1","0.5",2).getAlpha());
        assertEquals("alpha value", 0.6, centeredDistribution("1","0.6",0).getAlpha());
        assertEquals("alpha value", 0.7, centeredDistribution("1","0.7",0).getAlpha());
    }

    @Test
    public void markovForwardDistribution_ValueChangeProbabilityIsCorrect(){
        assertEquals("value change probability", 0.1, markovForwardDistribution("0.1","1").getChangeValueProbability());
        assertEquals("value change probability", 0.2, markovForwardDistribution("0.2","1").getChangeValueProbability());
        assertEquals("value change probability", 0.3, markovForwardDistribution("0.3","1").getChangeValueProbability());

    }
    @Test
    public void markovForwardDistribution_DirectionChangeProbabilityIsCorrect(){
        assertEquals("value change probability", 0.1, markovForwardDistribution("1","0.1").getChangeDirectionProbability());
        assertEquals("value change probability", 0.2, markovForwardDistribution("1","0.2").getChangeDirectionProbability());
        assertEquals("value change probability", 0.4, markovForwardDistribution("1","0.4").getChangeDirectionProbability());

    }

    @Test
    public void markovBackwardDistribution_ValueChangeProbabilityIsCorrect(){
        assertEquals("value change probability", 0.1, markovBackwardDistribution("0.1","1").getChangeValueProbability());
        assertEquals("value change probability", 0.2, markovBackwardDistribution("0.2","1").getChangeValueProbability());
        assertEquals("value change probability", 0.3, markovBackwardDistribution("0.3","1").getChangeValueProbability());

    }
    @Test
    public void markovBackwardDistribution_DirectionChangeProbabilityIsCorrect(){
        assertEquals("value change probability", 0.1, markovBackwardDistribution("1","0.1").getChangeDirectionProbability());
        assertEquals("value change probability", 0.2, markovBackwardDistribution("1","0.2").getChangeDirectionProbability());
        assertEquals("value change probability", 0.4, markovBackwardDistribution("1","0.4").getChangeDirectionProbability());

    }

    private MarkovForwardDistribution markovForwardDistribution(String pValueChange, String pDirectionChange) {
        MarkovDistrPanel markovDistrPanel = markovDistrPanel(pValueChange, pDirectionChange);
        DistributionPane distributionPanel = when(mock(DistributionPane.class).getMarkovForwardDistrPanel()).thenReturn(markovDistrPanel).getMock();
        return (MarkovForwardDistribution) DistributionFactory.create("Markov Forward", distributionPanel);
    }
    private MarkovBackwardDistribution markovBackwardDistribution(String pValueChange, String pDirectionChange) {
        MarkovDistrPanel markovDistrPanel = markovDistrPanel(pValueChange, pDirectionChange);
        DistributionPane distributionPanel = when(mock(DistributionPane.class).getMarkovBackwardDistrPanel()).thenReturn(markovDistrPanel).getMock();
        return (MarkovBackwardDistribution) DistributionFactory.create("Markov Backward", distributionPanel);
    }

    private MarkovDistrPanel markovDistrPanel(String pValueChange, String pDirectionChange) {
        JTextField tfPValueChange = when(mock(JTextField.class).getText()).thenReturn(pValueChange).getMock();
        JTextField tfPDirectionChange = when(mock(JTextField.class).getText()).thenReturn(pDirectionChange).getMock();
        MarkovDistrPanel markovDistrPanel = mock(MarkovDistrPanel.class);
        when(markovDistrPanel.getDirectionChangeProbability()).thenReturn(tfPDirectionChange);
        when(markovDistrPanel.getValueChangeProbabilityTextField()).thenReturn(tfPValueChange);
        return markovDistrPanel;
    }


    private CenteredDistribution centeredDistribution(String centerValue, String alphaValue, int valueOffset) {
        JTextField center = when(mock(JTextField.class).getText()).thenReturn(centerValue).getMock();
        JTextField alpha = when(mock(JTextField.class).getText()).thenReturn(alphaValue).getMock();
        CenteredDistrPane centeredDistrPane = mock(CenteredDistrPane.class);
        when(centeredDistrPane.getCenterTextField()).thenReturn(center);
        when(centeredDistrPane.getAlphaTextField()).thenReturn(alpha);
        DistributionPane distributionPanel = when(mock(DistributionPane.class).getCenteredDistrPane()).thenReturn(centeredDistrPane).getMock();
        return (CenteredDistribution) DistributionFactory.create("centered", distributionPanel, valueOffset);
    }
}
