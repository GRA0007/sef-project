package model.interfaces;

public interface Exemption 
{
	/*
	 * Variables
	 *
	 * List<Comment> comments
	 */
	
	void addComment(String comment, int authority);
	
	String readComments();
	
	boolean isExemptionApproved();

	void setApprovedExemption(boolean approvedExemption);
	
	String exemptionDetails();
	
	@Override
	String toString();
}
