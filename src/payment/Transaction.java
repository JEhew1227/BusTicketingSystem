/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaassignment;

/**
 *
 * @author KUNG WEI XIN
 */
abstract public class Transaction implements Payment{

    protected String paymentID;
    protected Ticket ticket;
    private static int nextTransactionID = 1000;
    
    public Transaction(Ticket ticket) {
        this.paymentID = "PMT"+Transaction.nextTransactionID;
        this.ticket = ticket;
        Transaction.nextTransactionID++;
    }
    
    public static double calTotal(Ticket ticket){
        return ticket.getAmount() * ticket.getQuantity;
    }

    public Transaction(String paymentID, Ticket ticket) {
        this.paymentID = paymentID;
        this.ticket = ticket;
    }
    
    
}
