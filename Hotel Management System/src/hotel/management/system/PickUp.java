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
public class PickUp extends JFrame{
    
Connection conn = null;
	
	ResultSet rs = null;
	
	private JTable table;
        Choice c_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					PickUp frame = new PickUp();
					frame.setVisible(true);
				
	}
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PickUp() {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
		setBounds(260, 140, 800, 600);
		setLayout(null);
		
		JLabel lblPickUpService = new JLabel("Pick Up Service");
		lblPickUpService.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPickUpService.setBounds(90, 11, 158, 25);
		add(lblPickUpService);
		
		JLabel lblTypeOfCar = new JLabel("Type of Car");
		lblTypeOfCar.setBounds(32, 97, 89, 14);
		add(lblTypeOfCar);

		
                c_name = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from addDriver");
                    while(rs.next()){
                        c_name.add(rs.getString("car_Company"));    
                    }
                }catch(Exception e){ }
                c_name.setBounds(123, 94, 150, 25);
		add(c_name);

                
		
		JLabel lblInfo = new JLabel("Name");
		lblInfo.setBounds(24, 208, 46, 14);
		add(lblInfo);
		
		JButton btnDisplay = new JButton("Display");
		 btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String SQL = "select * from addDriver where car_Company = '"+c_name.getSelectedItem()+"'";
				try{
				
					conn c = new conn();
					rs = c.s.executeQuery(SQL);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
				}catch (SQLException ss)
				{
					ss.printStackTrace();
				}
				
				
			}
		});
		 btnDisplay.setBounds(200, 500, 120, 30);
                 btnDisplay.setBackground(Color.BLACK);
              btnDisplay.setForeground(Color.WHITE);
		add( btnDisplay);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnBack.setBounds(420, 500, 120, 30);
                btnBack.setBackground(Color.BLACK);
                btnBack.setForeground(Color.WHITE);
		add(btnBack);
		
		table = new JTable();
		table.setBounds(0, 233, 800, 250);
                add(table);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(220, 208, 46, 14);
		add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(350, 208, 46, 14);
		add(lblGender);
		
		JLabel lblCar_Compnay = new JLabel("Company");
		lblCar_Compnay .setBounds(550, 208, 80, 14);
		add(lblCar_Compnay );
		
		
	
		JLabel lblAvailable= new JLabel("Available");
		lblAvailable.setBounds(650, 208, 86, 14);
		add(lblAvailable);
		
		
                
                
                getContentPane().setBackground(Color.WHITE);
	}
}
