package packersandmovers;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class A extends JFrame {

	private JPanel contentPane;
	
	String customerid, fname,lname,address,contact,emailid, password, status;
	char[] pass;
	int length;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A frame = new A();
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
	public A() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(193, 36, 205, 76);
		panel.add(textArea);
		
		final JTextArea textArea1 = new JTextArea();
		textArea1.setBounds(193, 146, 205, 76);
		panel.add(textArea1);
		
		JLabel lblNewLabel = new JLabel("name");
		lblNewLabel.setBounds(45, 55, 46, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("display");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try
				 {
					 Class.forName("oracle.jdbc.OracleDriver");
				 Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
				 Statement st= con.createStatement();
				 customerid="PNMC000002";
				 fname="sid";
				 lname="s";
				 emailid="@";
				 address="i";
				 contact="1";
				 password="sid";
				 status="";
				 PreparedStatement ps=con.prepareStatement("insert into client values(?,?,?,?,?,?,?,?)");
		            ps.setString(1, customerid);
		            ps.setString(2, fname);
		            ps.setString(3, lname);
		            ps.setString(4, address);
		            ps.setString(5, contact);
		            ps.setString(6, emailid);
		            ps.setString(7, status);
		            ps.setString(8, password);
		            ps.executeUpdate();
//				 String q="Select length from routelength where routepoint1='palasia' and routepoint2='vijaynagar'";
//					ResultSet rs= st.executeQuery(q);
//		            if (rs.next())
//		            {
//		            	length=rs.getInt(1);
//		            }
//				 String q="Select customerid from client where c_firstname='palash'";
//				 ResultSet rs= st.executeQuery(q);
//				 if(rs.next())
//				 {
//				 customerid=rs.getString(1);
//				 System.out.println(customerid);
//				 }
//				customerid = textArea.getText();
//				String a=textArea.getText();
//				textArea1.setText(String.valueOf(length));
				textArea1.setText(customerid);
				con.close();
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 }
				
			}
		});
		btnNewButton.setBounds(38, 119, 89, 23);
		panel.add(btnNewButton);
		
		}
}

