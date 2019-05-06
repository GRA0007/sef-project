package model.interfaces;

import model.Staff;

import java.util.Date;

public interface StructureInt {

    String toString();

    String getDuration();

    //Loop through all the comments for the structure
    //and return as a string is toString in comment class
    String getComments();
    String getComments(Staff staff);
    String getComments(Date dateTime);


}
