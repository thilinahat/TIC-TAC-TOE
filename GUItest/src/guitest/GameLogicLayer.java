/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author User
 */
public class GameLogicLayer {
    
    PlayersDatabaseAccessor accessor=new PlayersDatabaseAccessor();
    ResultSet dataSet=null;
    
    public String[] getProfileNames() throws SQLException{
        
        dataSet=accessor.retrieveProfile();
         String[] nameArray=new String[50];
          int i=0;
          while(dataSet.next()){
               nameArray[i]=dataSet.getString("Name");
               i++;
    }
    
    return nameArray;
        
    }
    
}
