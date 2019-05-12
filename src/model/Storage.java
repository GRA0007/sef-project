package model;

import model.interfaces.StorageInt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Storage implements StorageInt {

    private List<Staff> staff = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    // Load the data from the database
    public void loadData() {
        Staff testStaff1 = new Staff("e1234","da sokk","Milroy", "10 Street, Suburb", "5555555555", "milroy@rmit.edu.au", "Software Engineering", "Lecturer", 3);
        Staff testStaff2 = new Staff("e5678","da sokk","Not Milroy", "10 Street, Suburb", "5555555555", "notmilroy@rmit.edu.au", "Software Engineering", "Lecturer", 0);
        staff.add(testStaff1);
        staff.add(testStaff2);

        Student testStudent = new Student("s1234", "Stark", "Samantha", "10 Street, Suburb", "5555555555", "s1234@student.rmit.edu.au");
        testStudent.getProgramStructure().addCategory(new Course("CYX123", "Software Engineering Fundamentals", testStaff1, null, new Date(), false, null, false));
        students.add(testStudent);

        System.out.println("Test data loaded");
    }

    // Store the data in the database
    public boolean saveData() {
        return false;
    }

    // Authenticate a staff member by id and password
    public Staff authUser(String staffId, String pass) {
        return staff.stream()
                .filter(staff -> staffId.equalsIgnoreCase(staff.getID()))
                .findAny()
                .orElse(null);
    }

    // Register a new staff member
    public Staff addUser(String staffId, String given, String family, String address, String phone, String department, String jobTitle, int authority, String pass) {
        Staff newUser = new Staff(staffId, family, given, address, phone, staffId + "@rmit.edu.au", department, jobTitle, authority);
        staff.add(newUser);
        return newUser;
    }

    // Get a staff member by id
    public Staff getUser(String staffId) {
        return staff.stream()
                .filter(staff -> staffId.equalsIgnoreCase(staff.getID()))
                .findAny()
                .orElse(null);
    }

    // Retrieve a student by student number
    public Student getStudent(String id) {
        return students.stream()
                .filter(student -> id.equalsIgnoreCase(student.getID()))
                .findAny()
                .orElse(null);
    }

    // Add a new student
    public Student addStudent(String id, String given, String family, String address, String phone) {
        Student newStudent = new Student(id, family, given, address, phone, id + "@student.rmit.edu.au");
        students.add(newStudent);
        return newStudent;
    }
}
