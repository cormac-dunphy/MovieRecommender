package controllers;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;

import models.User;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import utils.Importer;

import utils.Sorter;


public class Main {

	public static Menu menu = new Menu();
	public static Sorter sorter = new Sorter();

	//runs the program
	public static void main(String args[]) throws Exception
	{
		Importer.ImportUsers();
		sorter.sortUsers();
		Importer.ImportMovies();
		sorter.sortMovies();
		Importer.ImportRatings();	
		menu.menu();
	}
}