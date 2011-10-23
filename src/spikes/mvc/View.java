package spikes.mvc;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class View extends JPanel implements IViewRefresh{
    private JLabel  lbNumGoods;
    private JLabel lbMinNumGoodsPerLevel;
    private JLabel  lbNumLevels;
    private JLabel  lbNumIOT;
    private JLabel lbResult;

    private JTextField tfNumGoods;
    private JTextField tfMinNumGoodsPerLevel;
    private JTextField tfNumLevels;
    private JTextField tfNumIOT;

    private JButton generateButton;

    private Model model;

    public View(Model model){
        model.addView(this);
        this.model = model;
        createGUI();
        refreshGUI();
    }

    public JTextField getNumGoodsTextField() {
        return tfNumGoods;
    }

    public JTextField getMinNumGoodsPerLevelTextField() {
        return tfMinNumGoodsPerLevel;
    }

    public JTextField getNumLevelsTextField() {
        return tfNumLevels;
    }

    public JTextField getNumIOTTextField() {
        return tfNumIOT;
    }

    private void createGUI() {
        setLayout(new MigLayout());
        lbNumGoods = new JLabel("# of goods");
        add(lbNumGoods);
        tfNumGoods = new JTextField(model.getNumGoods());
        add(tfNumGoods,"wrap, w 40!");
        lbMinNumGoodsPerLevel = new JLabel("# of goods per level");
        add(lbMinNumGoodsPerLevel);
        tfMinNumGoodsPerLevel = new JTextField(model.getMinGoodsPerLevel());
        add(tfMinNumGoodsPerLevel,"wrap, w 40!");
        lbNumLevels = new JLabel("# of levels");
        add(lbNumLevels);
        tfNumLevels = new JTextField(model.getNumLevels());
        add(tfNumLevels,"wrap, w 40!");
        lbNumIOT = new JLabel("# of IOT");
        add(lbNumIOT);
        tfNumIOT = new JTextField(model.getNumIOT());
        add(tfNumIOT,"wrap, w 40!");
        lbResult= new JLabel("Result: N/A");
        add(lbResult,"span");
        generateButton = new JButton("Generate");
        add(generateButton, "span, grow");
    }

    @Override

    public void refreshGUI() {
        lbResult.setText(model.result());
    }
}
