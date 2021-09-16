/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment;

import Asset.Ticket;
import Personnal.Customer;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author KUNG WEI XIN
 */
public interface Payment {


    //work in progress
    // its ok, good luck
    public static boolean performPayment(Customer customer, Ticket ticket){
        if(ticket == null){
            System.out.println("You have not reserve any tickets yet");
            return false;
        }
        //display get ticket information
        
        Scanner scan = new Scanner(System.in);
        double total = ticket.calTotal();
        System.out.println(ticket.toString());

        System.out.println("\t\t\tIs this information correct?");
        char choice = scan.next().charAt(0);
        if (Character.toUpperCase(choice) != 'Y') {
            return false;
        }

        String otp = generateOTP();
        System.out.println("\t\t\tOTP: " + otp);
        System.out.print("\t\t\tEnter Your OTP code: ");
        String inputOTP = scan.next();
        if (!inputOTP.equals(otp)) {
            System.out.println("\t\t\tIncorrect OTP code!");
            return false;
        }
        System.out.println("\t\t\tEnter total: ");
        double inputTotal = scan.nextDouble();
        if (inputTotal < total) {
            System.out.println("\t\t\tInsufficient amount entered!");
            return false;
        }

        double balance = customer.getCard().getBalance();
        balance -= total;
        customer.getCard().setBalance(balance);
        return true;
    }

    public static String generateOTP() {
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String otp = "";

        for (int i = 0; i < 3; i++) {
            int index = (int) Math.random() * alphabets.length();
            otp += alphabets.charAt(index);
        }
        for (int i = 0; i < 6; i++) {
            int index = (int) Math.random() * numbers.length();
            otp += numbers.charAt(index);
        }
        return otp;
    }

    public static double generateRandomBalance() {
        return generateRandomBalance(1000, 6000);
    }

    public static double generateRandomBalance(int min, int max) {
        return ((Math.random() * (max - min)) + min);
    }

}
