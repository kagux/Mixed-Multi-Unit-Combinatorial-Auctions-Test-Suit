package com.mmuca.expLab;

import com.mmuca.expLab.domain.distributions.CenteredDistribution;
import com.mmuca.expLab.domain.distributions.UniformDistribution;
import com.mmuca.expLab.ui.DistributionFactory;
import com.mmuca.expLab.ui.panels.CenteredDistrPane;
import com.mmuca.expLab.ui.panels.DistributionPane;
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
