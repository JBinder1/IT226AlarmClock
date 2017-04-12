package edu.ilstu.it.alarms;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * A class which handles the input and output of Alarms.
 */
public final class AlarmIO {

	/**
	 * The path the alarms are loaded and saved from.
	 */
	private static final String PATH = "alarms.xml";

	/**
	 * Loads alarms from the constant PATH, creating a new dummy XML is the PATH doesn't exist.
	 * @return The loaded alarms.
	 */
	public static List<Alarm> loadAlarms() {
		try {
			final JAXBContext jaxbContext = JAXBContext.newInstance(Alarms.class);
			final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			final File file = new File(PATH);
			if (!file.exists() && file.createNewFile())
				try (final BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
					writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<alarms/>\n\n");
				}
			final Alarms alarms = (Alarms) jaxbUnmarshaller.unmarshal(file);
			return alarms.getAlarms();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	/**
	 * Saves the specified alarms to the constant PATH.
	 */
	public static void saveAlarms(final List<Alarm> alarms) {
		try {
			final File file = new File(PATH);
			final JAXBContext context = JAXBContext.newInstance(Alarms.class);
			final Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(new Alarms(alarms), file);
		} catch (final JAXBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * A dummy class used by JAXB for XML input/output.
	 */
	@XmlRootElement(name = "alarms")
	@XmlAccessorType(XmlAccessType.FIELD)
	private static class Alarms {
		@XmlElement(name = "alarm")
		private List<Alarm> alarms = null;

		public Alarms() {
		}

		public Alarms(List<Alarm> alarms) {
			this.alarms = alarms;
		}

		public List<Alarm> getAlarms() {
			return alarms;
		}
	}
}
