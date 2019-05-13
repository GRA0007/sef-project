package model.interfaces;

import model.Staff;

import java.util.Date;

public interface CategoryInt {

    String toString();

    String getDuration();

    Staff getStaff();

    //Loop through all the comments for the structure
    //and return as a string is toString in comment class
    String getComments();


}
