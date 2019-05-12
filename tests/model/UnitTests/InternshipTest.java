package model.UnitTests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Internship;
import model.Student;

public class InternshipTest
{
	Internship is1;
	Internship is2;
	
	Student s2 = new Student("s5677359", "Harpreet", "Acosta",
			"66 Smith Lane Fitzroy Vic", "0499856514", "s5677359@student.rmit.edu.au");

	@Before
	public void setUp() throws Exception
	{
		is1 = new Internship(s2,"Computer Science","Third Year","Resume Building");
		
		is2 = new Internship(s2,"IBM", LocalDate.of(2019, 06, 14), LocalDate.of(2019, 11, 20), "Paul Pearson");
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
