package com.mmuca.market;

import java.util.ArrayList;

public class OTGenerator extends SingleBundleTransformationsGenerator{

    protected ArrayList<Good> getGoodsList(ArrayList<MarketLevel> levels, int currentKey) {
        return new ArrayList<Good>(levels.get(currentKey - 1).getAllGoods());
    }

    protected void populateTransformation(Good good, Transformation transformation) {
        transformation.addOutput(new GoodBundle(good,1));
    }

    protected int fromLevelOffset() {
        return 1;
    }

    protected int toLevelOffset() {
        return 0;
    }
}
