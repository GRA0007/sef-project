package model;

import model.interfaces.ProgramStructureInt;
import model.interfaces.CategoryInt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramStructure implements ProgramStructureInt {
    public static final int FILTER_COURSE = 0;
    public static final int FILTER_EXEMPTION = 1;
    public static final int FILTER_INTERNSHIP = 2;
    public static final int FILTER_TRANSFER = 3;
    public static final int FILTER_STUDENTFEEDBACK = 4;

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

    public String getString(List<AbstractCategory> categories) {
        if (categories.size() == 0) {
            return "Nothing found";
        } else {
            StringBuilder output = new StringBuilder();
            int i = 1;
            for (AbstractCategory category : categories) {
                String categoryName = category.getClass().getSimpleName();
                if (category instanceof Course && ((Course)category).getExemption())
                    categoryName = "Exemption";
                output.append("\n----------------- (").append(String.valueOf(i)).append(") ").append(categoryName).append(" -----------------");
                output.append(category.toString()).append("\n");
                i++;
            }
            return output.toString();
        }
    }

    public String toString() {
        return getString(categories);
    }

    public String toString(int filter) {
        if (filter == FILTER_COURSE) {
            return getString(categories.stream()
                    .filter(category -> category instanceof Course).collect(Collectors.toList()));
        } else if (filter == FILTER_EXEMPTION) {
            return getString(categories.stream()
                    .filter(category -> category instanceof Course && ((Course)category).getExemption()).collect(Collectors.toList()));
        } else if (filter == FILTER_INTERNSHIP) {
            return getString(categories.stream()
                    .filter(category -> category instanceof Internship).collect(Collectors.toList()));
        } else if (filter == FILTER_TRANSFER) {
            return getString(categories.stream()
                    .filter(category -> category instanceof Transfer).collect(Collectors.toList()));
        } else if (filter == FILTER_STUDENTFEEDBACK) {
            return getString(categories.stream()
                    .filter(category -> category instanceof StudentFeedback).collect(Collectors.toList()));
        }

        return null;
    }

    public String toString(Staff filter) {
        return getString(categories.stream()
                .filter(category -> category.getStaff() == filter).collect(Collectors.toList()));
    }

    public List<AbstractCategory> getResults() {
        return categories;
    }

    public List<AbstractCategory> getResults(int filter) {
        if (filter == FILTER_COURSE) {
            return categories.stream()
                    .filter(category -> category instanceof Course).collect(Collectors.toList());
        } else if (filter == FILTER_EXEMPTION) {
            return categories.stream()
                    .filter(category -> category instanceof Course && ((Course)category).getExemption()).collect(Collectors.toList());
        } else if (filter == FILTER_INTERNSHIP) {
            return categories.stream()
                    .filter(category -> category instanceof Internship).collect(Collectors.toList());
        } else if (filter == FILTER_TRANSFER) {
            return categories.stream()
                    .filter(category -> category instanceof Transfer).collect(Collectors.toList());
        } else if (filter == FILTER_STUDENTFEEDBACK) {
            return categories.stream()
                    .filter(category -> category instanceof StudentFeedback).collect(Collectors.toList());
        }

        return null;
    }

    public List<AbstractCategory> getResults(Staff filter) {
        return categories.stream()
                .filter(category -> category.getStaff() == filter).collect(Collectors.toList());
    }
}
