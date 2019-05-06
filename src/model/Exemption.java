package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class Exemption extends AbstractStructure implements model.interfaces.Exemption
{
	private boolean exemptionDecision; //has staff member approved exemption, can be decided post creation
	private Staff staff;
	
	private String dateRequested; //timestamp of creation
	private String exemptionRequest; //what course is requested for exemption
	private LocalDate challengeExamDate; //proposed new date for retake exam 
	private String decision;
	

	private File save;

	public Exemption(Student student, Staff staff, String exemptionRequest, LocalDate challengeExamDate, String decision)
	{
		super(student);
		this.staff = staff;
		
		this.dateRequested = new AppendTimestamp().getTimestamp().toString();
		this.exemptionRequest = exemptionRequest;
		this.challengeExamDate = challengeExamDate;
		this.decision = decision;

	}

	public String getDecision()
	{
		return decision;
	}

	@Override
	public LocalDate getChallengeExamDate()
	{
		return challengeExamDate;
	}

	@Override
	public void setChallengeExamDate(LocalDate challengeExamDate)
	{
		this.challengeExamDate = challengeExamDate;
	}

	@Override
	public String getExemptionRequest()
	{
		return exemptionRequest;
	}

	@Override
	public boolean isExemptionApproved()
	{
		return exemptionDecision;
	}

	@Override
	public void setApprovedExemption(boolean approvedExemption)
	{
		this.exemptionDecision = approvedExemption;
	}

	public String getDateRequested()
	{
		return dateRequested;
	}

	@Override
	public String getDuration()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "\n" + String.format("Date:\t\t\t%s\nExemption Sought:\t%s\nChallenge Exam Date\t%s\n"
				+ "Decision Made:\t\t%s\nReason:\n%s", this.dateRequested, this.exemptionRequest, 
				this.challengeExamDate,	this.exemptionDecision ? "Approved" : "Denied", this.decision);
	}
	
	// create comment class, for further separation
		@Override
		public void addComment(String comment)
		{
			PrintWriter pr = null;
			save = new File(student.getID() + "_" + "Comments.txt");

			try
			{
				pr = new PrintWriter(save);

			} catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}

			// This allows for comments to be tagged with appending staff member, and the
			// date associated
			pr.println(comment);
			pr.println("Staff Member: " + staff.getID());
			pr.println(new AppendTimestamp().getTimestamp());

			pr.close();
		}

		@Override
		public String readComments()
		{
			String readInComment;
			String finalString = "";

			try
			{
				FileReader txt = new FileReader(save);
				BufferedReader br = new BufferedReader(txt);

				while ((readInComment = br.readLine()) != null)
				{
					finalString += readInComment;
					finalString += "\n";
				}

				br.close();
				return finalString;

			} catch (FileNotFoundException e)
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			return null;
		}

}
