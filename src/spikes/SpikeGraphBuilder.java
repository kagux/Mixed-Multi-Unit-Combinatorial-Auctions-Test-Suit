package spikes;


import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;

import javax.swing.*;
import java.awt.*;

public class SpikeGraphBuilder {
    public JPanel build() {
        // Note that we can use the same nodes and edges in two different graphs.
        Graph<Integer, String> g2 = new SparseMultigraph<Integer, String>();
        g2.addVertex((Integer)1);
        g2.addVertex((Integer)2);
        g2.addVertex((Integer)3);
        g2.addEdge("Edge-A", 1,3);
        g2.addEdge("Edge-B", 2,3, EdgeType.DIRECTED);
        g2.addEdge("Edge-C", 3, 2, EdgeType.DIRECTED);
        g2.addEdge("Edge-P", 2,3); // A parallel edge


        // The Layout<V, E> is parameterized by the vertex and edge types
        Layout<Integer, String> layout = new FRLayout<Integer, String>(g2);
        layout.setSize(new Dimension(100,100)); // sets the initial size of the space
         // The BasicVisualizationServer<V,E> is parameterized by the edge types
         BasicVisualizationServer<Integer,String> vv =
                  new BasicVisualizationServer<Integer,String>(layout);
    //     vv.setPreferredSize(new Dimension(350,350)); //Sets the viewing area size
        return vv;
    }
}