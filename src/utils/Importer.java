package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import models.Movie;
import models.Rating;
import models.User;

public class Importer {
	public static HashMap<Long, User> userMap = new HashMap<Long, User>();
	public static HashMap<Long, Movie> movieMap = new HashMap<Long, Movie>();
	public static HashMap<Long, Rating> ratingMap = new HashMap<Long, Rating>();
	
	public static void ImportUsers() throws IOException
	{
		File usersFile = new File("data/users.dat");
		String delims = "[|]";
		Scanner scanner = new Scanner(usersFile);

		while (scanner.hasNextLine()) {
			String userDetails = scanner.nextLine();
			// parse user details string
			String[] userTokens = userDetails.split(delims);

			//assign each token a name
			long userID = Long.parseLong(userTokens[0]);
			String firstName = userTokens[1];
			String lastName = userTokens[2];				
			long age = Long.parseLong(userTokens[3]);
			String gender = userTokens[4];
			String occupation = userTokens[5];
			long zipCode = Long.parseLong(userTokens[6]);

			if (userTokens.length == 7) {
				System.out.println("UserID: " + userTokens[0] + ",First Name:" + userTokens[1]);
				User u = new User(firstName, lastName, gender, age, occupation, zipCode);
				userMap.put(new Long(userID), u);
			} else {
				scanner.close();
				throw new IOException("Invalid member length: " + userTokens.length);
			}
		}
		System.out.println("User hashmap: " + userMap);
		scanner.close();

	}


	public static void ImportMovies() throws FileNotFoundException
	{
		File moviesFile = new File("data/movies.dat");
		String delims = "[|]";
		Scanner scanner = new Scanner(moviesFile);

		while (scanner.hasNextLine())   {    
			String movieDetails = scanner.nextLine();    
			String[] movieTokens = movieDetails.split(delims);

			long movieID = Long.parseLong(movieTokens[0]);
			String title = movieTokens[1];
			String year = movieTokens[2];
			String url = movieTokens[3];


			if (movieTokens.length == 23) {
				Movie m = new Movie(title, year, url);
				movieMap.put(new Long(movieID), m);
			} else {
				scanner.close();
			}
		}
		System.out.println("Movies hashmap: " + movieMap);
	}


	public static void ImportRatings() throws FileNotFoundException
	{
		File ratingsFile = new File("data/ratings.dat");
		Scanner scanner = new Scanner(ratingsFile);
		String delims = "[|]";

		while (scanner.hasNextLine())   {

			String ratingDetails = scanner.nextLine();
			String[] ratingTokens = ratingDetails.split(delims);

			long userID = Long.parseLong(ratingTokens[0]);
			long movieID = Long.parseLong(ratingTokens[1]);
			long movieRating = Long.parseLong(ratingTokens[2]);
			long userTimestamp = Long.parseLong(ratingTokens[3]);

			// output rating data to console.
			if (ratingTokens.length == 4) {
				Rating r = new Rating(userID, movieID, movieRating, userTimestamp);
				ratingMap.put(new Long(userID), r);
				//movieMap.get(r.getMovieID()).addRating(r);
			} else {
				scanner.close();
			}
		}
		System.out.println("rating hashmap: " + ratingMap);
	}
}

