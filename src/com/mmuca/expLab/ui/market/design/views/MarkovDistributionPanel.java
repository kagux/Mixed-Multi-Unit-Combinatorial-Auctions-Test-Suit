package com.mmuca.expLab.ui.market.design.views;

import com.mmuca.expLab.ui.components.NumberSpinner;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

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
        pChangeValueSpinner = new NumberSpinner(0.1,0,0.9,0.1);
        pChangeDirectionSpinner = new NumberSpinner(0.1,0,0.9,0.1);
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
}
