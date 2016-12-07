
package utilities;

import java.util.Scanner;

/**
 * Prompt is a class that gets console input from the user, validates the input,
 * and then returns the result.
 *
 * @author Joshua Tennies
 */
public class Prompt {
    public static int getInt(String prompt) {
        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        int i = 0;
        while(!isValid) {
            System.out.print(prompt);
            if(input.hasNextInt()) {
                i = input.nextInt();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid integer value. Try again.");
            }
            input.nextLine();
        }
        return i;
    }
    
    public static int getInt(String prompt, int min, int max) {
        boolean isValid = false;
        int i = 0;
        while(!isValid) {
            i = getInt(prompt);
            if(i < min) {
                System.out.println("\nError! Must be greater than or equal to "
                        + min);
            } else if(i > max) {
                System.out.println("\nError! Must be less than or equal to "
                        + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }
    
    public static double getDouble(String prompt) {
        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        double d = 0;
        while(!isValid) {
            System.out.print(prompt);
            if(input.hasNextDouble()) {
                d = input.nextDouble();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid double value. Try again");
            }
            input.nextLine();
        }
        return d;
    }
    
    public static double getDouble(String prompt, double min, double max) {
        boolean isValid = false;
        double d = 0;
        while(!isValid) {
            d = getDouble(prompt);
            if(d < min) {
                System.out.println("\nError! Must be greater than or equal to "
                        + min);
            } else if(d > max) {
                System.out.println("\nError! Must be less than or equal to "
                        + max);
            } else {
                isValid = true;
            }
        }
        return d;
    }
    
    public static String getLine(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        return input.nextLine();
    }
}
