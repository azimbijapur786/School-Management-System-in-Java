package GuiSwing2;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

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

public class Annoucement {

	private JFrame frame;
	public static ResultSet rs;
	public static Connection con1;
	public static PreparedStatement insert;
	static String username;
	static String usertype;
	static String rollno;
	static String standard;
	static String code;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(usertype=="student") {
					Annoucement window = new Annoucement(username,usertype,standard,rollno);
					window.frame.setVisible(true);
					}
					else {
						Annoucement window = new Annoucement(username,usertype,standard,code);
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
	public Annoucement(String usern,String usert,String brnch, String rn) {
		this.username = usern;
		this.usertype = usert;
		this.standard = brnch;
		if(usertype=="student") {
			this.rollno = rn;
			
		}
		else {
			this.code=rn;
		}
		initialize();
		load_table();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 239, 213));
		frame.setBounds(100, 100, 1204, 674);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 3));
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(10, 10, 1170, 80);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Announcements");
		lblNewLabel.setIcon(new ImageIcon(Annoucement.class.getResource("/GuiSwing2/Imgs/icons8-commercial-48.png")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 1150, 60);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1178, 100, -1163, 453);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 239, 213));
		panel_1.setBounds(10, 562, 1164, 65);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Make Announcement");
		if(usertype=="student") {
			btnNewButton.setEnabled(false);
		}
		else {
			btnNewButton.setEnabled(true);
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Makeannouncement ma = new Makeannouncement(username,usertype,standard,code);
				frame.setVisible(false);
				
				
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setIcon(new ImageIcon(Annoucement.class.getResource("/GuiSwing2/Imgs/icons8-commercial-48.png")));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(759, 9, 271, 45);
		panel_1.add(btnNewButton);
		
		JButton btnBack = new JButton("back");
		btnBack.setForeground(Color.BLACK);
		btnBack.setFocusable(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usertype=="student") {

					StudentLogin sl = new StudentLogin(username,usertype,standard,rollno);
				
				 frame.setVisible(false);
				}
				else {

					TeacherLogin Tl = new TeacherLogin(username,usertype,standard,code);
					 frame.setVisible(false);
				}
			}
		});
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setIcon(new ImageIcon(Annoucement.class.getResource("/GuiSwing2/Imgs/back.png")));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBounds(1040, 10, 109, 45);
		panel_1.add(btnBack);
		
//		table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//			},
//			new String[] {
//				"Sr.no", "Announcement", "Date", "standard", "Teacher"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				Integer.class, Object.class, Object.class, Object.class, Object.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
//		table.getColumnModel().getColumn(1).setPreferredWidth(184);
//		table.setBounds(20, 100, 1160, 448);
//		frame.getContentPane().add(table);
		
		
		
		 table = new JTable();
//		 JTable table = new JTable();
		 table.setBorder(new LineBorder(new Color(0, 0, 0)));
		 table.setModel(new DefaultTableModel(
		 	new Object[][] {
		 		{null, null, null, null, null},
		 	},
		 	new String[] {
		 		"Sr.no", "Announcement", "Date", "standard", "Teacher"
		 	}
		 ) {
		 	boolean[] columnEditables = new boolean[] {
		 		false, false, false, false, false
		 	};
		 	public boolean isCellEditable(int row, int column) {
		 		return columnEditables[column];
		 	}
		 });
		 table.getColumnModel().getColumn(0).setPreferredWidth(53);
		 table.getColumnModel().getColumn(0).setMaxWidth(71);
		 table.getColumnModel().getColumn(1).setPreferredWidth(500);
		 table.getColumnModel().getColumn(2).setPreferredWidth(37);
		 table.getColumnModel().getColumn(3).setPreferredWidth(92);
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
//		table.getColumn(1).setCellRenderer(new TextTableRenderer());
//		table.setRowHeight(0, 80);
		table.setRowHeight(table.getRowHeight() + 20);
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(10, 103, 1164, 450);
		frame.getContentPane().add(sp);
		
		
		
		
		
	}
	
	
	public void load_table() {
		 try {
			 int c;
	            Class.forName("com.mysql.cj.jdbc.Driver"); //Register the mysql driver
	            con1 = DriverManager.getConnection("jdbc:mysql://localhost/students","root","");
	            insert = con1.prepareStatement("select * from announcement where standard=?");
	            insert.setString(1,standard);   
	           rs= insert.executeQuery();
	           ResultSetMetaData rss = rs.getMetaData();
	           c = rss.getColumnCount();
	           DefaultTableModel Df = (DefaultTableModel)table.getModel();
	           Df.setRowCount(0);
	           
	            while(rs.next()) {
	            	Vector v2 = new Vector();
	            	
	            	for(int a =1;a<=c;a++) {
	            		v2.add(rs.getString("id"));
	            		v2.add(rs.getString("announcement"));
	            		v2.add(rs.getString("date"));
	            		v2.add(rs.getString("standard"));
	            		v2.add(rs.getString("teacher"));
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



class TextTableRenderer extends JTextArea implements TableCellRenderer {
public TextTableRenderer() {
setOpaque(true);
setLineWrap(true);
setWrapStyleWord(true);
}

@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
		int row, int column) {
	// TODO Auto-generated method stub
	
	return null;
}


}