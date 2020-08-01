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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
public class Room extends JFrame {
    
    Connection conn = null;
	
	private JTable table;
	private JLabel lblAvailability;
	private JLabel lblCleanStatus;
	private JLabel lblPrice;
	private JLabel lblBedType;
	private JLabel lblRoomNumber;
	//private JLabel lblId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	Room room=new Room();
        room.setVisible(true);
				
	}

        
	public Room() {
		//conn = Javaconnect.getDBConnection();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,140, 1100, 600);
		setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
                Image i3 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(500,0,600,600);
                add(l1);
                
		
		table = new JTable();
		table.setBounds(0, 40, 500, 400);
		add(table);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    conn c = new conn();
					String displayCustomersql = "select * from addRoom";
					//PreparedStatement pst = conn.prepareStatement(displayCustomersql);
					ResultSet rs = c.s.executeQuery(displayCustomersql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(100, 470, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		add(btnLoadData);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnBack.setBounds(290, 470, 120, 30);
                btnBack.setBackground(Color.BLACK);
                btnBack.setForeground(Color.WHITE);
		add(btnBack);
		
		lblAvailability = new JLabel("Availability");
		lblAvailability.setBounds(119, 15, 69, 14);
		add(lblAvailability);
		
		lblCleanStatus = new JLabel("Clean Status");
		lblCleanStatus.setBounds(216, 15, 76, 14);
		add(lblCleanStatus);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(330, 15, 46, 14);
		add(lblPrice);
		
		lblBedType= new JLabel("Bed Type");
		lblBedType.setBounds(417, 15, 76, 14);
		add(lblBedType);

		
		lblRoomNumber = new JLabel("Room Number");
		lblRoomNumber.setBounds(12, 15, 90, 14);
		add(lblRoomNumber);
                
               getContentPane().setBackground(Color.WHITE);
	}
    
    
}
