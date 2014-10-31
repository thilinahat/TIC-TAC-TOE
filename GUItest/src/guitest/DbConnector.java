/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DbConnector {
    
    private Connection connector=null;
    
    public Connection getConnection(){
        
        System.out.println("=======MySql Connection Testing=======");
        
        try{
            Class.forName("com.mysql.jdbc.Connection");                  //checking for the driver
        }
        
        catch(ClassNotFoundException e) {
            System.out.println("Where is MySql Driver ???");
        }
        
        System.out.println("MySql Driver Registered");
        
        try{          //making the connection 
            connector=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/Game","root","");
            System.out.println("Connection Succeded!!!");
        }
        catch(SQLException e){
             System.out.println(e);
        }
        
   return connector;  //returning the connection
                    
    } 
}
