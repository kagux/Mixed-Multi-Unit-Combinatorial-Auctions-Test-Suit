package com.mmuca.expLab.domain.distributions;

import com.mmuca.expLab.domain.Require;

import java.util.ArrayList;
import java.util.Random;

public class CenteredDistribution implements IDistribution{
    private Parameters parameters;
    private CumulativeFunction cumulativeFunction;
    private Random randomGenerator;

    public CenteredDistribution(Parameters parameters) {
        this.parameters = parameters;
        this.cumulativeFunction = new CumulativeFunction();
        this.randomGenerator = new Random();
    }

    public int nextInt(){
        double rnd = randomGenerator.nextDouble()*cumulativeFunction.getMax();
        for (int i = parameters.range.getStart(); i<= parameters.range.getEnd();i++){
            if (cumulativeFunction.getProbabilityFor(i) > rnd)
                return i;
        }
        Require.thatUnreachable("Each value should have corresponding probability in cumulative function");
        return -1;
    }


    public static class Parameters {
        private ValueRange range;
        private double alpha;
        private int center;

        public Parameters(ValueRange range, int center, double alpha) {
            this.range = range;
            this.center = center;
            this.alpha = alpha;
        }

        public double getAlpha() {
            return alpha;
        }

        public int getCenter() {
            return center;
        }

        public ValueRange getRange() {
            return range;
        }
    }

    private class CumulativeFunction{
        private double max=0;
        private DensityFunction densityFunction;
        private ArrayList<Double> cumulativeFunction;

        public CumulativeFunction(){
            this.densityFunction = new DensityFunction();
            this.cumulativeFunction=cumulativeFunction();
        }

        public double getProbabilityFor(int value){
           return cumulativeFunction.get(parameters.range.indexOf(value));
        }

        private ArrayList<Double>  cumulativeFunction() {
            ArrayList<Double>  cumulativeFunction = new ArrayList<Double>();
            cumulativeFunction.add(0,densityFunction.getProbabilityFor(0));
            for (int i=1; i<parameters.range.size();i++){
                cumulativeFunction.add(i,cumulativeFunction.get(i-1)+densityFunction.getProbabilityFor(i));
            }
            return cumulativeFunction;
        }

        public double getMax() {
            if (max == 0) max=assessMax();
            return max;
        }

        private double assessMax(){
            double max= 0;
            for(double value: cumulativeFunction)
                max = Math.max(value,max);
            return max;
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
            return parameters.range.indexOf(parameters.center);
        }

        private ArrayList<Double> prepareDensityFunction(){
            ArrayList<Double> densityFunction = new ArrayList<Double>();
            for (int i =0; i< parameters.range.size(); i++){
                densityFunction.add(i, probabilityFunction() * centerBasedCoefficient(i));
            }
            return densityFunction;

        }
        private double probabilityFunction() {

            return (1 - parameters.alpha)/ probabilityDivisor();
        }

        private double centerBasedCoefficient(int valueIndex) {
            return Math.pow(parameters.alpha, distanceFromCenter(valueIndex)+1);
        }

        private double probabilityDivisor() {
            return (1  + parameters.alpha - firstSubtrahend() - secondSubtrahend());
        }

        private double firstSubtrahend() {
            return Math.pow(parameters.alpha, parameters.range.size() - centerIndex() +1);
        }

        private double secondSubtrahend() {
            return Math.pow(parameters.alpha, centerIndex());
        }

        private int distanceFromCenter(int valueIndex) {
            return Math.abs(valueIndex - centerIndex());
        }
    }



}
