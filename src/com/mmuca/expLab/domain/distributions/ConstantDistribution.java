package com.mmuca.expLab.domain.distributions;

public class ConstantDistribution implements IDistribution {
    private int value;

    public ConstantDistribution(int value) {
        this.value = value;
    }

    @Override
    public int nextInt() {
        return value;
    }

    @Override
    public void setValueRange(ValueRange range) {}

    @Override
    public void setTarget(int index) { }
}
