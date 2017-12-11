package utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.Movie;
import models.Rating;
import models.User;
import controllers.Driver;

public class FileSerializer {
	

	static XStream xstream = new XStream(new DomDriver());

	public void SerializeUsers() throws Exception
	{
		Driver driver = new Driver();
		//reads in the users from the file
		Importer.ImportUsers();
		//adds users to the hashmap
		driver.addUser("Lionel", "Messi", 31, "Male", "Footballer", 20202020);
		driver.addUser("Cormac", "Dunphy", 20, "Male", "Student", 10101010);
		HashMap<Long, User> users = driver.getUsers();
		System.out.println(users);
		//calls method in driver which writes the users hashmap to a file called Users.xml
		driver.storeUsers(new File("Users.xml"));
	}

	
	public static void serializeFiles(HashMap<Long, Movie> movies, HashMap<Long, User> users, HashMap<Long, Rating> ratings) throws Exception
	{

		XMLSerializer.push(movies);
		//System.out.println(movies);
		XMLSerializer.push(users);
		//System.out.println(users);
		XMLSerializer.push(ratings);
		//System.out.println(ratings);

		Driver driver = new Driver();
		//reads in the movies from the file
		Importer.ImportMovies();
		//adds a movie to the hashmap
		driver.addMovie("It", "2017", "www.it.ie");
		//HashMap<Long, Movie> movies = driver.getMovies();
		System.out.println(movies);
		//calls method in driver which writes the movies hashmap to a file called Movies.xml
		driver.storeMovies(new File("Movies.xml"));
	}
	
	public void SerializeRatings() throws Exception
	{
		Driver driver = new Driver();
		//reads in rating from the file
		Importer.ImportRatings();
		//adds a rating to the hashmap
		//driver.addRating(1234l, 1234l, 1234l, 1234l);
		HashMap<Long, Rating> ratings = driver.getRatings();
		System.out.println(ratings);
		//calls method in driver which writes the ratings hashmap to a file called Ratings.xml
		driver.storeRatings(new File("Ratings.xml"));

	}
}
