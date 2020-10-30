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

        app.readFile(app.path);
        app.pointArrayList = app.createPointsArray(app.nums);

        double l2Distance = app.findDistanceL2(app.pointArrayList);
        System.out.println(l2Distance);

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

    public double findDistanceL2(ArrayList<Point> arr) {
        double smallest = Integer.MAX_VALUE;
        double distance;


        for (int i = 0; i < arr.size(); i++) {
            for (int j = 1; j < arr.size() - 1; j++) {
                distance = metricL2(arr.get(i), arr.get(j));
//                if(distance < smallest) {
//                    smallest = distance;
//                    mostCentralL2 = arr.get(i);
//                }
                System.out.println(smallest);
            }
        }


        return smallest;
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
}
