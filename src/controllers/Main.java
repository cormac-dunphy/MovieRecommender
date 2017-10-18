package controllers;
import java.io.IOException;

import utils.Importer;

public class Main {
	//public static long id = Importer.id;
	static Driver driver = new Driver();
	static Importer importer = new Importer();
	public static void main(String args[]) throws IOException{
		Importer.ImportUsers();
		Importer.ImportMovies();
		Importer.ImportRatings();
		driver.addUser("Bob", "Dylan", 70, "M", "Artist", 10101010);
		driver.addUser("Leo", "Messi", 30, "M", "Footballer", 20202020);
		System.out.println("User hashmap: " + Importer.userMap);
		System.out.println("Movies hashmap: " + Importer.movieMap);
		System.out.println("rating hashmap: " + Importer.ratingMap);
}
}