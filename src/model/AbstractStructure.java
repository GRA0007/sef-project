package model;

import model.interfaces.Comment;
import model.interfaces.Structure;

import java.util.Date;

public abstract class AbstractStructure implements Structure {

    public abstract String toString();

    public abstract String getDuration();

    public void addComment(Comment comment){

    }

    //Loop through all the comments for the structure
    //and return as a string is toString in comment class
    public String getComments(){
       return null;
    }

    public  String getComments(StaffImpl staff){
        return null;
    }
    public  String getComments(Date dateTime){
       return null;
    }

}
