package packersandmovers;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class Additem {

	private JFrame frame;
	private JTextField textField;
	private JComboBox comboBox ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Additem window = new Additem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Additem() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Additem.class.getResource("/packersandmovers/logo1.jpg")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 219);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(181, 94, 127, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Select from Category", "Medium", "large", "heavy" }));
		comboBox.setBounds(181, 27, 127, 20);
		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel = new JLabel("Category :");
		lblNewLabel.setBounds(46, 30, 86, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Item Name : ");
		lblNewLabel_1.setBounds(46, 97, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			String cat=(String)comboBox.getSelectedItem();
			String item_name=textField.getText();
			if (item_name.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please Enter an Item ");
			}
if (cat.equalsIgnoreCase("select from category")) {
	JOptionPane.showMessageDialog(null, "Please Select from Category !");
} else {
	if (cat.equalsIgnoreCase("heavy")) {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
			Statement st=con.createStatement();
			String query="INSERT INTO HEAVY_ITEM (ITEM_NAME) VALUES ('"+item_name+"')  ";
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Item \""+item_name+"\" has been added to "+cat+" Category");
			frame.dispose();
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		}else{
			{if (cat.equalsIgnoreCase("medium")) {
				try{
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
				Statement st=con.createStatement();
				String query="INSERT INTO MEDIUM_ITEM (ITEM_NAME) VALUES ('"+item_name+"') ";
				st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Item \""+item_name+"\" has been added to "+cat+" Category");
				frame.dispose();
			} catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			e1.printStackTrace();
			}
			} else {
				try{
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
				Statement st=con.createStatement();
				String query="INSERT INTO LIGHT_ITEM (ITEM_NAME) VALUES ('"+item_name+"') ";
				st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Item \""+item_name+"\" has been added to "+cat+" Category");
				frame.dispose();
				} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}

			}
		}
	}
	
}


			}
			
		});
		btnAddItem.setBounds(183, 140, 89, 23);
		frame.getContentPane().add(btnAddItem);
	}

}
