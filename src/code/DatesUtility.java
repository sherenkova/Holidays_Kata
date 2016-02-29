package code;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DatesUtility {
	Date startDate;
	Calendar startCalendar;
	Date endDate;
	Calendar endCalendar;
	public DatesUtility(String date1, String date2) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	    Date d1 = df.parse(date1);
		Date d2 = df.parse(date2);
		
		startDate = least(d1, d2);
		endDate = startDate == d1 ? d2 : d1;
		
		startCalendar = Calendar.getInstance();
		endCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);
		endCalendar.setTime(endDate);
	}
	
	public static Date least(Date a, Date b) {
	    return a == null ? b : (b == null ? a : (a.before(b) ? a : b));
	}
	
	public Date getStartDate()
	{
		return startDate;
	}
	
	public Date getEndDate()
	{
		return endDate;
	}
	
	public Boolean isDateInsideRange(String date) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	    Date d = df.parse(date);
	    
	    return d.after(startDate) && d.before(endDate);
	}
	
	public Boolean isDateRangeInsideRange(String date1, String date2) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	    Date d1 = df.parse(date1);
		Date d2 = df.parse(date2);
		
		Date sd = least(d1, d2);
		Date ed = sd == d1 ? d2 : d1;
	    
	    return sd.after(startDate) && ed.before(endDate);
	}
	
	public Boolean isDateRangeOutsideRange(String date1, String date2) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	    Date d1 = df.parse(date1);
		Date d2 = df.parse(date2);
		
		Date sd = least(d1, d2);
		Date ed = sd == d1 ? d2 : d1;
	    
	    return sd.after(endDate) || ed.before(startDate);
	}
	
	public Integer getDaysCount()
	{
        return (int)( (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24));
	}
	
	public Boolean isSameMonth()
	{
        return startCalendar.get(Calendar.YEAR) == endCalendar.get(Calendar.YEAR) &&
        		startCalendar.get(Calendar.MONTH) == endCalendar.get(Calendar.MONTH);
	}
	
	public Boolean isSameYear()
	{
        return startCalendar.get(Calendar.YEAR) == endCalendar.get(Calendar.YEAR);
	}
}
