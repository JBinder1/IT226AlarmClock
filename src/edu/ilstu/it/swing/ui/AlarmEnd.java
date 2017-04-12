/**
 * Project: IT226GroupProject2
 * @author Jarred Binder
 * Created Apr 6, 2017 1:40:19 PM
 */
package edu.ilstu.it.swing.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ilstu.it.alarms.Alarm;
import edu.ilstu.it.alarms.AlarmIO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlarmEnd extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblSnoozedTimes;
	private JLabel lblAlarmDetails;
	private JLabel lblCustomMessage;
	private Alarm alarm;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AlarmEnd dialog = new AlarmEnd(new AlarmClockFrame());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AlarmEnd(final AlarmClockFrame frame) {
		alarm = null;
		
		setTitle("Alarm - Time's Up!");
		setBounds(100, 100, 484, 163);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setVisible(true);
		setAlwaysOnTop(true);
		
		
		// Plays an alarm clip until the window is closed
		final Clip clip = AlarmClockFrame.getAudioClip();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		lblSnoozedTimes = new JLabel("You've Snoozed This Alarm 0 Times");
		lblSnoozedTimes.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblSnoozedTimes, BorderLayout.SOUTH);
		
		
		lblAlarmDetails = new JLabel("This Alarm was set to go off at: ");
		lblAlarmDetails.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblAlarmDetails, BorderLayout.CENTER);
		
		// If we want to use a label to display the message instead of a TextArea
		lblCustomMessage = new JLabel();
		lblCustomMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomMessage.setVisible(false);
		contentPanel.add(lblCustomMessage, BorderLayout.NORTH);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
		JButton btnDismiss = new JButton("Dismiss Alarm");
		btnDismiss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.removeAlarm(alarm);
				AlarmIO.saveAlarms(frame.getAlarms());
				clip.close();	// Ends clip playback immediately
				setVisible(false);
				dispose();
			}
		});
		btnDismiss.setActionCommand("OK");
		buttonPane.add(btnDismiss);

		JButton btnSnooze = new JButton("Snooze (1 Minute)");
		btnSnooze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip.close();	// Ends clip playback immediately
				alarm.snooze();
				AlarmIO.saveAlarms(frame.getAlarms());
				setVisible(false);
				dispose();
			}
		});
		buttonPane.add(btnSnooze);
		getRootPane().setDefaultButton(btnSnooze);
	}
	
	public void displayAlarm(Alarm alarm){
		this.alarm = alarm;
		
		lblAlarmDetails.setText("This Alarm was set to go off at: " + alarm.getDate().toString());
		
		if(alarm.getSnoozeCount() > 0){
			lblSnoozedTimes.setText("You've Snoozed This Alarm " + alarm.getSnoozeCount() + " Times");
			lblSnoozedTimes.setVisible(true);
		}
		
		if(!alarm.getMessage().isEmpty()){
			lblCustomMessage.setText(alarm.getMessage());
			lblCustomMessage.setVisible(true);
		}
	}

}