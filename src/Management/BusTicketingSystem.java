/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

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
    static final int ACCOUNT_MENU = 2;
    static final int EXIT = 3;
}

interface Menu {

    static void welcomeMessage() {
        System.out.println("\t\t\tWELCOME!!!!");
        System.out.println("\t\t\tTHIS IS A BUS RESERVATION AND TICKETING SYSTEM...");
    }

    static void mainMenu(){
        System.out.println(" --------------------------");
        System.out.println("|         MAIN MENU        |");
        System.out.println(" --------------------------");
        System.out.println("|     1 : Account          |");
        System.out.println("|     2 : Reservation      |");
        System.out.println("|     3 : Payment          |");
        System.out.println("|     4 : Log Out          |");
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
        System.out.println("|     3 : Back             |");
        System.out.println(" --------------------------");
    }

    static void exitMessage() {
        System.out.println("\t\t\tYOU CHOSE TO EXIT THE SYSTEM...");
        System.out.println("\t\t\tHAVE A NICE DAY!!!!");
    }
}

public class BusTicketingSystem {

    /**
     * @param args the command line arguments
     */

    private static int choice;
    private static int flag = Flags.NO_LOGIN;
    private static Customer loggedInUser = null;

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        init();
        System.out.println("\t\t\t ___ _   _ ___   _____ ___ ___ _  _____ _____ ___ _  _  ___   _____   _____ _____ ___ __  __ ");
        System.out.println("\t\t\t| _ ) | | / __| |_   _|_ _/ __| |/ / __|_   _|_ _| \\| |/ __| / __\\ \\ / / __|_   _| __|  \\/  |");
        System.out.println("\t\t\t| _ \\ |_| \\__ \\   | |  | | (__| ' <| _|  | |  | || .` | (_ | \\__ \\\\ V /\\__ \\ | | | _|| |\\/| |");
        System.out.println("\t\t\t|___/\\___/|___/   |_| |___\\___|_|\\_\\___| |_| |___|_|\\_|\\___| |___/ |_| |___/ |_| |___|_|  |_|");
        System.out.println("");
        Menu.welcomeMessage();
        while (flag != Flags.EXIT) {
            showMenu();
            System.out.print("\n\t\t\tWhat is your choice: ");
            choice = scanner.nextInt();
            parseChoice();
        }
    }

    private static void parseChoice() {
        switch (flag) {
            case Flags.NO_LOGIN:
                parseRegistration();
                break;
            case Flags.LOGGED_IN:
                parseMainMenu();
                break;
            case Flags.ACCOUNT_MENU:
                parseAccountMenu();
                break;
        }
    }

    private static void parseRegistration(){
        switch(choice){
            case 1: 
                Registration.performRegistration();
                break;
            case 2:
                performLogin();
                break;
            case 3:
                Menu.exitMessage();
                flag = Flags.EXIT;
                break;
        }
    }
    
    private static void parseMainMenu(){
        switch(choice){
            case 1:
                flag = Flags.ACCOUNT_MENU;
                break;
            case 2:
                loggedInUser.reserveTicket();
                break;
            case 3:
                Payment.performPayment(loggedInUser, loggedInUser.getTicket());
                break;
            case 4:
                logOut();
                break;
        }
    }
    
    private static void parseAccountMenu(){
        switch(choice){
            case 1:
                break;
            case 2:
                break;
            case 3:
                flag = Flags.LOGGED_IN;
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
    
    private static void logOut(){
        loggedInUser = null;
        flag = Flags.NO_LOGIN;
    }
    
    private static void init(){
        Schedule [] scheduleList = {
            new Schedule ("Kepong", "Ipoh", Schedule.setupTime(14,35)),
            new Schedule ("Kedah", "Kelantan", Schedule.setupTime(16,00)),
            new Schedule ("Perak", "Selangor", Schedule.setupTime(9,30)),
            new Schedule ("Melaka", "Negeri Sembilan", Schedule.setupTime(11,20)),
            new Schedule ("Teluk Intan", "Seremban", Schedule.setupTime(18,50))
        };

        for (int a = 0; a < scheduleList.length; a++) {
            Schedule.addSchedule(scheduleList[a]);
        }
    }

    private static void performLogin() {
        System.out.printf("\t\t\tEnter your username :");
        scanner.nextLine();
        String userName = scanner.nextLine();
        System.out.println(userName);

        System.out.printf("\nEnter your password :");
//        String password = new String(System.console().readPassword());
        String password = scanner.nextLine();
        System.out.println(password);

        Customer customer = Customer.search(userName, password);
        if (customer == null) {
            System.out.println("\n\t\t\tUser doesn't exist");
            flag = Flags.NO_LOGIN;
            loggedInUser = null;
            return;
        }
        loggedInUser = customer;
        flag = Flags.LOGGED_IN;
    }

    public static void reserveTicket() {
        Scanner scanner = new Scanner(System.in);
        int selection;
        int destination = 0;
        char matrix[][] = new char[11][10];

        do {
            System.out.println("\t\t\t *=====================*");
            System.out.println("\t\t\t |     Reservation     |");
            System.out.println("\t\t\t *=====================*");
            System.out.println("\t\t\t | [1] Destination     |");
            System.out.println("\t\t\t | [2] Booking Ticket  |");
            System.out.println("\t\t\t | [3] Exit            |");
            System.out.println("\t\t\t *=====================*");
            System.out.println("");
            System.out.print(" \t\t\t Enter your choice : ");
            selection = scanner.nextInt();

            Customer.parseTicketUserChoice(selection, destination, matrix);

        } while (selection != 3);

        scanner.close();
    }
    
    public static void cls() throws IOException, InterruptedException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
