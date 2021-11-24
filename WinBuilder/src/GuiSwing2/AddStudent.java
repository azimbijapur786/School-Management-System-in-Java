package GuiSwing2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudent {

	private JFrame frmCoralCoastInternational;
	private JTextField txtFirstName;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		JLabel lblNewLabel = new JLabel("NAME :");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblNewLabel.setBounds(53, 108, 77, 21);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel);
		
		txtFirstName = new JTextField();
		txtFirstName.setBackground(new Color(240, 255, 240));
		txtFirstName.setBounds(159, 105, 240, 32);
		frmCoralCoastInternational.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("GENDER :");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(415, 111, 97, 16);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("MALE");
		chckbxNewCheckBox.setBounds(524, 109, 97, 23);
		frmCoralCoastInternational.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("FEMALE");
		chckbxNewCheckBox_1.setBounds(633, 109, 128, 23);
		frmCoralCoastInternational.getContentPane().add(chckbxNewCheckBox_1);
		ButtonGroup bg = new ButtonGroup();
		bg.add(chckbxNewCheckBox);
		bg.add(chckbxNewCheckBox_1); 
		
		JLabel lblNewLabel_2 = new JLabel("ROLL NO. : ");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(49, 162, 114, 16);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(159, 156, 179, 32);
		frmCoralCoastInternational.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CLASS :");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(49, 218, 81, 16);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 212, 130, 32);
		frmCoralCoastInternational.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("SECTION :");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(49, 271, 97, 16);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(159, 263, 154, 37);
		frmCoralCoastInternational.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("ADDRESS :");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(49, 334, 97, 16);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel_5);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(159, 312, 226, 82);
		frmCoralCoastInternational.getContentPane().add(textPane);
		
		JLabel lblNewLabel_6 = new JLabel("EMAIL :");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(60, 424, 97, 16);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setBounds(159, 418, 210, 32);
		frmCoralCoastInternational.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("");
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
		btnNewButton_1.setIcon(new ImageIcon(AddStudent.class.getResource("/GuiSwing2/images/diskette.png")));
		btnNewButton_1.setBounds(645, 434, 71, 61);
		frmCoralCoastInternational.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("SAVE");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(655, 507, 61, 16);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 txtFirstName.setText("");
				 textField.setText("");
			     textField_1.setText("");
			     textField_2.setText("");
			     textPane.setText("");
			     textField_3.setText("");
			     
			     
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AddStudent.class.getResource("/GuiSwing2/images/clear.png")));
		btnNewButton_2.setBounds(759, 425, 81, 70);
		frmCoralCoastInternational.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_8 = new JLabel("CLEAR");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(779, 507, 61, 16);
		frmCoralCoastInternational.getContentPane().add(lblNewLabel_8);
	}
}
