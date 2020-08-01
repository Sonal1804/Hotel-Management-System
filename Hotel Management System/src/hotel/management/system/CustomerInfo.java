/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

/**
 *
 * @author sayali
 */


import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class CustomerInfo extends JFrame{
    
Connection conn = null;
	
	private JLabel lblId;
	private JLabel lblIdNumber;
        private JLabel lblName;
	private JLabel lblGender;
	private JTable table;
	private JLabel lblCountry;
	private JLabel lblRoomNumber;
	private JLabel lblStatus;
        private JLabel lblDeposit;
	
        


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					CustomerInfo frame = new CustomerInfo();
					frame.setVisible(true);
				
	}
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CustomerInfo() {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 140, 900, 600);
		
		setLayout(null);

		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnBack.setBounds(450, 510, 120, 30);
                btnBack.setBackground(Color.BLACK);
                btnBack.setForeground(Color.WHITE);
		add(btnBack);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
                                    conn c  = new conn();
                                    
				String displayCustomersql = "select * from addCustomer";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
				
			
		});
		btnLoadData.setBounds(300, 510, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		add(btnLoadData);
		
		lblId = new JLabel("ID");
		lblId.setBounds(31, 11, 46, 14);
		add(lblId);
                
                lblIdNumber = new JLabel("Number");
		lblIdNumber .setBounds(150, 11, 46, 14);
		add(lblIdNumber );
		
		lblName = new JLabel("Name");
		lblName.setBounds(270, 11, 65, 14);
		add(lblName);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(360, 11, 46, 14);
		add(lblGender);
		
		table = new JTable();
		table.setBounds(0, 40, 900, 450);
		add(table);
		
		lblCountry = new JLabel("Country");
		lblCountry.setBounds(480, 11, 46, 14);
		add(lblCountry);
		
		lblRoomNumber = new JLabel("Room");
		lblRoomNumber.setBounds(600, 11, 46, 14);
		add(lblRoomNumber);
		
		lblStatus = new JLabel("Check-in Status");
		lblStatus.setBounds(680, 11, 100, 14);
		add(lblStatus);
		
		lblDeposit = new JLabel("Deposit");
		lblDeposit.setBounds(800, 11, 100, 14);
		add(lblDeposit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}
