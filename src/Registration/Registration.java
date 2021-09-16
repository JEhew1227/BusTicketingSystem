/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import Management.BusTicketingSystem;
import payment.Card;
import Personnal.Customer;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Qzheng
 */
public interface Registration {

    public static Customer performRegistration() {
        //prompt everything
        Scanner scanner = new Scanner(System.in);

        System.out.println("\t\t\tWelcome to registration...");

        System.out.print("\n\t\t\tEnter username(name you wish to be display as)>");
        String userName = scanner.nextLine();

        System.out.print("\nEnter password >");
//        String password = new String(System.console().readPassword());
        String password = scanner.nextLine();
        Card card = performRegistrationCard();
        while (card == null){
            System.out.println("Invalid card information");
            card = performRegistrationCard();
        }
        System.out.println("You have successfully registered");
        Customer customer = new Customer(userName, password, card);
        Customer.add(customer);
        return customer;
    }


    public static Card performRegistrationCard(){
        Scanner scanner = new Scanner(System.in);
        String cardNum;
        int cvv;
        Calendar expiryDate = Calendar.getInstance();
        
        System.out.print("\nEnter your Card number >");
        cardNum = scanner.nextLine();

        System.out.print("\n\t\t\tEnter your Card expiry date (month)>");
        int month = scanner.nextInt();
        --month;
        System.out.print("\n\t\t\tEnter your Card expiry date (year)>");
        int year = scanner.nextInt();

        expiryDate.set(Calendar.MONTH, month);
        expiryDate.set(Calendar.YEAR, year);

        System.out.print("\n\t\t\tEnter you Card cvv number >");
        cvv = scanner.nextInt();
        
        int monthExpiryDate = expiryDate.get(Calendar.MONTH)+1;
        int yearExpiryDate = expiryDate.get(Calendar.YEAR);
        
        Card card = new Card(cardNum, expiryDate, cvv);
        return Card.validateCard(card) ? card : null;
    }

    public static void editAccount() {
        System.out.println("\t\t\tEDIT ACCOUNT....");

        performRegistration();
        System.out.println("\t\t\tAccount edited..");
    }

}
