package myproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Data Access Object to a collection of NBA Stars.
 *
 * @author Joshua Tennies
 */
public class DAOStar {
    private final String fileName = "starlist.txt";
    public List<Star> myList;

    public DAOStar() {
        myList = new ArrayList();
        
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ex) {
            Logger.getLogger(DAOStar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        readList();
    }

    public void create(Star star) {
        myList.add(star);
        writeList();
    }

    public Star retrieve(int id) {
        for(Star star : myList) {
            if(star.getId() == id) {
                return star;
            }
        }
        return null;
    }

    public void update(Star star) {
        for(Star s : myList) {
            if(s.getId() == star.getId()) {
                s.setName(star.getName());
                s.setPpg(star.getPpg());
                s.setRpg(star.getRpg());
                s.setApg(star.getApg());
                break;
            }
        }
    }

    public void delete(int id) {
        Star myStar = null;
        for(Star s : myList) {
            if(id == s.getId()) {
                myStar = s;
                break;
            }
        }
        myList.remove(myStar);
        writeList();
    }

    public String orderById() {
        myList.sort(Comparator.comparing(Star::getId));
        return this.toString();
    }
    
    public String orderByName() {
        myList.sort(Comparator.comparing(Star::getName));
        return this.toString();
    }
    
    public String orderByPpg() {
        myList.sort(Comparator.comparing(Star::getPpg).reversed());
        return this.toString();
    }
    
    public String orderByRpg() {
        myList.sort(Comparator.comparing(Star::getRpg).reversed());
        return this.toString();
    }
    
    public String orderByApg() {
        myList.sort(Comparator.comparing(Star::getApg).reversed());
        return this.toString();
    }
    
    public String orderbyPpgRpg() {
        myList.sort(Comparator.comparing(Star::getPpg).thenComparing(Star::getRpg).reversed());
        return this.toString();
    }
    
    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double ppg = Double.parseDouble(data[2]);
                double rpg = Double.parseDouble(data[3]);
                double apg = Double.parseDouble(data[4]);
                Star myStar = new Star(id, name, ppg, rpg, apg);
                myList.add(myStar);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(DAOStar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for(Star star : myList) {
                writer.write(String.format("%d, %-20s, %5.1f, %5.1f, %5.1f \n", star.getId(),
                        star.getName(), star.getPpg(), star.getRpg(), star.getApg()));
                
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOStar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Star star : myList) {
            sb.append(star).append("\n");
        }
        return sb.toString();
    }
}
