package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketLevel;
import com.mmuca.expLab.domain.Market.collections.GoodBundlesSet;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.BundlesGenerator;
import com.mmuca.expLab.domain.distributions.IDistribution;
import com.mmuca.expLab.domain.distributions.ISeededDistribution;
import org.junit.Test;
import org.mockito.InOrder;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class BundlesGeneratorTest {

    public static final int targetLevelSerialNum = 1;

    @Test
    public  void generatedBundles(){
        IDistribution numberOfBundlesDistribution = mock (IDistribution.class);
        when(numberOfBundlesDistribution.flipCoin()).thenReturn(1, 3);

        ISeededDistribution goodsLevelDistribution = mock(ISeededDistribution.class);
        when(goodsLevelDistribution.flipCoin()).thenReturn(targetLevelSerialNum);

        BundlesGenerator generator = new BundlesGenerator(goodsLevelDistribution,numberOfBundlesDistribution);
        Market market = newMarket();
        GoodBundlesSet bundles = generator.generate(market, targetLevelSerialNum);

        InOrder inOrder  = inOrder(goodsLevelDistribution);
        inOrder.verify(goodsLevelDistribution).setSeed(targetLevelSerialNum);
        inOrder.verify(goodsLevelDistribution).flipCoin();
        verify(numberOfBundlesDistribution).flipCoin();

        assertEquals("# of bundles should be set by distribution", 1, bundles.size());
        assertTrue("goods should be picked only from level set by distribution", market.getLevel(targetLevelSerialNum).getAllGoods().containsAll(bundles.getAllGoods()));
        assertEquals("# of bundles is capped by # of goods at selected level", 2, generator.generate(newMarket(), targetLevelSerialNum).size());
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
