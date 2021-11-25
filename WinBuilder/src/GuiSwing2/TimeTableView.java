package GuiSwing2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimeTableView {

	private JFrame frmViewFeesDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeTableView window = new TimeTableView();
					window.frmViewFeesDetails.setVisible(true);
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
		public TimeTableView() {
		frmViewFeesDetails = new JFrame();
		frmViewFeesDetails.getContentPane().setBackground(new Color(250, 250, 210));
		frmViewFeesDetails.setTitle("Time Table");
		frmViewFeesDetails.setBounds(100, 100, 878, 499);
		frmViewFeesDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewFeesDetails.getContentPane().setLayout(null);
		frmViewFeesDetails.setVisible(true);
		frmViewFeesDetails.setResizable(false);
		frmViewFeesDetails.setLocationRelativeTo(null);
		
		JLabel titleFees = new JLabel("Time Table");
		titleFees.setFont(new Font("Times New Roman", Font.BOLD, 30));
		titleFees.setBounds(341, 14, 164, 30);
		frmViewFeesDetails.getContentPane().add(titleFees);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(43, 72, 782, 362);
		frmViewFeesDetails.getContentPane().add(lblNewLabel);
	}

}
