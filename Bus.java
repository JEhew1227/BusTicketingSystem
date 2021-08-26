/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democonsole;

/**
 *
 * @author JEhew
 */
public class Bus {
    
    private int busNo;
    private int seatNumber[];
    private String busStatus;
    private Driver driver;
    private Customer[] customerList;

    public Bus(int busNo, int[] seatNumber, String busStatus, Driver driver, Customer[] customerList) {
        this.busNo = busNo;
        this.seatNumber = seatNumber;
        this.busStatus = busStatus;
        this.driver = driver;
    }

    
    
    public String toString(){
        return String.format("%-5d %-15s %-5d %-15s", busNo,driver,seatNumber,busStatus);
        
    }
    
}
