/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package person;

import java.util.Scanner;

/**
 *
 * @author User
 */
interface PersonInterface {
        String name = "Name:";
        
        void addName();    
}

public class Person implements PersonInterface{

public static void main(String[] args){
       
       System.out.println(name);

       Person p = new Person();
       p.addName();
}

public void addName(){
Scanner scanner = new Scanner (System.in);
String name = scanner.nextLine();
}
       
}