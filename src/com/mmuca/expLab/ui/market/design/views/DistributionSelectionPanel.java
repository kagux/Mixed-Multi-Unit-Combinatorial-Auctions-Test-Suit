package com.mmuca.expLab.ui.market.design.views;

import com.mmuca.expLab.domain.distributions.Distribution;
import com.mmuca.expLab.ui.components.MinimizingCardPanel;
import com.mmuca.expLab.ui.market.design.models.DistributionModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class DistributionSelectionPanel extends JPanel{
    private JLabel distributionChoiceLabel;
    private JComboBox distributionsComboBox;
    private MinimizingCardPanel distributionSettingsPanel;


    private String title;
    private DistributionModel model;
    private UniformDistributionPanel uniformDistributionPanel;
    private CenteredDistributionPanel centeredDistributionPanel;
    private MarkovDistributionPanel markovForwardDistributionPanel;
    private MarkovDistributionPanel markovBackwardDistributionPanel;
    private ConstantDistributionPanel constantDistributionPanel;


    public DistributionSelectionPanel(String title, DistributionModel model){
        this.title = title;
        this.model = model;
        initComponents();
        layoutComponents();
    }

    public ConstantDistributionPanel getConstantDistributionPanel() {
        return constantDistributionPanel;
    }

    public JComboBox getDistributionsComboBox() {
        return distributionsComboBox;
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
        distributionsComboBox = new JComboBox(model.validDistributions());
        initDistributionSettingsPanel();
    }

    private void initDistributionSettingsPanel() {
        distributionSettingsPanel = new MinimizingCardPanel();
        uniformDistributionPanel = new UniformDistributionPanel();
        centeredDistributionPanel = new CenteredDistributionPanel(model);
        markovForwardDistributionPanel = new MarkovDistributionPanel();
        markovBackwardDistributionPanel = new MarkovDistributionPanel();
        constantDistributionPanel = new ConstantDistributionPanel(model);


    }

    private void layoutComponents() {
        setLayout(new MigLayout(
                "",//layout
                "0[][]0", //columns
                ""   //rows
        ));
        add(distributionChoiceLabel);
        add(distributionsComboBox, "wrap");
        add(distributionSettingsPanel,"span, grow, push");
        distributionSettingsPanel.add(uniformDistributionPanel, Distribution.UNIFORM.toString());
        distributionSettingsPanel.add(centeredDistributionPanel,Distribution.CENTERED.toString());
        distributionSettingsPanel.add(markovForwardDistributionPanel,Distribution.MARKOV_FORWARD.toString());
        distributionSettingsPanel.add(markovBackwardDistributionPanel,Distribution.MARKOV_BACKWARD.toString());
        distributionSettingsPanel.add(constantDistributionPanel,Distribution.CONSTANT.toString());
        distributionSettingsPanel.showCard(distributionsComboBox.getSelectedItem().toString());
    }


    public void showSettingsFor(Distribution distribution){
        distributionSettingsPanel.showCard(distribution.toString());
    }

    public Distribution selectedDistribution(){
        return (Distribution) distributionsComboBox.getSelectedItem();
    }

}
