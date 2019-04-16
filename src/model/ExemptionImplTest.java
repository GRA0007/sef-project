package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import model.interfaces.Exemption;
import model.interfaces.Staff;
import model.interfaces.Student;



class ExemptionImplTest
{
	Exemption a;
	Exemption b;
	Exemption c;
	Exemption d;
	
	File save;
	
	Student s1 = new StudentImpl("s3127736", "Paul", "Ryan", 
			"51/67 Curby Lane Carlton Vic", "0478534522", "s3127736@student.rmit.edu.au");
	Student s2 = new StudentImpl("s5677359", "Harpreet", "Acosta", 
			"66 Smith Lane Fitzroy Vic", "0499856514", "s5677359@student.rmit.edu.au");
	Student s3 = new StudentImpl("s8897125", "Morales", "Ezekiel", 
			"88 Lynden Street Camberwell Vic", "0478855764", "s8897125@student.rmit.edu.au");
	Student s4 = new StudentImpl("s2156883", "Boyer", "Billie-Jo", 
			"86 Charles Street Collingwood VIC", "0443389756", "s2156883@student.rmit.edu.au");
	
	Staff sf1 =  new StaffImpl("e259604", "Thevathayan","Charles", "City campus Building 15 Level 10 room 12",
			"+61399259604", "charles.thevathayan@rmit.edu.au", "School of Science", "Course Coordinator", 2);
	Staff sf2 =  new StaffImpl("e252879", "Khalil","Ibrahim", "14.11.25",
			"+61399252879", "Ibrahim.khalil@rmit.edu.au ", "School of Science", "Course Coordinator", 2);	
	Staff sf3 =  new StaffImpl("e120905", "Zhang","Xiuzhen", "14.09.05",
			null, "xiuzhen.zhang@rmit.edu.au ", "School of Science", "Course Coordinator", 2);
	Staff sf4 =  new StaffImpl("e259775", "Ryan","Caspar", "14.11.32",
			"+61399259775", "caspar.ryan@rmit.edu.au", "School of Science", "Course Coordinator", 4);
	Staff sf5 =  new StaffImpl("e333333", "Salim","Flora", null,
			null, "flora.salim@rmit.edu.au", "School of Science", "Course Coordinator", 2);
	Staff sf6 = new StaffImpl("e777777", "Balbin","Isaac", "Building 12 Level 9 Room 38",
			null, "isaac.balbin@rmit.edu.au", "School of Science", "Program Manager", 3);

	@BeforeEach
	void setUp() throws Exception
	{
		a = new ExemptionImpl(s1.getID(), sf1.getID(), "ISYS5180", sf1.authorityAccess());
		b = new ExemptionImpl(s2.getID(), sf2.getID(), "ISYS5180", sf2.authorityAccess());
		c = new ExemptionImpl(s3.getID(), sf6.getID(), "ISYS5180", sf6.authorityAccess());
	}

	@AfterEach
	void tearDown() throws Exception
	{
		
	}

	@Test
	void authorityTest() //looks for appropriate exemption
	{
		assertEquals(false, a.isExemptionApproved());	//course coordinator
		assertEquals(false, b.isExemptionApproved());	//course coordinator
		assertEquals(true, c.isExemptionApproved());	//program manager
		
	}
	
	@Test
	void printOutTest() //tests that the comment file is appropriately matched
	{
		a.addComment("This is a test", 3);
		assertEquals(true, a.commentsAttached());	//Comment boolean changed state
		assertEquals("S3127736_Comments.txt", a.getCommentFileName());	//file name is as expected
	}
	
	@Test
	void commentsContainTest() //looks for correct contents of comment printOut
	{
		String temp = "This subject line should match exactly what comes back in";
		b.addComment(temp, 3);
	}
	
	@Test
	void illegalArgumentTest()	//Will throw IllegalArgumentException due to authority access > bounds
	{
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			d = new ExemptionImpl(s4.getID(), sf4.getID(), "ISYS5180", sf4.authorityAccess());
		});
	}
	
}
