package packersandmovers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;


public class Feedback extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	static String customerid, feedbackid, fname, lname, address, contact, emailid, services, behaviour, overall, comments;
	static String quotationid, c_emailid, c_firstname, c_lastname, c_address, c_contact, q_shiftfrom, q_shiftto, q_shiftingdate, q_shiftingtime, routepoint1, routepoint2;

	static int num;
	static StringBuilder finalstring;
	public  String tempfeed;
	static String final_string,final_string1,final_string3_emp;
	public StringBuilder string;
	public StringBuilder tempfeed3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	
	public void FeedbackIdGenerator() {
		System.out.println(tempfeed+tempfeed3+final_string1);
			try {
				Class.forName("oracle.jdbc.OracleDriver");

				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");

				Statement st = con.createStatement();
				String temp = "SELECT feedbackid FROM feedback where ROWNUM<=1 order by feedbackid desc";
				ResultSet rs = st.executeQuery(temp);
				while (rs.next()) {
					String feed = rs.getString(1);
					System.out.println(feed);
					String tempfeed1 = feed.substring(0, 4);
					StringBuilder tempfeed3=new StringBuilder(tempfeed1);
					tempfeed = feed.substring(4, 10);
					
					String tempfeed2 = String.valueOf(Integer.parseInt(tempfeed) + 1);
					int i=tempfeed2.length();
					System.out.println(i);
					if(i==1)
					{
						StringBuilder string=new StringBuilder("00000");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);	
						final_string1=tempfeed3.toString();
						
					}
					if(i==2)
					{
						StringBuilder string=new StringBuilder("0000");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);
						final_string1=tempfeed3.toString();
						
					}
					if(i==3)
					{
						StringBuilder string=new StringBuilder("000");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);
						final_string1=tempfeed3.toString();
						
					}
					if(i==4)
					{
						StringBuilder string=new StringBuilder("00");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);
						final_string1=tempfeed3.toString();
						
					}
					if(i==5)
					{
						StringBuilder string=new StringBuilder("0");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);
						final_string1=tempfeed3.toString();
						
					}
					
					if(i==6)
					{
						StringBuilder string=new StringBuilder("");
						string.append(tempfeed2);
						tempfeed3.append(string);
						System.out.println(tempfeed3);
						final_string1=tempfeed3.toString();
						
					}
				
				}
				con.close();
				feedbackid= final_string1;
			} catch (Exception e) {
				e.printStackTrace();
			}
