/*
 * Created by JFormDesigner on Mon Oct 17 17:19:31 CEST 2011
 */

package com.mmuca.expLab.ui.panels;

import com.mmuca.expLab.ui.actions.GenerateMarketAction;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * @author Boris Mikhaylov
 */
public class MarketDesignerPane extends JPanel {
    public MarketDesignerPane() {
        initComponents();
    }

    public JTextField getNumOfLevelsTextField() {
        return tfNumberOfLevels;
    }

    public JTextField getNumOfGoodsTextField() {
        return tfNumberOfGoods;
    }

    public JTextField getNumOfTransformationsTextField() {
        return tfNumberOfTransformations;
    }

    public JTextField getMinNumOfGoodsPerLevelTextField() {
        return tfMinNumberOfGoodsPerLevel;
    }

    private void createUIComponents() {
         generateMarketAction = new GenerateMarketAction(this);
    }

    public JPanel getMarketGraphPane() {
        return marketGraphPane;
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Boris Mikhaylov
        createUIComponents();
        marketConfigPane = new JPanel();
        lbNumberOfLevels = new JLabel();
        tfNumberOfLevels = new JTextField();
        lbNumberOfGoods = new JLabel();
        tfNumberOfGoods = new JTextField();
        lbMinNumberOfGoodsPerLevel = new JLabel();
        tfMinNumberOfGoodsPerLevel = new JTextField();
        lbNumberOfTransformations = new JLabel();
        tfNumberOfTransformations = new JTextField();
        btnGenerateMarket = new JButton();
        marketGraphPane = new JPanel();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {232, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {498, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

        //======== marketConfigPane ========
        {
            marketConfigPane.setBorder(new EtchedBorder());
            marketConfigPane.setLayout(new GridBagLayout());
            ((GridBagLayout)marketConfigPane.getLayout()).columnWidths = new int[] {76, 53, 0};
            ((GridBagLayout)marketConfigPane.getLayout()).rowHeights = new int[] {27, 23, 0, 0, 0, 0};
            ((GridBagLayout)marketConfigPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
            ((GridBagLayout)marketConfigPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};

            //---- lbNumberOfLevels ----
            lbNumberOfLevels.setText("# Levels");
            marketConfigPane.add(lbNumberOfLevels, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- tfNumberOfLevels ----
            tfNumberOfLevels.setText("3");
            marketConfigPane.add(tfNumberOfLevels, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- lbNumberOfGoods ----
            lbNumberOfGoods.setText("# Goods");
            marketConfigPane.add(lbNumberOfGoods, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- tfNumberOfGoods ----
            tfNumberOfGoods.setText("6");
            marketConfigPane.add(tfNumberOfGoods, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- lbMinNumberOfGoodsPerLevel ----
            lbMinNumberOfGoodsPerLevel.setText("Min # Goods Per Level");
            marketConfigPane.add(lbMinNumberOfGoodsPerLevel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- tfMinNumberOfGoodsPerLevel ----
            tfMinNumberOfGoodsPerLevel.setText("2");
            marketConfigPane.add(tfMinNumberOfGoodsPerLevel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- lbNumberOfTransformations ----
            lbNumberOfTransformations.setText("# Transformations");
            marketConfigPane.add(lbNumberOfTransformations, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- tfNumberOfTransformations ----
            tfNumberOfTransformations.setText("2");
            marketConfigPane.add(tfNumberOfTransformations, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- btnGenerateMarket ----
            btnGenerateMarket.setVerticalAlignment(SwingConstants.BOTTOM);
            btnGenerateMarket.setAction(generateMarketAction);
            btnGenerateMarket.setText("Generate New Market");
            marketConfigPane.add(btnGenerateMarket, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(marketConfigPane, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //======== marketGraphPane ========
        {
            marketGraphPane.setLayout(new BorderLayout());
        }
        add(marketGraphPane, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- generateMarketAction ----
        generateMarketAction.putValue(Action.NAME, "Generate");
        generateMarketAction.putValue(Action.SHORT_DESCRIPTION, "Generates New Market ");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Boris Mikhaylov
    private JPanel marketConfigPane;
    private JLabel lbNumberOfLevels;
    private JTextField tfNumberOfLevels;
    private JLabel lbNumberOfGoods;
    private JTextField tfNumberOfGoods;
    private JLabel lbMinNumberOfGoodsPerLevel;
    private JTextField tfMinNumberOfGoodsPerLevel;
    private JLabel lbNumberOfTransformations;
    private JTextField tfNumberOfTransformations;
    private JButton btnGenerateMarket;
    private JPanel marketGraphPane;
    private GenerateMarketAction generateMarketAction;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
