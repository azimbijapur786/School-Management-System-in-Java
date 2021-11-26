package GuiSwing2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.TextField;
import javax.swing.JDesktopPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;



import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JEditorPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
import javax.swing.UIManager;

public class Classroom {
	public static ResultSet rs;
	public static Connection con1;
	public static PreparedStatement insert;
	private JFrame frame;


	static String username ;
	static String usertype;
	public static String standard;

	
	public static String name;
	public static String rollno;
	public static String code;
	public static String email;
	public static String mobileno;
	JTable table;
	/**
	 * Launch the application.
	 */
	
	
	
	
	
	public Classroom(String usern, String usert, String stand,String code) {
		this.code = code;
		this.standard = stand;
		this.username = usern;
		this.usertype= usert;
		
		initialize();
		load_table();
	
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classroom window = new Classroom(username,usertype,standard,code);
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
		frame.getContentPane().setBackground(new Color(255, 228, 196));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1197, 845);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 4));
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(10, 10, 1164, 81);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Classroom");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon(Classroom.class.getResource("/GuiSwing2/Imgs/icons8-google-classroom-48.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 13, 1144, 58);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 41));
		panel.add(lblNewLabel);
		

		
//		  String data[][]={ {"312034","Saif Ali","6700001231","saifmulla164@gmail.com"},    
////
//                  }; 
//		  String column[]={"Rollno","NAME","Mobile no.","Email"};    
		 table = new JTable();
//		 JTable table = new JTable();
		 table.setBorder(new LineBorder(new Color(0, 0, 0)));
		 table.setModel(new DefaultTableModel(
		 	new Object[][] {
		 		{},
		 	},
		 	new String[] {
		 		"Rollno", "NAME", "Mobile no.", "Email"
		 	}
		 ));
		 table.getColumnModel().getColumn(0).setPreferredWidth(71);
		 table.getColumnModel().getColumn(0).setMaxWidth(71);
		 table.setColumnSelectionAllowed(true);
		 table.setFont(new Font("Times New Roman", Font.BOLD, 18));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(1160, 205, -1155, -200);
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(Color.BLACK);
		table.getTableHeader().setForeground(Color.YELLOW);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		 table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
		table.setFillsViewportHeight(true);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);
		table.setRowHeight(table.getRowHeight() + 20);
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(10, 103, 1164, 644);
		frame.getContentPane().add(sp);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherLogin Tl = new TeacherLogin(username,usertype,standard,code);
				
				 frame.setVisible(false);
				
				
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setIcon(new ImageIcon(Classroom.class.getResource("/GuiSwing2/images/previous.png")));
		btnNewButton.setBounds(1123, 757, 51, 37);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
		
	}
	public void load_table() {
		 try {
			 int c;
	            Class.forName("com.mysql.cj.jdbc.Driver"); //Register the mysql driver
	            con1 = DriverManager.getConnection("jdbc:mysql://localhost/students","root","");
	            insert = con1.prepareStatement("select * from student where standard=? ");
	            insert.setString(1,standard);
	            
	           
	           rs= insert.executeQuery();
	           ResultSetMetaData rss = rs.getMetaData();
	           c = rss.getColumnCount();
	           DefaultTableModel Df = (DefaultTableModel)table.getModel();
	           Df.setRowCount(0);
	           
	            while(rs.next()) {
	            	Vector v2 = new Vector();
	            	
	            	for(int a =1;a<=c;a++) {
	            		v2.add(rs.getString("rollno"));
	            		v2.add(rs.getString("name"));
	            		v2.add(rs.getString("mobile"));
	            		v2.add(rs.getString("email"));
	            	}
	            	Df.addRow(v2);
	            }
	        
	            	 
//	            	name = rs.getString("name");
//	            	mobileno = rs.getString("mobile");
//	            	rollno = rs.getString("rollno");
//	            	email = rs.getString("email");
	            	
	            	
	            
	            
	        } catch (ClassNotFoundException ex) {
	        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (SQLException ex) {
	        	 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
	        } 
	}
}


