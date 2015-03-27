package packersandmovers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class Addclient {

	private JFrame frmAddClient;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addclient window = new Addclient();
					window.frmAddClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Addclient() {
		initialize();
		frmAddClient.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddClient = new JFrame();
		frmAddClient.setIconImage(Toolkit.getDefaultToolkit().getImage(Addclient.class.getResource("/packersandmovers/logo1.jpg")));
		frmAddClient.setTitle("ADD CLIENT");
		frmAddClient.setBounds(100, 100, 342, 466);
		frmAddClient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddClient.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 304, 413);
		frmAddClient.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 11, 46, 14);
		panel.add(lblName);

		JLabel label = new JLabel("Name:");
		label.setBounds(10, 11, 46, 14);
		panel.add(label);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 49, 65, 14);
		panel.add(lblAddress);

		JLabel lblContact = new JLabel("Contact:");
		lblContact.setBounds(10, 151, 65, 14);
		panel.add(lblContact);

		JLabel lblQuotation = new JLabel("Quotation:");
		lblQuotation.setBounds(10, 207, 65, 14);
		panel.add(lblQuotation);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 255, 46, 14);
		panel.add(lblStatus);

		textField = new JTextField();
		textField.setBounds(102, 8, 153, 20);
		panel.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(102, 54, 153, 69);
		panel.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);

		textField_1 = new JTextField();
		textField_1.setBounds(102, 148, 153, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(102, 204, 153, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(102, 255, 153, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JButton btnAddClient = new JButton("Add Client");
		btnAddClient.setBounds(36, 329, 105, 23);
		panel.add(btnAddClient);

		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		btnReset.setBounds(181, 329, 89, 23);
		panel.add(btnReset);
	}
}
