package com.mmuca.expLab.domain.Market.graphs;

import com.mmuca.expLab.domain.Market.Market;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.Context;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.TruePredicate;

import java.awt.*;
import java.awt.geom.Point2D;

public class MarketGraphVisualizationServerProvider {
    private GraphTransformers graphTransformers;
    private MarketGraphProvider graphProvider;

    public MarketGraphVisualizationServerProvider(GraphTransformers graphTransformers, MarketGraphProvider graphProvider){
        this.graphTransformers = graphTransformers;
        this.graphProvider = graphProvider;
    }

    public BasicVisualizationServer<Object,MarketEdge> getServerFor(Market market, Dimension size){
        return createServer(market, new MarketVertexAllTransLayoutTransformer(market, size), TruePredicate.<Context<Graph<Object, MarketEdge>, Object>>getInstance());
    }

    public BasicVisualizationServer<Object,MarketEdge> getOnlyIOTServerFor(Market market, Dimension size){
        return createServer(market, new MarketVertexOnlyIOTLayoutTransformer(market, size), new MarketVertexIncludeOnlyIOTPredicate());
    }

    private BasicVisualizationServer<Object, MarketEdge> createServer(Market market, Transformer<Object, Point2D> transformer, Predicate<Context<Graph<Object, MarketEdge>, Object>> predicate) {
        Layout<Object, MarketEdge> layout = new StaticLayout<Object, MarketEdge>(graphProvider.graphFor(market), transformer) ;
        BasicVisualizationServer<Object,MarketEdge> visualizationServer = new BasicVisualizationServer<Object,MarketEdge>(layout);
        visualizationServer.getRenderContext().setVertexShapeTransformer(graphTransformers.vertexShapeTransformer);
        visualizationServer.getRenderContext().setVertexFillPaintTransformer(graphTransformers.vertexColorTransformer);
        visualizationServer.getRenderContext().setEdgeDrawPaintTransformer(graphTransformers.edgeColorTransformer);
        visualizationServer.getRenderContext().setArrowDrawPaintTransformer(graphTransformers.edgeColorTransformer);
        visualizationServer.getRenderContext().setArrowFillPaintTransformer(graphTransformers.edgeColorTransformer);
        visualizationServer.getRenderContext().setVertexIncludePredicate(predicate);
        return visualizationServer;
    }

    public static class GraphTransformers {
        private final Transformer<Object, Shape> vertexShapeTransformer;
        private final Transformer<Object, Paint> vertexColorTransformer;
        private final Transformer<MarketEdge, Paint> edgeColorTransformer;

        public GraphTransformers(Transformer<Object, Shape> vertexShapeTransformer, Transformer<Object, Paint> vertexColorTransformer, Transformer<MarketEdge, Paint> edgeColorTransformer) {
            this.vertexShapeTransformer = vertexShapeTransformer;
            this.vertexColorTransformer = vertexColorTransformer;
            this.edgeColorTransformer = edgeColorTransformer;
        }

        public Transformer<Object, Shape> getVertexShapeTransformer() {
            return vertexShapeTransformer;
        }

        public Transformer<Object, Paint> getVertexColorTransformer() {
            return vertexColorTransformer;
        }

        public Transformer<MarketEdge, Paint> getEdgeColorTransformer() {
            return edgeColorTransformer;
        }
    }
}
