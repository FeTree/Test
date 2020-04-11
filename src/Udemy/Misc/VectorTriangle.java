package Udemy.Misc;

import java.util.*;

//finds area of a triangle given 3 vectors
public class VectorTriangle {
    // Vector A
    double vectorA1 = 5;
    double vectorA2 = 7;
    double vectorA3 = 3;
    // Vector B
    double vectorB1 = 7;
    double vectorB2 = 17;
    double vectorB3 = 5;
    // Vector C
    double vectorC1 = 6;
    double vectorC2 = 8;
    double vectorC3 = 3
            ;

    // Vector answer
    double vectorAnswer1;
    double vectorAnswer2;
    double vectorAnswer3;

    // Vectors for combining
    double vectorAB1;
    double vectorAB2;
    double vectorAB3;

    double vectorAC1;
    double vectorAC2;
    double vectorAC3;

    //Area
    Double area;

    // Arrays for cross product
    ArrayList<Double> vectAB = new ArrayList<>();
    ArrayList<Double> vectAC = new ArrayList<>();
    ArrayList<Double> crossProduct = new ArrayList<>();;

    public String calculate(){
        //find vector AB
        vectorAB1 = vectorB1 - vectorA1;
        vectorAB2 = vectorB2 - vectorA2;
        vectorAB3 = vectorB3 - vectorA3;
        //find vector AC
        vectorAC1 = vectorC1 - vectorA1;
        vectorAC2 = vectorC2 - vectorA2;
        vectorAC3 = vectorC3 - vectorA3;

        //cross product of AB x AC
        vectAB.add(0,vectorAB1);
        vectAB.add(1, vectorAB2);
        vectAB.add(2, vectorAB3);

        vectAC.add(0, vectorAC1);
        vectAC.add(1, vectorAC2);
        vectAC.add(2, vectorAC3);

        crossProduct.add((vectAB.get(1) * vectAC.get(2)) - (vectAB.get(2) * vectAC.get(1)));
        crossProduct.add( -((vectAB.get(0) * vectAC.get(2)) - (vectAB.get(2) * vectAC.get(0))));
        crossProduct.add((vectAB.get(0) * vectAC.get(1)) - (vectAB.get(1) * vectAC.get(0)));

        // Area = |AB x AC|
        area = Math.sqrt(crossProduct.get(0) * crossProduct.get(0) + crossProduct.get(1)*crossProduct.get(1) + crossProduct.get(2)*crossProduct.get(2));
        area *= 0.5;


        System.out.println("Cross Product: <" + crossProduct.get(0) + ", " + crossProduct.get(1) + ", "+ crossProduct.get(2) + ">");
        return("Area: " + area);
    }

        public static void main(String[] args) {
        VectorTriangle vt2 = new VectorTriangle();
        System.out.println(vt2.calculate());
    }

}
