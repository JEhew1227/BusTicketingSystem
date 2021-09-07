
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ticket;


/**
 *
 * @author User
 */

public class Ticket {
 
    private double amount = 10;
    private int quantity;
    private boolean paidStatus;
    
    public Ticket(int quantity, boolean paidStatus) {
        this.quantity = quantity;
        this.paidStatus = paidStatus;
    }

    public void verifyPaidStatus(){
        if (paidStatus = true){
            System.out.println("Payment has been made!");
        }
        else{
            System.out.println("Payment invalid!");
        }
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public boolean isPaidStatus() {
        return paidStatus;
    }
   
    public void setPaidStatus(boolean paidStatus) {
        this.paidStatus = paidStatus;
    }
}

