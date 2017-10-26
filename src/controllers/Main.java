package controllers;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;

import models.User;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import utils.FileSerializer;
import utils.Importer;
import utils.Serializer;
//import utils.Serializer;
import utils.XMLSerializer;

public class Main {

	static FileSerializer serializer = new FileSerializer();

	public static void main(String args[]) throws Exception{

		serializer.SerializeUsers();
		serializer.SerializeMovies();
		serializer.SerializeRatings();

	}
}