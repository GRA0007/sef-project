package model.UnitTests;

import model.Comment;
import model.Staff;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class CommentTest {

    Comment comment1;
    Date currentDate = new Date( );
    int authority  = 1;
    String comment  = "This is a dummaz comment to test the bloody testing class";
    Staff author = new Staff("e1234","Milroy","da sokk", "", "", "", "", "", 0);

    public static void main(String[] args){

    }

    @Before
    public void setUp() throws Exception {

        SimpleDateFormat ft =
                new SimpleDateFormat ("yyyy.MM.dd");

        comment1 = new Comment(comment,author);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void editAuthor() {
        Staff notMilroy = new Staff("e1234","Not","Milroy", "", "", "", "", "", 0);
        comment1.setAuthor(notMilroy);
        assertEquals(notMilroy, comment1.getAuthor());
        System.out.println("\nNew auth name: " + comment1.getAuthor());
    }

    @Test
    public void getAuthor() {
        assertEquals(author, comment1.getAuthor());
    }

    @Test
    public void getComment() {
        assertEquals(comment, comment1.getComment());
    }

    @Test
    public void checkToString() {
        System.out.println(comment1.toString());
    }


}