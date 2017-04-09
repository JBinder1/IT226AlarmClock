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
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author jarre
 *
 */
public class AlarmSetup extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldDay;
	private JTextField textFieldMonth;
	private JTextField textFieldYear;
	private JTextField textFieldHour;
	private JTextField textFieldMinute;

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
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Alarm Setup");
		setBounds(100, 100, 400, 200);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(null);
		{
			JLabel lblDay = new JLabel("Day:");
			lblDay.setBounds(10, 11, 70, 14);
			panel_1.add(lblDay);
			lblDay.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		
		textFieldDay = new JTextField();
		textFieldDay.setBounds(90, 8, 86, 20);
		panel_1.add(textFieldDay);
		textFieldDay.setColumns(10);
		{
			JLabel lblMonth = new JLabel("Month(#):");
			lblMonth.setBounds(10, 42, 70, 14);
			panel_1.add(lblMonth);
			lblMonth.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		
		textFieldMonth = new JTextField();
		textFieldMonth.setBounds(90, 39, 86, 20);
		panel_1.add(textFieldMonth);
		textFieldMonth.setColumns(10);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(10, 73, 70, 14);
		panel_1.add(lblYear);
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldYear = new JTextField();
		textFieldYear.setBounds(90, 70, 86, 20);
		panel_1.add(textFieldYear);
		textFieldYear.setColumns(10);
		
		JPanel panelRadio = new JPanel();
		panelRadio.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRadio.setBounds(224, 73, 150, 47);
		panel_1.add(panelRadio);
		panelRadio.setLayout(null);
		
		JRadioButton rdbtnAm = new JRadioButton("AM");
		rdbtnAm.setBounds(6, 7, 74, 33);
		panelRadio.add(rdbtnAm);
		
		JRadioButton rdbtnPm = new JRadioButton("PM");
		rdbtnPm.setBounds(82, 7, 62, 33);
		panelRadio.add(rdbtnPm);
		{
			textFieldHour = new JTextField();
			textFieldHour.setBounds(288, 8, 86, 20);
			panel_1.add(textFieldHour);
			textFieldHour.setColumns(10);
		}
		{
			textFieldMinute = new JTextField();
			textFieldMinute.setBounds(288, 39, 86, 20);
			panel_1.add(textFieldMinute);
			textFieldMinute.setColumns(10);
		}
		
		JLabel lblHour = new JLabel("Hour:");
		lblHour.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHour.setBounds(186, 11, 92, 14);
		panel_1.add(lblHour);
		
		JLabel lblMinute = new JLabel("Minute:");
		lblMinute.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMinute.setBounds(186, 42, 92, 14);
		panel_1.add(lblMinute);
	}
}
