package controllers;

import java.io.File;

import models.Movie;
import models.Rating;
import models.User;
import utils.Importer;

public class Driver implements RecommenderAPI {

	@Override
	public User addUser(String firstName, String lastName, long age,String gender, String occupation, long zipCode) {
		long id = Importer.userMap.size()+1;
		User user = new User(id, firstName, lastName, gender, age, occupation, zipCode);
		Importer.userMap.put(id, user);
		return user;
	}

	@Override
	public User removeUser(long userID) {
		return Importer.userMap.remove(userID); 
		}

	@Override
	public Movie addMovie(String title, String year, String url) {
		Movie movie = new Movie(title, year,url);
		Importer.movieMap.put(movie.id, movie);
		return movie;
	}

	@Override
	public Rating addRating(long userID, long movieID, long movieRating, long userTimestamp) {
		Rating rating = new Rating(userID, movieID, movieRating, userTimestamp);
		Importer.ratingMap.put(rating.getUserID(), rating);
		return rating;
	}

	@Override
	public Movie getMovie(long movieID) {
		Movie m = Importer.movieMap.get(movieID);
		return m;
	}

	@Override
	public User getUserRatings(long userID) {
		return null;
	}

	@Override
	public Movie getMoviesByTitle() {
		return null;
	}

	@Override
	public Movie getMoviesByYear() {
		return null;
	}

	@Override
	public Importer initialLoad(File csvFile) {
		
		return null;
	}

	@Override
	public void load() {
		

	}

	@Override
	public void write() {
		

	}

}
