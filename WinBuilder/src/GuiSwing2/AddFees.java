package GuiSwing2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFees {

	private JFrame frmFeesInfo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFees window = new AddFees();
					window.frmFeesInfo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddFees() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFeesInfo = new JFrame();
		frmFeesInfo.setTitle("CORAL COAST INTERNATIONAL HIGH SCHOOL");
		frmFeesInfo.setVisible(true);
		frmFeesInfo.getContentPane().setBackground(new Color(255, 228, 196));
		
		frmFeesInfo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME :");
		lblNewLabel.setBounds(178, 40, 61, 16);
		frmFeesInfo.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ROLL NO.:");
		lblNewLabel_1.setBounds(158, 104, 81, 16);
		frmFeesInfo.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CLASS :");
		lblNewLabel_2.setBounds(165, 164, 61, 16);
		frmFeesInfo.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("SECTION :");
		lblNewLabel_3.setBounds(145, 227, 81, 16);
		frmFeesInfo.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("FEES REFERENCE ID.:");
		lblNewLabel_4.setBounds(84, 285, 142, 16);
		frmFeesInfo.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("FEES PAID :");
		lblNewLabel_5.setBounds(145, 343, 81, 16);
		frmFeesInfo.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("FEES DUE :");
		lblNewLabel_6.setBounds(145, 393, 81, 16);
		frmFeesInfo.getContentPane().add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(251, 35, 130, 26);
		frmFeesInfo.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(251, 99, 130, 26);
		frmFeesInfo.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(251, 159, 130, 26);
		frmFeesInfo.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(251, 222, 130, 26);
		frmFeesInfo.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(251, 280, 130, 26);
		frmFeesInfo.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(251, 338, 130, 26);
		frmFeesInfo.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(251, 388, 130, 26);
		frmFeesInfo.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(AddFees.class.getResource("/images/diskette.png")));
		btnNewButton.setBounds(546, 328, 69, 56);
		frmFeesInfo.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("SAVE INFO");
		lblNewLabel_7.setBounds(545, 393, 81, 16);
		frmFeesInfo.getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
			}
			
		});
		btnNewButton_1.setIcon(new ImageIcon(AddFees.class.getResource("/images/clear.png")));
		btnNewButton_1.setBounds(654, 318, 71, 66);
		frmFeesInfo.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("CLEAR");
		lblNewLabel_8.setBounds(664, 393, 61, 16);
		frmFeesInfo.getContentPane().add(lblNewLabel_8);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				second second = new second();
				frmFeesInfo.setVisible(false);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AddFees.class.getResource("/images/previous.png")));
		btnNewButton_2.setBounds(6, 6, 55, 49);
		frmFeesInfo.getContentPane().add(btnNewButton_2);
		frmFeesInfo.setBounds(100, 100, 765, 485);
		frmFeesInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFeesInfo.setLocationRelativeTo(null);
	}
}
