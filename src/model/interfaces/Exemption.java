package model.interfaces;

import java.time.LocalDate;

public interface Exemption
{
	/*
	 * Variables
	 *
	 * List<Comment> comments
	 */

	boolean isExemptionApproved();

	void setApprovedExemption(boolean isExemptionApproved);

	LocalDate getChallengeExamDate();

	void setChallengeExamDate(LocalDate challengeExamDate);

	String getExemptionRequest();

	@Override
	String toString();

	void addComment(String comment);

	String readComments();

}
