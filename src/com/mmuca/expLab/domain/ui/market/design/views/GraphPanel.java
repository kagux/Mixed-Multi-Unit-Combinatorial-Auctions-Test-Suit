package com.mmuca.expLab.domain.ui.market.design.views;

import com.mmuca.expLab.domain.Market.graphs.*;
import com.mmuca.expLab.domain.ui.market.design.models.MarketModel;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.Context;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import net.miginfocom.swing.MigLayout;
import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.TruePredicate;

import javax.swing.*;
import java.awt.geom.Point2D;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GraphPanel extends JPanel implements ObserverView{
    private MarketModel model;
    private MarketGraphProvider graphProvider;
    private ExecutorService threadsQueue;


    public GraphPanel(MarketModel model, MarketGraphProvider graphProvider){
        this.model = model;
        this.graphProvider = graphProvider;
        model.addView(this);
        initComponents();
        layoutComponents();
    }

    private void initComponents() {
        threadsQueue = Executors.newSingleThreadExecutor();
    }

    private void layoutComponents() {
        setLayout(new MigLayout());
    }

    @Override
    public void refresh() {
        threadsQueue.submit(new GraphUpdate());
    }

    private class GraphUpdate extends SwingWorker<Void, Void>{
        private BasicVisualizationServer<Object,MarketEdge> graphPanel;

        @Override
        protected Void doInBackground() throws Exception {
            //TODO: move this to factory
            Transformer<Object, Point2D> initializer = new MarketVertexAllTransLayoutTransformer(model.market(), getSize());
            Predicate<Context<Graph<Object, MarketEdge>, Object>> vertexIncludePredicate = TruePredicate.getInstance();
            Layout<Object, MarketEdge> layout = new StaticLayout<Object, MarketEdge>(graphProvider.graphFor(model.market()), initializer) ;
            graphPanel = new BasicVisualizationServer<Object,MarketEdge>(layout);
            graphPanel.getRenderContext().setVertexShapeTransformer(new MarketVertexShapeTransformer());
            graphPanel.getRenderContext().setVertexFillPaintTransformer(new MarketVertexColorTransformer());
            graphPanel.getRenderContext().setEdgeDrawPaintTransformer(new MarketEdgeColorTransformer());
            graphPanel.getRenderContext().setArrowDrawPaintTransformer(new MarketEdgeColorTransformer());
            graphPanel.getRenderContext().setArrowFillPaintTransformer(new MarketEdgeColorTransformer());
            graphPanel.getRenderContext().setVertexIncludePredicate(vertexIncludePredicate);
            return null;
        }

        protected void done(){
           removeAll();
           add(graphPanel, "grow, push");
           revalidate();
        }
    }
}
