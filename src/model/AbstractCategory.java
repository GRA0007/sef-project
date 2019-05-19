package model;

import model.interfaces.CategoryInt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractCategory implements CategoryInt
{


	private List<Comment> commentList = new ArrayList<>();

	protected Staff staff;
	protected Date startDate;
	protected boolean isCompleted;
	protected Date endDate;
	protected Date lastEditTimestamp = new Date();

	public abstract String toString();

	public abstract String getDuration();

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

	public Staff getStaff() {
		return staff;
	}

	public void updateTimestamp() {
		lastEditTimestamp = new Date();
	}
}
