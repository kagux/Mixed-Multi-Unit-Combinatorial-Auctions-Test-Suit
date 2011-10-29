package com.mmuca.expLab.ui.market.design.views;

import com.mmuca.expLab.ui.components.NumberSpinner;
import com.mmuca.expLab.ui.market.design.models.DistributionModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class CenteredDistributionPanel extends JPanel implements ObserverView{
    public static final String CENTER_LABEL = "Center";
    public static final String ALPHA_LABEL = "Shape Factor";
    public static final String SPINNER_WIDTH = "w 60!";
    private JLabel centerLabel;
    private JLabel alphaLabel;

    private NumberSpinner centerSpinner;

    private NumberSpinner alphaSpinner;
    private DistributionModel model;

    public CenteredDistributionPanel(DistributionModel model){
        this.model = model;
        model.addView(this);
        initComponents();
        layoutComponents();
    }

    public NumberSpinner getCenterSpinner() {
        return centerSpinner;
    }

    public NumberSpinner getAlphaSpinner() {
        return alphaSpinner;
    }

    private void layoutComponents() {
        setLayout(new MigLayout(
                "", //layout
                "0[][align right]0",//columns
                "0[][]0"//rows
        ));
        add(centerLabel);
        add(centerSpinner, "pushx, grow, wrap," + SPINNER_WIDTH);
        add(alphaLabel);
        add(alphaSpinner, "pushx, grow, wrap," + SPINNER_WIDTH);
    }

    private void initComponents() {
        centerLabel = new JLabel(CENTER_LABEL);
        alphaLabel = new JLabel(ALPHA_LABEL);
        centerSpinner = new NumberSpinner(model.getRangeStart(),model.getRangeStart(),model.getRangeEnd(),1);
        centerSpinner.setVisualValueOffset(1-model.rangeOrigin());
        alphaSpinner = new NumberSpinner(0.1,0.1,0.9,0.1);
    }

    @Override
    public void update() {
        ((NumberSpinner.SpinnerModel)centerSpinner.getModel()).setMaximum(model.getRangeEnd());
        ((NumberSpinner.SpinnerModel)centerSpinner.getModel()).setMinimum(model.getRangeStart());
    }

    @Override
    public void beginUpdate() {}

    @Override
    public void endUpdate() { }
}
