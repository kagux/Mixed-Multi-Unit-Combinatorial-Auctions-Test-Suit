package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.graphs.MarketGraphProvider;
import com.mmuca.expLab.domain.Market.MarketLevel;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import edu.uci.ics.jung.graph.Graph;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class MarketGraphTest {

    @Test
    public void OneInputTransformation_OneGood_Graph(){
        int numLevels = 1;
        int goodsPerLevel = 1;
        Market market = newMarket(numLevels, goodsPerLevel);
        Transformation transformation = new Transformation();
        Good good = new Good("good 0:0");
        transformation.addInput(new GoodBundle(good, 1));
        market.getLevel(0).addTransformation(transformation);

        Graph<Object, String> graph = newGraph(market);

        assertEquals("# of vertices", 2,graph.getVertexCount());
        assertTrue("graph should contain good vertex", graph.containsVertex(good));
        assertTrue("graph should contain transformation vertex", graph.containsVertex(transformation));
        assertEquals("# of edges",1, graph.getEdgeCount());
        assertTrue("edge", graph.findEdge(good, transformation) != null);
        assertTrue("edge should be directed", graph.findEdge(transformation,good) == null);
    }

    @Test
    public void OneOutputTransformation_OneGood_Graph(){
        int numLevels = 1;
        int goodsPerLevel = 1;
        Market market = newMarket(numLevels, goodsPerLevel);
        Transformation transformation = new Transformation();
        Good good = new Good("good 0:0");
        transformation.addOutput(new GoodBundle(good, 1));
        market.getLevel(0).addTransformation(transformation);

        Graph<Object, String> graph = newGraph(market);

        assertEquals("# of vertices", 2,graph.getVertexCount());
        assertTrue("graph should contain good vertex", graph.containsVertex(good));
        assertTrue("graph should contain transformation vertex", graph.containsVertex(transformation));
        assertEquals("# of edges",1, graph.getEdgeCount());
        assertTrue("edge", graph.findEdge(transformation, good) != null);
        assertTrue("edge should be directed", graph.findEdge(good,transformation) == null);
    }

    @Test
    public void MultipleTransformations_MultipleGoods_Graph(){
        int numLevels = 2;
        int goodsPerLevel = 1;
        Market market = newMarket(numLevels, goodsPerLevel);
        Good good_1 = new Good("good 0:0");
        Good good_2 = new Good("good 1:0");
        Transformation transformation_1 = new Transformation();
        transformation_1.addInput(new GoodBundle(good_2, 1));
        market.getLevel(1).addTransformation(transformation_1);

        Transformation transformation_2 = new Transformation();
        transformation_2.addInput(new GoodBundle(good_1,1));
        transformation_2.addOutput(new GoodBundle(good_2,1));
        market.getLevel(0).addTransformation(transformation_2);

        Graph<Object, String> graph = newGraph(market);

        assertEquals("# of vertices", 4,graph.getVertexCount());
        assertTrue("graph should contain all goods vertices", graph.containsVertex(good_1));
        assertTrue("graph should contain all goods vertices", graph.containsVertex(good_2));

        assertTrue("graph should contain all transformations vertices", graph.containsVertex(transformation_1));
        assertTrue("graph should contain all transformations vertices", graph.containsVertex(transformation_2));

        assertEquals("# of edges",3, graph.getEdgeCount());
        assertTrue("input edge", graph.findEdge(good_2,transformation_1) != null);
        assertTrue("input edge", graph.findEdge(good_1,transformation_2) != null);
        assertTrue("output edge", graph.findEdge(transformation_2, good_2) != null);
    }






    private Graph<Object, String> newGraph(Market market) {
        return new MarketGraphProvider().graphFor(market);
    }

    private Market newMarket(int numLevels, int goodsPerLevel) {
        Market market = new Market();
        createLevels(market, numLevels);
        for (int i=0; i<market.getAllLevels().size();i++)
            createGoods(market.getLevel(i),i,goodsPerLevel);
        return market;
    }

    private void createLevels(Market market, int amount) {
        for (int i=0;i<amount;i++)
            market.addLevel(new MarketLevel());
    }

    private void createGoods(MarketLevel level, int levelIndex, int amount){
        for (int i=0;i<amount;i++)
            level.addGood(new Good("good "+levelIndex+":"+i));
    }

}
