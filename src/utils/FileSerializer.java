package utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import models.Movie;
import models.Rating;
import models.User;
import controllers.Driver;

public class FileSerializer {
	
	Sorter sorter = new Sorter();
	
	public void SerializeUsers() throws Exception
	{
		Driver driver = new Driver();
		//reads in the users from the file
		Importer.ImportUsers();
		//adds users to the hashmap
		driver.addUser("Lionel", "Messi", 31, "Male", "Footballer", 20202020);
		driver.addUser("Cormac", "Dunphy", 20, "Male", "Student", 10101010);
		
		sorter.sortUsers();
		
		//Print Out sorter.sortedUserMap
				System.out.println("User HashMap after sorting entries by values in FileSerializer");
		        Set<Entry<Long, User>> entrySetSortedByValue = sorter.sortedUserMap.entrySet();               		
		           for(Entry<Long, User> mapping : entrySetSortedByValue){
		               System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
		           }
		
		HashMap<Long, User> users = driver.getUsers();
		//System.out.println(users);
		//calls method in driver which writes the users hashmap to a file called Users.xml
		driver.storeUsers(new File("Users.xml"));
	}
	
	public void SerializeMovies() throws Exception
	{
		Driver driver = new Driver();
		//reads in the movies from the file
		Importer.ImportMovies();
		//adds a movie to the hashmap
		driver.addMovie("It", "2017", "www.it.ie");
		sorter.sortMovies();
		
		//Print Out sorter.sortedMovieMap
		System.out.println("Movie HashMap after sorting entries by values in FileSerializer");
        Set<Entry<Long, Movie>> entrySetSortedByValue = sorter.sortedMovieMap.entrySet();               		
           for(Entry<Long, Movie> mapping : entrySetSortedByValue){
               System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
           }
      
		HashMap<Long, Movie> movies = driver.getMovies();
		//System.out.println(movies);
		//calls method in driver which writes the movies hashmap to a file called Movies.xml
		driver.storeMovies(new File("Movies.xml"));
	}
	
	public void SerializeRatings() throws Exception
	{
		Driver driver = new Driver();
		//reads in rating from the file
		Importer.ImportRatings();
		//adds a rating to the hashmap
		driver.addRating(1234l, 1234l, 1234l, 1234l);
		HashMap<Long, Rating> ratings = driver.getRatings();
		System.out.println(ratings);
		//calls method in driver which writes the ratings hashmap to a file called Ratings.xml
		driver.storeRatings(new File("Ratings.xml"));
	}
}
