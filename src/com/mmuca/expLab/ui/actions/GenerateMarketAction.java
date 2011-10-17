package com.mmuca.expLab.ui.actions;

import com.mmuca.expLab.domain.Market.Market;
import com.mmuca.expLab.domain.Market.MarketGenerator;
import com.mmuca.expLab.domain.Market.MarketGeneratorBuilder;
import com.mmuca.expLab.domain.distributions.*;
import com.mmuca.expLab.ui.panels.MarketDesignerPane;

import javax.swing.*;
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
        Market market = generator.generate();
        System.out.println("success");
    }
}
