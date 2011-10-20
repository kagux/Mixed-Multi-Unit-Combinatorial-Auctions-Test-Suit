package com.mmuca.expLab.domain.Market.graphs;

import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import com.mmuca.expLab.domain.Require;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.Context;
import org.apache.commons.collections15.Predicate;

public class MarketVertexIncludeOnlyIOTPredicate implements Predicate<Context<Graph<Object, MarketEdge>, Object>>{

    @Override
    public boolean evaluate(Context<Graph<Object, MarketEdge>, Object> graphObjectContext) {
        Require.that(isGood(graphObjectContext) || graphObjectContext.element instanceof Transformation, "vertex needs to be either good or transformation");
        return isGood(graphObjectContext) || isIOTransformation((Transformation) graphObjectContext.element);
    }

    private boolean isGood(Context<Graph<Object, MarketEdge>, Object> graphObjectContext) {
        return graphObjectContext.element instanceof Good;
    }

    private boolean isIOTransformation(Transformation transformation){
        return transformation.getInput().size()>0 && transformation.getOutput().size()>0;
    }
}
