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
        GoodsGenerator generator= new GoodsGenerator(goodLevelDistribution(), NUMBER_OF_GOODS, MINIMUM_GOODS_PER_LEVEL);
        generator.populate(market);
        assertEquals("total # of goods should be as requested", NUMBER_OF_GOODS, market.getAllGoods().size());
        for (MarketLevel level: market.getAllLevels()) {
            assertTrue("minimum requirement should be fulfilled", level.getAllGoods().size() >= MINIMUM_GOODS_PER_LEVEL);
        }
        assertEquals("all goods should be unique", NUMBER_OF_GOODS, new HashSet<Good>(market.getAllGoods()).size());
    }

    @Test
    public void goodsAreAssignedToLevelsAsPerDistribution(){
        IDistribution levelDistribution = mock(IDistribution.class);
        when(levelDistribution.flipCoin()).thenReturn(0,0,2,2);
        Market market = newMarket();
        GoodsGenerator generator = new GoodsGenerator(levelDistribution,2,0);
        generator.populate(market);
        assertEquals("goods level should be set by distribution", 2, market.getLevel(0).getAllGoods().size());
        generator.populate(market);
        assertEquals("goods level should be set by distribution", 2, market.getLevel(2).getAllGoods().size());
    }

    private IDistribution goodLevelDistribution() {
        IDistribution goodLevelDistribution = mock(IDistribution.class);
        when(goodLevelDistribution.flipCoin()).thenReturn(0);
        return goodLevelDistribution;
    }

    private Market newMarket() {
        Market market = new Market();
        market.add(new MarketLevel());
        market.add(new MarketLevel());
        market.add(new MarketLevel());
        return market;
    }
}
