package model;

import java.time.LocalDate;
import java.util.Date;


public class Internship extends AbstractCategory
{
	private String company;
	private String contactPerson;
	
	private boolean gainedInternship = false;

	public Internship(String advice, Staff staff)
    {
        // They don't have an internship yet, add advice given as a comment
        this.addComment(new Comment(advice, staff));

        this.staff = staff;
        gainedInternship = false;
    }
	public Internship(String company, Date startDate, boolean completed, Date endDate, String contactPerson, Staff staff)
	{
		this.company = company;
		this.startDate = startDate;
		this.isCompleted = completed;
		this.endDate = endDate;
		this.contactPerson = contactPerson;
		this.staff = staff;
		
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

    public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
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
    
    @Override
    public String toString() 
    {
  
		if (!gainedInternship)
		return "\nGained internship:\t\tNo\nAdvice given:\t\tSee comments";
		
		return String.format("\nCompany:\t\t%s\nStart Date:\t\t%s\nEnd Date;\t\t%s\nContact Person\t\t%s\n"
				, this.company, this.startDate, this.endDate, this.contactPerson);
    }

}
