/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaassignment;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Scanner;
/**
 *
 * @author KUNG WEI XIN
 */
public interface Payment {
    public static void cls() throws IOException, InterruptedException{
         new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    
    public static boolean performPayment(Customer customer, Ticket ticket, Card card) throws IOException, InterruptedException{
        Scanner scan = new Scanner(System.in);
        Scanner console = new Scanner(System.in);
        //display get ticket information
        System.out.println("Ticket Price: "+ticket.getAmount());
        System.out.println("Ticket Quantity: "+ticket.getQuantity());
        System.out.println("Total Payable: "+Transaction.calTotal(ticket));
        //Confirm  with user
        System.out.println("Confirm Pay?(Y/N) :");
        char choice;
        choice = scan.next().charAt(0);
        
        //if user confirm
        if(choice == 'Y'||choice == 'y'){
            //get payment amount from user
            double balance;
            balance = generateRandomBalance();
            //set Balance to Card
            card.setCardBalance(balance);
            //Display Card Number and balance
            System.out.println("Card Number: "+card.getCardNum());
            System.out.println("Card balance: "+card.getBalance());
            balance -=Transaction.calTotal(ticket);
            //Enter to continue
            System.out.println("--Press Enter to Continue--");
            console.next();
            
            
            //clear screen
            cls();
            System.out.println("--Payment Completed--");
            System.out.println("Amount Paid: "+calTotal(ticket));
            System.out.println("Balance After :"+balance);
            return true;
        }else{
            //Else abort the payment
            System.out.println("Payment Cancelled");
            exit(-1);
            return false;
        }
      
    }
    
    public static String generateOTP(){
        String alphabets =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String otp = "";
        
        for (int i = 0; i < 3; i++) {
            int index =(int)Math.random()*alphabets.length();
            otp+=alphabets.charAt(index);
        }
        for (int i = 0; i < 6; i++) {
            int index =(int)Math.random()*numbers.length();
            otp+=numbers.charAt(index);
        }
        return otp;
    }
    public static double generateRandomBalance(){
        return generateRandomBalance(1000, 6000);
    }
    
    public static double generateRandomBalance(int min, int max){
         return ((Math.random() * (max - min)) + min);
    }
}
