package com.mmuca.expLab;

import com.mmuca.expLab.domain.distributions.CenteredDistribution;
import com.mmuca.expLab.ui.BundleNumCenteredDistributionFactory;
import com.mmuca.expLab.ui.panels.CenteredDistrPane;
import org.junit.Test;

import javax.swing.*;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BundlesNumCenteredDistributionFactoryTest {

    @Test
     public void correctCenterValue(){
        assertEquals("center", 1, distribution("1", "0.5").getCenter());
        assertEquals("center", 2, distribution("2", "0.5").getCenter());
        assertEquals("center", 5, distribution("5", "0.5").getCenter());
    }

    @Test
    public void correctAlphaValues(){
       assertEquals("alpha", 0.5, distribution("1", "0.5").getAlpha());
       assertEquals("alpha", 0.6, distribution("1", "0.6").getAlpha());
       assertEquals("alpha", 0.5, distribution("2", "0.5").getAlpha());
       assertEquals("alpha", 0.6, distribution("2", "0.6").getAlpha());
    }

    private CenteredDistribution distribution(String centerValue, String alphaValue) {
        JTextField center = when(mock(JTextField.class).getText()).thenReturn(centerValue).getMock();
        JTextField alpha = when(mock(JTextField.class).getText()).thenReturn(alphaValue).getMock();
        CenteredDistrPane centeredDistrPane = mock(CenteredDistrPane.class);
        when(centeredDistrPane.getCenterTextField()).thenReturn(center);
        when(centeredDistrPane.getAlphaTextField()).thenReturn(alpha);
        return (CenteredDistribution)new BundleNumCenteredDistributionFactory(centeredDistrPane).create();
    }
}
