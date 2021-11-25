package GuiSwing2;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;

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
		btnNewButton.setFocusable(false);
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
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setIcon(new ImageIcon(second.class.getResource("/GuiSwing2/images/data-processing.png")));
		btnNewButton_1.setBounds(421, 165, 163, 91);
		frmStudentProfile.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("STUDENTS INFO");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(421, 97, 204, 58);
		frmStudentProfile.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStd student = new AddStd();
				frmStudentProfile.setVisible(false);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2.setIcon(new ImageIcon(second.class.getResource("/GuiSwing2/images/follow.png")));
		btnNewButton_2.setBounds(202, 163, 167, 93);
		frmStudentProfile.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("ADD STUDENTS");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(202, 109, 167, 35);
		frmStudentProfile.getContentPane().add(lblNewLabel_1);
	}

}
