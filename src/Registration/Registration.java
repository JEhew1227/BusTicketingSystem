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

        System.out.print("\n\t\t\tEnter password >");
        String password = scanner.nextLine();
        //String password = new String(System.console().readPassword());

        Card card = performRegistrationCard();
        return new Customer(userName, password, card);
    }

    public static Card performRegistrationCard() {

        Scanner scanner = new Scanner(System.in);
        String cardNum;
        int cvv;
        Calendar expiryDate = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();

        System.out.print("\n\t\t\tEnter your Card number >");
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

        System.out.println("\n\t\t\tThese are the card information that you have entered\n");
        int monthExpiryDate = expiryDate.get(Calendar.MONTH) + 1;
        int yearExpiryDate = expiryDate.get(Calendar.YEAR);

        System.out.println("\n\t\t\tYou have successfully registered an account...");
        return new Card(cardNum, expiryDate, cvv);
    }

    public static void editAccount() {
        System.out.println("\t\t\tEDIT ACCOUNT....");

        performRegistration();
        System.out.println("\t\t\tAccount edited..");
    }

}
