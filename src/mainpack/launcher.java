package mainpack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class launcher {

	private JFrame frmPermitDistributorLauncher;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					launcher window = new launcher();
					window.frmPermitDistributorLauncher.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public launcher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPermitDistributorLauncher = new JFrame();
		frmPermitDistributorLauncher.setIconImage(
				Toolkit.getDefaultToolkit().getImage(launcher.class.getResource("/mainpack/img/icon.png")));
		frmPermitDistributorLauncher.setTitle("Permit Distributor Launcher");
		frmPermitDistributorLauncher.setBounds(100, 100, 423, 264);
		frmPermitDistributorLauncher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPermitDistributorLauncher.setLocationRelativeTo(null);
		frmPermitDistributorLauncher.getContentPane().setLayout(null);
		frmPermitDistributorLauncher.setUndecorated(true);

		JButton Launch = new JButton("Launch");
		Launch.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		Launch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Launch.setBackground(Color.WHITE);
		Launch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainUI window = new mainUI();
				window.frame.setVisible(true);
				frmPermitDistributorLauncher.dispose();
			}
		});
		Launch.setBounds(162, 163, 100, 35);
		frmPermitDistributorLauncher.getContentPane().add(Launch);
		JLabel lblNewLabel_1 = new JLabel("CLOSE");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setFont(lblNewLabel_1.getFont().deriveFont(14f));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(187, 209, 56, 24);
		frmPermitDistributorLauncher.getContentPane().add(lblNewLabel_1);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(launcher.class.getResource("/mainpack/img/launcher.png")));
		lblNewLabel.setBounds(0, 0, 423, 263);
		frmPermitDistributorLauncher.getContentPane().add(lblNewLabel);
	}
}
