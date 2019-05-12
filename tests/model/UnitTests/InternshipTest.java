package model.UnitTests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Date;

import model.Staff;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Internship;
import model.Student;

public class InternshipTest
{
	Internship is1;
	Internship is2;

	Staff s1 = new Staff("s5677359", "Forcett", "Julian",
			"44 Mann Lane Jordonville Vic", "04302843174", "julian.forcett@rmit.edu.au",
			"Technology", "Lecturer", 4);
	Student s2 = new Student("s5677359", "Harpreet", "Acosta",
			"66 Smith Lane Fitzroy Vic", "0499856514", "s5677359@student.rmit.edu.au");

	@Before
	public void setUp() throws Exception
	{
		is1 = new Internship("Resume Building", s1);
		
		is2 = new Internship("IBM", java.sql.Date.valueOf(LocalDate.of(2019, 06, 14)), true, java.sql.Date.valueOf(LocalDate.of(2019, 11, 20)), "Paul Pearson", s1);
	}	

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void printOutTest()
	{
		System.out.println(is1.toString());
		System.out.println();
		System.out.println(is2.toString());
		
	}

}
