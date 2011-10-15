package com.mmuca.expLab.domain.distributions;

import com.mmuca.expLab.domain.Require;

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
        Require.that(value >=start && value <= end,"Value needs to be in range ("+start+","+end+"); was "+value);
        return value - start;
    }
}
