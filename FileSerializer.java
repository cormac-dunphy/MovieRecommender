package utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.Movie;
import models.Rating;
import models.User;
import controllers.Driver;

public class FileSerializer {
	
	static XStream xstream = new XStream(new DomDriver());
	
	public static void serializeFiles(HashMap<Long, Movie> movies, HashMap<Long, User> users, HashMap<Long, Rating> ratings) throws Exception
	{
		XMLSerializer.push(movies);
		//System.out.println(movies);
		XMLSerializer.push(users);
		//System.out.println(users);
		XMLSerializer.push(ratings);
		//System.out.println(ratings);
	}
}
