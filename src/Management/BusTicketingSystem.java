/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

// problems:
// 1. make sure all methods return back to main method
// 2. too many hard coded results, change to accessing the object's attributes
// 3. fix the formatting

import Asset.Schedule;
import Asset.Ticket;
import Personnal.Customer;
import Registration.Registration;
import java.io.IOException;
import java.util.Scanner;
import payment.Payment;


/**
 *
 * @author Qzheng
 */
interface Flags {
    static final int NO_LOGIN = 0;
    static final int LOGGED_IN = 1;
    static final int MAIN_MENU = 2;
    static final int REGISTER_MENU = 3;
    static final int ACCOUNT_MENU = 4;
    static final int EXIT = 5;
}

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
        // System.out.println("| 5 : Log Out                                 |"); up to you
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
        // System.out.println("| 4 : Log Out                                 |"); up to you
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
    private static int flag = Flags.NO_LOGIN;
    private static Customer loggedInUser = null;

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        init();
        Menu.welcomeMessage();
        while (flag != Flags.EXIT) {
            showMenu();
            System.out.print("\nWhat is your choice: ");
            choice = scanner.nextInt();
            parseChoice();
        }
    }

    private static void parseChoice() {
        switch (flag) {
            case Flags.NO_LOGIN:
                firstChoice();
                break;
            case Flags.LOGGED_IN:
                mainMenuChoice();
                break;
            case Flags.ACCOUNT_MENU:
                accChoice();
                break;
        }
    }

    private static void showMenu() {
        switch (flag) {
            case Flags.NO_LOGIN:
                Menu.regMenu();
                break;
            case Flags.LOGGED_IN:
                Menu.mainMenu();
                break;
            case Flags.ACCOUNT_MENU:
                Menu.accMenu();
                break;
        }
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
            Schedule.addSchedule(scheduleList[a]);
        }
    }

    private static void performLogin(){
        System.out.printf("Enter your username :");
        scanner.nextLine();
        String userName = scanner.nextLine();

        System.out.printf("\nEnter your password :");
        String password = new String(System.console().readPassword());

        Customer customer = Customer.search(userName, password);
        if(customer == null){
            System.out.println("\nUser doesn't exist");
            flag = Flags.NO_LOGIN;
            loggedInUser = null;
            return;
        }
        loggedInUser = customer;
        flag = Flags.LOGGED_IN;
    }

    public static void mainMenuChoice(){
        switch(choice){
            case 1:
                accChoice();
                break;
            case 2:
                // Menu.scheduleMenu();
                break;
            case 3:
                reserveTicket();
                break;
            case 4:
                //Payment.performPayment();
                break;
            case 5:
                Menu.exitMessage();
                flag = Flags.EXIT;
                break;
        }
    }
    private static void accChoice(){
        switch(choice){
            case 1:
                Registration.editAccount();
                break;
            case 2:
                Customer.deleteAccount(loggedInUser);
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

    private static void firstChoice(){
        switch(choice){
            case 1:
                Customer newCustomer = Registration.performRegistration();
                Customer.add(newCustomer);
                break;
            case 2:
                performLogin();
                break;
            case 3:
                Menu.exitMessage();
                flag = Flags.EXIT;;
                break;
        }
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
            System.out.println("");
            System.out.print(" \t \t Enter your choice : ");
            selection = scanner.nextInt();

            Customer.parseTicketUserChoice(selection, destination, matrix);


        } while (selection != 3);

        scanner.close();
    }
}
