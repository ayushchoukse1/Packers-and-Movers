package packersandmovers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.Toolkit;

public class UpdateRate {

	private JFrame frmUpdateRates;
	private JTextField textField;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateRate window = new UpdateRate();
					window.frmUpdateRates.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateRate() {
		initialize();
		frmUpdateRates.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdateRates = new JFrame();
		frmUpdateRates.setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateRate.class.getResource("/packersandmovers/logo1.jpg")));
		frmUpdateRates.setTitle("UPDATE RATES");
		frmUpdateRates.setBounds(100, 100, 454, 230);
		frmUpdateRates.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUpdateRates.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(211, 101, 86, 20);
		frmUpdateRates.getContentPane().add(textField);
		textField.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Select from Category", "Medium", "large", "heavy" }));
		comboBox.setBounds(211, 31, 154, 20);
		frmUpdateRates.getContentPane().add(comboBox);

		JLabel lblNewLabel = new JLabel("Category :");
		lblNewLabel.setBounds(63, 34, 102, 14);
		frmUpdateRates.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter Price : ");
		lblNewLabel_1.setBounds(63, 104, 86, 14);
		frmUpdateRates.getContentPane().add(lblNewLabel_1);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(140, 146, 89, 23);
		frmUpdateRates.getContentPane().add(btnUpdate);
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cat=(String)comboBox.getSelectedItem();
				String rate=textField.getText();
				
				try {
					
					int result=JOptionPane.showConfirmDialog(null, "The Entered Value will be updated.", "Confirm", JOptionPane.YES_NO_OPTION);
					if (result==JOptionPane.YES_OPTION) {
						Class.forName("oracle.jdbc.OracleDriver");
						Connection con = DriverManager.getConnection(
								"jdbc:oracle:thin:@localhost:1521:orcl","scott","palash");
						Statement st=con.createStatement();
						String query="UPDATE RATEperkm SET PRICE = "+rate+" WHERE CATEGORY = '"+cat+"'     ";
						st.executeUpdate(query);
					}
					JOptionPane.showMessageDialog(null, "Rates Updated in "+cat+" Category to "+rate+" Rs");
					
					
					frmUpdateRates.dispose();
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
	}
}
