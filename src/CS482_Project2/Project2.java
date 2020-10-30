package CS482_Project2;

/*
David Eisenbaum
COMP482
Professor Noga
Due: 11-01-2020
 */

import java.awt.Point;

public class Project2 {
    public static void main(String[] args) {
        Point p1 = new Point(10, 5);
        Point p2 = new Point(18, 6);
        Project2 app = new Project2();
        System.out.println(app.metricL2(p1, p2));
    }


    public double metricL2(Point p1, Point p2) {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        double distance = distance = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
        return distance;
    }
}
