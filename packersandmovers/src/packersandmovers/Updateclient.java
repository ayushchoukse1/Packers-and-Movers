package packersandmovers;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Updateclient {
	public String temp_fname,temp_lname,temp_add,temp_cont,temp_email,temp;
	private JFrame frmUpdateClient;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextArea textArea;
	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updateclient window = new Updateclient();
					window.frmUpdateClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Updateclient(){
		initialize();
	}
	public Updateclient(String a){
		set_values(a);
		initialize();
		frmUpdateClient.setVisible(true);
	}
/**
 * @wbp.parser.entryPoint
 */
public void set_values(String a){
	
	temp=a;
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
		String get_client_detail="SELECT C_FIRSTNAME, C_LASTNAME, C_ADDRESS, C_CONTACT, C_EMAILID FROM CLIENT WHERE CustomerID = '"+temp+"'";
		
Statement st=con.createStatement();

ResultSet rs=st.executeQuery(get_client_detail);
		while(rs.next())
		{
		 temp_fname=rs.getString(1);
		
		
		 temp_lname=rs.getString(2);
		
		 temp_add=rs.getString(3);
		
			temp_cont=rs.getString(4);
			
			temp_email=rs.getString(5);
			
			 
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frmUpdateClient = new JFrame();
		frmUpdateClient.setIconImage(Toolkit.getDefaultToolkit().getImage(Updateclient.class.getResource("/packersandmovers/logo1.jpg")));
		frmUpdateClient.setResizable(false);
		frmUpdateClient.setTitle("UPDATE CLIENT");
		frmUpdateClient.setBounds(100, 100, 291, 382);
		frmUpdateClient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUpdateClient.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 292, 437);
		frmUpdateClient.getContentPane().add(scrollPane_1);

		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setBounds(10, 14, 95, 14);
		panel.add(lblFirstName);
		
		JLabel label_2 = new JLabel("Address:");
		label_2.setBounds(10, 97, 65, 14);
		panel.add(label_2);

		JLabel label_3 = new JLabel("Contact:");
		label_3.setBounds(10, 175, 65, 14);
		panel.add(label_3);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 231, 65, 14);
		panel.add(lblEmail);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(102, 11, 153, 20);
		panel.add(textField);
		textField.setText(temp_fname);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(102, 78, 153, 69);
		panel.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setText(temp_add);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(102, 172, 153, 20);
		panel.add(textField_1);
		textField_1.setText(temp_cont);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(102, 228, 153, 20);
		panel.add(textField_2);
		textField_2.setText(temp_email);
		
		JButton button = new JButton("Update Client");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String set_fname,set_lname,set_add,set_cont,set_email;
				set_fname=textField.getText();
				set_lname=textField_4.getText();
				set_add=textArea.getText();
				set_cont=textField_1.getText();
				set_email=textField_2.getText();
				
try {
	Class.forName("oracle.jdbc.OracleDriver");
	Connection con = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
	Statement st=con.createStatement();
	String query="UPDATE CLIENT SET C_FIRSTNAME ='"+set_fname+"', C_LASTNAME = '"+set_lname+"', C_ADDRESS = '"+set_add+"', C_CONTACT = '"+set_cont+"', C_EMAILID = '"+set_email+"' WHERE CustomerID = '"+temp+"'";
	int reply = JOptionPane.showConfirmDialog(null, "All THE ENTRIES WILL BE UPDATED", "Are you sure ?", JOptionPane.YES_NO_OPTION);
	if (reply==JOptionPane.YES_OPTION) {
		
	st.executeUpdate(query);
	}
	
} catch (Exception e) {
	// TODO: handle exception
}
JOptionPane.showMessageDialog(null, "Done!!");
frmUpdateClient.dispose();
			}
			
		});
		button.setBounds(78, 291, 120, 23);
		panel.add(button);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(102, 42, 153, 20);
		panel.add(textField_4);
		textField_4.setText(temp_lname);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setBounds(10, 45, 95, 14);
		panel.add(lblLastName);
	}
}
