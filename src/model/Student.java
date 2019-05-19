package model;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Student extends AbstractUser
{
	private ProgramStructure structure;
	private int riskLevel;
	private String riskReasonAndAdvice;

	public Student(String userID, String famName, String givenName, String address,
				   String phoneNo, String email) {
		super(userID, famName, givenName, address, phoneNo, email);
		structure = new ProgramStructure();
	}

	public ProgramStructure getProgramStructure() {
		return structure;
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

	public boolean sendCommentEmail(Comment comment, String emailFromUser, String password) {
	    //String studentEmail = this.getEmail();
        String studentEmail = "s3719834@student.rmit.edu.au";
        String staffEmail = emailFromUser;

        Properties props = new Properties();

        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.office365.com");

        // Get the Session object.
        SimpleMailAuthenticator authenticator = new SimpleMailAuthenticator(staffEmail, password);
        Session session = Session.getInstance(props, authenticator);


        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(staffEmail));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(studentEmail));

            // Set Subject: header field
            message.setSubject("Summary of your recent interation with " + comment.getAuthor().getName());

            // Now set the actual message
            message.setText(comment.toString());

            // Send message
            Transport.send(message);

           return true;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

	@Override
	public String toString() {
		if (riskLevel > 0) {
			return String.format("ID: %s\nName: %s %s\nAddress: %s\nPhone number: %s\nEmail: %s\n" +
							"\nThis student is at risk.\nRisk level: %s\nReason/advice: %s",
					this.userID, this.givenName, this.famName, this.address, this.phoneNo, this.email,
					riskLevel, riskReasonAndAdvice);
		} else {
			return super.toString();
		}
	}
}
