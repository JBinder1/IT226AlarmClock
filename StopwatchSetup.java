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
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author jarre
 *
 */
public class StopwatchSetup extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMinutes;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StopwatchSetup dialog = new StopwatchSetup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StopwatchSetup() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Stopwatch Setup");
		setBounds(100, 100, 434, 148);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAlarmTimein = new JLabel("Stopwatch Time (in minutes):");
			lblAlarmTimein.setBounds(14, 13, 139, 14);
			lblAlarmTimein.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblAlarmTimein);
		}
		{
			textFieldMinutes = new JTextField();
			textFieldMinutes.setBounds(156, 10, 90, 20);
			contentPanel.add(textFieldMinutes);
			textFieldMinutes.setColumns(15);
		}
		{
			JLabel lblCustomMessageoptional = new JLabel("Custom Message (Optional):");
			lblCustomMessageoptional.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCustomMessageoptional.setBounds(12, 44, 141, 14);
			contentPanel.add(lblCustomMessageoptional);
		}
		{
			textField = new JTextField();
			textField.setBounds(156, 41, 250, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// TODO have this create a new stopwatch with the # of minutes entered
						// TODO and then close this window
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
