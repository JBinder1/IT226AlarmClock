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
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		setBounds(100, 100, 450, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		Label labelCurrentTime = new Label("00:00:00 AM");
		contentPane.add(labelCurrentTime);
		labelCurrentTime.setFont(new Font("Dialog", Font.PLAIN, 40));
		labelCurrentTime.setAlignment(Label.CENTER);
		
		// Sets up a label that displays current time, and refreshes every second.
		Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	labelCurrentTime.setText(DateFormat.getDateTimeInstance().format(new Date()));
            }
        });
		timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(1000);
        timer.start();
		
		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons);
		
		JButton btnCreateNewAlarm = new JButton("Create New Alarm");
		btnCreateNewAlarm.setBounds(10, 0, 125, 23);
		btnCreateNewAlarm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO have this open an AlarmSetup
			}
		});
		panelButtons.setLayout(null);
		panelButtons.add(btnCreateNewAlarm);
		
		JButton btnCreateNewStopwatch = new JButton("Create New Stopwatch");
		btnCreateNewStopwatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreateNewStopwatch.setBounds(20, 34, 150, 23);
		btnCreateNewStopwatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO have this open a StopwatchSetup
			}
		});
		panelButtons.add(btnCreateNewStopwatch);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(27, 73, 89, 23);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panelButtons.add(btnExit);
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
}
