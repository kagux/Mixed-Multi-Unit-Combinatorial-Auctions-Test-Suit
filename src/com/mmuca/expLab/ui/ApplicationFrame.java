/*
 * Created by JFormDesigner on Mon Oct 17 16:56:58 CEST 2011
 */

package com.mmuca.expLab.ui;

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
        // Generated using JFormDesigner Evaluation license - Boris Mikhaylov
        mainTabbedPane = new MainTabbedPane();

        //======== this ========
        setTitle("Mixed Multi-Unit Combinatorial Auctions Experiments Suit");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(mainTabbedPane, BorderLayout.CENTER);
        setSize(850, 550);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Boris Mikhaylov
    private JTabbedPane mainTabbedPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
