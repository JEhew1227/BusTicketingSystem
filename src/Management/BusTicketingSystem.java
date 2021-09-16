/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;


import static Management.Menu.*;
import Personnal.Customer;
import Registration.Registration;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Qzheng
 */
interface Menu {

    static void logo(){
        System.out.println(" ___ _   _ ___   _____ ___ ___ _  _____ _____ ___ _  _  ___   _____   _____ _____ ___ __  __ ");
        System.out.println("| _ ) | | / __| |_   _|_ _/ __| |/ / __|_   _|_ _| \\| |/ __| / __\\ \\ / / __|_   _| __|  \\/  |");
        System.out.println("| _ \\ |_| \\__ \\   | |  | | (__| ' <| _|  | |  | || .` | (_ | \\__ \\\\ V /\\__ \\ | | | _|| |\\/| |");
        System.out.println("|___/\\___/|___/   |_| |___\\___|_|\\_\\___| |_| |___|_|\\_|\\___| |___/ |_| |___/ |_| |___|_|  |_|");
    }
    
    static void mainMenu() {
        
        System.out.println(" ------------------------------------------");
        System.out.println("|   BUS RESERVATION AND TICKETING SYSTEM   |");
        System.out.println(" ------------------------------------------ ");
        System.out.println("| [1] Register an account                  |");
        System.out.println("| [2] Edit account                         |");
        System.out.println("| [3] Delete account                       |");
        System.out.println("| [4] Exit                                 |");
        System.out.println(" ------------------------------------------");

    }
    
    static void custMenu(){
        System.out.println(" --------------------------");
        System.out.println("|         CUSTOMER         |");
        System.out.println(" --------------------------");
        System.out.println("|     1 : Add              |");
        System.out.println("|     2 : Edit             |");
        System.out.println("|     3 : Delete           |");
        System.out.println("|     4 : Display          |");
        System.out.println("|     5 : Exit             |");
        System.out.println(" --------------------------");
    }
    
    static void scheduleMenu(){
        System.out.println(" --------------------------");
        System.out.println("|     BUS SCHEDULE LIST   |");
        System.out.println(" --------------------------");
        System.out.println("|     1 : Add              |");
        System.out.println("|     2 : Edit             |");
        System.out.println("|     3 : Delete           |");
        System.out.println("|     4 : View             |");
        System.out.println("|     5 : Exit             |");
        System.out.println(" --------------------------");
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
    private static Customer loggedIn = null;
    
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        logo();
        System.out.println();
        mainMenu();
        System.out.println("Enter Choice: ");
        choice = scan.nextInt();
        performLogin();
    }
    
    private static void performLogin() {
        switch (choice) {
            case 1:
                Customer customer = Registration.performRegistration();
                Customer.add(customer);
                
        }
    }
    
    private static void custMenu(){
        
    }
    
    private static void scheduleMenu(){
        
    }
    
    private static void cardMenu(){
        
    }

}
