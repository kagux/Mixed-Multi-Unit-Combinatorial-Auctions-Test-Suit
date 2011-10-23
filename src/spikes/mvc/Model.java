package spikes.mvc;

import com.mmuca.expLab.domain.Market.MarketGenerator;

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {
    ArrayList<View> views = new ArrayList<View>();
    private MarketGenerator.Parameters generatorParameters;

    public Model(){
       this.generatorParameters = new MarketGenerator.Parameters(6,10,1,1);
    }

    public  void addView(View view){
       views.add(view);
    }

    private void updateViews(){
       for (View view: views)
           view.refreshGUI();
    }

    public String getNumGoods(){
       return String.valueOf(generatorParameters.getNumGoods());
    }

    public void setNumGoods(String numGoods){
        generatorParameters.setNumGoods(Integer.parseInt(numGoods));
        updateViews();
    }

    public String getMinGoodsPerLevel(){
        return String.valueOf(generatorParameters.getMinGoodsPerLevel());
    }

    public void setMinGoodsPerLevel(String minNumGoodsPerLevel){
        generatorParameters.setMinGoodsPerLevel(Integer.parseInt(minNumGoodsPerLevel));
        updateViews();
    }

    public String getNumLevels(){
        return String.valueOf(generatorParameters.getNumLevels());
    }

    public void setNumLevels(String numLevels){
        generatorParameters.setNumLevels(Integer.parseInt(numLevels));
        updateViews();
    }

    public String getNumIOT(){
        return String.valueOf(generatorParameters.getNumIOT());
    }

    public void setNumIOT(String numIOT){
        generatorParameters.setNumIOT(Integer.parseInt(numIOT));
        updateViews();
    }

    public String result(){
        return "Result: "+ getNumGoods()+" "+ getMinGoodsPerLevel()+" "+ getNumLevels()+" "+ getNumIOT();
    }
}
