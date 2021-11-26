package GuiSwing2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LoginAs {

	private JFrame frmLoginAs;
	private final ButtonGroup bg = new ButtonGroup();
	private JPanel Title;
	static String titleForLogin;
	static String usertype;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAs window = new LoginAs();
					window.frmLoginAs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	

	/**
	 * Initialize the contents of the frame.
	 */
	public LoginAs() {
		frmLoginAs = new JFrame();
		frmLoginAs.getContentPane().setBackground(Color.WHITE);
		frmLoginAs.setTitle("Login As");
		frmLoginAs.setBounds(100, 100, 1039, 602);
		frmLoginAs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginAs.getContentPane().setLayout(null);
		frmLoginAs.setVisible(true);
		frmLoginAs.setResizable(false);
		frmLoginAs.setLocationRelativeTo(null);
		
		Title = new JPanel();
		Title.setBackground(new Color(255, 250, 205));
		Title.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Title.setBounds(10, 10, 1005, 87);
		frmLoginAs.getContentPane().add(Title);
		Title.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(10, 10, 66, 67);
		Title.add(logo);
		logo.setIcon(new ImageIcon(LoginAs.class.getResource("/GuiSwing2/logo.jpg")));
		
		JLabel greet = new JLabel("K.C.Gandhi English School");
		greet.setBounds(0, 0, 1005, 87);
		Title.add(greet);
		greet.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		greet.setForeground(new Color(139, 0, 0));
		greet.setHorizontalAlignment(SwingConstants.CENTER);
		greet.setBackground(Color.WHITE);
		greet.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel logo_1 = new JLabel("");
		logo_1.setIcon(new ImageIcon(LoginAs.class.getResource("/GuiSwing2/Imgs/sun.jpeg")));
		logo_1.setBounds(929, 10, 66, 67);
		Title.add(logo_1);
		
		JPanel LogRadioPanel = new JPanel();
		LogRadioPanel.setBackground(new Color(255, 99, 71));
		LogRadioPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		LogRadioPanel.setBounds(10, 492, 856, 66);
		frmLoginAs.getContentPane().add(LogRadioPanel);
		LogRadioPanel.setLayout(null);
		
		JRadioButton teacher = new JRadioButton("Teacher");
		teacher.setHorizontalAlignment(SwingConstants.CENTER);
		teacher.setIcon(null);
		teacher.setFocusable(false);
		teacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				titleForLogin="Teacher Login";
				usertype="teacher";
				
			}
		});
		teacher.setBounds(180, 6, 171, 51);
		LogRadioPanel.add(teacher);
		teacher.setForeground(Color.WHITE);
		teacher.setBackground(new Color(255, 99, 71));
		bg.add(teacher);
		teacher.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JRadioButton student = new JRadioButton("Student");
		student.setHorizontalAlignment(SwingConstants.CENTER);
		student.setIcon(null);
		student.setFocusable(false);
		student.setForeground(Color.WHITE);
		
		student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				titleForLogin="Student Login";
				usertype="student";
			
			}
		});
		student.setBounds(420, 6, 155, 50);
		LogRadioPanel.add(student);
	
		student.setBackground(new Color(255, 99, 71));
		bg.add(student);
		student.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JRadioButton admin = new JRadioButton("Admin");
		admin.setIcon(null);
		admin.setHorizontalAlignment(SwingConstants.CENTER);
		admin.setFocusable(false);
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				titleForLogin="Admin Login";
				usertype="admin";
				
			
			}
		});
		admin.setBounds(602, 6, 213, 50);
		LogRadioPanel.add(admin);
		admin.setForeground(Color.WHITE);
		admin.setBackground(new Color(255, 99, 71));
		bg.add(admin);
		admin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel Loginas = new JLabel("Login As :");
		Loginas.setBackground(new Color(106, 90, 205));
		Loginas.setBounds(44, 9, 130, 42);
		LogRadioPanel.add(Loginas);
		Loginas.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JButton proceed = new JButton("Proceed");
		proceed.setFocusable(false);
		proceed.setForeground(Color.BLACK);
		proceed.setBackground(new Color(144, 238, 144));
		proceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			
					new Login(usertype);
					frmLoginAs.setVisible(false);
					
			}
		});
		proceed.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		proceed.setBounds(876, 492, 139, 66);
		frmLoginAs.getContentPane().add(proceed);
		
		JLabel schoolImg = new JLabel("");
		schoolImg.setBounds(10, 102, 523, 380);
		frmLoginAs.getContentPane().add(schoolImg);
		schoolImg.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		ImageIcon icon = new ImageIcon(LoginAs.class.getResource("/GuiSwing2/school.png"));
    	Image image = icon.getImage();
    	Image imgscale = image.getScaledInstance(schoolImg.getWidth(),schoolImg.getHeight(),Image.SCALE_SMOOTH);
    	ImageIcon scaledicon = new ImageIcon(imgscale);
	schoolImg.setIcon(scaledicon);
	
	JPanel panel = new JPanel();
	panel.setBackground(new Color(60, 179, 113));
	panel.setBounds(543, 103, 472, 42);
	frmLoginAs.getContentPane().add(panel);
	panel.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("About us");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 29));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(10, 10, 452, 22);
	panel.add(lblNewLabel);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(543, 155, 472, 326);
	frmLoginAs.getContentPane().add(scrollPane);
	
	JTextArea txtrTheCollegeWas = new JTextArea();
	txtrTheCollegeWas.setWrapStyleWord(true);
	txtrTheCollegeWas.setEditable(false);
	txtrTheCollegeWas.setFocusable(false);
	scrollPane.setViewportView(txtrTheCollegeWas);
	txtrTheCollegeWas.setText("            K.C.Gandhi English School was founded in 2000 by Shri C.Gandhi in Kalyan.His sole aim being   imparting good quailty eduaction to the students.The  school occupies a vast area of 2 acre with a huge playground.Our school is equipped with modern classrooms,science lab,IT lab, library and a canteen.Within these years K.C.Gandhi school has gained immense popularity due to the efforts of its teachers and their bright  students.The school ranks among the top 3 in Kalyan.The school environment is surrounded by a lot of trees and exotic plants which keeps the atmosphere here cool and pleasant. ");
	txtrTheCollegeWas.setLineWrap(true);
	txtrTheCollegeWas.setFont(new Font("Times New Roman", Font.BOLD, 19));
//		schoolImg.setIcon(new ImageIcon(LoginAs.class.getResource("/GuiSwing2/school.png")));
	}
}
