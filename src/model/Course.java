package model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Course extends AbstractCategory {

    private String courseCode;
    private String courseName;
    private Date startDate;
    private Date endDate;
    private boolean isCompleted = false;
    private String completedOrNot = "";
    private Staff coordinator;
    private Course[] prerequisites;
    private boolean isExemption;

    public Course(String courseCode, String courseName, Staff coordinator, Course[] prerequisites, Date startDate, boolean isCompleted, Date endDate, boolean isExemption) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCompleted = isCompleted;
        this.coordinator = coordinator;
        this.prerequisites = prerequisites;
        this.isExemption = isExemption;
        
        
    }

    @Override
    public String getDuration() {
        if (isCompleted) {
            long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            String duration = diff + " months";
            return duration;
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
            for (Course prerequisite : prerequisites) {
                prerequisitesString.append(prerequisite.getCourseCode()).append(": ").append(prerequisite.getCourseName()).append("\n");
            }
            return prerequisitesString.toString();
        } else {
            return "None";
        }
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
        toString = String.format("%s\n%-30s%s", toString, "Course coordinator:", this.coordinator.getName());
        toString = String.format("%s\n%-30s%s", toString, "Prerequisites:", this.getPrerequisites());
        toString = String.format("%s\n%-30s%s", toString, "Course duration:", this.getDuration());

        if (isCompleted) {
            completedOrNot = "Completed";
        } else {
            completedOrNot = "Pending";
        }
        toString = String.format("%s\n%-30s%s", toString, "Status:", this.completedOrNot);

        return toString;
    }
}