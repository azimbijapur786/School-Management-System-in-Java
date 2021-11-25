package GuiSwing2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;

public class ViewAnnounce {

	private JFrame frmAnnouncements;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAnnounce window = new ViewAnnounce();
					window.frmAnnouncements.setVisible(true);
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
	 public ViewAnnounce() {
		frmAnnouncements = new JFrame();
		frmAnnouncements.getContentPane().setBackground(SystemColor.info);
		frmAnnouncements.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Announcements :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(296, 26, 242, 61);
		frmAnnouncements.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(44, 98, 815, 334);
		frmAnnouncements.getContentPane().add(lblNewLabel_1);
		frmAnnouncements.setTitle("Announcements");
		frmAnnouncements.setBounds(100, 100, 907, 497);
		frmAnnouncements.setVisible(true);
		frmAnnouncements.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
