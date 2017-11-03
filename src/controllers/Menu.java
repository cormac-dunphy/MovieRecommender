package controllers;

import java.io.File;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;

public class Menu {

	public Driver driver = new Driver();

	@Command(description = "Add A New User")
	public void addUser(@Param(name = "first name") String firstName, @Param(name = "last name") String lastName,
			@Param(name = "gender") String gender, @Param(name = "age") Long age,
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
			@Param(name = "movieRating") Long movieRating, @Param(name = "userTimestamp") Long userTimestamp) 
	{
		driver.addRating(userID, movieID, movieRating, userTimestamp);

	}
	
	@Command(description = "Remove User")
	public void removeUser(@Param(name = "userID") long userID) 
	{
		driver.removeUser(userID);

	}
	
	@Command(description = "Get A Movie")
	public void getMovie(@Param(name = "movieID") long movieID) 
	{
		driver.removeUser(movieID);

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
	
	@Command(description = "Store Users")
	public void storeUsers(File file) throws Exception 
	{
		driver.storeUsers(file);

	}
	
	@Command(description = "Store Movies")
	public void storeMovies(File file) throws Exception 
	{
		driver.storeMovies(file);

	}
	
	@Command(description = "Load Users File")
	public void loadMovies(File file) throws Exception 
	{
		driver.load(file);

	}
	
	public void menu() throws Exception {

		Menu menu = new Menu();
		Shell shell = ShellFactory.createConsoleShell("lm", "Welcome to likemovie - ?help for instructions", menu);
		shell.commandLoop();
	}

}
