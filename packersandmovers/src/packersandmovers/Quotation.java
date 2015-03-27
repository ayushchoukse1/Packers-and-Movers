package packersandmovers;

import java.awt.BorderLayout;
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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class Quotation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	static String quotationid, customerid, c_emailid, c_firstname, c_lastname,
			c_address, c_contact, q_shiftfrom, q_shiftto, q_shiftingdate, routepoint1, routepoint2,
			q_shiftingtime;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quotation frame = new Quotation();
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
	public Quotation() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Quotation.class.getResource("/packersandmovers/logo1.jpg")));
		setResizable(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 1000, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		panel.add(scrollPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 248, 220));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		panel_2.setBounds(22, 0, 929, 130);
		panel_1.add(panel_2);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Quotation.class
				.getResource("/packersandmovers/logo1.jpg")));
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
		label.setBounds(10, 0, 92, 130);
		panel_2.add(label);

		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Quotation.class
				.getResource("/packersandmovers/banner3.jpg")));
		label_10.setBounds(102, 0, 848, 130);
		panel_2.add(label_10);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 248, 220));
		panel_4.setLayout(null);
		panel_4.setBounds(183, 164, 768, 488);
		panel_1.add(panel_4);

		JLabel label_6 = new JLabel("Quotation");
		label_6.setFont(new Font("Century Gothic", Font.BOLD, 25));
		label_6.setBounds(299, 11, 135, 45);
		panel_4.add(label_6);

		JLabel label_7 = new JLabel("First Name");
		label_7.setBounds(10, 137, 105, 14);
		panel_4.add(label_7);

		JLabel label_8 = new JLabel("Last Name");
		label_8.setBounds(385, 137, 105, 14);
		panel_4.add(label_8);

		JLabel label_9 = new JLabel("Address");
		label_9.setBounds(10, 180, 105, 14);
		panel_4.add(label_9);

		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(385, 180, 105, 14);
		panel_4.add(lblContact);

		JLabel label_11 = new JLabel("Email Id");
		label_11.setBounds(385, 96, 105, 14);
		panel_4.add(label_11);

		JLabel lblClientId = new JLabel("Customer Id");
		lblClientId.setBounds(10, 96, 105, 14);
		panel_4.add(lblClientId);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(125, 175, 175, 70);
		panel_4.add(scrollPane_1);
		
		final JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setBackground(new Color(255, 248, 220));
				
				JScrollPane scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(125, 266, 175, 70);
				panel_4.add(scrollPane_2);
		
				
				final JTextArea textArea1 = new JTextArea();
				scrollPane_2.setViewportView(textArea1);
				textArea1.setBackground(new Color(255, 248, 220));
				
				JScrollPane scrollPane_3 = new JScrollPane();
				scrollPane_3.setBounds(531, 266, 175, 70);
				panel_4.add(scrollPane_3);
				
				final JTextArea textArea2 = new JTextArea();
				scrollPane_3.setViewportView(textArea2);
				textArea2.setBackground(new Color(255, 248, 220));
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ArrayList list0=new Login().myItems0();
		        customerid=(String)list0.get(0);
		        System.out.println(customerid);
		        textField_7.setText(customerid);
		        textField_3.setText(customerid);
		        try {
					 Class.forName("oracle.jdbc.OracleDriver");
					 Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
					 Statement st= con.createStatement();
					 String q="Select * from client where customerid='"+customerid+"'";
					 ResultSet rs= st.executeQuery(q);
					 if(rs.next())
					 {
					 customerid=rs.getString(1);
					 System.out.println(customerid);
					 c_firstname=rs.getString(2);
					 System.out.println(c_firstname);
					 c_lastname=rs.getString(3);
					 System.out.println(c_lastname);
					 c_address=rs.getString(4);
					 System.out.println(c_address);
					 c_contact=rs.getString(5);
					 System.out.println(c_contact);
					 c_emailid=rs.getString(6);
					 System.out.println(c_emailid);
					 textField_3.setText(customerid);
					 textField_4.setText(c_emailid);
					 textField.setText(c_firstname);
					 textField_1.setText(c_lastname);
					 textArea.setText(c_address);
					 textField_2.setText(c_contact);
					 }
		        }
		        catch(Exception ex)
		        {
		        	ex.printStackTrace();
		        }
			}
		});
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setBounds(125, 412, 48, 23);
		panel_4.add(comboBox);
		
		final JComboBox comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox1.setBounds(170, 412, 94, 23);
		panel_4.add(comboBox1);
		
		final JComboBox comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"2013", "2014", "2015", "2016", "2017"}));
		comboBox2.setBounds(261, 412, 61, 23);
		panel_4.add(comboBox2);
		
		final JComboBox comboBox3 = new JComboBox();
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox3.setBounds(529, 412, 48, 23);
		panel_4.add(comboBox3);
		
		final JComboBox comboBox4 = new JComboBox();
		comboBox4.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBox4.setBounds(575, 412, 61, 23);
		panel_4.add(comboBox4);
		
		final JComboBox comboBox5 = new JComboBox();
		comboBox5.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		comboBox5.setBounds(636, 412, 56, 23);
		panel_4.add(comboBox5);
		
		final JComboBox comboBox6 = new JComboBox();
		comboBox6.setModel(new DefaultComboBoxModel(new String[] {"Select start point", "hell", "heaven", "palasia", "rajwada", "racecourse road", "vijaynagar", "airport"}));
		comboBox6.setBounds(125, 358, 177, 23);
		panel_4.add(comboBox6);
		
		final JComboBox comboBox7 = new JComboBox();
		comboBox7.setModel(new DefaultComboBoxModel(new String[] {"Select end point", "hell", "heaven", "palasia", "rajwada", "racecourse road", "vijaynagar", "airport"}));
		comboBox7.setBounds(531, 358, 177, 23);
		panel_4.add(comboBox7);
		
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
//					customerid = textField_3.getText();
//					System.out.println(customerid);
//					c_emailid = textField_4.getText();
//					System.out.println(c_emailid);
//					c_firstname = textField.getText();
//					System.out.println(c_firstname);
//					c_lastname = textField_1.getText();
//					System.out.println(c_lastname);
//					c_address =textArea.getText();
//					System.out.println(c_address);
//					c_contact = textField_2.getText();
//					System.out.println(c_contact);
					q_shiftfrom=textArea1.getText();
