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
import java.awt.event.*;
import java.awt.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField name,age, salary,phone,aadhar,email;
    JComboBox c1;
    JRadioButton male,female;
    ButtonGroup b1;

        public AddEmployee(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD EMPLOYEE DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            /*JLabel Passportno = new JLabel("NAME");
            Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Passportno.setBounds(60, 30, 150, 27);
            add(Passportno);*/
            
            JLabel empname = new JLabel("NAME");
            empname.setFont(new Font("Tahoma", Font.PLAIN, 17));
            empname.setBounds(60, 30, 150, 27);
            add(empname);
            
            name = new JTextField();
            name.setBounds(200, 30, 150, 27);
            add(name);
			
            JButton save = new JButton("SAVE");
            save.setBounds(200, 420, 150, 30);
            save.setBackground(Color.BLACK);
            save.setForeground(Color.WHITE);
            add(save);
	
            save.addActionListener(this);
            
            JLabel empage = new JLabel("AGE");
            empage.setFont(new Font("Tahoma", Font.PLAIN, 17));
            empage.setBounds(60, 80, 150, 27);
            add(empage);
			
            age = new JTextField();
            age.setBounds(200, 80, 150, 27);
            add(age);
            
            JLabel empgender = new JLabel("GENDER");
            empgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            empgender.setBounds(60, 120, 150, 27);
            add(empgender);
		
            male = new JRadioButton("MALE");
            male.setBackground(Color.WHITE);
            male.setBounds(200, 120, 70, 27);
            add(male);
	
            female = new JRadioButton("FEMALE");
            female.setBackground(Color.WHITE);
            female.setBounds(280, 120, 70, 27);
            add(female);
            
            b1=new ButtonGroup();
            b1.add(male);
            b1.add(female);
            
            
            
            
            JLabel empjob= new JLabel("JOB");
            empjob.setFont(new Font("Tahoma", Font.PLAIN, 17));
            empjob.setBounds(60, 170, 150, 27);
            add(empjob);
			
            String course[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE);
            c1.setBounds(200,170,150,30);
            add(c1);
            		
            JLabel empsalary = new JLabel("SALARY");
            empsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
            empsalary.setBounds(60, 220, 150, 27);
            add(empsalary);
			
            salary = new JTextField();
            salary.setBounds(200, 220, 150, 27);
            add( salary);
	
            JLabel empphone = new JLabel("PHONE");
            empphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
            empphone.setBounds(60, 270, 150, 27);
            add(empphone);
	
            phone = new JTextField();
            phone.setBounds(200, 270, 150, 27);
            add(phone);
	
            JLabel empaadhar = new JLabel("AADHAR");
            empaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
            empaadhar.setBounds(60, 320, 150, 27);
            add(empaadhar);
			
            aadhar= new JTextField();
            aadhar.setBounds(200, 320, 150, 27);
            add(aadhar);
	
            
            JLabel empemail = new JLabel("EMAIL");
            empemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
            empemail.setBounds(60, 370, 150, 27);
            add(empemail);
			
            email= new JTextField();
            email.setBounds(200, 370, 150, 27);
            add(email);
	
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(450, 24, 442, 35);
            add(AddPassengers);
			
     
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
            Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(410,80,480,410);
            add(image);

            
        
                
            setBounds(290,140,900,500);
           // setSize(900,600);
            setVisible(true);
            //setLocation(530,200);
			
}
        
        public void actionPerformed(ActionEvent ae){
                    String name1 = name.getText();
                    String age1 = age.getText();
                    String salary1 =salary.getText();
                    String phone1 = phone.getText();
                    String aadhar1 = aadhar.getText();
                    String email1 = email.getText();
                   
                    String gender = null;
                    
                    if(male.isSelected()){
                        gender = "male";
                    
                    }else if(female.isSelected()){
                        gender = "female";
                    }

                            
                    String courses1 = (String)c1.getSelectedItem();
                    
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO addemployee values( '"+name1+"', '"+age1+"', '"+gender+"','"+courses1+"', '"+salary1+"', '"+phone1+"','"+aadhar1+"', '"+email1+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Employee Added");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
            
     
    public static void main(String[] args){
        new AddEmployee();
    }   
    
}
