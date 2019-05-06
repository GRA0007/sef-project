package model;

public class StudentFeedback extends AbstractCategory
{
	private Student student;
	
	private String program;
	private String problemsFaced;
	private String actionTaken;

	public StudentFeedback(Student student, String program, String problemsFaced, String actionTaken)
	{
		this.student = student;
		this.program = program;
		this.problemsFaced = problemsFaced;
		this.actionTaken = actionTaken;
	}

	public String getProgram()
	{
		return program;
	}

	public String getProblemsFaced()
	{
		return problemsFaced;
	}

	public String getActionTaken()
	{
		return actionTaken;
	}
	
	@Override
	public String toString()
	{
		String tbc = String.format("Student ID:\t\t%s\nStudent Name:\t\t%s\n", student.getID(), student.getName());

		
		return tbc + "\n" + String.format("Program:\t\t%s\nProblems Faced by Student:\n%s\nAction Taken:"
				+ "\t\t%s", this.program, this.problemsFaced, this.actionTaken != null ? this.actionTaken : "None");
	}

	@Override
	public String getDuration()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
