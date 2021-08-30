/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package receipt;

/**
 *
 * @author User
 */
public class Receipt extends transaction {

Receipt(Customer customer, Date datePaid, double amountPaid){
       super(customer, datePaid, amountPaid);
 } 

}

public static void main(String[] args){
       
       Receipt r = new Receipt("customer", datePaid, amountPaid);
       System.out.println("|-----------------------------------|");
       System.out.println("|Customer Name|Date paid|Amount paid|");
       System.out.println("|-----------------------------------|");
       System.out.println("|                                   |");
       System.out.println("|-----------------------------------|");
       System.out.println("| r.customer|r.datePaid|r.amountPaid|");
       System.out.println("|-----------------------------------|");
       System.out.println("|Thank you!! Till next time:)       |");
       System.out.println("|-----------------------------------|");

}
  

 
