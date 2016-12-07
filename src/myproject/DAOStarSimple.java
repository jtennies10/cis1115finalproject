
package myproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joshua Tennies
 */
public class DAOStarSimple {
    List<Star> myList;
    
    DAOStarSimple() {
        myList = new ArrayList();
    }
    
    public void create(Star star) {
        myList.add(star);
    }
    
    public Star retrieve(int id) {
        for(Star s : myList) {
            if(s.getId() == id) {
                return s;
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
