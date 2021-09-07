/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;
import Payment.Card;
import Personnel.Customer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
/**
 *
 * @author Qzheng
 */
public interface Registration {
    
    public static Customer performRegistration(){
        //prompt everything
        Scanner scanner = new Scanner(System.in);
        String userName;
        String password;
        
        System.out.println("Welcome to registration...");
        
        System.out.print("\nEnter username(name you wish to be display as)>");
        userName = scanner.nextLine();      
        
        System.out.print("\nEnter password >");
        password = scanner.nextLine();      
        
        System.out.println("\nThese are the personal information that you have entered");
        
        System.out.printf("\nYour username : %s" ,userName);
        System.out.printf("\nYour password : %s" , password);
        
        Card card = performRegistrationCard();
        
        return new Customer(userName, password, card);  
    }
    
    
    public static Card performRegistrationCard(){
        
        Scanner scanner = new Scanner(System.in);
        String cardNum;
        int cvv;
        Calendar expiryDate = null;
        Calendar calendar = Calendar.getInstance();
        
        
        System.out.print("\nEnter your Card number >");
        cardNum = scanner.nextLine();
        
        System.out.print("\nEnter your Card expiry date (month)>");
        int month = scanner.nextInt();
        
        System.out.print("\nEnter your Card expiry date (year)>");
        int year = scanner.nextInt();
        
        expiryDate.set(Calendar.MONTH, month);
        expiryDate.set(Calendar.YEAR, year);
        
        System.out.print("\nEnter you Card cvv number >");
        cvv = scanner.nextInt();
                
        System.out.println("\nThese are the card information that you have entered\n");
        int monthExpiryDate = expiryDate.get(Calendar.MONTH);
        int yearExpiryDate = expiryDate.get(Calendar.YEAR);
        
        System.out.printf("Your card number      : %s\n" ,cardNum);
        System.out.printf("Your card expiry date : %d/%d\n" , monthExpiryDate, yearExpiryDate);
        System.out.printf("Your card cvv         : %d\n" , cvv);
        
        
        return new Card(cardNum,expiryDate, cvv);
    }
    
    public static void editAccount(){
        
    }

    public static void deleteAccount(){
        
    }

}
