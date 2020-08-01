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
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    
    Dashboard(){
        mb=new JMenuBar();
        add(mb);
        mb.setBounds(0,0,1950,30);
        
        m1=new JMenu("HOTEL MANAGEMENT");
        m1.setForeground(Color.RED);
        mb.add(m1);
        
        m2=new JMenu("ADMIN");
        m2.setForeground(Color.BLUE);
        mb.add(m2);
        
        i1=new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        m1.add(i1);
        
        i2=new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        m2.add(i2);
        
        
        i3=new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        m2.add(i3);
        
        i4=new JMenuItem("ADD DRIVERS");
        i4.addActionListener(this);
        m2.add(i4);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/Icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i1);
        
        image.setBounds(0,0,1400,900);
        add(image);
        
        
        JLabel heading=new JLabel("THE TAJ GROUP WELCOMES YOU");
        heading.setBounds(500,60,1000,50);
        heading.setFont(new Font("serif",Font.PLAIN,30));
        image.add(heading);
        
        setLayout(null);
        setBounds(0,0,1950,1020);
        setVisible(true);
        
        
     }
    
    public void actionPerformed(ActionEvent ae)
    {
        //String command=ae.getActionCommand();
        if(ae.getActionCommand().equals("RECEPTION"))
        {
            new Reception().setVisible(true);
            
        }else if(ae.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new AddEmployee().setVisible(true);
            
        }else if(ae.getActionCommand().equals("ADD ROOMS"))
        {
            new AddRoom().setVisible(true);
            
        }else if(ae.getActionCommand().equals("ADD DRIVERS"))
        {
            new AddDriver().setVisible(true);
        }
    }
    
    
    public static void main(String []args)
    {
        new Dashboard().setVisible(true);
    }    
}
