package packersandmovers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;
import java.awt.Toolkit;

public class Viewfeedback {
	public String temp_cid,temp_fname,temp_lname,temp_add,temp_cont,temp_email,temp,temp_service,temp_beh,temp_overall,temp_comments;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextArea textArea,textArea_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewfeedback window = new Viewfeedback();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void set_values(String a){
		
		temp=a;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
			String get_client_detail="SELECT f_FIRSTNAME, f_LASTNAME, f_SERVICES, f_BEHAVIOUR, F_OVERALL, F_COMMENTS, CUSTOMERID FROM FEEDBACK WHERE FEEDBACKID = '"+temp+"'";
			
	Statement st=con.createStatement();

	ResultSet rs=st.executeQuery(get_client_detail);
			while(rs.next())
			{
				temp_cid=rs.getString(7);
			 temp_fname=rs.getString(1);
			 temp_lname=rs.getString(2);
//			 temp_add=rs.getString(3);
//				temp_email=rs.getString(5);
//				temp_cont=rs.getString(6);
				temp_service=rs.getString(3);
				temp_beh=rs.getString(4);
				temp_overall=rs.getString(5);
				temp_comments=rs.getString(6);
			System.out.println(temp_comments);
				
				 
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * Create the application.
	 */
	public Viewfeedback() {
		
	}
/**
 * @wbp.parser.entryPoint
 */
public Viewfeedback(String a){
	set_values(a);
	initialize();
	frame.setVisible(true);
}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Viewfeedback.class.getResource("/packersandmovers/logo1.jpg")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 662, 602);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 646, 577);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblFeedbackNumber = new JLabel("Feedback number :");
		lblFeedbackNumber.setBounds(23, 27, 126, 14);
		panel.add(lblFeedbackNumber);

		JLabel lblCustomerId = new JLabel("Customer ID :");
		lblCustomerId.setBounds(23, 55, 102, 14);
		panel.add(lblCustomerId);

		JLabel lblName = new JLabel("First Name : ");
		lblName.setBounds(23, 80, 102, 14);
		panel.add(lblName);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(23, 149, 102, 14);
		panel.add(lblAddress);

		JLabel lblEmailId = new JLabel("Email Id :");
		lblEmailId.setBounds(23, 233, 102, 14);
		panel.add(lblEmailId);

		JLabel lblContact = new JLabel("Contact :");
		lblContact.setBounds(23, 268, 102, 14);
		panel.add(lblContact);

		JLabel lblServices = new JLabel("Services :");
		lblServices.setBounds(23, 303, 102, 14);
		panel.add(lblServices);

		JLabel lblBehaviour = new JLabel("Behaviour :");
		lblBehaviour.setBounds(23, 338, 102, 14);
		panel.add(lblBehaviour);

		JLabel lblOverall = new JLabel("Overall :");
		lblOverall.setBounds(23, 373, 102, 14);
		panel.add(lblOverall);

