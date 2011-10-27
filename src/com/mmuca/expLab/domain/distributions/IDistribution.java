package com.mmuca.expLab.domain.distributions;

public interface IDistribution {
    public int nextInt();
    public void setValueRange(ValueRange range);
    public void setTarget(int index);
}
