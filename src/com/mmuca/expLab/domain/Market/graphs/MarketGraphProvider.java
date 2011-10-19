package com.mmuca.expLab.domain.Market.graphs;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;

public class MarketGraphProvider {
    private Market market;
    private Graph<Object, String> graph;

    public MarketGraphProvider() {

    }

    public Graph<Object, String> graphFor(Market market) {
        this.market = market;
        return createGraph();
    }

    private Graph<Object, String> createGraph() {
        graph = new DirectedSparseGraph<Object, String>();
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
            graph.addEdge(bundle.getGood()+"->"+transformation,bundle.getGood(),transformation);
    }

    private void createOutputEdges(Transformation transformation) {
        for (GoodBundle bundle: transformation.getOutput())
            graph.addEdge(transformation+"->"+bundle.getGood(),transformation,bundle.getGood());
    }
}
