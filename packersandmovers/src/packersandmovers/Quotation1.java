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
import java.awt.Toolkit;


public class Quotation1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	static int q_light, q_medium, q_heavy;
	float q_total;
	static String quotationid, customerid, c_emailid, c_firstname, c_lastname,
	c_address, c_contact, q_shiftfrom, q_shiftto, routepoint1, routepoint2, q_shiftingdate,
	q_shiftingtime;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quotation1 frame = new Quotation1();
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
	public Quotation1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Quotation1.class.getResource("/packersandmovers/logo1.jpg")));
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
		panel_2.setBounds(20, 0, 931, 130);
		panel_1.add(panel_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Quotation1.class.getResource("/packersandmovers/logo1.jpg")));
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
		label.setBounds(10, 0, 92, 130);
		panel_2.add(label);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Quotation1.class.getResource("/packersandmovers/banner3.jpg")));
		label_8.setBounds(102, 0, 870, 130);
		panel_2.add(label_8);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(47, 79, 79));
		panel_3.setBounds(20, 130, 931, 25);
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
		label_5.setBounds(874, 0, 57, 28);
		panel_3.add(label_5);
		
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
		panel_4.setBounds(20, 166, 164, 462);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_4 = new JLabel("Customer Id:");
		label_4.setBounds(0, 26, 77, 20);
		panel_4.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 248, 220));
		textField_3.setOpaque(false);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBounds(58, 27, 116, 20);
		panel_4.add(textField_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 248, 220));
		panel_5.setBounds(183, 166, 768, 462);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_6 = new JLabel("Quotation");
		label_6.setFont(new Font("Century Gothic", Font.BOLD, 25));
		label_6.setBounds(299, 11, 135, 45);
		panel_5.add(label_6);
		
		JLabel lblNewLabel = new JLabel("Category of Goods:");
		lblNewLabel.setBounds(10, 89, 114, 14);
		panel_5.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Heavy");
		lblNewLabel_1.setBounds(124, 89, 46, 14);
		panel_5.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Medium");
		lblNewLabel_2.setBounds(360, 89, 46, 14);
		panel_5.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Light");
		lblNewLabel_3.setBounds(600, 89, 46, 14);
		panel_5.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 248, 220));
		textField.setBounds(124, 394, 67, 28);
		panel_5.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 248, 220));
		textField_1.setBounds(375, 394, 67, 28);
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 248, 220));
		textField_2.setBounds(631, 394, 67, 28);
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("No. of Goods:");
		lblNewLabel_4.setBounds(10, 397, 89, 14);
		panel_5.add(lblNewLabel_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(124, 125, 152, 243);
		panel_5.add(scrollPane_1);
		
		final JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.BOLD, 13));
		textArea.setBackground(new Color(255, 248, 220));
		scrollPane_1.setViewportView(textArea);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		
		JLabel lblNewLabel_5 = new JLabel("Types of Goods:");
		lblNewLabel_5.setBounds(10, 125, 104, 14);
		panel_5.add(lblNewLabel_5);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(360, 125, 152, 243);
		panel_5.add(scrollPane_2);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Arial", Font.BOLD, 13));
		scrollPane_2.setViewportView(textArea_1);
		textArea_1.setOpaque(false);
		textArea_1.setEditable(false);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(600, 125, 152, 243);
		panel_5.add(scrollPane_3);
		
		final JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Arial", Font.BOLD, 13));
		scrollPane_3.setViewportView(textArea_2);
		textArea_2.setOpaque(false);
		textArea_2.setEditable(false);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ArrayList list0=new Login().myItems0();
		        customerid=(String)list0.get(0);
		        System.out.println(customerid);
		        textField_3.setText(customerid);
		        
		        try
				{
					Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "palash");
				Statement st=con.createStatement();
				String q="Select * from heavy_item";
				ResultSet rs=st.executeQuery(q);
				while(rs.next())
				{
					String heavyitem=rs.getString(1);
					textArea.append(" "+heavyitem+"\n");
				}
				String q1="Select * from medium_item";
				ResultSet rs1=st.executeQuery(q1);
				while(rs1.next())
				{
					String mediumitem=rs.getString(1);
					textArea_1.append(" "+mediumitem+"\n");
				}
				String q2="Select * from light_item";
				ResultSet rs2=st.executeQuery(q2);
				while(rs2.next())
				{
					String lightitem=rs.getString(1);
					textArea_2.append(" "+lightitem+"\n");
				}
				con.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			
			}
		});
		
		JButton btnNewButton = new JButton("Generate Quotation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				q_light=Integer.parseInt(textField.getText());
				q_medium=Integer.parseInt(textField_1.getText());
				q_heavy=Integer.parseInt(textField_2.getText());

				new Quotation2().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(201, 438, 145, 23);
		panel_5.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Quotation().setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(484, 438, 89, 23);
		panel_5.add(btnBack);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(106, 90, 205));
		panel_8.setBounds(14, 46, 684, 3);
		panel_5.add(panel_8);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(183, 155, 768, 10);
		panel_1.add(panel_6);
		panel_6.setBackground(new Color(240, 230, 140));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(20, 155, 174, 10);
		panel_1.add(panel_7);
		panel_7.setBackground(new Color(240, 230, 140));
		
		JLabel label_9 = new JLabel("Copyright \u00A9 2013 Packers & Movers Ltd. All Rights Reserved");
		label_9.setBounds(35, 656, 365, 14);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("T & C Apply*");
		label_10.setBounds(849, 656, 74, 14);
		panel_1.add(label_10);
	}
	
	public ArrayList myItems1() {
		ArrayList list1 = new ArrayList();
		list1.add(q_light);
        list1.add(q_medium);
        list1.add(q_heavy);
        System.out.println(list1);
		return list1;
	}
}
