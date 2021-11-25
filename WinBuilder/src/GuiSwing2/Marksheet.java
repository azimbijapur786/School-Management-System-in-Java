package GuiSwing2;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;

public class Marksheet {
	public static String padString(String word, int length) {
	    String newWord = word;
	    for(int count = word.length(); count <= length; count++) {
	        newWord = newWord+" ";
	    }
	    return newWord;
	}
	public static ResultSet rs;
	static String username;
	static String usertype;
	static String standard;
	static String user;
	static String code;

	boolean flag = false;
	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	JLabel lblNewLabel_1_1_1 ;
	JLabel lblNewLabel_1_1_1_3;
	JLabel lblNewLabel_1_1_1_4;
	JLabel lblNewLabel_1_1_1_4_1;
	JLabel lblNewLabel_1_1_1_4_1_1;
	public static Connection con1;
	public static PreparedStatement insert;
	/**
	 * Launch the application.
	 */
	public Marksheet(String user,String usert,String standard,String code) {
		this.code = code;
		this.standard = standard;
		this.username = user;
		this.usertype = usert;
		System.out.println(username+" "+usertype+" "+ standard +" "+code);
		initialize();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marksheet window = new Marksheet(username,usertype,standard,code);
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
		frame.setBounds(100, 100, 1352, 795);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 3));
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(10, 20, 1321, 71);
		frame.getContentPane().add(panel);
		
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Marksheet Generator");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 1289, 51);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 38));
		lblNewLabel.setForeground(Color.BLACK);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(10, 101, 1321, 644);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Roll No :");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(24, 21, 135, 45);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Full Name :");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1.setBounds(24, 75, 135, 45);
		panel_1.add(lblNewLabel_1_1);
		
		JTextField textField = new JTextField();
				textField.setBackground(Color.BLACK);
		textField.setForeground(new Color(255, 255, 0));
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField.setBounds(158, 31, 313, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		 textField_1 = new JTextField();
		textField_1.setForeground(Color.GREEN);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(158, 85, 313, 26);
		panel_1.add(textField_1);
		
		
		
		
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Standard :");
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_1.setBounds(24, 130, 135, 45);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFocusTraversalKeysEnabled(false);
		comboBox.setFocusable(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"8", "9", "10"}));
		comboBox.setForeground(Color.GREEN);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setBackground(Color.BLACK);
		comboBox.setBounds(158, 140, 313, 26);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Gender :");
		lblNewLabel_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_1_1.setBounds(257, 239, 135, 45);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFocusable(false);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setForeground(Color.RED);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnNewRadioButton.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton.setBounds(358, 252, 71, 21);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setForeground(Color.RED);
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnFemale.setFocusable(false);
		rdbtnFemale.setBackground(SystemColor.activeCaption);
		rdbtnFemale.setBounds(431, 252, 104, 21);
		panel_1.add(rdbtnFemale);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Semester");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_1_1_1.setBounds(24, 240, 135, 45);
		panel_1.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Date :");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(24, 296, 135, 45);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JComboBox comboBox_1_2 = new JComboBox();
		comboBox_1_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		comboBox_1_2.setMaximumRowCount(1);
		comboBox_1_2.setForeground(Color.GREEN);
		comboBox_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox_1_2.setBackground(Color.BLACK);
		comboBox_1_2.setBounds(158, 250, 81, 26);
		panel_1.add(comboBox_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Mobile no:");
		lblNewLabel_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_2.setBounds(24, 185, 135, 45);
		panel_1.add(lblNewLabel_1_1_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.GREEN);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.BLACK);
		textField_3.setBounds(158, 195, 313, 26);
		panel_1.add(textField_3);
		
		
		lblNewLabel_1_1_1 = new JLabel("ENGLISH");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1.setBounds(24, 388, 135, 45);
		panel_1.add(lblNewLabel_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.GREEN);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.BLACK);
		textField_4.setBounds(257, 398, 91, 26);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Out of");
		lblNewLabel_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_2.setBounds(358, 388, 81, 45);
		panel_1.add(lblNewLabel_1_1_1_2);
		
		textField_5 = new JTextField();
		textField_5.setForeground(Color.GREEN);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_5.setColumns(10);
		textField_5.setBackground(Color.BLACK);
		textField_5.setBounds(444, 398, 91, 26);
		panel_1.add(textField_5);
		
		lblNewLabel_1_1_1_3 = new JLabel("MATHS");
		lblNewLabel_1_1_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_3.setBounds(24, 434, 135, 45);
		panel_1.add(lblNewLabel_1_1_1_3);
		
		 lblNewLabel_1_1_1_4 = new JLabel("SCIENCE");
		lblNewLabel_1_1_1_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1_1_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_4.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_4.setBounds(24, 477, 178, 45);
		panel_1.add(lblNewLabel_1_1_1_4);
		
		lblNewLabel_1_1_1_4_1 = new JLabel("HISTORY");
		lblNewLabel_1_1_1_4_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_4_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_4_1.setBounds(24, 522, 178, 45);
		panel_1.add(lblNewLabel_1_1_1_4_1);
		
		lblNewLabel_1_1_1_4_1_1 = new JLabel("GEOGRAPHY");
		lblNewLabel_1_1_1_4_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_4_1_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_4_1_1.setBounds(24, 575, 151, 37);
		panel_1.add(lblNewLabel_1_1_1_4_1_1);
		
		textField_6 = new JTextField();
		textField_6.setForeground(Color.GREEN);
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_6.setColumns(10);
		textField_6.setBackground(Color.BLACK);
		textField_6.setBounds(257, 444, 91, 26);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setForeground(Color.GREEN);
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_7.setColumns(10);
		textField_7.setBackground(Color.BLACK);
		textField_7.setBounds(257, 487, 91, 26);
		panel_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setForeground(Color.GREEN);
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_8.setColumns(10);
		textField_8.setBackground(Color.BLACK);
		textField_8.setBounds(257, 532, 91, 26);
		panel_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setForeground(Color.GREEN);
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_9.setColumns(10);
		textField_9.setBackground(Color.BLACK);
		textField_9.setBounds(257, 581, 91, 26);
		panel_1.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setForeground(Color.GREEN);
		textField_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_10.setColumns(10);
		textField_10.setBackground(Color.BLACK);
		textField_10.setBounds(444, 444, 91, 26);
		panel_1.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setForeground(Color.GREEN);
		textField_11.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_11.setColumns(10);
		textField_11.setBackground(Color.BLACK);
		textField_11.setBounds(444, 487, 91, 26);
		panel_1.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setForeground(Color.GREEN);
		textField_12.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_12.setColumns(10);
		textField_12.setBackground(Color.BLACK);
		textField_12.setBounds(444, 532, 91, 26);
		panel_1.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setForeground(Color.GREEN);
		textField_13.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_13.setColumns(10);
		textField_13.setBackground(Color.BLACK);
		textField_13.setBounds(444, 575, 91, 26);
		panel_1.add(textField_13);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Out of");
		lblNewLabel_1_1_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_2_1.setBounds(358, 434, 81, 45);
		panel_1.add(lblNewLabel_1_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_2_2 = new JLabel("Out of");
		lblNewLabel_1_1_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_2_2.setBounds(358, 477, 81, 45);
		panel_1.add(lblNewLabel_1_1_1_2_2);
		
		JLabel lblNewLabel_1_1_1_2_3 = new JLabel("Out of");
		lblNewLabel_1_1_1_2_3.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_2_3.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_2_3.setBounds(358, 522, 81, 45);
		panel_1.add(lblNewLabel_1_1_1_2_3);
		
		JLabel lblNewLabel_1_1_1_2_4 = new JLabel("Out of");
		lblNewLabel_1_1_1_2_4.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_2_4.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_1_1_1_2_4.setBounds(358, 567, 81, 45);
		panel_1.add(lblNewLabel_1_1_1_2_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.BLACK, 3));
		panel_2.setBackground(SystemColor.scrollbar);
		panel_2.setBounds(10, 372, 544, 250);
		panel_1.add(panel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Times New Roman", Font.BOLD, 18));
		dateChooser.setBackground(Color.BLACK);
		dateChooser.setForeground(Color.GREEN);
		dateChooser.setBounds(158, 305, 163, 31);
		panel_1.add(dateChooser);
		

//		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(Marksheet.class.getResource("/GuiSwing2/Imgs/back.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				Mainmenu mm = new Mainmenu(username,usertype,branch,rollno);
				TeacherLogin Tl = new TeacherLogin(username,usertype,standard,code);
				 frame.setVisible(false);
			}
		});
		btnBack.setFocusable(false);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setBounds(1189, 540, 91, 60);
		panel_1.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(661, 75, 537, 404);
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setForeground(Color.BLACK);
		textArea.setBackground(Color.WHITE);
		textArea.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
		textArea.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("RESULT");
		lblNewLabel_2.setBorder(new LineBorder(Color.BLACK, 3));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_2.setBounds(661, 21, 529, 45);
		panel_1.add(lblNewLabel_2);
		
	JButton btnReset = new JButton("Reset");
	btnReset.setIcon(new ImageIcon(Marksheet.class.getResource("/GuiSwing2/Imgs/erase.png")));
		btnReset.setFocusable(false);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setBorder(new LineBorder(new Color(255, 0, 0), 4));
				lblNewLabel_2.setBackground(Color.ORANGE);
				lblNewLabel_2.setForeground(Color.RED);
				lblNewLabel_2.setText("RESULT");
				textField.setText("");
				textField_1.setText("");
				
			
				comboBox.setSelectedIndex(-1);
