package edu.ilstu.it.alarms;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * An Alarm factory class which creates new alarm instances.
 */
public final class AlarmFactory {

	/**
	 * The date format that is used to convert a string to Date instance.
	 */
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MM d yyyy HH:mm a");

	/**
	 * Creates an alarm that goes off at the specified epoch time and with the specified message.
	 * @param time The time
	 * @param message The message.
	 * @return The created Alarm instance.
	 */
	public static Alarm createAlarm(final long time, final String message) {
		return new Alarm(new Date(time), message);
	}

	/**
	 * Creates an alarm that goes off at the specified epoch time and null message.
	 * @param time The time
	 * @return The created Alarm instance.
	 */
	public static Alarm createAlarm(final long time) {
		return createAlarm(time, null);
	}

	/**
	 * Creates an alarm that goes off at the specified string date and with the specified message.
	 * @param rawDate The raw date.
	 * @param message The message.
	 * @return The created Alarm instance.
	 * @throws ParseException If the string is not a valid date.
	 */
	public static Alarm createAlarm(final String rawDate, final String message) throws ParseException {
		return new Alarm(DATE_FORMAT.parse(rawDate), message);
	}

	/**
	 * Creates an alarm that goes off at the specified string date and null message.
	 * @param rawDate The raw date.
	 * @return The created Alarm instance.
	 * @throws ParseException If the string is not a valid date.
	 */
	public static Alarm createAlarm(final String rawDate) throws ParseException {
		return createAlarm(rawDate, null);
	}


	/**
	 * Creates an alarm that goes off after the specified amount of minutes and with the specified message.
	 * @param delayMinutes The delay in minutes.
	 * @param message The message.
	 * @return The created Alarm instance.
	 */
	public static Alarm createAlarm(final int delayMinutes, final String message) {
		final Date date = new Date();
		date.setTime(date.getTime() + delayMinutes * 1000 * 60);
		return new Alarm(date, message);
	}

	/**
	 * Creates an alarm that goes off after the specified amount of minutes and null message.
	 * @param delayMinutes The delay in minutes.
	 * @return The created Alarm instance.
	 */
	public static Alarm createAlarm(final int delayMinutes) {
		return createAlarm(delayMinutes, null);
	}
}
