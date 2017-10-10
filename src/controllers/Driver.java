package controllers;

import java.io.File;

import models.Movie;
import models.Rating;
import models.User;
import utils.Importer;

public class Driver implements RecommenderAPI {

	@Override
	public User addUser(String firstName, String lastName, long age,
			String gender, String occupation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User removeUser(long userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie addMovie(String title, String year, String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating addRating(long userID, long movieID, long rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie getMovie(long movieID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserRatings(long userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie getMoviesByTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie getMoviesByYear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Importer initialLoad(File csvFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	@Override
	public void write() {
		// TODO Auto-generated method stub

	}

}
