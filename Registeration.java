/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registeration;

import java.util.Scanner;

/**
 *
 * @author Qzheng
 */
public class Registeration {

        public static void main(String[] args){
           
            Register register = new Register();
            
            Scanner scanner = new Scanner(System.in);

            System.out.println("THIS IS A BUS RESERVATION AND TICKETING SYSTEM...");
            System.out.println("********************************************");
    	    System.out.println("** BUS RESERVATION AND TICKETING SYSTEM   **");
    	    System.out.println("********************************************");
       	    System.out.println("** [1] User Registeration/Login           **");
            System.out.println("** [2] Admin Login                        **");
            System.out.println("** [2] Exit                               **");
            System.out.println("********************************************\n");
            System.out.print("ENTER CHOICE: ");
	    String choice;
            choice = scanner.nextLine();
            
       
             if(choice.equals("1")){
                
                System.out.print(" Enter first name >");
                String firstName = scanner.nextLine();
                register.setFirstName(firstName);
                
                System.out.print(" Enter last name >");
                String lastName = scanner.nextLine();
                register.setLastName(lastName);
                
                System.out.print(" Enter email >");
                String email = scanner.nextLine();
                register.setEmail(email);
                
                System.out.print(" Enter username >");
                String username = scanner.nextLine();
                register.setUsername(username);
                
                System.out.print(" Enter password >");
                String password = scanner.nextLine();
                register.setPassword(password);
                
                System.out.print(" Enter phoneNo >");
                long phoneNo = scanner.nextLong();
                register.setPhoneNo(phoneNo);
                
                System.out.println(register.toString());
            }
            else if(choice.equals("2")){
                 
                 System.out.println("Enter Username >");
                 String adminName = scanner.nextLine();        
                 System.out.println("Enter Password >");
                 String adminPass = scanner.nextLine(); 
                   if(adminName.equals("1")){
                       if(adminPass.equals("1")){
                           //To next menu
                       }
                   }
                   else{
                       System.out.println("Invalid Input, please try again.");
                       System.exit(0);
                   }
                      
                         
            }
            else if(choice.equals("3")){
                 System.out.println("Thank you!!");
                 System.exit(0);
            }
            
        }
        
        private void printRegisterData(Register register){
            System.out.println(register.getFirstName());
            System.out.println(register.getLastName());
            System.out.println(register.getEmail());
            System.out.println(register.getUsername());
            System.out.println(register.getPassword());
            System.out.println(register.getPhoneNo());
        }
    
}

class Register{
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private long phoneNo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    @Override
    public String toString() {
        return "Register [firstName = " + firstName + ", lastName = " + lastName + ", Email = " + email + ", Username = " +
            username + ", Email = " + email + ", PhoneNo = " + phoneNo + "]";
    }
    
   
}


