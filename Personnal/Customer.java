/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democonsole;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author JEhew
 */
public class Customer implements Reservation {
    
    private String custName;
    private String custID;
    private String password;
    private int reserveSeatNo;
    private Ticket ticket;
    private Bus bus;
    private Card card;
    private ArrayList<Schedule> scheduleList;
    
    private static ArrayList<Customer> customerList = new ArrayList<>();
    private static int nextID = 1000;
    

    public Customer(String custName, String password) {
        this.custName = custName;
        this.custID = "CD" + Customer.nextID;
        this.password = password;
        Customer.nextID++ ;
    
    }

    public static void add(Customer customer){
        customerList.add(customer);
    }
    
    public static Customer search(String custName, String password){
        for(int i=0; i< customerList.size(); i++){
            if(customerList.get(i).getCustName().equals(custName) && customerList.get(i).getPassword().equals(password)){
                return customerList.get(i);
            }
        }
        
        return null;
        
    }
    
    public static void edit(Customer oldCustomer, Customer newCustomer){
        int oldCustomerIndex = customerList.indexOf(oldCustomer);
        customerList.set(oldCustomerIndex, newCustomer);
    }
    
    public static void delete(Customer customer){
        customerList.remove(customer);
    }
    
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustID() {
        return custID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getReserveSeatNo() {
        return reserveSeatNo;
    }

    public void setReserveSeatNo(int reserveSeatNo) {
        this.reserveSeatNo = reserveSeatNo;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
    
    public String toString(){
        return String.format("%-30s %-10s %-5d %-15s %-15s",
                custName,custID, reserveSeatNo, bus,ticket);
        
    }
    
    public void addSchedule(Schedule schedule){
        scheduleList.add(schedule);
    }
    
    public void deleteSchedule(Schedule schedule){
        scheduleList.remove(schedule);
    }
    
    public void editSchedule(Schedule schedule){
        scheduleList.set(0,schedule);
    }
    
    public void viewSchedule(Schedule schedule){
        System.out.println(Arrays.toString(scheduleList.toArray()));
    }

    @Override
    public void reserveTicket() {
        
    }

    @Override
    public void payTicket() {
        
    }
    
}
