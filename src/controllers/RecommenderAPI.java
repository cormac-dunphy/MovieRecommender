package controllers;

import java.io.File;

import utils.Importer;
import models.Movie;
import models.Rating;
import models.User;

public interface RecommenderAPI {
	public User addUser(String firstName,String lastName,long age,String gender,String occupation, long zipCode);
	public User removeUser(long userID);
	public Movie addMovie(String title,String year,String url);
	public Rating addRating(long userID,long movieID,long movieRating, long userTimestamp);
	public Movie getMovie(long movieID);
	public User getUserRatings(long userID);
	public Movie getMoviesByTitle();
	public Movie getMoviesByYear();
	public Importer initialLoad(File csvFile);
	void load();
	void write();
}

