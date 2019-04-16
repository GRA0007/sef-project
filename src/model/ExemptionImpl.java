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
	
	public ExemptionImpl(String studentID, String staffID, String courseCode, int authority)
	{
		if(authority < 0 || authority > 3) {throw new IllegalArgumentException();}
		
		this.studentID = studentID;
		this.staffID = staffID;
		this.courseCode = courseCode;
		this.approvedExemption = setApprovedExemption(authority);

	}
	
	//these comments only refer to specifics involving description regarding the approval of exemption
	public void addComment(String comments, int authority) 
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

			this.commentsExist = true;
		
			//This allows for comments to be tagged with appending staff member, and the date associated
			pr.println(comments);
			pr.println(toString());
			pr.println(timeStamp);
								
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
	public boolean setApprovedExemption(int authority)
	{
		if(authority == 3) {
			return (this.approvedExemption = true);
		}
		else return (this.approvedExemption = false);
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

	@Override
	public String toString() 
	{
		return String.format("Student Number: \t%s\nSupervisor: \t\t%s\nCourse: \t\t\t%s\n"
				+ "Exemption status: \t%s\nComments: \t\t\t%s", 
				this.studentID, this.staffID, this.courseCode, this.approvedExemption ? "Approved" : "Not Approved",
						this.commentsExist ? "Comments Available":"No Comments");
	}
}
