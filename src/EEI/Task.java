/*
Authors: David Eisenbaum
Purpose: Task class for employee analysis
*/
package EEI;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Task {
    //global variables
    private String name;
    private LocalDateTime assigned;
    private LocalDateTime due;
    private LocalDateTime completed;

    private ArrayList<Employee> employeesOnTask;

    public Task(String name, LocalDateTime assigned, LocalDateTime due) {
        this.name = name;
        this.assigned = assigned;
        this.due = due;
        employeesOnTask = new ArrayList<Employee>();
        //completed has to be set later cant be at creation of task
    }

    public void addEmployeesToTask(Employee e){
        employeesOnTask.add(e);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getAssigned() {
        return assigned;
    }

    public void setAssigned(LocalDateTime assigned) {
        this.assigned = assigned;
    }

    public LocalDateTime getDue() {
        return due;
    }

    public void setDue(LocalDateTime due) {
        this.due = due;
    }

    public LocalDateTime getCompleted() {
        return completed;
    }

    public void setCompleted(LocalDateTime completed) {
        this.completed = completed;
    }
}
