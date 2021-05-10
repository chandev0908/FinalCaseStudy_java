package mainpack;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.UIManager;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import mainpack.SettingsDialog.SettingsDialogResponse;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import com.toedter.calendar.JDateChooser;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class mainUI {

	JFrame frame;
	private JTextField fnameText;
	private JTextField emailText;
	private JTextField phoneText;
	private JTable table_1;
	private JComboBox coursecomboBox;
	private JDateChooser dateAvailability;
	public ArrayList<String> fName = new ArrayList<String>();
	public ArrayList<String> studentID = new ArrayList<String>();
	public ArrayList<String> email = new ArrayList<String>();
	public ArrayList<String> permitCode = new ArrayList<String>();
	public ArrayList<String> permitAvailability = new ArrayList<String>();
	public ArrayList<String> course = new ArrayList<String>();
	public ArrayList<String> phoneNum = new ArrayList<String>();
	public ArrayList<String> filepath = new ArrayList<String>();
	public File tempContainerFile;
	public String tempContainerFilePath = "";
	public int idI = 1;
	public int studentCounts = 0;
	public String emailFrom = "";
	public String passFrom = "";
	public boolean printed = false;
	public boolean darkMode = true;
	public String pdfFileName = "";
	private JTextField studidTxt;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public mainUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		// Main Frame
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(mainUI.class.getResource("/mainpack/img/icon.png")));
		frame.setMinimumSize(new Dimension(900, 650));
		frame.setTitle("Permit Distributor System");
		frame.setBounds(100, 100, 1150, 710);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		// Listener to Window Close button

		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (!printed) {
					if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close without printing PDF?",
							"WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				} else {
					System.exit(0);
				}
			}
		});
		// Menubar for changing email

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		JMenuItem mntmNewMenuItem = new JMenuItem("Settings");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SettingsDialog dialog = new SettingsDialog(new SettingsDialogResponseImp(), darkMode);
				dialog.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		JMenuItem mntmNewMenuItem23131 = new JMenuItem("File Name");
		mntmNewMenuItem23131.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pdfFileName = JOptionPane.showInputDialog(null, "Input the pdf file name", "",
						JOptionPane.WARNING_MESSAGE);
				if (pdfFileName == null) {
					pdfFileName = "";
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem23131);
		JMenuItem mntmNewMenuItem234 = new JMenuItem("Dark Mode");
		mntmNewMenuItem234.setBackground(Color.decode("#a4a4a4"));
		mnNewMenu.add(mntmNewMenuItem234);

		JMenuItem mntmNewMenuItem1231 = new JMenuItem("About");
		mntmNewMenuItem1231.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About abt = new About(darkMode);
				abt.frame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem1231);
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#14171A"));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 10));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#14171A"));
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(8, 1, 5, 5));

		JLabel fnamelabel = new JLabel("Full Name (Lastname, FirstName, Middle name)");
		fnamelabel.setForeground(Color.WHITE);
		fnamelabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(fnamelabel);

		fnameText = new JTextField();
		fnameText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (darkMode) {
					fnameText.setBackground(Color.BLACK);
					fnameText.setBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#1DA1F2")));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (darkMode) {
					fnameText.setBorder(null);
					fnameText.setBackground(Color.decode("#657786"));
				}
			}
		});
		fnameText.setForeground(Color.WHITE);
		fnameText.setBackground(Color.decode("#657786"));
		fnameText.setFont(new Font("Roboto Slab", Font.PLAIN, 12));
		panel_2.add(fnameText);
		fnameText.setColumns(15);

		JLabel idlabel_1 = new JLabel("Student ID");
		idlabel_1.setForeground(Color.WHITE);
		idlabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(idlabel_1);

		studidTxt = new JTextField();
		studidTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (darkMode) {
					studidTxt.setBackground(Color.BLACK);
					studidTxt.setBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#1DA1F2")));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (darkMode) {
					studidTxt.setBorder(null);
					studidTxt.setBackground(Color.decode("#657786"));
				}
			}
		});
		studidTxt.setForeground(Color.WHITE);
		studidTxt.setBackground(Color.decode("#657786"));
		studidTxt.setFont(new Font("Roboto Slab", Font.PLAIN, 12));
		studidTxt.setColumns(15);
		panel_2.add(studidTxt);

		JLabel mnamelabel = new JLabel("Permit Availability");
		mnamelabel.setForeground(Color.WHITE);
		mnamelabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(mnamelabel);

		dateAvailability = new JDateChooser();
		panel_2.add(dateAvailability);

		JLabel lblCurriculum = new JLabel("Course");
		lblCurriculum.setForeground(Color.WHITE);
		lblCurriculum.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(lblCurriculum);
		String[] courseData = { "", "Bachelor of Arts in Communication Arts", "Bachelor of Arts in English",
				"Bachelor of Arts in Psychology", "Bachelor of Science in Criminology",
				"Bachelor of Physical Education", "Bachelor of Science in Accountancy",
				"Bachelor of Science in Accounting Technology", "Bachelor of Science in Entrepreneurship",
				"Bachelor of Science in Hotel and Restaurant Management", "Bachelor of Science in Civil Engineering",
				"Bachelor of Science in Electrical Engineering", "Bachelor of Science in Electronics Engineering",
				"Bachelor of Science in Industrial Engineering", "Bachelor of Science in Mechanical Engineering",
				"Bachelor of Science in Computer Science", "Bachelor of Science in Information Systems",
				"Bachelor of Science in Information Technology", "Bachelor in Public Administration",
				"Bachelor of Science in Chemistry", "Bachelor of Science in Mathematics",
				"Bachelor of Science in Nursing",
				"Bachelor of Science in Elementary Education Specialized in General Curriculum",
				"Bachelor of Science in Elementary Education Specialized in Pre-School Education",
				"Bachelor of Science in Industrial Education Major in Industrial Arts",
				"Bachelor of Science in Secondary Education" };
		coursecomboBox = new JComboBox(courseData);
		coursecomboBox.setForeground(Color.WHITE);
		coursecomboBox.setBackground(Color.decode("#657786"));
		panel_2.add(coursecomboBox);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.decode("#14171A"));
		panel_2_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(panel_2_1);
		panel_2_1.setLayout(new GridLayout(6, 1, 5, 5));

		JLabel emaillabel = new JLabel("Email");
		emaillabel.setForeground(Color.WHITE);
		emaillabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2_1.add(emaillabel);

		emailText = new JTextField();
		emailText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (darkMode) {
					emailText.setBackground(Color.BLACK);
					emailText.setBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#1DA1F2")));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (darkMode) {
					emailText.setBorder(null);
					emailText.setBackground(Color.decode("#657786"));
				}
			}
		});
		emailText.setForeground(Color.WHITE);
		emailText.setBackground(Color.decode("#657786"));
		emailText.setFont(new Font("Roboto Slab", Font.PLAIN, 12));
		emailText.setColumns(15);
		panel_2_1.add(emailText);

		JLabel addresslabel = new JLabel("Phone #");
		addresslabel.setForeground(Color.WHITE);
		addresslabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2_1.add(addresslabel);

		phoneText = new JTextField();
		phoneText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (darkMode) {
					phoneText.setBackground(Color.BLACK);
					phoneText.setBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#1DA1F2")));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (darkMode) {
					phoneText.setBorder(null);
					phoneText.setBackground(Color.decode("#657786"));
				}
			}
		});
		phoneText.setForeground(Color.WHITE);
		phoneText.setBackground(Color.decode("#657786"));
		phoneText.setFont(new Font("Roboto Slab", Font.PLAIN, 12));
		phoneText.setColumns(15);
		panel_2_1.add(phoneText);

		JButton attachBtn = new JButton("Add Image");
		attachBtn.setBackground(Color.WHITE);
		attachBtn.setBorder(new LineBorder(new Color(0, 0, 0)));

		JLabel imagelabel = new JLabel("Insert Image");
		imagelabel.setForeground(Color.WHITE);
		imagelabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2_1.add(imagelabel);
		panel_2_1.add(attachBtn);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#14171A"));
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 7, 7));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblNewLabel.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/add.png")));
		panel_3.add(lblNewLabel);

		JLabel studCounts = new JLabel("Students Count: 0");
		studCounts.setFont(new Font("Tahoma", Font.PLAIN, 13));
		studCounts.setForeground(Color.WHITE);
		panel_3.add(studCounts);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setSize(new Dimension(115, 115));
		panel.add(lblNewLabel_6);
		attachBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser();
				fs.setDialogTitle("Add Image");
				fs.setFileFilter(new FileNameExtensionFilter("Image", "jpg", "png"));
				int result = fs.showOpenDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) {
					tempContainerFile = fs.getSelectedFile();
					tempContainerFilePath = tempContainerFile.getAbsolutePath();
					lblNewLabel_6.setIcon(iconRescaler(tempContainerFilePath));
				}
			}
		});
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.BLACK);
		panel_1.add(scrollPane);
		String[] label = { "ID", "Full Name", "Course", "Student ID", "Permit Code", "Permit Availability", "Email",
				"Phone" };
		Object[][] data = {};
		DefaultTableModel tableModel = new DefaultTableModel(data, label);
		table_1 = new JTable(tableModel);
		table_1.setForeground(Color.WHITE);
		table_1.setBackground(Color.BLACK);
		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table_1.getModel());
		table_1.setRowSorter(rowSorter);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int tcolumn = table_1.getSelectedColumn();
					int trow = table_1.getSelectedRow();
					String tval = tableModel.getValueAt(trow, tcolumn).toString();
					updator(tval, tcolumn, trow, table_1, fName, studentID, email, permitCode, permitAvailability,
							course, phoneNum);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex);
				}
			}
		});
		table_1.setFillsViewportHeight(true);
		scrollPane.setViewportView(table_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.decode("#14171A"));
		frame.getContentPane().add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new MigLayout("", "[93.00px]", "[290px]"));

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.decode("#14171A"));
		panel_4.add(panel_5, "cell 0 0,alignx center,aligny center");
		panel_5.setLayout(new GridLayout(8, 1, 5, 5));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/view.png")));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int numrow = table_1.getSelectedRow();
				JOptionPane.showMessageDialog(null, "Full Name: " + fName.get(numrow) + "\n" + "Course: "
						+ course.get(numrow) + "\n" + "Student ID: " + studentID.get(numrow) + "\n" + "Permit Code: "
						+ permitCode.get(numrow) + "\n" + "Permit Availability: " + permitAvailability.get(numrow)
						+ "\n" + "Email: " + email.get(numrow) + "\n" + "Phone #: " + phoneNum.get(numrow),
						"Student Info", JOptionPane.PLAIN_MESSAGE, iconRescaler(filepath.get(numrow)));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/hover-view.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/view.png")));
			}
		});
		panel_5.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("");

		lblNewLabel_1.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/delete.png")));
		panel_5.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int tcolumn = table_1.getSelectedColumn();
					int trow = table_1.getSelectedRow();
					String tval = tableModel.getValueAt(trow, tcolumn).toString();
					updator(tval, tcolumn, trow, table_1, fName, studentID, email, permitCode, permitAvailability,
							course, phoneNum);
					JOptionPane.showMessageDialog(null, "Updated Sucessfully");
				} catch (Exception jjs) {
					JOptionPane.showMessageDialog(null, "Error: " + jjs);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_3.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/hover-update.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/update.png")));
			}
		});

		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_5_1.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/Deleteall-hover.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_5_1.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/Deleteall.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					for (int i = 0; i < fName.size(); i++) {
						tableModel.removeRow(0);
					}
					JOptionPane.showMessageDialog(null, "Successfully deleted all data");
				} catch (Exception esdd) {
					JOptionPane.showMessageDialog(null, "Error: " + esdd);
				}
			}
		});
		lblNewLabel_5_1.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/Deleteall.png")));
		panel_5.add(lblNewLabel_5_1);
		lblNewLabel_3.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/update.png")));
		panel_5.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (emailChecker()) {
					SendEmail.sendMail(emailFrom, passFrom, fName, studentID, email, permitCode, permitAvailability,
							course, phoneNum, filepath);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_4.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/hover-email.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_4.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/email.png")));
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/email.png")));
		panel_5.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (pdfFileName.isBlank() || pdfFileName.isEmpty()) {
					pdfFileName = JOptionPane.showInputDialog(null, "Input the pdf file name",
							"INPUT THE FILE NAME FIRST!", JOptionPane.WARNING_MESSAGE);
					if (pdfFileName == null) {
						pdfFileName = "";
					}
				} else {
					printPdf.printThis(pdfFileName, fName, studentID, email, permitCode, permitAvailability, course,
							phoneNum);
					printed = true;
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_5.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/hover-pdf.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_5.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/pdf.png")));
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/pdf.png")));
		panel_5.add(lblNewLabel_5);

		JLabel lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_5_2.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/Search-hover.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_5_2.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/Search.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				String searchID = JOptionPane.showInputDialog(null, "Search for Student ID");
				if (studentID.size() >= 1) {
					System.out.println("hi");
					for (int iss = 0; iss < fName.size(); iss++) {
						if (searchID.equalsIgnoreCase(studentID.get(iss))) {
							JOptionPane.showMessageDialog(null,
									"Full Name: " + fName.get(iss) + "\n" + "Course: " + course.get(iss) + "\n"
											+ "Student ID: " + studentID.get(iss) + "\n" + "Permit Code: "
											+ permitCode.get(iss) + "\n" + "Permit Availability: "
											+ permitAvailability.get(iss) + "\n" + "Email: " + email.get(iss) + "\n"
											+ "Phone #: " + phoneNum.get(iss),
									"Student Info", JOptionPane.PLAIN_MESSAGE, iconRescaler(filepath.get(iss)));
						} else {
							JOptionPane.showMessageDialog(null, "Cant find any " + searchID + " in List");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "No Data yet");
				}

			}
		});
		lblNewLabel_5_2.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/Search.png")));
		panel_5.add(lblNewLabel_5_2);

		textField = new JTextField();
		textField.setText("Search Filter");
		textField.setSize(new Dimension(0, 10));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String textF = textField.getText();

				if (textF.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + textF));
				}
			}
		});
		panel_5.add(textField);
		textField.setColumns(10);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/addhover.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/add.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (textChecker()) {
					studentCounts++;
					String tfName = fnameText.getText();
					String tcourse = coursecomboBox.getSelectedItem().toString();
					String studId = studidTxt.getText();
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					String permitAvail = df.format(dateAvailability.getDate());
					String permitCd = randomCode();
					String temail = emailText.getText();
					String phone = phoneText.getText();
					studCounts.setText("Student Counts: " + studentCounts);
					Object[] temp = { idI, tfName, tcourse, studId, permitCd, permitAvail, temail, phone };
					tableModel.addRow(temp);
					fName.add(tfName);
					course.add(tcourse);
					studentID.add(studId);
					permitAvailability.add(permitAvail);
					permitCode.add(permitCd);
					email.add(temail);
					phoneNum.add(phone);
					filepath.add(tempContainerFilePath);
					printed = false;
					idI++;
					fnameText.setText("");
					coursecomboBox.setSelectedIndex(0);
					studidTxt.setText("");
					emailText.setText("");
					phoneText.setText("");
					dateAvailability.setCalendar(null);
					tempContainerFilePath = "";
					lblNewLabel_6.setIcon(null);
				}
			}
		});
		mntmNewMenuItem234.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (darkMode) {
					mntmNewMenuItem234.setBackground(new Color(240, 240, 240));
					panel.setBackground(null);
					panel_2.setBackground(null);
					panel_2_1.setBackground(null);
					panel_3.setBackground(null);
					panel_1.setBackground(null);
					panel_4.setBackground(null);
					panel_5.setBackground(null);
					table_1.setBackground(null);
					fnamelabel.setForeground(Color.BLACK);
					idlabel_1.setForeground(Color.BLACK);
					mnamelabel.setForeground(Color.BLACK);
					lblCurriculum.setForeground(Color.BLACK);
					emaillabel.setForeground(Color.BLACK);
					addresslabel.setForeground(Color.BLACK);
					imagelabel.setForeground(Color.BLACK);
					table_1.setForeground(Color.BLACK);
					studCounts.setForeground(Color.BLACK);
					fnameText.setBackground(Color.WHITE);
					fnameText.setForeground(Color.BLACK);
					studidTxt.setBackground(Color.WHITE);
					studidTxt.setForeground(Color.BLACK);
					coursecomboBox.setForeground(Color.BLACK);
					coursecomboBox.setBackground(Color.WHITE);
					phoneText.setBackground(Color.WHITE);
					emailText.setBackground(Color.WHITE);
					phoneText.setForeground(Color.BLACK);
					emailText.setForeground(Color.BLACK);
					fnameText.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
					studidTxt.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
					phoneText.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
					emailText.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
					darkMode = false;
				} else {
					mntmNewMenuItem234.setBackground(Color.decode("#a4a4a4"));
					panel.setBackground(Color.decode("#14171A"));
					panel_2.setBackground(Color.decode("#14171A"));
					panel_2_1.setBackground(Color.decode("#14171A"));
					panel_3.setBackground(Color.decode("#14171A"));
					panel_1.setBackground(Color.decode("#14171A"));
					panel_4.setBackground(Color.decode("#14171A"));
					panel_5.setBackground(Color.decode("#14171A"));
					table_1.setBackground(Color.decode("#14171A"));
					fnamelabel.setForeground(Color.WHITE);
					idlabel_1.setForeground(Color.WHITE);
					mnamelabel.setForeground(Color.WHITE);
					lblCurriculum.setForeground(Color.WHITE);
					emaillabel.setForeground(Color.WHITE);
					addresslabel.setForeground(Color.WHITE);
					imagelabel.setForeground(Color.WHITE);
					table_1.setForeground(Color.WHITE);
					studCounts.setForeground(Color.WHITE);
					coursecomboBox.setForeground(Color.WHITE);
					fnameText.setForeground(Color.WHITE);
					studidTxt.setForeground(Color.WHITE);
					coursecomboBox.setForeground(Color.WHITE);
					emailText.setForeground(Color.WHITE);
					phoneText.setForeground(Color.WHITE);
					coursecomboBox.setBackground(Color.decode("#657786"));
					fnameText.setBackground(Color.decode("#657786"));
					studidTxt.setBackground(Color.decode("#657786"));
					coursecomboBox.setBackground(Color.decode("#657786"));
					phoneText.setBackground(Color.decode("#657786"));
					emailText.setBackground(Color.decode("#657786"));
					darkMode = true;
				}
				UIManager.put("OptionPane.messageForeground", darkMode ? Color.WHITE : Color.BLACK);
				UIManager.put("OptionPane.background", darkMode ? Color.decode("#14171A") : new Color(210, 210, 210));
				UIManager.put("Panel.background", darkMode ? Color.decode("#14171A") : new Color(210, 210, 210));
			}
		});
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/hover-delete.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setIcon(new ImageIcon(mainUI.class.getResource("/mainpack/img/delete.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					studentCounts--;
					studCounts.setText("Students Count: " + studentCounts);
					int tablerow = table_1.getSelectedRow();
					Object tableid = tableModel.getValueAt(tablerow, 0);
					tableModel.removeRow(tablerow);
					fName.remove(tablerow);
					studentID.remove(tablerow);
					email.remove(tablerow);
					permitCode.remove(tablerow);
					permitAvailability.remove(tablerow);
					course.remove(tablerow);
					phoneNum.remove(tablerow);
					filepath.remove(tablerow);

					JOptionPane.showMessageDialog(null, "ID " + tableid + ", has been removed in the list");
				} catch (Exception as) {
					JOptionPane.showMessageDialog(null, "Invalid cannot do this action");
				}

			}
		});
	}

	public boolean emailChecker() {
		if (emailFrom.isBlank() && passFrom.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please setup your email account");
			return false;
		}
		if (emailFrom.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please input email");
			return false;
		}
		if (passFrom.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please input password");
			return false;
		}
		return true;
	}

	public class SettingsDialogResponseImp implements SettingsDialogResponse {

		@Override
		public void getResponse(String m, String p) {
			emailFrom = m;
			passFrom = p;
		}

	}

	public static void updator(String tval, int tcolumn, int trow, JTable table_1, ArrayList<String> fName,
			ArrayList<String> studentID, ArrayList<String> email, ArrayList<String> permitCode,
			ArrayList<String> permitAvailability, ArrayList<String> course, ArrayList<String> phoneNum) {
		if (tcolumn == 1) {
			fName.set(trow, tval);
		}
		if (tcolumn == 2) {
			course.set(trow, tval);
		}
		if (tcolumn == 3) {
			studentID.set(trow, tval);
		}
		if (tcolumn == 4) {
			permitCode.set(trow, tval);
		}
		if (tcolumn == 5) {
			permitAvailability.set(trow, tval);
		}
		if (tcolumn == 6) {
			email.set(trow, tval);
		}
		if (tcolumn == 7) {
			phoneNum.set(trow, tval);
		}
	}

	public String randomCode() {
		String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 10;

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphaNumeric.length());
			char randomChar = alphaNumeric.charAt(index);
			sb.append(randomChar);
		}

		String randomString = sb.toString();
		return randomString;
	}

	public ImageIcon iconRescaler(String imgpath) {
		ImageIcon ic = new ImageIcon(imgpath);
		Image img = ic.getImage();
		Image newimg = img.getScaledInstance(115, 115, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newic = new ImageIcon(newimg);
		return newic;
	}

	public boolean textChecker() {
		if (fnameText.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Dont leave the firstname blank");
			return false;
		}
		if (studidTxt.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Dont leave the student id blank");
			return false;
		}
		if (dateAvailability.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Dont leave the permit availability blank");
			return false;
		}
		if (emailText.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Dont leave the email blank");
			return false;
		}
		if (phoneText.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Dont leave the phone number blank");
			return false;
		}
		if (tempContainerFilePath.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please add an image");
			return false;
		}
		String val = coursecomboBox.getSelectedItem().toString();
		if (val.isBlank()) {
			JOptionPane.showMessageDialog(null, "Dont leave the course blank");
			return false;
		}
		for (String element : studentID) {
			if (studidTxt.getText().equalsIgnoreCase(element)) {
				JOptionPane.showMessageDialog(null, "That student id is already have a permit");
				return false;
			}
		}
		return true;
	}
}