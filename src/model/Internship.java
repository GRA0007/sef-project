package model;

import java.time.LocalDate;

public class Internship extends AbstractStructure
{
	private String program; 
	private String studentProgress; 
	private String advice;
	
	private String company; 
	private LocalDate startDate; 
	private LocalDate endDate; 
	private String contactPerson;
	
	private boolean gainedInternship = false;
   
	public Internship(Student student, String program, String studentProgress, String advice)
	{
		super(student);
		this.program = program;
		this.studentProgress = studentProgress;
		this.advice = advice;
	}
	
	public Internship(Student student, String company, LocalDate startDate, LocalDate endDate, String contactPerson)
	{
		super(student);
		this.company = company;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contactPerson = contactPerson;
		
		this.gainedInternship = true;
	}
	
	public void setGainedInternship(boolean set)
	{
		this.gainedInternship = set;
	}
	
	public boolean getGainedInternship()
	{
		return this.gainedInternship;
	}

    public LocalDate getStartDate()
	{
		return startDate;
	}

	public void setStartDate(LocalDate startDate)
	{
		this.startDate = startDate;
	}

	public LocalDate getEndDate()
	{
		return endDate;
	}

	public void setEndDate(LocalDate endDate)
	{
		this.endDate = endDate;
	}

	public String getContactPerson()
	{
		return contactPerson;
	}

	public void setContactPerson(String contactPerson)
	{
		this.contactPerson = contactPerson;
	}

	public String getCompany()
	{
		return company;
	}

	public String getStudentProgress()
	{
		return studentProgress;
	}

	public void setStudentProgress(String studentProgress)
	{
		this.studentProgress = studentProgress;
	}

	public String getAdvice()
	{
		return advice;
	}

	public void setAdvice(String advice)
	{
		this.advice = advice;
	}

	public String getProgram()
	{
		return program;
	}

	@Override
    public String getDuration() {
        return null;
    }
    
    @Override
    public String toString() 
    {
  
		if (!gainedInternship)
		return super.toString() + String.format("Phone:\t\t\t%s\nProgram:\t\t%s\nStudent Progress:\t%s\nAdvice:"
				+ "\t\t\t%s\nDate:\t\t\t%s", student.getPhone(), this.program, this.studentProgress, this.advice, 
				getTimestamp());
		
		return super.toString() + String.format("Company:\t\t%s\nStart Date:\t\t%s\nEnd Date;\t\t%s\nContact Person\t\t%s\n"
				, this.company, this.startDate, this.endDate, this.contactPerson);
    }

}
