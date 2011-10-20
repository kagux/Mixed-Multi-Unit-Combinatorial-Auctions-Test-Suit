package com.mmuca.expLab.domain.Market.graphs;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;

public class MarketGraphProvider {
    private Market market;
    private Graph<Object, MarketEdge> graph;

    public MarketGraphProvider() {

    }

    public Graph<Object, MarketEdge> graphFor(Market market) {
        this.market = market;
        return createGraph();
    }

    private Graph<Object, MarketEdge> createGraph() {
        graph = new DirectedSparseGraph<Object, MarketEdge>();
        createGoodsVertices();
        createTransformationsVertices();
        createEdges();
        return graph;
    }

    private void createTransformationsVertices() {
        for (Transformation transformation: market.getAllTransformations()){
            graph.addVertex(transformation);
        }
    }

    private void createGoodsVertices() {
        for (Good good : market.getAllGoods())
            graph.addVertex(good);
    }

    private void createEdges() {
        for (Transformation transformation: market.getAllTransformations()){
            createInputEdges(transformation);
            createOutputEdges(transformation);
        }
    }

    private void createInputEdges(Transformation transformation) {
        for (GoodBundle bundle: transformation.getInput())
            graph.addEdge(new MarketEdge(transformation, bundle.getGood()),bundle.getGood(),transformation);
    }

    private void createOutputEdges(Transformation transformation) {
        for (GoodBundle bundle: transformation.getOutput())
            graph.addEdge(new MarketEdge(transformation, bundle.getGood()),transformation,bundle.getGood());
    }
}
