
package myproject;

/**
 * NBA Star Object
 * @author Joshua Tennies
 */
public class Star {
    private int id;
    private String name;
    private double ppg; //Points Per Game
    private double rpg; //Rebounds Per Game
    private double apg; //Assists Per Game

    public Star() {
    }

    public Star(int id, String name, double ppg, double rpg, double apg) {
        this.id = id;
        this.name = name;
        this.ppg = ppg;
        this.rpg = rpg;
        this.apg = apg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPpg() {
        return ppg;
    }

    public void setPpg(double ppg) {
        this.ppg = ppg;
    }

    public double getRpg() {
        return rpg;
    }

    public void setRpg(double rpg) {
        this.rpg = rpg;
    }

    public double getApg() {
        return apg;
    }

    public void setApg(double apg) {
        this.apg = apg;
    }
    
    @Override
    public String toString() {
        return String.format("%d %-20s %5.1f %5.1f %5.1f", id, name, ppg, rpg, apg);
    }

}
