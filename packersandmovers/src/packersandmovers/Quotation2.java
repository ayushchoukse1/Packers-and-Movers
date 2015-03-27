package packersandmovers;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;


public class Quotation2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
//	private JTextArea textArea;
//	private JTextArea textArea_1;
//	private JTextArea textArea_2;
	
	static String quotationid, customerid, c_emailid, c_firstname, c_lastname, c_address, c_contact, q_shiftfrom, q_shiftto, q_shiftingdate, q_shiftingtime, routepoint1, routepoint2;
	static int  q_light, q_heavy, q_medium, length, priceheavy, pricemedium, pricelight;
	static float costheavy, costmedium, costlight, q_total;
	
	static int num;
	static StringBuilder finalstring;
	public  String tempfeed;
	static String final_string,final_string1,final_string3_emp;
	public StringBuilder string;
	public StringBuilder tempfeed3;

	/**
	 * Launch the application.
	 */
	
	public void QuotationIdGenerator() {
		System.out.println(tempfeed+tempfeed3+final_string1);
			try {
				Class.forName("oracle.jdbc.OracleDriver");

				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");

				Statement st = con.createStatement();
				String temp = "SELECT quotationid FROM quotation where ROWNUM<=1 order by quotationid desc";
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
				quotationid= final_string1;
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
					Quotation2 frame = new Quotation2();
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
	public Quotation2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Quotation2.class.getResource("/packersandmovers/logo1.jpg")));
		setResizable(false);
		QuotationIdGenerator();
		
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
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(20, 0, 931, 130);
		panel_2.setLayout(null);
		panel_1.add(panel_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Quotation2.class.getResource("/packersandmovers/logo1.jpg")));
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
		label.setBounds(10, 0, 92, 130);
		panel_2.add(label);
		
		JLabel label_17 = new JLabel("");
		label_17.setIcon(new ImageIcon(Quotation2.class.getResource("/packersandmovers/banner3.jpg")));
		label_17.setBounds(102, 0, 870, 130);
		panel_2.add(label_17);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(20, 130, 931, 25);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(47, 79, 79));
		panel_1.add(panel_3);
		
		JLabel label_1 = new JLabel("Update Profile");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Update().setVisible(true);
				dispose();
			}
		});
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_1.setBounds(136, 0, 116, 28);
		panel_3.add(label_1);
		
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
		label_3.setBounds(705, 0, 86, 28);
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
		label_5.setBounds(874, 0, 57, 28);
		panel_3.add(label_5);
		
		JLabel label_12 = new JLabel("Home");
		label_12.setForeground(new Color(255, 255, 255));
		label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ClientHome().setVisible(true);
				dispose();
			}
		});
		label_12.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_12.setBounds(10, 0, 86, 28);
		panel_3.add(label_12);
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(183, 155, 768, 10);
		panel_1.add(panel_7);
		panel_7.setBackground(new Color(240, 230, 140));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(20, 155, 174, 10);
		panel_1.add(panel_6);
		panel_6.setBackground(new Color(240, 230, 140));
		
		JLabel label_18 = new JLabel("Copyright \u00A9 2013 Packers & Movers Ltd. All Rights Reserved");
		label_18.setBounds(30, 656, 374, 14);
		panel_1.add(label_18);
		
		JLabel label_19 = new JLabel("T & C Apply*");
		label_19.setBounds(844, 656, 74, 14);
		panel_1.add(label_19);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 248, 220));
		panel_5.setLayout(null);
		panel_5.setBounds(183, 165, 768, 504);
		panel_1.add(panel_5);
		
		JLabel label_6 = new JLabel("Quotation");
		label_6.setFont(new Font("Century Gothic", Font.BOLD, 25));
		label_6.setBounds(298, 11, 135, 45);
		panel_5.add(label_6);
		
		JLabel label_7 = new JLabel("First Name");
		label_7.setBounds(10, 128, 105, 14);
		panel_5.add(label_7);
		
		JLabel label_8 = new JLabel("Last Name");
		label_8.setBounds(10, 159, 105, 14);
		panel_5.add(label_8);
		
		JLabel label_9 = new JLabel("Address");
		label_9.setBounds(10, 192, 105, 14);
		panel_5.add(label_9);
		
		JLabel label_10 = new JLabel("Contact Number");
		label_10.setBounds(10, 271, 105, 14);
		panel_5.add(label_10);
		
		JLabel label_11 = new JLabel("Email Id");
		label_11.setBounds(10, 310, 105, 14);
		panel_5.add(label_11);
		
		JButton btnPrintQuotation = new JButton("Print Quotation");
		btnPrintQuotation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PrintQuotation().setVisible(true);
				dispose();
			}
		});
		btnPrintQuotation.setBounds(323, 470, 152, 23);
		panel_5.add(btnPrintQuotation);
		
		JButton btnModifyQuotation = new JButton("Modify Quotation");
		btnModifyQuotation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Quotation1().setVisible(true);
				dispose();
			}
		});
		btnModifyQuotation.setBounds(498, 470, 142, 23);
		panel_5.add(btnModifyQuotation);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 248, 220));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(125, 125, 177, 28);
		panel_5.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 248, 220));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(125, 156, 177, 28);
		panel_5.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 248, 220));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(125, 268, 177, 28);
		panel_5.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 248, 220));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(125, 307, 177, 28);
		panel_5.add(textField_3);
		
		JLabel label_13 = new JLabel("Shift From");
		label_13.setBounds(10, 363, 70, 14);
		panel_5.add(label_13);
		
		JLabel label_14 = new JLabel("Shift To");
		label_14.setBounds(358, 360, 46, 14);
		panel_5.add(label_14);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(124, 187, 178, 67);
		panel_5.add(scrollPane_1);
		
		final JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setBackground(new Color(255, 248, 220));
		textArea.setEditable(false);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(125, 358, 178, 61);
		panel_5.add(scrollPane_3);
		
		final JTextArea textArea_1 = new JTextArea();
		scrollPane_3.setViewportView(textArea_1);
		textArea_1.setBackground(new Color(255, 248, 220));
		textArea_1.setEditable(false);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(471, 358, 177, 61);
		panel_5.add(scrollPane_2);
		
		final JTextArea textArea_2 = new JTextArea();
		scrollPane_2.setViewportView(textArea_2);
		textArea_2.setBackground(new Color(255, 248, 220));
		textArea_2.setEditable(false);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ArrayList list0=new Login().myItems0();
		        customerid=(String)list0.get(0);
		        System.out.println(customerid);
		        textField_21.setText(customerid);
