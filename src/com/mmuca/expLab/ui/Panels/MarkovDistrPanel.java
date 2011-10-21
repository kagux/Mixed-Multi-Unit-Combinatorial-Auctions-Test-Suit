/*
 * Created by JFormDesigner on Fri Oct 21 20:37:53 CEST 2011
 */

package com.mmuca.expLab.ui.panels;

import javax.swing.*;
import java.awt.*;

/**
 * @author Boris Mikhaylov
 */
public class MarkovDistrPanel extends JPanel {
    public MarkovDistrPanel() {
        initComponents();
    }

    public JTextField getValueChangeProbabilityTextField(){
        return tfValueChangeProbability;
    }

    public JTextField getDirectionChangeProbability(){
        return tfDirectionChangeProbability;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Boris Mikhaylov
        lbDirectionChangeProbability = new JLabel();
        tfDirectionChangeProbability = new JTextField();
        lbValueChangeProbability = new JLabel();
        tfValueChangeProbability = new JTextField();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {162, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

        //---- lbDirectionChangeProbability ----
        lbDirectionChangeProbability.setText("Direction Change Probability");
        lbDirectionChangeProbability.setLabelFor(tfDirectionChangeProbability);
        add(lbDirectionChangeProbability, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- tfDirectionChangeProbability ----
        tfDirectionChangeProbability.setText("0.1");
        add(tfDirectionChangeProbability, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- lbValueChangeProbability ----
        lbValueChangeProbability.setText("Skipping Level Probability");
        add(lbValueChangeProbability, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- tfValueChangeProbability ----
        tfValueChangeProbability.setText("0.1");
        add(tfValueChangeProbability, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Boris Mikhaylov
    private JLabel lbDirectionChangeProbability;
    private JTextField tfDirectionChangeProbability;
    private JLabel lbValueChangeProbability;
    private JTextField tfValueChangeProbability;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
