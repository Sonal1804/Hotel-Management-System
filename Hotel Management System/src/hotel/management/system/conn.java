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

import java.sql.*;


public class conn {
    
    Connection con;
    Statement s;
    
    public conn(){
    try{
    
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql:///projecthms","root","sayu");
    s=con.createStatement();
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    
}
}
