/**
 * Project: IT226GroupProject2
 * @author Jarred/Jerry Binder
 * Created Apr 6, 2017 1:40:39 PM
 */
package edu.ilstu.it.swing.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;

import edu.ilstu.it.alarms.AlarmFactory;
import edu.ilstu.it.alarms.AlarmIO;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class AlarmSetup extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldDay;
	private JTextField textFieldMonth;
	private JTextField textFieldYear;
	private JTextField textFieldHour;
	private JTextField textFieldMinute;
	private JTextField textFieldMessage;
	
	Calendar cal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AlarmSetup dialog = new AlarmSetup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AlarmSetup() {
		// This allows us to get the current time/date
		cal = Calendar.getInstance();
		
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Alarm Setup");
		setBounds(100, 100, 400, 230);
		
		JPanel panelExterior = new JPanel();
		getContentPane().add(panelExterior, BorderLayout.CENTER);
		panelExterior.setLayout(new BoxLayout(panelExterior, BoxLayout.X_AXIS));
		
		JPanel panelInterior = new JPanel();
		panelExterior.add(panelInterior);
		panelInterior.setLayout(null);
		
		JPanel panelRadio = new JPanel();
		panelRadio.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRadio.setBounds(224, 73, 150, 47);
		panelInterior.add(panelRadio);
		panelRadio.setLayout(null);
		
		JRadioButton radioAm = new JRadioButton("AM");
		radioAm.setSelected(true);
		radioAm.setBounds(6, 7, 74, 33);
		panelRadio.add(radioAm);
		
		JRadioButton radioPm = new JRadioButton("PM");
		radioPm.setBounds(82, 7, 62, 33);
		panelRadio.add(radioPm);
		
		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(radioAm);
		radioButtonGroup.add(radioPm);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Nothing happens if you don't at least have hour and minute filled out.
				// If that's the case, it'll assume the current date for the other fields.
				if(!textFieldHour.getText().isEmpty() && !textFieldMinute.getText().isEmpty()){
					int day = (textFieldDay.getText().isEmpty()) ? cal.get(Calendar.DAY_OF_MONTH) : Integer.parseInt(textFieldDay.getText());
					int month = (textFieldMonth.getText().isEmpty()) ? cal.get(Calendar.MONTH)+1 : Integer.parseInt(textFieldMonth.getText());
					int year = (textFieldYear.getText().isEmpty()) ? cal.get(Calendar.YEAR) : Integer.parseInt(textFieldYear.getText());
					int hour = Integer.parseInt(textFieldHour.getText());
					String amPm = (radioAm.isSelected()) ? "AM" : "PM";
							
					// this puts it in this DateFormat: "MM d yyyy HH:mm a"
					String rawDate = month + " " + day + " " + year + " " + hour + ":" + textFieldMinute.getText() + " " + amPm;
					
					try {
						AlarmClockFrame.getInstance().addAlarm(AlarmFactory.createAlarm(rawDate, textFieldMessage.getText()));
						AlarmIO.saveAlarms(AlarmClockFrame.getInstance().getAlarms());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
							
					setVisible(false);
					dispose();
				}
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
					
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setBounds(10, 11, 70, 14);
		panelInterior.add(lblDay);
		lblDay.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldDay = new JTextField();
		textFieldDay.setText(""+cal.get(Calendar.DAY_OF_MONTH));
		textFieldDay.setBounds(90, 8, 86, 20);
		panelInterior.add(textFieldDay);
		textFieldDay.setColumns(10);
		
		JLabel lblMonth = new JLabel("Month(#):");
		lblMonth.setBounds(10, 42, 70, 14);
		panelInterior.add(lblMonth);
		lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldMonth = new JTextField();
		textFieldMonth.setText(String.valueOf(cal.get(Calendar.MONTH)+1));	
		// Calendar's month value is indexed and starts at 0, hence the +1
		textFieldMonth.setBounds(90, 39, 86, 20);
		panelInterior.add(textFieldMonth);
		textFieldMonth.setColumns(10);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(10, 73, 70, 14);
		panelInterior.add(lblYear);
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldYear = new JTextField();
		textFieldYear.setText(""+cal.get(Calendar.YEAR));
		textFieldYear.setBounds(90, 70, 86, 20);
		panelInterior.add(textFieldYear);
		textFieldYear.setColumns(10);
		
		JLabel lblHour = new JLabel("Hour:");
		lblHour.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHour.setBounds(186, 11, 92, 14);
		panelInterior.add(lblHour);
		
		textFieldHour = new JTextField();
		textFieldHour.setBounds(288, 8, 86, 20);
		panelInterior.add(textFieldHour);
		textFieldHour.setColumns(10);
		
		JLabel lblMinute = new JLabel("Minute:");
		lblMinute.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMinute.setBounds(186, 42, 92, 14);
		panelInterior.add(lblMinute);
		
		textFieldMinute = new JTextField();
		textFieldMinute.setBounds(288, 39, 86, 20);
		panelInterior.add(textFieldMinute);
		textFieldMinute.setColumns(10);
		
		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMessage.setBounds(10, 134, 70, 14);
		panelInterior.add(lblMessage);
		
		textFieldMessage = new JTextField();
		textFieldMessage.setBounds(90, 131, 284, 20);
		panelInterior.add(textFieldMessage);
		textFieldMessage.setColumns(10);
	}
}
