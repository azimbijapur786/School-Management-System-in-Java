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
import java.awt.SystemColor;

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
		frmStudentProfile.getContentPane().setBackground(SystemColor.info);
		frmStudentProfile.setTitle("K.C.Gandhi English School");
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
		
		JButton btnNewButton_1 = new JButton("Manage Students");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(123, 104, 238));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminClassroom ac = new AdminClassroom();
				frmStudentProfile.setVisible(false);
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setIcon(new ImageIcon(second.class.getResource("/GuiSwing2/images/data-processing.png")));
		btnNewButton_1.setBounds(389, 266, 299, 91);
		frmStudentProfile.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add Students");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStd student = new AddStd();
				frmStudentProfile.setVisible(false);
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(123, 104, 238));
		btnNewButton_2.setIcon(new ImageIcon(second.class.getResource("/GuiSwing2/images/follow.png")));
		btnNewButton_2.setBounds(88, 265, 283, 93);
		frmStudentProfile.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(second.class.getResource("/GuiSwing2/images/unauthorized-person.png")));
		lblNewLabel.setBounds(329, 95, 145, 128);
		frmStudentProfile.getContentPane().add(lblNewLabel);
	}

}
