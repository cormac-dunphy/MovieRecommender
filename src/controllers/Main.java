package controllers;
import java.io.IOException;

import utils.Importer;

public class Main {
	static Importer importer = new Importer();
	public static void main(String args[]) throws IOException{
		Importer.ImportUsers();
		Importer.ImportMovies();
		Importer.ImportRatings();
}
}