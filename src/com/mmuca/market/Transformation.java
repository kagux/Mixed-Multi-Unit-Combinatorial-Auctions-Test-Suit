package com.mmuca.market;

public class Transformation implements Cloneable{
    GoodBundleSet input;
    GoodBundleSet output;

    public Transformation(){
        input=new GoodBundleSet();
        output=new GoodBundleSet();
    }

    public void addInput(GoodBundle bundle) {
        input.add(bundle);
    }

    public GoodBundleSet getInput() {
        return input;
    }

    public void addOutput(GoodBundle bundle) {
        output.add(bundle);
    }

    public GoodBundleSet getOutput() {
        return output;
    }

    public Transformation clone(){
       try{
        return (Transformation) super.clone();
       }
       catch (CloneNotSupportedException e){
           return null; //todo this is wrong
       }
    }
}
