/**
 * Project: IT226GroupProject2
 * @author Jarred Binder
 * Created Apr 6, 2017 12:19:38 PM
 */
package edu.ilstu.it.swing.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AlarmClockFrame extends JFrame {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
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
