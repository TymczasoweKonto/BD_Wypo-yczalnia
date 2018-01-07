import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpdateClientFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField nameField;
	private static JTextField surnameField;
	private static JTextField emailField;
	private static JTextField phoneField;
	private static JTextField peselField;

	public JTextField getNameField() {
		return nameField;
	}
	public JTextField getSurnameField() {
		return surnameField;
	}
	public JTextField getEmailField() {
		return emailField;
	}
	public JTextField getPhoneField() {
		return phoneField;
	}
	public JTextField getPeselField() {
		return peselField;
	}
	/**
	 * Create the frame.
	 */
	public UpdateClientFrame(JFrame frame) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		    	frame.setEnabled(true);
		    }
		});
		setBounds(100, 100, 502, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Imie");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(109, 11, 56, 23);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Nazwisko");
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setBounds(86, 94, 105, 23);
		contentPane.add(lblSurname);
		
		JLabel lblPesel = new JLabel("PESEL");
		lblPesel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesel.setBounds(86, 177, 105, 23);
		contentPane.add(lblPesel);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(278, 44, 90, 23);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Nr. telefonu");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setBounds(252, 140, 149, 23);
		contentPane.add(lblPhone);
		
		peselField = new JTextField();
		peselField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					int row = Application.getClientsTable().getSelectedRow();
					lblName.setForeground(Color.BLACK);
					lblPesel.setForeground(Color.BLACK);
					lblPhone.setForeground(Color.BLACK);
					lblSurname.setForeground(Color.BLACK);
					
					boolean correctData = true;
					
					if (nameField.getText().trim().compareTo("") == 0) { lblName.setForeground(Color.RED); correctData = false; }
					if (peselField.getText().trim().compareTo("") == 0) { lblPesel.setForeground(Color.RED); correctData = false; }
					if (phoneField.getText().trim().compareTo("") == 0) { lblPhone.setForeground(Color.RED); correctData = false; }
					if (surnameField.getText().trim().compareTo("") == 0) { lblSurname.setForeground(Color.RED); correctData = false; }
					try {
						if (correctData) {
							Application.functions.updateClient(Application.getClientsTable().getValueAt(row, 0).toString(), nameField.getText(),
									surnameField.getText(), peselField.getText(), emailField.getText(), phoneField.getText());
								
								
	
									ArrayList<String> resp =Application.functions.getTableContent("KLIENCI");
									String col[] = {"ID Klienta", "Imie", "Nazwisko", "PESEL", "E-mail", "Nr. telefonu"};
									DefaultTableModel tableModel = new DefaultTableModel(col, 0);
									
									Application.getClientsTable().setModel(tableModel);
									
									
									for (int i = 0; i < resp.size(); i++) {
										String[] data = resp.get(i).split("\t");
										tableModel.addRow(data);
									}
								
	
								
								frame.setEnabled(true);
								dispose();
						}
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Wyst�pi� b��d, operacja nie powiod�a si�!");
					}
				}
			}
		});
		peselField.setColumns(10);
		peselField.setBounds(86, 208, 105, 38);
		contentPane.add(peselField);
		
		nameField = new JTextField();
		nameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					int row = Application.getClientsTable().getSelectedRow();
					lblName.setForeground(Color.BLACK);
					lblPesel.setForeground(Color.BLACK);
					lblPhone.setForeground(Color.BLACK);
					lblSurname.setForeground(Color.BLACK);
					
					boolean correctData = true;
					
					if (nameField.getText().trim().compareTo("") == 0) { lblName.setForeground(Color.RED); correctData = false; }
					if (peselField.getText().trim().compareTo("") == 0) { lblPesel.setForeground(Color.RED); correctData = false; }
					if (phoneField.getText().trim().compareTo("") == 0) { lblPhone.setForeground(Color.RED); correctData = false; }
					if (surnameField.getText().trim().compareTo("") == 0) { lblSurname.setForeground(Color.RED); correctData = false; }
					try {
						if (correctData) {
							Application.functions.updateClient(Application.getClientsTable().getValueAt(row, 0).toString(), nameField.getText(),
									surnameField.getText(), peselField.getText(), emailField.getText(), phoneField.getText());
								
								
	
							ArrayList<String> resp =Application.functions.getTableContent("KLIENCI");
									String col[] = {"ID Klienta", "Imie", "Nazwisko", "PESEL", "E-mail", "Nr. telefonu"};
									DefaultTableModel tableModel = new DefaultTableModel(col, 0);
									
									Application.getClientsTable().setModel(tableModel);
									
									
									for (int i = 0; i < resp.size(); i++) {
										String[] data = resp.get(i).split("\t");
										tableModel.addRow(data);
									}
								
	
								
								frame.setEnabled(true);
								dispose();
						}
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Wyst�pi� b��d, operacja nie powiod�a si�!");
					}
				}
			}
		});
		nameField.setColumns(10);
		nameField.setBounds(86, 44, 105, 38);
		contentPane.add(nameField);
		
		surnameField = new JTextField();
		surnameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					int row = Application.getClientsTable().getSelectedRow();
					lblName.setForeground(Color.BLACK);
					lblPesel.setForeground(Color.BLACK);
					lblPhone.setForeground(Color.BLACK);
					lblSurname.setForeground(Color.BLACK);
					
					boolean correctData = true;
					
					if (nameField.getText().trim().compareTo("") == 0) { lblName.setForeground(Color.RED); correctData = false; }
					if (peselField.getText().trim().compareTo("") == 0) { lblPesel.setForeground(Color.RED); correctData = false; }
					if (phoneField.getText().trim().compareTo("") == 0) { lblPhone.setForeground(Color.RED); correctData = false; }
					if (surnameField.getText().trim().compareTo("") == 0) { lblSurname.setForeground(Color.RED); correctData = false; }
					try {
						if (correctData) {
							Application.functions.updateClient(Application.getClientsTable().getValueAt(row, 0).toString(), nameField.getText(),
									surnameField.getText(), peselField.getText(), emailField.getText(), phoneField.getText());
								
								
	
							ArrayList<String> resp =Application.functions.getTableContent("KLIENCI");
									String col[] = {"ID Klienta", "Imie", "Nazwisko", "PESEL", "E-mail", "Nr. telefonu"};
									DefaultTableModel tableModel = new DefaultTableModel(col, 0);
									
									Application.getClientsTable().setModel(tableModel);
									
									
									for (int i = 0; i < resp.size(); i++) {
										String[] data = resp.get(i).split("\t");
										tableModel.addRow(data);
									}
								
	
								
								frame.setEnabled(true);
								dispose();
						}
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Wyst�pi� b��d, operacja nie powiod�a si�!");
					}
				}
			}
		});
		surnameField.setColumns(10);
		surnameField.setBounds(86, 128, 105, 38);
		contentPane.add(surnameField);
		
		emailField = new JTextField();
		emailField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					int row = Application.getClientsTable().getSelectedRow();
					lblName.setForeground(Color.BLACK);
					lblPesel.setForeground(Color.BLACK);
					lblPhone.setForeground(Color.BLACK);
					lblSurname.setForeground(Color.BLACK);
					
					boolean correctData = true;
					
					if (nameField.getText().trim().compareTo("") == 0) { lblName.setForeground(Color.RED); correctData = false; }
					if (peselField.getText().trim().compareTo("") == 0) { lblPesel.setForeground(Color.RED); correctData = false; }
					if (phoneField.getText().trim().compareTo("") == 0) { lblPhone.setForeground(Color.RED); correctData = false; }
					if (surnameField.getText().trim().compareTo("") == 0) { lblSurname.setForeground(Color.RED); correctData = false; }
					try {
						if (correctData) {
								Application.functions.updateClient(Application.getClientsTable().getValueAt(row, 0).toString(), nameField.getText(),
															surnameField.getText(), peselField.getText(), emailField.getText(), phoneField.getText());
								
								
	
								ArrayList<String> resp =Application.functions.getTableContent("KLIENCI");
									String col[] = {"ID Klienta", "Imie", "Nazwisko", "PESEL", "E-mail", "Nr. telefonu"};
									DefaultTableModel tableModel = new DefaultTableModel(col, 0);
									
									Application.getClientsTable().setModel(tableModel);
									
									
									for (int i = 0; i < resp.size(); i++) {
										String[] data = resp.get(i).split("\t");
										tableModel.addRow(data);
									}
								
	
								
								frame.setEnabled(true);
								dispose();
						}
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Wyst�pi� b��d, operacja nie powiod�a si�!");
					}
				}
			}
		});
		emailField.setColumns(10);
		emailField.setBounds(252, 78, 149, 38);
		contentPane.add(emailField);
		
		phoneField = new JTextField();
		phoneField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					int row = Application.getClientsTable().getSelectedRow();
					lblName.setForeground(Color.BLACK);
					lblPesel.setForeground(Color.BLACK);
					lblPhone.setForeground(Color.BLACK);
					lblSurname.setForeground(Color.BLACK);
					
					boolean correctData = true;
					
					if (nameField.getText().trim().compareTo("") == 0) { lblName.setForeground(Color.RED); correctData = false; }
					if (peselField.getText().trim().compareTo("") == 0) { lblPesel.setForeground(Color.RED); correctData = false; }
					if (phoneField.getText().trim().compareTo("") == 0) { lblPhone.setForeground(Color.RED); correctData = false; }
					if (surnameField.getText().trim().compareTo("") == 0) { lblSurname.setForeground(Color.RED); correctData = false; }
					try {
						if (correctData) {
								Application.functions.updateClient(Application.getClientsTable().getValueAt(row, 0).toString(), nameField.getText(),
															surnameField.getText(), peselField.getText(), emailField.getText(), phoneField.getText());
								
								
	
								ArrayList<String> resp =Application.functions.getTableContent("KLIENCI");
									String col[] = {"ID Klienta", "Imie", "Nazwisko", "PESEL", "E-mail", "Nr. telefonu"};
									DefaultTableModel tableModel = new DefaultTableModel(col, 0);
									
									Application.getClientsTable().setModel(tableModel);
									
									
									for (int i = 0; i < resp.size(); i++) {
										String[] data = resp.get(i).split("\t");
										tableModel.addRow(data);
									}
								
	
								
								frame.setEnabled(true);
								dispose();
						}
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Wyst�pi� b��d, operacja nie powiod�a si�!");
					}
				}
			}
		});
		phoneField.setColumns(10);
		phoneField.setBounds(252, 172, 149, 38);
		contentPane.add(phoneField);
		
		JButton btnBack = new JButton("Wr\u00F3\u0107");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setEnabled(true);
				setVisible(false);
				dispose();
			}
		});
		btnBack.setBounds(10, 281, 105, 29);
		contentPane.add(btnBack);
		
		JButton btnUpdate = new JButton("Aktualizuj");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = Application.getClientsTable().getSelectedRow();
				lblName.setForeground(Color.BLACK);
				lblPesel.setForeground(Color.BLACK);
				lblPhone.setForeground(Color.BLACK);
				lblSurname.setForeground(Color.BLACK);
				
				boolean correctData = true;
				
				if (nameField.getText().trim().compareTo("") == 0) { lblName.setForeground(Color.RED); correctData = false; }
				if (peselField.getText().trim().compareTo("") == 0) { lblPesel.setForeground(Color.RED); correctData = false; }
				if (phoneField.getText().trim().compareTo("") == 0) { lblPhone.setForeground(Color.RED); correctData = false; }
				if (surnameField.getText().trim().compareTo("") == 0) { lblSurname.setForeground(Color.RED); correctData = false; }
				try {
					if (correctData) {
							Application.functions.updateClient(Application.getClientsTable().getValueAt(row, 0).toString(), nameField.getText(),
														surnameField.getText(), peselField.getText(), emailField.getText(), phoneField.getText());
							
							

							ArrayList<String> resp =Application.functions.getTableContent("KLIENCI");
								String col[] = {"ID Klienta", "Imie", "Nazwisko", "PESEL", "E-mail", "Nr. telefonu"};
								DefaultTableModel tableModel = new DefaultTableModel(col, 0);
								
								Application.getClientsTable().setModel(tableModel);
								
								
								for (int i = 0; i < resp.size(); i++) {
									String[] data = resp.get(i).split("\t");
									tableModel.addRow(data);
								}
							

							
							frame.setEnabled(true);
							dispose();
					}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Wyst�pi� b��d, operacja nie powiod�a si�!");
				}
			}
		});
		btnUpdate.setBounds(344, 281, 132, 29);
		contentPane.add(btnUpdate);
	}
}
