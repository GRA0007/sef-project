package model.interfaces;

public interface ProgramStructure {
    /*
     * Variables:
     * Name
     *
     * List<Exemption> exemptions
     */

    void addStructure(Structure structure);
    Structure setStructure(Structure structure);
    Structure getStructure(int listNumber);
    void deleteStructure(Structure structure);

    //create hash map here for comparisons
    //hashmap is deleted for each time toString is called
    String toString();
    String toString (int filter);

}
