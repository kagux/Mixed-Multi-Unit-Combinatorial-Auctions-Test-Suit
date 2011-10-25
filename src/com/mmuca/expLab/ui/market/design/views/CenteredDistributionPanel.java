package com.mmuca.expLab.ui.market.design.views;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class CenteredDistributionPanel extends JPanel{
    public static final String CENTER_LABEL = "Center";
    public static final String ALPHA_LABEL = "Shape Factor";
    public static final String SPINNER_WIDTH = "w 40!";
    private JLabel centerLabel;
    private JLabel alphaLabel;

    private JSpinner centerSpinner;

    private JSpinner alphaSpinner;

    public CenteredDistributionPanel(){
        initComponents();
        layoutComponents();
    }

    public JSpinner getCenterSpinner() {
        return centerSpinner;
    }

    public JSpinner getAlphaSpinner() {
        return alphaSpinner;
    }

    private void layoutComponents() {
        setLayout(new MigLayout(
                "", //layout
                "0[][]0",//columns
                "0[][]0"//rows
        ));
        add(centerLabel);
        add(centerSpinner, "wrap," + SPINNER_WIDTH);
        add(alphaLabel);
        add(alphaSpinner, "wrap," + SPINNER_WIDTH);
    }

    private void initComponents() {
        centerLabel = new JLabel(CENTER_LABEL);
        alphaLabel = new JLabel(ALPHA_LABEL);
        initCenterSpinner();
        initAlphaSpinner();
    }

    private void initAlphaSpinner() {
        alphaSpinner = new JSpinner();
        alphaSpinner.setModel(new SpinnerNumberModel(0.1,0,0.9,0.1));
        configureInputPolicy(alphaSpinner);
    }

    private void initCenterSpinner() {
        centerSpinner = new JSpinner();
        centerSpinner.setModel(new SpinnerNumberModel(1,1,Integer.MAX_VALUE,1));
        configureInputPolicy(centerSpinner);
    }

    private void configureInputPolicy(JSpinner spinner) {
        spinner.setEditor(new JSpinner.NumberEditor(spinner));
        JFormattedTextField spinnerTextField = ((JSpinner.NumberEditor) spinner.getEditor()).getTextField();
        NumberFormatter formatter = (NumberFormatter) spinnerTextField.getFormatter();
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
    }
}
