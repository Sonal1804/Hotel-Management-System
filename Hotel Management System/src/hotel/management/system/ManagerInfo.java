/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author sayali
 */
public class ManagerInfo extends JFrame {
    
Connection conn = null;
	
	private JTable table;
//	private JLabel lblNewLabel;
//	private JLabel lblJob;
//	private JLabel lblName;
//	private JLabel lblDepartment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					ManagerInfo frame = new ManagerInfo();
					frame.setVisible(true);
				
	}
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ManagerInfo() {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 140, 1010, 600);
		
		
		
		setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 34, 1000, 450);
		add(table);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    conn c = new conn();
				String displayCustomersql = "select * from addEmployee where empjob='Manager'";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
			
		});
		btnLoadData.setBounds(350, 500, 120, 30);
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
		btnBack.setBounds(510, 500, 120, 30);
                btnBack.setBackground(Color.BLACK);
                btnBack.setForeground(Color.WHITE);
                add(btnBack);
		
		JLabel name= new JLabel("Name");
		name.setBounds(41, 11, 46, 14);
		add(name);
		
		JLabel age = new JLabel("Age");
		age.setBounds(159, 11, 46, 14);
		add(age);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(273, 11, 46, 14);
		add(gender);
		
		JLabel job = new JLabel("Job");
		job.setBounds(416, 11, 86, 14);
		add(job);
                
                JLabel salary = new JLabel("Salary");
		salary.setBounds(536, 11, 86, 14);
		add(salary);
                
                JLabel phone = new JLabel("Phone");
		phone.setBounds(656, 11, 86, 14);
		add(phone);
                
                JLabel aadhar = new JLabel("Aadhar");
		aadhar.setBounds(786, 11, 86, 14);
		add(aadhar);
                
                JLabel gmail = new JLabel("Gmail");
		gmail.setBounds(896, 11, 86, 14);
                add(gmail);
                
                 getContentPane().setBackground(Color.WHITE);
	}
}
