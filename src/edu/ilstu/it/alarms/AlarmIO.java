package edu.ilstu.it.alarms;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class AlarmIO {

	private static final String PATH = "alarms.xml";

	public static void main(final String[] args) throws InterruptedException {
		List<Alarm> alarms = new ArrayList<>();
		alarms.add(AlarmFactory.createAlarm(1, "Alarm one!"));
		alarms.add(AlarmFactory.createAlarm(2));
		
		saveAlarms(alarms);
		
		alarms = loadAlarms();
		for (final Alarm alarm : alarms)
			alarm.startTimer();

		for (;;)
			Thread.sleep(100);
	}

	public static List<Alarm> loadAlarms() {
		try {
			final JAXBContext jaxbContext = JAXBContext.newInstance(Alarms.class);
			final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			final Alarms alarms = (Alarms) jaxbUnmarshaller.unmarshal( new File(PATH) );
			return alarms.getAlarms();
		} catch (final JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	// TODO: remember to save to file after each new alarm is made
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
