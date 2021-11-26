package GuiSwing2;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JTextField;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.UIManager;

public class Checkattend {
	public static Connection con1;
	public static PreparedStatement insert;
	static String username;
	static String usertype;
	static String code;
	static String standard;
	static String date="";
	private JFrame frame;
	private JTextField textField_2;
	static String sub ;
	
	/**
	 * Launch the application.
	 */
	public Checkattend (String usern , String usert,String stand ,String code) {
		this.standard = stand;
		this.code = code;
		this.username = usern;
		this.usertype = usert;
		initialize();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkattend  window = new Checkattend (username,usertype,standard,code);
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
		frame.getContentPane().setBackground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 756, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.menuText, 6));
		panel.setBackground(new Color(245, 245, 220));
		panel.setBounds(20, 125, 696, 348);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Date :");
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1_1.setBounds(176, 127, 59, 29);
		panel.add(lblNewLabel_1_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBackground(new Color(240, 230, 140));
		panel_1.setBounds(20, 23, 696, 92);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Attendance");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 676, 72);
		panel_1.add(lblNewLabel);
		
		
		
		
	
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(Checkattend.class.getResource("/GuiSwing2/Imgs/redo.png")));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				textField_2.setText("");
			}
		});
		btnReset.setForeground(Color.RED);
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnReset.setBackground(UIManager.getColor("Button.background"));
		btnReset.setBounds(369, 177, 118, 44);
		panel.add(btnReset);
		
		JButton btnBack = new JButton("");
		btnBack.setFocusable(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherLogin Tl = new TeacherLogin(username,usertype,standard,code);
				 frame.setVisible(false);
				
				
				
			}
		});
		btnBack.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnBack.setIcon(new ImageIcon(Checkattend.class.getResource("/GuiSwing2/images/previous.png")));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setBounds(10, 10, 68, 44);
		panel.add(btnBack);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Standard");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(164, 68, 80, 26);
		panel.add(lblNewLabel_1_2_1);
		
		textField_2 = new JTextField();
		textField_2.setText(standard);
		textField_2.setForeground(Color.ORANGE);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.BLACK);
		textField_2.setBounds(249, 69, 238, 26);
		panel.add(textField_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(245, 127, 242, 29);
		panel.add(dateChooser);
		
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		 

		JButton btnNewButton = new JButton("Check");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = df.format(dateChooser.getDate());
			    System.out.println(date);
			    Attendsheet as = new Attendsheet(username,usertype,standard,code, date);
			    frame.setVisible(false);
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(245, 177, 114, 44);
		panel.add(btnNewButton);
		
		
		
	
	}
}
