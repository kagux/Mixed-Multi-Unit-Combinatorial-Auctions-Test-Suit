package com.mmuca.expLab.domain.Market.transformations;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;

import java.util.ArrayList;

public class ITGenerator extends SingleBundleTransformationsGenerator {

    protected ArrayList<Good> getGoodsList(Market market, int currentKey) {
        return market.getLevel(currentKey).getAllGoods();
    }

    protected void addBundle(Good good, Transformation transformation) {
        transformation.addInput(new GoodBundle(good, 1));
    }

    protected int fromLevelOffset() {
        return 0;
    }

}
