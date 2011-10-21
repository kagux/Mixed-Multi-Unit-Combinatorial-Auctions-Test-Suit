package com.mmuca.expLab;

import com.mmuca.expLab.ui.BundlesNumDistributionAbstractFactory;
import com.mmuca.expLab.ui.CenteredDistributionFactory;
import com.mmuca.expLab.ui.DistributionFactory;
import com.mmuca.expLab.ui.UniformDistributionFactory;
import com.mmuca.expLab.ui.panels.CenteredDistrPane;
import com.mmuca.expLab.ui.panels.DistributionPane;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BundlesNumDistributionAbstractFactoryTest {

    @Test
    public void uniformDistribution(){
        DistributionPane distributionPaneIsNoNeeded = null;
        assertTrue("uniform distribution factory", factory("uniform", distributionPaneIsNoNeeded) instanceof UniformDistributionFactory);
        assertTrue("panel", factory("uniform", distributionPaneIsNoNeeded).getPanel() == null);
    }

    @Test
    public void centeredDistribution(){
        CenteredDistrPane centeredDistrPane = new CenteredDistrPane();
        DistributionPane panel = when(mock(DistributionPane.class).getCenteredDistrPane()).thenReturn(centeredDistrPane).getMock();
        assertTrue("centered distribution factory", factory("centered", panel) instanceof CenteredDistributionFactory);
        assertTrue("panel", factory("centered", panel).getPanel() == centeredDistrPane);

    }

     private DistributionFactory factory(String distributionName, DistributionPane panel) {
        return new BundlesNumDistributionAbstractFactory().getFactory(distributionName, panel);
    }


}
