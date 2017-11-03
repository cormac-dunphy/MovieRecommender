package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class RatingTest {
	
	//tests getters and setters for the rating class
	
	Rating test = new Rating(1234, 1234, 5, 1234);
	
	@Test
	public void testCreateRating() 
	{
		assertEquals(1234, test.userID);
		assertEquals(1234, test.movieID);
		assertEquals(5, test.movieRating);
		assertEquals(1234, test.userTimestamp);
	}

	@Test
	public void testGetUserID() 
	{
		assertEquals(1234, test.getUserID());
	}

	@Test
	public void testGetMovieID() 
	{
		assertEquals(1234, test.getMovieID());
	}

	@Test
	public void testMovieRating() 
	{
		assertEquals(5, test.getMovieRating());
	}

	@Test
	public void testGetUserTimestamp() 
	{
		assertEquals(1234, test.getUserTimestamp());
	}
}