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
public class SearchRoom extends JFrame {
    
Connection conn = null;
	
	ResultSet rs = null;
	
	
	private JTable table;
        Choice bed_type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					SearchRoom frame = new SearchRoom();
					frame.setVisible(true);
				
			
	}
	

	/**
	 * Create the frame.
	 * @throws SQLException
	 */
	public SearchRoom()  {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 140, 700, 500);
		setLayout(null);
		
		JLabel lblSearchForRoom = new JLabel("Search For Room");
		lblSearchForRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchForRoom.setBounds(250, 11, 186, 31);
		add(lblSearchForRoom);
		
		JLabel lblRoomAvailable = new JLabel("Room Bed Type:");
		lblRoomAvailable.setBounds(50, 73, 96, 14);
		add(lblRoomAvailable);
		
		JLabel lblRoomType = new JLabel("Room Number");
		lblRoomType.setBounds(23, 162, 96, 14);
		add(lblRoomType);
		
		JLabel lblRoomAvailable_1 = new JLabel("Availability");
		lblRoomAvailable_1.setBounds(175, 162, 120, 14);
		add(lblRoomAvailable_1);
		
		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setBounds(458, 162, 46, 14);
		add(lblPrice_1);
                
                JLabel lblBedTpe_1 = new JLabel("Bed Type");
		 lblBedTpe_1 .setBounds(580, 162, 96, 14);
		add( lblBedTpe_1 );
		
		JCheckBox checkRoom = new JCheckBox("Only display Available");
		checkRoom.setBounds(400, 69, 205, 23);
                checkRoom.setBackground(Color.WHITE);
		add(checkRoom);
		
		
                bed_type = new Choice();
                 bed_type.add("Single Bed");
                 bed_type.add("Double Bed");
                 bed_type.setBounds(153, 70, 120, 20);
		add( bed_type);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL = "select * from addRoom where room_bedtype = '"+ bed_type.getSelectedItem()+"'";
				String SQL2 = "select * from addRoom where room_available = 'Available' AND room_bedtype = '"+ bed_type.getSelectedItem()+"'";
			try{			
                                conn c = new conn();
				rs = c.s.executeQuery(SQL);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				if(checkRoom.isSelected())
				{	
					rs = c.s.executeQuery(SQL2);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				
				
			}catch (SQLException ss)
			{
				ss.printStackTrace();
			}
			
			}
		});
		btnSearch.setBounds(200, 400, 120, 30);
                btnSearch.setBackground(Color.BLACK);
                btnSearch.setForeground(Color.WHITE);
		add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnBack.setBounds(380, 400, 120, 30);
                btnBack.setBackground(Color.BLACK);
                btnBack.setForeground(Color.WHITE);
		add(btnBack);
		
		table = new JTable();
		table.setBounds(0, 187, 700, 300);
		add(table);
		
		JLabel lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(306, 162, 96, 14);
		add(lblCleanStatus);
                
                getContentPane().setBackground(Color.WHITE);
	}
}
