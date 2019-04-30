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
		protected String userID;
		protected String famName;
		protected String givenName;
		protected String address;
		protected String phoneNo;
		protected String email;
		
		public AbstractUser(String userID, String famName, String givenName, String address, 
				String phoneNo, String email)
		{
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
		public String getFormattedString(String address)
		{
			return createFormattedString(address);
		}
		
		@Override
		public String getID() 
		{
			return this.userID;
		}
		
		@Override
		public String getName() 
		{
			return this.givenName+ " " +this.famName;
		}
		
		@Override
		public String getPhoneNO() 
		{
			return this.phoneNo;
		}
		
		@Override
		public String getAddress()
		{
			return this.address;
		}

		@Override
		public String toString()
		{
			return String.format("%s:%s:%s:%s:%s:%s", 
					this.userID, this.famName, this.givenName, this.address, this.phoneNo, this.email);
		}

}
