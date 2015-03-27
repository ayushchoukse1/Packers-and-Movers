package packersandmovers;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;

public class PrintQuotation extends JFrame {

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
	
	static String quotationid, customerid, c_emailid, c_firstname, c_lastname, c_address, c_contact, q_shiftfrom, q_shiftto, q_shiftingdate, q_shiftingtime, routepoint1, routepoint2;
	static int  q_light, q_heavy, q_medium, length, priceheavy, pricemedium, pricelight;
	static float costheavy, costmedium, costlight, q_total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrintQuotation frame = new PrintQuotation();
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
	public PrintQuotation() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrintQuotation.class.getResource("/packersandmovers/logo1.jpg")));
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 800, 700);
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
		panel_1.setLayout(null);
		scrollPane.setViewportView(panel_1);
		
		JLabel label = new JLabel("Quotation");
		label.setFont(new Font("Century Gothic", Font.BOLD, 25));
		label.setBounds(337, 11, 135, 45);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("First Name");
		label_1.setBounds(10, 128, 105, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Last Name");
		label_2.setBounds(10, 159, 105, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Address");
		label_3.setBounds(10, 192, 105, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Contact Number");
		label_4.setBounds(10, 271, 105, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Email Id");
		label_5.setBounds(10, 310, 105, 14);
		panel_1.add(label_5);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Quotation Printed!");
				new Quotation().setVisible(true);
				dispose();
			}
		});
		btnPrint.setBounds(213, 496, 89, 23);
		panel_1.add(btnPrint);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Quotation2().setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(488, 496, 89, 23);
		panel_1.add(btnBack);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 248, 220));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(125, 125, 177, 28);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 248, 220));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(125, 156, 177, 28);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 248, 220));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(125, 268, 177, 28);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 248, 220));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(125, 307, 177, 28);
		panel_1.add(textField_3);
		
		JLabel label_6 = new JLabel("Shift From");
		label_6.setBounds(10, 363, 70, 14);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("Shift To");
		label_7.setBounds(358, 360, 46, 14);
		panel_1.add(label_7);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(124, 187, 178, 67);
		panel_1.add(scrollPane_1);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 248, 220));
		scrollPane_1.setViewportView(textArea);
		textArea.setEditable(false);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(125, 358, 178, 61);
		panel_1.add(scrollPane_3);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(255, 248, 220));
		scrollPane_3.setViewportView(textArea_1);
		textArea_1.setEditable(false);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(471, 358, 177, 61);
		panel_1.add(scrollPane_2);
		
		final JTextArea textArea_2 = new JTextArea();
		textArea_2.setBackground(new Color(255, 248, 220));
		scrollPane_2.setViewportView(textArea_2);
		textArea_2.setEditable(false);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
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
				
				ArrayList list2 = new Quotation2().myItems2();
				quotationid=(String)list2.get(0);
				priceheavy=(Integer)list2.get(1);
				pricemedium=(Integer)list2.get(2);
				pricelight=(Integer)list2.get(3);
				costheavy=(Float)list2.get(4);
				costmedium=(Float)list2.get(5);
				costlight=(Float)list2.get(6);
				q_total=(Float)list2.get(7);
				length=(Integer)list2.get(8);
				textField_14.setText(quotationid);
				textField_15.setText(String.valueOf(length));
				textField_9.setText(String.valueOf(pricelight));
				textField_8.setText(String.valueOf(pricemedium));
				textField_7.setText(String.valueOf(priceheavy));
				textField_10.setText(String.valueOf(costheavy));
				textField_11.setText(String.valueOf(costmedium));
				textField_12.setText(String.valueOf(costlight));
				textField_17.setText(String.valueOf(q_total));
			}
		});
		
		JLabel label_8 = new JLabel("Shifting Date");
		label_8.setBounds(10, 433, 87, 14);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("Shifting Time");
		label_9.setBounds(358, 430, 87, 14);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("Large Goods");
		label_10.setBounds(358, 127, 87, 14);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("Quantity");
		label_11.setBounds(471, 100, 71, 14);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("Price/km");
		label_12.setBounds(552, 100, 91, 14);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("Cost");
		label_13.setBounds(653, 100, 63, 14);
		panel_1.add(label_13);
		
		JLabel label_14 = new JLabel("Medium Goods");
		label_14.setBounds(358, 158, 87, 14);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("Small Goods");
		label_15.setBounds(358, 189, 87, 14);
		panel_1.add(label_15);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(255, 248, 220));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(471, 127, 46, 28);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(255, 248, 220));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(471, 158, 46, 28);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(255, 248, 220));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(471, 189, 46, 28);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(255, 248, 220));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(552, 127, 70, 28);
		panel_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setBackground(new Color(255, 248, 220));
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(552, 158, 70, 28);
		panel_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setBackground(new Color(255, 248, 220));
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(552, 189, 70, 28);
		panel_1.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setBackground(new Color(255, 248, 220));
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(653, 127, 86, 28);
		panel_1.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setBackground(new Color(255, 248, 220));
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(653, 158, 86, 28);
		panel_1.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setBackground(new Color(255, 248, 220));
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(653, 189, 86, 28);
		panel_1.add(textField_12);
		
		JLabel lblCustomerId = new JLabel("Customer Id");
		lblCustomerId.setBounds(10, 73, 87, 14);
		panel_1.add(lblCustomerId);
		
		textField_13 = new JTextField();
		textField_13.setBackground(new Color(255, 248, 220));
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(125, 70, 177, 28);
		panel_1.add(textField_13);
		
		JLabel label_17 = new JLabel("Quotation Id");
		label_17.setBounds(358, 67, 87, 14);
		panel_1.add(label_17);
		
		textField_14 = new JTextField();
		textField_14.setBackground(new Color(255, 248, 220));
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(471, 67, 177, 28);
		panel_1.add(textField_14);
		
		JLabel label_18 = new JLabel("Route Cost");
		label_18.setBounds(358, 223, 63, 14);
		panel_1.add(label_18);
		
		textField_15 = new JTextField();
		textField_15.setBackground(new Color(255, 248, 220));
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		textField_15.setBounds(471, 220, 86, 28);
		panel_1.add(textField_15);
		
		JLabel label_19 = new JLabel("VAT");
		label_19.setBounds(597, 220, 46, 14);
		panel_1.add(label_19);
		
		textField_16 = new JTextField();
		textField_16.setBackground(new Color(255, 248, 220));
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBounds(653, 220, 86, 28);
		panel_1.add(textField_16);
		
		JLabel label_20 = new JLabel("Total Cost");
		label_20.setBounds(358, 307, 86, 14);
		panel_1.add(label_20);
		
		textField_17 = new JTextField();
		textField_17.setBackground(new Color(255, 248, 220));
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		textField_17.setBounds(531, 293, 169, 54);
		panel_1.add(textField_17);
		
		JLabel label_21 = new JLabel("Other Charges");
		label_21.setBounds(358, 253, 87, 14);
		panel_1.add(label_21);
		
		textField_18 = new JTextField();
		textField_18.setBackground(new Color(255, 248, 220));
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		textField_18.setBounds(471, 251, 106, 28);
		panel_1.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setBackground(new Color(255, 248, 220));
		textField_19.setEditable(false);
		textField_19.setColumns(10);
		textField_19.setBounds(125, 430, 177, 28);
		panel_1.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setBackground(new Color(255, 248, 220));
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		textField_20.setBounds(471, 430, 177, 28);
		panel_1.add(textField_20);
	}

}
