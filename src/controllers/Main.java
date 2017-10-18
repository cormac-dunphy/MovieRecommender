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
	//public static long id = Importer.id;
	static Driver driver = new Driver();
	static Importer importer = new Importer();
	static Serializer serializer = new Serializer();
	public static void main(String args[]) throws IOException{
		Importer.ImportUsers();
		Importer.ImportMovies();
		Importer.ImportRatings();
		System.out.println("User hashmap: " + Importer.userMap);
		System.out.println("Movies hashmap: " + Importer.movieMap);
		System.out.println("Rating hashmap: " + Importer.ratingMap);
		
		serializer.Serialize();
	}
}