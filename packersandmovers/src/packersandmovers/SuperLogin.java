package packersandmovers;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SuperLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	static String customerid, post, username, password;
	String uname, pword; 
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuperLogin frame = new SuperLogin();
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
	public SuperLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 409);
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
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(146, 123, 69, 14);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(256, 123, 215, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(146, 182, 69, 14);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SuperLogin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
				Statement st= con.createStatement();
				username=textField.getText();
				System.out.println(username);
				char[] pass=passwordField.getPassword();
				password=new String(pass);
				System.out.println(password);
//				String q1="select username, password from login";
//				ResultSet rs1=st.executeQuery(q1);
//				while(rs1.next())
//				{
//					uname=rs1.getString(1);
//					System.out.println(uname);
//					pword=rs1.getString(2);
//					System.out.println(pword);
//				}
//				if(username1==uname && password1==pword)
//				{
//					JOptionPane.showMessageDialog(null, "login successful!");
					
				String q="Select post from login where username='"+username+"' and password='"+password+"'";
					ResultSet rs= st.executeQuery(q);
					System.out.println(post);
					if (rs.next())
					{
						post=rs.getString(1);
						System.out.println(post);
					}
					if(post.equals("admin"))
					{
						JOptionPane.showMessageDialog(null, "Welcome Admin");
						new AdminHome().setVisible(true);
						dispose();
					}
					if(post.equals("client"))
					{
						ResultSet rs2=st.executeQuery("select customerid from client where username='"+username+"'");
						if(rs2.next())
						{
							customerid=rs2.getString(1);
							System.out.println(customerid);
						}
						
						JOptionPane.showMessageDialog(null, "Welcome "+username);
						new ClientHome().setVisible(true);
						dispose();
					}
					con.close();
				}
//				else
//				{
//					JOptionPane.showMessageDialog(null, "username or password incorrect!");
//				}
//				}
//				con.close();
//				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(172, 245, 89, 23);
		panel_1.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(256, 179, 215, 20);
		panel_1.add(passwordField);
	}
	public ArrayList myItems0() {
		ArrayList list0 = new ArrayList();
		list0.add(customerid);
//        System.out.println(list1);
		return list0;
	}
}
