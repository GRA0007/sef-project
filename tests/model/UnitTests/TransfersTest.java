package model.UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Student;
import model.Transfers;

class TransfersTest
{
	Transfers tt1;
	
	Student s3 = new Student("s8897125", "Morales", "Ezekiel",
			"88 Lynden Street Camberwell Vic", "0478855764", "s8897125@student.rmit.edu.au");

	@BeforeEach
	void setUp() throws Exception
	{
		tt1 = new Transfers(s3, LocalDate.of(2019, 11, 20), "Discrete Structure", "Not a fan", "Move on");
		
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void test()
	{
		System.out.println(tt1.toString());
	}

}
