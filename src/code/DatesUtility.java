package code;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DatesUtility {
	Date startDate;
	Date endDate;
	public DatesUtility(String date1, String date2) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	    Date d1 = df.parse(date1);
		Date d2 = df.parse(date2);
	}
	
	public static Date least(Date a, Date b) {
	    return a == null ? b : (b == null ? a : (a.before(b) ? a : b));
	}
}
