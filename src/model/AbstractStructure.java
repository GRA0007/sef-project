package model;

import model.interfaces.StructureInt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractStructure implements StructureInt {

    private List<Comment> commentList = new ArrayList<>();

    public abstract String toString();

    public abstract String getDuration();

    public void addComment(Comment comment){

        commentList.add(comment);
    }

    public String getComments(){

        String commentListString = "";

        for (Comment currentComment:
             commentList) {
            commentListString += currentComment.toString() + "\n";
        }

        return commentListString;
    }

    public  String getComments(Staff staff){
        return null;
    }
    public  String getComments(Date dateTime){
       return null;
    }

}
