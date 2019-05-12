package model;

import model.interfaces.ProgramStructureInt;
import model.interfaces.CategoryInt;

import java.util.ArrayList;
import java.util.List;

public class ProgramStructure implements ProgramStructureInt {

    private List<AbstractCategory> categories = new ArrayList<>();

    public void addCategory(AbstractCategory structure) {
        categories.add(structure);
    }

    public CategoryInt getCategory(int listNumber) {
        return categories.get(listNumber);
    }

    public void deleteCategory(AbstractCategory category) {
        categories.remove(category);
    }

    public String toString() {
        return null;
    }

    public String toString(int filter) {
        return null;
    }
}
