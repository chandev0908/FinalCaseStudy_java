package mainpack;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
public class About {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the application.
	 */
	public About(boolean darkMode) {
		initialize(darkMode);
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize(boolean darkMode) {
		frame = new JFrame();
		frame.getContentPane().setBackground(darkMode ? Color.decode("#14171A") : new Color(210,210,210));
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 450);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		JLabel lblNewLabel = new JLabel("ABOUT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(250, 11, 88, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("This application is made for setting up permits for appointments faster, and easier.");
		lblNewLabel_1.setBounds(55, 70, 510, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FEATURES");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(256, 105, 76, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("- Make permits using a student's information");
		lblNewLabel_3.setBounds(40, 125, 342, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_2 = new JLabel("- Send permit to the student's email");
		lblNewLabel_3_2.setBounds(40, 175, 342, 14);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("- Record information and appointment date of students on a list");
		lblNewLabel_3_1.setBounds(40, 150, 408, 14);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_3 = new JLabel("- Can print the lists into a PDF");
		lblNewLabel_3_3.setBounds(40, 200, 342, 14);
		frame.getContentPane().add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("- Dark mode for peoples who prefers a darker UI");
		lblNewLabel_3_4.setBounds(40, 225, 342, 14);
		frame.getContentPane().add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("Developers");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(250, 265, 76, 25);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("JEAN DELMARI F. BERNAL");
		lblNewLabel_3_4_1.setBounds(328, 309, 342, 14);
		frame.getContentPane().add(lblNewLabel_3_4_1);
		
		JLabel lblNewLabel_3_4_1_1 = new JLabel("CHRISTIAN A. DALAGAN");
		lblNewLabel_3_4_1_1.setBounds(121, 309, 342, 14);
		frame.getContentPane().add(lblNewLabel_3_4_1_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setBounds(165, 325, 75, 75);
		frame.getContentPane().add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_3_4_1_2 = new JLabel("JOSHUA KIANE A. CASTRO");
		lblNewLabel_3_4_1_2.setBounds(223, 354, 175, 14);
		frame.getContentPane().add(lblNewLabel_3_4_1_2);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(250, 405, 88, 34);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		ImageIcon ic = new ImageIcon(About.class.getResource("/mainpack/img/icon.png"));
		Image img = ic.getImage();
		Image newimg = img.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newic = new ImageIcon(newimg);
		lblNewLabel_4.setIcon(newic);
		lblNewLabel_4.setBounds(174, 11, 66, 58);
		frame.getContentPane().add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, darkMode ? Color.decode("#1DA1F2") : new Color(180,180,180)));
		panel.setBackground(darkMode ? Color.decode("#14171A") : new Color(210,210,210));
		panel.setBounds(0, 0, 600, 450);
		frame.getContentPane().add(panel);

		if(darkMode){
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3_2.setForeground(Color.WHITE);
			lblNewLabel_3_1.setForeground(Color.WHITE);
			lblNewLabel_3_3.setForeground(Color.WHITE);
			lblNewLabel_3_4.setForeground(Color.WHITE);
			lblNewLabel_2_1.setForeground(Color.WHITE);
			lblNewLabel_3_4_1.setForeground(Color.WHITE);
			lblNewLabel_3_4_1_1.setForeground(Color.WHITE);
			lblNewLabel_3_4_1_2.setForeground(Color.WHITE);
			btnNewButton.setForeground(Color.BLACK);
		}else{
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel_1.setForeground(Color.BLACK);
			lblNewLabel_2.setForeground(Color.BLACK);
			lblNewLabel_3.setForeground(Color.BLACK);
			lblNewLabel_3_2.setForeground(Color.BLACK);
			lblNewLabel_3_1.setForeground(Color.BLACK);
			lblNewLabel_3_3.setForeground(Color.BLACK);
			lblNewLabel_3_4.setForeground(Color.BLACK);
			lblNewLabel_2_1.setForeground(Color.BLACK);
			lblNewLabel_3_4_1.setForeground(Color.BLACK);
			lblNewLabel_3_4_1_1.setForeground(Color.BLACK);
			lblNewLabel_3_4_1_2.setForeground(Color.BLACK);
			btnNewButton.setForeground(Color.BLACK);
		}
	}
}
