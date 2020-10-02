/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*; 
/**
 *
 * @author XPC
 */
public class ConnectionORCL {
    private String dbUrl = "jdbc:oracle:thin:@//localhost:1521/orcl";
    private String username = "system";
    private String password = "oracle";
    private Connection connection;
    
    public ConnectionORCL(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection(dbUrl,username,password);
        }
        catch(Exception e){ System.out.println("ERROR: Database connection doesn't work "+e);}
        
    };
   
    
    
   public void closeConnection() {
       try{
           this.connection.close();
       }
       catch(Exception e){ System.out.println("ERROR: The connection can't be closed"+e);}
   }  

   
    public Connection getConnection() {
        return connection;
    }
   
   
}
