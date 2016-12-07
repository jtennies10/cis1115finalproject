package myproject;

import java.util.Scanner;
import utilities.Prompt;
import utilities.Statistics;

/**
 *
 * @author Joshua Tennies
 */
public class StarAppMenu {

    Scanner input = new Scanner(System.in);
    DAOStar data = new DAOStar();

    public static void main(String[] args) {
        new StarAppMenu();
    }

    public StarAppMenu() {
        menuLoop();
    }

    private void menuLoop() {
        int choice = 1;
        int id = 0;
        String name;
        double ppg;
        double rpg;
        double apg;

        while (choice != 0) {
            System.out.println("\nPet App");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Record");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            System.out.println("6 = Retrieve All: Order by Id");
            System.out.println("7 = Retrieve All: Order by Name");
            System.out.println("8 = Retrieve All: Order by Points Per Game");
            System.out.println("9 = Retrieve All: Order by Rebounds Per Game");
            System.out.println("10 = Retrieve All: Order by Assists Per Game");
            System.out.println("11 = Retrieve All: Order by Points Per Game "
                    + "/ Rebounds Per Game");
            System.out.println("12 = Statistics for Points Per Game");
            choice = Prompt.getInt("Number of choice: ", 0, 12);

            if (choice == 1) {
                System.out.println(data.toString());
            } else if (choice == 2) {
                id = Prompt.getInt("Enter the id: ");
                name = Prompt.getLine("Enter the name: ");
                ppg = Prompt.getDouble("Enter the Points Per Game: ");
                rpg = Prompt.getDouble("Enter the Rebounds Per Game: ");
                apg = Prompt.getDouble("Enter the Assists Per Game: ");
                Star star = new Star(id, name, ppg, rpg, apg);
                data.create(star);
            } else if (choice == 3) {
                id = Prompt.getInt("Enter the id: ");
                System.out.println(data.retrieve(id));
            } else if (choice == 4) {
                id = Prompt.getInt("Enter the id: ");
                name = Prompt.getLine("Enter the name: ");
                ppg = Prompt.getDouble("Enter the Points Per Game: ");
                rpg = Prompt.getDouble("Enter the Rebounds Per Game: ");
                apg = Prompt.getDouble("Enter the Assists Per Game: ");
                Star star = new Star(id, name, ppg, rpg, apg);
                data.update(star);
            } else if (choice == 5) {
                id = Prompt.getInt("Enter the id: ");
                data.delete(id);
            } else if (choice == 6) {
                System.out.println(data.orderById());
            } else if (choice == 7) {
                System.out.println(data.orderByName());
            } else if (choice == 8) {
                System.out.println(data.orderByPpg());
            } else if (choice == 9) {
                System.out.println(data.orderByRpg());
            } else if (choice == 10) {
                System.out.println(data.orderByApg());
            } else if (choice == 11) {
                System.out.println(data.orderbyPpgRpg());
            } else if (choice == 12) {
                System.out.println("Lowest Points Per Game: " 
                        + Statistics.lowestPpg(data));
                System.out.println("Highest Points Per Game: "
                        + Statistics.highestPpg(data));
                System.out.printf("Total Points Per Game: %.2f\n", 
                        Statistics.sumPpg(data));
                System.out.printf("Average Points Per Game: %.2f\n",
                        Statistics.averagePpg(data));
                System.out.printf("Standard Deviation for Points Per Game: %.2f\n",
                        Statistics.standardDeviationPpg(data));
            } else {
                System.out.println("Please enter a number between zero and five.");
            }
        }
    }
}
