/*
 * Created by JFormDesigner on Fri Oct 21 12:27:28 CEST 2011
 */

package com.mmuca.expLab.ui.panels;

import com.jgoodies.forms.factories.Borders;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @author Boris Mikhaylov
 */
public class DistributionPane extends JPanel {
    public final static String UNIFORM_DISTR = "Uniform";
    public final static String CENTERED_DISTR = "Centered";

    public DistributionPane() {
        initComponents();
    }

    public CenteredDistrPane getCenteredDistrPane() {
        return centeredDistrPane;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Boris Mikhaylov
        uniformDistrPane = new JPanel();
        lbInfo = new JLabel();
        centeredDistrPane = new CenteredDistrPane();

        //======== this ========
        setBorder(new CompoundBorder(
            new TitledBorder(" Distribution Options"),
            Borders.DLU2_BORDER));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new CardLayout());

        //======== uniformDistrPane ========
        {
            uniformDistrPane.setLayout(new GridBagLayout());
            ((GridBagLayout)uniformDistrPane.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)uniformDistrPane.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)uniformDistrPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)uniformDistrPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

            //---- lbInfo ----
            lbInfo.setText("The uniform distribution has no additional options");
            uniformDistrPane.add(lbInfo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(uniformDistrPane, "Uniform");
        add(centeredDistrPane, "Centered");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Boris Mikhaylov
    private JPanel uniformDistrPane;
    private JLabel lbInfo;
    private CenteredDistrPane centeredDistrPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
