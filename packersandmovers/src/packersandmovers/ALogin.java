package packersandmovers;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class ALogin extends JFrame{
static int counter=0;
	private JFrame frmLoginWindow;
	private JTextField textField;
	private JPasswordField passwordField;
	String id,pass;
	static String customerid, username, password;
	String uname, pword; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ALogin window = new ALogin();
					window.frmLoginWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ALogin() {
		initialize();
		frmLoginWindow.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginWindow = new JFrame();
		frmLoginWindow.setFont(new Font("Dialog", Font.BOLD, 14));
		frmLoginWindow.setTitle("ALogin Window");
		frmLoginWindow.getContentPane().setBackground(Color.WHITE);
		frmLoginWindow.setBounds(100, 100, 814, 510);
		frmLoginWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLoginWindow.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(411, 39, 388, 115);
		frmLoginWindow.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ALogin Id :");
		lblNewLabel_1.setBounds(49, 11, 78, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setBounds(49, 55, 78, 14);
		panel.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(164, 8, 195, 20);
		panel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(164, 52, 195, 20);
		panel.add(passwordField);

		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 id = textField.getText();
				 System.out.println(id);
				 pass = passwordField.getText();
				 System.out.println(pass);
				if(id.isEmpty()||pass.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "USER/PASSWORD fields are empty");
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
		        							"ALogin successful, WELCOME ADMIN");
		        					frmLoginWindow.dispose();
		        					new Admin();
		        					break;
		        				} else if ( post.equals("client")&user1.equals(id)&pass1.equals(pass)) {
		        					JOptionPane.showMessageDialog(null,
		        							"ALogin successful, WELCOME " + id);
		        					ResultSet rs2=st.executeQuery("select customerid from client where username='"+username+"'");
		    						if(rs2.next())
		    						{
		    							customerid=rs2.getString(1);
		    							System.out.println(customerid);
		    						}
		        					frmLoginWindow.dispose();
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
		btnSignIn.setBounds(270, 83, 89, 23);
		panel.add(btnSignIn);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ALogin.class.getResource("/packersandmovers/Untitled.jpg")));
		lblNewLabel.setBounds(10, 11, 403, 169);
		frmLoginWindow.getContentPane().add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(540, 154, 259, 48);
		frmLoginWindow.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblDontHaveAn = new JLabel("Don't have an Account ?");
		lblDontHaveAn.setBounds(23, 22, 159, 14);
		panel_1.add(lblDontHaveAn);

		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Clientregister().setVisible(true);
			}
		});
		button.setBounds(160, 11, 75, 25);
		panel_1.add(button);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.WHITE);
		button.setIcon(new ImageIcon(ALogin.class.getResource("/packersandmovers/signup-button - Copy.png")));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 201, 799, 273);
		frmLoginWindow.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ALogin.class.getResource("/packersandmovers/banner123.jpg")));
		label.setBounds(0, 0, 799, 273);
		panel_2.add(label);
	}
	
	public ArrayList myItems0() {
		ArrayList list0 = new ArrayList();
		list0.add(customerid);
//        System.out.println(list1);
		return list0;
	}
}