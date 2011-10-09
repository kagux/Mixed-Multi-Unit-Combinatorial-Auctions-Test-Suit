package com.mmuca.market;

import com.mmuca.market.collections.GoodBundlesSet;

import java.util.Iterator;

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

    public void addAllInput(GoodBundlesSet bundles) {
        for (Iterator<GoodBundle> iterator=bundles.iterator();iterator.hasNext();)
            addInput(iterator.next());
    }


    public GoodBundlesSet getInput() {
        return input;
    }

    public void addOutput(GoodBundle bundle) {
        output.add(bundle);
    }

    public void addAllOutput(GoodBundlesSet bundles) {
        for (Iterator<GoodBundle> iterator=bundles.iterator();iterator.hasNext();)
            addOutput(iterator.next());
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
