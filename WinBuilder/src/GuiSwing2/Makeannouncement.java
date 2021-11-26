package GuiSwing2;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import com.toedter.calendar.JDateChooser;

public class Makeannouncement {
	public static Connection con1;
	public static PreparedStatement insert;
	private JFrame frame;
	static String username;
	static String usertype;
	static String name;
	static String brnchhh;
	static String standard;
	static String date;
	static String code;
	static String announce;
	static String announcement;
	private JTextField textField;
	private JTextField textField_1;
	public static ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Makeannouncement window = new Makeannouncement(username,usertype,standard,code);
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
	public Makeannouncement(String usern,String usert,String brnch, String rn) {
		this.username = usern;
		this.usertype = usert;
		this.standard = brnch;
		this.code = rn;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 239, 213));
		frame.setBounds(100, 100, 571, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 3));
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(10, 10, 536, 52);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Make Announcement");
		lblNewLabel.setBackground(new Color(240, 230, 140));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 511, 32);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1.setBackground(new Color(255, 218, 185));
		panel_1.setBounds(10, 72, 536, 155);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Teacher :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(106, 10, 78, 28);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("standard :");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(106, 48, 78, 28);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Date :");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(106, 86, 78, 28);
		panel_1.add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setForeground(Color.GREEN);
		textField.setBackground(Color.BLACK);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField.setBounds(194, 17, 214, 19);
		textField.setText(username);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.GREEN);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(194, 55, 214, 19);
		textField_1.setText(standard);
		panel_1.add(textField_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Times New Roman", Font.BOLD, 18));
		dateChooser.setBounds(194, 96, 214, 18);
		panel_1.add(dateChooser);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(new Color(240, 230, 140));
		panel_2.setBounds(10, 237, 130, 134);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
	
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setFocusable(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Annoucement an = new Annoucement(username,usertype,standard,code);
				frame.setVisible(false);
				
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setBounds(12, 95, 108, 29);
		panel_2.add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("Announce Here ");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setBounds(252, 225, 195, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 255, 379, 106);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(0, 255, 0));
		textArea.setBackground(new Color(0, 0, 0));
		textArea.setBorder(new LineBorder(Color.BLACK, 4));
		textArea.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				name = textField.getText();
				brnchhh= textField_1.getText();
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				 date = df.format(dateChooser.getDate());
			
				
				
				announce = textArea.getText();
				if(name.isEmpty()) {
					 JOptionPane.showMessageDialog(frame, "Enter your name","Error", 0, null);
				}
				else if(brnchhh.isEmpty()) {
					 JOptionPane.showMessageDialog(frame, "Enter your standard","Error", 0, null);
				}
				else if(date.isEmpty()) {
					 JOptionPane.showMessageDialog(frame, "Enter date","Error", 0, null);
				}
				else if(announce.isEmpty()) {
					 JOptionPane.showMessageDialog(frame, "Announce something","Error", 0, null);
				}
				else {
					 try {
				            Class.forName("com.mysql.cj.jdbc.Driver"); //Register the mysql driver
				            con1 = DriverManager.getConnection("jdbc:mysql://localhost/students","root","");
				            insert = con1.prepareStatement("insert into announcement(announcement,date,standard,teacher)values(?,?,?,?)");
				            insert.setString(1,announce);
				            insert.setString(2,date);
				            insert.setString(3,brnchhh);
				            insert.setString(4,name);
				            
				        

				            insert.executeUpdate();
				            JOptionPane.showMessageDialog(null,"Announcement Done !!", "Success", JOptionPane.PLAIN_MESSAGE);
				            
				          
				        } catch (ClassNotFoundException ex) {
				        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				        } catch (SQLException ex) {
				        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				        } 
					
					
					
				}
				
			}
		});
		btnNewButton_1.setBounds(12, 17, 108, 29);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		panel_2.add(btnNewButton_1);
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnNewButton.setBounds(12, 56, 108, 29);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_2.add(btnNewButton);
		
	}
}
