package model;

public class StudentFeedback extends AbstractStructure
{
	private String program;
	private String problemsFaced;
	private String actionTaken;

	public StudentFeedback(Student student, String program, String problemsFaced, String actionTaken)
	{
		super(student);
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
		return super.toString() + "\n" + String.format("Program:\t\t%s\nProblems Faced by Student:\n%s\nAction Taken:"
				+ "\t\t%s", this.program, this.problemsFaced, this.actionTaken != null ? this.actionTaken : "None");
	}

	@Override
	public String getDuration()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
