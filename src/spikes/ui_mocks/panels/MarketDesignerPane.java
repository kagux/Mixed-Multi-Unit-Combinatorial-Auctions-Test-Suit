/*
 * Created by JFormDesigner on Mon Oct 17 17:19:31 CEST 2011
 */

package spikes.ui_mocks.panels;

import com.mmuca.expLab.domain.distributions.Distribution;
import spikes.ui_mocks.actions.GenerateMarketAction;

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
        layout.show(goodsLevelDistrPane, e.getItem().toString());
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
        layout.show(bundlesNumDistrPanel, e.getItem().toString());
    }

    public DistributionPane getIOTLevelDistrPanel(){
        return iotLevelDistrPanel;
    }

    public JComboBox getIOTLevelDistrComboBox(){
        return cbIOTLevelDistr;
    }

    private void cbIOTLevelDistrItemStateChanged(ItemEvent e) {
        CardLayout layout = (CardLayout) iotLevelDistrPanel.getLayout();
        layout.show(iotLevelDistrPanel, e.getItem().toString());
    }


    public DistributionPane getInputBundlesGoodsLevelDistrPanel() {
        return inputBundlesGoodsLevelDistrPanel;
    }

    public JComboBox getInputBundlesGoodsLevelComboBox(){
        return cbInputBundlesGoodsLevelDistr;
    }


    private void cbInputBundlesGoodsLevelDistrItemStateChanged(ItemEvent e) {
        CardLayout layout = (CardLayout) inputBundlesGoodsLevelDistrPanel.getLayout();
        layout.show(inputBundlesGoodsLevelDistrPanel, e.getItem().toString());
    }

    public JComboBox getOutputBundlesGoodsLevelComboBox(){
        return cbOutputBundlesGoodsLevelDistr;
    }

    private void cbOutputBundlesGoodsLevelDistrItemStateChanged(ItemEvent e) {
        CardLayout layout = (CardLayout) outputBundlesGoodsLevelDistrPanel.getLayout();
        layout.show(outputBundlesGoodsLevelDistrPanel, e.getItem().toString());
    }

    public DistributionPane getOutputBundlesGoodsLevelDistrPanel() {
        return outputBundlesGoodsLevelDistrPanel;
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        createUIComponents();
        marketConfigScrollPane = new JScrollPane();
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
        separator2 = new JSeparator();
        lbIOTLevelDistr = new JLabel();
        cbIOTLevelDistr = new JComboBox();
        iotLevelDistrPanel = new DistributionPane();
        separator3 = new JSeparator();
        lbInputBundlesGoodsLevelDistr = new JLabel();
        cbInputBundlesGoodsLevelDistr = new JComboBox();
        inputBundlesGoodsLevelDistrPanel = new DistributionPane();
        separator4 = new JSeparator();
        lbOutputBundlesGoodsLevelDistr = new JLabel();
        cbOutputBundlesGoodsLevelDistr = new JComboBox();
        outputBundlesGoodsLevelDistrPanel = new DistributionPane();
        marketGraphPane = new JPanel();
        btnGenerateMarket = new JButton();

        //======== this ========
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 376, 0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 503, 15, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //======== marketConfigScrollPane ========
        {
            marketConfigScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            //======== marketConfigPane ========
            {
                marketConfigPane.setBorder(new EtchedBorder());
                marketConfigPane.setLayout(new GridBagLayout());
                ((GridBagLayout)marketConfigPane.getLayout()).columnWidths = new int[] {15, 172, 58, 10, 0};
                ((GridBagLayout)marketConfigPane.getLayout()).rowHeights = new int[] {15, 27, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)marketConfigPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0E-4};
                ((GridBagLayout)marketConfigPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- lbNumberOfLevels ----
                lbNumberOfLevels.setText("# Levels");
                marketConfigPane.add(lbNumberOfLevels, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- tfNumberOfLevels ----
                tfNumberOfLevels.setText("6");
                marketConfigPane.add(tfNumberOfLevels, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- lbNumberOfGoods ----
                lbNumberOfGoods.setText("# Goods");
                marketConfigPane.add(lbNumberOfGoods, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- tfNumberOfGoods ----
                tfNumberOfGoods.setText("20");
                marketConfigPane.add(tfNumberOfGoods, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- lbMinNumberOfGoodsPerLevel ----
                lbMinNumberOfGoodsPerLevel.setText("Min # Goods Per Level");
                marketConfigPane.add(lbMinNumberOfGoodsPerLevel, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- tfMinNumberOfGoodsPerLevel ----
                tfMinNumberOfGoodsPerLevel.setText("1");
                marketConfigPane.add(tfMinNumberOfGoodsPerLevel, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- lbNumberOfTransformations ----
                lbNumberOfTransformations.setText("# Transformations");
                marketConfigPane.add(lbNumberOfTransformations, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- tfNumberOfTransformations ----
                tfNumberOfTransformations.setText("15");
                marketConfigPane.add(tfNumberOfTransformations, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- chkOnlyIOTransformations ----
                chkOnlyIOTransformations.setText("Show only IO Transformations");
                chkOnlyIOTransformations.setSelected(true);
                marketConfigPane.add(chkOnlyIOTransformations, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                marketConfigPane.add(separator1, new GridBagConstraints(1, 6, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- lbGoodLevelDistr ----
                lbGoodLevelDistr.setText("Goods between levels are");
                lbGoodLevelDistr.setLabelFor(goodsLevelDistrPane);
                marketConfigPane.add(lbGoodLevelDistr, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- cbGoodsLevelDistr ----
                cbGoodsLevelDistr.addItem(Distribution.UNIFORM);
                cbGoodsLevelDistr.addItem(Distribution.CENTERED);
                cbGoodsLevelDistr.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        cbGoodsLevelDistrItemStateChanged(e);
                    }
                });
                marketConfigPane.add(cbGoodsLevelDistr, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                marketConfigPane.add(goodsLevelDistrPane, new GridBagConstraints(1, 8, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- lbBundlesNumDistr ----
                lbBundlesNumDistr.setText("# of bundles in IOT is");
                lbBundlesNumDistr.setLabelFor(cbBundlesNumDistr);
                marketConfigPane.add(lbBundlesNumDistr, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- cbBundlesNumDistr ----
                cbBundlesNumDistr.addItem(Distribution.CENTERED);
                cbBundlesNumDistr.addItem(Distribution.UNIFORM);
                cbBundlesNumDistr.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        cbBundlesNumDistrItemStateChanged(e);
                    }
                });
                marketConfigPane.add(cbBundlesNumDistr, new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- bundlesNumDistrPanel ----
                ((CardLayout)bundlesNumDistrPanel.getLayout()).show(bundlesNumDistrPanel, cbBundlesNumDistr.getSelectedItem().toString());
                marketConfigPane.add(bundlesNumDistrPanel, new GridBagConstraints(1, 10, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                marketConfigPane.add(separator2, new GridBagConstraints(1, 11, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- lbIOTLevelDistr ----
                lbIOTLevelDistr.setText("IOT Levels are");
                lbIOTLevelDistr.setLabelFor(cbIOTLevelDistr);
                marketConfigPane.add(lbIOTLevelDistr, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- cbIOTLevelDistr ----
                cbIOTLevelDistr.addItem(Distribution.UNIFORM);
                cbIOTLevelDistr.addItem(Distribution.CENTERED);

                cbIOTLevelDistr.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        cbIOTLevelDistrItemStateChanged(e);
                    }
                });
                marketConfigPane.add(cbIOTLevelDistr, new GridBagConstraints(2, 12, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                marketConfigPane.add(iotLevelDistrPanel, new GridBagConstraints(1, 13, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                marketConfigPane.add(separator3, new GridBagConstraints(1, 14, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- lbInputBundlesGoodsLevelDistr ----
                lbInputBundlesGoodsLevelDistr.setText("Goods' levels for IOT input are");
                lbInputBundlesGoodsLevelDistr.setLabelFor(cbInputBundlesGoodsLevelDistr);
                marketConfigPane.add(lbInputBundlesGoodsLevelDistr, new GridBagConstraints(1, 15, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- cbInputBundlesGoodsLevelDistr ----
                cbInputBundlesGoodsLevelDistr.addItem(Distribution.MARKOV_FORWARD);
                cbInputBundlesGoodsLevelDistr.addItem(Distribution.MARKOV_BACKWARD);
                cbInputBundlesGoodsLevelDistr.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        cbInputBundlesGoodsLevelDistrItemStateChanged(e);
                    }
                });
                marketConfigPane.add(cbInputBundlesGoodsLevelDistr, new GridBagConstraints(2, 15, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- inputBundlesGoodsLevelDistrPanel ----
                ( (CardLayout) inputBundlesGoodsLevelDistrPanel.getLayout()).show(inputBundlesGoodsLevelDistrPanel, cbInputBundlesGoodsLevelDistr.getSelectedItem().toString());
                marketConfigPane.add(inputBundlesGoodsLevelDistrPanel, new GridBagConstraints(1, 16, 2, 1, 0.0, 0.0,
                    GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 5, 5), 0, 0));
                marketConfigPane.add(separator4, new GridBagConstraints(1, 17, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- lbOutputBundlesGoodsLevelDistr ----
                lbOutputBundlesGoodsLevelDistr.setText("Goods' levels for IOT output ");
                marketConfigPane.add(lbOutputBundlesGoodsLevelDistr, new GridBagConstraints(1, 18, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- cbOutputBundlesGoodsLevelDistr ----
                cbOutputBundlesGoodsLevelDistr.addItem(Distribution.MARKOV_BACKWARD);
                cbOutputBundlesGoodsLevelDistr.addItem(Distribution.MARKOV_FORWARD);
                cbOutputBundlesGoodsLevelDistr.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        cbOutputBundlesGoodsLevelDistrItemStateChanged(e);
                    }
                });
                marketConfigPane.add(cbOutputBundlesGoodsLevelDistr, new GridBagConstraints(2, 18, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- outputBundlesGoodsLevelDistrPanel ----
                ((CardLayout)outputBundlesGoodsLevelDistrPanel.getLayout()).show(outputBundlesGoodsLevelDistrPanel, (String)cbOutputBundlesGoodsLevelDistr.getSelectedItem().toString());
                marketConfigPane.add(outputBundlesGoodsLevelDistrPanel, new GridBagConstraints(1, 19, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            }
            marketConfigScrollPane.setViewportView(marketConfigPane);
        }
        add(marketConfigScrollPane, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //======== marketGraphPane ========
        {
            marketGraphPane.setLayout(new BorderLayout());

            //---- btnGenerateMarket ----
            btnGenerateMarket.setVerticalAlignment(SwingConstants.BOTTOM);
            btnGenerateMarket.setAction(generateMarketAction);
            btnGenerateMarket.setText("Generate New Market");
            marketGraphPane.add(btnGenerateMarket, BorderLayout.SOUTH);
        }
        add(marketGraphPane, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- generateMarketAction ----
        generateMarketAction.putValue(Action.NAME, "Generate");
        generateMarketAction.putValue(Action.SHORT_DESCRIPTION, "Generates New Market ");
        generateMarketAction.setEnabled(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane marketConfigScrollPane;
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
    private JSeparator separator2;
    private JLabel lbIOTLevelDistr;
    private JComboBox cbIOTLevelDistr;
    private DistributionPane iotLevelDistrPanel;
    private JSeparator separator3;
    private JLabel lbInputBundlesGoodsLevelDistr;
    private JComboBox cbInputBundlesGoodsLevelDistr;
    private DistributionPane inputBundlesGoodsLevelDistrPanel;
    private JSeparator separator4;
    private JLabel lbOutputBundlesGoodsLevelDistr;
    private JComboBox cbOutputBundlesGoodsLevelDistr;
    private DistributionPane outputBundlesGoodsLevelDistrPanel;
    private JPanel marketGraphPane;
    private JButton btnGenerateMarket;
    private GenerateMarketAction generateMarketAction;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
