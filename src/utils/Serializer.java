package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Serializer {
	public void SerializeUsers() throws IOException
	{
		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("users.xml"));
		out.writeObject(Importer.userMap);
		out.close();
	}
}
