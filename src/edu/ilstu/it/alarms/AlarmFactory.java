package edu.ilstu.it.alarms;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class AlarmFactory {

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MM d yyyy HH:mm a");

	private AlarmFactory() {
		
	}

	public static Alarm createAlarm(final long time) {
		return createAlarm(time, null);
	}

	public static Alarm createAlarm(final long time, final String message) {
		return new Alarm(new Date(time), message);
	}

	public static Alarm createAlarm(final int delayMinutes) {
		return createAlarm(delayMinutes, null);
	}

	public static Alarm createAlarm(final int delayMinutes, final String message) {
		final Date date = new Date();
		date.setTime(date.getTime() + delayMinutes * 1000 * 60);
		return new Alarm(date, message);
	}

	public static Alarm createAlarm(final String rawDate) throws ParseException {
		return createAlarm(rawDate, null);
	}

	public static Alarm createAlarm(final String rawDate, final String message) throws ParseException {
		return new Alarm(DATE_FORMAT.parse(rawDate), message);
	}
}
