package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketLevel;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.GoodsGenerator;
import com.mmuca.expLab.domain.distributions.IDistribution;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GoodsGeneratorTest {

    public static final int MINIMUM_GOODS_PER_LEVEL = 2;
    public static final int NUMBER_OF_GOODS =10;

    @Test
    public void numberOfGeneratedGoods(){
        Market market = newMarket();
        GoodsGenerator generator= new GoodsGenerator(goodLevelDistribution());
        generator.populate(market, NUMBER_OF_GOODS, MINIMUM_GOODS_PER_LEVEL);
        assertEquals("total # of goods should be as requested", NUMBER_OF_GOODS, market.getAllGoods().size());
        for (MarketLevel level: market.getAllLevels()) {
            assertTrue("minimum requirement should be fulfilled", level.getAllGoods().size() >= MINIMUM_GOODS_PER_LEVEL);
        }
        assertEquals("all goods should be unique", NUMBER_OF_GOODS, new HashSet<Good>(market.getAllGoods()).size());
    }

    @Test
    public void goodsAreAssignedToLevelsAsPerDistribution(){
        IDistribution levelDistribution = when(mock(IDistribution.class).nextInt()).thenReturn(0,0,2,2).getMock();
        Market market = newMarket();
        GoodsGenerator generator = new GoodsGenerator(levelDistribution);
        generator.populate(market,2,0);
        assertEquals("goods level should be set by distribution", 2, market.getLevel(0).getAllGoods().size());
        generator.populate(market,2,0);
        assertEquals("goods level should be set by distribution", 2, market.getLevel(2).getAllGoods().size());
    }

    private IDistribution goodLevelDistribution() {
        return when(mock(IDistribution.class).nextInt()).thenReturn(0).getMock();
    }

    private Market newMarket() {
        Market market = new Market();
        market.addLevel(new MarketLevel());
        market.addLevel(new MarketLevel());
        market.addLevel(new MarketLevel());
        return market;
    }
}
