package model;

import java.util.StringTokenizer;

import model.interfaces.UserInt;



/**
 * @author andy
 *	The abstract user will be an overall template for both Staff and Student, it is not yet decided if
 *	variable setting will be appropriate, that will be latter confirmed.
 */
public abstract class AbstractUser implements UserInt
{
		private String userID;
		private String famName;
		private String givenName;
		private String address;
		private String phoneNo;
		private String email;
		
		AbstractUser(String userID, String famName, String givenName, String address,
				String phoneNo, String email) {
			this.userID = userID.toUpperCase();
			this.famName = famName.toUpperCase();
			this.givenName = givenName.toUpperCase();
			this.address = getFormattedString(address);
			this.phoneNo = phoneNo;
			this.email = email.toUpperCase();
		}
		
		//Method provides a string that concatenates users input into a string without white space,
		//allowing underscores ("_") to separate important strings 
		private String createFormattedString(String address) 
		{
			if(address == null) 
			{
				return null;
			}
			
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(address);
			
			
			while(st.hasMoreTokens())
			{
				sb.append(st.nextToken());
				
				if(st.hasMoreTokens()) 
				{
				sb.append("_");
				}
			}
			return sb.toString();
			
		}
		
		//public accessor for child classes to the createFormattedString method
		String getFormattedString(String address)
		{
			return createFormattedString(address);
		}
		
		public String getID()
		{
			return this.userID;
		}
		
		public String getName()
		{
			return this.givenName+ " " +this.famName;
		}
		
		public String getPhone()
		{
			return this.phoneNo;
		}
		
		public String getAddress()
		{
			return this.address;
		}

		@Override
		public String toString() {
			return String.format("ID: %s\nName: %s %s\nAddress: %s\nPhone number: %s\nEmail: %s",
					this.userID, this.givenName, this.famName, this.address, this.phoneNo, this.email);
		}

}
