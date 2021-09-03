/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democonsole;

import java.util.ArrayList;

/**
 *
 * @author JEhew
 */

enum BusStatus {
    Early,
    OnTime,
    Delay,
}

public class Bus {
    
    private int busNo;
    private int[] seatNumbers;
    private Driver driver;
    private ArrayList<Customer> customerList;
 
    private static int nextBusID = 1000;
    private final static int[][] BUS_SEAT_NUMBERS = {};
            
    public Bus(Driver driver) {
        this.busNo = Bus.nextBusID;
        this.seatNumbers = Bus.BUS_SEAT_NUMBERS[(int)(Math.random() * Bus.BUS_SEAT_NUMBERS.length)];
        this.driver = driver;
        this.customerList = new ArrayList<>();
    }

    public String toString(){
        return String.format("%-5d %-15s %-5d ", busNo,driver);
        
    }
    
    public void addCustomer(Customer customer){
        customerList.add(customer);
    }
    
    public void deleteCustomer(Customer customer){
        customerList.remove(customer);
    }
}
