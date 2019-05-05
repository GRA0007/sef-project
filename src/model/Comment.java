package model;
import model.interfaces.CommentInt;

import java.util.Date;

public class Comment implements CommentInt
{

    private String comment;
    private Staff author;
    private Date date;

    // Instantiate the comment, author, date
    public Comment(String comment, Staff author) {
        this.comment = comment;
        this.author = author;
        this.date = new Date();
    }

    public Comment(String comment, Staff author, Date date) {
        this.comment = comment;
        this.author = author;
        this.date = date;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public void setAuthor(Staff author){
        this.author = author;
    }

    public void setDate(Date date){
        this.date = date;
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