//					System.out.println(q_shiftfrom);
					q_shiftto=textArea2.getText();
//					System.out.println(q_shiftto);
					routepoint1=(String) comboBox6.getSelectedItem();
//					System.out.println(routepoint1);
					routepoint2=(String) comboBox7.getSelectedItem();
//					System.out.println(routepoint2);
					String date = (String) comboBox.getSelectedItem();
					String month = (String) comboBox1.getSelectedItem();
					String year = (String) comboBox2.getSelectedItem();
					String hour = (String) comboBox3.getSelectedItem();
					String min = (String) comboBox4.getSelectedItem();
					String meridian = (String) comboBox5.getSelectedItem();
					q_shiftingdate = date + "/" + month + "/" + year;
					q_shiftingtime = hour + ":" + min + " " + meridian;
//					System.out.println(q_shiftingdate);
//					System.out.println(q_shiftingtime);
//					System.out.println(year);
//					System.out.println(hour);
//					System.out.println(min);
//					System.out.println(meridian);
					// System.out.println(q_shiftingdate+" "+q_shiftingtime);
					 if(c_firstname.equals("") ||
					 c_lastname.equals("") || c_address.equals("") ||
					 c_contact.equals("") || c_emailid.equals("") ||
					 q_shiftfrom.equals("") || q_shiftto.equals("") || routepoint1.equals("") || routepoint2.equals("") ||
					 q_shiftingdate.equals("") || q_shiftingtime.equals(""))
					 {
					 JOptionPane.showMessageDialog(null,"one or more fields are empty");
					 }
					 else
					 {
					new Quotation1().setVisible(true);
					dispose();
					 }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNext.setBounds(212, 457, 89, 23);
		panel_4.add(btnNext);

		// public ArrayList myItems()
		// {
		//
		// }

		JButton button_1 = new JButton("Reset");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				textField_3.setText("");
				textField_4.setText("");
				textField.setText("");
				textField_1.setText("");
				textArea.setText("");
				textField_2.setText("");
				textArea1.setText("");
				textArea2.setText("");
				comboBox6.setSelectedIndex(0);
				comboBox7.setSelectedIndex(0);
				comboBox.setSelectedIndex(0);
				comboBox1.setSelectedIndex(0);
				comboBox2.setSelectedIndex(0);
				comboBox3.setSelectedIndex(0);
				comboBox4.setSelectedIndex(0);
				comboBox5.setSelectedIndex(0);
			}
		});
		button_1.setBounds(487, 457, 89, 23);
		panel_4.add(button_1);

		textField = new JTextField();
		textField.setBackground(new Color(255, 248, 220));
		textField.setColumns(10);
		textField.setBounds(125, 134, 177, 28);
		panel_4.add(textField);

		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 248, 220));
		textField_1.setColumns(10);
		textField_1.setBounds(531, 134, 177, 28);
		panel_4.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 248, 220));
		textField_2.setColumns(10);
		textField_2.setBounds(531, 177, 177, 28);
		panel_4.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 248, 220));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(125, 93, 179, 28);
		panel_4.add(textField_3);

		JLabel label_13 = new JLabel("Shift From");
		label_13.setBounds(10, 271, 70, 14);
		panel_4.add(label_13);

		JLabel label_14 = new JLabel("Shift To");
		label_14.setBounds(385, 271, 46, 14);
		panel_4.add(label_14);

		JLabel label_15 = new JLabel("Shifting Date");
		label_15.setBounds(10, 415, 87, 14);
		panel_4.add(label_15);

		JLabel label_16 = new JLabel("Shifting Time");
		label_16.setBounds(385, 415, 87, 14);
		panel_4.add(label_16);

		textField_4 = new JTextField();
		textField_4.setBackground(new Color(255, 248, 220));
		textField_4.setBounds(531, 93, 177, 28);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("route start point");
		lblNewLabel.setBounds(10, 361, 105, 14);
		panel_4.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("route end point");
		lblNewLabel_1.setBounds(385, 361, 105, 14);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(106, 90, 205));
		panel_8.setBounds(18, 46, 684, 4);
		panel_4.add(panel_8);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 248, 220));
		panel_5.setBounds(22, 164, 162, 478);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_4 = new JLabel("Customer Id:");
		label_4.setBounds(0, 30, 78, 20);
		panel_5.add(label_4);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(255, 248, 220));
		textField_7.setOpaque(false);
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBounds(57, 31, 116, 20);
		panel_5.add(textField_7);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(47, 79, 79));
		panel_3.setBounds(22, 130, 929, 25);
		panel_1.add(panel_3);

		JLabel lblUpdateProfile = new JLabel("Update Profile");
		lblUpdateProfile.setForeground(new Color(255, 255, 255));
		lblUpdateProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Update().setVisible(true);
				dispose();
			}
		});
		lblUpdateProfile.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblUpdateProfile.setBounds(136, 0, 116, 28);
		panel_3.add(lblUpdateProfile);

		JLabel label_2 = new JLabel("Give Requirements/Generate Quotation");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_2.setBounds(328, 0, 315, 29);
		panel_3.add(label_2);

		JLabel label_3 = new JLabel("Feedback");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Feedback().setVisible(true);
				dispose();
			}
		});
		label_3.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_3.setBounds(702, 0, 86, 28);
		panel_3.add(label_3);

		JLabel label_5 = new JLabel("Logout");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int n=JOptionPane.showConfirmDialog(null, "Do you want to Logout?", "Logout", JOptionPane.YES_NO_OPTION);
				if(n==0)
				{
					new Login().setVisible(true);
					dispose();
				}
			}
		});
		label_5.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_5.setBounds(872, 0, 57, 28);
		panel_3.add(label_5);

		JLabel label_1 = new JLabel("Home");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ClientHome().setVisible(true);
				dispose();
			}
		});
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_1.setBounds(10, 0, 86, 28);
		panel_3.add(label_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(183, 154, 768, 10);
		panel_1.add(panel_7);
		panel_7.setBackground(new Color(240, 230, 140));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(22, 154, 174, 10);
		panel_1.add(panel_6);
		panel_6.setBackground(new Color(240, 230, 140));
		
		JLabel label_12 = new JLabel("Copyright \u00A9 2013 Packers & Movers Ltd. All Rights Reserved");
		label_12.setBounds(32, 656, 371, 14);
		panel_1.add(label_12);
		
		JLabel label_17 = new JLabel("T & C Apply*");
		label_17.setBounds(846, 656, 74, 14);
		panel_1.add(label_17);
	}

	public ArrayList myItems() {
		ArrayList list = new ArrayList();
        list.add(customerid);
        list.add(c_emailid);
        list.add(c_firstname);
        list.add(c_lastname);
        list.add(c_address);
        list.add(c_contact);
        list.add(q_shiftfrom);
        list.add(q_shiftto);
        list.add(routepoint1);
        list.add(routepoint2);
        list.add(q_shiftingdate);
        list.add(q_shiftingtime);
        System.out.println(list);
		return list;
	}
}
