package model;

import java.time.LocalDate;

public class Transfers extends AbstractStructure
{
	private LocalDate date;
	private String previousCourse;
	private String problemsFaced;
	private String adviceGiven;

	public Transfers(Student student, LocalDate date, String previousCourse, String problemsFaced, String adviceGiven)
	{
		super(student);
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

	public Transfers(Student student)
	{
		super(student);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString()
	{
		return super.toString() + "\n" + String.format("Date:\t\t\t%s\nPromblems Faced by Student:\n%s\n\nAdvice:\n%s", 
				this.date, this.problemsFaced, this.adviceGiven);
	}

	@Override
	public String getDuration()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
