package com.mmuca.expLab.domain.ui.market.design.views;

import com.mmuca.expLab.domain.distributions.Distribution;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.ArrayList;

public class DistributionsPanel extends JPanel{
    private JLabel distributionChoiceLabel;
    private JComboBox distributionsComboBox;


    private ArrayList<Distribution> distributions;


    public DistributionsPanel(){
        initComponents();
        layoutComponents();
    }

    private void initComponents() {
        distributionChoiceLabel = new JLabel("Distribution label");
        distributionsComboBox = new JComboBox();
    }

    private void layoutComponents() {
        setLayout(new MigLayout());
        add(distributionChoiceLabel);
        add(distributionsComboBox);
    }


}
