/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import DB.ConnectionORCL;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author XPC
 */
public class MetodosLogin {
    ConnectionORCL connectionObj;
    CallableStatement stmt;
    Connection conn;
    ResultSet rs;
    
    public MetodosLogin(){
        connectionObj = new ConnectionORCL();
        conn = connectionObj.getConnection();
        rs = null;
        
    }
    
    
    
    public ArrayList<Login> login(String user, String password){
        
        ArrayList<Login> arreglo = new ArrayList();
        try{
            //TODO llamar el sp que devuelve el usuario que hace match con los datos aqui.
            
            stmt = conn.prepareCall("{call  TIENDAGG.sp_LoginVerif (?,?,?)}");
            stmt.setString(1, user);
            stmt.setString(2, password);
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(3);
            while(rs.next()){
                Login loginBD = new Login(rs.getString("correo"),rs.getString("contrasena"), rs.getInt("id_usuario") );
                arreglo.add(loginBD);
            }
            stmt.close();
            
            //FIN SP
        }
        catch(Exception e){ 
            System.out.println("ERROR: No se puede completar la operacion "+e);
        }
        return arreglo;
    }
    
    public ArrayList<Login> checkCorreo(String user){
        
        ArrayList<Login> arreglo = new ArrayList();
        try{
            //INICIO SP
            
            stmt = conn.prepareCall("{call  TIENDAGG.sp_checkCorreo (?,?)}");
            stmt.setString(1, user);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);
            while(rs.next()){
                Login loginBD = new Login(rs.getString("correo") );
                arreglo.add(loginBD);
            }
            stmt.close();
            
            //FIN SP
        }
        catch(Exception e){ 
            System.out.println("ERROR: No se puede completar la operacion "+e);
        }
        return arreglo;
    }
    
}
