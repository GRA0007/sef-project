package model.UnitTests;

import java.io.File;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Staff;
import model.Student;
import model.Exemption;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ExemptionTest
{
	Exemption a;
	Exemption b;
	Exemption c;
	Exemption d;
	
	File save;
	
	Student s1 = new Student("s3127736", "Paul", "Ryan",
			"51/67 Curby Lane Carlton Vic", "0478534522", "s3127736@student.rmit.edu.au");
	Student s2 = new Student("s5677359", "Harpreet", "Acosta",
			"66 Smith Lane Fitzroy Vic", "0499856514", "s5677359@student.rmit.edu.au");
	Student s3 = new Student("s8897125", "Morales", "Ezekiel",
			"88 Lynden Street Camberwell Vic", "0478855764", "s8897125@student.rmit.edu.au");
	Student s4 = new Student("s2156883", "Boyer", "Billie-Jo",
			"86 Charles Street Collingwood VIC", "0443389756", "s2156883@student.rmit.edu.au");
	

	Staff sf1 =  new Staff("e259604", "Thevathayan","Charles", "City campus Building 15 Level 10 room 12",
			"+61399259604", "charles.thevathayan@rmit.edu.au", "School of Science", "Course Coordinator", true);
	Staff sf2 =  new Staff("e252879", "Khalil","Ibrahim", "14.11.25",
			"+61399252879", "Ibrahim.khalil@rmit.edu.au ", "School of Science", "Course Coordinator", false);	
	Staff sf3 =  new Staff("e120905", "Zhang","Xiuzhen", "14.09.05",
			null, "xiuzhen.zhang@rmit.edu.au ", "School of Science", "Course Coordinator", true);
	Staff sf4 =  new Staff("e259775", "Ryan","Caspar", "14.11.32",
			"+61399259775", "caspar.ryan@rmit.edu.au", "School of Science", "Course Coordinator", true);
	Staff sf5 =  new Staff("e333333", "Salim","Flora", null,
			null, "flora.salim@rmit.edu.au", "School of Science", "Course Coordinator", true);
	Staff sf6 = new Staff("e777777", "Balbin","Isaac", "Building 12 Level 9 Room 38",
			null, "isaac.balbin@rmit.edu.au", "School of Science", "Program Manager", true);


	@BeforeEach
	void setUp() throws Exception
	{
		a = new Exemption(s1, sf1, "Redo Progamming Exam", LocalDate.of(2019, 10, 27), "Not Yet Approved");
		b = new Exemption(s2, sf2, "Drop Security", LocalDate.of(2019, 05, 03), "Approved");

	}

	@AfterEach
	void tearDown() throws Exception
	{
		
	}

	@Test
	void authorityTest() //looks for appropriate exemption
	{
		assertEquals(true, a.isExemptionApproved());
		assertEquals(false, b.isExemptionApproved());
	}
	
	@Test
	void printOutTest() //tests that the comment file is appropriately matched
	{
		a.addComment("This is a test");
		System.out.println(a.toString());
		
	}
	
	@Test
	void commentsContainTest() //looks for correct contents of comment printOut
	{
		String temp = "This subject line should match exactly what comes back in";
		b.addComment(temp);

		//a.addComment("This is a test");
		System.out.println(a.readComments());

	}

}
