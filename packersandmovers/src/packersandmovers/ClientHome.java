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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;


public class ClientHome extends JFrame {

	private JPanel contentPane;
	
	static String customerid, quotationid1, quotationid2, Cid;
	private JTextField txtYtre;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientHome frame = new ClientHome();
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
	public ClientHome() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientHome.class.getResource("/packersandmovers/logo1.jpg")));
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
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		panel_2.setBounds(21, 0, 930, 130);
		panel_1.add(panel_2);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.WHITE);
		label.setOpaque(true);
		label.setIcon(new ImageIcon(ClientHome.class.getResource("/packersandmovers/logo1.jpg")));
		label.setBounds(10, 0, 82, 130);
		panel_2.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ClientHome.class.getResource("/packersandmovers/banner3.jpg")));
		lblNewLabel.setBounds(102, 0, 828, 130);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(47, 79, 79));
		panel_3.setBounds(21, 130, 930, 25);
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
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Quotation().setVisible(true);
				dispose();
			}
		});
		label_2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_2.setBounds(328, 0, 315, 29);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("Feedback");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Feedback().setVisible(true);
				dispose();
			}
		});
		label_3.setFont(new Font("Century Gothic", Font.BOLD, 15));
		label_3.setBounds(706, 0, 86, 28);
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
		label_5.setBounds(873, 0, 57, 28);
		panel_3.add(label_5);
		
		JLabel lblNewLabel_1 = new JLabel("Home");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new ClientHome().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 0, 86, 28);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 248, 220));
		panel_4.setBounds(21, 165, 163, 462);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 115, 116, 100);
		panel_4.add(scrollPane_1);
		
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
		textArea.setBackground(new Color(255, 248, 220));
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ArrayList list0=new Login().myItems0();
		        customerid=(String)list0.get(0);
		        System.out.println(customerid);
		        txtYtre.setText(customerid);
		        
		        try
				{
					Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "palash");
				Statement st=con.createStatement();
//				String q0="SELECT count(quotationid) from QUOTATION where CUSTOMERID='PAMC000001'";
//				System.out.println(q0);
				String q="Select quotationid from quotation where customerid='"+customerid+"'";
				ResultSet rs=st.executeQuery(q);
//				if(rs.next())
//				{
//					quotationid1=rs.getString(1);
//					System.out.println(quotationid1);
//					customerid=rs.getString(2);
//					c_firstname=rs.getString(3);
//					c_lastname=rs.getString(4);
//					c_contact=rs.getString(5);
//					q_shiftfrom=rs.getString(6);
//					q_shiftto=rs.getString(7);
//					q_shiftingtime=rs.getString(8);
//					q_shiftingdate=rs.getString(9);
//					q_light=rs.getInt(10);
//					q_medium=rs.getInt(11);
//					q_heavy=rs.getInt(12);
//					q_total=rs.getFloat(13);
//				}
				while(rs.next())
				{
					quotationid1=rs.getString(1);
					textArea.append(" "+quotationid1+"\n");
//					System.out.println(quotationid2);
				}
				con.close();
//				textField_13.setText(customerid);
//				textField_14.setText(quotationid);
//				textField.setText(c_firstname);
//				textField_1.setText(c_lastname);
//				textField_2.setText(c_contact);
//				textField_4.setText(String.valueOf(q_heavy));
//				textField_5.setText(String.valueOf(q_medium));
//				textField_6.setText(String.valueOf(q_light));
//				textArea_1.setText(q_shiftfrom);
//				textArea_2.setText(q_shiftto);
//				textField_19.setText(q_shiftingtime);
//				textField_20.setText(q_shiftingdate);
//				textField_17.setText(String.valueOf(q_total));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		
		
		JLabel lblNewLabel_2 = new JLabel("Generated Quotations");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(230, 230, 250));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel_2.setBounds(10, 53, 143, 25);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Customer Id:");
		lblNewLabel_3.setBounds(0, 22, 77, 20);
		panel_4.add(lblNewLabel_3);
		
		txtYtre = new JTextField();
		txtYtre.setBackground(new Color(255, 248, 220));
		txtYtre.setHorizontalAlignment(SwingConstants.CENTER);
		txtYtre.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtYtre.setBorder(null);
		txtYtre.setOpaque(false);
		txtYtre.setEditable(false);
		txtYtre.setBounds(57, 23, 116, 20);
		panel_4.add(txtYtre);
		txtYtre.setColumns(10);
		
		JLabel lblEnterQuotationId = new JLabel("Enter Quotation ID");
		lblEnterQuotationId.setBounds(0, 226, 143, 14);
		panel_4.add(lblEnterQuotationId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 251, 143, 25);
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblQuotationIds = new JLabel("Quotation IDs:");
		lblQuotationIds.setBounds(0, 89, 116, 14);
		panel_4.add(lblQuotationIds);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cid=textField_1.getText();
				new GeneratedQuotations().setVisible(true);
				dispose();
			}
		});
		btnSubmit.setBounds(37, 289, 89, 23);
		panel_4.add(btnSubmit);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 248, 220));
		panel_5.setBounds(183, 166, 767, 461);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ClientHome.class.getResource("/packersandmovers/packers-movers-logo.jpg")));
		label_1.setBounds(88, 55, 604, 369);
		panel_5.add(label_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(183, 155, 767, 10);
		panel_1.add(panel_6);
		panel_6.setBackground(new Color(240, 230, 140));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(21, 155, 173, 10);
		panel_1.add(panel_7);
		panel_7.setBackground(new Color(240, 230, 140));
		
		JLabel label_4 = new JLabel("Copyright \u00A9 2013 Packers & Movers Ltd. All Rights Reserved");
		label_4.setBounds(21, 656, 352, 14);
		panel_1.add(label_4);
		
		JLabel label_6 = new JLabel("T & C Apply*");
		label_6.setBounds(835, 656, 79, 14);
		panel_1.add(label_6);
	}
	public ArrayList items()
	{
		ArrayList lt=new ArrayList();
		lt.add(Cid);
		return lt;
	}
}
