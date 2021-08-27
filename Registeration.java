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
       	    System.out.println("** [1] User Registeration                 **");
            System.out.println("** [2] Admin Login                        **");
            System.out.println("** [3] Exit                               **");
            System.out.println("********************************************\n");
            System.out.print("ENTER CHOICE: ");
	    String choice;
            choice = scanner.nextLine();
            
       
             if(choice.equals("1")){
                
                System.out.print(" Enter first name >");
                String firstName = scanner.nextLine();
                register.setFirstName(firstName);
                System.out.println("");
                
                System.out.print(" Enter last name >");
                String lastName = scanner.nextLine();
                register.setLastName(lastName);
                System.out.println("");
                
                System.out.print(" Enter email >");
                String email = scanner.nextLine();
                register.setEmail(email);
                System.out.println("");
                
                System.out.print(" Enter username >");
                String username = scanner.nextLine();
                register.setUsername(username);
                System.out.println("");
                
                System.out.print(" Enter password >");
                String password = scanner.nextLine();
                register.setPassword(password);
                System.out.println("");
                
                System.out.print(" Enter phoneNo >");
                long phoneNo = scanner.nextLong();
                register.setPhoneNo(phoneNo);
                System.out.println("");
                
                System.out.println("==============================================");
                System.out.println("Here is the information that you have typed in");
                System.out.println("==============================================");
                System.out.println(register.toString());
                
                //PROCEED TO NEXT MENU//
            }
            else if(choice.equals("2")){
                 
                 System.out.print("Enter Username >");
                 String adminName = scanner.nextLine();        
                 System.out.print("Enter Password >");
                 String adminPass = scanner.nextLine(); 
                   if(adminName.equals("1")){
                       if(adminPass.equals("1")){
                           
                           System.out.println("Admin Login Successfully");
                           //PROCEED TO NEXT MENU//
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
        
        public void editAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================================");
        System.out.println("Are you sure that you want to edit your account?(y/n)");
        String editAcc = scanner.nextLine();  
        if(editAcc.equals("y")){
            Register register = new Register();
            
            System.out.println("Please re-type the information.");
            System.out.println("================================================");
            System.out.print(" Enter first name >");
                String firstName = scanner.nextLine();
                register.setFirstName(firstName);
                System.out.println("==============================================");
                
                System.out.print(" Enter last name >");
                String lastName = scanner.nextLine();
                register.setLastName(lastName);
                System.out.println("==============================================");
                
                System.out.print(" Enter email >");
                String email = scanner.nextLine();
                register.setEmail(email);
                System.out.println("==============================================");
                
                System.out.print(" Enter username >");
                String username = scanner.nextLine();
                register.setUsername(username);
                System.out.println("==============================================");
                
                System.out.print(" Enter password >");
                String password = scanner.nextLine();
                register.setPassword(password);
                System.out.println("==============================================");
                
                System.out.print(" Enter phoneNo >");
                long phoneNo = scanner.nextLong();
                register.setPhoneNo(phoneNo);
                
                System.out.println("==============================================");
                System.out.println("Here is the information that you have typed in");
                System.out.println("==============================================");
                System.out.println(register.toString());
        }
        else if(editAcc.equals("n")){
            System.out.println("You choose to not edit your account.");
            //BACK TO MAIN MENU
        }
        else
            System.out.println("Invalid input, please try again.");
            //BACK TO MAIN MENU
    }
        
    public void deleteAccount(){
        
    }    
        
    public void afterReg(){
        Register register = new Register();
            
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("********************************************");
    	    System.out.println("** BUS RESERVATION AND TICKETING SYSTEM   **");
    	    System.out.println("********************************************");
       	    System.out.println("** [1] Edit account                       **");
            System.out.println("** [2] Delete account                     **");
            System.out.println("** [3] Back to main menu                  **");
            System.out.println("********************************************\n");
            System.out.print("ENTER CHOICE: ");
	    String choice;
            choice = scanner.nextLine();
            
            if(choice.equals("1")){
                editAccount();
            }
            else if(choice.equals("2")){
                deleteAccount();
            }
            else if(choice.equals("3")){
                //BACK TO MAIN MENU
            }
}
}


