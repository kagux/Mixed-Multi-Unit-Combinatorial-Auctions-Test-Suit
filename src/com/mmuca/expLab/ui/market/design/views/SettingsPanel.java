package com.mmuca.expLab.ui.market.design.views;

import com.mmuca.expLab.ui.components.NumberSpinner;
import com.mmuca.expLab.ui.market.design.models.MarketModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class SettingsPanel extends JPanel{
    public static final String NUM_GOODS_LABEL = "# of goods";
    public static final String MIN_GOODS_PER_LEVEL_LABEL = "# of goods per level";
    public static final String NUM_LEVELS_LABEL = "# of levels";
    public static final String NUM_IOT_LABEL = "# of IOT";
    public static final String SHOW_ONLY_IOT_CHECK_BOX = "Show only IOT";
    public static final String GOOD_LEVEL_DISTR_PANEL_TITLE = "Goods between levels are";
    public static final String INPUT_BUNDLES_NUM_DISTR_PANEL_TITLE = "# of inputs for IOT is";
    public static final String OUTPUT_BUNDLES_NUM_DISTR_PANEL_TITLE = "# of outputs for IOT is";
    public static final String INPUT_BUNDLE_GOOD_LEVEL_DISTR_PANEL_TITLE = "Good level for input is";
    public static final String OUTPUT_BUNDLE_GOOD_LEVEL_DISTR_PANEL_TITLE = "Good level for output is";
    public static final String IOT_LEVEL_DISTR_PANEL_TITLE = "IOT Level is";

    private JLabel numGoodsLabel;
    private JLabel minNumGoodsPerLevelLabel;
    private JLabel numLevelsLabel;
    private JLabel numIOTLabel;

    private JSpinner numGoodsSpinner;
    private JSpinner minGoodsPerLevelSpinner;
    private JSpinner numLevelsSpinner;
    private JSpinner numIOTSpinner;

    private DistributionSelectionPanel goodLevelDistrPanel;
    private DistributionSelectionPanel inputBundlesNumDistrPanel;
    private DistributionSelectionPanel outputBundlesNumDistrPanel;
    private DistributionSelectionPanel inputBundleGoodLevelDistrPanel;
    private DistributionSelectionPanel outputBundleGoodLevelDistrPanel;
    private DistributionSelectionPanel iotLevelDistrPanel;

    private JCheckBox showOnlyIOTCheckBox;
    private MarketModel model;


    public SettingsPanel(MarketModel model) {
        this.model = model;
        initComponents();
        layoutComponents();
    }

    public DistributionSelectionPanel getIotLevelDistrPanel() {
        return iotLevelDistrPanel;
    }

    public DistributionSelectionPanel getGoodLevelDistrPanel() {
        return goodLevelDistrPanel;
    }

    public DistributionSelectionPanel getInputBundlesNumDistrPanel() {
        return inputBundlesNumDistrPanel;
    }

    public DistributionSelectionPanel getOutputBundlesNumDistrPanel() {
        return outputBundlesNumDistrPanel;
    }

    public DistributionSelectionPanel getInputBundleGoodLevelDistrPanel() {
        return inputBundleGoodLevelDistrPanel;
    }

    public DistributionSelectionPanel getOutputBundleGoodLevelDistrPanel() {
        return outputBundleGoodLevelDistrPanel;
    }

    public JCheckBox getShowOnlyIOTCheckBox() {
        return showOnlyIOTCheckBox;
    }

    public JSpinner getNumGoodsSpinner() {
        return numGoodsSpinner;
    }

    public JSpinner getMinGoodsPerLevelSpinner() {
        return minGoodsPerLevelSpinner;
    }

    public JSpinner getNumLevelsSpinner() {
        return numLevelsSpinner;
    }

    public JSpinner getNumIOTSpinner() {
        return numIOTSpinner;
    }

    private void initComponents() {
        numGoodsLabel = new JLabel(NUM_GOODS_LABEL);
        minNumGoodsPerLevelLabel = new JLabel(MIN_GOODS_PER_LEVEL_LABEL);
        numLevelsLabel = new JLabel(NUM_LEVELS_LABEL);
        numIOTLabel = new JLabel(NUM_IOT_LABEL);
        numGoodsSpinner = new NumberSpinner(model.getNumGoods(), model.MINIMUM_NUM_GOODS, Integer.MAX_VALUE, 1);
        minGoodsPerLevelSpinner = new NumberSpinner(model.getMinGoodsPerLevel(),model.MINIMUM_MIN_NUM_GOODS_PER_LEVEL,Integer.MAX_VALUE,1);
        numLevelsSpinner = new NumberSpinner(model.getNumLevels(),model.MINIMUM_NUM_LEVELS,Integer.MAX_VALUE,1);
        numIOTSpinner = new NumberSpinner(model.getNumIOT(),model.MINIMUM_NUM_IOT,Integer.MAX_VALUE,1);
        showOnlyIOTCheckBox=new JCheckBox(SHOW_ONLY_IOT_CHECK_BOX,model.isShowOnlyIOT());
        goodLevelDistrPanel = new DistributionSelectionPanel(GOOD_LEVEL_DISTR_PANEL_TITLE, model.getGoodLevelDistrModel());
        inputBundlesNumDistrPanel = new DistributionSelectionPanel(INPUT_BUNDLES_NUM_DISTR_PANEL_TITLE,model.getOutputBundlesNumDistrModel());
        outputBundlesNumDistrPanel = new DistributionSelectionPanel(OUTPUT_BUNDLES_NUM_DISTR_PANEL_TITLE,model.getOutputBundlesNumDistrModel());
        iotLevelDistrPanel = new DistributionSelectionPanel(IOT_LEVEL_DISTR_PANEL_TITLE, model.getIotLevelDistrModel());
        inputBundleGoodLevelDistrPanel = new DistributionSelectionPanel(INPUT_BUNDLE_GOOD_LEVEL_DISTR_PANEL_TITLE, model.getInputBundleGoodLevelDistrModel());
        outputBundleGoodLevelDistrPanel = new DistributionSelectionPanel(OUTPUT_BUNDLE_GOOD_LEVEL_DISTR_PANEL_TITLE, model.getOutputBundleGoodLevelDistrModel());

    }

    private void layoutComponents() {
        setLayout(new MigLayout(
                "", //Layout
                "5[]10[]5", //columns
                ""  //rows
        ));
        add(numGoodsLabel);
        add(numGoodsSpinner, "wrap, w 40!");
        add(minNumGoodsPerLevelLabel);
        add(minGoodsPerLevelSpinner,"wrap, w 40!");
        add(numLevelsLabel);
        add(numLevelsSpinner,"wrap, w 40!");
        add(numIOTLabel);
        add(numIOTSpinner,"wrap, w 40!");
        add(showOnlyIOTCheckBox, "span, wrap");
        add(new JSeparator(),"span, grow, pushx");
        add(goodLevelDistrPanel, "span, grow, pushx,wrap");
        add(new JSeparator(),"span, grow, pushx");
        add(iotLevelDistrPanel, "span, grow, pushx, wrap");
        add(new JSeparator(),"span, grow, pushx");
        add(inputBundlesNumDistrPanel, "span, grow, pushx, wrap");
        add(new JSeparator(),"span, grow, pushx");
        add(outputBundlesNumDistrPanel, "span, grow, pushx, wrap");
        add(new JSeparator(),"span, grow, pushx");
        add(inputBundleGoodLevelDistrPanel, "span, grow, pushx, wrap");
        add(new JSeparator(),"span, grow, pushx");
        add(outputBundleGoodLevelDistrPanel, "span, grow, pushx, wrap");
    }

}
