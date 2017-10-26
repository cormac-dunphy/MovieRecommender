package utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import models.Movie;
import models.Rating;
import models.User;
import controllers.Driver;

public class FileSerializer {
	
	public void SerializeUsers() throws Exception
	{
		Driver driver = new Driver();
		Importer.ImportUsers();
		driver.addUser("Lionel", "Messi", 31, "Male", "Footballer", 20202020);
		driver.addUser("Cormac", "Dunphy", 20, "Male", "Student", 10101010);
		HashMap<Long, User> users = driver.getUsers();
		System.out.println(users);
		driver.storeUsers(new File("Users.xml"));
	}
	
	public void SerializeMovies() throws Exception
	{
		Driver driver = new Driver();
		Importer.ImportMovies();
		driver.addMovie("It", "2017", "www.it.ie");
		HashMap<Long, Movie> movies = driver.getMovies();
		System.out.println(movies);
		driver.storeMovies(new File("Movies.xml"));
	}
	
	public void SerializeRatings() throws Exception
	{
		Driver driver = new Driver();
		Importer.ImportRatings();
		driver.addRating(1234l, 1234l, 1234l, 1234l);
		HashMap<Long, Rating> ratings = driver.getRatings();
		System.out.println(ratings);
		driver.storeRatings(new File("Ratings.xml"));
	}
}
