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

import java.sql.*;	
import java.awt.event.*;
import java.awt.*;
public class Reception extends JFrame{
    

	public static void main(String[] args) {
		new Reception();
	}
	
	public Reception(){
		
               // setBounds(530, 200, 850, 570);
               setBounds(300,140,850,570);
	
		
		setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fourth.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(250,30,500,470);
                add(l1);
		
		JButton btnNewCustomerForm = new JButton("New Customer Form");
		btnNewCustomerForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				NewCustomer custom = new NewCustomer();
				custom.setVisible(true);
                                setVisible(false);
			}catch(Exception e1){
				e1.printStackTrace();
			}
			}
		});
		btnNewCustomerForm.setBounds(10, 30, 200, 30);
                btnNewCustomerForm.setBackground(Color.BLACK);
                btnNewCustomerForm.setForeground(Color.WHITE);
		add(btnNewCustomerForm);
		
		JButton btnRoom = new JButton("Room");
		btnRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				Room room = new Room();
				room.setVisible(true);
                                setVisible(false);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});
		btnRoom.setBounds(10, 70, 200, 30);
                btnRoom.setBackground(Color.BLACK);
                btnRoom.setForeground(Color.WHITE);

		add(btnRoom);
		
		/*JButton btnDepartment = new JButton("Department");
		btnDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*try{
					Department dept = new Department();
					dept.setVisible(true);
					setVisible(false);
					
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			
			}
		});
		btnDepartment.setBounds(10, 110, 200, 30);
               btnDepartment.setBackground(Color.BLACK);
               btnDepartment.setForeground(Color.WHITE);

		add(btnDepartment);*/
		
		JButton btnAllEmpInfo = new JButton("All Employee Info");
		btnAllEmpInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				
					AllEmployeeInfo em = new AllEmployeeInfo();
					em.setVisible(true);
					setVisible(false);
					
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			
			}
		});
                btnAllEmpInfo.setBounds(10, 110, 200, 30);
		               
                btnAllEmpInfo.setBackground(Color.BLACK);
                btnAllEmpInfo.setForeground(Color.WHITE);

		add(btnAllEmpInfo);
		
		JButton btnCustomerInfo = new JButton("Customer Info");
		btnCustomerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//error ---------------------
					CustomerInfo customer = new CustomerInfo();
					customer.setVisible(true);				
					setVisible(false);
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
                btnCustomerInfo.setBounds(10, 150, 200, 30);
		
                btnCustomerInfo.setBackground(Color.BLACK);
             btnCustomerInfo.setForeground(Color.WHITE);

		add(btnCustomerInfo);
		
		JButton btnManagerInfo = new JButton("Manager Info");
		btnManagerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				ManagerInfo mana = new ManagerInfo();
				mana.setVisible(true);
                                setVisible(false);
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
                btnManagerInfo.setBounds(10, 190, 200, 30);
		
                btnManagerInfo.setBackground(Color.BLACK);
                btnManagerInfo.setForeground(Color.WHITE);

		add(btnManagerInfo);
		
		JButton btnNewCheckOut = new JButton("Check Out");
		btnNewCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
                                  CheckOut frame = new CheckOut();
					frame.setVisible(true);

                                        setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
                btnNewCheckOut.setBounds(10, 230, 200, 30);
		
              btnNewCheckOut.setBackground(Color.BLACK);
                btnNewCheckOut.setForeground(Color.WHITE);

		add(btnNewCheckOut);
		
		JButton btnUpdateCheckStatus = new JButton("Update Check Status");
		btnUpdateCheckStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				UpdateCheckStatus update = new UpdateCheckStatus();
				update.setVisible(true);
                                setVisible(false);
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
                btnUpdateCheckStatus.setBounds(10, 270, 200, 30);
		
               btnUpdateCheckStatus.setBackground(Color.BLACK);
                btnUpdateCheckStatus.setForeground(Color.WHITE);

		add(btnUpdateCheckStatus);
		
		JButton btnUpdateRoomStatus = new JButton("Update Room Status");
		btnUpdateRoomStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					UpdateRoomStatus room = new UpdateRoomStatus();
					room.setVisible(true);
                                        setVisible(false);
				}catch(Exception s)
				{
					s.printStackTrace();
				}
			}
		});
                btnUpdateRoomStatus.setBounds(10, 310, 200, 30);
		
                btnUpdateRoomStatus.setBackground(Color.BLACK);
               btnUpdateRoomStatus.setForeground(Color.WHITE);

		add(btnUpdateRoomStatus);
		
		JButton btnPickUpSerice = new JButton("Pick up Service");
		btnPickUpSerice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				PickUp pick = new PickUp();
				pick.setVisible(true);
                                setVisible(false);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
                btnPickUpSerice.setBounds(10, 350, 200, 30);
		
                btnPickUpSerice.setBackground(Color.BLACK);
                btnPickUpSerice.setForeground(Color.WHITE);

		add(btnPickUpSerice);
		
		JButton btnSearchRoom = new JButton("Search Room");
		btnSearchRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				SearchRoom search = new SearchRoom();
				search.setVisible(true);
                                setVisible(false);
				}
				catch (Exception ss){
					ss.printStackTrace();
				}
			}
		});
                btnSearchRoom.setBounds(10, 390, 200, 30);
		
                btnSearchRoom.setBackground(Color.BLACK);
                btnSearchRoom.setForeground(Color.WHITE);

		add(btnSearchRoom);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
                                   // new Dashboard().setVisible(true);
                                    setVisible(false);
                                    
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
                btnLogOut.setBounds(10, 430, 200, 30);
		
                btnLogOut.setBackground(Color.BLACK);
                btnLogOut.setForeground(Color.WHITE);

		add(btnLogOut);
                getContentPane().setBackground(Color.WHITE);
                
                setVisible(true);
	}
}

