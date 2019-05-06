package model;

public class Substitutions extends AbstractCategory
{
	private Student student;
	
	private String originalCourse;
	private String substituteCourse;
	private String reasonForSubstitution;
	
	public Substitutions(Student student, String originalCourse, String substituteCourse, String reasonForSubstitution)
	{
		this.student = student;
		this.originalCourse = originalCourse;
		this.substituteCourse = substituteCourse;
		this.reasonForSubstitution = reasonForSubstitution + "\n" + new AppendTimestamp().getTimestamp();
	}
	
	public String getOriginalCourse()
	{
		return originalCourse;
	}


	public void setOriginalCourse(String originalCourse)
	{
		this.originalCourse = originalCourse;
	}


	public String getSubstituteCourse()
	{
		return substituteCourse;
	}


	public void setSubstituteCourse(String substituteCourse)
	{
		this.substituteCourse = substituteCourse;
	}


	public String getReasonForSubstitution()
	{
		return reasonForSubstitution;
	}
	
	public void appendToReason(String additionalComment)
	{
		this.reasonForSubstitution += ("\n" + additionalComment);
	}


	@Override
	public String toString()
	{
		String tbc = String.format("Student ID:\t\t%s\nStudent Name:\t\t%s\n", student.getID(), student.getName());

		
		return tbc + String.format("Origianl Course:\t%s\nSubstituted Course:\t%s\n"
				+ "Reason for Substitution:\n%s", this.originalCourse, this.substituteCourse, this.reasonForSubstitution);
	}

	@Override
	public String getDuration()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
