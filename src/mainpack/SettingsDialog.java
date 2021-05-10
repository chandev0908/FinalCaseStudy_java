package mainpack;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class SettingsDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField emailField;
	private JPasswordField passField;

	/**
	 * Create the dialog.
	 */
	public interface SettingsDialogResponse {
		void getResponse(String m, String p);
	}

	public SettingsDialog(SettingsDialogResponse sdResponse, boolean darkMode) {
		setTitle("Email Form");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBackground(darkMode ? Color.decode("#14171A") : new Color(210,210,210));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(darkMode ? Color.decode("#14171A") : new Color(210,210,210));
		panel_1.setBorder(new EmptyBorder(40, 40, 40, 40));
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(4, 0, 10, 5));

		JLabel lblNewLabel = new JLabel("Email");
		panel_1.add(lblNewLabel);

		emailField = new JTextField();
		panel_1.add(emailField);
		emailField.setColumns(20);

		JLabel lblNewLabel_1 = new JLabel("Password");
		panel_1.add(lblNewLabel_1);

		passField = new JPasswordField();
		panel_1.add(passField);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(darkMode ? Color.decode("#14171A") : new Color(210,210,210));
		getContentPane().add(panel_2, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String m = emailField.getText();
				String p = new String(passField.getPassword());
				sdResponse.getResponse(m, p);
				dispose();
			}
		});
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel_2.add(btnNewButton_1);
		if(darkMode){
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel_1.setForeground(Color.WHITE);
		}else{
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel_1.setForeground(Color.BLACK);
		}
	}
}
