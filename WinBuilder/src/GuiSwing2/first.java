package GuiSwing2;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class first extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					first frame = new first();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public first() {
	    
		setType(Type.POPUP);
		setTitle("ADMIN LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 466);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(first.class.getResource("/GuiSwing2/images/unauthorized-person.png")));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setBounds(307, 41, 142, 117);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTch at = new AddTch();
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(first.class.getResource("/GuiSwing2/images/teacher (1).png")));
		btnNewButton.setBounds(428, 231, 106, 87);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				second frameTwo  = new second();
			   setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(first.class.getResource("/GuiSwing2/images/student.png")));
		btnNewButton_1.setBounds(190, 231, 106, 87);
		contentPane.add(btnNewButton_1);
		
JButton btnNewButton_3 = new JButton("");
btnNewButton_3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		LoginAs la = new LoginAs();
		setVisible(false);
	}
});
btnNewButton_3.setFocusable(false);
		btnNewButton_3.setIcon(new ImageIcon(first.class.getResource("/GuiSwing2/images/turn-off (1).png")));
		btnNewButton_3.setBounds(674, 6, 66, 44);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("MANAGE STUDENT");
		lblNewLabel_1.setBounds(190, 319, 116, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ADD TEACHER");
		lblNewLabel_2.setBounds(438, 319, 92, 16);
		contentPane.add(lblNewLabel_2);
	}
}
