/**
 * Project: IT226GroupProject2
 * @author Jarred/Jerry Binder
 * Created Apr 6, 2017 1:40:19 PM
 */
package edu.ilstu.it.swing.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ilstu.it.alarms.Alarm;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlarmEnd extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

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
		
		JLabel lblSnoozedTimes = new JLabel("You've Snoozed This Alarm " + alarm.getSnoozeCount() + " Times");
		lblSnoozedTimes.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnoozedTimes.setVisible(false);
		contentPanel.add(lblSnoozedTimes, BorderLayout.SOUTH);
		if(alarm.getSnoozeCount() > 0){
			lblSnoozedTimes.setVisible(true);
		}
		
		JLabel lblAlarmDetails = new JLabel("This Alarm was set to go off at: " + alarm.getDate().toString());
		lblAlarmDetails.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblAlarmDetails, BorderLayout.CENTER);
		
		JTextArea textAreaCustomMessage = new JTextArea(alarm.getMessage());
		textAreaCustomMessage.setEditable(false);
		contentPanel.add(textAreaCustomMessage, BorderLayout.NORTH);
		textAreaCustomMessage.setVisible(false);
		if(!alarm.getMessage().isEmpty()){
			textAreaCustomMessage.setVisible(true);
		}
		
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
				// TODO end alarm, stop sound, remove from alarm storage, close this window
			}
		});
		btnDismiss.setActionCommand("OK");
		buttonPane.add(btnDismiss);

		JButton btnSnooze = new JButton("Snooze (1 Minute)");
		btnSnooze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO add to the alarm's snoozed counter, hide/close this window and pause sound for 1 minute via timer
			}
		});
		buttonPane.add(btnSnooze);
		getRootPane().setDefaultButton(btnSnooze);
	}

}
