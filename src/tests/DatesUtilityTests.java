package tests;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import code.DatesUtility;

public class DatesUtilityTests {

	@Test
	public void testConstructor() throws ParseException {
		DatesUtility util = new DatesUtility("29/02/2016", "06/12/2016");
	}
}
