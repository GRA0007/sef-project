package model.interfaces;

public interface Exemption 
{
	
	public abstract void addComment(String comments);
	
	public abstract String readComments();
	
	public abstract boolean isExemptionApproved();

	boolean setApprovedExemption(int authority);
	
	public abstract String exemptionDetails();
	
	@Override
	String toString();
	
	boolean commentsAttached();
	
	String getCommentFileName();
}
