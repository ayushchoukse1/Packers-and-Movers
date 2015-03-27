package packersandmovers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	static int counter=0;
	String id,pass;
	static String customerid, username, password;
	String uname, pword;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("Packers n Movers");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/packersandmovers/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 5), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 11, 415, 192);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/packersandmovers/Untitled.jpg")));
		lblNewLabel.setBounds(0, 0, 415, 192);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblNewLabel_1.setBounds(723, 350, 65, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblNewLabel_2.setBounds(723, 396, 65, 14);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(795, 348, 148, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id = textField.getText();
				 System.out.println(id);
				 pass = passwordField.getText();
				 System.out.println(pass);
				if(id.isEmpty()||pass.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "USERNAME/PASSWORD fields are empty");
				}
				
				try{
				Class.forName("oracle.jdbc.OracleDriver");

				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
			
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("SELECT COUNT(*)FROM login WHERE PASSWORD = '"+pass+"' AND USERNAME = '"+id+"' ");
				String query_pass = "SELECT * FROM login WHERE USERNAME = '"+id+"' AND PASSWORD = '"+pass+"'";
				while (rs.next()) {
		            if( rs.getInt(1)>0 ) {
		            	ResultSet rs1 = st.executeQuery(query_pass);
		        		
		        		while(rs1.next()) {
		        			String post = rs1.getString(3);
		        			String user1=rs1.getString(1);
		        			String pass1=rs1.getString(2);
		        				if (post.equals("admin")&user1.equals(id)&pass1.equals(pass)) {
		        					JOptionPane.showMessageDialog(null,
		        							"Login successful, WELCOME ADMIN");
		        					new Admin();
		        					dispose();
		        					break;
		        				} else if ( post.equals("client")&user1.equals(id)&pass1.equals(pass)) {
		        					ResultSet rs2=st.executeQuery("select customerid from client where username='"+id+"'");
		    						if(rs2.next())
		    						{
		    							customerid=rs2.getString(1);
		    							System.out.println(customerid);
		    						}
		        					
		        					JOptionPane.showMessageDialog(null,
		        							"Login successful, WELCOME " + id);

		        					new ClientHome().setVisible(true);
		        					dispose();
		        					break;
		        				}
		        		}
		            } else {
		            	JOptionPane.showMessageDialog(null, "Invalid Username/Password.");
		            	textField.setText("");
		            	passwordField.setText(null);
		            }
		        }
				}catch(Exception e){
							e.printStackTrace();
						}
			}
		});
		btnNewButton.setBounds(859, 425, 84, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new client_register_form().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(859, 280, 84, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Don't have an Account?");
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblNewLabel_3.setBounds(711, 283, 138, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/packersandmovers/banner123.jpg")));
		lblNewLabel_4.setBounds(10, 204, 693, 258);
		panel.add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(795, 394, 148, 28);
		panel.add(passwordField);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new AdminCheck().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_5.setBounds(926, 635, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Copyright \u00A9 2013 Packers & Movers Ltd. All Rights Reserved");
		lblNewLabel_6.setBounds(20, 627, 386, 14);
		panel.add(lblNewLabel_6);
		
		JTextArea txtrIsharwalPackersAnd = new JTextArea();
		txtrIsharwalPackersAnd.setEditable(false);
		txtrIsharwalPackersAnd.setBorder(new TitledBorder(new LineBorder(new Color(240, 230, 140), 4, true), "About Us", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		txtrIsharwalPackersAnd.setFont(new Font("Century Gothic", Font.ITALIC, 14));
		txtrIsharwalPackersAnd.setWrapStyleWord(true);
		txtrIsharwalPackersAnd.setLineWrap(true);
		txtrIsharwalPackersAnd.setText("PACKERS & MOVERS  is an India based organization that offers professional packing and moving services for all type of goods across India.  We take pride in offering packing and unpacking services, loading and unloading services, car transportation services at the most economical cost and at the same time provide reliability in the service we provide.  We can help you with the services at local as well as national level i.e. relocation, moving, transferring your goods at the requisite location across India.");
		txtrIsharwalPackersAnd.setBounds(424, 21, 540, 157);
		panel.add(txtrIsharwalPackersAnd);
		
		JTextArea txtrRegisterWithUs = new JTextArea();
		txtrRegisterWithUs.setEditable(false);
		txtrRegisterWithUs.setFont(new Font("Century Gothic", Font.ITALIC, 13));
		txtrRegisterWithUs.setBorder(new TitledBorder(new LineBorder(new Color(240, 230, 140), 4, true), "Sign Up", TitledBorder.CENTER, TitledBorder.BOTTOM, null, new Color(0, 0, 255)));
		txtrRegisterWithUs.setWrapStyleWord(true);
		txtrRegisterWithUs.setLineWrap(true);
		txtrRegisterWithUs.setText("Register With us for a Free Quotation!\r\nUse the Sign Up link below.");
		txtrRegisterWithUs.setBounds(711, 204, 253, 65);
		panel.add(txtrRegisterWithUs);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBorder(new TitledBorder(new LineBorder(new Color(240, 230, 140), 4, true), "Sign In", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		lblNewLabel_7.setBounds(711, 326, 253, 136);
		panel.add(lblNewLabel_7);
		
		JLabel lblTC = new JLabel("T & C Apply*");
		lblTC.setBounds(834, 627, 74, 14);
		panel.add(lblTC);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Login.class.getResource("/packersandmovers/support.jpg")));
		lblNewLabel_8.setBounds(20, 473, 214, 78);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("+91-9876543210");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(20, 541, 214, 14);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Email Id: pan@packers&movers.com");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(10, 561, 253, 14);
		panel.add(lblNewLabel_10);
	}
	
	public ArrayList myItems0() {
		ArrayList list0 = new ArrayList();
		list0.add(customerid);
//        System.out.println(list1);
		return list0;
	}
}
