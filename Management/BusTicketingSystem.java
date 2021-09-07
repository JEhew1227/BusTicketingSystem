/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticketingsystem;

import Registration.Registration;
import Personnel.Customer;
import java.util.Scanner;

/**
 *
 * @author Qzheng
 */
interface Menu {

    static void mainMenu() {
        System.out.println("THIS IS A BUS RESERVATION AND TICKETING SYSTEM...");
        System.out.println(" ------------------------------------------");
        System.out.println("|   BUS RESERVATION AND TICKETING SYSTEM   |");
        System.out.println(" ------------------------------------------ ");
        System.out.println("| [1] Register an account                  |");
        System.out.println("| [2] Edit account                         |");
        System.out.println("| [3] Delete account                       |");
        System.out.println("| [4] Exit                                 |");
        System.out.println(" ------------------------------------------\n");

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
    private static int choice;
    private static Customer loggedIn = null;
    
    private static void performLogin() {
        switch (choice) {
            case 1:
                performRegisteration();
                performRegisterationCard();
                
        }
    }
    
    private static void custMenu(){
        
    }
    
    private static void scheduleMenu(){
        
    }
    
    private static void cardMenu(){
        
    }

}
