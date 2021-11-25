package GuiSwing2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Login {
	public static PreparedStatement insert;
	public static ResultSet rs;
	public static Connection con1;
	private JFrame frmLogin;
	private JTextField unameStd;
	private JPasswordField passwordField;
	public static String usertype="";
	public static String username;
	public static String standard;
	public static String rollno;
	public static String code;
	public static String name;
	
	public Login(String usertype) {
		this.usertype=usertype;
		
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(new Color(250, 250, 210));
		frmLogin.setTitle(LoginAs.titleForLogin);
		frmLogin.setBounds(100, 100, 487, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setVisible(true);
		frmLogin.setResizable(false);
		frmLogin.setLocationRelativeTo(null);
		
		JLabel unames = new JLabel("Username :");
		unames.setIcon(new ImageIcon(Login.class.getResource("/GuiSwing2/Imgs/icons8-user-40.png")));
		unames.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		unames.setBounds(59, 29, 159, 64);
		frmLogin.getContentPane().add(unames);
		
		JLabel pwds = new JLabel("Password : ");
		pwds.setIcon(new ImageIcon(Login.class.getResource("/GuiSwing2/Imgs/lock_closed.png")));
		pwds.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		pwds.setBounds(59, 103, 159, 48);
		frmLogin.getContentPane().add(pwds);
		
		unameStd = new JTextField();
		unameStd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		unameStd.setBounds(228, 48, 191, 30);
		frmLogin.getContentPane().add(unameStd);
		unameStd.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(230, 116, 189, 30);
		frmLogin.getContentPane().add(passwordField);
		
		JButton stdOk = new JButton("OK");
		stdOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = unameStd.getText();
				String pass = passwordField.getText();
				
				
				if(usertype=="student") {
					StudentLogin sl = new StudentLogin();
					frmLogin.setVisible(false);
				}
				else if(usertype=="teacher") {
					
					 try {
				            Class.forName("com.mysql.cj.jdbc.Driver"); //Register the mysql driver
				            con1 = DriverManager.getConnection("jdbc:mysql://localhost/students","root","");
				            insert = con1.prepareStatement("select name,standard,code from teachers where username = ? and pass = ? ");
				            insert.setString(1,user);
				            insert.setString(2,pass);
				           
				           rs= insert.executeQuery();
				            if(rs.next()==false) {
				            	JOptionPane.showMessageDialog(null,"Teacher Not Found", "ERROR", JOptionPane.PLAIN_MESSAGE);
				            }
				            else {
				            	name = rs.getString("name");
				            	standard = rs.getString("standard");
				            	rollno = rs.getString("code");
				            	TeacherLogin tl = new TeacherLogin(name,usertype,standard,rollno);
								frmLogin.setVisible(false);
						
				            
				            }
				            
				        } catch (ClassNotFoundException ex) {
				        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				        } catch (SQLException ex) {
				        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				        } 
					
					
					
					
					
					
					
					
				
				}
				else
				{
					 try {
				            Class.forName("com.mysql.cj.jdbc.Driver"); //Register the mysql driver
				            con1 = DriverManager.getConnection("jdbc:mysql://localhost/students","root","");
				            insert = con1.prepareStatement("select * from admin where username = ? and pass = ? ");
				            insert.setString(1,user);
				            insert.setString(2,pass);
				           
				           rs= insert.executeQuery();
				            if(rs.next()==false) {
				            	JOptionPane.showMessageDialog(null,"Admin Not Found", "ERROR", JOptionPane.PLAIN_MESSAGE);
				            }
				            else {
				            	first first = new first();
				            	
								
				            	first attach = new first();
								frmLogin.setVisible(false);
				            	
				            }
				            
				        } catch (ClassNotFoundException ex) {
				        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				        } catch (SQLException ex) {
				        	JOptionPane.showMessageDialog(null,"Check Database Connection", "ERROR", JOptionPane.PLAIN_MESSAGE);
//				        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				        } 
					
//					
//					first attach = new first();
//					frmLogin.setVisible(false);
				}
			}
		});
		stdOk.setFocusable(false);
		stdOk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stdOk.setBounds(79, 187, 89, 40);
		frmLogin.getContentPane().add(stdOk);
		
		JButton stdClr = new JButton("Clear");
		stdClr.setFocusable(false);
		stdClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				unameStd.setText(null);
				passwordField.setText(null);
				
			}
		});
		stdClr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stdClr.setBounds(189, 187, 89, 40);
		frmLogin.getContentPane().add(stdClr);
		
		JButton loginBack = new JButton("Back");
		loginBack.setFocusable(false);
		loginBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new LoginAs();
				frmLogin.setVisible(false);
			}
		});
		loginBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginBack.setBounds(299, 187, 89, 40);
		frmLogin.getContentPane().add(loginBack);
		
	
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login(usertype);
					window.frmLogin.setVisible(true);
				
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
