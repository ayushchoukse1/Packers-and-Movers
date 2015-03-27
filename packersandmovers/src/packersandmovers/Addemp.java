package packersandmovers;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Addemp {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextArea textArea;
	private JComboBox comboBox;
	private JRadioButton rdbtnFemale,rdbtnMale;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	String empid,empfname,emplname,empcont,empadd,empage,empgender,empsalary,emppost;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addemp window = new Addemp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Addemp() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Addemp.class.getResource("/packersandmovers/logo1.jpg")));
		frame.setBounds(100, 100, 339, 566);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 330, 528);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblName = new JLabel("First Name :");
		lblName.setBounds(10, 24, 86, 14);
		panel.add(lblName);

		JLabel lblPost = new JLabel("Post :");
		lblPost.setBounds(10, 96, 46, 14);
		panel.add(lblPost);

		textField = new JTextField();
		textField.setBounds(93, 21, 170, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblContact = new JLabel("Contact :");
		lblContact.setBounds(10, 140, 58, 14);
		panel.add(lblContact);

		textField_2 = new JTextField();
		textField_2.setBounds(93, 137, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblAddres = new JLabel("Address :");
		lblAddres.setBounds(10, 192, 58, 14);
		panel.add(lblAddres);

		 textArea = new JTextArea();
		textArea.setBounds(93, 187, 170, 86);
		panel.add(textArea);

		JLabel lblAge = new JLabel("Age :");
		lblAge.setBounds(10, 315, 46, 14);
		panel.add(lblAge);

		textField_3 = new JTextField();
		textField_3.setBounds(93, 312, 170, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(10, 373, 58, 14);
		panel.add(lblGender);

		 rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(93, 369, 58, 23);
		panel.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(198, 369, 118, 23);
		panel.add(rdbtnFemale);

		JLabel lblSalary = new JLabel("Salary : ");
		lblSalary.setBounds(10, 422, 46, 14);
		panel.add(lblSalary);

		textField_4 = new JTextField();
		textField_4.setBounds(93, 419, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);

		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getValues();
				if (empfname.isEmpty()||emplname.isEmpty()||emppost.isEmpty()||empcont.isEmpty()||empadd.isEmpty()||empage.isEmpty()||empgender.isEmpty()||empsalary.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill up All the Fields");
				} else {
					try {
						Class.forName("oracle.jdbc.OracleDriver");
						Connection con = DriverManager.getConnection(
								"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
						Statement st=con.createStatement();
						String query="INSERT INTO EMPLOYEE (EMPLOYEEID, E_FIRSTNAME, E_LASTNAME, E_POST, E_ADDRESS, E_CONTACT, E_AGE, E_GENDER, E_SALARY) VALUES ('"+empid+"', '"+empfname+"', '"+emplname+"', '"+emppost+"','"+empadd+"', '"+empcont+"', '"+empage+"', '"+empgender+"', '"+empsalary+"') ";
						st.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Employee has been Registerd with this "+empid+" ID");
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
				frame.dispose();
			}
		});
		btnAddEmployee.setBounds(10, 487, 118, 23);
		panel.add(btnAddEmployee);

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(198, 487, 89, 23);
		panel.add(btnReset);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Please Select", "Packer", "Mover", "Driver" }));
		comboBox.setBounds(93, 93, 109, 20);
		panel.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(93, 52, 170, 20);
		panel.add(textField_1);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setBounds(10, 55, 86, 14);
		panel.add(lblLastName);
	}
	public void getValues(){
		Idgenerator obj=new Idgenerator();
		obj.EmployeeIdGenerator();
		empid=obj.final_string3_emp;
		empfname=textField.getText();
		emplname=textField_1.getText();
		emppost=(String)comboBox.getSelectedItem();
		empcont=textField_2.getText();
		empadd=textArea.getText();
		empage=textField_3.getText();
		if (rdbtnMale.isSelected()) {
			empgender="Male";
		} else {
			empgender="Female";
		}
		empsalary=textField_4.getText();
		System.out.println(empid+empfname+emplname+emppost+empadd+empage+empcont+empgender+empsalary);
	}
}
