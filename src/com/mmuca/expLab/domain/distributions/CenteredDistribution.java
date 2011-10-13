package com.mmuca.expLab.domain.distributions;

import java.util.ArrayList;
import java.util.Random;

public class CenteredDistribution implements IDistribution{
    private ValueRange range;
    private Parameters parameters;
    private CumulativeFunction cumulativeFunction;
    private Random randomGenerator;

    public CenteredDistribution(ValueRange range, Parameters parameters) {
        this.parameters = parameters;
        this.range = range;
        this.cumulativeFunction = new CumulativeFunction();
        this.randomGenerator = new Random();
    }

    public int flipCoin(){
        double rnd = randomGenerator.nextDouble();
        for (int i = range.getStart(); i<= range.getEnd();i++){
            if (cumulativeFunction.getProbabilityFor(i) > rnd)
                return i;
        }
        //TODO fast fail here;
        return -1;
    }


    public static class Parameters {
        private double alpha;
        private int center;

        public Parameters(int center, double alpha) {
            this.center = center;
            this.alpha = alpha;
        }

        public double getAlpha() {
            return alpha;
        }

        public int getCenter() {
            return center;
        }
    }

    private class CumulativeFunction{

        private DensityFunction densityFunction;
        private ArrayList<Double> cumulativeFunction;

        public CumulativeFunction(){
            this.densityFunction = new DensityFunction();
            this.cumulativeFunction=cumulativeFunction();
        }

        public double getProbabilityFor(int value){
           return cumulativeFunction.get(range.indexOf(value));
        }

        private ArrayList<Double>  cumulativeFunction() {
            ArrayList<Double>  cumulativeFunction = new ArrayList<Double>();
            cumulativeFunction.add(0,densityFunction.getProbabilityFor(0));
            for (int i=1; i<range.size();i++){
                cumulativeFunction.add(i,cumulativeFunction.get(i-1)+densityFunction.getProbabilityFor(i));
            }
            return cumulativeFunction;
        }

    }

    private class DensityFunction{
        private ArrayList<Double> densityFunction;

        public DensityFunction() {
            this.densityFunction = prepareDensityFunction();
        }

        public double getProbabilityFor(int valueIndex){
            return densityFunction.get(valueIndex);
        }

        private int centerIndex() {
            return range.indexOf(parameters.center);
        }

        private ArrayList<Double> prepareDensityFunction(){
            ArrayList<Double> densityFunction = new ArrayList<Double>();
            for (int i =0; i< range.size(); i++){
                densityFunction.add(i, probabilityFunction()*centerBasedCoefficient(i));
            }
            return  densityFunction;

        }
        private double probabilityFunction() {

            return (1 - parameters.alpha)/ probabilityDivisor();
        }

        private double centerBasedCoefficient(int valueIndex) {
            return Math.pow(parameters.alpha, distanceFromCenter(valueIndex));
        }

        private double probabilityDivisor() {
            return (1  + parameters.alpha - firstSubtrahend() - secondSubtrahend());
        }

        private double firstSubtrahend() {
            return Math.pow(parameters.alpha, range.size() - centerIndex() +1);
        }

        private double secondSubtrahend() {
            return Math.pow(parameters.alpha, centerIndex());
        }

        private int distanceFromCenter(int valueIndex) {
            return Math.abs(valueIndex - centerIndex());
        }
    }



}
