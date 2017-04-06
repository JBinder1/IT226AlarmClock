package edu.ilstu.alarms;

import java.util.Optional;

public class Alarm {

	private final String rawDate;
	private final Optional<String> message;

	public Alarm(final String rawDate) {
		this(rawDate, null);
	}

	public Alarm(final String rawDate, final String message) {
		this.rawDate = rawDate;
		this.message = Optional.ofNullable(message);
	}

	public String getRawDate() {
		return rawDate;
	}

	public Optional<String> getMessage() {
		return message;
	}
}
