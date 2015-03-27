package packersandmovers;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class Updateclientstatus {
static int tag;
String temp;
	private JFrame frmUpdateStatus;
	private JTextField textField;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updateclientstatus window = new Updateclientstatus();
					window.frmUpdateStatus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Updateclientstatus() {
		

	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public Updateclientstatus(String a){
		temp=a;
		System.out.println(temp);

		initialize();
		frmUpdateStatus.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmUpdateStatus = new JFrame();
		frmUpdateStatus.setIconImage(Toolkit.getDefaultToolkit().getImage(Updateclientstatus.class.getResource("/packersandmovers/logo1.jpg")));
		frmUpdateStatus.setTitle("Update Status");
		frmUpdateStatus.setBounds(100, 100, 418, 272);
		frmUpdateStatus.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUpdateStatus.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(166, 30, 129, 20);
		frmUpdateStatus.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(temp);

		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Please Select", "Pending", "Done", "In Progress" }));
		comboBox.setBounds(166, 89, 129, 20);
		frmUpdateStatus.getContentPane().add(comboBox);

		JLabel lblNewLabel = new JLabel("Customer Id");
		lblNewLabel.setBounds(52, 33, 98, 14);
		frmUpdateStatus.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Status");
		lblNewLabel_1.setBounds(52, 92, 64, 14);
		frmUpdateStatus.getContentPane().add(lblNewLabel_1);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id=textField.getText();
				if(comboBox.getSelectedIndex()!=0)
				{
				
				
				String status=(String)comboBox.getSelectedItem();
				String temp= id.toUpperCase();
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
					Statement st=con.createStatement();
					String query="SELECT CustomerID FROM CLIENT";
					ResultSet rs=st.executeQuery(query);
					
						while(rs.next()){
							
							String temp1=rs.getString(1);
							if(id.equals(temp1))
							{
								try{
							Statement st1=con.createStatement();
							String up_status="UPDATE CLIENT SET C_STATUS = '"+status+"' WHERE CustomerID = '"+id+"'";
							st1.executeUpdate(up_status);
							tag=0;
							JOptionPane.showMessageDialog(null, "Status Updated");
							frmUpdateStatus.dispose();
								}catch(Exception e1)
								{
									e1.printStackTrace();
								}
							}else{
								tag++;
							}
						}
						if(tag!=0){
							
						}
				}
				 catch (Exception e2) {
					// TODO: handle exception
				}
			}else{	JOptionPane.showMessageDialog(null, "Select A Status");
			}
			}
		});
		btnUpdate.setBounds(166, 158, 89, 23);
		frmUpdateStatus.getContentPane().add(btnUpdate);
	}
}
