package model;

public class Student extends AbstractUser
{
	private ProgramStructure structure;
	private int progress;
	private int riskLevel;
	private String riskReasonAndAdvice;

	Student(String userID, String famName, String givenName, String address,
				   String phoneNo, String email) {
		super(userID, famName, givenName, address, phoneNo, email);
		structure = new ProgramStructure();
	}

	public ProgramStructure getProgramStructure() {
		return structure;
	}

	public void setInternshipProgress(int progress){
		this.progress = progress;
	}

	public int getProgress(){
		return progress;
	}

	public void setRiskLevel(int riskLevel){
		this.riskLevel = riskLevel;
	}

	public int getRiskLevel(){
		return this.riskLevel;
	}

	public void setRiskReasonAndAdvice(String riskReasonAndAdvice){
		this.riskReasonAndAdvice = riskReasonAndAdvice;
	}

	public String getRiskReasonAndAdvice(){
		return this.riskReasonAndAdvice;
	}
    public void sendCommentEmail(Comment comment) {
		System.out.println("Sending email...");
    }
}
