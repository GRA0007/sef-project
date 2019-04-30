package model.interfaces;

public interface ProgramStructureInt {
    /*
     * Variables:
     * Name
     *
     * List<Exemption> exemptions
     */

    void addStructure(StructureInt structure);
    StructureInt setStructure(StructureInt structure);
    StructureInt getStructure(int listNumber);
    void deleteStructure(StructureInt structure);

    //create hash map here for comparisons
    //hashmap is deleted for each time toString is called
    String toString();
    String toString (int filter);

}
