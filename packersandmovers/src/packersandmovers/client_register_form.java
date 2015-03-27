package packersandmovers;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


public class client_register_form extends JFrame {
	static String customerid, fname,lname,address,contact,emailid, status, username, password;
	char[] pass;
    static int num;
	static StringBuilder finalstring;
	public  String tempfeed;
	static String final_string,final_string1,final_string3_emp;
	public StringBuilder string;
	public StringBuilder tempfeed3;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	
	public void CustomerIdGenerator() {
		System.out.println(tempfeed+tempfeed3+final_string1);
			try {
				Class.forName("oracle.jdbc.OracleDriver");

				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");

				Statement st = con.createStatement();
				String temp = "SELECT customerid FROM client where ROWNUM<=1 order by customerid desc";
				ResultSet rs = st.executeQuery(temp);
				while (rs.next()) {
					String feed = rs.getString(1);
					System.out.println(feed);
					String tempfeed1 = feed.substring(0, 4);
					StringBuilder tempfeed3=new StringBuilder(tempfeed1);
					tempfeed = feed.substring(4, 10);
					
					String tempfeed2 = String.valueOf(Integer.parseInt(tempfeed) + 1);
					int i=tempfeed2.length();
					System.out.println(i);
					if(i==1)
					{
						StringBuilder string=new StringBuilder("00000");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);	
						final_string1=tempfeed3.toString();
						
					}
					if(i==2)
					{
						StringBuilder string=new StringBuilder("0000");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);
						final_string1=tempfeed3.toString();
						
					}
					if(i==3)
					{
						StringBuilder string=new StringBuilder("000");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);
						final_string1=tempfeed3.toString();
						
					}
					if(i==4)
					{
						StringBuilder string=new StringBuilder("00");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);
						final_string1=tempfeed3.toString();
						
					}
					if(i==5)
					{
						StringBuilder string=new StringBuilder("0");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);
						final_string1=tempfeed3.toString();
						
					}
					
					if(i==6)
					{
						StringBuilder string=new StringBuilder("");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);
						final_string1=tempfeed3.toString();
						
					}
				
				}
				con.close();
				customerid= final_string1;
			} catch (Exception e) {
				e.printStackTrace();
			}
//			System.out.println(customerid);
//			return final_string1;
	}
			
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client_register_form frame = new client_register_form();
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
	public client_register_form() {
		CustomerIdGenerator();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 32));
		lblNewLabel.setBounds(118, 11, 301, 45);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(93, 90, 105, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(93, 133, 105, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(93, 175, 105, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contact Number");
		lblNewLabel_4.setBounds(93, 275, 105, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email Id");
		lblNewLabel_5.setBounds(93, 318, 105, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setBounds(93, 407, 105, 14);
		panel.add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(276, 170, 179, 80);
		panel.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 248, 220));
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Class.forName("oracle.jdbc.OracleDriver");
	            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
	            fname=textField.getText();
	            lname=textField_1.getText();
	            address=textArea.getText();
	            contact=textField_3.getText();
	            emailid=textField_4.getText();
	            username=textField_5.getText();
	            pass=passwordField.getPassword();
	            password= new String(pass);
	            status="";
//	            double client_id1=Math.random()*10000000;
//	            client_id=(int) Math.ceil(client_id1);
//	            System.out.println(fname);
//	            System.out.println(lname);
//	            System.out.println(password);
	            
//	            System.out.println("@@ "+customerid);
//	            if(password.length()<4 || password.length()>10)
//	            {
//	                JOptionPane.showMessageDialog(null, "Invalid Password");
//	            }
	            if(fname.equals("") || lname.equals("") || address.equals("") || contact.equals("") || emailid.equals("") || username.equals("") || password.equals(""))
	            {       
	                JOptionPane.showMessageDialog(null,"one or more fields are empty");
	            }
	            else
	            {
	            PreparedStatement ps=con.prepareStatement("insert into client values(?,?,?,?,?,?,?,?,?)");
	            ps.setString(1, customerid);
	            System.out.println(customerid);
	            ps.setString(2, fname);
	            ps.setString(3, lname);
	            ps.setString(4, address);
	            ps.setString(5, contact);
	            ps.setString(6, emailid);
	            ps.setString(7, status);
	            ps.setString(8, password);
	            ps.setString(9, username);
	            ps.executeUpdate();
	            PreparedStatement ps1=con.prepareStatement("insert into login values(?,?,?)");
	            ps1.setString(1, username);
	            ps1.setString(2, password);
	            ps1.setString(3, "client");
	            ps1.executeUpdate();
	            con.close();
//	            CustomerIdGenerator();
	            JOptionPane.showMessageDialog(null,"Welcome "+textField.getText()+", your Customer ID is: "+customerid);
	            new Login().setVisible(true);
	            dispose();
	            }
				} catch (Exception ex) {
					ex.printStackTrace();
				} 
			}
		});
		btnNewButton.setBounds(130, 459, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
		        textField_1.setText("");
		        textArea.setText("");
		        textField_3.setText("");
		        textField_4.setText("");
		        passwordField.setText("");
			}
		});
		btnNewButton_1.setBounds(330, 459, 89, 23);
		panel.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 248, 220));
		textField.setBounds(276, 87, 179, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 248, 220));
		textField_1.setBounds(276, 130, 179, 28);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 248, 220));
		textField_3.setBounds(276, 272, 179, 28);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(255, 248, 220));
		textField_4.setBounds(276, 315, 179, 28);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 248, 220));
		passwordField.setBounds(276, 404, 179, 28);
		panel.add(passwordField);
		
		JLabel lblNewLabel_7 = new JLabel("Username");
		lblNewLabel_7.setBounds(93, 361, 79, 14);
		panel.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(255, 248, 220));
		textField_5.setBounds(276, 358, 179, 28);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		}
}
