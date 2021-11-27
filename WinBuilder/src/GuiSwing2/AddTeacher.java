package GuiSwing2;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class AddTeacher {

	private JFrame frmCoralCoastInternational;
	private final JPanel panel = new JPanel();
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacher window = new AddTeacher();
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
	

	/**
	 * Initialize the contents of the frame.
	 */
	 public AddTeacher () {
		frmCoralCoastInternational = new JFrame();
		frmCoralCoastInternational.setTitle("Add Teacher");
		frmCoralCoastInternational.setBounds(100, 100, 789, 486);
		frmCoralCoastInternational.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCoralCoastInternational.setLocationRelativeTo(null);
		frmCoralCoastInternational.getContentPane().setLayout(null);
		panel.setBackground(new Color(245, 222, 179));
		panel.setBounds(0, 0, 783, 452);
		frmCoralCoastInternational.getContentPane().add(panel);
		frmCoralCoastInternational.setVisible(true);
		panel.setLayout(null);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first back = new first();
				frmCoralCoastInternational.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(6, 6, 80, 57);
		btnNewButton_1.setIcon(new ImageIcon(AddTeacher.class.getResource("/GuiSwing2/images/previous.png")));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(595, 338, 80, 76);
		btnNewButton.setIcon(new ImageIcon(AddTeacher.class.getResource("/GuiSwing2/images/diskette.png")));
		panel.add(btnNewButton);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(AddTeacher.class.getResource("/GuiSwing2/images/clear.png")));
		btnNewButton_2.setBounds(687, 351, 71, 63);
		panel.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("SAVE");
		lblNewLabel.setBounds(620, 417, 61, 16);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("CLEAR");
		lblNewLabel_1.setBounds(705, 417, 61, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NAME :");
		lblNewLabel_2.setBounds(42, 115, 61, 16);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(130, 110, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ID NO. :");
		lblNewLabel_3.setBounds(42, 175, 61, 16);
		panel.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 170, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("GENDER :");
		lblNewLabel_4.setBounds(42, 228, 61, 16);
		panel.add(lblNewLabel_4);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("MALE");
		chckbxNewCheckBox.setBounds(130, 224, 80, 23);
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("FEMALE");
		chckbxNewCheckBox_1.setBounds(214, 224, 80, 23);
		panel.add(chckbxNewCheckBox_1);
		
		ButtonGroup chckbk = new ButtonGroup();
		chckbk.add(chckbxNewCheckBox);
		chckbk.add(chckbxNewCheckBox_1);
	}
}
