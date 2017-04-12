package edu.ilstu.it.alarms;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public final class AlarmFactory {

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MM d yyyy HH:mm a");
	private static ArrayList<Alarm> alarmStorage = new ArrayList<Alarm>();
	
	/*
	 * Alarm Methods
	 */
	
	public static Alarm createAlarm(final long time, final String message) {
		Alarm al = new Alarm(new Date(time), message);
		alarmStorage.add(al);
		return al;
	}

	public static Alarm createAlarm(final long time) {
		return createAlarm(time, null);
	}
	
	/*
	 * Alarm Methods (parsing)
	 */

	public static Alarm createAlarm(final String rawDate, final String message) throws ParseException {
		Alarm al = new Alarm(DATE_FORMAT.parse(rawDate), message);
		alarmStorage.add(al);
		return al;
	}
	
	public static Alarm createAlarm(final String rawDate) throws ParseException {
		return createAlarm(rawDate, null);
	}

	/*
	 * Stopwatch Methods
	 */
	
	public static Alarm createStopwatch(final int delayMinutes, final String message) {
		final Date date = new Date();
		date.setTime(date.getTime() + delayMinutes * 1000 * 60);
		Alarm al = new Alarm(date, message);
		alarmStorage.add(al);
		return al;
	}
	
	public static Alarm createStopwatch(final int delayMinutes) {
		return createAlarm(delayMinutes, null);
	}
}
