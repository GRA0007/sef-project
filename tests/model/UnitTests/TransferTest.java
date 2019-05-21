package model.UnitTests;

import model.Staff;
import model.Transfer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class TransferTest {
    Transfer t1, t2;
    Calendar today = Calendar.getInstance();
    Calendar nextMonth = Calendar.getInstance();
    Staff author = new Staff("e1234","Milroy","da sokk", "", "", "", "", "", 0);

    public static void main(String[] args){

    }

    @Before
    public void setUp() throws Exception {
        nextMonth.add(Calendar.MONTH, 1);

        t1 = new Transfer("ABC123", "DEF456", today.getTime(), false, null, author);
        t2 = new Transfer("ABC123", "DEF456", today.getTime(), true, nextMonth.getTime(), author);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAuthor() {
        assertEquals(t1.getStaff(), author);
        assertEquals(t2.getStaff(), author);
    }

    @Test
    public void testTransferred() {
        assertFalse(t1.isTransferred());
        assertTrue(t2.isTransferred());
    }

    @Test
    public void testPrintOut() {
        System.out.println(t1.toString());
        System.out.println(t2.toString());
    }

    @Test
    public void testDuration() {
        assertEquals(t1.getDuration(), "N/A");
        assertEquals(t2.getDuration(), "1 month");
    }
}
