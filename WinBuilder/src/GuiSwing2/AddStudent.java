package GuiSwing2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class AddStudent {

	private JFrame frmCoralCoastInternational;
	private JTextField txtFirstName;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	public static String filepath;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent window = new AddStudent();
					window.frmCoralCoastInternational.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCoralCoastInternational = new JFrame();
		frmCoralCoastInternational.setTitle("CORAL COAST INTERNATIONAL HIGH SCHOOL");
		frmCoralCoastInternational.getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		frmCoralCoastInternational.getContentPane().setBackground(new Color(255, 228, 196));
		frmCoralCoastInternational.setBounds(100, 100, 873, 571);
		frmCoralCoastInternational.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCoralCoastInternational.setLocationRelativeTo(null);
		frmCoralCoastInternational.setVisible(true);
		frmCoralCoastInternational.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblNewLabel.setBounds(53, 106, 77, 21);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel);
		
		txtFirstName = new JTextField();
		txtFirstName.setBackground(new Color(240, 255, 240));
		txtFirstName.setBounds(159, 105, 240, 32);
		frmCoralCoastInternational.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Gender :");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(49, 279, 97, 16);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("MALE");
		chckbxNewCheckBox.setBackground(new Color(255, 228, 196));
		chckbxNewCheckBox.setBounds(159, 279, 97, 23);
		frmCoralCoastInternational.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("FEMALE");
		chckbxNewCheckBox_1.setBackground(new Color(255, 228, 196));
		chckbxNewCheckBox_1.setBounds(242, 279, 128, 23);
		frmCoralCoastInternational.getContentPane().add(chckbxNewCheckBox_1);
		ButtonGroup bg = new ButtonGroup();
		bg.add(chckbxNewCheckBox);
		bg.add(chckbxNewCheckBox_1); 
		
		JLabel lblNewLabel_2 = new JLabel("Roll no :");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(53, 160, 114, 16);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(159, 156, 240, 32);
		frmCoralCoastInternational.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Standard");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(49, 216, 81, 16);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 212, 240, 32);
		frmCoralCoastInternational.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.BLACK, 7));
		panel_2.setBounds(608, 70, 162, 154);
		frmCoralCoastInternational.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		JLabel lblNewLabel_x = new JLabel("");
		
		
		lblNewLabel_x.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_x.setBounds(10, 10, 142, 134);
		panel_2.add(lblNewLabel_x);
		
		JButton btnChooseImage = new JButton("Choose Photo");
		btnChooseImage.setHorizontalAlignment(SwingConstants.LEFT);
		btnChooseImage.setIcon(new ImageIcon(AddStudent.class.getResource("/GuiSwing2/Imgs/folder_red.png")));
		btnChooseImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				 String currentDirectory = System.getProperty("user.dir");
				  JFileChooser fc=new JFileChooser(currentDirectory+"\\WinBuilder\\src\\GuiSwing2\\images\\");
//				  fc.setCurrentDirectory(new File("D:\\Java\\Images"));
				    int i=fc.showOpenDialog(frmCoralCoastInternational);    
				    Path temp = null;
				    if(i==JFileChooser.APPROVE_OPTION){   
				    	  
						
				    	
				
				        File f=fc.getSelectedFile();    
				        filepath=f.getPath();  
		
				        ImageIcon icon = new ImageIcon(filepath);
				    	Image image = icon.getImage();
				    	Image imgscale = image.getScaledInstance(lblNewLabel_x.getWidth(),lblNewLabel_x.getHeight(),Image.SCALE_SMOOTH);
				    	ImageIcon scaledicon = new ImageIcon(imgscale);
				        lblNewLabel_x.setIcon(scaledicon);
				                     
				    }    
			}
		});
		btnChooseImage.setFocusable(false);
		btnChooseImage.setForeground(Color.BLACK);
		btnChooseImage.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnChooseImage.setBackground(UIManager.getColor("Button.background"));
		btnChooseImage.setBounds(587, 234, 199, 45);
		
		frmCoralCoastInternational.getContentPane().add(btnChooseImage);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(52, 332, 97, 16);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel_5);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(159, 312, 240, 82);
		frmCoralCoastInternational.getContentPane().add(textPane);
		
		JLabel lblNewLabel_6 = new JLabel("EMAIL :");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(53, 422, 97, 16);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setBounds(159, 418, 240, 32);
		frmCoralCoastInternational.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  second second = new second();
			  frmCoralCoastInternational.setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddStudent.class.getResource("/GuiSwing2/images/previous.png")));
		btnNewButton.setBounds(6, 6, 62, 54);
		frmCoralCoastInternational.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setIcon(new ImageIcon(AddStudent.class.getResource("/GuiSwing2/images/diskette.png")));
		btnNewButton_1.setBounds(614, 436, 71, 61);
		frmCoralCoastInternational.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("SAVE");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(624, 507, 61, 16);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 txtFirstName.setText("");
				 textField.setText("");
			     textField_1.setText("");
			
			     textPane.setText("");
			     textField_3.setText("");
			     
			     
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AddStudent.class.getResource("/GuiSwing2/images/clear.png")));
		btnNewButton_2.setBounds(720, 436, 66, 61);
		frmCoralCoastInternational.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_8 = new JLabel("CLEAR");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(715, 507, 81, 16);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel_8);
	}
}
