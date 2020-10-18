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
public class MetodosTarjeta {
    ConnectionORCL connectionObj;
    CallableStatement stmt;
    Connection conn;
    ResultSet rs;
    
    public MetodosTarjeta(){
        
        
    }
    
    public boolean postTarjeta(int id, String numero, String nombre, 
                                     String fecha, int ccv ){
        
        boolean exito_operacion;
        try{
            //INICIO SP
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            stmt = conn.prepareCall("{call  TIENDAGG.sp_postTarjeta (?,?,?,?,?)}");
            stmt.setInt(1, id);
            stmt.setString(2, numero);
            stmt.setString(3, nombre);
            stmt.setString(4, fecha);
            stmt.setInt(5, ccv);
            stmt.execute();
            stmt.close();
            conn.close();
            exito_operacion = true;
            
            //FIN SP
        }
        catch(Exception e){ 
            System.out.println("ERROR: No se puede completar la operacion "+e);
            exito_operacion = false;
        }
        return exito_operacion;
    }
    
    public ArrayList<Tarjeta> getTarjetas(int id){
        ArrayList<Tarjeta> arreglo = new ArrayList();
        try{
            //TODO llamar el sp 
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            stmt = conn.prepareCall("{call  TIENDAGG.sp_getTarjetas (?,?)}");
            stmt.setInt(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);
            while(rs.next()){
                String numero = rs.getString("numero_tarjeta");
                String nombre = rs.getString("titular_tarjeta");
                int ccv = rs.getInt("ccv");
                String fecha = rs.getString("fecha_vencimiento");
                Tarjeta tarjeta = new Tarjeta(numero, nombre, ccv, fecha);
               
                arreglo.add(tarjeta);
            }
            
            stmt.close();
            conn.close();
            //FIN SP
        }
        catch(Exception e){ 
            System.out.println("ERROR: No se puede completar la operacion "+e);
        }
        return arreglo;
    }
}
