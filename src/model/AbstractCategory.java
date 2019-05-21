package model;

import model.interfaces.CategoryInt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractCategory implements CategoryInt
{


	private List<Comment> commentList = new ArrayList<>();

	protected Staff staff;
	protected Date startDate;
	protected boolean isCompleted;
	protected Date endDate;
	protected Date lastEditTimestamp = new Date();

	public abstract String toString();

	public String getDuration() {
		if (isCompleted) {
			long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
			long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

			int months = Math.round(diff / 30);
			return months + " month" + (months == 1 ? "" : "s");
		} else {
			return "N/A";
		}
	};

	public void addComment(Comment comment)
	{
		commentList.add(comment);
	}

	public String getComments()
	{

		StringBuilder commentListString = new StringBuilder();

		if (commentList.size() > 0) {
			for (Comment currentComment : commentList) {
				commentListString.append(currentComment.toString()).append("\n");
			}
		} else {
			commentListString.append("No comments\n");
		}

		return commentListString.toString();
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public Staff getStaff() {
		return staff;
	}

	public void updateTimestamp() {
		lastEditTimestamp = new Date();
	}

	public void setTimestamp(Date date) {
		lastEditTimestamp = date;
	}
}
