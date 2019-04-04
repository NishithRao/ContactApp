import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class contactApp extends DatabaseConnect {

	private JFrame frmContactBook;
	private JPanel contact;
	private JPanel add;
	private JPanel d;
		
	Statement st = null;
	Statement st1 = null;
			
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField txtWelcomeToContact;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					contactApp window = new contactApp();
					window.frmContactBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public contactApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmContactBook = new JFrame();
		frmContactBook.setResizable(false);
		frmContactBook.getContentPane().setForeground(Color.BLACK);
		frmContactBook.setBackground(Color.WHITE);
		frmContactBook.setTitle("Contact Book");
		frmContactBook.setBounds(100, 100, 559, 411);
		frmContactBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmContactBook.getContentPane().setLayout(new CardLayout(0, 0));
		
				
		JPanel contact = new JPanel();
		frmContactBook.getContentPane().add(contact, "name_17682430698010");
		contact.setVisible(true);
		
		JPanel add = new JPanel();
		frmContactBook.getContentPane().add(add, "name_17684775412426");
		add.setLayout(null);
		add.setVisible(false);
		
		
		JPanel delete = new JPanel();
		delete.setBackground(Color.WHITE);
		delete.setForeground(Color.BLACK);
		frmContactBook.getContentPane().add(delete, "name_17687378825643");
		
		textField_10 = new JTextField();
		textField_10.setBounds(299, 52, 157, 32);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Enter Contact ID");
		lblNewLabel_10.setBounds(111, 50, 146, 32);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnNewButton_5 = new JButton("Delete");
		btnNewButton_5.setBounds(197, 95, 132, 32);
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DatabaseConnect db = new DatabaseConnect();
				db.connectDB();
				try {
					
				st = db.conn1.createStatement();
				int bp = JOptionPane.showConfirmDialog(frmContactBook, "Do you want to delete the record ?");
				if (bp == JOptionPane.YES_OPTION) {
					
					if (textField_10.getText().length() > 4)
					{
						JOptionPane.showMessageDialog(frmContactBook, "Unknown ID");
						delete.setVisible(true);
					}
					else if (textField_10.getText().length() == 0)
					{
						JOptionPane.showMessageDialog(frmContactBook, "Please enter an ID");
						delete.setVisible(true);
					}
					else {
					
					String query = "delete from date where Contact_Id = "+textField_10.getText().trim()+";"; 	
					st.executeUpdate(query);
					
					String query1 = "delete from phone where Contact_Id = "+textField_10.getText().trim()+";";
					st.executeUpdate(query1);
				
					String query2 = "delete from address where Contact_Id = "+textField_10.getText().trim()+";";
					st.executeUpdate(query2);
					
					String query3 = "delete from contactname where Contact_Id = "+textField_10.getText().trim()+";";
					int count = st.executeUpdate(query3);	
					
					if (count == 0) {
						JOptionPane.showMessageDialog(frmContactBook, "Entry not found");
					}
					else {
						JOptionPane.showMessageDialog(frmContactBook, "Deleted Successfully!");
					}
					}					
				}
				else if (bp == JOptionPane.CANCEL_OPTION || bp == JOptionPane.NO_OPTION) {
					delete.setVisible(true);
				}				
				
			}
            catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
                System.exit(1);
            }
			catch (Exception e1) {
		    JOptionPane.showMessageDialog(frmContactBook, "Error!");
			}
		  }
				
				
					
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton button = new JButton("Back");
		button.setBounds(394, 327, 132, 32);
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete.setVisible(false);
				contact.setVisible(true);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_11 = new JLabel("DELETE");
		lblNewLabel_11.setBounds(26, 11, 87, 55);
		delete.setLayout(null);
		delete.add(textField_10);
		delete.add(lblNewLabel_10);
		delete.add(btnNewButton_5);
		delete.add(button);
		delete.add(lblNewLabel_11);
		delete.setVisible(false);
		contact.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(184, 18, 145, 22);
		contact.add(textArea);
		
		
		JLabel lblEnterTheSearch = new JLabel("Enter the search text");
		lblEnterTheSearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEnterTheSearch.setBounds(18, 11, 156, 39);
		contact.add(lblEnterTheSearch);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 15));

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(298, 226, 132, 20);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(339, 18, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseConnect db = new DatabaseConnect();
				db.connectDB();
				
				if(textArea.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Text");
				}
				else {
				
				try {
					st = db.conn1.createStatement();
					int i = 0;												
					String test ="";
					String Text = textArea.getText().trim();
					
					String query = "select distinct contactname.* from contactname left join address on contactname.Contact_Id=address.Contact_Id  left join phone on contactname.Contact_Id = phone.Contact_Id left join date on contactname.Contact_Id = date.Contact_Id\r\n" + 
							"where (contactname.Contact_Id like '%"+Text+"%' or Address like '%"+Text+"%' or City like '%"+Text+"%' or State like '%"+Text+"%' or Zip like '%"+Text+"%' or Fname like '%"+Text+"%' or Mname like '%"+Text+"%' or Lname like '%"+Text+"%' or area_code like '%"+Text+"%' or number like '%"+Text+"%' or Date like '%"+Text+"%' or concat(area_code,'',number) like '%"+Text+"%');";
					
					ResultSet rs1 = st.executeQuery(query);
										
					while (rs1.next())
					  {
						
						String contact_id = ("---------------------------------------------------------------------------"+"\r\n"+"Contact ID :"+rs1.getString("Contact_Id")+"\r\n");
						String firstName = ("First name :"+rs1.getString("Fname")+"\r\n");
						String Lname = ("Last name :"+rs1.getString("Lname")+"\r\n");
						String Mname = ("Middle name :"+rs1.getString("Mname")+"\r\n");

						test = test + contact_id + firstName + Mname + Lname;
						System.out.format("%s\n", firstName);
						i++;
					  }
					textArea_1.setText(test);
					if (i == 0) {
		                Component obj = null;
						JOptionPane.showMessageDialog(obj, "No Result Found");
		           	}
					}
					
					catch (SQLException ex) {
						System.out.println("An error occurred. Maybe user/password is invalid");
						ex.printStackTrace();
		        }
				    catch (Exception e1) {
				    	System.err.println("Got an exception!");
				        System.err.println(e1.getMessage());
				    }
				}
			}
		});
		contact.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(99, 51, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				dateChooser.setCalendar(null);
				contact.setVisible(false);
				add.setVisible(true);
				delete.setVisible(false);
			}
		});
		contact.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contact.setVisible(false);
				add.setVisible(false);
				delete.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBounds(339, 51, 108, 23);
		contact.add(btnNewButton_2);
		
		txtWelcomeToContact = new JTextField();
		txtWelcomeToContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtWelcomeToContact.setBounds(18, 114, 497, 33);
		contact.add(txtWelcomeToContact);
		txtWelcomeToContact.setColumns(10);
		txtWelcomeToContact.setText("                          Welcome to Contact Book! :)");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 158, 497, 203);
		contact.add(scrollPane);
		
		scrollPane.setViewportView(textArea_1);
		textArea_1.setEditable(false);
		
	    txtWelcomeToContact.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	            txtWelcomeToContact.setText("");
	        }

			@Override
			public void focusLost(FocusEvent e) {	
				txtWelcomeToContact.setText("Welcome to Contact Book!");
			}
	    });

		JCheckBox chckbxNewCheckBox = new JCheckBox("home");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox.setBounds(116, 95, 58, 23);
		add.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("work");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox_1.setBounds(176, 95, 58, 23);
		add.add(chckbxNewCheckBox_1);
		
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("home");
		chckbxNewCheckBox_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox_3.setBounds(122, 196, 58, 23);
		add.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("work");
		chckbxNewCheckBox_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox_4.setBounds(193, 196, 58, 23);
		add.add(chckbxNewCheckBox_4);
		
		JLabel lblNewLabel = new JLabel("Address type");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(35, 99, 81, 14);
		add.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Add");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DatabaseConnect db = new DatabaseConnect();
				db.connectDB();
								
				String address_type = null;
				int contact_id = 0;
				String phone_type = null;
				String address = null;
				String state = null;
				String city = null;
				String zip = null;
				String area_code,number = null;	
				
				if(textField.getText().isEmpty() | textField_1.getText().isEmpty() | textField_2.getText().isEmpty() | textField_3.getText().isEmpty() | textField_4.getText().isEmpty() | textField_5.getText().isEmpty() | textField_6.getText().isEmpty() | textField_8.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fill all the required fields");
					add.setVisible(true);
					contact.setVisible(false);
				}
				else {
					try {
					
						st = db.conn1.createStatement();
						SimpleDateFormat sdf = new SimpleDateFormat("MM//dd//yyyy");
						String date = sdf.format(dateChooser.getDate());
					
						String query = "Insert into contactname (Contact_Id, Fname, Mname, Lname) values(NULL,'" + textField_6.getText().trim()+ "','" + textField_7.getText().trim() + "','" + textField_8.getText().trim()+ "');";
						String query1 = "select * from contactname where Fname ='"+textField_6.getText().trim()+ "' AND Mname = '"+textField_7.getText().trim()+ "' AND Lname = '"+textField_8.getText().trim()+"';";
						
							
						if (chckbxNewCheckBox.isSelected()) {
							System.out.println("Entered home");
							address_type = "home";
							address = textField.getText().trim();
							state = textField_1.getText().trim();
							city = textField_2.getText().trim();
							zip = textField_3.getText().trim();
						}
						else if (chckbxNewCheckBox_1.isSelected()) {
							address_type = "work";
							address = textField.getText().trim();
							state = textField_1.getText().trim();
							city = textField_2.getText().trim();
							zip = textField_3.getText().trim();
						}
						
						if (chckbxNewCheckBox_3.isSelected()) {
							System.out.println("Entered home1");
							phone_type = "home";
							area_code = textField_4.getText().trim();
							number = textField_5.getText().trim();
						}
						else if (chckbxNewCheckBox_4.isSelected()) {
							phone_type = "work";
							area_code = textField_4.getText().trim();
							number = textField_5.getText().trim();
						}

						st.executeUpdate(query);
						ResultSet rs = st.executeQuery(query1);
						
						while(rs.next()) {
							contact_id = rs.getInt("Contact_Id");
							System.out.println(contact_id);
						}
						String query2 = "Insert into phone (Contact_Id, phone_type, area_code, number) values ('"+contact_id+"', '"+phone_type+"', '"+textField_4.getText().trim()+"', "+textField_5.getText().trim()+");";
						String query3 = "Insert into address (Contact_Id, Address_Type, Address, City, State, Zip) values ('"+contact_id+"', '"+address_type+"', '"+textField.getText().trim()+"', '"+textField_1.getText().trim()+"', '"+textField_2.getText().trim()+"', '"+textField_3.getText().trim()+"');";
						String query4 = "Insert into date (Contact_Id,date_type,Date) values ('"+contact_id+"', 'birth','"+date+"');";
						
						st.executeUpdate(query2);
						st.executeUpdate(query3);
						st.executeUpdate(query4);
							
						txtWelcomeToContact.setText("Entry added succesfully");
						add.setVisible(false);
						contact.setVisible(true);
										
				}
				catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error!");
					e1.printStackTrace();
				}	
			}
			}
		});
		btnNewButton_3.setBounds(151, 304, 100, 30);
		add.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Type of number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(26, 200, 90, 14);
		add.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(20, 125, 96, 20);
		add.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 125, 83, 20);
		add.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(258, 125, 83, 20);
		add.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Street");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(51, 147, 56, 14);
		add.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("state");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(280, 147, 35, 14);
		add.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("zipcode");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(395, 147, 48, 14);
		add.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(370, 125, 96, 20);
		add.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("City");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(172, 147, 48, 14);
		add.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(20, 225, 66, 20);
		add.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(122, 226, 144, 20);
		add.add(textField_5);
		
		JLabel lblNewLabel_6 = new JLabel("Area code");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(26, 245, 67, 14);
		add.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Number");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(176, 245, 48, 14);
		add.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(20, 48, 96, 20);
		add.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(151, 48, 96, 20);
		add.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(280, 48, 96, 20);
		add.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("First name");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(35, 34, 72, 14);
		add.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Middle name");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(156, 34, 95, 14);
		add.add(lblNewLabel_9);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastName.setBounds(298, 34, 78, 14);
		add.add(lblLastName);
		
		add.add(dateChooser);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(348, 245, 48, 14);
		add.add(lblDate);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add.setVisible(false);
				contact.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(276, 304, 100, 30);
		add.add(btnNewButton_4);
		
	}
}