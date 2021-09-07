/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receipt;

import java.util.Calendar;

/**
 *
 * @author User
 */
public class Receipt {
    private Customer customer;
    private Calendar datePaid;
    private boolean paidStatus;
    private int quantity;
    private double amountPaid;

    public Receipt(Customer customer) {
        this.customer = customer;
        datePaid = Calendar.getInstance();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Calendar getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Calendar datePaid) {
        this.datePaid = datePaid;
    }

    public boolean isPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(boolean paidStatus) {
        this.paidStatus = paidStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public static void printReceipt(Customer customer, Calendar datePaid, boolean paidStatus, int quantity, double amountPaid) {
        System.out.println("===========================\n");
        System.out.println("|Customer Name:"+customer+"\n" );
        System.out.println("|Date Paid:   "+datePaid+" \n");
        System.out.println("|Paid Status: "+paidStatus+"\n");
        System.out.println("|No.of tickets:    "+quantity+" \n");
        System.out.println("===========================\n");
        System.out.println("|Amount paid(RM) "+amountPaid+" \n");
        System.out.println("===========================\n\n");
        System.out.println("Thank you and till next time:) ");
    }
}
    
    
    
    
    
}
    
    

    
  


