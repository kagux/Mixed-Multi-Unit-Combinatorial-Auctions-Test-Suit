package com.mmuca.expLab.ui.actions;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketGenerator;
import com.mmuca.expLab.domain.Market.MarketGeneratorBuilder;
import com.mmuca.expLab.domain.Market.graphs.*;
import com.mmuca.expLab.domain.distributions.*;
import com.mmuca.expLab.ui.panels.MarketDesignerPane;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.Context;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.TruePredicate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;

public class GenerateMarketAction extends AbstractAction{

    private MarketDesignerPane panel;

    public GenerateMarketAction(MarketDesignerPane panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MarketGenerator.Parameters marketParameters = new MarketGenerator.Parameters(
                Integer.parseInt(panel.getNumOfLevelsTextField().getText()),
                Integer.parseInt(panel.getNumOfGoodsTextField().getText()),
                Integer.parseInt(panel.getMinNumOfGoodsPerLevelTextField().getText()),
                Integer.parseInt(panel.getNumOfTransformationsTextField().getText())
        );

        IDistribution goodLevelDistribution = new UniformDistribution();
        IDistribution iotLevelDistribution = new UniformDistribution();
        ITargetedDistribution inputBundlesGoodLevelDistribution = new ForwardMarkovDistribution(0.1,0.1);
        ITargetedDistribution outputBundlesGoodLevelDistribution = new BackwardMarkovDistribution(0.1,0.1);
        IDistribution numberOfInputBundlesDistribution = new CenteredDistribution(1,0.9);
        IDistribution numberOfOutputBundlesDistribution = new CenteredDistribution(1,0.9);

        MarketGeneratorBuilder.Distributions distributions = new MarketGeneratorBuilder.Distributions(
                goodLevelDistribution,
                iotLevelDistribution,
                inputBundlesGoodLevelDistribution,
                outputBundlesGoodLevelDistribution,
                numberOfInputBundlesDistribution,
                numberOfOutputBundlesDistribution
        );

        MarketGeneratorBuilder builder = new MarketGeneratorBuilder(marketParameters, distributions);
        MarketGenerator generator = builder.build();
        MarketGraphProvider graphProvider = new MarketGraphProvider();
        Market market = generator.nextMarket();

        Transformer<Object, Point2D> initializer;
        Predicate<Context<Graph<Object, MarketEdge>, Object>> vertexIncludePredicate;
        if(panel.getOnlyIOTransformationsCheckBox().isSelected()){
            initializer = new MarketVertexOnlyIOTLayoutTransformer(market, panel.getMarketGraphPane().getSize());
            vertexIncludePredicate = new MarketVertexIncludeOnlyIOTPredicate() ;
        }
        else {
            initializer = new MarketVertexAllTransLayoutTransformer(market, panel.getMarketGraphPane().getSize());
            vertexIncludePredicate = TruePredicate.getInstance();
        }


        Layout<Object, MarketEdge> layout = new StaticLayout<Object, MarketEdge>(graphProvider.graphFor(market), initializer) ;
        layout.setSize(panel.getMarketGraphPane().getSize());
        BasicVisualizationServer<Object,MarketEdge> graphPanel = new BasicVisualizationServer<Object,MarketEdge>(layout);
        graphPanel.getRenderContext().setVertexShapeTransformer(new MarketVertexShapeTransformer());
        graphPanel.getRenderContext().setVertexFillPaintTransformer(new MarketVertexColorTransformer());
        graphPanel.getRenderContext().setEdgeDrawPaintTransformer(new MarketEdgeColorTransformer());
        graphPanel.getRenderContext().setArrowDrawPaintTransformer(new MarketEdgeColorTransformer());
        graphPanel.getRenderContext().setArrowFillPaintTransformer(new MarketEdgeColorTransformer());
        ;
        graphPanel.getRenderContext().setVertexIncludePredicate(vertexIncludePredicate);
        panel.getMarketGraphPane().add(graphPanel, BorderLayout.CENTER);
        panel.getMarketGraphPane().revalidate();
    }
}
