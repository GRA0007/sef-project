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
    private Course prereq = new Course("COSC 2018", "Discrete Mathematics", coordinator,  currentDate, true, endDate, false);

    private Course[] prereqArray= {prereq};

    public static void main(String[] args){

    }

    @Before
    public void setUp() throws Exception{
        course1 = new Course("COSC 2019", "Algorithms and Analysis",coordinator, prereqArray, currentDate, false, endDate,false);
    }
    @Test
    public void getDuration() {
        assertEquals("0 months", course1.getDuration());
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
    public void getSemester(){
        assertEquals("Semester_1_2019", course1.getSemester());

    }

    @Test
    public void getPrerequisites() {
        assertEquals(String.format("%-30s%s","Prerequisites:",prereqArray[0].getCourseCode()+":"+ prereqArray[0].getCourseName()), course1.getPrerequisites());
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
        toString = String.format("%s\n%-30s%s", toString, "Course duration:", "0 months");
        toString = String.format("%s\n%-30s%s", toString, "Semester:", "Semester_1_2019");
        toString = String.format("%s\n%-30s%s", toString, "Status:", "Pending");


        assertEquals(toString, course1.toString());

    }
}