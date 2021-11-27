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
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

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
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1104, 646);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JButton btnNewButton = new JButton("Manage Teachers");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(147, 112, 219));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTch at = new AddTch();
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(first.class.getResource("/GuiSwing2/images/teacher (1).png")));
		btnNewButton.setBounds(413, 512, 299, 87);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Manage Students");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(147, 112, 219));
		btnNewButton_1.setIcon(new ImageIcon(first.class.getResource("/GuiSwing2/images/student.png")));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				second frameTwo  = new second();
			   setVisible(false);
			}
		});
		btnNewButton_1.setBounds(67, 512, 304, 87);
		contentPane.add(btnNewButton_1);
		
JButton btnNewButton_3 = new JButton("Logout");
btnNewButton_3.setForeground(Color.WHITE);
btnNewButton_3.setBackground(new Color(147, 112, 219));
btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
btnNewButton_3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		LoginAs la = new LoginAs();
		setVisible(false);
	}
});
btnNewButton_3.setFocusable(false);
		btnNewButton_3.setIcon(new ImageIcon(first.class.getResource("/GuiSwing2/images/turn-off (1).png")));
		btnNewButton_3.setBounds(748, 512, 289, 87);
		contentPane.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setBackground(new Color(240, 230, 140));
		panel.setBounds(10, 10, 1070, 87);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("K.C.Gandhi English School");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 37));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 10, 1050, 67);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(157, 107, 797, 395);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 797, 395);
		ImageIcon icon = new ImageIcon(LoginAs.class.getResource("/GuiSwing2/imgs/adminbg.jpeg"));
    	Image image = icon.getImage();
    	Image imgscale = image.getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
    	ImageIcon scaledicon = new ImageIcon(imgscale);
		panel_1.setLayout(null);
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		lblNewLabel.setIcon(scaledicon);
		panel_1.add(lblNewLabel);
	}
}
