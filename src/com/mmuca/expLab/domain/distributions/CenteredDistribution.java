package com.mmuca.expLab.domain.distributions;

import com.mmuca.expLab.domain.Require;

import java.util.ArrayList;
import java.util.Random;

public class CenteredDistribution implements IDistribution{
    private CumulativeFunction cumulativeFunction;
    private Random randomGenerator;
    private ValueRange range;
    private int center;
    private double alpha;

    public CenteredDistribution(int center, double alpha) {
        this.center = center;
        this.alpha = alpha;
        this.cumulativeFunction = new CumulativeFunction();
        this.randomGenerator = new Random();
    }

    public int nextInt(){
        Require.that(range != null, "Value range has to be set before generating next value");
        double rnd = randomGenerator.nextDouble()*cumulativeFunction.getMax();
        for (int i = range.getStart(); i<= range.getEnd();i++){
            if (cumulativeFunction.getProbabilityFor(i) > rnd)
                return i;
        }
        Require.thatUnreachable("Each value should have corresponding probability in cumulative function");
        return -1;
    }

    public void setValueRange(ValueRange range){
        this.range = range;
    }

    private class CumulativeFunction{
        private double max=0;
        private DensityFunction densityFunction;
        private ArrayList<Double> cumulativeFunction;

        public CumulativeFunction(){
            this.densityFunction = new DensityFunction();
        }

        public double getProbabilityFor(int value){
           return cumulativeFunction().get(range.indexOf(value));
        }

        private ArrayList<Double>  cumulativeFunction() {
            if (cumulativeFunction != null) return cumulativeFunction;
            cumulativeFunction=initCumulativeFunction();
            return cumulativeFunction;
        }

        private ArrayList<Double> initCumulativeFunction() {
            ArrayList<Double> cumulativeFunction = new ArrayList<Double>();
            cumulativeFunction.add(0,densityFunction.getProbabilityFor(0));
            for (int i=1; i<range.size();i++){
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
            for(double value: cumulativeFunction())
                max = Math.max(value,max);
            return max;
        }
    }

    private class DensityFunction{
        private ArrayList<Double> densityFunction;

        public double getProbabilityFor(int valueIndex){
            return densityFunction().get(valueIndex);
        }

        private int centerIndex() {
            return range.indexOf(center);
        }

        private ArrayList<Double> densityFunction(){
            if (densityFunction != null) return  densityFunction;
            densityFunction=initDensityFunction();
            return densityFunction;
        }

        private ArrayList<Double> initDensityFunction() {
            ArrayList<Double> densityFunction = new ArrayList<Double>();
            for (int i =0; i< range.size(); i++){
                densityFunction.add(i, probabilityFunction() * centerBasedCoefficient(i));
            }
            return densityFunction;
        }

        private double probabilityFunction() {

            return (1 - alpha)/ probabilityDivisor();
        }

        private double centerBasedCoefficient(int valueIndex) {
            return Math.pow(alpha, distanceFromCenter(valueIndex)+1);
        }

        private double probabilityDivisor() {
            return (1  + alpha - firstSubtrahend() - secondSubtrahend());
        }

        private double firstSubtrahend() {
            return Math.pow(alpha, range.size() - centerIndex() +1);
        }

        private double secondSubtrahend() {
            return Math.pow(alpha, centerIndex());
        }

        private int distanceFromCenter(int valueIndex) {
            return Math.abs(valueIndex - centerIndex());
        }
    }



}
