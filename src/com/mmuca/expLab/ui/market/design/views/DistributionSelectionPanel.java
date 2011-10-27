package com.mmuca.expLab.ui.market.design.views;

import com.mmuca.expLab.domain.distributions.Distribution;
import com.mmuca.expLab.ui.components.MinimizingCardPanel;
import com.mmuca.expLab.ui.market.design.models.DistributionModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class DistributionSelectionPanel extends JPanel implements ObserverView {
    private JLabel distributionChoiceLabel;
    private JComboBox<Distribution> distributionsComboBox;
    private MinimizingCardPanel distributionSettingsPanel;


    private String title;
    private DistributionModel model;
    private UniformDistributionPanel uniformDistributionPanel;
    private CenteredDistributionPanel centeredDistributionPanel;
    private MarkovDistributionPanel markovForwardDistributionPanel;
    private MarkovDistributionPanel markovBackwardDistributionPanel;


    public DistributionSelectionPanel(String title, DistributionModel model){
        this.title = title;
        this.model = model;
        model.addView(this);
        initComponents();
        layoutComponents();
    }

    public JComboBox<Distribution> getDistributionsComboBox() {
        return distributionsComboBox;
    }

    public MinimizingCardPanel getDistributionSettingsPanel() {
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
        distributionSettingsPanel = new MinimizingCardPanel();
        uniformDistributionPanel = new UniformDistributionPanel();
        centeredDistributionPanel = new CenteredDistributionPanel(model);
        markovForwardDistributionPanel = new MarkovDistributionPanel();
        markovBackwardDistributionPanel = new MarkovDistributionPanel();


    }

    private void initDistributionsComboBox() {
        distributionsComboBox = new JComboBox<Distribution>(model.validDistributions());
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
        distributionSettingsPanel.add(uniformDistributionPanel,Distribution.UNIFORM.toString());
        distributionSettingsPanel.add(centeredDistributionPanel,Distribution.CENTERED.toString());
        distributionSettingsPanel.add(markovForwardDistributionPanel,Distribution.MARKOV_FORWARD.toString());
        distributionSettingsPanel.add(markovBackwardDistributionPanel,Distribution.MARKOV_BACKWARD.toString());
        distributionSettingsPanel.showCard(distributionsComboBox.getSelectedItem().toString());
    }


    @Override
    public void refresh() {
        distributionSettingsPanel.revalidate();

    }
}
