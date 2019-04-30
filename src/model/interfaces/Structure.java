package model.interfaces;

import model.StaffImpl;

import java.util.Date;

public interface Structure {

    String toString();

    String getDuration();

    void addComment(Comment comment);

    //Loop through all the comments for the structure
    //and return as a string is toString in comment class
    String getComments();
    String getComments(StaffImpl staff);
    String getComments(Date dateTime);


}
