package com.mmuca.expLab.domain.ui.market.design.views;

import com.mmuca.expLab.domain.ui.market.design.models.MarketModel;
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
    private MarketModel model;


    public SettingsPanel(MarketModel model) {
        this.model = model;
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
        initNumGoodsSpinner();
        initGoodsPerLevelSpinner();
        initNumLevelsSpinner();
        initNumIOTSpinner();
        showOnlyIOTCheckBox=new JCheckBox(SHOW_ONLY_IOT_CHECK_BOX,model.isShowOnlyIOT());
    }

    private void initNumIOTSpinner() {
        numIOTSpinner = new JSpinner();
        numIOTSpinner.setModel(new SpinnerNumberModel(model.getNumIOT(),model.MINIMUM_NUM_IOT,Integer.MAX_VALUE,1));
        configureInputPolicy(numIOTSpinner);
    }

    private void initNumLevelsSpinner() {
        numLevelsSpinner = new JSpinner();
        numLevelsSpinner.setModel(new SpinnerNumberModel(model.getNumLevels(),model.MINIMUM_NUM_LEVELS,Integer.MAX_VALUE,1));
        configureInputPolicy(numGoodsSpinner);
    }

    private void initGoodsPerLevelSpinner() {
        minGoodsPerLevelSpinner = new JSpinner();
        minGoodsPerLevelSpinner.setModel(new SpinnerNumberModel(model.getMinGoodsPerLevel(),model.MINIMUM_MIN_NUM_GOODS_PER_LEVEL,Integer.MAX_VALUE,1));
        configureInputPolicy(minGoodsPerLevelSpinner);
    }

    private void initNumGoodsSpinner() {
        numGoodsSpinner = new JSpinner();
        numGoodsSpinner.setModel(new SpinnerNumberModel(model.getNumGoods(), model.MINIMUM_NUM_GOODS, Integer.MAX_VALUE, 1));
        configureInputPolicy(numGoodsSpinner);
    }

    private void configureInputPolicy(JSpinner spinner) {
        spinner.setEditor(new JSpinner.NumberEditor(spinner));
        JFormattedTextField spinnerTextField = ((JSpinner.NumberEditor) spinner.getEditor()).getTextField();
        NumberFormatter formatter = (NumberFormatter) spinnerTextField.getFormatter();
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
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

}
