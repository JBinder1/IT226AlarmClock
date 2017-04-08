package edu.ilstu.it.alarms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Optional;

import javax.sound.sampled.Clip;
import javax.swing.Timer;

import edu.ilstu.it.swing.ui.AlarmClockFrame;

public final class Alarm {

	private final Date date;
	private final Optional<String> message;

	private Timer timer;
	private int snoozeCount = 0;

	Alarm(final Date date) {
		this(date, null);
	}

	Alarm(final Date date, final String message) {
		this.date = date;
		this.message = Optional.ofNullable(message);
	}

	public void startTimer() {
		timer = new Timer((int) (date.getTime() - new Date().getTime()), new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				final Clip clip = AlarmClockFrame.getAudioClip();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				// TODO: Swing alert box
				// Create the swing alert box according to isSnoozed():
				// 		if isSnoozed() == true should display snoozeCount on the alert box
				// When it is dismissed it should stop the clip and save the new list of alarms (with the current one removed)
			}
		});
		timer.start();
	}

	public void snooze() {
		snoozeCount++;
		date.setTime(date.getTime() + 1000 * 60); // Adds a minute to the date
		startTimer();
	}

	public int getSnoozeCount() {
		return snoozeCount;
	}

	public boolean isSnoozed() {
		return getSnoozeCount() > 0;
	}

	public Date getDate() {
		return date;
	}

	public Optional<String> getMessage() {
		return message;
	}

	public Timer getTimer() {
		return timer;
	}
}
