package GuiSwing2;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.mysql.cj.jdbc.*;
public class AttendanceMark {
	static String username;
	static String standard;
	static String rollno;
	static String usertype;

	private JFrame frmMarkAttendance;
	JTextField getRollAttd;
	JTextField getClassAttd;
	Connection con;
	java.sql.PreparedStatement pst;
	JDateChooser datechooser;
	/**
	 * Launch the application.
	 */
	
public AttendanceMark(String usern,String usert,String stand,String rollno) {
		
	this.username=usern;
	this.standard=stand;
	this.usertype=usert;
	this.rollno=rollno;
		con=DatabaseForAttendanceConnect.dbconnect();
		
		frmMarkAttendance = new JFrame();
		frmMarkAttendance.getContentPane().setBackground(new Color(250, 250, 210));
		frmMarkAttendance.setTitle("Mark Attendance");
		frmMarkAttendance.setBounds(100, 100, 546, 499);
		frmMarkAttendance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarkAttendance.getContentPane().setLayout(null);
		frmMarkAttendance.setVisible(true);
		frmMarkAttendance.setResizable(false);
		frmMarkAttendance.setLocationRelativeTo(null);
		
		JLabel attendedDay = new JLabel("Mark Attendance");
		attendedDay.setBackground(Color.WHITE);
		attendedDay.setHorizontalAlignment(SwingConstants.CENTER);
		attendedDay.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		attendedDay.setBounds(10, 10, 492, 68);
		frmMarkAttendance.getContentPane().add(attendedDay);
		
		JLabel rollAttd = new JLabel("Roll No. :");
		rollAttd.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		rollAttd.setBounds(71, 106, 114, 23);
		frmMarkAttendance.getContentPane().add(rollAttd);
		
		JLabel classAttd = new JLabel("standard :");
		classAttd.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		classAttd.setBounds(71, 169, 114, 23);
		frmMarkAttendance.getContentPane().add(classAttd);
		
		
		JButton clearAttd = new JButton("Clear");
		clearAttd.setIcon(new ImageIcon(AttendanceMark.class.getResource("/GuiSwing2/Imgs/erase.png")));
		clearAttd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				getRollAttd.setText(null);
				getClassAttd.setText(null);

				datechooser.setDate(null);
			}
		});
		clearAttd.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		clearAttd.setBounds(206, 317, 126, 60);
		frmMarkAttendance.getContentPane().add(clearAttd);
		
		JButton backAttd = new JButton("Back");
		backAttd.setIcon(new ImageIcon(AttendanceMark.class.getResource("/GuiSwing2/images/previous.png")));
		backAttd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				StudentLogin sl = new StudentLogin(username,usertype,standard,rollno);
				frmMarkAttendance.setVisible(false);
				
			}
		});
		backAttd.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		backAttd.setBounds(354, 317, 126, 60);
		frmMarkAttendance.getContentPane().add(backAttd);
		
		getRollAttd = new JTextField(rollno);
		getRollAttd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getRollAttd.setBounds(288, 103, 152, 33);
		frmMarkAttendance.getContentPane().add(getRollAttd);
		getRollAttd.setColumns(10);
		
		getClassAttd = new JTextField(standard);
		getClassAttd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getClassAttd.setBounds(288, 170, 152, 33);
		frmMarkAttendance.getContentPane().add(getClassAttd);
		getClassAttd.setColumns(10);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblDate.setBounds(71, 225, 83, 33);
		frmMarkAttendance.getContentPane().add(lblDate);
		
		datechooser = new JDateChooser();
		datechooser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 15));
		datechooser.setBounds(288, 225, 171, 33);
		frmMarkAttendance.getContentPane().add(datechooser);
		
		
		JButton markAttendance = new JButton("Mark");
		markAttendance.setIcon(new ImageIcon(AttendanceMark.class.getResource("/GuiSwing2/Imgs/check.png")));
		markAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{	
					  String rollno = getRollAttd.getText();
					  String std = getClassAttd.getText();
					  SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					  String date = df.format(datechooser.getDate());
		
				 	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");

					pst = con.prepareStatement("INSERT INTO attendance(roll,standard,date,name)"+" VALUES(?,?,?,?);");

		

				
					pst.setString(1,rollno);
					pst.setString(2,std);
					pst.setString(3,date);
					pst.setNString(4, username);
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Done");
			         
				} 
				catch (SQLException e1) 
				{
					
					e1.printStackTrace();
				}
		         
			}
		});
		markAttendance.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		markAttendance.setBounds(46, 317, 139, 60);
		frmMarkAttendance.getContentPane().add(markAttendance);
		
		
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendanceMark window = new AttendanceMark(username,usertype,standard,rollno);
					window.frmMarkAttendance.setVisible(true);
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
	
}
