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
public class MetodosProductos {
    
    ConnectionORCL connectionObj;
    CallableStatement stmt;
    Connection conn;
    ResultSet rs;
    
    public MetodosProductos(){
        connectionObj = new ConnectionORCL();
        conn = connectionObj.getConnection();
        rs = null;
    }
    
    public boolean postProducto(int codigo, String nombre, String descripcion, 
                                     int precio, int cantidad, 
                                     String nombreCategoria){
        
        boolean exito_operacion;
        try{
            //TODO llamar el sp que devuelve el usuario que hace match con los datos aqui.
            System.out.println(codigo+nombre+descripcion+precio+cantidad+nombreCategoria);
            stmt = conn.prepareCall("{call  TIENDAGG.sp_postProducto (?,?,?,?,?,?)}");
            stmt.setInt(1, codigo);
            stmt.setString(2, nombre);
            stmt.setString(3, descripcion);
            stmt.setInt(4, precio);
            stmt.setInt(5, cantidad);
            stmt.setString(6, nombreCategoria);
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
    
    public ArrayList<Producto> getProductos(){
        ArrayList<Producto> arreglo = new ArrayList();
        try{
            //TODO llamar el sp 
            stmt = conn.prepareCall("{call  TIENDAGG.sp_getProductos (?)}");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);
            while(rs.next()){
                int id_producto = rs.getInt("id_producto");
                String nombre = rs.getString("nombre_producto");
                int precio = rs.getInt("precio");
                int cantidad = rs.getInt("cantidad");
                String nombre_cat = rs.getString("nombre_cat"); 
                
                Producto producto = new Producto(id_producto,nombre,precio,cantidad,nombre_cat);
               
                arreglo.add(producto);
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
