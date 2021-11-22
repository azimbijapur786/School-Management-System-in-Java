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

public class ViewFees {

	private JFrame frmViewFeesDetails;
	private JTextField getRefIdforFees;
	private JTextField getClassforfees;
	private JTextField getRollForfees;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFees window = new ViewFees();
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
		public ViewFees() {
		frmViewFeesDetails = new JFrame();
		frmViewFeesDetails.getContentPane().setBackground(new Color(250, 250, 210));
		frmViewFeesDetails.setTitle("View Fees Details");
		frmViewFeesDetails.setBounds(100, 100, 878, 499);
		frmViewFeesDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewFeesDetails.getContentPane().setLayout(null);
		frmViewFeesDetails.setVisible(true);
		frmViewFeesDetails.setResizable(false);
		frmViewFeesDetails.setLocationRelativeTo(null);
		
		JLabel titleFees = new JLabel("Fees Details");
		titleFees.setFont(new Font("Times New Roman", Font.BOLD, 30));
		titleFees.setBounds(341, 14, 164, 30);
		frmViewFeesDetails.getContentPane().add(titleFees);
		
		JLabel feesRef = new JLabel("Ref. Id. :");
		feesRef.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		feesRef.setBounds(37, 110, 112, 39);
		frmViewFeesDetails.getContentPane().add(feesRef);
		
		JLabel feesClass = new JLabel("Class :");
		feesClass.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		feesClass.setBounds(37, 173, 101, 39);
		frmViewFeesDetails.getContentPane().add(feesClass);
		
		JLabel feesRoll = new JLabel("Roll No. :");
		feesRoll.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		feesRoll.setBounds(37, 240, 112, 39);
		frmViewFeesDetails.getContentPane().add(feesRoll);
		
		getRefIdforFees = new JTextField();
		getRefIdforFees.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getRefIdforFees.setBounds(159, 107, 164, 30);
		frmViewFeesDetails.getContentPane().add(getRefIdforFees);
		getRefIdforFees.setColumns(10);
		
		getClassforfees = new JTextField();
		getClassforfees.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getClassforfees.setColumns(10);
		getClassforfees.setBounds(159, 173, 164, 30);
		frmViewFeesDetails.getContentPane().add(getClassforfees);
		
		getRollForfees = new JTextField();
		getRollForfees.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getRollForfees.setColumns(10);
		getRollForfees.setBounds(159, 240, 164, 30);
		frmViewFeesDetails.getContentPane().add(getRollForfees);
		
		JButton getFees = new JButton("Get Fees Reciept");
		getFees.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		getFees.setBounds(16, 303, 203, 59);
		frmViewFeesDetails.getContentPane().add(getFees);
		
		JButton printFees = new JButton("Print Fees Reciept");
		printFees.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		printFees.setBounds(16, 365, 203, 59);
		frmViewFeesDetails.getContentPane().add(printFees);
		
		JButton clearFees = new JButton("Clear");
		clearFees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				getRefIdforFees.setText(null);
				getClassforfees.setText(null);
				getRollForfees.setText(null);
			}
		});
		clearFees.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		clearFees.setBounds(229, 303, 132, 59);
		frmViewFeesDetails.getContentPane().add(clearFees);
		
		JButton backFees = new JButton("Back");
		backFees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new StudentLogin();
				frmViewFeesDetails.setVisible(false);
			}
		});
		backFees.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		backFees.setBounds(229, 365, 132, 59);
		frmViewFeesDetails.getContentPane().add(backFees);
		
		JPanel panelToshowFees = new JPanel();
		panelToshowFees.setBackground(new Color(255, 255, 255));
		panelToshowFees.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelToshowFees.setBounds(398, 67, 436, 369);
		frmViewFeesDetails.getContentPane().add(panelToshowFees);
		panelToshowFees.setLayout(null);
		
		JLabel showFeesReciept = new JLabel("");
		showFeesReciept.setBounds(0, 0, 436, 369);
		panelToshowFees.add(showFeesReciept);
		showFeesReciept.setBackground(new Color(255, 255, 255));
	}

}
