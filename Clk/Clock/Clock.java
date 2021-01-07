package Clock;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;

public class Clock {

	private JFrame frame;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clock window = new Clock();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
		
	}

	/**
	 * Create the application.
	 */
	public Clock() {
		initialize();
		setTime();
	}
	
	public void setTime() {
		Thread th = new Thread() {
			public void run() {
				try {
					while(true) {
						Calendar cl= new GregorianCalendar();
						int hr = cl.get(Calendar.HOUR);
						int min = cl.get(Calendar.MINUTE);
						int sec = cl.get(Calendar.SECOND);
						int am_pm = cl.get(Calendar.AM_PM);
						String d_n = "";
						if(am_pm==1) d_n="PM";
						else d_n="AM";
						
						 lblNewLabel_1.setText(hr+" : "+min+" : "+sec+" "+d_n);
						 sleep(1000);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		th.start();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		
		btnNewButton = new JButton("X");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(243, 0, 57, 32);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Clock");
		lblNewLabel.setFont(new Font("Orbitron", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 102, 51));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 31, 264, 51);
		frame.getContentPane().add(lblNewLabel);
		
	    lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Russo One", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(10, 70, 285, 80);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		
		frame.setUndecorated(true);
		frame.setSize(300,150);
		frame.setLocationRelativeTo(null);
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
