package controllers;

import java.io.File;
import java.io.FileNotFoundException;

import utils.Importer;
import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
//final
public class Menu {

	//commands for cliche shell which use methods from the Driver class

	public Driver driver = new Driver();

	@Command(description = "Add A New User")
	public void addUser(@Param(name = "first name") String firstName, @Param(name = "last name") String lastName,
			@Param(name = "age") Long age, @Param(name = "gender") String gender,
			@Param(name = "occupation") String occupation, @Param(name = "zipCode") long zipCode) 
	{
		driver.addUser(firstName, lastName, age, gender, occupation, zipCode);
	}

	@Command(description = "Add A New Movie")
	public void addMovie(@Param(name = "title") String title, @Param(name = "year") String year,
			@Param(name = "url") String url) 
	{
		driver.addMovie(title, year, url);
	}

	@Command(description = "Add A New Rating")
	public void addRating(@Param(name = "userID") long userID, @Param(name = "movieID") Long movieID,
			@Param(name = "movieRating") Long movieRating) 
	{
		driver.addRating(userID, movieID, movieRating);
	}

	@Command(description = "Remove User")
	public void removeUser(@Param(name = "userID") long userID) 
	{
		driver.removeUser(userID);
	}

	@Command(description = "Get A Movie")
	public void getMovie(@Param(name = "movieID") long movieID) 
	{
		driver.getMovie(movieID);
	}

	@Command(description = "Get Users")
	public void getUsers() 
	{
		driver.getUsers();
	}

	@Command(description = "Get Ratings")
	public void getRatings() 
	{
		driver.getRatings();
	}

	@Command(description = "Get Movies By Title")
	public void getMoviesByTitle(@Param(name = "title") String title) 
	{
		driver.getMoviesByTitle(title);
	}

	@Command(description = "Get Movies By Year")
	public void getMoviesByYear(@Param(name="year")String year) 
	{
		driver.getMoviesByYear(year);
	}

	@Command(description = "List Movies")
	public void listMovies() throws FileNotFoundException 
	{
		driver.listMovies();
	}

	@Command(description = "Get User Ratings")
	public void getUserRatings(@Param(name="userID")long userID) throws FileNotFoundException 
	{
		driver.getUserRatings(userID);
	}

	public void menu() throws Exception 
	{
		Menu menu = new Menu();
		Shell shell = ShellFactory.createConsoleShell("MR", "Welcome to Movie Recommender - ?help for instructions", menu);
		shell.commandLoop();
	}
}