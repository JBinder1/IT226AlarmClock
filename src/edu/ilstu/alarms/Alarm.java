package edu.ilstu.alarms;

import java.util.Date;
import java.util.Optional;

public final class Alarm {

	private final Date date;
	private final Optional<String> message;

	Alarm(final Date date) {
		this(date, null);
	}

	Alarm(final Date date, final String message) {
		this.date = date;
		this.message = Optional.ofNullable(message);
	}

	public Date getDate() {
		return date;
	}

	public Optional<String> getMessage() {
		return message;
	}
}
