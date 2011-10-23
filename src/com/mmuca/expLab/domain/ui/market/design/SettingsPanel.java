package com.mmuca.expLab.domain.ui.market.design;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class SettingsPanel extends JPanel{
    public static final String NUM_GOODS_LABEL = "# of goods";
    public static final String MIN_GOODS_PER_LEVEL_LABEL = "# of goods per level";
    public static final String NUM_LEVELS_LABEL = "# of levels";
    public static final String NUM_IOT_LABEL = "# of IOT";

    private JLabel numGoodsLabel;
    private JLabel minNumGoodsPerLevelLabel;
    private JLabel numLevelsLabel;
    private JLabel numIOTLabel;

    private JTextField numGoodsTextField;
    private JTextField minGoodsPerLevelTextField;
    private JTextField numLevelsTextField;
    private JTextField numIOTTextField;


    public SettingsPanel() {
        createGUI();
    }

    public JTextField getNumGoodsTextField() {
        return numGoodsTextField;
    }

    public JTextField getMinGoodsPerLevelTextField() {
        return minGoodsPerLevelTextField;
    }

    public JTextField getNumLevelsTextField() {
        return numLevelsTextField;
    }

    public JTextField getNumIOTTextField() {
        return numIOTTextField;
    }


    private void createGUI() {
        setLayout(new MigLayout(
                "", //Layout
                "5[]10[]5", //columns
                ""  //rows
        ));
        numGoodsLabel = new JLabel(NUM_GOODS_LABEL);
        add(numGoodsLabel);
        numGoodsTextField = new JTextField();
        add(numGoodsTextField,"wrap, w 40!");
        minNumGoodsPerLevelLabel = new JLabel(MIN_GOODS_PER_LEVEL_LABEL);
        add(minNumGoodsPerLevelLabel);
        minGoodsPerLevelTextField = new JTextField();
        add(minGoodsPerLevelTextField,"wrap, w 40!");
        numLevelsLabel = new JLabel(NUM_LEVELS_LABEL);
        add(numLevelsLabel);
        numLevelsTextField = new JTextField();
        add(numLevelsTextField,"wrap, w 40!");
        numIOTLabel = new JLabel(NUM_IOT_LABEL);
        add(numIOTLabel);
        numIOTTextField = new JTextField();
        add(numIOTTextField,"wrap, w 40!");
    }


}
