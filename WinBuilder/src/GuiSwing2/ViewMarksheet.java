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
import javax.swing.SwingConstants;

public class ViewMarksheet {

	private JFrame frmViewMarksheet;
	private JTextField getRollMarksheet;
	private JTextField getClassMarksheet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMarksheet window = new ViewMarksheet();
					window.frmViewMarksheet.setVisible(true);
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
		public ViewMarksheet() {
		frmViewMarksheet = new JFrame();
		frmViewMarksheet.getContentPane().setBackground(new Color(250, 250, 210));
		frmViewMarksheet.setTitle("View Marksheet");
		frmViewMarksheet.setBounds(100, 100, 878, 499);
		frmViewMarksheet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewMarksheet.getContentPane().setLayout(null);
		frmViewMarksheet.setVisible(true);
		frmViewMarksheet.setResizable(false);
		frmViewMarksheet.setLocationRelativeTo(null);
		
		JLabel ViewMarksheetTitle = new JLabel("View Marksheet");
		ViewMarksheetTitle.setHorizontalAlignment(SwingConstants.CENTER);
		ViewMarksheetTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		ViewMarksheetTitle.setBounds(0, 11, 854, 35);
		frmViewMarksheet.getContentPane().add(ViewMarksheetTitle);
		
		JLabel rollMarksheet = new JLabel("Roll No. :");
		rollMarksheet.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		rollMarksheet.setBounds(61, 103, 104, 42);
		frmViewMarksheet.getContentPane().add(rollMarksheet);
		
		JLabel classMarksheet = new JLabel("Class :");
		classMarksheet.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		classMarksheet.setBounds(61, 175, 104, 42);
		frmViewMarksheet.getContentPane().add(classMarksheet);
		
		getRollMarksheet = new JTextField();
		getRollMarksheet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getRollMarksheet.setBounds(175, 103, 159, 35);
		frmViewMarksheet.getContentPane().add(getRollMarksheet);
		getRollMarksheet.setColumns(10);
		
		getClassMarksheet = new JTextField();
		getClassMarksheet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getClassMarksheet.setColumns(10);
		getClassMarksheet.setBounds(175, 175, 159, 35);
		frmViewMarksheet.getContentPane().add(getClassMarksheet);
		
		JButton getMarksheetBtn = new JButton("Get Makrsheet");
		getMarksheetBtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		getMarksheetBtn.setBounds(61, 245, 183, 53);
		frmViewMarksheet.getContentPane().add(getMarksheetBtn);
		
		JButton btnPrintMarksheet = new JButton("Print Marksheet");
		btnPrintMarksheet.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnPrintMarksheet.setBounds(61, 307, 183, 53);
		frmViewMarksheet.getContentPane().add(btnPrintMarksheet);
		
		JButton clearMarksheet = new JButton("Clear");
		clearMarksheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				getRollMarksheet.setText(null);
				getClassMarksheet.setText(null);
			}
		});
		clearMarksheet.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		clearMarksheet.setBounds(61, 371, 183, 53);
		frmViewMarksheet.getContentPane().add(clearMarksheet);
		
		JButton BackMarksheet = new JButton("Back");
		BackMarksheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new StudentLogin();
				frmViewMarksheet.setVisible(false);
			}
		});
		BackMarksheet.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		BackMarksheet.setBounds(249, 245, 85, 179);
		frmViewMarksheet.getContentPane().add(BackMarksheet);
		
		JPanel panelToShowMarksheet = new JPanel();
		panelToShowMarksheet.setBackground(new Color(255, 255, 255));
		panelToShowMarksheet.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelToShowMarksheet.setBounds(379, 63, 416, 367);
		frmViewMarksheet.getContentPane().add(panelToShowMarksheet);
		panelToShowMarksheet.setLayout(null);
		
		JLabel showMarksheet = new JLabel("");
		showMarksheet.setBounds(6, 16, 404, 345);
		panelToShowMarksheet.add(showMarksheet);
	}
}
