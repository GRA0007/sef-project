package model.interfaces;

import model.Staff;
import model.Student;

public interface StorageInt {
    // This class stores/retrieves user objects from the database and stores all staff and student objects

    void loadData();
    boolean saveData();

    Staff authUser(String staffId, String pass);
    Staff addUser(String staffId, String given, String family, String address,
                  String phone, String department, String jobTitle, boolean authority, String pass);

    Student getStudent(String id);
    Student addStudent(String id, String given, String family, String address, String phone);
}
