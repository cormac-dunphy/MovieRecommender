package controllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utils.Importer;

public class DriverTest {
	
	Driver driver = new Driver();
	
	@Test
	public void testAddUser()
	{
		assertTrue(Importer.userMap.size() == 0);
		driver.addUser("Cormac", "Dunphy", 20, "Male", "Student", 101010);
		assertTrue(Importer.userMap.size() == 1);
	}
	
	@After
	public void tearDown()
	{
		driver.removeUser(1);
	}
	
	@Test
	public void testRemoveUser()
	{
		driver.addUser("Cormac", "Dunphy", 20, "Male", "Student", 101010);
		assertTrue(Importer.userMap.size() == 1);
		driver.removeUser(1);
		assertTrue(Importer.userMap.size() == 0);
	}
		
	@Test
	public void testAddMovie()
	{
		assertTrue(Importer.movieMap.size() == 0);
		driver.addMovie("It", "2017", "www.it.ie");
		assertTrue(Importer.movieMap.size() == 1);
	}
	
	@Test
	public void testAddRating()
	{
		assertTrue(Importer.ratingMap.size() == 0);
		driver.addRating(1234l, 1234l, 5l, 1234l);
		assertTrue(Importer.ratingMap.size() == 1);
	}
}