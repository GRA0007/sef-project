package model;

import model.interfaces.StorageInt;

public class Storage implements StorageInt {

    // Load the data from the database
    public void loadData() {

    }

    // Store the data in the database
    public boolean saveData() {
        return false;
    }

    // Authenticate a staff member by id and password
    public Staff authUser(String staffId, String pass) {
        // Testing
        return new Staff("e1234","Milroy","da sokk", "", "", "", "", "", true);
    }

    // Register a new staff member
    public Staff addUser(String staffId, String given, String family, String address, String phone, String department, String jobTitle, boolean authority, String pass) {
        return new Staff(staffId, family, given, address, phone, staffId + "@rmit.edu.au", department, jobTitle, authority);
    }

    // Retrieve a student by student number
    public Student getStudent(String id) {
        // Testing
        return new Student("s1234", "Grant", "Ben", "10 Street, Suburb", "5555555555", "s1234@student");
    }

    // Add a new student
    public Student addStudent(String id, String given, String family, String address, String phone) {
        //TODO: add to list of students
        return new Student(id, family, given, address, phone, id + "@student.rmit.edu.au");
    }
}
