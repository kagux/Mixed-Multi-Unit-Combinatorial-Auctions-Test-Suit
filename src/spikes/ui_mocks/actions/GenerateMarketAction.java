package spikes.ui_mocks.actions;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketGenerator;
import com.mmuca.expLab.domain.Market.MarketGeneratorBuilder;
import com.mmuca.expLab.domain.Market.graphs.*;
import com.mmuca.expLab.domain.distributions.Distribution;
import com.mmuca.expLab.domain.distributions.IDistribution;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.Context;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import org.apache.commons.collections15.Predicate;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.TruePredicate;
import spikes.ui_mocks.DistributionFactory;
import spikes.ui_mocks.panels.MarketDesignerPane;

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
                Integer.parseInt(panel.getNumOfLevelsTextField().getText())+1,
                Integer.parseInt(panel.getNumOfGoodsTextField().getText()),
                Integer.parseInt(panel.getMinNumOfGoodsPerLevelTextField().getText()),
                Integer.parseInt(panel.getNumOfTransformationsTextField().getText())
        );


        MarketGenerator.Distributions distributions = new MarketGenerator.Distributions(
                DistributionFactory.create((Distribution)panel.getGoodsLevelDistrComboBox().getSelectedItem(), panel.getGoodsLevelDistrPanel(), -1),
                DistributionFactory.create((Distribution) panel.getIOTLevelDistrComboBox().getSelectedItem(), panel.getIOTLevelDistrPanel(), -1),
                (IDistribution)DistributionFactory.create((Distribution) panel.getInputBundlesGoodsLevelComboBox().getSelectedItem(),panel.getInputBundlesGoodsLevelDistrPanel()),
                (IDistribution)DistributionFactory.create((Distribution) panel.getOutputBundlesGoodsLevelComboBox().getSelectedItem(),panel.getOutputBundlesGoodsLevelDistrPanel()),
                DistributionFactory.create((Distribution)panel.getBundlesNumDistrComboBox().getSelectedItem(),panel.getBundlesNumDistrPanel()),
                DistributionFactory.create((Distribution) panel.getBundlesNumDistrComboBox().getSelectedItem(), panel.getBundlesNumDistrPanel())
        );

        MarketGeneratorBuilder builder = new MarketGeneratorBuilder(marketParameters, distributions);
        MarketGenerator generator = builder.build();
        MarketGraphProvider graphProvider = new MarketGraphProvider();
        Market market = generator.nextMarket();

        Transformer<Object, Point2D> initializer;
        Predicate<Context<Graph<Object, MarketEdge>, Object>> vertexIncludePredicate;

        if(panel.getOnlyIOTransformationsCheckBox().isSelected()){
            initializer = new MarketVertexOnlyIOTLayoutTransformer(market, panel.getMarketGraphPane().getSize());
            vertexIncludePredicate = new MarketVertexIncludeOnlyIOTPredicate();
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
        graphPanel.getRenderContext().setVertexIncludePredicate(vertexIncludePredicate);
        panel.getMarketGraphPane().add(graphPanel, BorderLayout.CENTER);
        panel.getMarketGraphPane().revalidate();
    }

}
