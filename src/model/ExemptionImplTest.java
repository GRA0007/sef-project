package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
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
			"+61399259604", "charles.thevathayan@rmit.edu.au", "School of Science", "Course Coordinator", true);
	Staff sf2 =  new StaffImpl("e252879", "Khalil","Ibrahim", "14.11.25",
			"+61399252879", "Ibrahim.khalil@rmit.edu.au ", "School of Science", "Course Coordinator", false);	
	Staff sf3 =  new StaffImpl("e120905", "Zhang","Xiuzhen", "14.09.05",
			null, "xiuzhen.zhang@rmit.edu.au ", "School of Science", "Course Coordinator", true);
	Staff sf4 =  new StaffImpl("e259775", "Ryan","Caspar", "14.11.32",
			"+61399259775", "caspar.ryan@rmit.edu.au", "School of Science", "Course Coordinator", true);
	Staff sf5 =  new StaffImpl("e333333", "Salim","Flora", null,
			null, "flora.salim@rmit.edu.au", "School of Science", "Course Coordinator", true);
	Staff sf6 = new StaffImpl("e777777", "Balbin","Isaac", "Building 12 Level 9 Room 38",
			null, "isaac.balbin@rmit.edu.au", "School of Science", "Program Manager", true);

	@BeforeEach
	void setUp() throws Exception
	{
		a = new ExemptionImpl(s1.getID(), sf1.getID(), "ISYS5180", sf1.authorityAccess());
		b = new ExemptionImpl(s2.getID(), sf2.getID(), "ISYS5180", sf2.authorityAccess());
	}

	@AfterEach
	void tearDown() throws Exception
	{
		
	}

	@Test
	void authorityTest()
	{
		assertEquals(true, a.isExemptionApproved());
		assertEquals(false, b.isExemptionApproved());
	}
	
	@Test
	void printOutTest()
	{
		//a.addComment("This is a test");
		System.out.println(a.readComments());
	}

}
