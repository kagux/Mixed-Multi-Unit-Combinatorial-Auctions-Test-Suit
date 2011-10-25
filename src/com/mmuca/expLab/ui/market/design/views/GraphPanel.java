package com.mmuca.expLab.ui.market.design.views;

import com.mmuca.expLab.domain.Market.graphs.MarketEdge;
import com.mmuca.expLab.domain.Market.graphs.MarketGraphVisualizationServerProvider;
import com.mmuca.expLab.ui.market.design.models.MarketModel;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GraphPanel extends JPanel implements ObserverView{
    private MarketModel model;
    private MarketGraphVisualizationServerProvider visualizationServerProvider;
    private ExecutorService threadsQueue;


    public GraphPanel(MarketModel model, MarketGraphVisualizationServerProvider visualizationServerProvider){
        this.model = model;
        this.visualizationServerProvider = visualizationServerProvider;
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
        threadsQueue.submit(new GraphUpdater());
    }

    private class GraphUpdater extends SwingWorker<Void, Void>{
        private BasicVisualizationServer<Object,MarketEdge> graphPanel;

        @Override
        protected Void doInBackground() throws Exception {
            if (model.isShowOnlyIOT())  graphPanel = visualizationServerProvider.getOnlyIOTServerFor(model.market(),getSize());
            else                        graphPanel = visualizationServerProvider.getServerFor(model.market(),getSize());
            return null;
        }

        protected void done(){
           removeAll();
           add(graphPanel, "grow, push");
           revalidate();
        }
    }
}
