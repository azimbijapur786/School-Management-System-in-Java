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

public class StudentLogin {

	private JFrame frmStudenLogin;
		static String username;
		static String standard;
		static String rollno;
		static String usertype;

	/**
	 * Launch the application.
	 */
		
		public StudentLogin(String usern,String usert,String stand,String rollno) {
			
			this.username=usern;
			this.standard=stand;
			this.usertype=usert;
			this.rollno=rollno;
			System.out.println(username+" "+usertype+" "+ standard +" "+rollno);
			frmStudenLogin = new JFrame();
			frmStudenLogin.getContentPane().setBackground(new Color(255, 250, 205));
			frmStudenLogin.setTitle("Studen Login");
			frmStudenLogin.setBounds(100, 100, 1104, 646);
			frmStudenLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmStudenLogin.getContentPane().setLayout(null);
			frmStudenLogin.setVisible(true);
			frmStudenLogin.setResizable(false);
			frmStudenLogin.setLocationRelativeTo(null);
			
			JPanel titlestdPanel = new JPanel();
			titlestdPanel.setBackground(new Color(255, 255, 240));
			titlestdPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			titlestdPanel.setBounds(10, 11, 1070, 86);
			frmStudenLogin.getContentPane().add(titlestdPanel);
			titlestdPanel.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setIcon(new ImageIcon(StudentLogin.class.getResource("/GuiSwing2/Imgs/sun.jpeg")));
			lblNewLabel_1.setBounds(83, 10, 84, 66);
			titlestdPanel.add(lblNewLabel_1);
			
			JLabel schoolName = new JLabel("K.C.GANDHI ENGLISH SCHOOL");
			schoolName.setHorizontalAlignment(SwingConstants.CENTER);
			schoolName.setBackground(new Color(255, 255, 255));
			schoolName.setBounds(-27, 0, 1097, 86);
			titlestdPanel.add(schoolName);
			schoolName.setForeground(new Color(0, 0, 0));
			schoolName.setFont(new Font("Times New Roman", Font.BOLD, 30));
				
			JLabel logoStd = new JLabel("");
			logoStd.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java\\Eclipse\\WinBuilder\\src\\GuiSwing2\\logo5.jfif"));
			logoStd.setBounds(46, 11, 78, 86);
			frmStudenLogin.getContentPane().add(logoStd);
			
			JButton addAttendance = new JButton("Mark Attendance");
			addAttendance.setIcon(new ImageIcon(StudentLogin.class.getResource("/GuiSwing2/Imgs/icons8-raised-hand-48.png")));
			addAttendance.setFocusable(false);
			addAttendance.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					AttendanceMark att = new AttendanceMark(username,usertype,standard,rollno);
						frmStudenLogin.setVisible(false);
					
				}
			});
			addAttendance.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			addAttendance.setBackground(UIManager.getColor("Button.light"));
			addAttendance.setBounds(21, 126, 232, 86);
			frmStudenLogin.getContentPane().add(addAttendance);
			
			JButton viewMarks = new JButton("View Marksheet");
			viewMarks.setIcon(new ImageIcon(StudentLogin.class.getResource("/GuiSwing2/Imgs/icons8-document-50.png")));
			viewMarks.setFocusable(false);
			viewMarks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					ViewMarksheet vm = new ViewMarksheet(username,usertype,standard,rollno);
					frmStudenLogin.setVisible(false);
				}
			});
			viewMarks.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			viewMarks.setBounds(21, 222, 232, 86);
			frmStudenLogin.getContentPane().add(viewMarks);
			
			JButton viewFee = new JButton("Timetable");
			viewFee.setIcon(new ImageIcon(StudentLogin.class.getResource("/GuiSwing2/Imgs/icons8-calendar-48.png")));
			viewFee.setFocusable(false);
			viewFee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					TimeTable tt = new TimeTable(username,usertype,standard,rollno);
					frmStudenLogin.setVisible(false);
				}
			});
			viewFee.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			viewFee.setBounds(21, 318, 232, 86);
			frmStudenLogin.getContentPane().add(viewFee);
			
			JButton logoutStd = new JButton("Logout");
			logoutStd.setIcon(new ImageIcon(StudentLogin.class.getResource("/GuiSwing2/images/turn-off (1).png")));
			logoutStd.setFocusable(false);
			logoutStd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					new LoginAs();
					frmStudenLogin.setVisible(false);
				}
			});
			logoutStd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			logoutStd.setBounds(21, 504, 232, 80);
			frmStudenLogin.getContentPane().add(logoutStd);
			
			JButton getAnnounce = new JButton("Announcements");
			getAnnounce.setIcon(new ImageIcon(StudentLogin.class.getResource("/GuiSwing2/Imgs/icons8-commercial-48.png")));
			getAnnounce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					Annoucement aa = new Annoucement(username,usertype,standard,rollno);
					frmStudenLogin.setVisible(false);
				}
			});
			getAnnounce.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			getAnnounce.setFocusable(false);
			getAnnounce.setBounds(21, 414, 232, 80);
			frmStudenLogin.getContentPane().add(getAnnounce);
			
			JPanel panel = new JPanel();
			panel.setBounds(294, 126, 774, 444);
			frmStudenLogin.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			lblNewLabel.setBounds(0, 0, 774, 444);
			ImageIcon icon = new ImageIcon(LoginAs.class.getResource("/GuiSwing2/imgs/library.jpg"));
	    	Image image = icon.getImage();
	    	Image imgscale = image.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
	    	ImageIcon scaledicon = new ImageIcon(imgscale);
	    	
			
			lblNewLabel.setIcon(scaledicon);
			panel.add(lblNewLabel);
		}
		
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin window = new StudentLogin(username,usertype,standard,rollno);
					window.frmStudenLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
