package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest {

	Movie test = new Movie("It", "2017", "www.it.com");
	
	@Test
	public void testCreateMovie() 
	{
		assertEquals("It", test.title);
		assertEquals("2017", test.year);
		assertEquals("www.it.com", test.url);	
	}
	
	@Test
	public void testGetTitle() 
	{
		assertEquals("It", test.getTitle());
	}

	@Test
	public void testYear() 
	{
		assertEquals("2017", test.getYear());
	}
}
