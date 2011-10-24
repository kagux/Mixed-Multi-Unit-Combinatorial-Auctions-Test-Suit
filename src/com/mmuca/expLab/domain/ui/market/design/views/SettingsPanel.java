package com.mmuca.expLab.domain.ui.market.design.views;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class SettingsPanel extends JPanel{
    public static final String NUM_GOODS_LABEL = "# of goods";
    public static final String MIN_GOODS_PER_LEVEL_LABEL = "# of goods per level";
    public static final String NUM_LEVELS_LABEL = "# of levels";
    public static final String NUM_IOT_LABEL = "# of IOT";
    public static final String SHOW_ONLY_IOT_CHECK_BOX = "Show only IOT";

    private JLabel numGoodsLabel;
    private JLabel minNumGoodsPerLevelLabel;
    private JLabel numLevelsLabel;
    private JLabel numIOTLabel;

    private JSpinner numGoodsSpinner;
    private JSpinner minGoodsPerLevelSpinner;
    private JSpinner numLevelsSpinner;
    private JSpinner numIOTSpinner;

    private JCheckBox showOnlyIOTCheckBox;


    public SettingsPanel() {
        initComponents();
        layoutComponents();
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
        numGoodsSpinner = new JSpinner();
        numGoodsSpinner.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        disallowInvalidInput(numGoodsSpinner);
        minGoodsPerLevelSpinner = new JSpinner();
        minGoodsPerLevelSpinner.setModel(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
        disallowInvalidInput(minGoodsPerLevelSpinner);
        numLevelsSpinner = new JSpinner();
        numLevelsSpinner.setModel(new SpinnerNumberModel(3,3,Integer.MAX_VALUE,1));
        disallowInvalidInput(numGoodsSpinner);
        numIOTSpinner = new JSpinner();
        numIOTSpinner.setModel(new SpinnerNumberModel(0,0,Integer.MAX_VALUE,1));
        disallowInvalidInput(numIOTSpinner);
        showOnlyIOTCheckBox=new JCheckBox(SHOW_ONLY_IOT_CHECK_BOX);
    }

    private void layoutComponents() {
        setLayout(new MigLayout(
                "", //Layout
                "5[]10[]5", //columns
                ""  //rows
        ));
        add(numGoodsLabel);
        add(numGoodsSpinner,"wrap, w 40!");
        add(minNumGoodsPerLevelLabel);
        add(minGoodsPerLevelSpinner,"wrap, w 40!");
        add(numLevelsLabel);
        add(numLevelsSpinner,"wrap, w 40!");
        add(numIOTLabel);
        add(numIOTSpinner,"wrap, w 40!");
        add(showOnlyIOTCheckBox, "span, wrap");
    }


    private void disallowInvalidInput(JSpinner spinner) {
        spinner.setEditor(new JSpinner.NumberEditor(spinner));
        JFormattedTextField spinnerTextField = ((JSpinner.NumberEditor) spinner.getEditor()).getTextField();
        ((NumberFormatter)spinnerTextField.getFormatter()).setAllowsInvalid(false);
    }

}
