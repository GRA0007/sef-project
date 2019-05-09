package model;

import model.interfaces.CategoryInt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractCategory implements CategoryInt {

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
}
