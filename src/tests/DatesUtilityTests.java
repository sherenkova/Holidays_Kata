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
}
