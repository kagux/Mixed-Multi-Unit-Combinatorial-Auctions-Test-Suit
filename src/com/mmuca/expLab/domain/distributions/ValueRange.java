package com.mmuca.expLab.domain.distributions;

public class ValueRange {
    private int start;
    private int end;

    public ValueRange(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int size() {
        return end - start +1;
    }

    public int indexOf(int value) {
        //TODO fast fail
        return value - start;
    }
}
