/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class PlayersDatabaseAccessor {
    
    private Statement stmnt=null;
    private Connection  databaseConnector=null;
    private DbConnector myConnector=new DbConnector();
    private ResultSet dataSet=null;
    String SQLQuery=null;
    
    public ResultSet  retrieveProfile() throws SQLException{
        
         try{
        databaseConnector=myConnector.getConnection();
        stmnt=(Statement) databaseConnector.createStatement();
        
        
        SQLQuery="SELECT * FROM Game.profiles";
        dataSet=stmnt.executeQuery(SQLQuery);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return dataSet; //return the raws as a resultSet
        
    }
    
    public void  insertProfile(String profileName,String password) throws SQLException{
        
        try {
            databaseConnector = myConnector.getConnection();
                 
            SQLQuery = "INSERT INTO Game.profiles  "+"VALUES(?,?,?)";
            PreparedStatement preparedStatement = databaseConnector.prepareStatement(SQLQuery);
            
            preparedStatement.setString(1, profileName);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3, "0");
            preparedStatement.executeUpdate(); 
            
        } 
         catch (SQLException e) {
            System.out.println(e.getMessage());
          } 
         
    }
    
    public void updateScores(String profileName,int score) throws SQLException{
         try {
            databaseConnector = myConnector.getConnection();
             stmnt=(Statement) databaseConnector.createStatement();
             
          SQLQuery="UPDATE Game.profiles SET Score= "+score+"  WHERE Name= "+profileName;
          stmnt.executeUpdate(SQLQuery);
            
            
        } 
         catch (SQLException e) {
            System.out.println(e.getMessage());
          } 
          
         
    }
    
    
}
