package controllers;

import java.io.File;

import utils.Importer;
import models.Movie;
import models.Rating;
import models.User;

//list of methods used in the driver class
public interface RecommenderAPI {
	public User addUser(String firstName,String lastName,long age, String gender, String occupation, long zipCode);
	public User removeUser(long userID);
	public Movie addMovie(String title,String year,String url);
	public Rating addRating(long userID,long movieID,long movieRating);
	public Movie getMovie(long movieID);
	public User getUserRatings(long userID);
	public Movie getMoviesByTitle(String title);
	public Movie getMoviesByYear(String year);
}



