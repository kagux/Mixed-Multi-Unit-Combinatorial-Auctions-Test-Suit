package com.mmuca.expLab.ui.market.design.views;

import com.mmuca.expLab.ui.components.NumberSpinner;
import com.mmuca.expLab.ui.market.design.models.DistributionModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ConstantDistributionPanel extends JPanel implements ObserverView{
    public static final String VALUE_LABEL = "Value";
    public static final String SPINNER_WIDTH = "w 60!";
    private JLabel valueLabel;
    private NumberSpinner valueSpinner;
    private DistributionModel model;

    public ConstantDistributionPanel(DistributionModel model){
        this.model = model;
        model.addView(this);
        initComponents();
        layoutComponents();
    }

    public NumberSpinner getValueSpinner() {
        return valueSpinner;
    }

    private void initComponents() {
        valueLabel = new JLabel(VALUE_LABEL);
        valueSpinner = new NumberSpinner(model.getRangeStart(),model.getRangeStart(),model.getRangeEnd(),1);
        valueSpinner.setVisualValueOffset(1-model.rangeOrigin());
    }

    private void layoutComponents() {
        setLayout(new MigLayout(
                "", //layout
                "0[][align right]0", //columns
                "" //rows

        ));
        add(valueLabel);
        add(valueSpinner, "grow, pushx," + SPINNER_WIDTH);
    }

    @Override
    public void update() {
       ((SpinnerNumberModel) valueSpinner.getModel()).setMaximum(model.getRangeEnd());
       ((SpinnerNumberModel) valueSpinner.getModel()).setMinimum(model.getRangeStart());
    }

    @Override
    public void beginUpdate() {}

    @Override
    public void endUpdate() {}
}
