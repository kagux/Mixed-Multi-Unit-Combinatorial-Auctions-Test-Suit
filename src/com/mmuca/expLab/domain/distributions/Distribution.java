package com.mmuca.expLab.domain.distributions;

public enum Distribution {
    UNIFORM("Uniform"),
    CENTERED("Centered"),
    MARKOV_FORWARD("Markov Forward"),
    MARKOV_BACKWARD("Markov Backward"),
    CONSTANT("Constant");

    private String distributionName;

    Distribution(String name) {
        this.distributionName = name;
    }

    @Override
    public String toString() {
        return distributionName;
    }
}
