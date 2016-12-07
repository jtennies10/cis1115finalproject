
package utilities;

import myproject.DAOStar;
import myproject.Star;

/**
 *
 * @author Joshua Tennies
 */
public class Statistics {
    public static double lowestPpg(DAOStar data) {
        double lowest = 100;
        for(Star s : data.myList) {
            if(s.getPpg() < lowest) lowest = s.getPpg();
        }
        return lowest;
    }
    
    public static double highestPpg(DAOStar data) {
        double highest = 0;
        for(Star s : data.myList) {
            if(s.getPpg() > highest) highest = s.getPpg();
        }
        return highest;
    }
    
    public static double sumPpg(DAOStar data) {
        double sum = 0;
        for(Star s : data.myList) {
            sum += s.getPpg();
        }
        return sum;
    }
    
    public static double averagePpg(DAOStar data) {
        double sum = sumPpg(data);
        double average = sum / data.myList.size();
        return average;
    }
    
    public static double standardDeviationPpg(DAOStar data) {
        double total = 0;
        double average = averagePpg(data);
        for(Star s : data.myList) { 
            total += Math.pow((s.getPpg() - average), 2); //calculates top of standard dev calculation 
        }
        return Math.sqrt(total / (data.myList.size() - 1));
    }
}
