package com.mmuca.market;

public class Good {
    private String name;
    public Good(String name) {
        this.name=name;
    }

    public String getName(){
            return this.name;

    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Good good = (Good) o;

        if (!name.equals(good.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
