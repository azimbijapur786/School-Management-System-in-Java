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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
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
import com.toedter.calendar.JDateChooser;
import javax.swing.UIManager;

public class AddStudent {
	public static ResultSet rs;
	public static String filepath;
	public static Connection con1;
	public static PreparedStatement insert;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
static String user;
private final ButtonGroup buttonGroup = new ButtonGroup();
private JPasswordField passwordField;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_4;
	/**
	 * Launch the application.
	 */
public AddStudent(String usern) {
	if(usern!=null) {
	this.user= usern;
	}
	else {
		this.user= "";
	}
	initialize();
}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent window = new AddStudent(user);
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
		frame.getContentPane().setBackground(new Color(255, 228, 196));
		frame.setBounds(100, 100, 1147, 719);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(22, 20, 1087, 71);
		frame.getContentPane().add(panel);
		String username = "Add Student";
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel(username);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 1128, 51);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 38));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.inactiveCaptionText, 8));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(66, 119, 1012, 528);
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
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password :");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1.setBounds(87, 130, 135, 45);
		panel_1.add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.GREEN);
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField.setBounds(232, 31, 313, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.GREEN);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(232, 81, 313, 26);
		panel_1.add(textField_1);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.YELLOW);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.BLACK);
		textField_4.setBounds(762, 276, 162, 36);
		panel_1.add(textField_4);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(232, 411, 204, 26);
	
		
		dateChooser.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel_1.add(dateChooser);
		
		
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Standard :");
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_1.setBounds(87, 185, 135, 45);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFocusTraversalKeysEnabled(false);
		comboBox.setFocusable(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"8","9","10"}));
		comboBox.setForeground(Color.GREEN);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setBackground(Color.BLACK);
		comboBox.setBounds(232, 196, 313, 26);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Gender :");
		lblNewLabel_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_1_1.setBounds(87, 346, 135, 45);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFocusable(false);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setForeground(Color.RED);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnNewRadioButton.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton.setBounds(228, 359, 85, 21);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setForeground(Color.RED);
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnFemale.setFocusable(false);
		rdbtnFemale.setBackground(SystemColor.activeCaption);
		rdbtnFemale.setBounds(315, 359, 104, 21);
		panel_1.add(rdbtnFemale);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("DOB :");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(87, 401, 135, 45);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.BLACK, 7));
		panel_2.setBounds(737, 31, 162, 154);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 10, 142, 134);
		panel_2.add(lblNewLabel_2);
		
		JButton btnChooseImage = new JButton("Choose Photo");
		btnChooseImage.setHorizontalAlignment(SwingConstants.LEFT);
		btnChooseImage.setIcon(new ImageIcon("D:\\java\\javaproj\\JavaProject\\src\\images\\folder_red.png"));
		btnChooseImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				  JFileChooser fc=new JFileChooser("D:\\java\\images");    
				    int i=fc.showOpenDialog(panel_2);    
				    Path temp = null;
				    if(i==JFileChooser.APPROVE_OPTION){   
				    	  
						
				    	
				
				        File f=fc.getSelectedFile();    
				        filepath=f.getPath();   
				        ImageIcon icon = new ImageIcon(filepath);
				    	Image image = icon.getImage();
				    	Image imgscale = image.getScaledInstance(lblNewLabel_2.getWidth(),lblNewLabel_2.getHeight(),Image.SCALE_SMOOTH);
				    	ImageIcon scaledicon = new ImageIcon(imgscale);
				        lblNewLabel_2.setIcon(scaledicon);
				                     
				    }    
			}
		});
		btnChooseImage.setFocusable(false);
		btnChooseImage.setForeground(Color.BLACK);
		btnChooseImage.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnChooseImage.setBackground(UIManager.getColor("Button.background"));
		btnChooseImage.setBounds(717, 196, 199, 51);
		panel_1.add(btnChooseImage);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordField.setBackground(Color.BLACK);
		passwordField.setForeground(Color.RED);
		passwordField.setBounds(232, 140, 313, 26);
		panel_1.add(passwordField);
		JButton btnReset = new JButton("Reset");
		btnReset.setFocusable(false);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				passwordField.setText("");
				lblNewLabel_2.setIcon(null);
				comboBox.setSelectedIndex(-1);
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnReset.setForeground(Color.RED);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBackground(UIManager.getColor("Button.background"));
		btnReset.setBounds(893, 455, 93, 51);
		panel_1.add(btnReset);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setFocusable(false);
		btnNewButton.setIcon(new ImageIcon(AddStudent.class.getResource("/GuiSwing2/Imgs/user_add.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( dateChooser.getDate()!=null) {
						
				String name = textField.getText();
				String username = textField_1.getText();
				String pass = passwordField.getText();
				String email = textField_2.getText();
				String mobile = textField_3.getText();
				String rollno = textField_4.getText();
				String branch = comboBox.getSelectedItem().toString();
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				String date = df.format(dateChooser.getDate());
				String gender;
				if(rdbtnNewRadioButton.isSelected()) {
					gender = "Male";
					
				}
				else {
					gender = "Female";
				}
					
			
				 if(name.isEmpty()) {
					 JOptionPane.showMessageDialog(frame, "Enter Full Name","Error", 0,null);
				 }
				
				 else if( username.isEmpty()) {
					 JOptionPane.showMessageDialog(frame, "Enter Username","Error", 0, null);
				 } 
				 else if( pass.isEmpty()) {
					 JOptionPane.showMessageDialog(frame, "Enter password","Error", 0, null);
				 }
				 else if( email.isEmpty()) {
					 JOptionPane.showMessageDialog(frame, "Enter email","Error", 0, null);
				 }
				 else if( mobile.isEmpty()) {
					 JOptionPane.showMessageDialog(frame, "Enter mobile number","Error", 0, null);
				 }
				 else if(lblNewLabel_2.getIcon()==null) {
					 JOptionPane.showMessageDialog(frame, "Please attach your photo","Error", 0, null);
				 }
				 else if(rollno.isEmpty()) {
					 if(user=="Student") {
					 JOptionPane.showMessageDialog(frame, "Enter Roll number","Error", 0, null);
					 }
					
					 else {
						 JOptionPane.showMessageDialog(frame, "Enter code number","Error", 0, null); 
					 }
				 }
				 else {
					
						 
					 try {
				            Class.forName("com.mysql.cj.jdbc.Driver"); //Register the mysql driver
				            con1 = DriverManager.getConnection("jdbc:mysql://localhost/schoolmanagement","root","");
				            
				            insert = con1.prepareStatement("select username from students where rollno = ?");
				            insert.setString(1,rollno);
				           
				           
				           rs= insert.executeQuery();
				            if(rs.next()) {
				            	JOptionPane.showMessageDialog(null,"Student Already registered", "ERROR", JOptionPane.PLAIN_MESSAGE);
				            }

				            else {
				            
				            insert = con1.prepareStatement("insert into students(name,username,pass,branch,mobile,email,gender,dob,image,rollno)values(?,?,?,?,?,?,?,?,?,?)");
				            insert.setString(1,name);
				            insert.setString(2,username);
				            insert.setString(3,pass);
				            insert.setString(4,branch);
				            insert.setString(5,mobile);
				            insert.setString(6,email);
				            insert.setString(7,gender);
				            insert.setString(8,date);
				            insert.setString(9,filepath);
				            insert.setString(10,rollno);

				            insert.executeUpdate();
				            JOptionPane.showMessageDialog(null,"Student Registered Successfully!!", "Success", JOptionPane.PLAIN_MESSAGE);
				            }
				          
				        } catch (ClassNotFoundException ex) {
				        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				        } catch (SQLException ex) {
				        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				        } 
//				Login lg = new Login(user,user);
				frame.setVisible(false);
				 }
				 
				 
				 }
				else {
					JOptionPane.showMessageDialog(frame, "Please fill all details","Error", 0, null);
				}
			}
			
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(785, 455, 98, 51);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email :");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_2.setBounds(87, 291, 135, 45);
		panel_1.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.GREEN);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.BLACK);
		textField_2.setBounds(232, 301, 313, 26);
		panel_1.add(textField_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Mobile no:");
		lblNewLabel_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_2.setBounds(87, 240, 135, 45);
		panel_1.add(lblNewLabel_1_1_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.GREEN);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.BLACK);
		textField_3.setBounds(232, 250, 313, 26);
		panel_1.add(textField_3);
		
		
		JLabel lblNewLabel_1_3 = new JLabel("Roll No :");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_3.setBackground(Color.WHITE);
		lblNewLabel_1_3.setBounds(664, 271, 135, 45);
		panel_1.add(lblNewLabel_1_3);
		
	
		
	}
}
