package spikes.mvc;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MVS Spike");
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
        frame.getContentPane().add(view);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 300);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
