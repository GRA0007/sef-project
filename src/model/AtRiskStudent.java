package model;

public class AtRiskStudent extends AbstractCategory
{
	private Student student;
	
	private int stageRisk;
	private String reasonForRisk;
	private String adviceGiven;
	
	public AtRiskStudent(Student student, int stageRisk, String reasonForRisk, String adviceGiven)
	{
		this.student = student;
		this.stageRisk = stageRisk;
		this.reasonForRisk = reasonForRisk;
		this.adviceGiven = adviceGiven;
	}

	public void appendAdvice(String comments)
	{
		this.adviceGiven += "\n" + comments;
	}
	
	public int getStageRisk()
	{
		return stageRisk;
	}

	public void setStageRisk(int stageRisk)
	{
		this.stageRisk = stageRisk;
	}

	public String getReasonForRisk()
	{
		return reasonForRisk;
	}

	public String getAdviceGiven()
	{
		return adviceGiven;
	}
	

	@Override
	public String toString()
	{
		String tbc = String.format("Student ID:\t\t%s\nStudent Name:\t\t%s\n", student.getID(), student.getName());
		
		return tbc + "\n" + String.format("Risk Stage:\t\t%s\nReason for being at risk:\n%s\nAdvice:\n%s", 
				this.stageRisk, this.reasonForRisk, this.adviceGiven);
	}

	@Override
	public String getDuration()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
