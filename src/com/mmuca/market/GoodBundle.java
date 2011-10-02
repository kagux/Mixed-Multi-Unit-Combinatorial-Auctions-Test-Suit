package com.mmuca.market;

public class GoodBundle {
    private Good good;
    private int amount;

    public GoodBundle(Good good, int amount) {
        this.good=good;
        this.amount=amount;
    }
    
    public Good getGood(){
        return good;
    }
    
    public int getAmount(){
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodBundle bundle = (GoodBundle) o;

        if (amount != bundle.amount) return false;
        if (!good.equals(bundle.good)) return false;

        return true;
    }

    @Override
    public int hashCode(){
        return good.hashCode();
    }
}
