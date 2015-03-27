package packersandmovers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.awt.Window.Type;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Feedform extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ButtonGroup bg = new ButtonGroup();
	private ButtonGroup b = new ButtonGroup();
	private ButtonGroup g = new ButtonGroup();
	private JScrollBar j = new JScrollBar();
	
	String cid,name,address,email,comment;
	String ser="";
	String be ="";
	String over ="";
	String contact="";
	int con;
	int f=0;
	String fid=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedform frame = new Feedform();
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
	public Feedform() {
		setTitle("FEEDBACK");
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/siddharthsarathe/Desktop/untitled folder 2/Feedform (11).jpg"));
		lblNewLabel.setBounds(0, -23, 581, 137);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(-17, 112, 599, 620);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setBackground(new Color(210, 180, 140));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(-1, 0, 624, 22);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customer id");
		lblNewLabel_2.setBounds(46, 75, 101, 22);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(46, 118, 101, 22);
		panel_1.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(182, 118, 134, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(182, 75, 134, 22);
		panel_1.add(textField_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(46, 152, 101, 22);
		panel_1.add(lblAddress);
		
		final JTextArea textArea1 = new JTextArea();
		textArea1.setBackground(Color.GRAY);
		textArea1.setBounds(182, 155, 134, 50);
		panel_1.add(textArea1);
		
		JLabel lblServices = new JLabel("Services");
		lblServices.setBounds(46, 310, 101, 22);
		panel_1.add(lblServices);
		
		JLabel lblBehaviour = new JLabel("Behaviour");
		lblBehaviour.setBounds(46, 344, 101, 22);
		panel_1.add(lblBehaviour);
		
		final JRadioButton serpoor = new JRadioButton("POOR");
		serpoor.setBounds(182, 310, 78, 23);
		panel_1.add(serpoor);
		bg.add(serpoor);
		
		final JRadioButton sergood = new JRadioButton("GOOD");
		sergood.setBounds(272, 310, 78, 23);
		panel_1.add(sergood);
		bg.add(sergood);
		
		final JRadioButton bepoor = new JRadioButton("POOR");
		bepoor.setBounds(182, 344, 78, 23);
		panel_1.add(bepoor);
		b.add(bepoor);
		
		final JRadioButton ogood = new JRadioButton("GOOD");
		ogood.setBounds(272, 377, 78, 23);
		panel_1.add(ogood);
		g.add(ogood);
		
		final JRadioButton bevgood = new JRadioButton("V GOOD");
		bevgood.setBounds(362, 344, 95, 23);
		panel_1.add(bevgood);
		b.add(bevgood);
		
		final JRadioButton beexc = new JRadioButton("EXCELLENT");
		beexc.setBounds(452, 344, 116, 23);
		panel_1.add(beexc);
		b.add(beexc);
		
		final JRadioButton servgood = new JRadioButton("V GOOD");
		servgood.setBounds(362, 310, 95, 23);
		panel_1.add(servgood);
		bg.add(servgood);
		
		final JRadioButton serexc = new JRadioButton("EXCELLENT");
		serexc.setBounds(452, 310, 116, 23);
		panel_1.add(serexc);
		bg.add(serexc);
		
		JLabel lblOverall = new JLabel("Overall");
		lblOverall.setBounds(46, 378, 101, 22);
		panel_1.add(lblOverall);
		
		final JRadioButton opoor = new JRadioButton("POOR");
		opoor.setBounds(182, 379, 78, 23);
		panel_1.add(opoor);
		g.add(opoor);
		
		final JRadioButton begood = new JRadioButton("GOOD");
		begood.setBounds(272, 344, 78, 23);
		panel_1.add(begood);
		b.add(begood);
		
		final JRadioButton ovgood = new JRadioButton("V GOOD");
		ovgood.setBounds(362, 377, 95, 23);
		panel_1.add(ovgood);
		g.add(ovgood);
		
		final JRadioButton oexc = new JRadioButton("EXCELLENT");
		oexc.setBounds(452, 377, 116, 23);
		panel_1.add(oexc);
		g.add(oexc);
		
		JLabel lblComment = new JLabel("Comment");
		lblComment.setBounds(46, 423, 101, 22);
		panel_1.add(lblComment);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.GRAY);
		textArea.setBounds(182, 426, 134, 50);
		panel_1.add(textArea);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
			fid = textField_2.getText();
			cid = textField_1.getText();
			name = textField.getText();
			address = textArea1.getText();
			System.out.println(address);
            email = textField_3.getText();
            contact = textField_4.getText();
             
          
           
             
             
 				
 				
 				
 				
 				
 			
 				             
             
             //try{
         	 //if(contact
            	// {
            		// JOptionPane.showMessageDialog(null, "Enter Contact ");
            	// }
           //  }
          //   catch(NumberFormatException e)
           //  {
            	// JOptionPane.sho
           //  }
            
            
            if(serpoor.isSelected()) //|| sergood.isSelected() || servgood.isSelected() || serexc.isSelected())
            {
            	ser = serpoor.getLabel();
            }
            if(sergood.isSelected())
            {
            	ser = sergood.getLabel();
            }
            if(servgood.isSelected())
            {
            	ser = servgood.getLabel();
            }
            if(serexc.isSelected())
            {
            	ser = serexc.getLabel();
            }
            if(bepoor.isSelected())
            {
            	be = bepoor.getLabel();
            }
            if(begood.isSelected())
            {
            	be = begood.getLabel();
            }
            if(bevgood.isSelected())
            {
            	be = bevgood.getLabel();
            }
            if(beexc.isSelected())
            {
            	be = beexc.getLabel();
            }
            if(opoor.isSelected())
            {
            	over = opoor.getLabel();
            }
            if(ogood.isSelected())
            {
            	over = ogood.getLabel();
            }
            if(ovgood.isSelected())
            {
            	over = ovgood.getLabel();
            }
            if(oexc.isSelected())
            {
            	over = oexc.getLabel();
            }
             
            comment  = textArea.getText();
           System.out.println("SFDSFSDF");
           
           if(fid.equals("") || cid.equals("") || contact.equals("") || name.equals("") || address.equals("") || email.equals("") || ser.equals("") || be.equals("") || over.equals("") )
            {
            	JOptionPane.showMessageDialog(null, "ALL FIELDS ARE MANDATORY");
            	textField_1.setText("");
            	textField.setText("");
            	textField_2.setText(""+0);
            	textField_3.setText("");
            	textField_4.setText("");
            	textArea.setText("");
            	textArea1.setText("");
            	bg.clearSelection();
            	b.clearSelection();
            	g.clearSelection();
            	 
            	
            	
            }
           else
           {
           
        	   
            
            try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            Connection conn = null;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","siddharth");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            String q = ("insert into Feedform values(?,?,?,?,?,?,?,?,?,?)");
            PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement(q);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
           try {
			ps.setString(1, fid);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           try {
			ps.setString(2, cid);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           try {
			ps.setString(3, name);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           try {
			ps.setString(4, address);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           try {
			ps.setString(5, email);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           try {
        	   con = Integer.parseInt(contact);

			ps.setInt(6, con);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           try {
			ps.setString(7, ser);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           try {
			ps.setString(8, be);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           try {
			ps.setString(9, over);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           try {
			ps.setString(10, comment);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           try {
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           try {
			conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           
            
           JOptionPane.showMessageDialog(null, "Thank You for Your FeedBack");
           
           
           
            
           }
           
			
			
				
			}
		});
		btnNewButton.setBackground(new Color(210, 180, 140));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(182, 508, 117, 29);
		panel_1.add(btnNewButton);
		
		JLabel lblFeedbackId = new JLabel("Feedback id");
		lblFeedbackId.setBounds(46, 30, 101, 22);
		panel_1.add(lblFeedbackId);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("0");
		textField_2.setColumns(10);
		textField_2.setBounds(182, 30, 134, 22);
		panel_1.add(textField_2);
		
		JLabel lblEmailId = new JLabel("Email id");
		lblEmailId.setBounds(46, 232, 101, 22);
		panel_1.add(lblEmailId);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(182, 229, 134, 22);
		panel_1.add(textField_3);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(46, 276, 101, 22);
		panel_1.add(lblContact);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(182, 273, 134, 22);
		panel_1.add(textField_4);
		
		JButton btnGenerate = new JButton("GENERATE ");
		btnGenerate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			try{
				fid=textField_2.getText();
				f = Integer.parseInt(fid);
				
			  Random random = new Random();
			  f = random.nextInt(10000)+1;
			  textField_2.setText("P&M"+f);
			}
			catch(NumberFormatException g)
			{
				
			}
		

				
			
			

				
				
			}
		});
		btnGenerate.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnGenerate.setBackground(new Color(210, 180, 140));
		btnGenerate.setBounds(384, 28, 151, 29);
		panel_1.add(btnGenerate);
		//j.add(scrollBar);
	}
}
