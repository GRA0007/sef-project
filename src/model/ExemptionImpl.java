package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import model.interfaces.Exemption;
import model.interfaces.Staff;
import model.interfaces.Student;

public class ExemptionImpl implements Exemption
{
	private String studentID;
	private String staffID;
	private String courseCode;
	private boolean approvedExemption;
	private boolean commentsExist;	//allows user awareness if any comments have been attached
	
	private Date date;
	private long time;
	private Timestamp timeStamp;
	
	private File save;
	
	public ExemptionImpl(String studentID, String staffID, String courseCode, boolean approvedExemption)
	{
		this.studentID = studentID;
		this.staffID = staffID;
		this.courseCode = courseCode;
		this.approvedExemption = approvedExemption;

	}
	
	//create comment class, for further separation
	public void addComment(String comments) 
	{				
		PrintWriter pr = null;
		save = new File(this.studentID+"_"+"Comments.txt");
		
		date = new Date();
		time = date.getTime();
		timeStamp = new Timestamp(time);
		
		try {
			pr = new PrintWriter(save);
			
			} catch (FileNotFoundException e) 
				{
				e.printStackTrace();
				} 

			//This allows for comments to be tagged with appending staff member, and the date associated
			pr.println(comments);
			pr.println("Staff Member: " + this.staffID);
			pr.println(timeStamp);
								
			pr.close();	
			
			this.commentsExist = true;
			
			
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
			}
			catch (IOException e)
			{
			e.printStackTrace();
			}
		return null; 
	}
	
	@Override
	public boolean isExemptionApproved()
	{
		return approvedExemption;
	}

	@Override
	public void setApprovedExemption(boolean approvedExemption)
	{
		this.approvedExemption = approvedExemption;
	}
	
	@Override
	public boolean commentsAttached()
	{
		return this.commentsExist;
	}
	
	@Override
	public String exemptionDetails()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getCommentFileName()
	{
		return this.save.getName();
	}

/*	@Override
	public String toString() 
	{
		return String.format("Student Number: \t%s\nName: \t\t\t%s %s\nSupervisor: \t\t%s\nCourse: \t\t%s\n"
				+ "Exemption status: \t%s\nComments: \t\t%s", 
				this.student.getStudentID(), this.student.getGivenName(), this.student.getFamName(), 
				this.staff.getName(), this.courseCode, this.approvedExemption ? "Approved" : "Not Approved",
						(this.comments != null ) ? "Comments Available":"No Comments");
	}*/
}
