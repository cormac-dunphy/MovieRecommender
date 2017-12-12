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
import utils.Importer;
import utils.Sorter;

public class Driver implements RecommenderAPI {

	//returns the contents of user map
	public HashMap<Long, User> getUsers()
	{
		System.out.println(Importer.userMap);
		return Importer.userMap;
	}
//check for git
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
	//serializes the hashmap to the file
	@Override
	public User addUser(String firstName, String lastName, long age, String gender, String occupation, long zipCode)
	{
		//gives user id of 1 more than the size of the hashmap
		long id = Importer.userMap.size()+1;
		User user = new User(id, firstName, lastName, age, gender, occupation, zipCode);
		//puts the user into the hashmap
		Importer.userMap.put(id, user);

		//initializes variables
		File userFile = new File("data/users.dat");
		String fileName = ("data/users.dat");
		String delims2 = "|";
		String newLine = System.getProperty("line.separator");

		// Use new PrintWriter with the 'true' parameter to avoid overwriting the user file.
		// Add the new user info along with the id and delimiter to the userFile
		PrintWriter printWriter = null;
		try {
			//if the user file doesnt exist create one
			if (!userFile.exists()) userFile.createNewFile();
			printWriter = new PrintWriter(new FileOutputStream(fileName, true));
			//write the info to the userFile with delims |
			printWriter.write(newLine + id + delims2 + firstName + delims2 + lastName + delims2 + age + delims2 + gender + delims2 + occupation + delims2 + zipCode);
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}
		//confirmation that you've added the user
		System.out.println("User Added to File: " + firstName + " " + lastName + " " + age + " " + gender + " " + occupation + " " + zipCode );

		return user;
	}

	//adds new movie to moviemap and gives it an id of 1 greater than the size of the hashmap
	//serializes to the file
	public Movie addMovie(String title, String year, String url) 
	{
		//gives movie id of one greater than the hashmap size
		long id = Importer.movieMap.size()+1;
		Movie movie = new Movie(title, year,url);
		Importer.movieMap.put(id, movie);

		//initializing variables
		File movieFile = new File("data/movies.dat");
		String fileName = ("data/movies.dat");
		String delims2 = "|";
		String newLine = System.getProperty("line.separator");

		// Use new PrintWriter with the 'true' parameter to avoid overwriting the movies file.
		// Add the new movie info along with the id and delimiters
		PrintWriter printWriter = null;
		try {
			//if movieFile doesnt exist create one
			if (!movieFile.exists()) movieFile.createNewFile();
			printWriter = new PrintWriter(new FileOutputStream(fileName, true));
			//write the movie info to the file with the delims |
			printWriter.write(newLine + id + delims2 + title + delims2 + year + delims2 + url);
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}
		//confirmation that you've added the movie
		System.out.println("Movie Added to File: " + title + " " + year + " " + url );

		return movie;

	}

	//adds a rating to the ratingmap and serializes to the file
	public Rating addRating(long userID, long movieID, long movieRating) 
	{
		//use built in date.getTime to get the timestamp
		java.util.Date date= new java.util.Date();
		long timestampMS = date.getTime();
		Rating rating = new Rating(userID, movieID, movieRating, timestampMS);
		//puts rating into map with the users ID
		Importer.ratingMap.put(rating.getUserID(), rating);

		// Initialize variables
		File ratingFile = new File("data/ratings.dat");
		String fileName = ("data/ratings.dat");
		String delims2 = "|";
		String newLine = System.getProperty("line.separator");

		// Use new PrintWriter with the 'true' parameter to avoid overwriting the ratings file.
		// Add the new rating info, id and delimiters
		PrintWriter printWriter = null;
		try {
			//if the ratingFile doesn't exist create one
			if (!ratingFile.exists()) ratingFile.createNewFile();
			printWriter = new PrintWriter(new FileOutputStream(fileName, true));
			//writes rating info file with delims |
			printWriter.write(newLine + userID + delims2 + movieID + delims2 + movieRating + delims2 + timestampMS);
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}
		//confirmation that you've added the rating
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

	//takes in a users id and returns their ratings
	@Override
	public User getUserRatings(long userID) 
	{
		for(Rating value : Importer.ratingMap.values())
		{
			if(value.userID == userID)
			{
				System.out.println(value);
			}
		}
		return null;
	}

	public Movie getMoviesByTitle(String title) 
	{
		//iterates through the values in sortedMovieMap
		for(Movie value : Sorter.sortedMovieMap.values())
		{
			//if the inputted string is in the value.title in the hashmap - print out the value
			if(value.title.contains(title))
			{
				System.out.println(value);
			}
		}
		return null;
	}

	@Override
	public Movie getMoviesByYear(String year)
	{
		//iterates through the values in sortedMovieMap
		for(Movie value : Sorter.sortedMovieMap.values())
		{
			//if the inputted string is in the value.year in the hashmap - print out the value
			if(value.year.contains(year))
			{
				System.out.println(value);
			}
		}
		return null;
	}

	//lists out all movies in the hashmap
	public void listMovies() throws FileNotFoundException
	{
		File movieFile = new File("data/movies.dat");
		Scanner inMovies = new Scanner(movieFile);
		System.out.println("Movies: ");
		//iterates through the movieFile and prints out each line
		while (inMovies.hasNextLine()) {
			String movieLine = inMovies.nextLine().trim();
			System.out.println(movieLine);           
		}
		inMovies.close();
	}
}