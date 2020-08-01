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
import java.sql.*;
public class CheckOut extends JFrame {
    
Connection conn = null;
	
	
	private JTextField room_number;
        Choice cust_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					CheckOut frame = new CheckOut();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CheckOut() {
		//conn = Javaconnect.getDBConnection();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(230,140, 800, 294);
		setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
                Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(300,0,500,225);
                add(l1);
		
		JLabel lblCheckOut = new JLabel("Check Out ");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckOut.setBounds(70, 11, 140, 35);
		add(lblCheckOut);
		
		JLabel lblName = new JLabel("Number :");
		lblName.setBounds(20, 85, 80, 14);
		add(lblName);
                
                cust_id = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from addCustomer");
                    while(rs.next()){
                        cust_id.add(rs.getString("Cust_id_Number"));    
                    }
                }catch(Exception e){ }
                cust_id.setBounds(130, 82, 150, 20);
		add(cust_id);
                
                ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
                Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
                ImageIcon i6 = new ImageIcon(i5);
                JButton btnCheck = new JButton(i6);
                btnCheck.setBounds(290,82,20,20);
                add(btnCheck);
                
                btnCheck.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent ae){
                        System.out.println("Hi");
                        try{
                            
                            conn c = new conn();
                            String number = cust_id.getSelectedItem();
                            ResultSet rs = c.s.executeQuery("select * from addCustomer where Cust_id_Number = "+number);
                            
                            if(rs.next()){
                                System.out.println("clicked");
                                room_number.setText(rs.getString("Cust_Room"));    
                            }
                        }catch(Exception e){ }
                    }
                });

		
		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(20, 132, 86, 20);
		add(lblRoomNumber);
		
		room_number = new JTextField();
                room_number.setBounds(130, 132, 150, 20);
		add(room_number);
                
                
                
                
                
		
                
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                                String id = cust_id.getSelectedItem();
                                String s1 = room_number.getText();
				String deleteSQL = "Delete from addCustomer where cust_id_Number = "+id;
                                String q2 = "update addRoom set room_available = 'Available' where room_number = "+s1;
                                
                                
				conn c = new conn();

	    		try{
	    			
	    			
	    			c.s.executeUpdate(deleteSQL);
	    			c.s.executeUpdate(q2);
	    			JOptionPane.showMessageDialog(null, "Check Out Successful");
	    			new Reception().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
			}
		});
		btnCheckOut.setBounds(50, 200, 100, 25);
                btnCheckOut.setBackground(Color.BLACK);
                btnCheckOut.setForeground(Color.WHITE);
		add(btnCheckOut);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnBack.setBounds(160, 200, 100, 25);
                btnBack.setBackground(Color.BLACK);
                btnBack.setForeground(Color.WHITE);
		add(btnBack);
                
                
                getContentPane().setBackground(Color.WHITE);
	}
}
