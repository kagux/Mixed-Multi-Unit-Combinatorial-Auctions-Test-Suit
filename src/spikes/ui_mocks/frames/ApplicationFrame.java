/*
 * Created by JFormDesigner on Mon Oct 17 16:56:58 CEST 2011
 */

package spikes.ui_mocks.frames;

import spikes.ui_mocks.panels.MainTabbedPane;

import javax.swing.*;
import java.awt.*;

/**
 * @author Boris Mikhaylov
 */
public class ApplicationFrame extends JFrame {
    public ApplicationFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        mainTabbedPane = new MainTabbedPane();

        //======== this ========
        setTitle("Mixed Multi-Unit Combinatorial Auctions Experiments Suit");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 10, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 1.0, 0.0, 1.0E-4};
        contentPane.add(mainTabbedPane, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        setSize(850, 550);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private MainTabbedPane mainTabbedPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}