//		        textField_13.setText(customerid);
		        
//				QuotationidGenerator();
				
				ArrayList list=new Quotation().myItems();
		        customerid=(String)list.get(0);
		        c_emailid=(String)list.get(1);
		        c_firstname=(String)list.get(2);
		        c_lastname=(String)list.get(3);
		        c_address=(String)list.get(4);
		        c_contact=(String)list.get(5);
		        q_shiftfrom=(String)list.get(6);
		        q_shiftto=(String)list.get(7);
		        routepoint1=(String)list.get(8);
		        routepoint2=(String)list.get(9);
		        q_shiftingdate=(String)list.get(10);
		        q_shiftingtime=(String)list.get(11);
		        textField_13.setText(customerid);
		        textField.setText(c_firstname);
		        textField_1.setText(c_lastname);
		        textArea.setText(c_address);
		        textField_2.setText(c_contact);
		        textField_3.setText(c_emailid);
		        textArea_1.setText(q_shiftfrom);
		        textArea_2.setText(q_shiftto);
		        textField_19.setText(q_shiftingdate);
		        textField_20.setText(q_shiftingtime);
		        
		        ArrayList list1=new Quotation1().myItems1();
//		        String light=(String)list1.get(0);
//		        q_light=Integer.parseInt(light);
		        q_light=(Integer)list1.get(0);
//		        System.out.println(q_light);
		        q_medium=(Integer)list1.get(1);
//		        System.out.println(q_medium);
		        q_heavy=(Integer)list1.get(2);
