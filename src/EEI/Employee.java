package EEI;

/*
Authors: David Eisenbaum,
Date Started: 2/29/19
Purpose: Employee class to store employees (actual people) to be analyzed for incentives.
*/

//imports
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee{
    //variables
    private double score; //measure of how well the employee is doing
    private String firstName;
    private String lastName;
    private String typeOfJob; //optional input

    public Employee(String firstName, String lastName, String typeOfJob){
        this.firstName = firstName;
        this.lastName = lastName;
        this.typeOfJob = typeOfJob;
    }

    public double calculateScore(){
        //TODO: algorithm to evaluate employees performance expressible in numbers(double)
        return score;
    }

    //this will keep track of their time in and time out on a certain day
    public void schedule(){
        //TODO
    }

    //Assign a new task to employee(s)
    public void assignTask(){
        //TODO
        //Task taskOne = new Task("Project" , LocalDate.now().atTime(11, 17));
    }

    //getters and setters
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTypeOfJob() {
        return typeOfJob;
    }

    public void setTypeOfJob(String typeOfJob) {
        this.typeOfJob = typeOfJob;
    }
}
