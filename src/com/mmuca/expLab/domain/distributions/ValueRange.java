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

    public void setStart(int start){
        Require.that(end > start, "Range start should be less than end");
        this.start=start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end){
       Require.that(end > start, "Range end should be greater than start");
        this.end=end;
    }

    public int size() {
        return end - start +1;
    }

    public int indexOf(int value) {
        Require.that(value >=start && value <= end,"Value needs to be in range ("+start+","+end+"); was "+value);
        return value - start;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValueRange that = (ValueRange) o;

        if (end != that.end) return false;
        if (start != that.start) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }
}
