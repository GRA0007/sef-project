package model.interfaces;

import model.AbstractCategory;

public interface ProgramStructureInt {
    /*
     * Variables:
     * Name
     *
     * List<Exemption> structures
     */

    void addCategory(AbstractCategory structure);
    CategoryInt getCategory(int listNumber);
    void deleteCategory(AbstractCategory structure);

    //create hash map here for comparisons
    //hashmap is deleted for each time toString is called
    String toString();
    String toString (int filter);

}
