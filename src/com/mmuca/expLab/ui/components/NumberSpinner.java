package com.mmuca.expLab.ui.components;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class NumberSpinner  extends JSpinner{

    public static class SpinnerModel extends SpinnerNumberModel{
        private int valueOffset=0;

        public SpinnerModel(Number value, Comparable minimum, Comparable maximum, Number stepSize){
            super(value,minimum,maximum,stepSize);
        }

        public void setValueOffset(int valueOffset){
            this.valueOffset = valueOffset;
            fireStateChanged();
        }

        @Override
        public void setMinimum(Comparable minimum) {
            if (minimum instanceof Integer && (Integer) super.getValue() < (Integer) minimum){
                super.setValue(minimum);
            }
            super.setMinimum(minimum);
        }

        @Override
        public Comparable getMinimum() {
            return  (Comparable) addOffset((Number) super.getMinimum());

        }

        @Override
        public void setMaximum(Comparable maximum) {
            if (maximum instanceof Integer && (Integer) super.getValue() > (Integer)maximum){
                super.setValue(maximum);
            }
            super.setMaximum(maximum);
        }

        @Override
        public Comparable getMaximum() {
            Number maximum = (Number) super.getMaximum();
            if (maximum instanceof Integer && valueOffset < 0){
                if ( (Integer) maximum == Integer.MAX_VALUE){
                    maximum =  (Integer) maximum + valueOffset;
                }
            }
            return (Comparable) addOffset(maximum);
        }

        @Override
        public Object getValue() {
            return addOffset((Number) super.getValue());
        }

        @Override
        public void setValue(Object value) {
            super.setValue(removeOffset((Number) value));
        }

        @Override
        public Object getNextValue() {
            return addOffset((Number) super.getNextValue());
        }

        @Override
        public Object getPreviousValue() {
            return addOffset((Number) super.getPreviousValue());
        }

        public Object getAdjustedValue(){
            return super.getValue();
        }


        private Object removeOffset(Number value){
            return applyOffset(value, -valueOffset);
        }

        private Object addOffset(Number value){
            return applyOffset(value, valueOffset);
        }

        private Object applyOffset(Number value, int offset) {
            Number newValue = value;
            if (value instanceof Integer) {
                newValue = value.intValue()+ offset;
            }
            return newValue;
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

    public NumberSpinner(int value, int minimum, int maximum, int stepSize){
        super(new SpinnerModel(value, minimum, maximum, stepSize));
        setStrictEditor();
    }

    public NumberSpinner(double value, double minimum, double maximum, double stepSize) {
        super(new SpinnerModel(value, minimum, maximum, stepSize));
        setStrictEditor();
    }

    public void setVisualValueOffset(int valueOffset){
        ((SpinnerModel)getModel()).setValueOffset(valueOffset);
        revalidate();
    }

    public Object getRealValue(){
       return ((SpinnerModel)getModel()).getAdjustedValue();
    }

    private void setStrictEditor() {
        setEditor(new StrictNumberEditor(this));
    }

}
