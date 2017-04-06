package edu.ilstu.alarms;

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
				// Swing alert box should stop the clip and save the new list of alarms (with the current one removed)
			}
		});
		timer.start();
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
