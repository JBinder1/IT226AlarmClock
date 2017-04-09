/**
 * Project: IT226GroupProject2
 * @author Jarred Binder
 * Created Apr 6, 2017 12:19:38 PM
 */
package edu.ilstu.it.swing.ui;

import java.awt.EventQueue;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Font;
import javax.swing.Timer;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;

public class AlarmClockFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlarmClockFrame frame = new AlarmClockFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlarmClockFrame() {
		setTitle("Alarm Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Label labelCurrentTime = new Label("Jan 1 1970 00:00:00 AM");
		contentPane.add(labelCurrentTime, BorderLayout.NORTH);
		labelCurrentTime.setFont(new Font("Dialog", Font.PLAIN, 40));
		labelCurrentTime.setAlignment(Label.CENTER);
		this.startClock(labelCurrentTime);
		
		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new BorderLayout(0, 0));
		
		JButton btnCreateNewAlarm = new JButton("Create New Alarm");
		panelButtons.add(btnCreateNewAlarm);
		
		JButton btnCreateNewStopwatch = new JButton("Create New Stopwatch");
		panelButtons.add(btnCreateNewStopwatch, BorderLayout.NORTH);
		
		JButton btnExit = new JButton("Exit");
		panelButtons.add(btnExit, BorderLayout.SOUTH);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCreateNewStopwatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StopwatchSetup().setVisible(true);
			}
		});
		btnCreateNewAlarm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AlarmSetup().setVisible(true);
			}
		});
	}

	private static final String AUDIO_CLIP_PATH = "air_horn.wav";

	public static Clip getAudioClip() {
		try {
	        final AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(AUDIO_CLIP_PATH).getAbsoluteFile());
	        final Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        return clip;
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    }
		return null;
	}
	
	/**
	 * Initializes the clock at the top of this JFrame that displays current time.
	 * This uses a Timer to update it every second with the current time.
	 * @param labelCurrentTime
	 */
	private void startClock(Label labelCurrentTime){
		// Sets up a label that displays current time, and refreshes every second.
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				labelCurrentTime.setText(DateFormat.getDateTimeInstance().format(new Date()));
			}
		});
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.setInitialDelay(0);
		timer.start();
	}
}
