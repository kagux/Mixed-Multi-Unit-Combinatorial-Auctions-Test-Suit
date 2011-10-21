/*
 * Created by JFormDesigner on Fri Oct 21 12:39:57 CEST 2011
 */

package com.mmuca.expLab.ui.panels;

import javax.swing.*;
import java.awt.*;

/**
 * @author Boris Mikhaylov
 */
public class CenteredDistrPane extends JPanel {
    public CenteredDistrPane() {
        initComponents();
    }

    public JTextField getCenterTextField(){
        return tfCenter;
    }

    public  JTextField getAlphaTextField(){
        return tfAlpha;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbCenter = new JLabel();
        tfCenter = new JTextField();
        lbAlpha = new JLabel();
        tfAlpha = new JTextField();

        //======== this ========
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {150, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

        //---- lbCenter ----
        lbCenter.setText("Center");
        lbCenter.setLabelFor(tfCenter);
        add(lbCenter, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- tfCenter ----
        tfCenter.setText("1");
        add(tfCenter, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- lbAlpha ----
        lbAlpha.setText("Shape Factor");
        lbAlpha.setLabelFor(tfAlpha);
        add(lbAlpha, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- tfAlpha ----
        tfAlpha.setText("0.5");
        add(tfAlpha, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbCenter;
    private JTextField tfCenter;
    private JLabel lbAlpha;
    private JTextField tfAlpha;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
