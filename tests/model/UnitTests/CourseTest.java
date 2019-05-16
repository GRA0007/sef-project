package model.UnitTests;

import model.Course;
import model.Staff;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CourseTest {

    private Course course1;
    private Date currentDate = new Date();
    private Date endDate = new Date();

    private Staff coordinator = new Staff("E99999", "Kodz", "Milroy", "", "", "e9999@rmit.edu.au","Comp Sci", "Coordinator", 1);
    private Course prereq = new Course("COSC 2018", "Discrete Mathematics", "Semester 1", coordinator,  currentDate, true, endDate, false);

    private Course[] prereqArray= {prereq};

    public static void main(String[] args){

    }

    @Before
    public void setUp() throws Exception{
        course1 = new Course("COSC 2019", "Algorithms and Analysis","Semester 1", coordinator, prereqArray, currentDate, false, endDate,false);
    }
    @Test
    public void getDuration() {
        assertEquals("N/A", course1.getDuration());
    }

    @Test
    public void getCourseCode() {
        assertEquals("COSC 2019", course1.getCourseCode());
    }

    @Test
    public void getCourseName() {
        assertEquals("Algorithms and Analysis", course1.getCourseName());
    }

    @Test
    public void getExemption() {
        assertEquals(false, course1.getExemption());
    }

    @Test
    public void toStringTest() {
        String toString = "";

        toString = String.format("%s\n%-30s%s", toString, "Course code:", "COSC 2019");
        toString = String.format("%s\n%-30s%s", toString, "Course name:", "Algorithms and Analysis");
        toString = String.format("%s\n%-30s%s", toString, "Course coordinator:", coordinator.getName());
        toString = String.format("%s\n%-30s%s", toString, "Prerequisites:", prereqArray[0].getCourseCode()+":"+ prereqArray[0].getCourseName());
        toString = String.format("%s\n%-30s%s", toString, "Course duration:", "N/A");
        toString = String.format("%s\n%-30s%s", toString, "Semester:", "Semester 1");
        toString = String.format("%s\n%-30s%s", toString, "Status:", "Pending");


        assertEquals(toString, course1.toString());

    }
}