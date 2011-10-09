package com.mmuca.market.Stubs;

import com.mmuca.market.distributions.IDistribution;
import com.mmuca.market.distributions.ValueRange;

import java.util.Random;

public class StubLevelDistribution implements IDistribution {

    private ValueRange range;
    private Random random;

    public StubLevelDistribution(ValueRange range){
        this.range = range;
        this.random= new Random();
    }

    @Override
    public int flipCoin() {
        return range.getFirst() + (int) ((range.getLast() - range.getFirst()+1)*random.nextDouble());
    }
}
