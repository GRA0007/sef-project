package model.UnitTests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.AbstractCategory;
import model.Staff;
import model.Student;
import model.StudentFeedback;

public class StudentFeedbackTest
{
	StudentFeedback sf1;
	StudentFeedback sf2;
	StudentFeedback sf3;
	StudentFeedback sf4;
	
	Date testStartDate = java.sql.Date.valueOf(LocalDate.of(2019, 11, 02));
	Date testEndDate = java.sql.Date.valueOf(LocalDate.of(2020, 03, 20));

	Staff st1 = new Staff("e5677359", "Forcett", "Julian",
			"44 Mann Lane Jordonville Vic", "04302843174", "julian.forcett@rmit.edu.au",
			"Technology", "Lecturer", 4);
	Staff st2 = new Staff("e3332223", "Lowes", "Jenny",
			"32 Lynhurst Drive VIC", "0408222111", "Jenny.Lowes@rmit.edu.au",
			"Science", "Administration", 1);
	Student s2 = new Student("s5677359", "Harpreet", "Acosta",
			"66 Smith Lane Fitzroy Vic", "0499856514", "s5677359@student.rmit.edu.au");
	Student s3 = new Student("s332221", "Jeeves", "Charlie", "22 Whatever Street", "0418888222", "user.name@rmit.edu.au");

	
	@Before
	public void setUp() throws Exception
	{
		s2.getProgramStructure().addCategory(new StudentFeedback(
				st1 ,"Dog ate homework","Nothing, this was a poor excuse"));
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void printTest()
	{
		//Checking to see that the format works with superclass toString()
		//System.out.println(s2.getProgramStructure());
	}
	
	@Test
	public void printOutTest()
	{	
	//Print out checks that the class is correctly formatted to program structure
	//	System.out.println(s4.toString()+ "\n" + s4.getProgramStructure());
	//	System.out.println(s5.toString()+ "\n" + s5.getProgramStructure());
		
		assertTrue(s2.getProgramStructure().toString().contains("StudentFeedback"));	
	}
	
	@Test (expected = NullPointerException.class)
	public void staffExceptionThrownTest()
	{
		s3.getProgramStructure().addCategory(new StudentFeedback(null, "Who dis", "I dont want to be known"));
	}
	
	@Test (expected = NullPointerException.class)
	public void emptyValuesTest()
	{
		s3.getProgramStructure().addCategory(new StudentFeedback(st1, null, null));
	}
	
	@Test
	public void deleteFeedbackTest()
	{
		AbstractCategory temp = s2.getProgramStructure().getCategory(0);
		s2.getProgramStructure().deleteCategory(temp);
		assertEquals(s2.getProgramStructure().toString(), "Nothing found");
	}
	
	@Test
	public void multipleCommentsAttachedTest()
	{
		s2.getProgramStructure().addCategory(new StudentFeedback(
				st1 ,"Hit head on bathroom sink","Sent to medical school"));
		s2.getProgramStructure().addCategory(new StudentFeedback(
				st2 ,"Disagreed with Tutor over proper indentation","Set a debate class"));
		
		//System.out.println(s2.getProgramStructure());
		
		assertTrue(s2.getProgramStructure().toString().contains("(3)"));
		assertFalse(s2.getProgramStructure().toString().contains("(4)"));
	}

}
