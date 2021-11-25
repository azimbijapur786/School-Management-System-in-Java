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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin window = new StudentLogin();
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
	/**
	 * Initialize the contents of the frame.
	 */
		public StudentLogin() {
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
		addAttendance.setFocusable(false);
		addAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
					new AttendanceMark();
					frmStudenLogin.setVisible(false);
				
			}
		});
		addAttendance.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		addAttendance.setBackground(UIManager.getColor("Button.background"));
		addAttendance.setBounds(21, 126, 232, 67);
		frmStudenLogin.getContentPane().add(addAttendance);
		
		JButton viewMarks = new JButton("View Marksheet");
		viewMarks.setFocusable(false);
		viewMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new ViewMarksheet();
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
				new TimeTableView();
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
				new ViewAnnounce();
				frmStudenLogin.setVisible(false);
			}
		});
		getAnnounce.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		getAnnounce.setFocusable(false);
		getAnnounce.setBounds(21, 370, 232, 60);
		frmStudenLogin.getContentPane().add(getAnnounce);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Java\\Java Project Sem III\\School-Management_System\\WinBuilder\\src\\GuiSwing2\\library2.jfif"));
		lblNewLabel.setBounds(331, 126, 523, 374);
		frmStudenLogin.getContentPane().add(lblNewLabel);
	}
}
