package model.UnitTests;

import model.Internship;
import model.Staff;
import model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class InternshipTest
{
	Internship is1;
	Internship is2;
	Internship is3;
	Internship is4;
	
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
		is1 = new Internship("Resume Building", st1);	
		is2 = new Internship("IBM", java.sql.Date.valueOf(LocalDate.of(2019, 06, 14)), true, java.sql.Date.valueOf(LocalDate.of(2019, 11, 20)), "Paul Pearson", st1);
		is3 = new Internship("EY", testStartDate, false, testEndDate, "Ryan King", st1);
	}	

	@After
	public void tearDown() throws Exception
	{
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void signatureStringTest()
	{
		is3.setInternshipCompleted(st1);
		assertEquals(st1.getID()+ ": " + new Date().toGMTString().toString(), is3.getCompletedSignature());
	}
	
	@Test
	public void checkIncompleteTest()
	{
		assertEquals(false, is3.getInternshipStatus());
		is3.setInternshipCompleted(st1);
	}
	
	@Test
	public void checkCompleteTest()
	{
		is3.setInternshipCompleted(st1);
		assertEquals(true, is3.getInternshipStatus());
	}
	
	@Test (expected = NullPointerException.class)
	public void nullStaffTest()
	{
		new Internship("New Listing", null);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void invaildDateTest()
	{
		new Internship("EY", testEndDate, false, testStartDate, "Ryan King", st1);
	}
	
	@Test (expected = NullPointerException.class)
	public void nullStaffInstTest()
	{
		new Internship("EY", testStartDate, false, testEndDate, "Ryan King", null);
	}
	
}
