package com.mmuca.market;

import com.mmuca.market.distributions.IDistribution;
import com.mmuca.market.distributions.ValueRange;

import java.util.Random;

public class StubDistribution implements IDistribution {

    private ValueRange range;
    private Random random;

    public  StubDistribution(ValueRange range){
        this.range = range;
        this.random= new Random();
    }

    @Override
    public int flipCoin() {
        return range.getFirst() + (int) ((range.getLast() - range.getFirst()+1)*random.nextDouble());
    }
}
