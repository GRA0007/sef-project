package model;

import model.interfaces.ProgramStructureInt;
import model.interfaces.CategoryInt;

import java.util.ArrayList;
import java.util.List;

public class ProgramStructure implements ProgramStructureInt {
    private String name;
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
        if (categories.size() == 0) {
            return "Program structure is empty";
        } else {
            StringBuilder output = new StringBuilder();
            for (AbstractCategory category : categories) {
                output.append("\n").append(category.getClass().getSimpleName());
                output.append(category.toString()).append("\n");
            }
            return output.toString();
        }
    }

    public String toString(int filter) {
        return null;
    }
}
