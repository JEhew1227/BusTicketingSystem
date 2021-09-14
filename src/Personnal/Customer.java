/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnel;

import Asset.Schedule;
import Asset.Ticket;
import Asset.Bus;
import Payment.Card;
import Payment.Payment;
import Reservation.Reservation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author JEhew
 */
public class Customer extends Person implements Reservation {

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

    public Customer(Person person, String password, Card card) {
        super(person.name);
        this.custName = custName;
        this.custID = "CD" + Customer.nextID;
        this.password = password;
        Customer.nextID++;

    }

    public static void add(Customer customer) {
        customerList.add(customer);
    }

    public static Customer search(String custName, String password) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustName().equals(custName) && customerList.get(i).getPassword().equals(password)) {
                return customerList.get(i);
            }
        }

        return null;

    }

    public static void edit(Customer oldCustomer, Customer newCustomer) {
        int oldCustomerIndex = customerList.indexOf(oldCustomer);
        customerList.set(oldCustomerIndex, newCustomer);
    }

    public static void delete(Customer customer) {
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

    public String toString() {
        return String.format("%-30s %-10s %-5d %-15s %-15s",
                custName, custID, reserveSeatNo, bus, ticket);

    }

    public void addSchedule(Schedule schedule) {
        scheduleList.add(schedule);
    }

    public void deleteSchedule(Schedule schedule) {
        scheduleList.remove(schedule);
    }

    public void editSchedule(Schedule schedule) {
        scheduleList.set(0, schedule);
    }

    public void viewSchedule(Schedule schedule) {
        System.out.println(Arrays.toString(scheduleList.toArray()));
    }

    @Override
    public void reserveTicket() {
        Scanner scanner = new Scanner(System.in);
        int selection;
        int destination;
        char matrix[][] = new char[11][10];

        do {
            System.out.println("\t \t *=====================*");
            System.out.println("\t \t |     Reservation     |");
            System.out.println("\t \t *=====================*");
            System.out.println("\t \t | [1] Destination     |");
            System.out.println("\t \t | [2] Booking Ticket  |");
            System.out.println("\t \t | [3] Exit            |");
            System.out.println("\t \t *=====================*");
            System.out.println(""); // new line
            System.out.print(" \t \t Enter your choice : ");
            selection = scanner.nextInt();

            parseTicketUserChoice(selection, destination, matrix);
            

        } while (selection != 3);

    }

    private static void parseTicketUserChoice(int selection, int destination, char matrix[][]) {

        Scanner scanner = new Scanner(System.in);
        switch (selection) {
            case 1:
                System.out.println("\t \t *========================================================*");
                System.out.println("\t \t |                   Destination  List                    |");
                System.out.println("\t \t *========================================================*");
                System.out.println("\t \t |     Destination         |     Time      |     Price    |");
                System.out.println("\t \t *========================================================*");
                System.out.println("\t \t |  [1]   Seremban         |    10 : 00    |     RM 10    |");
                System.out.println("\t \t |  [2] Kuala Lumpur       |    12 : 00    |     RM 10    |");
                System.out.println("\t \t |  [3]   Selangor         |    14 : 00    |     RM 10    |");
                System.out.println("\t \t |  [4]     Kedah          |    16 : 00    |     RM 10    |");
                System.out.println("\t \t |  [5]  Johor Bahru       |    18 : 00    |     RM 10    |");
                System.out.println("\t \t *========================================================*");
                System.out.println(""); // new line

                break;

            case 2:
                System.out.println("\t \t *============================*");
                System.out.println("\t \t |       Booking Ticket       *");
                System.out.println("\t \t *============================*");
                System.out.println(""); // new line
                System.out.print(" \t \t Enter Destination : ");
                destination = scanner.nextInt();
                
                destination(destination, matrix);

                

            case 3:
                System.out.println("Thank You and BYE !");
                System.out.println(" Have A Nice Day ! ");
                break;

        }
    }
    
    private static void destination(int destination, char matrix[][]) {

        switch (destination) {
            case 1:
                System.out.println("\t*====================*");
                System.out.println("\t*      Seremban      *");
                System.out.println("\t*====================*");
                bookingSeat(matrix);
                break;
            case 2:
                System.out.println("\t*====================*");
                System.out.println("\t*    Kuala Lumpur    *");
                System.out.println("\t*====================*");
                bookingSeat(matrix);
                break;
                
            case 3:
                System.out.println("\t*====================*");
                System.out.println("\t*     Selangor       *");
                System.out.println("\t*====================*");
                bookingSeat(matrix);
                break;
                
            case 4:
                System.out.println("\t*====================*");
                System.out.println("\t*       Kedah        *");
                System.out.println("\t*====================*");
                bookingSeat(matrix);
                break;
                
            case 5:
                System.out.println("\t*====================*");
                System.out.println("\t*     Johor Bahru    *");
                System.out.println("\t*====================*");
                bookingSeat(matrix);
                break;
                

        }
    }
    
    private static void bookingSeat(char matrix[][]) {

        Scanner scanner = new Scanner(System.in);

        //loop for column
        for (int colNum = 1; colNum <= 2; colNum++) {
            System.out.print(" Col " + (colNum) + "\t");
        }
        System.out.println();

        //loop for row
        for (int rowNum = 1; rowNum < 10; rowNum++) {
            System.out.println("Row    " + (rowNum) + "| \t");
            //loop for printing row and col
            for (int col = 1; col <= 2; col++) {
                matrix[rowNum][col] = '*';
                System.out.print(matrix[rowNum][col] + "\t\t");

            }
            System.out.println();
        }
        while (true) {
            System.out.print("Enter row and column seperated by space : ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Row : " + x);
            System.out.println("Column : " + y);

            if ((x > 0 && y < 0)) {
                System.out.println("\n \t Bus Seat Reservation ");
                System.out.println();
                System.out.println("\n---------------------------------------");

                for (int colNum = 1; colNum <= 2; colNum++) {
                    System.out.print("Column " + (colNum) + "\t");
                }

                for (int rowNum = 1; rowNum <= 10; rowNum++) {
                    System.out.print("Row " + (rowNum) + "\t");
                    for (int col = 1; col <= 2; col++) {
                        matrix[x][y] = 'X';
                        System.out.print(matrix[rowNum][col] + "\t\t");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Booking Failed ! - Please Booking Again !");
                break;
            }

            System.out.println("You Have Successfully booking a seat !");
            System.out.print("Do you want booking another seat ? (Y/N) : ");
            char option = scanner.next().charAt(0);

            if (option == 'Y' || option == 'y') {
                continue;
            } else {
                System.out.println(" Enjoy Your Trip !");
                break;

            }

        }

    }

   @Override
    public void payTicket() {
        performPayment(this, ticket);

        if (ticket.verifyPaidStatus().paidStatus == true) {
            Ticket ticket;
        } else {
            performTicket(this, ticket);
        }
    }
    
}
