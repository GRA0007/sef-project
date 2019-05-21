package model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Course extends AbstractCategory {

    private String courseCode;
    private String courseName;
    private String semester;
    private String[] prerequisites;
    private boolean isExemption;

    //Add if fail or pass
    //Add an int for the risk one here
    public Course(String courseCode, String courseName, String semester, Staff coordinator, String[] prerequisites, Date startDate, boolean isCompleted, Date endDate, boolean isExemption) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.semester = semester;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCompleted = isCompleted;
        this.staff = coordinator;
        this.prerequisites = prerequisites;
        this.isExemption = isExemption;
    }

    public Course(String courseCode, String courseName,String semester,Staff coordinator, Date startDate, boolean isCompleted, Date endDate, boolean isExemption) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.semester = semester;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCompleted = isCompleted;
        this.staff = coordinator;
        this.isExemption = isExemption;
    }


    @Override
    public String getDuration() {
        if (isCompleted) {
            long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            return diff + " months";
        } else {
            return "N/A";
        }
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getPrerequisites() {

        if (prerequisites != null) {
            StringBuilder prerequisitesString = new StringBuilder();
            for (String prerequisite : prerequisites) {
                prerequisitesString.append(prerequisite);
            }
            return prerequisitesString.toString();
        } else {
            return "None";
        }
    }

    public String[] getPrerequisiteArray() {
        return prerequisites;
    }

    public String getSemester(){
        return this.semester;
    }

    public boolean getExemption()
    {
        return isExemption;
    }

    @Override
    public String toString() {
        String toString = "";

        toString = String.format("%s\n%-30s%s", toString, "Course code:", this.courseCode);
        toString = String.format("%s\n%-30s%s", toString, "Course name:", this.courseName);
        toString = String.format("%s\n%-30s%s", toString, "Course coordinator:", this.staff.getName());
        toString = String.format("%s\n%-30s%s", toString, "Prerequisites:", this.getPrerequisites());
        toString = String.format("%s\n%-30s%s", toString, "Course duration:", this.getDuration());
        toString = String.format("%s\n%-30s%s", toString, "Semester:", this.getSemester());

        String completedOrNot;
        if (isCompleted) {
            completedOrNot = "Completed";
        } else {
            completedOrNot = "Pending";
        }
        toString = String.format("%s\n%-30s%s", toString, "Status:", completedOrNot);

        return toString;
    }
}