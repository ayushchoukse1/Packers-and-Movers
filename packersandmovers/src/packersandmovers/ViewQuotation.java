package packersandmovers;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class ViewQuotation {
	String id,cid,fname,lname,cont,add,email,sfrom,sto,date,time,medium,light,heavy,total,tcost;;
	private JFrame frmQuotation;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtDada;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_1;
	private JTextField textField_5;
	int a;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewQuotation window = new ViewQuotation();
					window.frmQuotation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewQuotation() {
		
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public ViewQuotation(String...ar)
	{
		id=ar[0];
		 cid=ar[1];
		get_values();
		set_values();
		initialize();
		frmQuotation.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuotation = new JFrame();
		frmQuotation.setIconImage(Toolkit.getDefaultToolkit().getImage(ViewQuotation.class.getResource("/packersandmovers/logo1.jpg")));
		frmQuotation.setTitle("Quotation");
		frmQuotation.setBounds(100, 100, 554, 622);
		frmQuotation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmQuotation.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Integer temp=Integer.parseInt(textField_4.getText())+Integer.parseInt(textField_2.getText())+Integer.parseInt(textField_3.getText());
				String tempstr=temp.toString();
				textField_10.setText(tempstr);
			}
		});
		panel.setBounds(0, 0, 538, 584);
		frmQuotation.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblQuotationNumber = new JLabel("Quotation Number :");
		lblQuotationNumber.setBounds(10, 31, 133, 14);
		panel.add(lblQuotationNumber);

		JLabel lblCustomerId = new JLabel("Customer Id :");
		lblCustomerId.setBounds(10, 69, 133, 14);
		panel.add(lblCustomerId);

		JLabel lblName = new JLabel("First Name :");
		lblName.setBounds(10, 106, 88, 14);
		panel.add(lblName);

		JLabel lblContact = new JLabel("Contact :");
		lblContact.setBounds(10, 147, 88, 14);
		panel.add(lblContact);

		JLabel lblDateCreated = new JLabel("Shifting Date :");
		lblDateCreated.setBounds(10, 286, 88, 14);
		panel.add(lblDateCreated);

		JLabel lblHeavyItems = new JLabel("Heavy Items :");
		lblHeavyItems.setBounds(10, 333, 88, 14);
		panel.add(lblHeavyItems);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(95, 330, 48, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblLightItems = new JLabel("Light Items :");
		lblLightItems.setBounds(186, 333, 88, 14);
		panel.add(lblLightItems);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBackground(Color.WHITE);
		textField_3.setColumns(10);
		textField_3.setBounds(264, 330, 46, 20);
		panel.add(textField_3);

		JLabel lblMediumItems = new JLabel("Medium Items :");
		lblMediumItems.setBounds(352, 333, 88, 14);
		panel.add(lblMediumItems);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBackground(Color.WHITE);
		textField_4.setColumns(10);
		textField_4.setBounds(441, 330, 61, 20);
		panel.add(textField_4);

		JLabel lblTotalNoOf = new JLabel("Total no. of Items : ");
		lblTotalNoOf.setBounds(10, 373, 133, 14);
		panel.add(lblTotalNoOf);

		JLabel lblPrice = new JLabel("Shifting Time :");
		lblPrice.setBounds(283, 283, 133, 14);
		panel.add(lblPrice);

		txtDada = new JTextField();
		txtDada.setEditable(false);
		txtDada.setForeground(Color.BLACK);
		txtDada.setBackground(Color.WHITE);
		txtDada.setBounds(134, 28, 149, 20);
		panel.add(txtDada);
		txtDada.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBackground(Color.WHITE);
		textField_6.setColumns(10);
		textField_6.setBounds(134, 66, 149, 20);
		panel.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBackground(Color.WHITE);
		textField_7.setColumns(10);
		textField_7.setBounds(134, 103, 149, 20);
		panel.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBackground(Color.WHITE);
		textField_8.setColumns(10);
		textField_8.setBounds(134, 144, 149, 20);
		panel.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setBackground(Color.WHITE);
		textField_9.setColumns(10);
		textField_9.setBounds(108, 283, 149, 20);
		panel.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setBackground(Color.WHITE);
		textField_10.setColumns(10);
		textField_10.setBounds(118, 370, 97, 20);
		panel.add(textField_10);

		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setBackground(Color.WHITE);
		textField_11.setColumns(10);
		textField_11.setBounds(379, 283, 149, 20);
		panel.add(textField_11);

		JButton btnClose = new JButton("Close");
		btnClose.setBounds(80, 529, 89, 23);
		panel.add(btnClose);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				textField_2.setEditable(true);
				textField_3.setEditable(true);
				textField_4.setEditable(true);
				
				textField_11.setEditable(true);
				textField_9.setEditable(true);

			}
		});
		btnUpdate.setBounds(231, 529, 89, 23);
		panel.add(btnUpdate);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(389, 529, 89, 23);
		panel.add(btnSave);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setBounds(293, 103, 133, 14);
		panel.add(lblLastName);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(379, 103, 149, 20);
		panel.add(textField_1);
		
		JLabel lblTotalCostOf = new JLabel("Total Cost of Transport :");
		lblTotalCostOf.setBounds(10, 418, 159, 14);
		panel.add(lblTotalCostOf);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(160, 415, 97, 20);
		panel.add(textField_5);
		txtDada.setText(id);
		textField_6.setText(cid);
		textField_7.setText(fname);
		textField_1.setText(lname);
		textField_8.setText(cont);
		//textArea.setText(add);
		//textField.setText(email);
//		DefaultComboBoxModel<String> from=new DefaultComboBoxModel<String>();
//		from.addElement(sfrom);
//		DefaultComboBoxModel<String> to=new DefaultComboBoxModel<String>();
//		from.addElement(sto);
		textField_9.setText(time);
		textField_11.setText(date);
		textField_4.setText(medium);
		textField_3.setText(light);
		textField_2.setText(heavy);
		textField_5.setText(total);
		String ab=String.valueOf(a);
		textField_10.setText(ab);
		
		JLabel lblNewLabel = new JLabel("Shift From");
		lblNewLabel.setBounds(10, 180, 66, 14);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(134, 175, 149, 63);
		panel.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Shift To");
		lblNewLabel_1.setBounds(304, 180, 46, 14);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(382, 175, 146, 63);
		panel.add(scrollPane);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		
		textArea.setText(sfrom);
		textArea_1.setText(sto);
	}
	public void get_values(){
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
				PreparedStatement ps=con.prepareStatement("SELECT customerid, FIRSTNAME, LASTNAME, CONTACT, q_SHIFTFROM, q_SHIFTTO, q_SHIFTDATE, Q_SHIFTTIME, q_LIGHT, q_MEDIUM, q_HEAVY, q_TOTAL FROM QUOTATION WHERE QUOTATIONID ='"+id+"'");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					
					fname=rs.getString(2);
					lname=rs.getString(3);
					cont=rs.getString(4);
					sfrom=rs.getString(5);
					sto=rs.getString(6);
					date=rs.getString(7);
					time=rs.getString(8);
					light=rs.getString(9);
					medium=rs.getString(10);
					heavy=rs.getString(11);
					total=rs.getString(12);
				a= Integer.parseInt(medium)+Integer.parseInt(heavy)+Integer.parseInt(light);
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	public void set_values(){
		System.out.println(id);
		
		
	}
}