		JLabel lblComments = new JLabel("Comments :");
		lblComments.setBounds(23, 415, 102, 14);
		panel.add(lblComments);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(159, 24, 155, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(159, 52, 155, 20);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(159, 77, 155, 20);
		panel.add(textField_2);

		textField_3 = new JTextField();
		//textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(159, 230, 155, 20);
		textField_3.setEditable(false);
		panel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(159, 265, 155, 20);
		panel.add(textField_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(159, 144, 256, 75);
		panel.add(scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(169, 410, 256, 75);
		panel.add(scrollPane_1);

		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);

		JRadioButton rdbtnPoor = new JRadioButton(temp_service);
		buttonGroup.add(rdbtnPoor);
		
		rdbtnPoor.setBounds(156, 299, 109, 23);
		panel.add(rdbtnPoor);
/*
		JRadioButton rdbtnGood = new JRadioButton("Good");
		buttonGroup.add(rdbtnGood);
		rdbtnGood.setBounds(267, 299, 109, 23);
		panel.add(rdbtnGood);

		JRadioButton rdbtnVeryGood = new JRadioButton("Very Good");
		buttonGroup.add(rdbtnVeryGood);
		rdbtnVeryGood.setBounds(398, 299, 109, 23);
		panel.add(rdbtnVeryGood);

		JRadioButton rdbtnExcellent = new JRadioButton("Excellent");
		buttonGroup.add(rdbtnExcellent);
		rdbtnExcellent.setBounds(531, 299, 109, 23);
		panel.add(rdbtnExcellent);
*/
		JRadioButton radioButton = new JRadioButton(temp_beh);
		buttonGroup_1.add(radioButton);
		radioButton.setBounds(156, 329, 109, 23);
		panel.add(radioButton);
/*
		JRadioButton radioButton_1 = new JRadioButton("Good");
		buttonGroup_1.add(radioButton_1);
		radioButton_1.setBounds(267, 329, 109, 23);
		panel.add(radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton("Very Good");
		buttonGroup_1.add(radioButton_2);
		radioButton_2.setBounds(398, 329, 109, 23);
		panel.add(radioButton_2);

		JRadioButton radioButton_3 = new JRadioButton("Excellent");
		buttonGroup_1.add(radioButton_3);
		radioButton_3.setBounds(531, 329, 109, 23);
		panel.add(radioButton_3);
*/
		JRadioButton radioButton_4 = new JRadioButton(temp_overall);
		buttonGroup_2.add(radioButton_4);
		radioButton_4.setBounds(156, 364, 109, 23);
		panel.add(radioButton_4);
/*
		JRadioButton radioButton_5 = new JRadioButton("Good");
		buttonGroup_2.add(radioButton_5);
		
		radioButton_5.setBounds(267, 364, 109, 23);
		panel.add(radioButton_5);

		JRadioButton radioButton_6 = new JRadioButton("Very Good");
		buttonGroup_2.add(radioButton_6);
		radioButton_6.setBounds(398, 364, 109, 23);
		panel.add(radioButton_6);

		JRadioButton radioButton_7 = new JRadioButton("Excellent");
		buttonGroup_2.add(radioButton_7);
		radioButton_7.setBounds(531, 364, 109, 23);
		panel.add(radioButton_7);*/
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(159, 105, 155, 20);
		panel.add(textField_5);
		System.out.println(temp_cid+temp_fname+temp_lname+temp_add+temp_cont+temp_email+temp+temp_service+temp_beh+temp_overall+temp_comments);
		textField.setText(temp);
		textField_1.setText(temp_cid);
		textField_2.setText(temp_fname);
		textField_5.setText(temp_lname);
		textArea.setText(temp_add);
		textField_3.setText(temp_email);
		textField_4.setText(temp_cont);
		textArea_1.setText(temp_comments);
		/*
		if (temp_service.equalsIgnoreCase("poor")) {
			rdbtnPoor.setSelected(true);
		} else {if (temp_service.equalsIgnoreCase("good")) {
			rdbtnGood.setSelected(true);
		} else {if (temp_service.equalsIgnoreCase("very good")) {
			rdbtnVeryGood.setSelected(true);
		} else {
			rdbtnExcellent.setSelected(true);

		}
		if (temp_beh.equalsIgnoreCase("poor")) {
			radioButton.setSelected(true);
		} else {if (temp_beh.equalsIgnoreCase("good")) {
			radioButton_1.setSelected(true);
		} else {if (temp_beh.equalsIgnoreCase("very good")) {
			radioButton_2.setSelected(true);
		} else {radioButton_3.setSelected(true);

		}
		if (temp_overall.equalsIgnoreCase("poor")) {
			radioButton_4.setSelected(true);
		} else {if (temp_overall.equalsIgnoreCase("good")) {
				radioButton_5.setSelected(true);
		} else {if (temp_overall.equalsIgnoreCase("very good")) {
			radioButton_6.setSelected(true);
		} else {
			radioButton_7.setSelected(true);

		}

		}

		}

		}

		}
		}*/

		
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnClose.setBounds(149, 527, 89, 23);
		panel.add(btnClose);
		
		JLabel lblLastName = new JLabel("Last Name : ");
		lblLastName.setBounds(23, 108, 102, 14);
		panel.add(lblLastName);
		
		
	}
}
