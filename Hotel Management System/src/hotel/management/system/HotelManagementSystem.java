
package hotel.management.system;

/**
 *
 * @author sayali
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class HotelManagementSystem extends JFrame implements ActionListener{
    JLabel l1;
    JButton b1;

    public HotelManagementSystem(){
        
        setBounds(2,50,1366,565);
        
        //setSize(400,400);
        //setLocation(0,0,1366,565);
        
        //setSize(1366,430);          // setContentPane(300,300,1366,390);   frame size
        setLayout(null);
        //setLocation(300,300);

	l1 = new JLabel("");
        b1 = new JButton("Next");
                
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
				
                
                
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
       // Image i3 = i1.getImage().getScaledInstance(1366, 390,Image.SCALE_DEFAULT);
        //ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i1);
        
                
        JLabel lid=new JLabel("HOTEL MANAGEMENT SYSTEM");
        lid.setBounds(20,430,1000,90);
        lid.setFont(new Font("serif",Font.PLAIN,30));
        lid.setForeground(Color.white);
        l1.add(lid);
              
        b1.setBounds(1030,430,150,30);
       // b1.setBounds(1170,325,150,50);
	l1.setBounds(0, 0, 1366,565);
                
        l1.add(b1);
	add(l1);
 
        b1.addActionListener(this);
       setVisible(true);
                
       /* while(true){
             lid.setVisible(false); // lid =  j label
            try{
               Thread.sleep(500); //1000 = 1 second
               }catch(Exception e){} 
                lid.setVisible(true);
                try{
                    Thread.sleep(500);
                }catch(Exception e){}
          }*/
    }

 public  void actionPerformed(ActionEvent e)
{
    new Login().setVisible(true);
    this.setVisible(false);
}
    
    public static void main(String[] args) {
        // TODO code application logic 
        
        new HotelManagementSystem();
    }
    
    
}
