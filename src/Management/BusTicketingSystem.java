/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;


import Asset.Schedule;
import Asset.Ticket;
import Personnal.Customer;
import static Personnal.Customer.parseTicketUserChoice;
import Registration.Registration;
import java.io.IOException;
import java.util.Scanner;
import payment.Payment;


/**
 *
 * @author Qzheng
 */
interface Menu {

    static void welcomeMessage(){
        System.out.println("WELCOME!!!!");
        System.out.println("THIS IS A BUS RESERVATION AND TICKETING SYSTEM...");
    }
    
    static void mainMenu(){
        System.out.println(" --------------------------");
        System.out.println("|         MAIN MENU        |");
        System.out.println(" --------------------------");
        System.out.println("|     1 : Account          |");
        System.out.println("|     2 : Schedule         |");
        System.out.println("|     3 : Reservation      |");
        System.out.println("|     4 : Payment          |");
        System.out.println("|     5 : Exit             |");
        System.out.println(" --------------------------");
    }
    static void regMenu() {
        System.out.println(" ------------------------------------------");
        System.out.println("|   BUS RESERVATION AND TICKETING SYSTEM   |");
        System.out.println(" ------------------------------------------ ");
        System.out.println("| 1 : Register an account                  |");
        System.out.println("| 2 : Login                                |");
        System.out.println("| 3 : Exit                                 |");
        System.out.println(" ------------------------------------------\n");

    }
    
    static void accMenu(){
        System.out.println(" --------------------------");
        System.out.println("|         ACCOUNT          |");
        System.out.println(" --------------------------");
        System.out.println("|     1 : Edit             |");
        System.out.println("|     2 : Delete           |");
        System.out.println("|     3 : Display          |");
        System.out.println("|     4 : Exit             |");
        System.out.println(" --------------------------");
    }
    
    static void scheduleMenu(){
        System.out.println(" --------------------------");
        System.out.println("|     BUS SCHEDULE LIST    |");
        System.out.println(" --------------------------");
        System.out.println("|     1 : Add              |");
        System.out.println("|     2 : Edit             |");
        System.out.println("|     3 : Delete           |");
        System.out.println("|     4 : View             |");
        System.out.println("|     5 : Exit             |");
        System.out.println(" --------------------------");
    }
    
    static void exitMessage(){
        System.out.println("YOU CHOSE TO EXIT THE SYSTEM...");
        System.out.println("HAVE A NICE DAY!!!!");
    }
}

public class BusTicketingSystem {

    /**
     * @param args the command line arguments
     */
    
    public static void cls() throws IOException, InterruptedException{
         new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    
    private static int choice;
    private static Customer loggedInUser = null;
    
    public static Scanner scanner =new Scanner(System.in);
    
    public static void main(String[] args) {
        init();
        //display logo//
        Menu.welcomeMessage();
        Menu.regMenu();
        System.out.print("\nWhat is your choice :");
        choice = scanner.nextInt();
        firstChoice();
    }
    
    private static void init(){
        Schedule [] scheduleList = { 
            new Schedule ("Kepong", "Ipoh", Schedule.setupTime(14,35)),
            new Schedule ("Kedah", "Kelantan", Schedule.setupTime(16,00)),
            new Schedule ("Perak", "Selangor", Schedule.setupTime(9,30)),
            new Schedule ("Melaka", "Negeri Sembilan", Schedule.setupTime(11,20)),
            new Schedule ("Teluk Intan", "Seremban", Schedule.setupTime(18,50))
                         
        };
        
        for(int a = 0; a < scheduleList.length; a++){
            System.out.println(scheduleList[a]);
            Schedule.addSchedule(scheduleList[a]);
            System.out.println("Schedule has been added");
        }
    }
    
        private static void performLogin(){
        
        System.out.printf("Enter your username :");
        String userName = scanner.nextLine();
        
        System.out.printf("\nEnter your password :");
        String password = scanner.nextLine();
        
        Customer customer = Customer.search(userName, password);
        if(customer == null){
            System.out.println("\nUser doesn't exist");
            
        }
        loggedInUser = customer;
        
    }
    
    private static void performReg() {
                Registration.performRegistration();
                mainMenuChoice();
    }
    
    public static void mainMenuChoice(){
        Menu.mainMenu();
                getChoice();
                switch(choice){
                    case 1:
                        Menu.accMenu();
                        getChoice();
                        accChoice();
                        break;
                    case 2:
                        Menu.scheduleMenu();
                        break;
                    case 3:
                        reserveTicket();
                        break;
                    case 4:
                        //Payment.performPayment();
                        break;
                    case 5:
                        Menu.exitMessage();
                        break;
        }
    }
    private static void accChoice(){
        switch(choice){
            case 1:
                Registration.editAccount();
                mainMenuChoice();
                break;
            case 2:
                Customer.deleteAccount(loggedInUser);
                mainMenuChoice();
                break;
            case 3:
                //display customer info
                break;
            case 4:
                mainMenuChoice();
        }
    }
    
    private static void scheduleChoice(){
        switch(choice){
            case 1:
                
                break;
        }
    }
        
    private static void getChoice(){
        System.out.print("\nWhat is your choice :");
        choice = scanner.nextInt();
    }
    
    private static void firstChoice(){
        switch(choice){
            case 1:
                performReg();
                mainMenuChoice();
                break; 
            case 2:
                performLogin();
                
                break;
            case 3:
                Menu.exitMessage();
                break;
        }
    }
    
    private static void custMenu(){
        
    }
    
    private static void scheduleMenu(){
        
    }
    
    private static void cardMenu(){
        
    }
    
    public static void reserveTicket() {
        Scanner scanner = new Scanner(System.in);
        int selection;
        int destination = 0;
        char matrix[][] = new char[11][10];

        do {
            System.out.println("\t \t *=====================*");
            System.out.println("\t \t |     Reservation     |");
            System.out.println("\t \t *=====================*");
            System.out.println("\t \t | [1] Destination     |");
            System.out.println("\t \t | [2] Booking Ticket  |");
            System.out.println("\t \t | [3] Exit            |");
            System.out.println("\t \t *=====================*");
            System.out.println(""); // new line
            System.out.print(" \t \t Enter your choice : ");
            selection = scanner.nextInt();

            parseTicketUserChoice(selection, destination, matrix);
            

        } while (selection != 3);

    }
}
