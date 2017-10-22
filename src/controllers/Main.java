package controllers;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import models.User;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import utils.Importer;
import utils.Serializer;

public class Main {
	static Driver driver = new Driver();
	static Importer importer = new Importer();
	static Serializer serializer = new Serializer();

	public static void main(String args[]) throws IOException{
		Importer.ImportUsers();
		Importer.ImportMovies();
		Importer.ImportRatings();
		
		//System.out.println("map size before add user" + importer.userMap.size());
		
		driver.addUser("Lionel", "Messi",31l, "M", "Footballer", 220022l);
		
		//System.out.println("map size after add user" + importer.userMap.size());
		
		System.out.println("User hashmap: " + Importer.userMap);
		System.out.println("Movies hashmap: " + Importer.movieMap);
		System.out.println("Rating hashmap: " + Importer.ratingMap);

		serializer.SerializeUsers();
		
		
	}
}