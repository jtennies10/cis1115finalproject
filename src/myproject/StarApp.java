
package myproject;

/**
 *
 * @author Joshua Tennies
 */
public class StarApp {
    public static void main(String[] args) {
        Star curry = new Star(1, "Steph Curry", 26.7, 4.2, 6.1);
        System.out.println(curry);
        Star lebron = new Star(2, "LeBron James", 23.6, 8.4, 9.7);
        System.out.println(lebron);
        Star davis = new Star(3, "Anthony Davis", 31.6, 10.9, 2.1);
        System.out.println(davis);
    }
}
