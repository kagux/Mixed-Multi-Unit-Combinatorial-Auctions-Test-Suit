package com.mmuca.expLab.ui.market.design.views;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class MarkovDistributionPanel extends JPanel{
    public static final String CHANGE_VALUE_LABEL = "Probability to change value";
    public static final String CHANGE_DIRECTION_LABEL = "Probability to change direction";

    private JSpinner pChangeValueSpinner;
    private JSpinner pChangeDirectionSpinner;
    private JLabel pChangeValueLabel;
    private JLabel pChangeDirectionLabel;

    public MarkovDistributionPanel() {
        initComponents();
        layoutComponents();
    }

    public JSpinner getpChangeValueSpinner() {
        return pChangeValueSpinner;
    }

    public JSpinner getpChangeDirectionSpinner() {
        return pChangeDirectionSpinner;
    }

    private void initComponents() {
        pChangeValueLabel = new JLabel(CHANGE_VALUE_LABEL);
        pChangeDirectionLabel = new JLabel(CHANGE_DIRECTION_LABEL);
        initPChangeValueSpinner();
        iniPChangeDirectionSpinner();
    }

    private void layoutComponents() {
        setLayout(new MigLayout(
                "",        //layout
                "0[][align right]0",  //columns
                ""                    //rows
        ));
        add(pChangeDirectionLabel);
        add(pChangeDirectionSpinner, "wrap, pushx, grow, w 40!");
        add(pChangeValueLabel);
        add(pChangeValueSpinner,"pushx, grow, w 40!");

    }

    private void iniPChangeDirectionSpinner() {
        pChangeDirectionSpinner = new JSpinner();
        pChangeDirectionSpinner.setModel(new SpinnerNumberModel(0.1,0,0.9,0.1));
        configureInputPolicy(pChangeDirectionSpinner);
    }

    private void initPChangeValueSpinner() {
        pChangeValueSpinner = new JSpinner();
        pChangeValueSpinner.setModel(new SpinnerNumberModel(0.1,0,0.9,0.1));
        configureInputPolicy(pChangeValueSpinner);
    }

    private void configureInputPolicy(JSpinner spinner) {
        spinner.setEditor(new JSpinner.NumberEditor(spinner));
        JFormattedTextField spinnerTextField = ((JSpinner.NumberEditor) spinner.getEditor()).getTextField();
        NumberFormatter formatter = (NumberFormatter) spinnerTextField.getFormatter();
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
    }
}
