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
	private String comments;
	
	private Date date;
	private long time;
	private Timestamp timeStamp;
	
	private File save = new File(this.studentID+"_"+"Comments.txt");
	
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
		
		date = new Date();
		time = date.getTime();
		timeStamp = new Timestamp(time);
		
		try {
			pr = new PrintWriter(save);
			
			} catch (FileNotFoundException e) 
				{
				e.printStackTrace();
				} 

			pr.print(comments);

			pr.println(timeStamp);
								
			pr.close();	
	}
	
	@Override
	public void readComments()
	{
		String readInComment;
		
		try
		{
			FileReader txt = new FileReader(save);
			BufferedReader br = new BufferedReader(txt);
	
			while ((readInComment = br.readLine()) != null) 
				    System.out.println(readInComment);
			
			br.close();
			
		} catch (FileNotFoundException e)
			{
			e.printStackTrace();
			}
			catch (IOException e)
			{
			e.printStackTrace();
			} 	
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
	public String exemptionDetails()
	{
		// TODO Auto-generated method stub
		return null;
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
