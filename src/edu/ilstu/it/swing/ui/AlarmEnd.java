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
import edu.ilstu.it.alarms.AlarmFactory;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlarmEnd extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblSnoozedTimes;
	private JLabel lblAlarmDetails;
	private JTextArea textAreaCustomMessage;
	private Alarm alarm;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AlarmEnd dialog = new AlarmEnd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AlarmEnd() {
		setTitle("Alarm - Time's Up!");
		setBounds(100, 100, 484, 163);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		// Plays an alarm clip until the window is closed
		final Clip clip = AlarmClockFrame.getAudioClip();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		lblSnoozedTimes = new JLabel("You've Snoozed This Alarm 0 Times");
		lblSnoozedTimes.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnoozedTimes.setVisible(false);
		contentPanel.add(lblSnoozedTimes, BorderLayout.SOUTH);
		
		
		lblAlarmDetails = new JLabel("This Alarm was set to go off at: ");
		lblAlarmDetails.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblAlarmDetails, BorderLayout.CENTER);
		
		textAreaCustomMessage = new JTextArea();
		textAreaCustomMessage.setEditable(false);
		contentPanel.add(textAreaCustomMessage, BorderLayout.NORTH);
		textAreaCustomMessage.setVisible(false);
		
		// If we want to use a label to display the message instead of a TextArea
//		JLabel lblCustomMessage = new JLabel(alarm.getMessage());
//		lblCustomMessage.setHorizontalAlignment(SwingConstants.CENTER);
//		lblCustomMessage.setVisible(false);
//		contentPanel.add(lblCustomMessage, BorderLayout.NORTH);
//		if(!alarm.getMessage().isEmpty()){
//			lblCustomMessage.setVisible(true);
//		}
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
		JButton btnDismiss = new JButton("Dismiss Alarm");
		btnDismiss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO end alarm, stop sound, remove from alarms.xml
				AlarmFactory.deleteAlarm(alarm);
				clip.close();
				setVisible(false);
				dispose();
			}
		});
		btnDismiss.setActionCommand("OK");
		buttonPane.add(btnDismiss);

		JButton btnSnooze = new JButton("Snooze (1 Minute)");
		btnSnooze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip.close();
				if(AlarmFactory.alarmStorage.contains(alarm))
					AlarmFactory.alarmStorage.get(AlarmFactory.alarmStorage.indexOf(alarm));
				setVisible(false);
				dispose();
			}
		});
		buttonPane.add(btnSnooze);
		getRootPane().setDefaultButton(btnSnooze);
	}
	
	public void displayAlarm(Alarm alarm){
		this.alarm = alarm;
		
		if(alarm.getSnoozeCount() > 0){
			lblSnoozedTimes.setVisible(true);
			lblSnoozedTimes.setText("You've Snoozed This Alarm " + alarm.getSnoozeCount() + " Times");
		}
		
		if(!alarm.getMessage().isEmpty()){
			textAreaCustomMessage.setText("This Alarm was set to go off at: " + alarm.getDate().toString());
			textAreaCustomMessage.setVisible(true);
		}
	}

}
