package model;

import java.util.Date;

public class Internship extends AbstractCategory
{
	private String company;
	private Date startDate;
	private boolean intershipStatus;
	private Date endDate;
	private String contactPerson;
	private String completedSignature; // Staff member who authorised completion

	private boolean gainedInternship = false;

	public Internship(String advice, Staff staff) throws NullPointerException
	{
		if (staff == null)
			throw new NullPointerException("Staff must be included");
		// They don't have an internship yet, add advice given as a comment
		this.addComment(new Comment("Advice Given; " + advice, staff));

		this.staff = staff;
		gainedInternship = false;
	}

	public Internship(String company, Date startDate, boolean intershipStatus, Date endDate, String contactPerson,
			Staff staff) throws IllegalArgumentException, NullPointerException
	{
		if (startDate.compareTo(endDate) >= 0)
			throw new IllegalArgumentException("Please check your input dates");

		if (staff == null)
			throw new NullPointerException("Staff must be included");

		this.company = company;
		this.startDate = startDate;
		this.intershipStatus = intershipStatus;
		this.endDate = endDate;
		this.contactPerson = contactPerson;
		this.staff = staff;

		this.gainedInternship = true;
	}

	public String getAdvice()
	{
		return this.getComments();
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

	public boolean getInternshipStatus()
	{
		return this.intershipStatus;
	}

	@SuppressWarnings("deprecation")
	public void setInternshipCompleted(Staff staff)
	{
		this.intershipStatus = true;
		this.completedSignature = staff.getID() + ": " + new Date().toGMTString().toString();
	}

	public String getCompletedSignature()
	{
		return this.completedSignature;
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
	public String getDuration()
	{
		return null;
	}

	@Override
	public String toString()
	{

		if (!gainedInternship)
			return String.format("\n%-30s%s\n%s", "Internship Status: ",
					this.intershipStatus ? "Completed" : "Active", getComments());

		return String.format("\n%-30s%s\n%-30s%s\n%-30s%s\n%-30s%s",
				"Company:", this.company, "Start Date:", this.startDate, 
				"End Date:", this.endDate, "Contact Person:", this.contactPerson);
	}

}
