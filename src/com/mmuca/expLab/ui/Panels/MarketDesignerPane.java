/*
 * Created by JFormDesigner on Mon Oct 17 17:19:31 CEST 2011
 */

package com.mmuca.expLab.ui.panels;

import com.mmuca.expLab.ui.actions.GenerateMarketAction;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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

    public JCheckBox getOnlyIOTransformationsCheckBox(){
        return chkOnlyIOTransformations;
    }

    public JComboBox getGoodsLevelDistrComboBox(){
        return cbGoodsLevelDistr;
    }

    private void createUIComponents() {
         generateMarketAction = new GenerateMarketAction(this);
    }

    public JPanel getMarketGraphPane() {
        return marketGraphPane;
    }

    private void cbGoodsLevelDistrItemStateChanged(ItemEvent e) {
        CardLayout layout = (CardLayout) goodsLevelDistrPane.getLayout();
        layout.show(goodsLevelDistrPane, (String)e.getItem());
    }

    public DistributionPane getGoodsLevelDistrPanel() {
        return goodsLevelDistrPane;
    }

    public DistributionPane getBundlesNumDistrPanel() {
        return bundlesNumDistrPanel;
    }

    public JComboBox getBundlesNumDistrComboBox(){
         return cbBundlesNumDistr;
    }

    private void cbBundlesNumDistrItemStateChanged(ItemEvent e) {
        CardLayout layout = (CardLayout) bundlesNumDistrPanel.getLayout();
        layout.show(bundlesNumDistrPanel, (String)e.getItem());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Boris Mikhaylov
        createUIComponents();
        scrollPane2 = new JScrollPane();
        marketConfigPane = new JPanel();
        lbNumberOfLevels = new JLabel();
        tfNumberOfLevels = new JTextField();
        lbNumberOfGoods = new JLabel();
        tfNumberOfGoods = new JTextField();
        lbMinNumberOfGoodsPerLevel = new JLabel();
        tfMinNumberOfGoodsPerLevel = new JTextField();
        lbNumberOfTransformations = new JLabel();
        tfNumberOfTransformations = new JTextField();
        chkOnlyIOTransformations = new JCheckBox();
        separator1 = new JSeparator();
        lbGoodLevelDistr = new JLabel();
        cbGoodsLevelDistr = new JComboBox();
        goodsLevelDistrPane = new DistributionPane();
        lbBundlesNumDistr = new JLabel();
        cbBundlesNumDistr = new JComboBox();
        bundlesNumDistrPanel = new DistributionPane();
        btnGenerateMarket = new JButton();
        marketGraphPane = new JPanel();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("border".equals(e.getPropertyName())) throw new RuntimeException();
            }
        });

        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 332, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 503, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

        //======== scrollPane2 ========
        {
            scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            //======== marketConfigPane ========
            {
                marketConfigPane.setBorder(new EtchedBorder());
                marketConfigPane.setLayout(new GridBagLayout());
                ((GridBagLayout)marketConfigPane.getLayout()).columnWidths = new int[] {76, 53, 0};
                ((GridBagLayout)marketConfigPane.getLayout()).rowHeights = new int[] {27, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)marketConfigPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
                ((GridBagLayout)marketConfigPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};

                //---- lbNumberOfLevels ----
                lbNumberOfLevels.setText("# Levels");
                marketConfigPane.add(lbNumberOfLevels, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- tfNumberOfLevels ----
                tfNumberOfLevels.setText("6");
                marketConfigPane.add(tfNumberOfLevels, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- lbNumberOfGoods ----
                lbNumberOfGoods.setText("# Goods");
                marketConfigPane.add(lbNumberOfGoods, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- tfNumberOfGoods ----
                tfNumberOfGoods.setText("20");
                marketConfigPane.add(tfNumberOfGoods, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- lbMinNumberOfGoodsPerLevel ----
                lbMinNumberOfGoodsPerLevel.setText("Min # Goods Per Level");
                marketConfigPane.add(lbMinNumberOfGoodsPerLevel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- tfMinNumberOfGoodsPerLevel ----
                tfMinNumberOfGoodsPerLevel.setText("1");
                marketConfigPane.add(tfMinNumberOfGoodsPerLevel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- lbNumberOfTransformations ----
                lbNumberOfTransformations.setText("# Transformations");
                marketConfigPane.add(lbNumberOfTransformations, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- tfNumberOfTransformations ----
                tfNumberOfTransformations.setText("15");
                marketConfigPane.add(tfNumberOfTransformations, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- chkOnlyIOTransformations ----
                chkOnlyIOTransformations.setText("Show only IO Transformations");
                chkOnlyIOTransformations.setSelected(true);
                marketConfigPane.add(chkOnlyIOTransformations, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));
                marketConfigPane.add(separator1, new GridBagConstraints(0, 5, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- lbGoodLevelDistr ----
                lbGoodLevelDistr.setText("Goods between levels are");
                lbGoodLevelDistr.setLabelFor(goodsLevelDistrPane);
                marketConfigPane.add(lbGoodLevelDistr, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- cbGoodsLevelDistr ----
                cbGoodsLevelDistr.setModel(new DefaultComboBoxModel(new String[] {
                    "Uniform",
                    "Centered"
                }));
                cbGoodsLevelDistr.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        cbGoodsLevelDistrItemStateChanged(e);
                    }
                });
                marketConfigPane.add(cbGoodsLevelDistr, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));
                marketConfigPane.add(goodsLevelDistrPane, new GridBagConstraints(0, 7, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- lbBundlesNumDistr ----
                lbBundlesNumDistr.setText("# of bundles in IOT is");
                lbBundlesNumDistr.setLabelFor(cbBundlesNumDistr);
                marketConfigPane.add(lbBundlesNumDistr, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- cbBundlesNumDistr ----
                cbBundlesNumDistr.setModel(new DefaultComboBoxModel(new String[] {
                    "Uniform",
                    "Centered"
                }));
                cbBundlesNumDistr.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        cbBundlesNumDistrItemStateChanged(e);
                    }
                });
                marketConfigPane.add(cbBundlesNumDistr, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));
                marketConfigPane.add(bundlesNumDistrPanel, new GridBagConstraints(0, 9, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- btnGenerateMarket ----
                btnGenerateMarket.setVerticalAlignment(SwingConstants.BOTTOM);
                btnGenerateMarket.setAction(generateMarketAction);
                btnGenerateMarket.setText("Generate New Market");
                marketConfigPane.add(btnGenerateMarket, new GridBagConstraints(0, 10, 2, 1, 0.0, 0.0,
                    GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            scrollPane2.setViewportView(marketConfigPane);
        }
        add(scrollPane2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //======== marketGraphPane ========
        {
            marketGraphPane.setLayout(new BorderLayout());
        }
        add(marketGraphPane, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- generateMarketAction ----
        generateMarketAction.putValue(Action.NAME, "Generate");
        generateMarketAction.putValue(Action.SHORT_DESCRIPTION, "Generates New Market ");
        generateMarketAction.setEnabled(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Boris Mikhaylov
    private JScrollPane scrollPane2;
    private JPanel marketConfigPane;
    private JLabel lbNumberOfLevels;
    private JTextField tfNumberOfLevels;
    private JLabel lbNumberOfGoods;
    private JTextField tfNumberOfGoods;
    private JLabel lbMinNumberOfGoodsPerLevel;
    private JTextField tfMinNumberOfGoodsPerLevel;
    private JLabel lbNumberOfTransformations;
    private JTextField tfNumberOfTransformations;
    private JCheckBox chkOnlyIOTransformations;
    private JSeparator separator1;
    private JLabel lbGoodLevelDistr;
    private JComboBox cbGoodsLevelDistr;
    private DistributionPane goodsLevelDistrPane;
    private JLabel lbBundlesNumDistr;
    private JComboBox cbBundlesNumDistr;
    private DistributionPane bundlesNumDistrPanel;
    private JButton btnGenerateMarket;
    private JPanel marketGraphPane;
    private GenerateMarketAction generateMarketAction;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
