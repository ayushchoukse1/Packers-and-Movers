package packersandmovers;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class AdminCheck extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCheck frame = new AdminCheck();
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
	public AdminCheck() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminCheck.class.getResource("/packersandmovers/logo1.jpg")));
		setTitle("Admin Signup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration PIN");
		lblNewLabel.setBounds(41, 32, 105, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(184, 29, 163, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(41, 91, 93, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(41, 149, 105, 14);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 88, 163, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(184, 146, 163, 20);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("SignUp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String regPin=textField.getText();
				String userAdmin=textField_1.getText();
				char[] pass=passwordField.getPassword();
				String password=new String(pass);
				try
				{
					if(regPin.equals("PnM"))
					{
						Class.forName("oracle.jdbc.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
						PreparedStatement ps1=con.prepareStatement("insert into login values(?,?,?)");
			            ps1.setString(1, userAdmin);
			            ps1.setString(2, password);
			            ps1.setString(3, "admin");
			            ps1.executeUpdate();
			            con.close();
//			            CustomerIdGenerator();
			            JOptionPane.showMessageDialog(null,"Welcome Admin, your Username is: "+userAdmin);
			            new Login().setVisible(true);
			            dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Registration PIN is Incorrect!");
					}
				}
				catch (Exception ex) {
				ex.printStackTrace();
				}
				}
		});
		btnNewButton.setBounds(77, 194, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(232, 194, 89, 23);
		panel.add(btnNewButton_1);
	}

}
