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
public class UpdateCheckStatus extends JFrame {
    
Connection conn = null;
	
	
	//private JTextField txt_ID;
        private JTextField txt_Room;
	private JTextField txt_Status;
	private JTextField txt_Deposit;
	private JTextField txt_Name;
	private JTextField txt_Payment;

        Choice c1, c2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					UpdateCheckStatus frame = new UpdateCheckStatus();
					frame.setVisible(true);
				
	}
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public UpdateCheckStatus()  {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 140, 950, 500);
		setLayout(null);
		
		JLabel heading = new JLabel("Check-In Details");
		heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		heading.setBounds(124, 11, 222, 25);
		add(heading);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
                JLabel l1 = new JLabel(i1);
                l1.setBounds(450,70,476,270);
                add(l1);
		
		JLabel lblid = new JLabel("ID:");
		lblid.setBounds(25, 88, 46, 14);
		add(lblid);
                
                c1 = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from addCustomer");
                    while(rs.next()){
                        c1.add(rs.getString("Cust_id_Number"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(248, 85, 140, 20);
		add(c1);
		
		JLabel lblNewLabel_1 = new JLabel("Room Number :");
		lblNewLabel_1.setBounds(25, 129, 107, 14);
		add(lblNewLabel_1);
                
                
                txt_Room = new JTextField();
                txt_Room.setBounds(248, 126, 140, 20);
		add(txt_Room);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(25, 174, 97, 14);
		add(lblName);
		
		JLabel lblCheckedIn = new JLabel("Checked-in :");
		lblCheckedIn.setBounds(25, 216, 107, 14);
		add(lblCheckedIn);
		
		JLabel lblAmountPaid = new JLabel("Amount Paid (Rs) : ");
		lblAmountPaid.setBounds(25, 261, 107, 14);
		add(lblAmountPaid);
		
		JLabel lblPendingAmount = new JLabel("Pending Amount (Rs) : ");
		lblPendingAmount.setBounds(25, 302, 150, 14);
		add(lblPendingAmount);

		
		txt_Name = new JTextField();
		txt_Name.setBounds(248, 171, 140, 20);
		add(txt_Name);
		
		
		txt_Status = new JTextField();
		txt_Status.setBounds(248, 216, 140, 20);
		add(txt_Status);
		
		txt_Deposit = new JTextField();
		txt_Deposit.setBounds(248, 258, 140, 20);
		add(txt_Deposit);
		
		
		txt_Payment = new JTextField();
		txt_Payment.setBounds(248, 299, 140, 20);
		add(txt_Payment);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) { 
                            try{
                                conn c = new conn();
                                
                                String s1 = c1.getSelectedItem();
				String s2 = txt_Room.getText(); //room_number;    
                                String s3 = txt_Name.getText(); //name    
                                String s4 = txt_Status.getText(); //status;    
                                String s5 = txt_Deposit.getText(); //deposit    
				
                                c.s.executeUpdate("update addCustomer set Cust_room = '"+s2+"', Cust_Name = '"+s3+"', Cust_status = '"+s4+"', Cust_Deposit = '"+s5+"' where Cust_id_Number = '"+s1+"'");
                                
                                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                                new Reception().setVisible(true);
                                setVisible(false);
                            }catch(Exception ee){
                                System.out.println(ee);
                            }				
				
				
				
			}
		});
		btnUpdate.setBounds(168, 378, 89, 23);
                btnUpdate.setBackground(Color.BLACK);
                btnUpdate.setForeground(Color.WHITE);
		add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		 btnBack .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		 btnBack .setBounds(281, 378, 89, 23);
                btnBack .setBackground(Color.BLACK);
                 btnBack .setForeground(Color.WHITE);
		add( btnBack );
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try{
				String s1 = c1.getSelectedItem();
				conn c = new conn();
                                ResultSet rs1 = c.s.executeQuery("select * from addCustomer where Cust_id_Number = "+s1);
                                
                                while(rs1.next()){
                                    txt_Room.setText(rs1.getString("Cust_Room"));    
                                    txt_Name.setText(rs1.getString("Cust_Name"));    
                                    txt_Status.setText(rs1.getString("Cust_Status"));    
                                    txt_Deposit.setText(rs1.getString("Cust_Deposit"));    
                                }
                            }catch(Exception ee){}
                            
                            try{
                                String total = "";
                                conn c  = new conn();
                                ResultSet rs2 = c.s.executeQuery("select * from addRoom where room_number = "+txt_Room.getText());
                                while(rs2.next()){
                                    total = rs2.getString("room_price"); 
                                    
                                }
                                String paid = txt_Deposit.getText();
                                int pending = Integer.parseInt(total)- Integer.parseInt(paid);
                                
                                txt_Payment.setText(Integer.toString(pending));
                                
                            }catch(Exception ee){}
			}
		});
		btnCheck.setBounds(56, 378, 89, 23);
                btnCheck.setBackground(Color.BLACK);
                btnCheck.setForeground(Color.WHITE);
		add(btnCheck);
                
                getContentPane().setBackground(Color.WHITE);
	}

}
