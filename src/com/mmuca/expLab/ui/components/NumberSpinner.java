package com.mmuca.expLab.ui.components;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class NumberSpinner  extends JSpinner{
    private static class OffsetNumberModel extends SpinnerNumberModel{

        public OffsetNumberModel(Number value, Comparable minimum, Comparable maximum, Number stepSize){
            super(value,minimum,maximum,stepSize);
        }

    }
    private class StrictNumberEditor extends NumberEditor {
        public StrictNumberEditor(JSpinner spinner) {
            super(spinner);
            setStrictFormatter();
        }

        private void setStrictFormatter() {
            NumberFormatter formatter = (NumberFormatter) getTextField().getFormatter();
            formatter.setAllowsInvalid(false);
            formatter.setCommitsOnValidEdit(true);
        }
    }

    public NumberSpinner(Number value, Comparable minimum, Comparable maximum, Number stepSize){
        super(new SpinnerNumberModel(value, minimum,maximum, stepSize));
        setStrictEditor();
    }

    public NumberSpinner(int value, int minimum, int maximum, int stepSize){
        super(new SpinnerNumberModel(value, minimum,maximum, stepSize));
        setStrictEditor();
    }

    public NumberSpinner(double value, double minimum, double maximum, double stepSize) {
        super(new SpinnerNumberModel(value, minimum,maximum, stepSize));
        setStrictEditor();
    }

    private void setStrictEditor() {
        setEditor(new StrictNumberEditor(this));
    }
}
