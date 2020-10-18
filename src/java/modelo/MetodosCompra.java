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
        
        
    }
    
    public boolean postCompra(int usuario, int direccion, String productos, 
            int total, String fecha, String tarjeta ){
        
        boolean exito_operacion;
        try{
            //INICIO SP
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            stmt = conn.prepareCall("{call  TIENDAGG.sp_postCompra (?,?,?,?,?,?)}");
            stmt.setInt(1, usuario);
            stmt.setInt(2, direccion);
            stmt.setString(3, productos);
            stmt.setString(4, fecha);
            stmt.setInt(5, total);
            stmt.setString(6, tarjeta);
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
    
    public ArrayList<Compra> getComprasCliente(int id){
        ArrayList<Compra> arreglo = new ArrayList();
        try{
            //INICIO SP
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            stmt = conn.prepareCall("{call  TIENDAGG.sp_getComprasCliente (?,?)}");
            stmt.setInt(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);
            while(rs.next()){
                int id_orden = rs.getInt("id_orden");
                String fecha_orden = rs.getString("fecha_orden");
                String estado_orden = rs.getString("estado");
                String detalles_orden = rs.getString("detalles");
                int monto = rs.getInt("monto"); 
                Compra compra = new Compra(id_orden, fecha_orden, estado_orden,
                        detalles_orden ,monto);
               
                arreglo.add(compra);
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
    
    public ArrayList<Compra> getCompras(){
        ArrayList<Compra> arreglo = new ArrayList();
        try{
            //INICIO SP
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            stmt = conn.prepareCall("{call  TIENDAGG.sp_getCompras (?)}");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);
            while(rs.next()){
                int id_usuario = rs.getInt("id_usuario");
                int id_orden = rs.getInt("id_orden");
                String fecha_orden = rs.getString("fecha_orden");
                String estado_orden = rs.getString("estado");
                String detalles_orden = rs.getString("detalles");
                int monto = rs.getInt("monto"); 
                Compra compra = new Compra(id_usuario, id_orden, fecha_orden, estado_orden,
                        detalles_orden ,monto);
               
                arreglo.add(compra);
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
    
    
    public boolean putOrdenEntregada(int id ){
        
        boolean exito_operacion;
        try{
            //INICIO SP
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            stmt = conn.prepareCall("{call  TIENDAGG.sp_putOrdenEntregada (?)}");
            stmt.setInt(1, id);
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
    
}