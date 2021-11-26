package GuiSwing2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
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
import java.awt.SystemColor;
import javax.swing.UIManager;

public class TimeTable {
	public static ResultSet rs;
	ImageIcon setImage;
	ImageIcon setImage1;
	public static Connection con1;
	public static PreparedStatement insert;
	private JFrame frame;
	static String username;
	static String usertype;
	static String standard;
	static String rollno;
	static String code;
	 public String path;
	 JLabel lblNewLabel_1;
	 TimeTable(String user,String usert,String std, String rn){
		
		this.username=user;
		this.usertype=usert;
		this.standard= std;
		if(usertype=="student") {
			this.rollno=rn;
		}
		else {
			this.code=rn;
		}
		
		initialize();
		load_tt();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(usertype=="Student") {
						TimeTable window = new TimeTable(username,usertype,standard,rollno);
						window.frame.setVisible(true);
					}
					else {
						TimeTable window = new TimeTable(username,usertype,standard,code);
						window.frame.setVisible(true);
					}
					
					
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
		frame.getContentPane().setBackground(new Color(255, 239, 213));
		frame.setResizable(false);
		frame.setBounds(100, 100, 908, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 3));
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(10, 10, 875, 67);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Time Table");
		lblNewLabel.setBounds(0, 10, 875, 49);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1.setBounds(10, 87, 875, 354);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
	 lblNewLabel_1 = new JLabel("");
	 lblNewLabel_1.setBounds(10, 10, 855, 331);
	 panel_1.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Update");
		if(usertype=="teacher") {
			btnNewButton.setEnabled(true);
		}
		else {
			btnNewButton.setEnabled(false);
		}
		btnNewButton.setIcon(new ImageIcon(TimeTable.class.getResource("/GuiSwing2/Imgs/redo.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String currentDirectory = System.getProperty("user.dir");
				  JFileChooser fc=new JFileChooser(currentDirectory+"\\WinBuilder\\src\\GuiSwing2\\User_images\\");
				
				
//				  JFileChooser fc=new JFileChooser("D:\\java\\images");    
				    int i=fc.showOpenDialog(panel_1);    
				    Path temp = null;
				    if(i==JFileChooser.APPROVE_OPTION){   
				    	  
				        File f=fc.getSelectedFile();    
				        String filepath=f.getPath();   
				        ImageIcon icon = new ImageIcon(filepath);
				    	Image image = icon.getImage();
				    	Image imgscale = image.getScaledInstance(lblNewLabel_1.getWidth(),lblNewLabel_1.getHeight(),Image.SCALE_SMOOTH);
				    	ImageIcon scaledicon = new ImageIcon(imgscale);
				        lblNewLabel_1.setIcon(scaledicon);
				        setImage = new ImageIcon(imgscale);
				        
				        try {
				            Class.forName("com.mysql.cj.jdbc.Driver"); //Register the mysql driver
				            con1 = DriverManager.getConnection("jdbc:mysql://localhost/students","root","");
				            insert = con1.prepareStatement("update timetable set filepath = ? where standard = ?");
				            insert.setString(1,filepath);
				            insert.setString(2,standard);
				          
				            insert.executeUpdate();
				            JOptionPane.showMessageDialog(null,"Time Table Updated successfully", "Success", JOptionPane.PLAIN_MESSAGE);
				            
				          
				        } catch (ClassNotFoundException ex) {
				        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				        } catch (SQLException ex) {
				        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				        } 
				    }    
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(734, 451, 150, 57);
		frame.getContentPane().add(btnNewButton);
//		
//		JButton btnSet = new JButton("Set");
//		if(usertype=="Teacher") {
//			btnSet.setEnabled(true);
//		}
//		else {
//			btnSet.setEnabled(false);
//		}
//		btnSet.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				lblNewLabel_1.setIcon(setImage);
//				
//			}
//		});
//		btnSet.setForeground(Color.WHITE);
//		btnSet.setFont(new Font("Times New Roman", Font.BOLD, 18));
//		btnSet.setFocusable(false);
//		btnSet.setBackground(Color.MAGENTA);
//		btnSet.setBounds(657, 479, 119, 57);
//		frame.getContentPane().add(btnSet);
		
		JButton btnBack = new JButton("back");
		btnBack.setIcon(new ImageIcon(TimeTable.class.getResource("/GuiSwing2/Imgs/back.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usertype=="student") {
//					Mainmenu mm = new Mainmenu(username,usertype,standard,rollno);
					StudentLogin sl = new StudentLogin(username,usertype,standard,rollno);
					
					 frame.setVisible(false);
				}
				else if(usertype=="teacher"){
//					Mainmenu mm = new Mainmenu(username,usertype,standard,code);
					TeacherLogin Tl = new TeacherLogin(username,usertype,standard,code);
					 frame.setVisible(false);
				}
				
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBack.setFocusable(false);
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setBounds(583, 451, 141, 57);
		frame.getContentPane().add(btnBack);
	}
	public void load_tt() {
		 try {
			 int c;
	            Class.forName("com.mysql.cj.jdbc.Driver"); //Register the mysql driver
	            con1 = DriverManager.getConnection("jdbc:mysql://localhost/students","root","");
	            insert = con1.prepareStatement("select * from timetable where standard=?");
	            insert.setString(1,standard);
	        
	           rs= insert.executeQuery();
	        if(rs.next()) {
	           path=rs.getString("filepath");
	           
	      	 ImageIcon icon1 = new ImageIcon(path);
		    	Image image1 = icon1.getImage();
		    	Image imgscale1 = image1.getScaledInstance(lblNewLabel_1.getWidth(),lblNewLabel_1.getHeight(),Image.SCALE_SMOOTH);
		    	ImageIcon scaledicon1 = new ImageIcon(imgscale1);
		        lblNewLabel_1.setIcon(scaledicon1);
		        setImage1 = new ImageIcon(imgscale1);
	        }
	            	 
	        } catch (ClassNotFoundException ex) {
	        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SQLException ex) {
	        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
	        } 
		
		
		
	}
}
