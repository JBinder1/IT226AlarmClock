/**
 * Project: IT226GroupProject2
 * @author Jarred/Jerry Binder
 * Created Apr 6, 2017 1:40:54 PM
 */
package edu.ilstu.it.swing.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ilstu.it.alarms.AlarmFactory;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StopwatchSetup extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMinutes;
	private JTextField textFieldCustomMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try{
			StopwatchSetup dialog = new StopwatchSetup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StopwatchSetup() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Stopwatch Setup");
		setBounds(100, 100, 550, 148);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAlarmTimein = new JLabel("Stopwatch Time (in minutes):");
			lblAlarmTimein.setBounds(14, 13, 170, 14);
			lblAlarmTimein.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblAlarmTimein);
		}
		{
			textFieldMinutes = new JTextField();
			textFieldMinutes.setBounds(194, 10, 111, 20);
			contentPanel.add(textFieldMinutes);
			textFieldMinutes.setColumns(15);
		}
		{
			JLabel lblCustomMessage = new JLabel("Custom Message (optional):");
			lblCustomMessage.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCustomMessage.setBounds(14, 44, 170, 14);
			contentPanel.add(lblCustomMessage);
		}
		{
			textFieldCustomMessage = new JTextField();
			textFieldCustomMessage.setBounds(194, 41, 330, 20);
			contentPanel.add(textFieldCustomMessage);
			textFieldCustomMessage.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// User can submit this without a message, but they must have something in minutes
						if(!textFieldMinutes.getText().isEmpty()){
							// TODO have this createAlarm call put alarms wherever alarms go
							try{
								AlarmFactory.createAlarm(Integer.parseInt(textFieldMinutes.getText()), textFieldCustomMessage.getText());
							}catch(Exception e){ e.printStackTrace(); }
							
							setVisible(false);
							dispose();
						}
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
