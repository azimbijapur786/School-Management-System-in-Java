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

	private JFrame frmMarkAttendance;
	JTextField getRollAttd;
	JTextField getClassAttd;
	Connection con;
	java.sql.PreparedStatement pst;
	JTextField getEmail;
	JDateChooser datechooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendanceMark window = new AttendanceMark();
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
	public AttendanceMark() {
		
		con=DatabaseForAttendanceConnect.dbconnect();
		
		frmMarkAttendance = new JFrame();
		frmMarkAttendance.getContentPane().setBackground(new Color(250, 250, 210));
		frmMarkAttendance.setTitle("Mark Attendance");
		frmMarkAttendance.setBounds(100, 100, 878, 499);
		frmMarkAttendance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarkAttendance.getContentPane().setLayout(null);
		frmMarkAttendance.setVisible(true);
		frmMarkAttendance.setResizable(false);
		frmMarkAttendance.setLocationRelativeTo(null);
		
		JLabel attendedDay = new JLabel("Mark Attendance");
		attendedDay.setBackground(Color.WHITE);
		attendedDay.setHorizontalAlignment(SwingConstants.CENTER);
		attendedDay.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		attendedDay.setBounds(10, 10, 844, 68);
		frmMarkAttendance.getContentPane().add(attendedDay);
		
		JLabel rollAttd = new JLabel("Roll No. :");
		rollAttd.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		rollAttd.setBounds(71, 109, 114, 23);
		frmMarkAttendance.getContentPane().add(rollAttd);
		
		JLabel classAttd = new JLabel("Class :");
		classAttd.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		classAttd.setBounds(71, 169, 79, 23);
		frmMarkAttendance.getContentPane().add(classAttd);
		
		JButton markAttendance = new JButton("Mark");
		markAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{	
					  String rollno = getRollAttd.getText();
					  String std = getClassAttd.getText();
					  SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					  String date = df.format(datechooser.getDate());
					  String email = getEmail.getText();
				 	con= DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
<<<<<<< HEAD
					pst = con.prepareStatement("INSERT INTO attendance(id,roll,standard,date,email)"+" VALUES(NULL,?,?,?,?);");
=======
					pst = con.prepareStatement("INSERT INTO information(roll,standard,date,email)"+" VALUES(?,?,?,?);");
>>>>>>> 2e2de11c2af697724c3e3b056ac2600a28e795a3
				
					pst.setString(1,rollno);
					pst.setString(2,std);
					pst.setString(3,date);
					pst.setNString(4, email);
			
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
		markAttendance.setBounds(120, 369, 99, 60);
		frmMarkAttendance.getContentPane().add(markAttendance);
		
		JButton clearAttd = new JButton("Clear");
		clearAttd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				getRollAttd.setText(null);
				getClassAttd.setText(null);
				getEmail.setText(null);
				datechooser.setDate(null);
			}
		});
		clearAttd.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		clearAttd.setBounds(305, 369, 99, 60);
		frmMarkAttendance.getContentPane().add(clearAttd);
		
		JButton backAttd = new JButton("Back");
		backAttd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new StudentLogin();
				frmMarkAttendance.setVisible(false);
				
			}
		});
		backAttd.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		backAttd.setBounds(483, 369, 99, 60);
		frmMarkAttendance.getContentPane().add(backAttd);
		
		getRollAttd = new JTextField();
		getRollAttd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getRollAttd.setBounds(288, 110, 152, 33);
		frmMarkAttendance.getContentPane().add(getRollAttd);
		getRollAttd.setColumns(10);
		
		getClassAttd = new JTextField();
		getClassAttd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getClassAttd.setBounds(288, 170, 152, 33);
		frmMarkAttendance.getContentPane().add(getClassAttd);
		getClassAttd.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEmail.setBounds(67, 292, 192, 33);
		frmMarkAttendance.getContentPane().add(lblEmail);
		
		getEmail = new JTextField();
		getEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getEmail.setColumns(10);
		getEmail.setBounds(288, 292, 246, 33);
		frmMarkAttendance.getContentPane().add(getEmail);
		
		JLabel lblDate = new JLabel("Date (MM-DD--YY) :");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblDate.setBounds(67, 235, 219, 23);
		frmMarkAttendance.getContentPane().add(lblDate);
		
		datechooser = new JDateChooser();
		datechooser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 15));
		datechooser.setBounds(288, 225, 171, 33);
		frmMarkAttendance.getContentPane().add(datechooser);
	}
}