//		        System.out.println(q_heavy);
				textField_4.setText(String.valueOf(q_heavy));
				textField_5.setText(String.valueOf(q_medium));
				textField_6.setText(String.valueOf(q_light));
				
				textField_14.setText(quotationid);
				System.out.println(routepoint1);
				System.out.println(routepoint2);
				
				try
				{
					Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
				Statement st= con.createStatement();
				
				String q="Select length from routelength where routepoint1='"+routepoint1+"' and routepoint2='"+routepoint2+"'";
//				String q="Select length from routelength where routepoint1='hell' and routepoint2='heaven'";
				ResultSet rs= st.executeQuery(q);
	            if (rs.next())
	            {
	            	length=rs.getInt(1);
	            	System.out.println(length);
	            }
	            textField_15.setText(String.valueOf(length));
				System.out.println(length);
	            
	            String q1="Select price from priceperkm where category='light'";
	            ResultSet rs1= st.executeQuery(q1);
	            if(rs1.next())
	            {
	            	pricelight=rs1.getInt(1);
	            }
				textField_9.setText(String.valueOf(pricelight));
//				System.out.println(pricelight);
				
				String q2="Select price from priceperkm where category='medium'";
	            ResultSet rs2= st.executeQuery(q2);
	            if(rs2.next())
	            {
	            	pricemedium=rs2.getInt(1);
	            }
				textField_8.setText(String.valueOf(pricemedium));
//				System.out.println(pricemedium);
	            
	            String q3="Select price from priceperkm where category='heavy'";
	            ResultSet rs3= st.executeQuery(q3);
	            if(rs3.next())
	            {
	            	priceheavy=rs3.getInt(1);
	            }
	            textField_7.setText(String.valueOf(priceheavy));
//	            System.out.println(priceheavy);
				
	            costheavy= q_heavy*priceheavy*length;
				costmedium= q_medium*pricemedium*length;
				costlight= q_light*pricelight*length;
				textField_10.setText(String.valueOf(costheavy));
				textField_11.setText(String.valueOf(costmedium));
				textField_12.setText(String.valueOf(costlight));
				q_total=costheavy+costmedium+costlight;
				textField_17.setText(String.valueOf(costheavy+costmedium+costlight));
				con.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
		        
		        
			}
		});
		
		
		JLabel label_15 = new JLabel("Shifting Date");
		label_15.setBounds(10, 433, 87, 14);
		panel_5.add(label_15);
		
		JLabel label_16 = new JLabel("Shifting Time");
		label_16.setBounds(358, 433, 87, 14);
		panel_5.add(label_16);
		
		JLabel lblLargeGoods = new JLabel("Heavy Goods");
		lblLargeGoods.setBounds(358, 127, 87, 14);
		panel_5.add(lblLargeGoods);
		
		JLabel lblNewLabel = new JLabel("Quantity");
		lblNewLabel.setBounds(471, 100, 71, 14);
		panel_5.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Price/km");
		lblNewLabel_1.setBounds(552, 100, 91, 14);
		panel_5.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cost");
		lblNewLabel_2.setBounds(653, 100, 63, 14);
		panel_5.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Medium Goods");
		lblNewLabel_3.setBounds(358, 158, 87, 14);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Light Goods");
		lblNewLabel_4.setBounds(358, 189, 87, 14);
		panel_5.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(255, 248, 220));
		textField_4.setEditable(false);
		textField_4.setBounds(471, 127, 46, 28);
		panel_5.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(255, 248, 220));
		textField_5.setEditable(false);
		textField_5.setBounds(471, 158, 46, 28);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(255, 248, 220));
		textField_6.setEditable(false);
		textField_6.setBounds(471, 189, 46, 28);
		panel_5.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(255, 248, 220));
		textField_7.setEditable(false);
		textField_7.setBounds(552, 127, 70, 28);
		panel_5.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBackground(new Color(255, 248, 220));
		textField_8.setEditable(false);
		textField_8.setBounds(552, 158, 70, 28);
		panel_5.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBackground(new Color(255, 248, 220));
		textField_9.setEditable(false);
		textField_9.setBounds(552, 189, 70, 28);
		panel_5.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBackground(new Color(255, 248, 220));
		textField_10.setEditable(false);
		textField_10.setBounds(653, 127, 86, 28);
		panel_5.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBackground(new Color(255, 248, 220));
		textField_11.setEditable(false);
		textField_11.setBounds(653, 158, 86, 28);
		panel_5.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBackground(new Color(255, 248, 220));
		textField_12.setEditable(false);
		textField_12.setBounds(653, 189, 86, 28);
		panel_5.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Customer Id");
		lblNewLabel_5.setBounds(10, 73, 87, 14);
		panel_5.add(lblNewLabel_5);
		
		textField_13 = new JTextField();
		textField_13.setBackground(new Color(255, 248, 220));
		textField_13.setEditable(false);
		textField_13.setBounds(125, 70, 177, 28);
		panel_5.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Quotation Id");
		lblNewLabel_6.setBounds(358, 73, 87, 14);
		panel_5.add(lblNewLabel_6);
		
		textField_14 = new JTextField();
		textField_14.setBackground(new Color(255, 248, 220));
		textField_14.setEditable(false);
		textField_14.setBounds(471, 70, 177, 28);
		panel_5.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Route length(km)");
		lblNewLabel_7.setBounds(358, 223, 103, 14);
		panel_5.add(lblNewLabel_7);
		
		textField_15 = new JTextField();
		textField_15.setBackground(new Color(255, 248, 220));
		textField_15.setEditable(false);
		textField_15.setBounds(471, 220, 86, 28);
		panel_5.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("VAT");
		lblNewLabel_8.setBounds(597, 220, 46, 14);
		panel_5.add(lblNewLabel_8);
		
		textField_16 = new JTextField();
		textField_16.setBackground(new Color(255, 248, 220));
		textField_16.setText("5.25%");
		textField_16.setEditable(false);
		textField_16.setBounds(653, 220, 86, 28);
		panel_5.add(textField_16);
		textField_16.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Total Cost(Rs.)");
		lblNewLabel_9.setBounds(358, 307, 86, 14);
		panel_5.add(lblNewLabel_9);
		
		textField_17 = new JTextField();
		textField_17.setBackground(new Color(255, 248, 220));
		textField_17.setEditable(false);
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField_17.setBounds(531, 284, 169, 54);
		panel_5.add(textField_17);
		textField_17.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Other Charges");
		lblNewLabel_10.setBounds(358, 253, 87, 14);
		panel_5.add(lblNewLabel_10);
		
		textField_18 = new JTextField();
		textField_18.setBackground(new Color(255, 248, 220));
		textField_18.setEditable(false);
		textField_18.setBounds(471, 251, 106, 28);
		panel_5.add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setBackground(new Color(255, 248, 220));
		textField_19.setEditable(false);
		textField_19.setBounds(125, 430, 177, 28);
		panel_5.add(textField_19);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setBackground(new Color(255, 248, 220));
		textField_20.setEditable(false);
		textField_20.setBounds(471, 430, 177, 28);
		panel_5.add(textField_20);
		textField_20.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Save Quotation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
				PreparedStatement ps=con.prepareStatement("insert into quotation values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
	            ps.setString(1, quotationid);
	            ps.setString(2, customerid);
	            ps.setString(3, c_firstname);
	            ps.setString(4, c_lastname);
	            ps.setString(5, c_contact);
	            ps.setString(6, q_shiftfrom);
	            ps.setString(7, q_shiftto);
	            ps.setString(8, q_shiftingdate);
	            ps.setString(9, q_shiftingtime);
	            ps.setInt(10, q_light);
	            ps.setInt(11, q_medium);
	            ps.setInt(12, q_heavy);
	            ps.setFloat(13, q_total);
	            ps.executeUpdate();
	            con.close();
	            JOptionPane.showMessageDialog(null, "Quotation Saved!");
	            new Quotation().setVisible(true);
	            dispose();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(150, 470, 152, 23);
		panel_5.add(btnNewButton);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(106, 90, 205));
		panel_8.setBounds(32, 46, 684, 4);
		panel_5.add(panel_8);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 248, 220));
		panel_4.setBounds(20, 165, 164, 504);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_4 = new JLabel("Customer Id:");
		label_4.setBounds(0, 26, 77, 20);
		panel_4.add(label_4);
		
		textField_21 = new JTextField();
		textField_21.setBackground(new Color(255, 248, 220));
		textField_21.setOpaque(false);
		textField_21.setHorizontalAlignment(SwingConstants.CENTER);
		textField_21.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_21.setEditable(false);
		textField_21.setColumns(10);
		textField_21.setBorder(null);
		textField_21.setBounds(58, 27, 116, 20);
		panel_4.add(textField_21);
	}
	
	public ArrayList myItems2() {
		ArrayList list2 = new ArrayList();
		list2.add(quotationid);
		list2.add(priceheavy);
        list2.add(pricemedium);
        list2.add(pricelight);
        list2.add(costheavy);
        list2.add(costmedium);
        list2.add(costlight);
        list2.add(q_total);
        list2.add(length);
//        list2.add(routepoint2);
//        list2.add(q_shiftingdate);
//        list2.add(q_shiftingtime);
//        System.out.println(list);
		return list2;
	}
}

