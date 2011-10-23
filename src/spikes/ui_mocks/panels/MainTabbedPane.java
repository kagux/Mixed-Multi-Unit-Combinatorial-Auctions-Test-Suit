/*
 * Created by JFormDesigner on Mon Oct 17 16:59:53 CEST 2011
 */

package spikes.ui_mocks.panels;

import javax.swing.*;

/**
 * @author Boris Mikhaylov
 */
public class MainTabbedPane extends JTabbedPane {
    public MainTabbedPane() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        marketDesignerPane = new MarketDesignerPane();

        //======== this ========
        addTab("Market Designer", marketDesignerPane);

        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private MarketDesignerPane marketDesignerPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
