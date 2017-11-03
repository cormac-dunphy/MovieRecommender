package models;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utils.Importer;
import controllers.Driver;

public class UserTest 
{
	//tests getters and setters for the user class
	
	User test = new User(40l, "Cormac", "Dunphy", "Male", 20l, "Student" , 20201212l);
	
	@Test
	public void testCreateUser()
	{
		assertEquals("Cormac", test.firstName);
		assertEquals("Dunphy", test.lastName);
		assertEquals("Male", test.gender);
		assertEquals(20l, test.age);
		assertEquals("Student", test.occupation);
		assertEquals(20201212l, test.zipCode);
	}
	
	@Test
	public void testGetFirstName()
	{
		assertEquals("Cormac", test.getFirstName());
	}
	
	@Test
	public void testGetLastName() 
	{
		assertEquals("Dunphy", test.getLastName());
	}

	@Test
	public void testGetGender() 
	{
		assertEquals("Male", test.getGender());
	}

	@Test
	public void testGetAge() 
	{
		assertEquals(20l, test.getAge());
	}

	@Test
	public void testGetOccupation() 
	{
		assertEquals("Student", test.getOccupation());
	}
	
	@Test
	public void testGetZipCode() 
	{
		assertEquals(20201212l, test.getZipCode());
	}
}