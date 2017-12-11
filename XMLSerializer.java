package utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Stack;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.Movie;
import models.Rating;
import models.User;

@SuppressWarnings("serial")
public class XMLSerializer implements Serializable {

	@SuppressWarnings("rawtypes")
	private static Stack stack = new Stack();
	private File file;

	public XMLSerializer(File file) {
		this.setFile(file);
	}

	@SuppressWarnings("unchecked")
	public static void push(Object o) {
		stack.push(o);
	}

	public static Object popMovies(Map<Long, Movie> movies) {
		return stack.pop();
	}

	public static Object popUsers(Map<Long, User> users) {
		return stack.pop();
	}

	public static Object popRatings(Map<Long, Rating> ratings) {
		return stack.pop();
	}

	@SuppressWarnings("rawtypes")
	public void read() throws Exception {
		ObjectInputStream is = null;
		try {
			XStream xstream = new XStream(new DomDriver());
			is = xstream.createObjectInputStream(new FileReader("serialisedData.xml"));
			stack = (Stack) is.readObject();
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}

	public static void write() throws Exception {
		ObjectOutputStream os = null;
		try {
			XStream xstream = new XStream(new DomDriver());
			os = xstream.createObjectOutputStream(new FileWriter("serialisedData.xml"));
			os.writeObject(stack);
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}