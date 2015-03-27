package packersandmovers;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.org.apache.regexp.internal.RESyntaxException;

import net.proteanit.sql.DbUtils;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Admin {
	static Connection con;
	String id_1;
	 String medium,large,heavy;
	 String a[]=new String[3];
	private JFrame frmAdmin;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField txtrs;
	private JTextField txtrs_1;
	private JTextField txtrs_2;
	private JTable table_3;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JList list;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frmAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		connection();
		initialize();
		update_rates();
		update_client();
		update_employee();
		update_feedback();
		update_quotation();

		
		frmAdmin.setVisible(true);
	}
public Admin(int a){
//	frmAdmin.revalidate();
	frmAdmin.repaint();
}
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
	private void initialize() {
		frmAdmin = new JFrame();
		frmAdmin.setIconImage(Toolkit.getDefaultToolkit().getImage(Admin.class.getResource("/packersandmovers/logo1.jpg")));
		frmAdmin.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				update_rates();
				refresh_list();
			
				update_client();
				update_employee();
				update_feedback();
				update_quotation();
			frmAdmin.repaint();
			}
		});
		frmAdmin.setResizable(false);
		frmAdmin.setTitle("ADMIN");
		frmAdmin.setBounds(100, 100, 843, 411);
		frmAdmin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAdmin.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.textText);
		tabbedPane.setBounds(0, 0, 837, 383);
		frmAdmin.getContentPane().add(tabbedPane);

		JPanel Client_panel = new JPanel();
		tabbedPane.addTab("Client Management", null, Client_panel, null);
		tabbedPane.setBackgroundAt(0, Color.LIGHT_GRAY);
		Client_panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 812, 185);
		Client_panel.add(scrollPane);

		 table = new JTable();
		 table.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 	table.getSelectedRow();
		 	}
		 });
		 table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "First Name", "Last Name", "Address", "contact", "quotation", "Status", "UserName"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(7).setResizable(false);

		JButton btnNewButton = new JButton("Update Client");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selected_row = table.getSelectedRow();
				Object[] rowData=new Object[table.getColumnCount()];
				for(int i=0;i<table.getColumnCount();i++){
					rowData[i]=table.getValueAt(selected_row,i);
				}
				String id=(String)rowData[0];
				
				new Updateclient(id);
				update_client();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

			}
		});
		btnNewButton.setBounds(99, 271, 111, 23);
		Client_panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Delete Client");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selected_row = table.getSelectedRow();
				Object[] rowData=new Object[table.getColumnCount()];
				for(int i=0;i<table.getColumnCount();i++){
					rowData[i]=table.getValueAt(selected_row,i);
				}
				String id=(String)rowData[0];
				int reply = JOptionPane.showConfirmDialog(null, "Selected Entry will be Deleted", "Are you sure ?", JOptionPane.YES_NO_OPTION);
				if(reply==JOptionPane.YES_OPTION){
					try{
						 
						
						PreparedStatement ps=con.prepareStatement("DELETE FROM CLIENT WHERE CustomerID = '"+id+"'  ");
						ps.executeUpdate();
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
				update_client();
			}
		});
		btnNewButton_1.setBounds(322, 271, 111, 23);
		Client_panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Update Status");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selected_row = table.getSelectedRow();
				Object[] rowData=new Object[table.getColumnCount()];
				for(int i=0;i<table.getColumnCount();i++){
					rowData[i]=table.getValueAt(selected_row,i);
				}
				String id=(String)rowData[0];
				
				new Updateclientstatus(id);
			}
		});
		btnNewButton_2.setBounds(519, 271, 126, 23);
		Client_panel.add(btnNewButton_2);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			int result=(int)JOptionPane.showConfirmDialog(null,"Are you sure you want to Logout?","Confirm!",JOptionPane.YES_NO_OPTION);
			if(result==JOptionPane.YES_OPTION){
				new Login();
				frmAdmin.dispose();
			}
			}
		});
		btnLogout.setBounds(733, 0, 89, 23);
		Client_panel.add(btnLogout);

		JPanel Employee_panel = new JPanel();
		tabbedPane.addTab("Employee Management", null, Employee_panel, null);
		tabbedPane.setBackgroundAt(1, Color.LIGHT_GRAY);
		Employee_panel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 812, 189);
		Employee_panel.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, },
				new String[] { "ID", "Name", "Post", "Address", "Contact",
						"Age", "Gender", "Salary" }) {
			/**
							 * 
							 */
							private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { Integer.class, String.class,
					String.class, String.class, Integer.class, Integer.class,
					String.class, Integer.class };

			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false,
					false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(2).setResizable(false);
		table_1.getColumnModel().getColumn(3).setResizable(false);
		table_1.getColumnModel().getColumn(4).setResizable(false);
		table_1.getColumnModel().getColumn(5).setResizable(false);
		table_1.getColumnModel().getColumn(6).setResizable(false);
		table_1.getColumnModel().getColumn(7).setResizable(false);

		JButton btnAdd = new JButton("Add Employee");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Addemp();
			}
		});
		btnAdd.setBounds(94, 298, 134, 23);
		Employee_panel.add(btnAdd);

		JButton btnDelete = new JButton("Delete Employee");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selected_row = table_1.getSelectedRow();
			Object[] rowData=new Object[table_1.getColumnCount()];
			for(int i=0;i<table_1.getColumnCount();i++){
				rowData[i]=table_1.getValueAt(selected_row,i);
			}
			String id=(String)rowData[0];
			int reply = JOptionPane.showConfirmDialog(null, "Selected Entry will be Deleted", "Are you sure ?", JOptionPane.YES_NO_OPTION);
			if(reply==JOptionPane.YES_OPTION){
				try{
					 
					
					PreparedStatement ps=con.prepareStatement("DELETE FROM EMPLOYEE WHERE EMPLOYEEID = '"+id+"'");
					ps.executeUpdate();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
			update_employee();
				
			}
		});
		btnDelete.setBounds(321, 298, 134, 23);
		Employee_panel.add(btnDelete);

		JButton btnUpdate = new JButton("Update Details");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selected_row = table_1.getSelectedRow();
				Object[] rowData=new Object[table_1.getColumnCount()];
				for(int i=0;i<table_1.getColumnCount();i++){
					rowData[i]=table_1.getValueAt(selected_row,i);
				}
				String id=(String)rowData[0];
				
				new Updateempdetails(id);
			}
		});
		
		btnUpdate.setBounds(558, 298, 120, 23);
		Employee_panel.add(btnUpdate);

		JPanel quotation_panel = new JPanel();
		tabbedPane.addTab("Quotation Management", null, quotation_panel, null);
		tabbedPane.setBackgroundAt(2, Color.LIGHT_GRAY);
		quotation_panel.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setViewportBorder(new BevelBorder(BevelBorder.LOWERED,
				null, null, null, null));
		scrollPane_2.setBounds(10, 11, 812, 188);
		quotation_panel.add(scrollPane_2);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Quotation ID", "Customer ID", "First Name", "Last Name", "Contact", "Shifting Date", "Price (in Rs.)"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_2.getColumnModel().getColumn(0).setResizable(false);
		table_2.getColumnModel().getColumn(1).setResizable(false);
		table_2.getColumnModel().getColumn(2).setResizable(false);
		table_2.getColumnModel().getColumn(3).setResizable(false);
		table_2.getColumnModel().getColumn(4).setResizable(false);
		table_2.getColumnModel().getColumn(5).setResizable(false);
		table_2.getColumnModel().getColumn(6).setResizable(false);
		scrollPane_2.setViewportView(table_2);

		JButton btnDeleteQuotation = new JButton("Delete Quotation");
		btnDeleteQuotation.setBounds(637, 252, 139, 23);
		quotation_panel.add(btnDeleteQuotation);

		JButton btnViewQuotation = new JButton("View Quotation");
		btnViewQuotation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selected_row = table_2.getSelectedRow();
				Object[] rowData=new Object[table_2.getColumnCount()];
				for(int i=0;i<table_2.getColumnCount();i++){
					rowData[i]=table_2.getValueAt(selected_row,i);
				}
				String id=(String)rowData[0];
				String cid=(String)rowData[1];
				System.out.println(id+"  "+cid);
				new ViewQuotation(id,cid);
			}
		});
		btnViewQuotation.setBounds(66, 252, 145, 23);
		quotation_panel.add(btnViewQuotation);

		JPanel Price_panel = new JPanel();
		tabbedPane.addTab("Price Management", null, Price_panel, null);
		tabbedPane.setBackgroundAt(3, Color.LIGHT_GRAY);
		Price_panel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 367, 333);
		Price_panel.add(panel);
		panel.setLayout(null);

		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblCategory.setBounds(31, 22, 95, 14);
		panel.add(lblCategory);

		JLabel lblRate = new JLabel("Rate");
		lblRate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblRate.setBounds(238, 22, 46, 14);
		panel.add(lblRate);

		JLabel lblNewLabel = new JLabel("1. Medium :");
		lblNewLabel.setFont(new Font("Calisto MT", Font.BOLD, 12));
		lblNewLabel.setBounds(31, 69, 83, 14);
		panel.add(lblNewLabel);

		JLabel lblLarge = new JLabel("2. Large :");
		lblLarge.setFont(new Font("Calisto MT", Font.BOLD, 12));
		lblLarge.setBounds(31, 121, 65, 14);
		panel.add(lblLarge);

		JLabel lblHeavy = new JLabel("3. Heavy :");
		lblHeavy.setFont(new Font("Calisto MT", Font.BOLD, 12));
		lblHeavy.setBounds(31, 172, 83, 14);
		panel.add(lblHeavy);

		txtrs = new JTextField();
		txtrs.setEditable(false);
		
		txtrs.setBounds(214, 65, 86, 20);
		panel.add(txtrs);
		txtrs.setColumns(10);

		txtrs_1 = new JTextField();
		txtrs_1.setEditable(false);
		
		txtrs_1.setBounds(214, 117, 86, 20);
		panel.add(txtrs_1);
		txtrs_1.setColumns(10);

		txtrs_2 = new JTextField();
		txtrs_2.setEditable(false);
		
		txtrs_2.setBounds(214, 168, 86, 20);
		panel.add(txtrs_2);
		txtrs_2.setColumns(10);

		JLabel lblkm = new JLabel("/Km");
		lblkm.setBounds(274, 23, 46, 14);
		panel.add(lblkm);

		JLabel lblNoteChargesApply = new JLabel("Note: Charges apply per item.");
		lblNoteChargesApply.setBounds(31, 308, 238, 14);
		panel.add(lblNoteChargesApply);

		JButton btnUpdateRates = new JButton("Update Rates");
		btnUpdateRates.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new UpdateRate();
			}
		});
		btnUpdateRates.setBounds(31, 258, 132, 23);
		panel.add(btnUpdateRates);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(387, 11, 435, 333);
		Price_panel.add(panel_1);
		panel_1.setLayout(null);

		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				set_list();
			}
		});
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Select from Category", "Medium", "Large", "Heavy" }));
		comboBox.setBounds(10, 11, 147, 20);
		panel_1.add(comboBox);

		JLabel lblChooseFromCategory = new JLabel(
				"Choose from category to see items in it.");
		lblChooseFromCategory.setBounds(167, 14, 246, 14);
		panel_1.add(lblChooseFromCategory);

		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Additem();

			}
		});
		btnAddItem.setBounds(227, 59, 123, 23);
		panel_1.add(btnAddItem);
		
		JButton btnRemoveItem = new JButton("Remove Item");
		btnRemoveItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			int  result=JOptionPane.showConfirmDialog(null,"Are you sure you want To delete the selected entry?", "CONFIRM ! ",JOptionPane.YES_NO_OPTION);
				String item=(String)comboBox.getSelectedItem();
				
			if(result==JOptionPane.YES_OPTION){
				if(item.equalsIgnoreCase("large")){
					String str=(String)list.getSelectedValue();
					try{
						 
						
						Statement st=con.createStatement();
						String query="DELETE FROM LIGHT_ITEM WHERE ITEM_NAME = '"+str+"' ";
						st.executeUpdate(query);
						set_list();
					}catch(Exception e){
						e.printStackTrace();
						}
				}else{
					if(item.equalsIgnoreCase("medium")){
						String str=(String)list.getSelectedValue();
						try{
							 
							
							Statement st=con.createStatement();
							String query="DELETE FROM MEDIUM_ITEM WHERE ITEM_NAME = '"+str+"' ";
							st.executeUpdate(query);
							set_list();
						}catch(Exception e){
							e.printStackTrace();
							}
					}else{
						String str=(String)list.getSelectedValue();
						try{
							 
							
							Statement st=con.createStatement();
							String query="DELETE FROM HEAVY_ITEM WHERE ITEM_NAME = '"+str+"' ";
							st.executeUpdate(query);
							set_list();
						}catch(Exception e){
							e.printStackTrace();
							}
					}
				}
			}
			}
		});
		btnRemoveItem.setBounds(227, 107, 123, 23);
		panel_1.add(btnRemoveItem);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 42, 145, 283);
		panel_1.add(scrollPane_4);
	
				list = new JList();
				scrollPane_4.setViewportView(list);

		JPanel Feedback_panel = new JPanel();
		tabbedPane.addTab("Feedback", null, Feedback_panel, null);
		tabbedPane.setBackgroundAt(4, Color.LIGHT_GRAY);
		Feedback_panel.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 812, 171);
		Feedback_panel.add(scrollPane_3);

		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"FeedBack Id", "Customer Id", "First Name", "Last Name", "Address", "Contact"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, false, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_3.getColumnModel().getColumn(0).setResizable(false);
		table_3.getColumnModel().getColumn(1).setResizable(false);
		table_3.getColumnModel().getColumn(2).setResizable(false);
		table_3.getColumnModel().getColumn(3).setResizable(false);
		table_3.getColumnModel().getColumn(4).setResizable(false);
		table_3.getColumnModel().getColumn(5).setResizable(false);
		scrollPane_3.setViewportView(table_3);

		JButton btnNewButton_3 = new JButton("View Feedback");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selected_row = table_3.getSelectedRow();
				Object[] rowData=new Object[table_3.getColumnCount()];
				for(int i=0;i<table_3.getColumnCount();i++){
					rowData[i]=table_3.getValueAt(selected_row,i);
				}
				String id=(String)rowData[0];
				new Viewfeedback(id);
			}
		});
		btnNewButton_3.setBounds(178, 248, 120, 23);
		Feedback_panel.add(btnNewButton_3);

		JButton btnDeleteFeedback = new JButton("Delete Feedback");
		btnDeleteFeedback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				int selected_row = table_3.getSelectedRow();
				Object[] rowData=new Object[table_3.getColumnCount()];
				for(int i=0;i<table_3.getColumnCount();i++){
					rowData[i]=table_3.getValueAt(selected_row,i);
				}
				String id=(String)rowData[0];
				try {
					 
					
					Statement st=con.createStatement();
					String query="DELETE FROM FEEDBACK WHERE FEEDBACKID = '"+id+"'   ";
					int result=JOptionPane.showConfirmDialog(null, "Are you sure you want  to delete "+id+" Entry ?", "Confirm ! ",JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.YES_OPTION)
					{
						st.executeUpdate(query);
						update_feedback();
					}
				
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnDeleteFeedback.setBounds(486, 248, 137, 23);
		Feedback_panel.add(btnDeleteFeedback);
	}
	public void update_client(){
		try {
			 
			
			String get_client_table="SELECT * FROM CLIENT WHERE C_FIRSTNAME IS  NOT  NULL  ";
			PreparedStatement ps=con.prepareStatement(get_client_table);
			ResultSet rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			for (int c = 0; c < table.getColumnCount(); c++)
			{
			    Class<?> col_class = table.getColumnClass(c);
			    table.setDefaultEditor(col_class, null);        // remove editor
			}
			
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}
	public void update_employee(){
		try {
			 
			
			String get_client_table="SELECT * FROM EMPLOYEE WHERE E_FIRSTNAME IS  NOT  NULL  ";
			PreparedStatement ps=con.prepareStatement(get_client_table);
			ResultSet rs=ps.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			
			for (int c = 0; c < table_1.getColumnCount(); c++)
			{
			    Class<?> col_class = table_1.getColumnClass(c);
			    table_1.setDefaultEditor(col_class, null);        // remove editor
			}
			
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}
	public void update_quotation(){
		try {
			 
			
			String get_client_table="SELECT QUOTATIONID, CustomerID, FIRSTNAME, LASTNAME, CONTACT, q_shiftfrom, q_shiftto, q_shifttime, q_SHIFTDATE, q_TOTAL FROM QUOTATION WHERE CustomerID IS  NOT  NULL";
			PreparedStatement ps=con.prepareStatement(get_client_table);
			ResultSet rs=ps.executeQuery();
			table_2.setModel(DbUtils.resultSetToTableModel(rs));
			for (int c = 0; c < table_2.getColumnCount(); c++)
			{
			    Class<?> col_class = table_2.getColumnClass(c);
			    table_2.setDefaultEditor(col_class, null);        // remove editor
			}
			
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}
	public void update_feedback(){
		try {
			 
			
			String get_client_table="SELECT * FROM FEEDBACK WHERE F_FIRSTNAME IS  NOT  NULL";
			PreparedStatement ps=con.prepareStatement(get_client_table);
			ResultSet rs=ps.executeQuery();
			table_3.setModel(DbUtils.resultSetToTableModel(rs));
			for (int c = 0; c < table_3.getColumnCount(); c++)
			{
			    Class<?> col_class = table_3.getColumnClass(c);
			    table_3.setDefaultEditor(col_class, null);        // remove editor
			}
			
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}
	public void update_rates(){
		try {
			
			 
			
			String query="SELECT PRICE FROM priceperkm";
			PreparedStatement ps=con.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			String str[]=new String[3];
			int i=0;
			while(rs.next()){
				str[i]=rs.getString(1);
			
				i++;
			}
			txtrs.setText(str[0]);
			txtrs_1.setText(str[1]);
			txtrs_2.setText(str[2]);
			rs.close();
			

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void set_list(){
		String cat=(String)comboBox.getSelectedItem();
		String query;
		if(comboBox.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(null,"Please Select a category");
		}else{
			if (cat.equalsIgnoreCase("medium")) {
				query="SELECT * FROM MEDIUM_ITEM";
				try{
					DefaultListModel temp_list= new DefaultListModel();
					 
					
					PreparedStatement ps=con.prepareStatement(query);
					ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					String name=rs.getString(1);
					temp_list.addElement(name);
				}
				list.setModel(temp_list);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			} else {if (cat.equalsIgnoreCase("large")) {
				query="SELECT * FROM LIGHT_ITEM";
				try{
					DefaultListModel temp_list= new DefaultListModel();
					
					PreparedStatement ps=con.prepareStatement(query);
					ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					String name=rs.getString(1);
					temp_list.addElement(name);
				}
				list.setModel(temp_list);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			} else {
					query="SELECT * FROM HEAVY_ITEM";
					try{
						DefaultListModel temp_list= new DefaultListModel();
						 
												PreparedStatement ps=con.prepareStatement(query);
						ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						String name=rs.getString(1);
						temp_list.addElement(name);
					}
					list.setModel(temp_list);
					}catch(Exception e){
						e.printStackTrace();
					}
					
			}

			}

			
		}
	}
	public void refresh_list(){
		String cat=(String)comboBox.getSelectedItem();
		String query;
		
			if (cat.equalsIgnoreCase("medium")) {
				query="SELECT * FROM MEDIUM_ITEM";
				try{
					DefaultListModel temp_list= new DefaultListModel();
					 
					
					PreparedStatement ps=con.prepareStatement(query);
					ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					String name=rs.getString(1);
					temp_list.addElement(name);
				}
				list.setModel(temp_list);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			} else {if (cat.equalsIgnoreCase("large")) {
				query="SELECT * FROM LIGHT_ITEM";
				try{
					DefaultListModel temp_list= new DefaultListModel();
					 
					 
					PreparedStatement ps=con.prepareStatement(query);
					ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					String name=rs.getString(1);
					temp_list.addElement(name);
				}
				list.setModel(temp_list);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			} else {
				if(cat.equalsIgnoreCase("large")){
					query="SELECT * FROM HEAVY_ITEM";
				
					try{
						DefaultListModel temp_list= new DefaultListModel();
						 
						
						PreparedStatement ps=con.prepareStatement(query);
						ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						String name=rs.getString(1);
						temp_list.addElement(name);
					}
					list.setModel(temp_list);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}

			}

			
		}
	static void connection(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			 con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	}


