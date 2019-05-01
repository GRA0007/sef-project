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
        return null;
    }

    // Register a new staff member
    public Staff addUser(String staffId, String pass) {
        return null;
    }
}
