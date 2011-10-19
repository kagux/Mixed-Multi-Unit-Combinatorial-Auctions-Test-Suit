package spikes;

import javax.swing.*;

public class GraphXSpike {
    public static void main(String args[]){
        JFrame frame = new JFrame("GraphX Spike");
        SpikeGraphBuilder graphBuilder = new SpikeGraphBuilder();
        JPanel content = new JPanel();
        frame.getContentPane().add(content);
        frame.setLocation(500, 200);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        content.add(graphBuilder.build());
        content.revalidate();
    }
}
