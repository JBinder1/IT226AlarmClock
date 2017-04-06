package edu.ilstu.alarms;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class Alarm {

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MM d yyyy HH:mm a");

	private final String rawDate;
	private final Date date;
	private final Optional<String> message;

	public Alarm(final String rawDate) throws ParseException {
		this(rawDate, null);
	}

	public Alarm(final String rawDate, final String message) throws ParseException {
		this.rawDate = rawDate;
		this.date = DATE_FORMAT.parse(rawDate);
		this.message = Optional.ofNullable(message);
	}

	public String getRawDate() {
		return rawDate;
	}

	public Date getDate() {
		return date;
	}

	public Optional<String> getMessage() {
		return message;
	}
}
