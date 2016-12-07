/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

/**
 *
 * @author Joshua Tennies
 */
public class StarApp2 {
    public static void main(String[] args) {
        DAOStarSimple data = new DAOStarSimple();
        data.create(new Star(1, "Stephen Curry", 26.7, 5.1, 6.2));
        data.create(new Star(2, "Lebron James", 23.3, 9.8, 8.1));
        data.create(new Star(3, "Anthony Davis", 30.1, 10.4, 2.1));
        data.create(new Star(4, "Russell Westbrook", 31.2, 10.1, 11.2));
        data.create(new Star(5, "James Harden", 29.1, 7.4, 12.1));
        
        //test printing all data
        System.out.print(data);
        
        //test retrieve
        System.out.println("");
        System.out.println("Testing retrieve");
        System.out.println(data.retrieve(1));
        System.out.println(data.retrieve(3));
        System.out.println(data.retrieve(-1));
        
        //test update
        System.out.println("");
        System.out.println("Testing update");
        Star curry = new Star(1, "Stephen Curry", 26.7, 5.1, 6.2);
        curry.setPpg(29.2);
        data.update(curry);
        System.out.println(data.retrieve(1));
        
        //test delete
        System.out.println("");
        System.out.println("Testing delete");
        data.delete(3);
        System.out.println(data);
        
        
        
    }
   
}
