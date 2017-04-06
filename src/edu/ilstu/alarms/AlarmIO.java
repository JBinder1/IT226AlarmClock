package edu.ilstu.alarms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class AlarmIO {

	private static final String PATH = "alarms.csv";

	public static List<Alarm> loadAlarms() {
		final List<Alarm> alarms = new ArrayList<>();
		try {
			final List<String> lines = Files.readAllLines(Paths.get(PATH));
			for (final String line : lines) {
				final String[] split = line.split(",");
				final long time = Long.parseLong(split[0]);
				alarms.add(split.length == 1 ? AlarmFactory.createAlarm(time) : AlarmFactory.createAlarm(time, split[1]));
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return alarms;
	}

	// TODO: remember to save to file after each new alarm is made
	public static void saveAlarms(final List<Alarm> alarms) {
		final List<String> lines = new ArrayList<>();
		for (final Alarm alarm : alarms) {
			final StringBuilder builder = new StringBuilder();
			builder.append(alarm.getDate().getTime());
			if (alarm.getMessage().isPresent())
				builder.append(',').append(alarm.getMessage().get());
			lines.add(builder.toString());
		}
	}
}
