package model.interfaces;

public interface Exemption 
{
	
	public abstract void addComment(String comments);
	
	public abstract String readComments();
	
	public abstract boolean isExemptionApproved();

	public abstract void setApprovedExemption(boolean approvedExemption);
	
	public abstract String exemptionDetails();
	
	@Override
	public abstract String toString();

	public boolean commentsAttached();

	public String getCommentFileName();
	
}
