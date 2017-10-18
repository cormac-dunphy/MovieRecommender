package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testCreate() 
	{
		User one = new User(10l, "Cormac", "Dunphy", "M", 0, "student", 10101010);
		equals(one);
	}
}
