package GuiSwing2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Profile {
	public static ResultSet rs;
	
	public static Connection con1;
	public static PreparedStatement insert;
	private JFrame frame;
	static String username ;
	static String usertype;
	public static String standard;
	static String code ;

	public static String email;
	public static String mobileno;
	static String name ;
	static String year ;
	static String gender ;
	static String imagepath ;
	static String dob ;
	static String uname;
	static String prof;

private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
public Profile(String usern,String usert , String stand, String code) {
	this.username = usern;
	this.usertype = usert;
	this.standard = stand;
	this.code = code;
//	System.out.println(username+" "+usertype+" "+ standard +" "+code);
	load_table() ;
	initialize();
}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile window = new Profile(username,usertype,standard,code);
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
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 8));
		frame.getContentPane().setBackground(new Color(255, 248, 220));
		frame.setBounds(100, 100, 1147, 701);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 4));
		panel.setBackground(Color.WHITE);
		panel.setBounds(22, 20, 1087, 71);
		frame.getContentPane().add(panel);
		
		panel.setLayout(null);
		
	
		if(usertype=="Student") {
			prof= usertype+" Profile";
		}
		JLabel lblNewLabel = new JLabel("Teacher Profile");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 1067, 51);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 38));
		lblNewLabel.setForeground(Color.RED);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(22, 118, 1087, 528);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name :");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(87, 21, 135, 45);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("User Name :");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1.setBounds(87, 76, 135, 45);
		panel_1.add(lblNewLabel_1_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		
		
		JButton btnLoginPage = new JButton("");
		btnLoginPage.setFocusable(false);
		btnLoginPage.setIcon(new ImageIcon("D:\\java\\javaproj\\JavaProject\\src\\images\\back.png"));
		btnLoginPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Mainmenu mm = new Mainmenu(username,usertype,standard, code);
				TeacherLogin Tl = new TeacherLogin(username,usertype,standard,code);
				 frame.setVisible(false);
				 frame.setVisible(false);
			}
		});
		btnLoginPage.setForeground(Color.WHITE);
		btnLoginPage.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLoginPage.setBackground(UIManager.getColor("Button.background"));
		btnLoginPage.setBounds(992, 469, 67, 37);
		panel_1.add(btnLoginPage);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Standard :");
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_1.setBounds(87, 131, 135, 45);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Gender :");
		lblNewLabel_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_1_1.setBounds(87, 292, 135, 45);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2.setBounds(897, 21, 162, 154);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 10, 142, 134);
		ImageIcon icon = new ImageIcon(imagepath);
    	Image image = icon.getImage();
    	Image imgscale = image.getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_SMOOTH);
    	ImageIcon scaledicon = new ImageIcon(imgscale);
        lblNewLabel_2.setIcon(scaledicon);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email :");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_2.setBounds(87, 237, 135, 45);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Mobile no:");
		lblNewLabel_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_2.setBounds(87, 182, 135, 45);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_4 = new JLabel(name);
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_4.setBackground(Color.WHITE);
		lblNewLabel_1_4.setBounds(232, 21, 438, 45);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(uname);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1.setBounds(232, 76, 438, 45);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel(standard);
		lblNewLabel_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_2.setBounds(232, 131, 438, 45);
		panel_1.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel(mobileno);
		lblNewLabel_1_1_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_3.setBounds(232, 182, 319, 45);
		panel_1.add(lblNewLabel_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_3_1 = new JLabel(email);
		lblNewLabel_1_1_1_3_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_3_1.setBounds(232, 237, 438, 45);
		panel_1.add(lblNewLabel_1_1_1_3_1);
		
		
		
		JLabel lblNewLabel_1_1_1_3_3 = new JLabel(gender);
		lblNewLabel_1_1_1_3_3.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_3_3.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_3_3.setBounds(232, 292, 135, 45);
		panel_1.add(lblNewLabel_1_1_1_3_3);
		
			JLabel lblNewLabel_1_3 = new JLabel("Code :");
			lblNewLabel_1_3.setForeground(Color.BLACK);
			lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 23));
			lblNewLabel_1_3.setBackground(Color.WHITE);
			lblNewLabel_1_3.setBounds(850, 271, 135, 45);
			panel_1.add(lblNewLabel_1_3);
			JLabel lblNewLabel_1_1_1_3_3_1 = new JLabel(code);
			lblNewLabel_1_1_1_3_3_1.setForeground(Color.RED);
			lblNewLabel_1_1_1_3_3_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
			lblNewLabel_1_1_1_3_3_1.setBounds(924, 271, 135, 45);
			panel_1.add(lblNewLabel_1_1_1_3_3_1);
		
		
	}
	public void load_table() {
		 try {
			 int c;
	            Class.forName("com.mysql.cj.jdbc.Driver"); //Register the mysql driver
	            con1 = DriverManager.getConnection("jdbc:mysql://localhost/students","root","");
	            insert = con1.prepareStatement("select * from teachers where code = ? ");
	            insert.setString(1,code);
	            
	           
	           rs= insert.executeQuery();
	          if(rs.next()) {
	        	  	uname = rs.getString("username");
	            	name = rs.getString("name");
	            	mobileno = rs.getString("mobile");
	            	code = rs.getString("code");
	            	email = rs.getString("email");
	            	
	            	gender = rs.getString("gender");
	            
	            	imagepath = rs.getString("image");
	          }
	            
	        } catch (ClassNotFoundException ex) {
	        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SQLException ex) {
	        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
	        } 
	}
}
