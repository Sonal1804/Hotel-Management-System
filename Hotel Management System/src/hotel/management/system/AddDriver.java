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

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.sql.*;
//import java.util.*;
public class AddDriver extends JFrame implements ActionListener{
    
    
    private JTextField d_name,d_age,c_company;
    private JComboBox d_gender,c_avail;
    JButton addd,backd;
    

    public static void main(String[] args) {
        new AddDriver().setVisible(true);
    }


    public AddDriver() {
        setBounds(200,140,970,500);
	
	
	setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,30,500,370);
                add(l15);
        
        JLabel heading = new JLabel("Add Driver");
       heading.setFont(new Font("Tahoma", Font.BOLD, 18));
	heading.setBounds(194, 10, 120, 22);
	add(heading);
        
	
        
	JLabel drivername = new JLabel("Name");
	drivername.setForeground(new Color(25, 25, 112));
	drivername.setFont(new Font("Tahoma", Font.BOLD, 14));
	drivername.setBounds(64, 70, 102, 22);
	add(drivername);
        
        
        d_name = new JTextField();
	d_name.setBounds(174, 70, 156, 20);
	add(d_name);
        

	JLabel driverage = new JLabel("Age");
        driverage.setForeground(new Color(25, 25, 112));
	driverage.setFont(new Font("Tahoma", Font.BOLD, 14));
	driverage.setBounds(64, 110, 102, 22);
	add(driverage);
        
        d_age = new JTextField();
	d_age.setBounds(174, 110, 156, 20);
	add(d_age);


	JLabel drivergender = new JLabel("Gender");
	drivergender.setForeground(new Color(25, 25, 112));
	drivergender.setFont(new Font("Tahoma", Font.BOLD, 14));
	drivergender.setBounds(64, 150, 102, 22);
        add(drivergender);
        
        d_gender = new JComboBox(new String[] { "Male", "Female" });
	d_gender.setBounds(176, 150, 154, 20);
	add(d_gender);

	JLabel carcompany= new JLabel("Car Company");
	carcompany.setForeground(new Color(25, 25, 112));
	carcompany.setFont(new Font("Tahoma", Font.BOLD, 14));
	carcompany.setBounds(64, 190, 102, 22);
	add(carcompany);
        
        c_company = new JTextField();
	c_company.setBounds(174, 190, 156, 20);
	add(c_company);

        JLabel available = new JLabel("Available");
	 available.setForeground(new Color(25, 25, 112));
	 available.setFont(new Font("Tahoma", Font.BOLD, 14));
	 
         available.setBounds(64, 230, 102, 22);
	add( available);


        c_avail = new JComboBox(new String[] { "Yes", "No" });
	c_avail.setBounds(176, 230, 154, 20);
	add(c_avail);

        
      


        
        
	

	addd = new JButton("Add");
	addd.addActionListener(this);
	addd.setBounds(64, 380, 111, 33);
        addd.setBackground(Color.BLACK);
        addd.setForeground(Color.WHITE);
	add(addd);

	backd = new JButton("Back");
	backd.addActionListener(this);
	backd.setBounds(198, 380, 111, 33);
        backd.setBackground(Color.BLACK);
        backd.setForeground(Color.WHITE);
	add(backd);

	
      setBackground(Color.WHITE);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == addd){
                try{
                conn c = new conn();
                String name = d_name.getText();
                String age = d_age.getText();
                String gender = (String)d_gender.getSelectedItem();
                String company  = c_company.getText();
                
                String available = (String)c_avail.getSelectedItem();
              
                String str = "INSERT INTO adddriver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"','"+available+"')";
              
                
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                this.setVisible(false);
               
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == backd){
                this.setVisible(false);
            }
        }catch(Exception eee){
            
        }
    }
    
    
    
}
