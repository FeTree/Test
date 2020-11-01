package CS482_Project2;

/*
David Eisenbaum
COMP482
Professor Noga
Due: 11-01-2020
 */

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Project2 {

    String path = "C:\\Users\\David Eisenbaum\\IdeaProjects\\Test\\src\\CS482_Project2\\input2.txt";
    ArrayList<Integer> nums = new ArrayList<>();
    ArrayList<Point> pointArrayList;

    Point mostCentralL2;

    public static void main(String[] args) throws FileNotFoundException {
        Project2 app = new Project2();

        //read file and input into nums arraylist
        app.readFile(app.path);

        // create an array list of points
        app.pointArrayList = app.createPointsArray(app.nums);

        //finds geometric center
        Point center = app.findGeometricCenter(app.pointArrayList);

        // call method to find manhattan l1 distance
        double l1Distance = app.findDistanceL1(app.pointArrayList, center);

        // call method to find l2 distance
        double l2Distance = app.findDistanceL2(app.pointArrayList, center);

        // print l1
        System.out.println("(" + (int) center.getX() +"," + (int) center.getY() + ") " + (int)l1Distance);

        // Print l2
        System.out.println("(" + (int) center.getX() +"," + (int) center.getY() + ") " + (int)l2Distance);

    }

    /*
     * Read Input File
     * @param path
     * @throws FileNotFoundException
     */
    public void readFile(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        while(scanner.hasNextInt()) {
            nums.add(scanner.nextInt());
        }
    }

    /*
    Create Arraylist of points using an Integer arraylist
     */
    public ArrayList<Point> createPointsArray(ArrayList<Integer> arr) {
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < arr.size(); i+=2) {
            points.add(new Point(arr.get(i), arr.get(i+1)));
        }

        sortByXCoordinates(points);
        return points;
    }

    public Point findGeometricCenter(ArrayList<Point> arr) {
        double xmax = Integer.MIN_VALUE;
        double xmin = Integer.MAX_VALUE;
        double ymax = Integer.MIN_VALUE;
        double ymin = Integer.MAX_VALUE;

        //find x max
        for (int i = 0; i < arr.size(); i++) {
            if(xmax < arr.get(i).x) {
                xmax = arr.get(i).x;
            }
        }

        //find x min
        for (int i = 0; i < arr.size(); i++) {
            if(xmin > arr.get(i).x) {
                xmin = arr.get(i).x;
            }
        }

        //find y max
        for (int i = 0; i < arr.size(); i++) {
            if(ymax < arr.get(i).y) {
                ymax = arr.get(i).y;
            }
        }

        //find y min
        for (int i = 0; i < arr.size(); i++) {
            if(ymin > arr.get(i).y) {
                ymin = arr.get(i).y;
            }
        }

        int xcenter = (int) (xmax-xmin) / 2;
        int ycenter = (int) (ymax-ymin) / 2;



        Point centralPoint = new Point(xcenter, ycenter);
        return centralPoint;
    }

    public double findDistanceL2(ArrayList<Point> arr, Point center) {
        double smallest = Integer.MAX_VALUE;
        double distance = 0;

        for (int i = 0; i < arr.size(); i++) {
            distance += metricL2(center, arr.get(i));
        }

        return distance;
    }

    public double findDistanceL1(ArrayList<Point> arr, Point center) {
        double smallest = Integer.MAX_VALUE;
        double distance = 0;

        for (int i = 0; i < arr.size(); i++) {
            distance += metricL1(center, arr.get(i));
        }

        return distance;
    }

    /*
     sort by x coordinate
     */
    public void sortByXCoordinates(ArrayList<Point> arrayList) {

        Collections.sort(arrayList, new PointCompare());

    }

    public class PointCompare implements Comparator<Point> {

        public int compare(final Point a, final Point b) {
            if (a.x < b.x) {
                return -1;
            }
            else if (a.x > b.x) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    /*
    Finds normal L2 metric
     */
    public double metricL2(Point p1, Point p2) {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double distance = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
        return distance;
    }

    /*
    Finds manhattan L1 metric
     */
    public double metricL1(Point p1, Point p2) {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();

        double distance = (Math.abs(x1 - x2)) + (Math.abs(y1 - y2));
        return distance;
    }
}
