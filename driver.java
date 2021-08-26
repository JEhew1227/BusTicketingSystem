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
public class driver {
    private String driverID;
    private static int nextID = 100;
    
    public driver(){
        this.driverID = "BD" +nextID;
        ++nextID;
    }
    
    
    public String toString(){
        return "Driver Id: "+driverID+"\n";
    }
}
