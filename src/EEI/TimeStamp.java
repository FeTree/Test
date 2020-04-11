/*
Author: David Eisenbaum
Purpose: Keep track of employee time in and out
*/
package EEI;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeStamp {
    //Global variables
    private LocalDate date;  //date keeping track of time in and time out on certain date
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;

    public TimeStamp(LocalDate date, LocalDateTime timeIn, LocalDateTime timeOut) {
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalDateTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }
}