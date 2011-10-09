package com.mmuca.market;

import com.mmuca.market.Stubs.StubBundlesDistribution;
import com.mmuca.market.Stubs.StubIOTGoodsLevelDistribution;
import com.mmuca.market.collections.GoodBundlesSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class BundlesGeneratorTest {

    public static final int targetLevelSerialNum = 1;

    @Test
    public void numberOfBundlesIsDeterminedByDistribution(){
        //this stub distribution returns fixed value
        StubBundlesDistribution goodsDistribution = new StubBundlesDistribution();
        BundlesGenerator generator = new BundlesGenerator(new StubIOTGoodsLevelDistribution(), goodsDistribution);
        Market market = newMarket();

        //predefined fixed values for stub distribution
        ArrayList<Integer> possibleNumberOfBundles = new ArrayList<Integer>();
        possibleNumberOfBundles.add(3);
        possibleNumberOfBundles.add(4);

        for (Integer numberOfBundles: possibleNumberOfBundles){
            goodsDistribution.setNumberOfBundles(numberOfBundles);
            assertEquals(
                    "number of bundles should be defined by distribution or by number of goods at selected level by goods level distribution",
                    Math.min(market.getLevel(targetLevelSerialNum).getAllGoods().size(), numberOfBundles.intValue()),
                    generator.generate(market,targetLevelSerialNum).size()
                    );
        }
    }

    @Test
    public void bundlesAreFormedFromGoodsDeterminedByDistribution(){
        //stub for this distribution returns good's level same as seeded value, which we force to be targetLevelSerialNum
        BundlesGenerator generator = new BundlesGenerator(new StubIOTGoodsLevelDistribution(), new StubBundlesDistribution(3));
        Market market = newMarket();

        ArrayList<Integer> possibleTargetLevel = new ArrayList<Integer>();
                possibleTargetLevel.add(1);
                possibleTargetLevel.add(2);

        for (Integer targetLevelSerialNum: possibleTargetLevel){
            ArrayList<Good> goods = market.getLevel(targetLevelSerialNum).getAllGoods();
            GoodBundlesSet bundles = generator.generate(market, targetLevelSerialNum);
            for (Iterator<GoodBundle> iterator=bundles.iterator();iterator.hasNext();) {
                assertTrue("Goods for input should be picked as per distribution",goods.contains(iterator.next().getGood()));
            }
        }

    }
    

    private Market newMarket() {
        MarketLevel level_1 = new MarketLevel();
        MarketLevel level_2 = new MarketLevel();
        MarketLevel level_3 = new MarketLevel();
        MarketLevel level_4 = new MarketLevel();

        Good good_1 = new Good("good 1");
        Good good_2 = new Good("good 2");
        Good good_3 = new Good("good 3");
        Good good_4 = new Good("good 4");
        Good good_5 = new Good("good 5");
        Good good_6 = new Good("good 6");
        Good good_7 = new Good("good 7");

        level_1.addGood(good_1);
        level_1.addGood(good_2);

        level_2.addGood(good_3);
        level_2.addGood(good_4);

        level_3.addGood(good_5);
        level_3.addGood(good_6);

        level_4.addGood(good_7);

        Market market= new Market();
        market.add(level_1);
        market.add(level_2);
        market.add(level_3);
        market.add(level_4);
        return market;
    }


}
