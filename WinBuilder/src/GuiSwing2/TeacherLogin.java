package GuiSwing2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TeacherLogin {

	private JFrame frmTeacherLogin;
	public static String username;
	public static String usertype;
	public static String standard;
	public static String code;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherLogin window = new TeacherLogin(username,usertype,standard,code);
					window.frmTeacherLogin.setVisible(true);
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
		public TeacherLogin(String username, String usertype, String standard,String code) {
			this.username=username;
			this.usertype=usertype;
			this.standard=standard;
			this.code=code;
			
		frmTeacherLogin = new JFrame();
		frmTeacherLogin.getContentPane().setBackground(new Color(255, 240, 245));
		frmTeacherLogin.setTitle("Studen Login");
		frmTeacherLogin.setBounds(100, 100, 1191, 772);
		frmTeacherLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeacherLogin.getContentPane().setLayout(null);
		frmTeacherLogin.setVisible(true);
		frmTeacherLogin.setResizable(false);
		frmTeacherLogin.setLocationRelativeTo(null);
		
		JPanel titlestdPanel = new JPanel();
		titlestdPanel.setBackground(new Color(240, 230, 140));
		titlestdPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		titlestdPanel.setBounds(21, 19, 1146, 97);
		frmTeacherLogin.getContentPane().add(titlestdPanel);
		titlestdPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 10, 125, 73);
		titlestdPanel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBorder(null);
		lblNewLabel.setIcon(new ImageIcon(TeacherLogin.class.getResource("/GuiSwing2/Imgs/teacher-at-the-blackboard.png")));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel schoolName = new JLabel("K.C.GANDHI ENGLISH SCHOOL");
		schoolName.setBounds(0, 0, 1146, 97);
		titlestdPanel.add(schoolName);
		schoolName.setHorizontalAlignment(SwingConstants.CENTER);
		schoolName.setBackground(new Color(255, 240, 245));
		schoolName.setForeground(new Color(0, 0, 0));
		schoolName.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JPanel libimgPanel = new JPanel();
		libimgPanel.setBackground(new Color(255, 248, 220));
		libimgPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		libimgPanel.setBounds(21, 242, 1146, 368);
		frmTeacherLogin.getContentPane().add(libimgPanel);
		libimgPanel.setLayout(null);
		
		JLabel Library = new JLabel("");
		Library.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Library.setBounds(0, 0, 588, 368);
		libimgPanel.add(Library);
//		Library.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java\\Eclipse\\WinBuilder\\src\\GuiSwing2\\library2.jfif"));
		ImageIcon icon = new ImageIcon(LoginAs.class.getResource("/GuiSwing2/imgs/Complab.jpg"));
    	Image image = icon.getImage();
    	Image imgscale = image.getScaledInstance(Library.getWidth(),Library.getHeight(),Image.SCALE_SMOOTH);
    	ImageIcon scaledicon = new ImageIcon(imgscale);
	Library.setIcon(scaledicon);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBackground(new Color(60, 179, 113));
	panel_1.setBounds(598, 0, 548, 67);
	libimgPanel.add(panel_1);
	panel_1.setLayout(null);
	
	JLabel lblNewLabel_1 = new JLabel("My Notes");
	lblNewLabel_1.setForeground(Color.WHITE);
	lblNewLabel_1.setIcon(new ImageIcon(TeacherLogin.class.getResource("/GuiSwing2/Imgs/contract.png")));
	lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 27));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setBounds(10, 10, 528, 47);
	panel_1.add(lblNewLabel_1);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(598, 67, 548, 301);
	libimgPanel.add(scrollPane);
	
	JTextArea textArea = new JTextArea();
	textArea.setToolTipText("");
	textArea.setForeground(new Color(0, 0, 0));
	textArea.setFont(new Font("Times New Roman", Font.ITALIC, 20));
	textArea.setLineWrap(true);
	scrollPane.setViewportView(textArea);
		
		JLabel logoStd = new JLabel("");
		logoStd.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java\\Eclipse\\WinBuilder\\src\\GuiSwing2\\logo5.jfif"));
		logoStd.setBounds(46, 11, 78, 86);
		frmTeacherLogin.getContentPane().add(logoStd);
		
		JButton addAttendance = new JButton(" Check Attendance");
		addAttendance.setBorderPainted(false);
		addAttendance.setForeground(Color.WHITE);
		addAttendance.setIcon(new ImageIcon(TeacherLogin.class.getResource("/GuiSwing2/Imgs/icons8-raised-hand-48.png")));
		addAttendance.setFocusable(false);
		addAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				  Checkattend ca = new Checkattend (username,usertype,standard,code);
					frmTeacherLogin.setVisible(false);
				
			}
		});
		addAttendance.setFont(new Font("Times New Roman", Font.BOLD, 20));
		addAttendance.setBackground(new Color(255, 99, 71));
		addAttendance.setBounds(615, 136, 276, 86);
		frmTeacherLogin.getContentPane().add(addAttendance);
		
		JButton viewMarks = new JButton(" Add Marksheet");
		viewMarks.setBorderPainted(false);
		viewMarks.setBackground(new Color(255, 99, 71));
		viewMarks.setForeground(Color.WHITE);
		viewMarks.setIcon(new ImageIcon(TeacherLogin.class.getResource("/GuiSwing2/Imgs/icons8-document-50.png")));
		viewMarks.setFocusable(false);
		viewMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Marksheet m = new Marksheet(username,usertype,standard,code);
				frmTeacherLogin.setVisible(false);
			}
		});
		viewMarks.setFont(new Font("Times New Roman", Font.BOLD, 20));
		viewMarks.setBounds(314, 136, 291, 86);
		frmTeacherLogin.getContentPane().add(viewMarks);
		
		JButton viewFee = new JButton("Announcements");
		viewFee.setBorderPainted(false);
		viewFee.setBackground(new Color(123, 104, 238));
		viewFee.setForeground(Color.WHITE);
		viewFee.setIcon(new ImageIcon(TeacherLogin.class.getResource("/GuiSwing2/Imgs/icons8-commercial-48.png")));
		viewFee.setFocusable(false);
		viewFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Annoucement A = new Annoucement(username,usertype,standard,code);
				frmTeacherLogin.setVisible(false);
			}
		});
		viewFee.setFont(new Font("Times New Roman", Font.BOLD, 20));
		viewFee.setBounds(316, 631, 296, 83);
		frmTeacherLogin.getContentPane().add(viewFee);
		
		JButton logoutStd = new JButton("Logout");
		logoutStd.setBorderPainted(false);
		logoutStd.setForeground(Color.WHITE);
		logoutStd.setBackground(new Color(255, 99, 71));
		logoutStd.setIcon(new ImageIcon(TeacherLogin.class.getResource("/GuiSwing2/Imgs/erase.png")));
		logoutStd.setFocusable(false);
		logoutStd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new LoginAs();
				frmTeacherLogin.setVisible(false);
			}
		});
		logoutStd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		logoutStd.setBounds(908, 631, 259, 83);
		frmTeacherLogin.getContentPane().add(logoutStd);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setForeground(Color.WHITE);
		btnProfile.setBorder(null);
		btnProfile.setIcon(new ImageIcon(TeacherLogin.class.getResource("/GuiSwing2/Imgs/icons8-contacts-50.png")));
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile prof = new Profile(username,usertype,standard,code);
				frmTeacherLogin.setVisible(false);
			}
		});
		btnProfile.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnProfile.setFocusable(false);
		btnProfile.setBackground(new Color(255, 99, 71));
		btnProfile.setBounds(21, 136, 283, 86);
		frmTeacherLogin.getContentPane().add(btnProfile);
		
		JButton btnTimeTable = new JButton("Time Table");
		btnTimeTable.setBorderPainted(false);
		btnTimeTable.setForeground(Color.WHITE);
		btnTimeTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeTable TT = new TimeTable(username,usertype,standard,code);
				frmTeacherLogin.setVisible(false);
			}
		});
		btnTimeTable.setIcon(new ImageIcon(TeacherLogin.class.getResource("/GuiSwing2/Imgs/icons8-calendar-48.png")));
		btnTimeTable.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTimeTable.setFocusable(false);
		btnTimeTable.setBackground(new Color(255, 99, 71));
		btnTimeTable.setBounds(901, 136, 266, 86);
		frmTeacherLogin.getContentPane().add(btnTimeTable);
		
		JButton btnClassroom = new JButton("Classroom");
		btnClassroom.setBorderPainted(false);
		btnClassroom.setForeground(Color.WHITE);
		btnClassroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Classroom cr = new Classroom(username,usertype,standard , code);
				frmTeacherLogin.setVisible(false);
			}
		});
		btnClassroom.setIcon(new ImageIcon(TeacherLogin.class.getResource("/GuiSwing2/Imgs/icons8-google-classroom-48.png")));
		btnClassroom.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnClassroom.setFocusable(false);
		btnClassroom.setBackground(new Color(123, 104, 238));
		btnClassroom.setBounds(21, 630, 283, 84);
		frmTeacherLogin.getContentPane().add(btnClassroom);
		
		JButton btnSaveNote = new JButton("Save Note");
		btnSaveNote.setBorderPainted(false);
		btnSaveNote.setIcon(new ImageIcon(TeacherLogin.class.getResource("/GuiSwing2/Imgs/diskette.png")));
		btnSaveNote.setForeground(Color.WHITE);
		btnSaveNote.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSaveNote.setFocusable(false);
		btnSaveNote.setBackground(new Color(60, 179, 113));
		btnSaveNote.setBounds(622, 631, 276, 83);
		frmTeacherLogin.getContentPane().add(btnSaveNote);
	}
}