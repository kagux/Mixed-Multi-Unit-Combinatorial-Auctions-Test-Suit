package com.mmuca.expLab.ui.market.design.views;

import com.mmuca.expLab.domain.distributions.Distribution;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DistributionSelectionPanel extends JPanel{
    private JLabel distributionChoiceLabel;
    private JComboBox<Distribution> distributionsComboBox;
    private JPanel distributionSettingsPanel;


    private ArrayList<Distribution> distributions;
    private String title;
    private UniformDistributionPanel uniformDistributionPanel;
    private CenteredDistributionPanel centeredDistributionPanel;
    private MarkovDistributionPanel markovForwardDistributionPanel;
    private MarkovDistributionPanel markovBackwardDistributionPanel;


    public DistributionSelectionPanel(String title, ArrayList<Distribution> distributions){
        this.title = title;
        this.distributions = distributions;
        initComponents();
        layoutComponents();
    }

    public JComboBox<Distribution> getDistributionsComboBox() {
        return distributionsComboBox;
    }

    public JPanel getDistributionSettingsPanel() {
        return distributionSettingsPanel;
    }

    public UniformDistributionPanel getUniformDistributionPanel() {
        return uniformDistributionPanel;
    }

    public CenteredDistributionPanel getCenteredDistributionPanel() {
        return centeredDistributionPanel;
    }

    public MarkovDistributionPanel getMarkovForwardDistributionPanel() {
        return markovForwardDistributionPanel;
    }

    public MarkovDistributionPanel getMarkovBackwardDistributionPanel() {
        return markovBackwardDistributionPanel;
    }

    private void initComponents() {
        distributionChoiceLabel = new JLabel(title);
        initDistributionsComboBox();
        initDistributionSettingsPanel();
    }

    private void initDistributionSettingsPanel() {
        distributionSettingsPanel = new JPanel();
        distributionSettingsPanel.setLayout(new CardLayout());
        uniformDistributionPanel = new UniformDistributionPanel();
        centeredDistributionPanel = new CenteredDistributionPanel();
        markovForwardDistributionPanel = new MarkovDistributionPanel();
        markovBackwardDistributionPanel = new MarkovDistributionPanel();
        distributionSettingsPanel.add(uniformDistributionPanel,Distribution.UNIFORM.toString());
        distributionSettingsPanel.add(centeredDistributionPanel,Distribution.CENTERED.toString());
        distributionSettingsPanel.add(markovForwardDistributionPanel,Distribution.MARKOV_FORWARD.toString());
        distributionSettingsPanel.add(markovBackwardDistributionPanel,Distribution.MARKOV_BACKWARD.toString());

    }

    private void initDistributionsComboBox() {
        distributionsComboBox = new JComboBox<Distribution>();
        for (Distribution distribution: distributions)
            distributionsComboBox.addItem(distribution);
    }

    private void layoutComponents() {
        setLayout(new MigLayout(
                "",//layout
                "0[][]0", //columns
                ""   //rows
        ));
        add(distributionChoiceLabel);
        add(distributionsComboBox, "wrap");
        add(distributionSettingsPanel,"span, push");
    }


}
