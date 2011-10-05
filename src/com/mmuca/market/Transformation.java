package com.mmuca.market;

import com.mmuca.market.collections.GoodBundlesSet;

public class Transformation implements Cloneable{
    GoodBundlesSet input;
    GoodBundlesSet output;

    public Transformation(){
        input=new GoodBundlesSet();
        output=new GoodBundlesSet();
    }

    public void addInput(GoodBundle bundle) {
        input.add(bundle);
    }

    public GoodBundlesSet getInput() {
        return input;
    }

    public void addOutput(GoodBundle bundle) {
        output.add(bundle);
    }

    public GoodBundlesSet getOutput() {
        return output;
    }

    public Transformation clone(){
       try{
        return (Transformation) super.clone();
       }
       catch (CloneNotSupportedException e){
           throw new InternalError();
       }
    }
}
