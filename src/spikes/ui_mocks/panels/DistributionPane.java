/*
 * Created by JFormDesigner on Fri Oct 21 12:27:28 CEST 2011
 */

package spikes.ui_mocks.panels;

import com.jgoodies.forms.factories.Borders;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @author Boris Mikhaylov
 */
public class DistributionPane extends JPanel {
    public DistributionPane() {
        initComponents();
    }

    public CenteredDistrPane getCenteredDistrPane() {
        return centeredDistrPane;
    }

    public MarkovDistrPanel getMarkovForwardDistrPanel() {
        return markovForwardDistrPanel;
    }

    public MarkovDistrPanel getMarkovBackwardDistrPanel() {
        return markovBackwardDistrPanel;
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        uniformDistrPane = new JPanel();
        lbInfo = new JLabel();
        centeredDistrPane = new CenteredDistrPane();
        markovForwardDistrPanel = new MarkovDistrPanel();
        markovBackwardDistrPanel = new MarkovDistrPanel();

        //======== this ========
        setBorder(new CompoundBorder(
            new TitledBorder(" Distribution Options"),
            Borders.DLU2_BORDER));
        setLayout(new CardLayout());

        //======== uniformDistrPane ========
        {
            uniformDistrPane.setLayout(new GridBagLayout());
            ((GridBagLayout)uniformDistrPane.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)uniformDistrPane.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)uniformDistrPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)uniformDistrPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

            //---- lbInfo ----
            lbInfo.setText("The uniform distribution has no additional options");
            uniformDistrPane.add(lbInfo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(uniformDistrPane, "Uniform");
        add(centeredDistrPane, "Centered");
        add(markovForwardDistrPanel, "Markov Forward");
        add(markovBackwardDistrPanel, "Markov Backward");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel uniformDistrPane;
    private JLabel lbInfo;
    private CenteredDistrPane centeredDistrPane;
    private MarkovDistrPanel markovForwardDistrPanel;
    private MarkovDistrPanel markovBackwardDistrPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
