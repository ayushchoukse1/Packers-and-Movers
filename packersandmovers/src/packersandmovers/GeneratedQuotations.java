package packersandmovers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class GeneratedQuotations extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_17;
	private JTextField textField_19;
	private JTextField textField_20;

	static String qid, quotationid, customerid, c_emailid, c_firstname, c_lastname, c_address, c_contact, q_shiftfrom, q_shiftto, q_shiftingdate, q_shiftingtime, routepoint1, routepoint2;
	static int  q_light, q_heavy, q_medium, length, priceheavy, pricemedium, pricelight;
	static float costheavy, costmedium, costlight, q_total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneratedQuotations frame = new GeneratedQuotations();
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
	public GeneratedQuotations() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GeneratedQuotations.class.getResource("/packersandmovers/logo1.jpg")));
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 248, 220));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 295, 175, 59);
		panel.add(scrollPane);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 248, 220));
		scrollPane.setViewportView(textArea_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(468, 295, 175, 62);
		panel.add(scrollPane_1);
		
		final JTextArea textArea_2 = new JTextArea();
		textArea_2.setBackground(new Color(255, 248, 220));
		scrollPane_1.setViewportView(textArea_2);
//		"+customerid+"
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ArrayList lt=new ClientHome().items();
				qid=(String)lt.get(0);
				try
				{
					Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "palash");
				Statement st=con.createStatement();
//				String q0="SELECT count(quotationid) from QUOTATION where CUSTOMERID='"+customerid+"'";
//				System.out.println(q0);
				String q="Select * from quotation where quotationid='"+qid+"'";
				ResultSet rs=st.executeQuery(q);
				if(rs.next())
				{
					quotationid=rs.getString(1);
//					System.out.println(quotationid);
					customerid=rs.getString(2);
					c_firstname=rs.getString(3);
					c_lastname=rs.getString(4);
					c_contact=rs.getString(5);
					q_shiftfrom=rs.getString(6);
					q_shiftto=rs.getString(7);
					q_shiftingtime=rs.getString(8);
					q_shiftingdate=rs.getString(9);
					q_light=rs.getInt(10);
					q_medium=rs.getInt(11);
					q_heavy=rs.getInt(12);
					q_total=rs.getFloat(13);
				}
				con.close();
				textField_13.setText(customerid);
				textField_14.setText(quotationid);
				textField.setText(c_firstname);
				textField_1.setText(c_lastname);
				textField_2.setText(c_contact);
				textField_4.setText(String.valueOf(q_heavy));
				textField_5.setText(String.valueOf(q_medium));
				textField_6.setText(String.valueOf(q_light));
				textArea_1.setText(q_shiftfrom);
				textArea_2.setText(q_shiftto);
				textField_19.setText(q_shiftingtime);
				textField_20.setText(q_shiftingdate);
				textField_17.setText(String.valueOf(q_total));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
//				new GeneratedQuotations().setVisible(true);
//				dispose();
			
				}
		});
		
		JLabel label = new JLabel("Quotation");
		label.setFont(new Font("Century Gothic", Font.BOLD, 25));
		label.setBounds(337, 11, 135, 45);
		panel.add(label);
		
		JLabel label_1 = new JLabel("First Name");
		label_1.setBounds(10, 128, 105, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Last Name");
		label_2.setBounds(10, 182, 105, 14);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("Contact Number");
		label_4.setBounds(10, 239, 105, 14);
		panel.add(label_4);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ClientHome().setVisible(true);
				dispose();
			}
		});
		button_1.setBounds(337, 568, 89, 23);
		panel.add(button_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(255, 248, 220));
		textField.setBounds(125, 125, 177, 28);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 248, 220));
		textField_1.setBounds(125, 179, 177, 28);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(255, 248, 220));
		textField_2.setBounds(125, 236, 177, 28);
		panel.add(textField_2);
		
		JLabel label_6 = new JLabel("Shift From");
		label_6.setBounds(10, 300, 70, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Shift To");
		label_7.setBounds(358, 300, 46, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Shifting Date");
		label_8.setBounds(10, 387, 87, 14);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("Shifting Time");
		label_9.setBounds(358, 384, 87, 14);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("Large Goods");
		label_10.setBounds(358, 127, 87, 14);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("Quantity");
		label_11.setBounds(471, 100, 71, 14);
		panel.add(label_11);
		
		JLabel label_14 = new JLabel("Medium Goods");
		label_14.setBounds(358, 182, 87, 14);
		panel.add(label_14);
		
		JLabel label_15 = new JLabel("Small Goods");
		label_15.setBounds(358, 239, 87, 14);
		panel.add(label_15);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(255, 248, 220));
		textField_4.setBounds(471, 127, 46, 28);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(255, 248, 220));
		textField_5.setBounds(471, 179, 46, 28);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(255, 248, 220));
		textField_6.setBounds(471, 236, 46, 28);
		panel.add(textField_6);
		
		JLabel label_16 = new JLabel("Customer Id");
		label_16.setBounds(10, 67, 87, 14);
		panel.add(label_16);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBackground(new Color(255, 248, 220));
		textField_13.setBounds(125, 64, 177, 28);
		panel.add(textField_13);
		
		JLabel label_17 = new JLabel("Quotation Id");
		label_17.setBounds(358, 67, 87, 14);
		panel.add(label_17);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBackground(new Color(255, 248, 220));
		textField_14.setBounds(463, 64, 177, 28);
		panel.add(textField_14);
		
		JLabel label_20 = new JLabel("Total Cost");
		label_20.setBounds(358, 473, 86, 14);
		panel.add(label_20);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		textField_17.setBackground(new Color(255, 248, 220));
		textField_17.setBounds(471, 461, 169, 54);
		panel.add(textField_17);
		
		textField_19 = new JTextField();
		textField_19.setEditable(false);
		textField_19.setColumns(10);
		textField_19.setBackground(new Color(255, 248, 220));
		textField_19.setBounds(125, 384, 177, 28);
		panel.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		textField_20.setBackground(new Color(255, 248, 220));
		textField_20.setBounds(471, 384, 177, 28);
		panel.add(textField_20);
		
		
		}

}
