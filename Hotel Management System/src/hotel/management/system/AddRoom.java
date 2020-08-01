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
import java.util.*;

public class AddRoom extends JFrame implements ActionListener{
    
    
    JTextField r_no,r_price;
    JComboBox avail ,  c_status, b_type;
    JButton addr,backr;
   // Choice c1;

    public static void main(String[] args) {
        new AddRoom();
    }


    public AddRoom() {
       // setBounds(450, 200, 1000, 450);
        getContentPane().setLayout(null);
        setBounds(270,140,970,500);
	//contentPane = new JPanel();
	//setContentPane(contentPane);
	//contentPane.setLayout(null);
       
        
                                                             
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,30,500,370);
                add(l15);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(194, 10, 120, 22);
	add(heading);
        
	
        
	JLabel roomno = new JLabel("Room Number");
	roomno.setForeground(new Color(25, 25, 112));
	roomno.setFont(new Font("Tahoma", Font.BOLD, 14));
	roomno.setBounds(64, 70, 115, 22);
	add(roomno);
        
        
        r_no = new JTextField();
	r_no.setBounds(174, 70, 156, 20);
	add(r_no);
        

	JLabel availability = new JLabel("Availability");
	availability.setForeground(new Color(25, 25, 112));
	availability.setFont(new Font("Tahoma", Font.BOLD, 14));
	availability.setBounds(64, 110, 115, 22);
	add(availability);
        
        avail = new JComboBox(new String[] { "Available", "Occupied" });
	avail.setBounds(176, 110, 154, 20);
	add(avail);


	JLabel cleanningStatus = new JLabel("Cleaning Status");
	cleanningStatus.setForeground(new Color(25, 25, 112));
	cleanningStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
	cleanningStatus.setBounds(64, 150, 115, 22);
	add(cleanningStatus);
        
        c_status = new JComboBox(new String[] { "Cleaned", "Dirty" });
	 c_status.setBounds(176, 150, 154, 20);
	add(c_status);

	JLabel roomprice = new JLabel("Price");
	roomprice.setForeground(new Color(25, 25, 112));
	roomprice.setFont(new Font("Tahoma", Font.BOLD, 14));
	roomprice.setBounds(64, 190, 115, 22);
	add(roomprice);
        
        r_price = new JTextField();
	r_price.setBounds(174, 190, 156, 20);
	add(r_price);

        JLabel bedtype = new JLabel("Bed Type");
	bedtype.setForeground(new Color(25, 25, 112));
	bedtype.setFont(new Font("Tahoma", Font.BOLD, 14));
	bedtype.setBounds(64, 230, 115, 22);
	add(bedtype);


        b_type= new JComboBox(new String[] { "Single Bed", "Double Bed"});
	 b_type.setBounds(176, 230, 154, 20);
	add( b_type);

	

	

	addr= new JButton("Add");
	addr.addActionListener(this);
	addr.setBounds(64, 321, 111, 33);
        addr.setBackground(Color.BLACK);
        addr.setForeground(Color.WHITE);
	add(addr);

	backr = new JButton("Back");
	backr.addActionListener(this);
	backr.setBounds(198, 321, 111, 33);
        backr.setBackground(Color.BLACK);
        backr.setForeground(Color.WHITE);
        add(backr);

	
       
       
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == addr){
                try{
                conn c = new conn();
                String room = r_no.getText();
                String available = (String)avail.getSelectedItem();
                String status = (String)c_status.getSelectedItem();
                String price  = r_price.getText();
                String type = (String)b_type.getSelectedItem();
                String str = "INSERT INTO addroom values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";
              
                
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Room Successfully Added");
                this.setVisible(false);
               
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() ==backr){
                this.setVisible(false);
            }
        }catch(Exception eee){
            
        }
    }
}
