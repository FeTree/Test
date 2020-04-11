package EEI;

import java.time.*;

public class App {

    //static variable
    static Clock clock = Clock.tick(Clock.systemDefaultZone(), Duration.ofMinutes(1));

    public static void main(String[] args) {
        //TODO
        EmployeeHashMap map = new EmployeeHashMap();
        Employee david = new Employee("David", "Eisenbaum", "Intern");
        map.addToMap(david);
        System.out.println(map.sizeOfHashMap());

        Task taskOne = new Task("Project", LocalDateTime.now(clock), LocalDate.of(2019, 3, 10).atTime(8, 0));
        taskOne.setCompleted(LocalDate.of(2019, 4, 5).atTime(10,0));
        System.out.println(taskOne.getAssigned());
        System.out.println(taskOne.getCompleted()); //just testing they way LocalDateTime works
    }//end main

    public void menu(){
        boolean flag = true;
        int option = 0; //will prompt user to enter but not until after everything works7yy776777
        int totalAmountOfOptions = 10;
        try{
            while(flag){
                if(option <0 || option > totalAmountOfOptions){
                    System.out.println("Invalid Option");
                    //ask for option again
                }
                else if(option == 0){
                    //create new employee
                }
                else if(option == 1){
                    //assign time in
                }
                else if(option == 2){
                    //assign time out to employee
                }
                else if(option == 3){
                    //create task
                }
                else if(option == 4){
                    //assign employee to task
                }
                else{
                    flag = false; //end menu
                }
            }//end while
        }//end try
        catch(Exception e){
            System.out.println("Invalid");
            //reset option
        }//end catch

    }//end menu
}//end app
