/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnal;

import Management.BusTicketingSystem;
import Asset.Schedule;
import Asset.Ticket;
import Asset.Bus;
import payment.Card;
import payment.Payment;
import Reservation.Reservation;

import Asset.Bus;
import Personnal.Person;
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
        this(person.getName(), password, card);
    }

    public Customer(String name, String password, Card card) {
        super(name);
        this.custID = "CD" + nextID;
        this.password = password;
        this.card = card;
        ++nextID;
    }



    public static void add(Customer customer) {
        customerList.add(customer);
    }

    public static Customer search(String custName, String password) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getName().equals(custName) && customerList.get(i).getPassword().equals(password)) {
                return customerList.get(i);
            }
           
        }
        return null;
    }

    public static void edit(Customer oldCustomer, Customer newCustomer) {
        int oldCustomerIndex = customerList.indexOf(oldCustomer);
        customerList.set(oldCustomerIndex, newCustomer);
    }

    public static void deleteAccount(Customer customer){

        Scanner scanner = new Scanner(System.in);
        char yesOrno;

        do{
            System.out.printf("Are you sure you want to delete your account?(y/n)");
            yesOrno = scanner.next().charAt(0);

        if(yesOrno == 'Y' || yesOrno == 'y'){
            System.out.println("\nYour account has been deleted\n");
            customerList.remove(customer);
            
        }
        else if (yesOrno == 'N' || yesOrno == 'n'){
            
        }
        else
            System.out.println("\nInvalid Choice, please enter again.\n");
        }while(yesOrno != 'y' || yesOrno != 'n');
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

    public Card getCard(){
        return this.card;
    }

    public String toString() {
        return String.format("%-30s %-10s %-5d %-15s %-15s",
                custName, custID, reserveSeatNo, bus, ticket);

    }

    @Override
    public void reserveTicket() {
        Scanner scanner = new Scanner(System.in);
        int selection;
        int destination = 0;
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

            Ticket ticket = parseTicketUserChoice(selection, destination, matrix);

            if (ticket != null) {
                this.setTicket(ticket);
            }
        } while (selection != 3);

    }

    public static Ticket parseTicketUserChoice(int selection, int destination, char matrix[][]) {

        Scanner scanner = new Scanner(System.in);
        Ticket ticket = null;
        switch (selection) {
            case 1:
                System.out.println("\t \t *========================================================*");
                System.out.println("\t \t |                   Destination  List                    |");
                System.out.println("\t \t *========================================================*");
                System.out.println("\t \t |     Destination         |     Time      |     Price    |");
                System.out.println("\t \t *========================================================*");
                for(int i = 0 ; i < Schedule.scheduleList.size() ; i++){
                    Schedule schedule = Schedule.scheduleList.get(i);
                    System.out.printf("\t\t|  [%d] %-20s |    %s    |    RM%d    |\n", i+1, schedule.getDestination(), schedule.getDepartureTime(), 10);
                }
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
                
                ticket = destination(destination, matrix);

            case 3:
                System.out.println("Thank You and BYE !");
                System.out.println(" Have A Nice Day ! ");
                break;

        }
        return ticket;
    }

    private static Ticket destination(int destination, char matrix[][]) {

        if(destination < 0 || destination > Schedule.scheduleList.size()-1){
            return null;
        }
        System.out.println("\t \t *============================*");
        System.out.printf("\t \t *%10s\n", Schedule.scheduleList.get(destination-1).getDestination());
        System.out.println("\t \t *============================*");
        return bookingSeat(matrix);
    }

    private static Ticket bookingSeat(char matrix[][]) {

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

            if ((x > 0 && y > 0)) {
                System.out.println("\n \t Bus Seat Reservation ");
                System.out.println();
                System.out.println("\n---------------------------------------");

                for (int colNum = 1; colNum <= 2; colNum++) {
                    System.out.print("Column " + (colNum) + "\t");
                }

                for (int rowNum = 1; rowNum <= 10; rowNum++) {
                    System.out.print("\nRow " + (rowNum) + "\t");
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
        // create ticket
        return new Ticket(10, 1, false);
    }
//work in progress
   @Override
    public void payTicket() {
        if(ticket.isPaidStatus()){
            return ;
        }
        boolean paid = Payment.performPayment(this, ticket);
        ticket.setPaidStatus(paid);
    }

}