//				textField_2.setText("");
				textField_3.setText("");
				textArea.setText("");
				
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("") ;
				textField_10.setText("") ;
				textField_7.setText("") ;
				textField_11.setText("") ;
				textField_8.setText(""); 
				textField_12.setText("") ; 
				textField_9.setText("");
				textField_13.setText(""); 
				
				
				
				
				
				 textArea.setText(
		                 
						 "----------------------------------------K.C.Gandhi English School-------------------------------------\n"
						            + "_____________________________________________________________________________\n"
		                         );
				
			}
		});
		btnReset.setForeground(Color.RED);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset.setBackground(UIManager.getColor("Button.background"));
		btnReset.setBounds(898, 539, 123, 61);
		panel_1.add(btnReset);
		
		
		textArea.setText(
                
                "----------------------------------------K.C.Gandhi English School-------------------------------------\n"
               + "_____________________________________________________________________________\n"
                );
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.setIcon(new ImageIcon(Marksheet.class.getResource("/GuiSwing2/Imgs/contract.png")));
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(new LineBorder(Color.BLACK, 2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Rollno = textField.getText();
				String fullname = textField_1.getText();
				String standard = comboBox.getSelectedItem().toString();
//				String email = textField_2.getText();
				String mobile = textField_3.getText();
				String year =  comboBox_1_2.getSelectedItem().toString();
//				String date = comboBox_1.getSelectedItem().toString()+"/"+comboBox_1_1.getSelectedItem().toString()+"/"+comboBox_1_1_1.getSelectedItem().toString();
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				String date = df.format(dateChooser.getDate());
				
				
				String English = textField_4.getText();
				String Englishoutof = textField_5.getText();
				String Maths = textField_6.getText() ;
				String Mathsoutof =textField_10.getText() ;
				String Science =textField_7.getText() ;
				String Scienceoutof =textField_11.getText() ;
				String History = textField_8.getText(); 
				String Historyoutof =textField_12.getText() ; 
				String Geography = textField_9.getText();
				String Geographyoutof = textField_13.getText(); 
				String gender;
				
				if(rdbtnNewRadioButton.isSelected()) {
					gender = "Male";
					
				}
				else {
					gender = "Female";
				}
				
				 if(Rollno.isEmpty()) {
					 JOptionPane.showMessageDialog(frame, "Enter Roll no.","Error", 0,null);
				 }
				 else if( fullname.isEmpty()) {
					 JOptionPane.showMessageDialog(frame, "Enter Full name","Error", 0, null);
				 } 
				 
//				 else if( email.isEmpty()) {
//					 JOptionPane.showMessageDialog(frame, "Enter email","Error", 0, null);
//				 }
				 else if( mobile.isEmpty()) {
					 JOptionPane.showMessageDialog(frame, "Enter mobile number","Error", 0, null);
				 }
				 else if( English.isEmpty() || Englishoutof.isEmpty() || Maths.isEmpty() || Mathsoutof.isEmpty() || Science.isEmpty() || Scienceoutof.isEmpty() || History.isEmpty() || Historyoutof.isEmpty() || Geography.isEmpty() || Geographyoutof.isEmpty()) {
					 JOptionPane.showMessageDialog(frame, "Enter all marks please","Error", 0, null);
				 }
				 else {
					 int iEnglish = Integer.parseInt(English);
					 int iEnglishoutof = Integer.parseInt(Englishoutof);
					 int iMaths = Integer.parseInt(Maths);
					 int iMathsoutof = Integer.parseInt(Mathsoutof);
					 int iScience = Integer.parseInt(Science);
					 int iScienceoutof = Integer.parseInt(Scienceoutof);
					 int iHistory = Integer.parseInt(History);
					 int iHistoryoutof = Integer.parseInt(Historyoutof);
					 int iGeography = Integer.parseInt(Geography);
					 int iGeographyoutof = Integer.parseInt(Geographyoutof);
					  
					 int marks = iEnglish+iMaths+iScience+iHistory+iGeography;
					 int total = iEnglishoutof+iMathsoutof+iScienceoutof+iHistoryoutof +iGeographyoutof;
					 String mark = String.valueOf(marks);
					 String tot = String.valueOf(total);
					 float percentage = (marks*100)/total;
					 String percent = String.valueOf(percentage);
					 if(percentage<=35.0) {
					
						 lblNewLabel_2.setText("FAIL");
							lblNewLabel_2.setBackground(Color.PINK);
							lblNewLabel_2.setForeground(Color.RED);
						
					 }
					 else {
						 lblNewLabel_2.setBorder(new LineBorder(new Color(0, 100, 0)));
						 lblNewLabel_2.setText("PASS!!");
							lblNewLabel_2.setBackground(Color.GREEN);
							lblNewLabel_2.setForeground(new Color(0, 100, 0));
							
					 }
					 flag = true;
					 String text ="";
					 String sub1 = padString(lblNewLabel_1_1_1.getText().toString(),50);
					 String sub2 =padString(lblNewLabel_1_1_1_3.getText().toString(),50);
					 String sub3 = padString(lblNewLabel_1_1_1_4.getText().toString(),50);
					 String sub4 = padString(lblNewLabel_1_1_1_4_1.getText().toString(),50);
					 String sub5 = padString(lblNewLabel_1_1_1_4_1_1.getText().toString(),43);
					 
					
					 
					 
					 
					textArea.setText(textArea.getText()+
							         "Name :"+fullname+"\t"
							         +"Roll no :"+Rollno+
							         "\n"+"Standard :"+standard+"\t"+
							         "Sem :"+year+"\t"+
//							         "\nE-mail :"+email+"\t"+
							         "Date :"+date+"\n"+
							         "__________________________________________________________________________\n"
							         
							         );
					 textArea.setText(textArea.getText()+"Subjects                                           "+"Marks\n"+
							         "__________________________________________________________________________\n"+
							         sub1+English+"/"+Englishoutof+"\n"+
							          sub2+Maths+"/"+Mathsoutof+"\n"
							           +sub3+Science+"/"+Scienceoutof+"\n"
							           +sub4+History+"/"+Historyoutof+"\n"
							           +sub5+Geography+"/"+Geographyoutof+"\n"+
							           "__________________________________________________________________________\n");
					 
					
				
					 textArea.setText(textArea.getText()+"Total                                               "+marks+"/"+tot+""+
					 
							 "         Percantage :"+percent+"%\n");
					
					 textArea.setText(textArea.getText()+"\nTeacher :"+username+"\n"+"__________________________________________________________________________\n");
					 
					
//				
				 }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(869, 485, 135, 46);
		panel_1.add(btnNewButton);
		JButton btnLoginPage = new JButton("Print");
		btnLoginPage.setIcon(new ImageIcon(Marksheet.class.getResource("/GuiSwing2/Imgs/printer.png")));
		btnLoginPage.setFocusable(false);
		btnLoginPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==true) {
				 try {
                     textArea.print();
                 }
                 catch (java.awt.print
                         .PrinterException a) {
                     System.err.format(
                             "NoPrinter Found",
                             a.getMessage());
                 }
				}
				else {
					 JOptionPane.showMessageDialog(frame, "Please fill all Enteries","Error", 0, null);
				}
				
			}
		});
		btnLoginPage.setForeground(Color.BLACK);
		btnLoginPage.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLoginPage.setBackground(UIManager.getColor("Button.background"));
		btnLoginPage.setBounds(601, 540, 135, 61);
		panel_1.add(btnLoginPage);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setIcon(new ImageIcon(Marksheet.class.getResource("/GuiSwing2/Imgs/diskette.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==true) {
				try {
                    FileWriter fw
                            = new FileWriter(
                            "marksheetsrecord.txt", true);
                    fw.write("\n\n\n"+textArea.getText());
                    fw.close();
                }
                catch (Exception ae) {
                    System.out.println(ae);
                }
				  JOptionPane.showMessageDialog(
	                        panel_1, "DATA SAVED SUCCESSFULLY");
				}
				else {
					JOptionPane.showMessageDialog(frame, "Please fill all Enteries","Error", 0, null);
				}
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setBounds(755, 540, 123, 60);
		panel_1.add(btnNewButton_1);
		
		JButton btnSend = new JButton("Send");
		btnSend.setIcon(new ImageIcon(Marksheet.class.getResource("/GuiSwing2/Imgs/send.png")));
		btnSend.setSelectedIcon(new ImageIcon("D:\\java\\javaproj\\JavaProject\\src\\images\\send.png"));
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==true) {
				 try {
					
			            Class.forName("com.mysql.cj.jdbc.Driver"); //Register the mysql driver
			            con1 = DriverManager.getConnection("jdbc:mysql://localhost/schoolmanagement","root","");
			            insert = con1.prepareStatement("insert into marksheet(marksheet,result,rollno,branch,sem)values(?,?,?,?,?)");
			            insert.setString(1,textArea.getText());
			            insert.setString(2,lblNewLabel_2.getText());
			            insert.setString(3,textField.getText());
			            insert.setString(4,comboBox.getSelectedItem().toString());
			            insert.setString(5,comboBox_1_2.getSelectedItem().toString());

			            insert.executeUpdate();
			            JOptionPane.showMessageDialog(null,"Result Sent to "+textField_1.getText()+" successfully", "Success", JOptionPane.PLAIN_MESSAGE);
			            
			          
			        } catch (ClassNotFoundException ex) {
			        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
			        } catch (SQLException ex) {
			        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
			        } 
				}
				else {
					JOptionPane.showMessageDialog(frame, "Please fill all Enteries","Error", 0, null);
				}
			}
		});
		btnSend.setForeground(Color.BLACK);
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSend.setFocusable(false);
		btnSend.setBackground(UIManager.getColor("Button.background"));
		btnSend.setBounds(1046, 540, 123, 61);
		panel_1.add(btnSend);
		
	
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					
					 try {
				            Class.forName("com.mysql.cj.jdbc.Driver"); //Register the mysql driver
				            con1 = DriverManager.getConnection("jdbc:mysql://localhost/schoolmanagement","root","");
				            insert = con1.prepareStatement("select name,branch,email,mobile,gender from students where rollno = ?");
				            insert.setString(1,textField.getText());
				           
				           
				           rs= insert.executeQuery();
				            if(rs.next()==false) {
				            	JOptionPane.showMessageDialog(null,"Student not found", "ERROR", JOptionPane.PLAIN_MESSAGE);
				            }
				            else {
				            	String name2= rs.getString("name");
				            	textField_1.setText(name2);
				            	String email2 = rs.getString("email");
//				            	textField_2.setText(email2);
				            	String mobileno2 = rs.getString("mobile");
				            	textField_3.setText(mobileno2);
				            	String gender2 = rs.getString("gender");
				            	if(gender2.equals("Male")) {
				            		rdbtnNewRadioButton.setSelected(true);
				            	}
				            	else {
				            		rdbtnFemale.setSelected(true);
				            	}
				            
				            }
				            
				        } catch (ClassNotFoundException ex) {
				        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				        } catch (SQLException ex) {
				        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
				        } 
			 	}
					
					
					
				}
				
			}
		);

//		 JSeparator s = new JSeparator();
//         
//	        // set layout as vertical
//	        s.setOrientation(SwingConstants.VERTICAL);
//	         
//	      
//	        panel_1.add(s);
	}
	}


