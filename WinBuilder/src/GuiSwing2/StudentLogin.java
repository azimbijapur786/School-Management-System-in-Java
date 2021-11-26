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
			frmStudenLogin.setBounds(100, 100, 900, 550);
			frmStudenLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmStudenLogin.getContentPane().setLayout(null);
			frmStudenLogin.setVisible(true);
			frmStudenLogin.setResizable(false);
			frmStudenLogin.setLocationRelativeTo(null);
			
			JPanel titlestdPanel = new JPanel();
			titlestdPanel.setBackground(new Color(255, 255, 240));
			titlestdPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			titlestdPanel.setBounds(10, 11, 844, 86);
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
			schoolName.setBounds(0, 0, 844, 86);
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
			addAttendance.setBounds(21, 126, 232, 67);
			frmStudenLogin.getContentPane().add(addAttendance);
			
			JButton viewMarks = new JButton("View Marksheet");
			viewMarks.setFocusable(false);
			viewMarks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					ViewMarksheet vm = new ViewMarksheet(username,usertype,standard,rollno);
					frmStudenLogin.setVisible(false);
				}
			});
			viewMarks.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			viewMarks.setBounds(21, 210, 232, 67);
			frmStudenLogin.getContentPane().add(viewMarks);
			
			JButton viewFee = new JButton("Timetable");
			viewFee.setFocusable(false);
			viewFee.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					TimeTable tt = new TimeTable(username,usertype,standard,rollno);
					frmStudenLogin.setVisible(false);
				}
			});
			viewFee.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			viewFee.setBounds(21, 294, 232, 60);
			frmStudenLogin.getContentPane().add(viewFee);
			
			JButton logoutStd = new JButton("Logout");
			logoutStd.setFocusable(false);
			logoutStd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					new LoginAs();
					frmStudenLogin.setVisible(false);
				}
			});
			logoutStd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			logoutStd.setBounds(21, 440, 232, 60);
			frmStudenLogin.getContentPane().add(logoutStd);
			
			JButton getAnnounce = new JButton("Announcements");
			getAnnounce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					Annoucement aa = new Annoucement(username,usertype,standard,rollno);
					frmStudenLogin.setVisible(false);
				}
			});
			getAnnounce.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			getAnnounce.setFocusable(false);
			getAnnounce.setBounds(21, 370, 232, 60);
			frmStudenLogin.getContentPane().add(getAnnounce);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon(StudentLogin.class.getResource("/GuiSwing2/library.jpg")));
			lblNewLabel.setBounds(327, 137, 473, 322);
			frmStudenLogin.getContentPane().add(lblNewLabel);
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

	/**
	 * Create the application.
	 */
}
