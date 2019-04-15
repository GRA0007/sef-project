package model.interfaces;

public interface Exemption 
{
	
	void addComment(String comments);
	
	String readComments();
	
	boolean isExemptionApproved();

	void setApprovedExemption(boolean approvedExemption);
	
	String exemptionDetails();
	
	@Override
	String toString();
}
