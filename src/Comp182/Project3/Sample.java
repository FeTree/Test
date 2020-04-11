/*
Author: David Eisenbaum
Comp 182
Professor Barnes
Project 3
 */
package Comp182.Project3;

import java.util.*;
public class Sample {


        //class variables
        protected ArrayList<Double> data;
        protected double size;
        protected double min;
        protected double max;
        protected double mean;
        protected double median;
        protected double sDev;
        String name;

        //constructor
        public Sample(){
            // size = getData().size();
            min = getMin();
            max = getMax();
            mean = getMean();
            median = getMedian();
            sDev = getsDev();
            name = "Model";
            data = new ArrayList<>();
        }

        public void add(double value){
            data.add(value);
        }


        //compute min, max, avg
        public void computeStats(ArrayList<Double> al){
            //computes mean
            double sum = 0;
            int i;
            //add all the values
            for(i = 1; i < al.size(); i++){
                sum += al.get(i);
            }
            mean = sum / al.size();

            //computes standard deviation
            double sumSquares = 0;
            for(int j = 0; j<al.size(); j++){
                sumSquares += Math.pow(al.get(j) - mean, 2);
            }
            sDev = Math.pow(sumSquares / al.size(), 0.5);

            //computes min
            min = Collections.min(al);

            //computes max
            max = Collections.max(al);

            //computes median
            Collections.sort(al);
            median = al.get(al.size() / 2);

        }

        //getters
        public double getSize() {
            return size;
        }

        public ArrayList<Double> getData() {
            return data;
        }

        public double getMax() {
            return max;
        }

        public double getMean() {
            return mean;
        }

        public double getMedian() {
            return median;
        }

        public double getMin() {
            return min;
        }

        public double getsDev() {
            return sDev;
        }

        public String getName(){
            return name;
        }

        public String toString(){
            return String.format("Distribution: name = %s, size = %s, mean = %s, stdDev = %s, min = %s, max = %s, median = %s" ,
                    name, size, mean, sDev, min, max, median);
        }
}
