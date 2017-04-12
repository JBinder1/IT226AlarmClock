/**
 * Alarm
 * Project: IT226GroupProject2
 * 
 * Object containing the Date, message, and 
 * snooze count of an alarm. Also contains
 * the Timer that sets the alarm off at the 
 * time it's set for.
 * 
 * @author Ryan Greene
 */
package edu.ilstu.it.alarms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;
import javax.xml.bind.annotation.*;

import edu.ilstu.it.swing.ui.AlarmClockFrame;
import edu.ilstu.it.swing.ui.AlarmEnd;

/**
 * A class that holds the data for an alarm and handles the timer and snoozing of the alarm.
 */
@XmlRootElement(name = "alarm")
public final class Alarm {

	/**
	 * The date the alarm goes off.
	 */
	@XmlAttribute
	private Date date;
	/**
	 * The message of the alarm (possible null)
	 */
	@XmlElement
	private String message;

	/**
	 * The timer that goes off once the date is reached.
	 */
	private Timer timer;

	/**
	 * The amount of times the alarm has been snoozed.
	 */
	private int snoozeCount = 0;

	/**
	 * Default constructor for JAXB.
	 */
	Alarm(){
		
	}

	/**
	 * Constructs a new alarm instance with the specified date and message.
	 * @param date The date the alarm goes off.
	 * @param message The message of the alarm.
	 */
	Alarm(final Date date, final String message) {
		this.date = date;
		this.message = message;
		startTimer();
	}

	/**
	 * Starts the alarm's timer to go off at the date.
	 */
	public void startTimer() {
		timer = new Timer((int) (date.getTime() - new Date().getTime()), new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				AlarmEnd end = new AlarmEnd(AlarmClockFrame.getInstance());
				end.displayAlarm(Alarm.this);
			}
		});
		timer.setRepeats(false);
		timer.setCoalesce(true);
		timer.start();
	}

	/**
	 * Snoozes the alarm, incrementing snoozeCount, incrementing the date by a minute, and restarting the timer.
	 */
	public void snooze() {
		snoozeCount++;
		if (date.getTime() - new Date().getTime() < 0)
			date = new Date();
		date.setTime(date.getTime() + 1000 * 60); // Adds a minute to the date
		startTimer();
	}

	/**
	 * Gets the date the alarm goes off.
	 * @return The date.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Gets the message of the alarm.
	 * @return The message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the amount of times the alarm has been snoozed.
	 * @return The snooze count.
	 */
	public int getSnoozeCount() {
		return snoozeCount;
	}

	/**
	 * Gets whether or not the alarm has been snoozed.
	 * @return Whether or not the alarm has been snoozed.
	 */
	public boolean isSnoozed() {
		return getSnoozeCount() > 0;
	}

	/**
	 * Gets the timer of when the alarm goes off.
	 * @return The timer.
	 */
	public Timer getTimer() {
		return timer;
	}

	@Override
	public String toString() {
		return "" + date.toString() + "\n" + message;
	}
}
