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

public class Sorter{
	
	Importer importer = new Importer();
	public static LinkedHashMap<Long, Movie> sortedMovieMap = new LinkedHashMap<>();
	public static LinkedHashMap<Long, User> sortedUserMap = new LinkedHashMap<>();
	
	public void sortMovies()
	{
		System.out.println("in sortmovies");
		Set<Entry<Long,Movie>> entries = importer.movieMap.entrySet();
		
		for(Entry<Long,Movie> entry : entries){
			System.out.println(entry.getKey() + "==>" + entry.getValue());		
		}
		
		Comparator<Entry<Long, Movie>> valueComparator = new Comparator<Entry<Long,Movie>>() {
            
            @Override
            public int compare(Entry<Long, Movie> e1, Entry<Long, Movie> e2) {
                Movie v1 = e1.getValue();
                String s1 = v1.title;
                Movie v2 = e2.getValue();
                String s2 = v2.title;
                return s1.compareTo(s2);
            }
        };
        
        // Sort method needs a List, so let's first convert Set to List in Java
        List<Entry<Long, Movie>> listOfEntries = new ArrayList<Entry<Long, Movie>>(entries);
        
        // sorting HashMap by values using comparator
        Collections.sort(listOfEntries, valueComparator);
        
        //LinkedHashMap<Long, Movie> sortedByValue = new LinkedHashMap<Long, Movie>(listOfEntries.size());
        
        //sortedMovieMap.clear();
        // copying entries from List to Map
        for(Entry<Long, Movie> entry : listOfEntries){
           sortedMovieMap.put(entry.getKey(), entry.getValue());
        }
	}
	
	public void sortUsers()
	{
		System.out.println("in sortusers");
		Set<Entry<Long,User>> entries = importer.userMap.entrySet();
		
		for(Entry<Long, User> entry : entries){
			System.out.println(entry.getKey() + "==>" + entry.getValue());		
		}
		
		Comparator<Entry<Long, User>> valueComparator = new Comparator<Entry<Long,User>>() {
            
            @Override
            public int compare(Entry<Long, User> e1, Entry<Long, User> e2) {
                User v1 = e1.getValue();
                String s1 = v1.firstName;
                User v2 = e2.getValue();
                String s2 = v2.firstName;
                return s1.compareTo(s2);
            }
        };
        
        // Sort method needs a List, so let's first convert Set to List in Java
        List<Entry<Long, User>> listOfEntries = new ArrayList<Entry<Long, User>>(entries);
        
        // sorting HashMap by values using comparator
        Collections.sort(listOfEntries, valueComparator);
        
        //LinkedHashMap<Long, User> sortedByValue = new LinkedHashMap<Long, User>(listOfEntries.size());
        
        //sortedMovieMap.clear();
        // copying entries from List to Map
        for(Entry<Long, User> entry : listOfEntries){
           sortedUserMap.put(entry.getKey(), entry.getValue());
        }
	}
}
