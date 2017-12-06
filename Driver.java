package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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

	private Serializer serializer;

	public Driver()
	{
	}

	public Driver(Serializer serializer)
	{
		this.serializer = serializer;
	}

	//returns the contents of user map
	public HashMap<Long, User> getUsers()
	{
		System.out.println(Importer.userMap);
		return Importer.userMap;
	}

	//returns the contents of movie map
	public HashMap<Long, Movie> getMovies()
	{
		System.out.println(Importer.movieMap);
		return Importer.movieMap;
	}

	//returns the contents of rating map
	public HashMap<Long, Rating> getRatings() 
	{
		System.out.println(Importer.ratingMap);
		return Importer.ratingMap;
	}

	//adds new user to usermap and gives it an id of 1 greater than the size of the hashmap
	@Override
	public User addUser(String firstName, String lastName, long age, String gender, String occupation, long zipCode)
	{
		long id = Importer.userMap.size()+1;
		User user = new User(id, firstName, lastName, age, gender, occupation, zipCode);
		Importer.userMap.put(id, user);

		System.out.println("in Add a User .......");
		File userFile = new File("data/users.dat");
		String fileName = ("data/users.dat");
		String delims2 = "|";
		String newLine = System.getProperty("line.separator");

		// Use new PrintWriter with the 'true' parameter to avoid overwriting the books file.
		// Add the new book title, date released and author along with the book ID and delimiters.
		PrintWriter printWriter = null;
		try {
			if (!userFile.exists()) userFile.createNewFile();
			printWriter = new PrintWriter(new FileOutputStream(fileName, true));
			printWriter.write(newLine + id + delims2 + firstName + delims2 + lastName + delims2 + age + delims2 + gender + delims2 + occupation + delims2 + zipCode);
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}

		System.out.println("User Added to File: " + firstName + " " + lastName + " " + age + " " + gender + " " + occupation + " " + zipCode );

		return user;
	}

	//adds new movie to moviemap and gives it an id of 1 greater than the size of the hashmap
	public Movie addMovie(String title, String year, String url) 
	{
		long id = Importer.movieMap.size()+1;
		Movie movie = new Movie(title, year,url);
		Importer.movieMap.put(id, movie);

		System.out.println("in Add a Movie .......");
		File movieFile = new File("data/movies.dat");
		String fileName = ("data/movies.dat");
		String delims2 = "|";
		String newLine = System.getProperty("line.separator");

		// Use new PrintWriter with the 'true' parameter to avoid overwriting the books file.
		// Add the new book title, date released and author along with the book ID and delimiters.
		PrintWriter printWriter = null;
		try {
			if (!movieFile.exists()) movieFile.createNewFile();
			printWriter = new PrintWriter(new FileOutputStream(fileName, true));
			printWriter.write(newLine + id + delims2 + title + delims2 + year + delims2 + url);
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}

		System.out.println("Movie Added to File: " + title + " " + year + " " + url );

		return movie;

	}

	//adds a rating to the ratingmap
	public Rating addRating(long userID, long movieID, long movieRating) 
	{
		// Initialize variable and store new Timestamp object
		java.util.Date date= new java.util.Date();
		long timestampMS = date.getTime();
		Rating rating = new Rating(userID, movieID, movieRating, timestampMS);
		Importer.ratingMap.put(rating.getUserID(), rating);

		System.out.println("in Add a Rating .......");
		File ratingFile = new File("data/ratings.dat");
		String fileName = ("data/ratings.dat");
		String delims2 = "|";
		String newLine = System.getProperty("line.separator");



		// Use new PrintWriter with the 'true' parameter to avoid overwriting the books file.
		// Add the new book title, date released and author along with the book ID and delimiters.
		PrintWriter printWriter = null;
		try {
			if (!ratingFile.exists()) ratingFile.createNewFile();
			printWriter = new PrintWriter(new FileOutputStream(fileName, true));
			printWriter.write(newLine + userID + delims2 + movieID + delims2 + movieRating + delims2 + timestampMS);
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}

		System.out.println("Rating Added to File: " + userID + " " + movieID + " " + movieRating + " " + timestampMS );
		return rating;
	}

	//removes a user from usermap by id
	@Override
	public User removeUser(long userID) 
	{
		System.out.println("User" + " " + userID + " " + "has been removed");
		return Importer.userMap.remove(userID); 
	}

	//returns movie by id
	public Movie getMovie(long movieID) 
	{
		Movie m = Importer.movieMap.get(movieID);
		System.out.println(m);
		return m;
	}

	@Override
	public User getUserRatings(long userID) 
	{
		long i;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter User ID: ");
		i = scanner.nextLong();
		for(Rating value : Importer.ratingMap.values())
		{
			if(value.userID == i)
			{
				System.out.println(value);
			}
		}
		return null;
	}

	@Override
	public Movie getMoviesByTitle() 
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
		return null;
	}

	@Override
	public Movie getMoviesByYear()
	{
		String s = null;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter year of movie: ");
		s = scanner.nextLine();

		for(Movie value : Sorter.sortedMovieMap.values())
		{
			if(value.year.contains(s))
			{
				System.out.println(value);
			}
		}
		return null;
	}

	public void listMovies() throws FileNotFoundException
	{
		File movieFile = new File("data/movies.dat");
		Scanner inMovies = new Scanner(movieFile);
		System.out.println("Movies: ");
		while (inMovies.hasNextLine()) {
			String movieLine = inMovies.nextLine().trim();
			System.out.println(movieLine);           
		}
		inMovies.close();

	}

}