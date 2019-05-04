package model.interfaces;

import model.AbstractStructure;

public interface ProgramStructureInt {
    /*
     * Variables:
     * Name
     *
     * List<Exemption> structures
     */

    void addStructure(AbstractStructure structure);
    StructureInt getStructure(int listNumber);
    void deleteStructure(AbstractStructure structure);

    //create hash map here for comparisons
    //hashmap is deleted for each time toString is called
    String toString();
    String toString (int filter);

}
