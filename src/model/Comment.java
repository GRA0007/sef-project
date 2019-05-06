package model;
import model.interfaces.CommentInt;

import java.util.Date;

public class Comment implements CommentInt
{

    private String comment;
    private Staff author;
    private Date date;

    public Comment(String comment, Staff author) {
        this.comment = comment;
        this.author = author;
        this.date = new Date();
    }

    public void setAuthor(Staff author){
        this.author = author;
    }

    public String getComment(){
        return this.comment;
    }

    public Staff getAuthor(){
       return this.author;
    }

    public Date getDate(){
        return this.date;
    }


    @Override
    public String toString() {
        String toString = "";
        toString = String.format("%s\n%-30s%s", toString, "Date:", this.date.toString());
        toString = String.format("%s\n%-30s%s", toString, "Author:", this.author.getName());
        toString = String.format("%s\n%-30s%s", toString, "Comment:", this.comment);

        return toString;
    }
}