package model.interfaces;

import model.Staff;

public interface StorageInt {
    // This class stores/retrieves user objects from the database and stores all staff and student objects

    void loadData();
    boolean saveData();

    Staff authUser(String staffId, String pass);
    Staff addUser(String staffId, String pass);
}
