package model;

import java.sql.Timestamp;
import java.util.Date;

public abstract class AppendTimestamp
{
	 private Timestamp timeStamp;
		
		public AppendTimestamp()
		{
			Date date= new Date();
			long time = date.getTime();
			timeStamp = new Timestamp(time);

		}
		
		public Timestamp getTimestamp()
		{
			return this.timeStamp;
		}
}
