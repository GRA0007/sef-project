package model;
import model.interfaces.Comment;

import java.util.Date;

public class CommentImpl implements Comment
{

    private int authority;
    private String comment;
    //make staff name string for now
    private String author;

    private Date date ;

    //Instatiate the authority, comment, author, date
    public CommentImpl(String comment, String author, Date date){
        this.comment = comment;
        this.author = author;
        this.date = date;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public int getAuthority(){
        return this.authority;
    }

    public String getComment(){
        return this.comment;
    }

    public String getAuthor(){
       return this.author;
    }

    public Date getDate(){
        return this.date;
    }


    @Override
    public String toString() {

        String actualAuthority = "";
        if(this.getAuthority() == 1) {
            actualAuthority = "Senior Program managers";
        }
        else if (this.getAuthority() == 2) {
            actualAuthority = "Program managers";
        }else{
            actualAuthority = "Staff";
        }
       String toString = "";
       toString = String.format("%s\n%s", toString, "Here's the comment you wanted to access!");

       toString = String.format("%s\n%-30s%s", toString, "Date:", this.date);
       toString = String.format("%s\n%-30s%s", toString, "Author:", this.author);
       toString = String.format("%s\n%-30s%s", toString, "Comment:", this.comment);
       toString = String.format("%s\n%-30s%s", toString, "Allow access to:", actualAuthority);


        return toString;
    }
}