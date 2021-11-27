package GuiSwing2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;



import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class ViewMarksheet {
	Boolean flag=false;
	JTextArea textArea;
	public static PreparedStatement insert;
	public static Connection con1;
	public static ResultSet rs;
	static String username;
	static String standard;
	static String rollno;
	static String usertype;
	private JFrame frmViewMarksheet;
	private JTextField getRollMarksheet;
	private JTextField getClassMarksheet;

	/**
	 * Launch the application.
	 */
	
	public ViewMarksheet(String usern,String usert,String stand,String rollno) {
		this.username=usern;
		this.standard=stand;
		this.usertype=usert;
		this.rollno=rollno;
		frmViewMarksheet = new JFrame();
		frmViewMarksheet.getContentPane().setBackground(new Color(250, 250, 210));
		frmViewMarksheet.setTitle("View Marksheet");
		frmViewMarksheet.setBounds(100, 100, 966, 568);
		frmViewMarksheet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewMarksheet.getContentPane().setLayout(null);
		frmViewMarksheet.setVisible(true);
		frmViewMarksheet.setResizable(false);
		frmViewMarksheet.setLocationRelativeTo(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(386, 71, 537, 404);
		frmViewMarksheet.getContentPane().add(scrollPane);
		
		 textArea = new JTextArea();
		 textArea.setEditable(false);
		textArea.setFont(new Font("Lucida Calligraphy", Font.BOLD, 13));
		scrollPane.setViewportView(textArea);
		
		
		JLabel ViewMarksheetTitle = new JLabel("View Marksheet");
		ViewMarksheetTitle.setFocusTraversalPolicyProvider(true);
		ViewMarksheetTitle.setHorizontalAlignment(SwingConstants.CENTER);
		ViewMarksheetTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		ViewMarksheetTitle.setBounds(0, 11, 942, 35);
		frmViewMarksheet.getContentPane().add(ViewMarksheetTitle);
		
		JLabel rollMarksheet = new JLabel("Roll No. :");
		rollMarksheet.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		rollMarksheet.setBounds(61, 103, 104, 42);
		frmViewMarksheet.getContentPane().add(rollMarksheet);
		
		JLabel classMarksheet = new JLabel("Sem");
		classMarksheet.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		classMarksheet.setBounds(61, 175, 104, 42);
		frmViewMarksheet.getContentPane().add(classMarksheet);
		
		getRollMarksheet = new JTextField(rollno);
		getRollMarksheet.setEditable(false);
		getRollMarksheet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getRollMarksheet.setBounds(175, 103, 159, 35);
		frmViewMarksheet.getContentPane().add(getRollMarksheet);
		getRollMarksheet.setColumns(10);
		
		getClassMarksheet = new JTextField();
		getClassMarksheet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getClassMarksheet.setColumns(10);
		getClassMarksheet.setBounds(175, 175, 159, 35);
		frmViewMarksheet.getContentPane().add(getClassMarksheet);
		
		JButton getMarksheetBtn = new JButton("Get Marksheet");
		getMarksheetBtn.setFocusable(false);
		getMarksheetBtn.setIcon(new ImageIcon(ViewMarksheet.class.getResource("/GuiSwing2/Imgs/icons8-document-50.png")));
		getMarksheetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sem = getClassMarksheet.getText();
				String roll = getRollMarksheet.getText();
				 if(roll.isEmpty()) {
					 JOptionPane.showMessageDialog(frmViewMarksheet, "Enter Roll no.","Error", 0,null);
				 }
				 else if(sem.isEmpty()) {
					 JOptionPane.showMessageDialog(frmViewMarksheet, "Enter Semester.","Error", 0,null);
				 }
				
				 else {
				
				 try {
			            Class.forName("com.mysql.cj.jdbc.Driver"); //Register the mysql driver
			            con1 = DriverManager.getConnection("jdbc:mysql://localhost/students","root","");
			            insert = con1.prepareStatement("select marksheet from marksheet where standard = ? and rollno = ? and sem = ?");
			            insert.setString(1,standard);
			            insert.setString(2,rollno);
			            insert.setString(3,sem);
			           rs= insert.executeQuery();
			         
			        
			            if(rs.next()==false) {
			            	JOptionPane.showMessageDialog(null,"Marksheet not found", "ERROR", JOptionPane.PLAIN_MESSAGE);
			            }
			            else {
			            String result = rs.getString("marksheet");
			            textArea.setText(result);
                         flag=true;
			           }

			            
			        } catch (ClassNotFoundException ex) {
			        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
			        } catch (SQLException ex) {
			        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
			        } 
				 }
				
			}
		});
		getMarksheetBtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		getMarksheetBtn.setBounds(61, 245, 241, 64);
		frmViewMarksheet.getContentPane().add(getMarksheetBtn);
		
		JButton btnPrintMarksheet = new JButton("Print Marksheet");
		btnPrintMarksheet.setFocusable(false);
		btnPrintMarksheet.setIcon(new ImageIcon(ViewMarksheet.class.getResource("/GuiSwing2/Imgs/printer.png")));
		btnPrintMarksheet.addActionListener(new ActionListener() {
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
						 JOptionPane.showMessageDialog(frmViewMarksheet, "Please fill all Enteries","Error", 0, null);
					}

			}
		});
		btnPrintMarksheet.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnPrintMarksheet.setBounds(61, 319, 241, 64);
		frmViewMarksheet.getContentPane().add(btnPrintMarksheet);
		
		JButton clearMarksheet = new JButton("Clear");
		clearMarksheet.setFocusable(false);
		clearMarksheet.setIcon(new ImageIcon(ViewMarksheet.class.getResource("/GuiSwing2/Imgs/erase.png")));
		clearMarksheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				getClassMarksheet.setText(null);
				textArea.setText(null);
			}
		});
		clearMarksheet.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		clearMarksheet.setBounds(59, 393, 243, 64);
		frmViewMarksheet.getContentPane().add(clearMarksheet);
		
		JButton BackMarksheet = new JButton("");
		BackMarksheet.setFocusable(false);
		BackMarksheet.setIcon(new ImageIcon(ViewMarksheet.class.getResource("/GuiSwing2/images/previous.png")));
		BackMarksheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				StudentLogin sl = new StudentLogin(username,usertype,standard,rollno);
				frmViewMarksheet.setVisible(false);
			}
		});
		BackMarksheet.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		BackMarksheet.setBounds(10, 11, 79, 42);
		frmViewMarksheet.getContentPane().add(BackMarksheet);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMarksheet window = new ViewMarksheet(username,usertype,standard,rollno);
					window.frmViewMarksheet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
