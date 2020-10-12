/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import DB.ConnectionORCL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author XPC
 */
public class MetodosTarjeta {
    ConnectionORCL connectionObj;
    CallableStatement stmt;
    Connection conn;
    ResultSet rs;
    
    public MetodosTarjeta(){
        connectionObj = new ConnectionORCL();
        conn = connectionObj.getConnection();
        rs = null;
        
    }
    
    public boolean postTarjeta(int id, String numero, String nombre, 
                                     String fecha, int ccv ){
        
        boolean exito_operacion;
        try{
            //INICIO SP
            
            stmt = conn.prepareCall("{call  TIENDAGG.sp_postTarjeta (?,?,?,?,?)}");
            stmt.setInt(1, id);
            stmt.setString(2, numero);
            stmt.setString(3, nombre);
            stmt.setString(4, fecha);
            stmt.setInt(5, ccv);
            stmt.execute();
            stmt.close();
            exito_operacion = true;
            //FIN SP
        }
        catch(Exception e){ 
            System.out.println("ERROR: No se puede completar la operacion "+e);
            exito_operacion = false;
        }
        return exito_operacion;
    }
}
