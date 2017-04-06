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
import javax.swing.JLabel;

/**
 * @author jarre
 *
 */
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
		setTitle("Alarm");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblSnoozedTimes = new JLabel("You've Snoozed This Alarm 0 Times");
			contentPanel.add(lblSnoozedTimes);
		}
		{
			JLabel lblCustomMessage = new JLabel("Custom Message");
			contentPanel.add(lblCustomMessage);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnDismiss = new JButton("Dismiss Alarm");
				btnDismiss.setActionCommand("OK");
				buttonPane.add(btnDismiss);
				getRootPane().setDefaultButton(btnDismiss);
			}
			{
				JButton btnSnooze = new JButton("Snooze (1 Minute)");
				buttonPane.add(btnSnooze);
			}
		}
	}

}
