/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democonsole;

import java.util.Date;

/**
 *
 * @author JEhew
 */
public class Card {
    
    private String cardNum;
    private Date expiryDate;
    private int cvv;
    
    private static boolean credit;

    public Card(String cardNum, Date expiryDate, int cvv) {
        this.cardNum = cardNum;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    
    
    public String toString(){
        return String.format("%-20s %-15s %-5d", cardNum,expiryDate,cvv);
        
    }
    
}
