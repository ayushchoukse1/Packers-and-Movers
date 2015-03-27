package packersandmovers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class Updateempdetails {
String empid;	
public String temp_fname,temp_lname,temp_post,temp_cont,temp_add,temp_age,temp_gender,temp_salary,temp;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextArea textArea;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_4;
	private JComboBox comboBox;
	private JRadioButton radioButton,radioButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updateempdetails window = new Updateempdetails();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Updateempdetails() {
		
	}
/**
 * @wbp.parser.entryPoint
 */
public Updateempdetails(String a){
	empid=a;
	set_values(a);
	initialize();
	frame.setVisible(true);
}
	public void set_values(String a){
		
		temp=a;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
			String get_emp_detail="SELECT E_FIRSTNAME, E_LASTNAME, E_POST, E_ADDRESS, E_CONTACT, E_AGE, E_GENDER, E_SALARY FROM EMPLOYEE WHERE EMPLOYEEID = '"+empid+"'";
			
	Statement st=con.createStatement();

	ResultSet rs=st.executeQuery(get_emp_detail);
			while(rs.next())
			{
			 temp_fname=rs.getString(1);
			
			
			 temp_lname=rs.getString(2);
			
			 temp_post=rs.getString(3);
			 temp_add=rs.getString(4);
				temp_cont=rs.getString(5);
				
				temp_age=rs.getString(6);
				temp_gender=rs.getString(7);
				temp_salary=rs.getString(8);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * Create the application.
	 */
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Updateempdetails.class.getResource("/packersandmovers/logo1.jpg")));
		frame.setBounds(100, 100, 327, 571);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 318, 533);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setBounds(10, 14, 86, 14);
		panel.add(lblFirstName);

		JLabel label_1 = new JLabel("Post :");
		label_1.setBounds(10, 83, 46, 14);
		panel.add(label_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(93, 11, 170, 20);
		panel.add(textField);
		textField.setText(temp_fname);

		JLabel label_2 = new JLabel("Contact :");
		label_2.setBounds(10, 127, 58, 14);
		panel.add(label_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(93, 124, 86, 20);
		panel.add(textField_1);
		textField_1.setText(temp_cont);

		JLabel label_3 = new JLabel("Address :");
		label_3.setBounds(10, 179, 58, 14);
		panel.add(label_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 174, 170, 86);
		panel.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText(temp_add);

		JLabel label_4 = new JLabel("Age :");
		label_4.setBounds(10, 302, 46, 14);
		panel.add(label_4);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(93, 299, 170, 20);
		panel.add(textField_2);
		textField_2.setText(temp_age);

		JLabel label_5 = new JLabel("Gender :");
		label_5.setBounds(10, 360, 58, 14);
		panel.add(label_5);

		radioButton = new JRadioButton("Male");
		buttonGroup.add(radioButton);
		radioButton.setBounds(93, 356, 58, 23);
		panel.add(radioButton);

		radioButton_1 = new JRadioButton("Female");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(198, 356, 118, 23);
		panel.add(radioButton_1);
		if (temp_gender=="male") {
			radioButton_1.setSelected(true);
		} else {
			radioButton.setSelected(true);
		}
		JLabel label_6 = new JLabel("Salary : ");
		label_6.setBounds(10, 409, 46, 14);
		panel.add(label_6);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(93, 406, 86, 20);
		panel.add(textField_3);
		textField_3.setText(temp_salary);

		JButton btnUpdateDetails = new JButton("Update Details");
		btnUpdateDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					String set_fname,set_lname,set_add,set_cont,set_post,set_age,set_salary,set_gender;
					set_fname=textField.getText();
					set_lname=textField_4.getText();
					set_add=textArea.getText();
					set_cont=textField_1.getText();
					set_age=textField_2.getText();
					set_salary=textField_3.getText();
					set_post=(String)comboBox.getSelectedItem();
					if (radioButton.isSelected()) {
						set_gender="Male";
					} else {
						set_gender="Female";
					}
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
		Statement st=con.createStatement();
		String query="UPDATE EMPLOYEE SET E_FIRSTNAME = '"+set_fname+"', E_LASTNAME = '"+set_lname+"', E_POST = '"+set_post+"', E_ADDRESS = '"+set_add+"', E_CONTACT = '"+set_cont+"', E_AGE = '"+set_age+"', E_GENDER = '"+set_gender+"', E_SALARY = '"+set_salary+"' WHERE EMPLOYEEID = '"+temp+"'";
		int reply = JOptionPane.showConfirmDialog(null, "All THE ENTRIES WILL BE UPDATED", "Are you sure ?", JOptionPane.YES_NO_OPTION);
		if (reply==JOptionPane.YES_OPTION) {
			
		st.executeUpdate(query);
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	JOptionPane.showMessageDialog(null, "Done!!");
	frame.dispose();
			}
		});
		btnUpdateDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnUpdateDetails.setBounds(10, 474, 118, 23);
		panel.add(btnUpdateDetails);

		JButton button_1 = new JButton("Reset");
		button_1.setBounds(198, 474, 89, 23);
		panel.add(button_1);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Please Select", "Packer", "Mover", "Driver" }));
		comboBox.setBounds(93, 80, 109, 20);
		panel.add(comboBox);
		Object temp_obj=(Object)temp_post;
		comboBox.setSelectedItem(temp_obj);
		
		JLabel lblLastname = new JLabel("LastName :");
		lblLastname.setBounds(10, 42, 86, 14);
		panel.add(lblLastname);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(93, 39, 170, 20);
		panel.add(textField_4);
		textField_4.setText(temp_lname);
	}
}
