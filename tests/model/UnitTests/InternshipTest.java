package model.UnitTests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Date;

import model.Staff;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.AbstractCategory;
import model.Internship;
import model.Student;

public class InternshipTest
{
	Internship is1;
	Internship is2;
	Internship is3;
	Internship is4;

	Date testStartDate = java.sql.Date.valueOf(LocalDate.of(2019, 11, 02));
	Date testEndDate = java.sql.Date.valueOf(LocalDate.of(2020, 03, 20));

	Staff st1 = new Staff("e5677359", "Forcett", "Julian", "44 Mann Lane Jordonville Vic", "04302843174",
			"julian.forcett@rmit.edu.au", "Technology", "Lecturer", 4);
	Staff st2 = new Staff("e3332223", "Lowes", "Jenny", "32 Lynhurst Drive VIC", "0408222111",
			"Jenny.Lowes@rmit.edu.au", "Science", "Administration", 1);
	Student s2 = new Student("s5677359", "Harpreet", "Acosta", "66 Smith Lane Fitzroy Vic", "0499856514",
			"s5677359@student.rmit.edu.au");
	Student s3 = new Student("s332221", "Jeeves", "Charlie", "22 Whatever Street", "0418888222",
			"user.name@rmit.edu.au");
	Student s4 = new Student("s456998", "Chris", "Powers", "45 Lynhurst Street", "049887651", "s456998@rmit.edu.au");
	Student s5 = new Student("s433398", "Julia", "Charmers", "99 Made This Street", "04988888", "s433398@rmit.edu.au");

	
	@Before
	public void setUp() throws Exception
	{
		is1 = new Internship("Resume Building", st1);
		is2 = new Internship("IBM", java.sql.Date.valueOf(LocalDate.of(2019, 06, 14)), true,
				java.sql.Date.valueOf(LocalDate.of(2019, 11, 20)), "Paul Pearson", st1);
		is3 = new Internship("EY", testStartDate, false, testEndDate, "Ryan King", st1);

		s4.getProgramStructure()
				.addCategory(new Internship("AWS", testStartDate, true, testEndDate, "Paul Pearson", st1));
		s5.getProgramStructure()
		.addCategory(new Internship("Build that resume", st2));

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
		assertEquals(st1.getID() + ": " + new Date().toGMTString().toString(), is3.getCompletedSignature());
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

	@Test(expected = NullPointerException.class)
	public void nullStaffTest()
	{
		new Internship("New Listing", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invaildDateTest()
	{
		new Internship("EY", testEndDate, false, testStartDate, "Ryan King", st1);
	}

	@Test(expected = NullPointerException.class)
	public void nullStaffInstTest()
	{
		new Internship("EY", testStartDate, false, testEndDate, "Ryan King", null);
	}

	@Test
	public void printOutTest()
	{	
	//Print out checks that the class is correctly formatted to program structure
	//	System.out.println(s4.toString()+ "\n" + s4.getProgramStructure());
	//	System.out.println(s5.toString()+ "\n" + s5.getProgramStructure());
		
		assertTrue(s4.getProgramStructure().toString().contains("Internship"));	
	}
	
	@Test
	public void deleteInternshipTest()
	{
		AbstractCategory temp = s4.getProgramStructure().getCategory(0);
		s4.getProgramStructure().deleteCategory(temp);
		assertEquals(s4.getProgramStructure().toString(), "Nothing found");
	}

}
