package utils;

import java.util.Map.Entry;
import java.util.Set;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;








import models.Movie;
import models.User;
//final
public class Sorter{

	Importer importer = new Importer();
	public static LinkedHashMap<Long, Movie> sortedMovieMap = new LinkedHashMap<>();
	public static LinkedHashMap<Long, User> sortedUserMap = new LinkedHashMap<>();

	public void sortMovies()
	{
		//create a set of the values in moviemap
		Set<Entry<Long,Movie>> entries = importer.movieMap.entrySet();

		Comparator<Entry<Long, Movie>> valueComparator = new Comparator<Entry<Long,Movie>>() {

			@Override
			public int compare(Entry<Long, Movie> e1, Entry<Long, Movie> e2) {
				//v1 is the value of e1
				Movie v1 = e1.getValue();
				//s1 is the title of v1
				String s1 = v1.title;
				//v2 is the value of e2
				Movie v2 = e2.getValue();
				//s2 is the title of v2
				String s2 = v2.title;
				return s1.compareTo(s2);
			}
		};

		// Sort method needs a List, so convert set to list
		List<Entry<Long, Movie>> listOfEntries = new ArrayList<Entry<Long, Movie>>(entries);

		// sorting HashMap by values using comparator
		Collections.sort(listOfEntries, valueComparator);

		// copying entries from List to Map
		for(Entry<Long, Movie> entry : listOfEntries){
			sortedMovieMap.put(entry.getKey(), entry.getValue());
		}
	}

	public void sortUsers()
	{
		//create a set of values of userMap
		Set<Entry<Long,User>> entries = importer.userMap.entrySet();

		Comparator<Entry<Long, User>> valueComparator = new Comparator<Entry<Long,User>>() {

			@Override
			public int compare(Entry<Long, User> e1, Entry<Long, User> e2) {
				//v1 is the value in e1
				User v1 = e1.getValue();
				//s1 is the first name in v1
				String s1 = v1.firstName;
				//v2 is the value in e2
				User v2 = e2.getValue();
				//s2 is the first name in v2
				String s2 = v2.firstName;
				return s1.compareTo(s2);
			}
		};

		// Sort method needs a List, so let's first convert Set to List in Java
		List<Entry<Long, User>> listOfEntries = new ArrayList<Entry<Long, User>>(entries);

		// sorting HashMap by values using comparator
		Collections.sort(listOfEntries, valueComparator);

		// copying entries from List to Map
		for(Entry<Long, User> entry : listOfEntries){
			sortedUserMap.put(entry.getKey(), entry.getValue());
		}
	}
}
