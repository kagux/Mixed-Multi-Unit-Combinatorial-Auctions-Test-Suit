package com.mmuca.expLab.ui.actions;

import com.mmuca.expLab.domain.Market.*;
import com.mmuca.expLab.domain.Market.graphs.MarketGraphProvider;
import com.mmuca.expLab.domain.Market.graphs.MarketVertexColorTransformer;
import com.mmuca.expLab.domain.Market.graphs.MarketVertexLayoutTransformer;
import com.mmuca.expLab.domain.Market.graphs.MarketVertexShapeTransformer;
import com.mmuca.expLab.domain.distributions.*;
import com.mmuca.expLab.ui.panels.MarketDesignerPane;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.visualization.VisualizationViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
        IDistribution numberOfInputBundlesDistribution = new UniformDistribution();
        IDistribution numberOfOutputBundlesDistribution = new UniformDistribution();

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
        Layout<Object, String> layout = new StaticLayout<Object, String>(graphProvider.graphFor(market),new MarketVertexLayoutTransformer(market,panel.getMarketGraphPane().getSize() )) ;
        layout.setSize(panel.getMarketGraphPane().getSize());
        VisualizationViewer<Object,String> graphPanel = new VisualizationViewer<Object,String>(layout);
        graphPanel.getRenderContext().setVertexShapeTransformer(new MarketVertexShapeTransformer());
        graphPanel.getRenderContext().setVertexFillPaintTransformer(new MarketVertexColorTransformer());
        panel.getMarketGraphPane().add(graphPanel, BorderLayout.CENTER);
        panel.getMarketGraphPane().revalidate();
    }
}
