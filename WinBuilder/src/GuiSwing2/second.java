package GuiSwing2;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class second {

	private JFrame frmStudentProfile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					second window = new second();
					window.frmStudentProfile.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public second() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentProfile = new JFrame();
		frmStudentProfile.getContentPane().setBackground(new Color(240, 128, 128));
		frmStudentProfile.setTitle("CORAL COAST INTERNATIONAL HIGH SCHOOL");
		frmStudentProfile.setBounds(100, 100, 780, 466);
		frmStudentProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentProfile.setVisible(true);
		frmStudentProfile.setLocationRelativeTo(null);
		frmStudentProfile.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first first = new first();
				frmStudentProfile.setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(second.class.getResource("/GuiSwing2/images/previous.png")));
		btnNewButton.setBounds(6, 6, 68, 58);
		frmStudentProfile.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(second.class.getResource("/GuiSwing2/images/data-processing.png")));
		btnNewButton_1.setBounds(302, 138, 163, 85);
		frmStudentProfile.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("CLICK TO SEE STUDENT'S DATA");
		lblNewLabel.setBounds(282, 79, 204, 58);
		frmStudentProfile.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent student = new AddStudent();
				frmStudentProfile.setVisible(false);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setIcon(new ImageIcon(second.class.getResource("/GuiSwing2/images/follow.png")));
		btnNewButton_2.setBounds(120, 276, 167, 93);
		frmStudentProfile.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("ADD STUDENTS");
		lblNewLabel_1.setBounds(162, 239, 147, 35);
		frmStudentProfile.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFees af = new AddFees();
				frmStudentProfile.dispose();
				
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(second.class.getResource("/GuiSwing2/images/receipt.png")));
		btnNewButton_3.setBounds(463, 276, 163, 93);
		frmStudentProfile.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("ADD FEES RECEIPT");
		lblNewLabel_2.setBounds(488, 248, 119, 16);
		frmStudentProfile.getContentPane().add(lblNewLabel_2);
	}

}
