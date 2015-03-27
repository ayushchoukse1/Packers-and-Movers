package packersandmovers;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Toolkit;


public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField textField_4;
	
	static String customerid, c_emailid, c_firstname, c_lastname, c_address, c_contact, c_password, username;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Update.class.getResource("/packersandmovers/logo1.jpg")));
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ArrayList list0=new Login().myItems0();
		        customerid=(String)list0.get(0);
		        System.out.println(customerid);
		        textField_6.setText(customerid);
				try
				{
					Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "palash");
				Statement st=con.createStatement();
				String q="Select * from client where customerid='"+customerid+"'";
				ResultSet rs=st.executeQuery(q);
				if(rs.next())
				{
					c_firstname=rs.getString(2);
					c_lastname=rs.getString(3);
					c_address=rs.getString(4);
					c_contact=rs.getString(5);
					c_emailid=rs.getString(6);
					c_password=rs.getString(8);
					username=rs.getString(9);
					
				}
				con.close();
				
				textField.setText(c_firstname);
				textField_1.setText(c_lastname);
				textField_4.setText(c_address);
				textField_2.setText(c_contact);
				textField_3.setText(c_emailid);
				passwordField.setText(c_password);
				textField_5.setText(username);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 1000, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 248, 220));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		panel_2.setBounds(20, 0, 931, 130);
		panel_1.add(panel_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Update.class.getResource("/packersandmovers/logo1.jpg")));
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
		label.setBounds(10, 0, 92, 130);
		panel_2.add(label);
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(Update.class.getResource("/packersandmovers/banner3.jpg")));
		label_13.setBounds(102, 0, 829, 130);
		panel_2.add(label_13);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(47, 79, 79));
		panel_3.setBounds(20, 130, 931, 25);
		panel_1.add(panel_3);
		
		JLabel label_1 = new JLabel("Update Profile");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Update().setVisible(true);
				dispose();
			}
		});
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_1.setBounds(136, 0, 116, 28);
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("Give Requirements/Generate Quotation");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Quotation().setVisible(true);
				dispose();
			}
		});
		label_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_2.setBounds(328, 0, 315, 29);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("Feedback");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Feedback().setVisible(true);
				dispose();
			}
		});
		label_3.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_3.setBounds(704, 0, 86, 28);
		panel_3.add(label_3);
		
		JLabel label_5 = new JLabel("Logout");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int n=JOptionPane.showConfirmDialog(null, "Do you want to Logout?", "Logout", JOptionPane.YES_NO_OPTION);
				if(n==0)
				{
					new Login().setVisible(true);
					dispose();
				}
			}
		});
		label_5.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_5.setBounds(874, 0, 57, 28);
		panel_3.add(label_5);
		
		JLabel label_6 = new JLabel("Home");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ClientHome().setVisible(true);
				dispose();
			}
		});
		label_6.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_6.setBounds(10, 0, 86, 28);
		panel_3.add(label_6);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 248, 220));
		panel_4.setBounds(20, 164, 164, 461);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_4 = new JLabel("Customer Id:");
		label_4.setBounds(0, 26, 77, 20);
		panel_4.add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(255, 248, 220));
		textField_6.setOpaque(false);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBounds(58, 27, 116, 20);
		panel_4.add(textField_6);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 248, 220));
		panel_5.setLayout(null);
		panel_5.setBounds(184, 164, 767, 461);
		panel_1.add(panel_5);
		
		JLabel label_7 = new JLabel("First Name");
		label_7.setBounds(213, 90, 105, 14);
		panel_5.add(label_7);
		
		JLabel label_8 = new JLabel("Last Name");
		label_8.setBounds(213, 133, 105, 14);
		panel_5.add(label_8);
		
		JLabel label_9 = new JLabel("Address");
		label_9.setBounds(213, 175, 105, 14);
		panel_5.add(label_9);
		
		JLabel label_10 = new JLabel("Contact Number");
		label_10.setBounds(213, 220, 105, 14);
		panel_5.add(label_10);
		
		JLabel label_11 = new JLabel("Email Id");
		label_11.setBounds(213, 263, 105, 14);
		panel_5.add(label_11);
		
		JLabel label_12 = new JLabel("Password");
		label_12.setBounds(213, 359, 105, 14);
		panel_5.add(label_12);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "palash");
				Statement st=con.createStatement();
				c_firstname=textField.getText();
				c_lastname=textField_1.getText();
				c_address=textField_4.getText();
				c_contact=textField_2.getText();
				c_emailid=textField_3.getText();
//				c_password=passwordField.getText();
				char[] pass=passwordField.getPassword();
	            c_password= new String(pass);
	            username=textField_5.getText();
//	            "+customerid+"
				String q="update client set c_firstname='"+c_firstname+"', c_lastname='"+c_lastname+"', c_address='"+c_address+"', c_contact='"+c_contact+"', c_emailid='"+c_emailid+"', c_password='"+c_password+"', username='"+username+"' where customerid='"+customerid+"'";
				st.executeUpdate(q);
				con.close();
				JOptionPane.showMessageDialog(null, "Profile Updated!");
				}
				catch(Exception exc)
				{
					exc.printStackTrace();
				}
				
			}
		});
		btnUpdate.setBounds(213, 406, 89, 23);
		panel_5.add(btnUpdate);
		
		JButton button_1 = new JButton("Reset");
		button_1.setBounds(350, 406, 89, 23);
		panel_5.add(button_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 248, 220));
		textField.setColumns(10);
		textField.setBounds(396, 87, 179, 32);
		panel_5.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 248, 220));
		textField_1.setColumns(10);
		textField_1.setBounds(396, 130, 179, 32);
		panel_5.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 248, 220));
		textField_2.setColumns(10);
		textField_2.setBounds(396, 217, 179, 32);
		panel_5.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 248, 220));
		textField_3.setColumns(10);
		textField_3.setBounds(396, 260, 179, 32);
		panel_5.add(textField_3);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 248, 220));
		passwordField.setBounds(396, 356, 179, 32);
		panel_5.add(passwordField);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(255, 248, 220));
		textField_4.setColumns(10);
		textField_4.setBounds(396, 172, 179, 32);
		panel_5.add(textField_4);
		
		JLabel lblUpdateProfile = new JLabel("Update Profile");
		lblUpdateProfile.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblUpdateProfile.setBounds(298, 11, 196, 45);
		panel_5.add(lblUpdateProfile);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ClientHome().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(486, 406, 89, 23);
		panel_5.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(213, 311, 70, 14);
		panel_5.add(lblNewLabel);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(255, 248, 220));
		textField_5.setBounds(396, 308, 179, 32);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(106, 90, 205));
		panel_8.setBounds(49, 48, 684, 4);
		panel_5.add(panel_8);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(184, 154, 767, 10);
		panel_1.add(panel_6);
		panel_6.setBackground(new Color(240, 230, 140));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(20, 154, 174, 10);
		panel_1.add(panel_7);
		panel_7.setBackground(new Color(240, 230, 140));
		
		JLabel label_14 = new JLabel("Copyright \u00A9 2013 Packers & Movers Ltd. All Rights Reserved");
		label_14.setBounds(38, 656, 374, 14);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("T & C Apply*");
		label_15.setBounds(852, 656, 74, 14);
		panel_1.add(label_15);
	}
}
