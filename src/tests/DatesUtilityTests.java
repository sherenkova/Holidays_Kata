package tests;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

import code.DatesUtility;

public class DatesUtilityTests {

	@Test
	public void testConstructor() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
	}
	
	@Test
	public void testLeastCorrectWorking() throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	    Date d1 = df.parse("29/02/2016");
		Date d2 = df.parse("06/12/2016");
		Date d3 = DatesUtility.least(d1, d2);
		
		assertEquals(d1, d3);
	}
	
	@Test
	public void testLeastCorrectWorkingReverseParameters() throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	    Date d1 = df.parse("29/02/2016");
		Date d2 = df.parse("06/12/2016");
		Date d3 = DatesUtility.least(d2, d1);
		
		assertEquals(d1, d3);
	}
	
	@Test
	public void testLeastCorrectWorkingBigDates() throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	    Date d1 = df.parse("29/01/2056");
		Date d2 = df.parse("06/01/2056");
		Date d3 = DatesUtility.least(d2, d1);
		
		assertEquals(d2, d3);
	}
	
	@Test
	public void testLeastCorrectWorkingSmallDates() throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	    Date d1 = df.parse("29/01/1056");
		Date d2 = df.parse("06/01/1056");
		Date d3 = DatesUtility.least(d2, d1);
		
		assertEquals(d2, d3);
	}
	
	@Test
	public void testCorrectStartDate() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	    Date d1 = df.parse("29/02/2016");
		
		assertEquals(util.getStartDate(), d1);
	}
	
	@Test
	public void testCorrectEndDate() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	    Date d1 = df.parse("06/12/2016");
		
		assertEquals(util.getEndDate(), d1);
	}
	
	@Test
	public void testIsInRangeOutOfRange() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		
		assertEquals(util.isDateInsideRange("27/04/2015"), false);
	}
	
	@Test
	public void testIsInRangeInRange() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		
		assertEquals(util.isDateInsideRange("27/04/2016"), true);
	}
	
	@Test
	public void testisDateRangeInsideRangeInside() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		
		assertEquals(util.isDateRangeInsideRange("29/03/2016", "06/11/2016"), true);
	}
	
	@Test
	public void testisDateRangeInsideRangeInsideReverse() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		
		assertEquals(util.isDateRangeInsideRange("06/11/2016", "29/03/2016"), true);
	}
	
	@Test
	public void testisDateRangeInsideRangeCrossed() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		
		assertEquals(util.isDateRangeInsideRange("29/01/2016", "06/11/2016"), false);
	}
	
	@Test
	public void testisDateRangeInsideRangeCrossedReverse() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		
		assertEquals(util.isDateRangeInsideRange("06/11/2016", "29/01/2016"), false);
	}
	
	@Test
	public void testisDateRangeInsideRangeOutside() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		
		assertEquals(util.isDateRangeInsideRange("29/01/2013", "06/11/2013"), false);
	}
	
	@Test
	public void testisDateRangeInsideRangeOutsideReverse() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		
		assertEquals(util.isDateRangeInsideRange("06/11/2013", "29/01/2013"), false);
	}
	
	@Test
	public void testisDateRangeOutsideRangeInside() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		
		assertEquals(util.isDateRangeOutsideRange("29/03/2016", "06/11/2016"), false);
	}
	
	@Test
	public void testisDateRangeOutsideRangeInsideReverse() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		
		assertEquals(util.isDateRangeOutsideRange("06/11/2016", "29/03/2016"), false);
	}
	
	@Test
	public void testisDateRangeOutsideRangeCrossed() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		
		assertEquals(util.isDateRangeOutsideRange("29/01/2016", "06/11/2016"), false);
	}
	
	@Test
	public void testisDateRangeOutsideRangeCrossedReverse() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		
		assertEquals(util.isDateRangeOutsideRange("06/11/2016", "29/01/2016"), false);
	}
	
	@Test
	public void testisDateRangeOutsideRangeOutside() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		
		assertEquals(util.isDateRangeOutsideRange("29/01/2013", "06/11/2013"), true);
	}
	
	@Test
	public void testisDateRangeOutsideRangeOutsideReverse() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
		
		assertEquals(util.isDateRangeOutsideRange("06/11/2013", "29/01/2013"), true);
	}
	
	@Test
	public void testGetDaysCount() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/02/2016");
		
		assertEquals(util.getDaysCount(), (Integer)23);
	}
	
	@Test
	public void testGetDaysCountOneMonth() throws ParseException {
		DatesUtility util = new DatesUtility("01/01/1000", "01/02/1000");
		
		assertEquals(util.getDaysCount(), (Integer)31);
	}
}
