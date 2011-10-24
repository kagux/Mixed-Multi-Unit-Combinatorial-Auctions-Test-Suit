package com.mmuca.expLab.domain.ui.market.design.views;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class CenteredDistributionPanel extends JPanel{
    public static final String CENTER_LABEL = "Center";
    public static final String ALPHA_LABEL = "Shape Factor";
    private JLabel centerLabel;
    private JLabel alphaLabel;

    private JTextField centerTextField;

    private JTextField alphaTextField;

    public CenteredDistributionPanel(){
        initComponents();
        layoutComponents();
    }

    public JTextField getCenterTextField() {
        return centerTextField;
    }

    public JTextField getAlphaTextField() {
        return alphaTextField;
    }

    private void layoutComponents() {
        setLayout(new MigLayout());
        add(centerLabel);
        add(centerTextField,"wrap");
        add(alphaLabel);
        add(alphaTextField);
    }

    private void initComponents() {
        centerLabel = new JLabel(CENTER_LABEL);
        alphaLabel = new JLabel(ALPHA_LABEL);
        centerTextField = new JTextField();
        alphaTextField = new JTextField();
    }
}
