package model;

import java.time.LocalDate;

public class Transfers extends AbstractCategory
{
	private Student student;
	
	private LocalDate date;
	private String previousCourse;
	private String problemsFaced;
	private String adviceGiven;

	public Transfers(Student student, LocalDate date, String previousCourse, String problemsFaced, String adviceGiven)
	{
		this.student = student;
		this.date = date;
		this.previousCourse = previousCourse;
		this.problemsFaced = problemsFaced;
		this.adviceGiven = adviceGiven;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public String getPreviousCourse()
	{
		return previousCourse;
	}

	public String getProblemsFaced()
	{
		return problemsFaced;
	}

	public String getAdviceGiven()
	{
		return adviceGiven;
	}

	@Override
	public String toString()
	{
		String tbc = String.format("Student ID:\t\t%s\nStudent Name:\t\t%s\n", student.getID(), student.getName());

		
		return tbc + "\n" + String.format("Date:\t\t\t%s\nPromblems Faced by Student:\n%s\n\nAdvice:\n%s", 
				this.date, this.problemsFaced, this.adviceGiven);
	}

	@Override
	public String getDuration()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
