package com.mmuca.expLab;

import com.mmuca.expLab.domain.Market.goods.Good;
import com.mmuca.expLab.domain.Market.goods.bundles.GoodBundle;
import com.mmuca.expLab.domain.Market.graphs.MarketEdge;
import com.mmuca.expLab.domain.Market.graphs.MarketVertexIncludeOnlyIOTPredicate;
import com.mmuca.expLab.domain.Market.transformations.Transformation;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.Context;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class MarketVertexIncludeOnlyIOTPredicateTest {
    @Test
    public void includeOnlyIOTransformations(){
        MarketVertexIncludeOnlyIOTPredicate predicate = new MarketVertexIncludeOnlyIOTPredicate();
        assertTrue("include IO Transformation", predicate.evaluate(Context.getInstance(graph(), ioTransformation())));
        assertFalse("should not include Input transformation", predicate.evaluate(Context.getInstance(graph(), inputTransformation())));
        assertFalse("should not include Output transformation", predicate.evaluate(Context.getInstance(graph(), outputTransformation())));
        assertTrue("include good",predicate.evaluate(Context.getInstance(graph(),(Object)new Good("good"))));
    }

    private Graph<Object, MarketEdge> graph() {
        return new DirectedSparseGraph<Object, MarketEdge>();
    }

    private Object outputTransformation() {
        Transformation outputTransformation = new Transformation();
        outputTransformation.addOutput(newBundle());
        return outputTransformation;
    }

    private Object inputTransformation() {
        Transformation inputTransformation = new Transformation();
        inputTransformation.addInput(newBundle());
        return inputTransformation;
    }

    private Object ioTransformation() {
        Transformation ioTransformation = new Transformation();
        ioTransformation.addInput(newBundle());
        ioTransformation.addOutput(newBundle());
        return ioTransformation;
    }

    private GoodBundle newBundle() {
        return new GoodBundle(new Good("good"),1);
    }
}
