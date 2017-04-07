/**
 * Project: IT226GroupProject2
 * @author Jarred/Jerry Binder
 * Created Apr 7, 2017 2:17:21 PM
 */
package edu.ilstu.it.xml.io;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class XmlInput {
	public static final String DEFAULT_FILENAME = "alarms.xml";
	
	/**
	 * Default constructor. Calls custom filename constructor using default filename.
	 */
	XmlInput(){
		this(DEFAULT_FILENAME);
	}
	
	/**
	 * Custom filename constructor. Opens whatever file is argued.
	 * @param filename
	 */
	XmlInput(String filename){
		File file = new File(filename);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
