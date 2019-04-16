package model.UnitTests;

import model.CommentImpl;
import model.StaffImpl;
import model.interfaces.Comment;
import model.interfaces.Staff;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static org.junit.Assert.*;

public class CommentImplTest {

    CommentImpl comment1;
    Date currentDate = new Date( );
    int authority  = 1;
    String comment  = "This is a dummaz comment to test the bloody testing class";
    String author = "Milroy da sokk";

    public static void main(String[] args){
    }
    @Before
    public void setUp() throws Exception {

        SimpleDateFormat ft =
                new SimpleDateFormat ("yyyy.MM.dd");

        comment1 = new CommentImpl(authority ,comment,author, currentDate);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void editAuthor() {

        String authName = "Not milroy";
        comment1.setAuthor(authName);
        assertEquals(authName, comment1.getAuthor());
    }

    @Test
    public void getAuthor() {
        assertEquals(author, comment1.getAuthor());
    }

    @Test
    public void getAuthority() {
        assertEquals(authority, comment1.getAuthority());
    }

    @Test
    public void getComment() {
        assertEquals(comment, comment1.getComment());
    }

    @Test
    public void getDate() {
        assertEquals(currentDate, comment1.getDate());
    }

    @Test
    public void checkToString() {
        System.out.println(comment1.toString());
    }


}