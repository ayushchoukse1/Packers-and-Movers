package packersandmovers;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Clientregister extends JFrame {
	String fname, lname, address, contact, emailid,username;
	char[] pass;
	String client_id;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JTextField textField_5;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientregister frame = new Clientregister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Clientregister() {
		initialize();

	}

	/**
	 * Create the frame.
	 */
	public void initialize() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100,425,565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 421, 539);
		contentPane.add(scrollPane_1);

		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setBounds(39, 11, 301, 45);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 36));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(39, 181, 105, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(39, 224, 105, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(39, 272, 105, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Contact Number");
		lblNewLabel_4.setBounds(39, 356, 105, 14);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Email Id");
		lblNewLabel_5.setBounds(39, 399, 105, 14);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Password :");
		lblNewLabel_6.setBounds(39, 134, 105, 14);
		panel.add(lblNewLabel_6);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(64, 468, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");

					Connection con = DriverManager.getConnection(
							"jdbc:db2://localhost:50000/packers", "db2admin",
							"root");
					fname = textField_5.getText();
					lname = textField_1.getText();
					address = textArea.getText();
					contact = textField_3.getText();
					emailid = textField_4.getText();
					pass = passwordField.getPassword();
					System.out.println(pass);
					username=textField.getText();
					String password = new String(pass);
					
					if (password.length() <= 4 || password.length() >= 10) {
						JOptionPane.showMessageDialog(null, "Invalid Password");
					} else if (fname.equals("") || lname.equals("")
							|| address.equals("") || contact.equals("")
							|| emailid.equals("") || password.equals("")) {
						JOptionPane.showMessageDialog(null,
								"one or more fields are empty");
					} else {
						Idgenerator idgen=new Idgenerator();
						idgen.CustomerIdGenerator();
						client_id=idgen.final_string1;
						PreparedStatement ps = con
								.prepareStatement("INSERT INTO DB2ADMIN.CLIENT (C_FIRSTNAME, CLIENTID, C_LASTNAME, C_ADDRESS, C_EMAILID, C_STATUS, C_CONTACT,C_USERNAME) VALUES(?,?,?,?,?,?,?,?)");
						ps.setString(2, client_id);
						ps.setString(1, fname);
						ps.setString(3, lname);
						ps.setString(4,address);
						ps.setString(7,contact);
						ps.setString(5,emailid);
						ps.setString(6, "pending");
						ps.setString(8, username);
						ps.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Welcome "
								+ textField.getText() + ", your Client ID is: "
								+ client_id);
						
						dispose();
						Statement st= con.createStatement();
						String regi_string="INSERT INTO DB2ADMIN.REGISTRY (USERNAME, PASSWORD, POST) VALUES ('"+username+"', '"+password+"', 'user')   ";
						st.executeUpdate(regi_string);
						con.close();
						JOptionPane.showMessageDialog(null, "You have successfully Registered, Welcome"+fname+""+lname);
					}
				} catch (Exception ex) {

				}
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBounds(268, 468, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textArea.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				passwordField.setText("");

			}
		});
		panel.add(btnNewButton_1);

		textField = new JTextField();
		textField.setBounds(174, 86, 179, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(174, 221, 179, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(174, 353, 179, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(174, 396, 179, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(174, 131, 179, 20);
		panel.add(passwordField);

		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(39, 89, 77, 14);
		panel.add(lblUserName);

		textField_5 = new JTextField();
		textField_5.setBounds(174, 178, 179, 20);
		textField_5.setColumns(10);
		panel.add(textField_5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(174, 267, 192, 75);
		panel.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
