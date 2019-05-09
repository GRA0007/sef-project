package model.UnitTests;

import model.Comment;
import model.Staff;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AbstractCategoryTest {

    private Comment comment1;
    private Comment comment2;
    private String commentString1  = "This is a dummaz comment to test the bloody testing class";
    private String commentString2  = "Second comment being tested . . .  TESTIINNGG!";

    Staff author = new Staff("e1234","Milroy","da sokk", "", "", "", "", "", false);
    List<Comment> commentList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {

        comment1 = new Comment(commentString1,author);
        comment2 = new Comment(commentString2,author);
    }
    @Test
    public void addComment() {
        commentList.add(comment1);
        commentList.add(comment2);
    }

    @Test
    public void getComments() {
        for (Comment currentComment:
                commentList) {
            assertEquals(currentComment.toString(), comment1.getComment());
        }
    }
}