package model.interfaces;

import model.AbstractCategory;
import model.Staff;

import java.util.List;

public interface ProgramStructureInt {
    /*
     * Variables:
     * Name
     *
     * List<Exemption> structures
     */

    void addCategory(AbstractCategory structure);
    AbstractCategory getCategory(int listNumber);
    void deleteCategory(AbstractCategory structure);

    //create hash map here for comparisons
    //hashmap is deleted for each time toString is called
    String toString();
    String toString (int filter);
    String toString (Staff filter);

    List<AbstractCategory> getResults();
    List<AbstractCategory> getResults(int filter);
    List<AbstractCategory> getResults(Staff filter);

}
