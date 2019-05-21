package model;

import java.util.Date;

public class Internship extends AbstractCategory
{
	private String company;
	private String contactPerson;
	private String completedSignature; // Staff member who authorised completion

	private boolean gainedInternship = false;

	public Internship(String advice, Staff staff) throws NullPointerException
	{
		if (staff == null)
			throw new NullPointerException("Staff must be included");
		// They don't have an internship yet, add advice given as a comment
		if (advice != null) {
			this.addComment(new Comment(advice, staff));
		}

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
		this.isCompleted = intershipStatus;
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

	public boolean getInternshipStatus()
	{
		return this.isCompleted;
	}

	@SuppressWarnings("deprecation")
	public void setInternshipCompleted(Staff staff)
	{
		this.isCompleted = true;
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
    public String toString() 
    {
		if (!gainedInternship)
			return String.format("\n%s\t%s\n%s\t\t%s", "Internship Status: ",
					this.isCompleted ? "Completed" : "Active", "Advice Given: ", "See comments");

		return String.format("\nCompany:\t\t%s\nStart Date:\t\t%s\nEnd Date;\t\t%s\nContact Person\t\t%s\n",
				this.company, this.startDate, this.endDate, this.contactPerson);
	}

}
