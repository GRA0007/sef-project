package model;

public class StudentFeedback extends AbstractCategory
{
	private String problemFaced;

	public StudentFeedback(Staff staff, String problemFaced, String actionTaken) throws NullPointerException
	{
		if (staff == null || problemFaced == null)
			throw new NullPointerException(staff == null ? "Staff must be included" : "A problem must be listed");

		this.problemFaced = problemFaced;
		this.addComment(new Comment("Action taken; " + actionTaken, staff));
	}

	public String getProblemsFaced()
	{
		return problemFaced;
	}

	public String getActionTaken()
	{
		return this.getComments();
	}

	@Override
	public String toString()
	{
		return String.format("\n%-30s%s\n%s", "Problems faced by student:", getProblemsFaced(), getActionTaken());
	}

	@Override
	public String getDuration()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
