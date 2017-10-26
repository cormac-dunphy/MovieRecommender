package controllers;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.Movie;
import models.Rating;
import models.User;
import utils.Importer;
import utils.Serializer;

public class Driver implements RecommenderAPI {
	/*
	private Serializer serializer;


	public Driver()
	{}

	public Driver(Serializer serializer)
	{
		this.serializer = serializer;
	}

	@SuppressWarnings("unchecked")
	public void load() throws Exception 
	{

	}

	@SuppressWarnings("unchecked")
	void load(File file) throws Exception
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
	 */
	public void storeUsers(File file) throws Exception
	{
		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(file));
		out.writeObject(Importer.userMap);
		out.close(); 
	}

	public void storeMovies(File file) throws IOException 
	{	
		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(file));
		out.writeObject(Importer.movieMap);
		out.close(); 	
	}

	public void storeRatings(File file) throws IOException 
	{	
		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(file));
		out.writeObject(Importer.ratingMap);
		out.close(); 	
	}

	public HashMap<Long, User> getUsers()
	{
		return Importer.userMap;		
	}

	public HashMap<Long, Movie> getMovies()
	{
		return Importer.movieMap;
	}

	public HashMap<Long, Rating> getRatings() 
	{
		return Importer.ratingMap;
	}

	@Override
	public User addUser(String firstName, String lastName, long age,String gender, String occupation, long zipCode)
	{
		long id = Importer.userMap.size()+1;
		User user = new User(id, firstName, lastName, gender, age, occupation, zipCode);
		Importer.userMap.put(id, user);
		return user;
	}

	public Movie addMovie(String title, String year, String url) 
	{
		long id = Importer.movieMap.size()+1;
		Movie movie = new Movie(title, year,url);
		Importer.movieMap.put(id, movie);
		return movie;
	}

	public Rating addRating(long userID, long movieID, long movieRating, long userTimestamp) 
	{
		Rating rating = new Rating(userID, movieID, movieRating, userTimestamp);
		Importer.ratingMap.put(rating.getUserID(), rating);
		return rating;
	}

	@Override
	public User removeUser(long userID) 
	{
		return Importer.userMap.remove(userID); 
	}

	public Movie getMovie(long movieID) 
	{
		Movie m = Importer.movieMap.get(movieID);
		return m;
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
	{}
}
