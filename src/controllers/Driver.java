package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.Movie;
import models.Rating;
import models.User;
import utils.FileSerializer;
import utils.Importer;
import utils.Serializer;
import utils.Sorter;

public class Driver implements RecommenderAPI {
	
	public HashMap<Long,User> userIndex = new HashMap<>();
	public HashMap<Long,Movie> movieIndex = new HashMap<>();
	public HashMap<Long,Rating> ratingIndex = new HashMap<>();
	
	private Serializer serializer;
	
	public Driver()
	{
	}
	
	public Driver(Serializer serializer)
	{
		this.serializer = serializer;
	}
	
	//writes the content of the userMap to a file called Users.xml
	public void storeUsers(File file) throws Exception
	{
		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(file));
		out.writeObject(Importer.userMap);
		out.close(); 
	}
	
	//writes the content of the movieMap to a file called Movies.xml
	public void storeMovies(File file) throws IOException 
	{	
		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(file));
		out.writeObject(Importer.movieMap);
		out.close(); 	
	}
	
	//writes the content of the ratingMap to a file called Ratings.xml
	public void storeRatings(File file) throws IOException 
	{	
		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(file));
		out.writeObject(Importer.ratingMap);
		out.close(); 	
	}
	
	//returns the contents of user map
	public HashMap<Long, User> getUsers()
	{
		return Importer.userMap;
	}

	//returns the contents of movie map
	public HashMap<Long, Movie> getMovies()
	{
		return Importer.movieMap;
	}

	//returns the contents of rating map
	public HashMap<Long, Rating> getRatings() 
	{
		return Importer.ratingMap;
	}

	//adds new user to usermap and gives it an id of 1 greater than the size of the hashmap
	@Override
	public User addUser(String firstName, String lastName, long age,String gender, String occupation, long zipCode)
	{
		long id = Importer.userMap.size()+1;
		User user = new User(id, firstName, lastName, gender, age, occupation, zipCode);
		Importer.userMap.put(id, user);
		return user;
	}

	//adds new movie to moviemap and gives it an id of 1 greater than the size of the hashmap
	public Movie addMovie(String title, String year, String url) 
	{
		long id = Importer.movieMap.size()+1;
		Movie movie = new Movie(title, year,url);
		Importer.movieMap.put(id, movie);
		return movie;
	}

	//adds a rating to the ratingmap
	public Rating addRating(long userID, long movieID, long movieRating, long userTimestamp) 
	{
		Rating rating = new Rating(userID, movieID, movieRating, userTimestamp);
		Importer.ratingMap.put(rating.getUserID(), rating);
		return rating;
	}

	//removes a user from usermap by id
	@Override
	public User removeUser(long userID) 
	{
		return Importer.userMap.remove(userID); 
	}

	//returns movie by id
	public Movie getMovie(long movieID) 
	{
		Movie m = Importer.movieMap.get(movieID);
		return m;
	}
	
	public void searchMovies()
	{
		String s = null;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter search term: ");
		s = scanner.nextLine();
		
		for(Movie value : Sorter.sortedMovieMap.values())
		{
			if(value.title.contains(s))
			{
				System.out.println(value);
			}
		}
	}

	@Override
	public User getUserRatings(long userID) 
	{
		return null;
	}

	@Override
	public Movie getMoviesByTitle() 
	{
		return null;
	}

	@Override
	public Movie getMoviesByYear()
	{
		return null;
	}

	@Override
	public Importer initialLoad(File csvFile) 
	{
		return null;
	}

	@Override
	public void write() 
	{
		
	}
	
	@SuppressWarnings("unchecked")
	public void load(File file) throws Exception
	{
	    ObjectInputStream is = null;
	    try
	    {
	      XStream xstream = new XStream(new DomDriver());
	      is = xstream.createObjectInputStream(new FileReader(file));
	      Importer.userMap       = (HashMap<Long, User>)     is.readObject();
	    }
	    finally
	    {
	      if (is != null)
	      {
	        is.close();
	      }
	    }
}
	
	public void storeInput() throws Exception
	{
		FileSerializer.serializeFiles(Importer.movieMap, Importer.userMap, Importer.ratingMap);
	}

}