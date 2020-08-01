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


public class NewCustomer extends JFrame {
    
    Connection conn = null;
	//PreparedStatement pst = null;
	
	private JTextField custIdNumber,custName,custCheckin,custDeposit,custCountry;
        JComboBox custId;
        JRadioButton r1,r2;
        Choice custAvailableRoomNo;
        ButtonGroup custGender;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		NewCustomer frame = new NewCustomer();
		frame.setVisible(true);
				
	}

	public NewCustomer()  {
		
                setBounds(200, 140, 850, 550);
		setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.png"));
                Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(480,10,300,500);
                add(l1);
		
		JLabel heading = new JLabel("NEW CUSTOMER FORM");
		heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		heading.setBounds(118, 11, 260, 53);
		add(heading);
                
                JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 76, 200, 14);
		add(lblId);
                
                custId = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
		 custId .setBounds(271, 73, 150, 20);
		add( custId );
                
                JLabel lblNumber = new JLabel("Number :");
		lblNumber.setBounds(35, 111, 200, 14);
		add(lblNumber);
                
                custIdNumber = new JTextField();
		custIdNumber.setBounds(271, 111, 150, 20);
		add(custIdNumber);
		//t1.setColumns(10);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(35, 151, 200, 14);
		add(lblName);
		
		custName = new JTextField();
		custName.setBounds(271, 151, 150, 20);
		add(custName);
		//t2.setColumns(10);

                
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 191, 200, 14);
		add(lblGender);
                
                r1 = new JRadioButton("Male");
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBackground(Color.WHITE);
                r1.setBounds(271, 191, 80, 12);
                add(r1);
                
                r2 = new JRadioButton("Female");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBackground(Color.WHITE);
                r2.setBounds(350, 191, 100, 12);
		add(r2);
                
                custGender=new ButtonGroup();
                custGender.add(r1);
                custGender.add(r2);
                
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 231, 200, 14);
		add(lblCountry);
		
		JLabel lblReserveRoomNumber = new JLabel("Allocated Room Number :");
		lblReserveRoomNumber.setBounds(35, 274, 200, 14);
		add(lblReserveRoomNumber);
                
                custAvailableRoomNo = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from addRoom");
                    while(rs.next()){
                         custAvailableRoomNo.add(rs.getString("room_number"));    
                    }
                }catch(Exception e){ }
                custAvailableRoomNo.setBounds(271, 274, 150, 20);
		add( custAvailableRoomNo);
		
		JLabel lblCheckInStatus = new JLabel("Checked-In :");
		lblCheckInStatus.setBounds(35, 316, 200, 14);
		add(lblCheckInStatus);
		
		JLabel lblDeposite = new JLabel("Deposit :");
		lblDeposite.setBounds(35, 359, 200, 14);
		add(lblDeposite);
		
		
		
		
		
		custCountry = new JTextField();
		custCountry.setBounds(271, 231, 150, 20);
		add(custCountry);
		//t3.setColumns(10);
		
		
		custCheckin = new JTextField();
		custCheckin.setBounds(271, 316, 150, 20);
		add(custCheckin);
		//t5.setColumns(10);
		
		custDeposit = new JTextField();
		custDeposit.setBounds(271, 359, 150, 20);
		add(custDeposit);
		//t6.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            conn c = new conn();
                            String radio = null;
                            
                            if(r1.isSelected()){ 
                                radio = "Male";
                            }
                            else if(r2.isSelected()){ 
                                radio = "Female";
                            }
                            
                            String s6 = custAvailableRoomNo.getSelectedItem();
                          
                            try{
	    			
                                String s1 = (String)custId.getSelectedItem(); 
	    			String s2 =  custIdNumber.getText();
	    			String s3 =  custName.getText();
                                String s4 =  radio;
	    			String s5 =  custCountry.getText();
	    			String s7 =  custCheckin.getText();
                                String s8 =  custDeposit.getText();
                                
                                String q1 = "insert into addcustomer values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                                String q2 = "update addRoom set room_available = 'Occupied' where room_number = "+s6;
                                c.s.executeUpdate(q1);
                                c.s.executeUpdate(q2);
	    			
	    			
	    			JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                                new Reception().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
		    	catch(NumberFormatException s){
		    		JOptionPane.showMessageDialog(null, "Please enter a valid Number");
			}
			}
		});
		btnAdd.setBounds(100, 430, 120, 30);
                btnAdd.setBackground(Color.BLACK);
                btnAdd.setForeground(Color.WHITE);
		add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            new Reception().setVisible(true);
                            setVisible(false);
			}
		}); 
		btnBack.setBounds(260, 430, 120, 30);
                btnBack.setBackground(Color.BLACK);
                btnBack.setForeground(Color.WHITE);
		add(btnBack);
                
                getContentPane().setBackground(Color.WHITE);
	}
}
