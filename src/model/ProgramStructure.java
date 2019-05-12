package model;

import model.interfaces.ProgramStructureInt;
import model.interfaces.CategoryInt;

import java.util.ArrayList;
import java.util.List;

public class ProgramStructure implements ProgramStructureInt {
    public static final int FILTER_COURSE = 0;
    public static final int FILTER_EXEMPTION = 1;
    public static final int FILTER_INTERNSHIP = 2;
    public static final int FILTER_TRANSFER = 3;

    private String name;
    private List<AbstractCategory> categories = new ArrayList<>();

    public void addCategory(AbstractCategory structure) {
        categories.add(structure);
    }

    public AbstractCategory getCategory(int listNumber) {
        return categories.get(listNumber);
    }

    public Course getCourseByCode(String code) {
        for (AbstractCategory category : categories) {
            if (category instanceof Course && ((Course)category).getCourseCode().equalsIgnoreCase(code)) {
                return (Course) category;
            }
        }
        return null;
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