//			System.out.println(customerid);
//			return final_string1;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedback frame = new Feedback();
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
	public Feedback() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Feedback.class.getResource("/packersandmovers/logo1.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 1000, 730);
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
		panel_1.setBackground(new Color(255, 248, 220));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(20, 0, 931, 130);
		panel_1.add(panel_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Feedback.class.getResource("/packersandmovers/logo1.jpg")));
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
		label.setBounds(10, 0, 92, 130);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Feedback.class.getResource("/packersandmovers/banner3.jpg")));
		label_1.setBounds(102, 0, 870, 130);
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(47, 79, 79));
		panel_3.setBounds(20, 130, 931, 25);
		panel_1.add(panel_3);
		
		JLabel label_2 = new JLabel("Update Profile");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Update().setVisible(true);
				dispose();
			}
		});
		label_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_2.setBounds(136, 0, 116, 28);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("Give Requirements/Generate Quotation");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Quotation().setVisible(true);
				dispose();
			}
		});
		label_3.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_3.setBounds(328, 0, 315, 29);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("Feedback");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_4.setBounds(703, 0, 86, 28);
		panel_3.add(label_4);
		
		JLabel label_6 = new JLabel("Logout");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.addMouseListener(new MouseAdapter() {
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
		label_6.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_6.setBounds(874, 0, 57, 28);
		panel_3.add(label_6);
		
		JLabel label_7 = new JLabel("Home");
		label_7.setForeground(new Color(255, 255, 255));
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ClientHome().setVisible(true);
				dispose();
			}
		});
		label_7.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_7.setBounds(10, 0, 86, 28);
		panel_3.add(label_7);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 248, 220));
		panel_4.setBounds(20, 164, 164, 459);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_5 = new JLabel("Customer Id:");
		label_5.setBounds(0, 29, 77, 20);
		panel_4.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(255, 248, 220));
		textField_6.setOpaque(false);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBounds(58, 30, 116, 20);
		panel_4.add(textField_6);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 248, 220));
		panel_5.setLayout(null);
		panel_5.setBounds(183, 164, 768, 459);
		panel_1.add(panel_5);
		
		JLabel lblFeedback = new JLabel("Feedback");
		lblFeedback.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblFeedback.setBounds(298, 11, 135, 45);
		panel_5.add(lblFeedback);
		
		JLabel label_9 = new JLabel("First Name");
		label_9.setBounds(10, 136, 105, 14);
		panel_5.add(label_9);
		
		JLabel label_10 = new JLabel("Last Name");
		label_10.setBounds(385, 136, 105, 14);
		panel_5.add(label_10);
		
		JLabel label_11 = new JLabel("Address");
		label_11.setBounds(10, 181, 105, 14);
		panel_5.add(label_11);
		
		JLabel label_12 = new JLabel("Contact");
		label_12.setBounds(385, 181, 105, 14);
		panel_5.add(label_12);
		
		JLabel lblCustomerId = new JLabel("Customer Id");
		lblCustomerId.setBounds(385, 96, 105, 14);
		panel_5.add(lblCustomerId);
		
		JLabel lblFeedbackId = new JLabel("Feedback Id");
		lblFeedbackId.setBounds(10, 96, 105, 14);
		panel_5.add(lblFeedbackId);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(125, 373, 175, 65);
		panel_5.add(scrollPane_1);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 248, 220));
		scrollPane_1.setViewportView(textArea_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(125, 176, 178, 67);
		panel_5.add(scrollPane_2);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 248, 220));
		scrollPane_2.setViewportView(textArea);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ArrayList list0=new Login().myItems0();
		        customerid=(String)list0.get(0);
		        System.out.println(customerid);
		        textField_6.setText(customerid);
		        FeedbackIdGenerator();
				textField_3.setText(feedbackid);
				textField_4.setText(customerid);
				
				ArrayList list=new Quotation().myItems();
		        c_emailid=(String)list.get(1);
		        c_firstname=(String)list.get(2);
		        c_lastname=(String)list.get(3);
		        c_address=(String)list.get(4);
		        c_contact=(String)list.get(5);
		        textField.setText(c_firstname);
		        textField_1.setText(c_lastname);
		        textArea.setText(c_address);
		        textField_2.setText(c_contact);
		        textField_5.setText(c_emailid);
			}
		});
		
		
		final JRadioButton spoor = new JRadioButton("Poor");
		spoor.setBackground(new Color(255, 248, 220));
		buttonGroup.add(spoor);
		spoor.setBounds(125, 263, 109, 23);
		panel_5.add(spoor);
		
		final JRadioButton sgood = new JRadioButton("Good");
		sgood.setBackground(new Color(255, 248, 220));
		buttonGroup.add(sgood);
		sgood.setBounds(250, 263, 109, 23);
		panel_5.add(sgood);
		
		final JRadioButton svgood = new JRadioButton("Very Good");
		svgood.setBackground(new Color(255, 248, 220));
		buttonGroup.add(svgood);
		svgood.setBounds(381, 263, 109, 23);
		panel_5.add(svgood);
		
		final JRadioButton sexcel = new JRadioButton("Excellent");
		sexcel.setBackground(new Color(255, 248, 220));
		buttonGroup.add(sexcel);
		sexcel.setBounds(515, 263, 109, 23);
		panel_5.add(sexcel);
		
		final JRadioButton bpoor = new JRadioButton("Poor");
		bpoor.setBackground(new Color(255, 248, 220));
		buttonGroup_1.add(bpoor);
		bpoor.setBounds(125, 299, 109, 23);
		panel_5.add(bpoor);
		
		final JRadioButton bgood = new JRadioButton("Good");
		bgood.setBackground(new Color(255, 248, 220));
		buttonGroup_1.add(bgood);
		bgood.setBounds(250, 299, 109, 23);
		panel_5.add(bgood);
		
		final JRadioButton bvgood = new JRadioButton("Very Good");
		bvgood.setBackground(new Color(255, 248, 220));
		buttonGroup_1.add(bvgood);
		bvgood.setBounds(381, 299, 109, 23);
		panel_5.add(bvgood);
		
		final JRadioButton bexcel = new JRadioButton("Excellent");
		bexcel.setBackground(new Color(255, 248, 220));
		buttonGroup_1.add(bexcel);
		bexcel.setBounds(515, 299, 109, 23);
		panel_5.add(bexcel);
		
		final JRadioButton opoor = new JRadioButton("Poor");
		opoor.setBackground(new Color(255, 248, 220));
		buttonGroup_2.add(opoor);
		opoor.setBounds(125, 332, 109, 23);
		panel_5.add(opoor);
		
		final JRadioButton ogood = new JRadioButton("Good");
		ogood.setBackground(new Color(255, 248, 220));
		buttonGroup_2.add(ogood);
		ogood.setBounds(250, 332, 109, 23);
		panel_5.add(ogood);
		
		final JRadioButton ovgood = new JRadioButton("Very Good");
		ovgood.setBackground(new Color(255, 248, 220));
		buttonGroup_2.add(ovgood);
		ovgood.setBounds(381, 332, 109, 23);
		panel_5.add(ovgood);
		
		final JRadioButton oexcel = new JRadioButton("Excellent");
		oexcel.setBackground(new Color(255, 248, 220));
		buttonGroup_2.add(oexcel);
		oexcel.setBounds(515, 332, 109, 23);
		panel_5.add(oexcel);
	
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fname=textField.getText();
				System.out.println(fname);
				lname=textField_1.getText();
				System.out.println(lname);
				comments=textArea_1.getText();
				System.out.println(comments);
				address=textArea.getText();
				contact=textField_2.getText();
				emailid=textField_5.getText();
				if(spoor.isSelected())
				{
				    services="Poor";
				}
				if(sgood.isSelected())
				{
				    services="Good";
				}
				if(svgood.isSelected())
				{
				    services="Very Good";
				}
				if(sexcel.isSelected())
				{
				    services="Excellent";
				}
				System.out.println(services);
				if(bpoor.isSelected())
				{
				    behaviour="Poor";
				}
				if(bgood.isSelected())
				{
					behaviour="Good";
				}
				if(bvgood.isSelected())
				{
					behaviour="Very Good";
				}
				if(bexcel.isSelected())
				{
					behaviour="Excellent";
				}
				System.out.println(services);
				if(opoor.isSelected())
				{
				    overall="Poor";
				}
				if(ogood.isSelected())
				{
					overall="Good";
				}
				if(ovgood.isSelected())
				{
					overall="Very Good";
				}
				if(oexcel.isSelected())
				{
					overall="Excellent";
				}
				System.out.println(overall);
				if(fname.equals("") || lname.equals("") || address.equals("") || contact.equals("") || emailid.equals("") || services.equals("") || behaviour.equals("") || overall.equals("") || comments.equals(""))
				{
					JOptionPane.showMessageDialog(null, "one or more fields are empty");
				}
				else
				{
					try
					{
					Class.forName("oracle.jdbc.OracleDriver");
		            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
					PreparedStatement ps=con.prepareStatement("insert into feedback values(?,?,?,?,?,?,?,?)");
		            ps.setString(1, feedbackid);
//		            System.out.println(customerid);
		            ps.setString(2, fname);
		            ps.setString(3, lname);
		            ps.setString(4, services);
		            ps.setString(5, behaviour);
		            ps.setString(6, overall);
		            ps.setString(7, comments);
		            ps.setString(8, customerid);
		            ps.executeUpdate();
		            con.close();
		            JOptionPane.showMessageDialog(null, "Feedback Submitted!");
		            JOptionPane.showMessageDialog(null, "Thank You for your Feedback.");
		            textField.setText("");
					textField_1.setText("");
					textArea_1.setText("");
					textArea.setText("");
					textField_2.setText("");
					textField_5.setText("");
					buttonGroup.clearSelection();
					buttonGroup_1.clearSelection();
					buttonGroup_2.clearSelection();
					new ClientHome().setVisible(true);
					dispose();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		btnSubmit.setBounds(418, 393, 89, 23);
		panel_5.add(btnSubmit);
		
		JButton button_1 = new JButton("Reset");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textArea_1.setText("");
				textArea.setText("");
				textField_2.setText("");
				textField_5.setText("");
				buttonGroup.clearSelection();
				buttonGroup_1.clearSelection();
				buttonGroup_2.clearSelection();
			}
		});
		button_1.setBounds(586, 393, 89, 23);
		panel_5.add(button_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 248, 220));
		textField.setColumns(10);
		textField.setBounds(125, 133, 177, 27);
		panel_5.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 248, 220));
		textField_1.setColumns(10);
		textField_1.setBounds(531, 133, 177, 27);
		panel_5.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 248, 220));
		textField_2.setColumns(10);
		textField_2.setBounds(531, 178, 177, 27);
		panel_5.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_3.setBackground(new Color(255, 248, 220));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(125, 93, 179, 27);
		panel_5.add(textField_3);
		
		JLabel lblServices = new JLabel("Services");
		lblServices.setBounds(10, 272, 70, 14);
		panel_5.add(lblServices);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setBounds(10, 378, 87, 14);
		panel_5.add(lblComments);
		
		JLabel lblBehaviour = new JLabel("Behaviour");
		lblBehaviour.setBounds(10, 308, 87, 14);
		panel_5.add(lblBehaviour);
		
		JLabel lblOverall = new JLabel("Overall");
		lblOverall.setBounds(10, 341, 87, 14);
		panel_5.add(lblOverall);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_4.setBackground(new Color(255, 248, 220));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(531, 93, 177, 27);
		panel_5.add(textField_4);
		
		JLabel lblNewLabel = new JLabel("Email Id");
		lblNewLabel.setBounds(385, 229, 46, 14);
		panel_5.add(lblNewLabel);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(255, 248, 220));
		textField_5.setBounds(531, 223, 177, 27);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(106, 90, 205));
		panel_8.setBounds(24, 46, 684, 4);
		panel_5.add(panel_8);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(183, 155, 768, 10);
		panel_1.add(panel_7);
		panel_7.setBackground(new Color(240, 230, 140));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(20, 155, 174, 10);
		panel_1.add(panel_6);
		panel_6.setBackground(new Color(240, 230, 140));
		
		JLabel label_8 = new JLabel("Copyright \u00A9 2013 Packers & Movers Ltd. All Rights Reserved");
		label_8.setBounds(39, 656, 370, 14);
		panel_1.add(label_8);
		
		JLabel label_13 = new JLabel("T & C Apply*");
		label_13.setBounds(853, 656, 74, 14);
		panel_1.add(label_13);
		
		}
}
