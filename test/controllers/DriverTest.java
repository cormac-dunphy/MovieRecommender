package controllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utils.Importer;

public class DriverTest {
	
	Driver driver = new Driver();
	
	//checks size of hashmap before and after the addUser method is called
	@Test
	public void testAddUser()
	{
		assertTrue(Importer.userMap.size() == 0);
		driver.addUser("Cormac", "Dunphy", 20l, "Male", "Student", 101010);
		assertTrue(Importer.userMap.size() == 1);
	}
	
	//removes the user from the hashmap
	@After
	public void tearDown()
	{
		driver.removeUser(1);
	}
	
	//adds a user then checks the size is 1
	//then calls the removeUser method and checks if the size is 0
	@Test
	public void testRemoveUser()
	{
		driver.addUser("Cormac", "Dunphy", 20l, "Male", "Student", 101010);
		assertTrue(Importer.userMap.size() == 1);
		driver.removeUser(1);
		assertTrue(Importer.userMap.size() == 0);
	}
		
	//checks the size of the hashmap before and after the addMovie method is called
	@Test
	public void testAddMovie()
	{
		assertTrue(Importer.movieMap.size() == 0);
		driver.addMovie("It", "2017", "www.it.ie");
		assertTrue(Importer.movieMap.size() == 1);
	}
	
	//checks the size of the hashmap before and after the addRating method is called
	@Test
	public void testAddRating()
	{
		assertTrue(Importer.ratingMap.size() == 0);
		driver.addRating(1234l, 1234l, 5l);
		assertTrue(Importer.ratingMap.size() == 1);
	}
	
}