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
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author XPC
 */
public class MetodosCompra {
    ConnectionORCL connectionObj;
    CallableStatement stmt;
    Connection conn;
    ResultSet rs;
    
    public MetodosCompra(){
        connectionObj = new ConnectionORCL();
        conn = connectionObj.getConnection();
        rs = null;
        
    }
    
    public boolean postCompra(int usuario, int direccion, String productos, 
            int total, String fecha, String tarjeta ){
        
        boolean exito_operacion;
        try{
            //INICIO SP
            stmt = conn.prepareCall("{call  TIENDAGG.sp_postCompra (?,?,?,?,?,?)}");
            stmt.setInt(1, usuario);
            stmt.setInt(2, direccion);
            stmt.setString(3, productos);
            stmt.setString(4, fecha);
            stmt.setInt(5, total);
            stmt.setString(6, tarjeta);
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