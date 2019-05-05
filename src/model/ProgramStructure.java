package model;

import model.interfaces.ProgramStructureInt;
import model.interfaces.StructureInt;

import java.util.ArrayList;
import java.util.List;

public class ProgramStructure implements ProgramStructureInt {

	private List<AbstractStructure> structures = new ArrayList<>();

    public void addStructure(AbstractStructure structure) {
        structures.add(structure);
    }

    public StructureInt getStructure(int listNumber) {
        return structures.get(listNumber);
    }

    public void deleteStructure(AbstractStructure structure) {
        structures.remove(structure);
    }

    public String toString() {
        return null;
    }

    public String toString(int filter) {
        return null;
    }
}
