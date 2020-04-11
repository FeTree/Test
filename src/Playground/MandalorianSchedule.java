package Playground;

import java.time.Clock;
import java.util.*;

public class MandalorianSchedule {
    public static void main(String[] args) {

        Date[] mandalorianSchedule = new Date[10];

        Date nextEp = new Date(2019, 11, 29);
        Date prevEp = new Date(2019, 11, 2);
        for (int i = 0; i <1 ; i++) {
            mandalorianSchedule[i] = nextEp;
            mandalorianSchedule[i] = prevEp;
        }
        Date currentDate = new Date();
        System.out.println(currentDate);

        System.out.println(nextEp.compareTo(prevEp));
    }
}
