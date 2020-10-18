/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import DB.ConnectionORCL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author XPC
 */
public class MetodosCategoria {
    ConnectionORCL connectionObj;
    CallableStatement stmt;
    Connection conn;
    ResultSet rs;

    public MetodosCategoria() {
        
    }
    
    
    
    public boolean postCategoria(String nombre, String descripcion){
        
        boolean exito_operacion;
        try{
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            //TODO llamar el sp
            stmt = conn.prepareCall("{call  TIENDAGG.sp_postCategoria (?,?)}");
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.execute();
            stmt.close();
            exito_operacion = true;
            //FIN SP
            conn.close();
        }
        catch(Exception e){ 
            System.out.println("ERROR: No se puede completar la operacion "+e);
            exito_operacion = false;
        }
        return exito_operacion;
    }
    
    public ArrayList<Categoria> getCategorias(){
        
        ArrayList<Categoria> arreglo = new ArrayList();
        try{
            //TODO llamar el sp 
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            stmt = conn.prepareCall("{call  TIENDAGG.sp_getCategorias (?)}");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);
            while(rs.next()){
                String nombre = rs.getString("nombre_cat");
                String descripcion = rs.getString("descripcion_cat");
                int id = rs.getInt("id_categoria");
                
                Categoria categoria = new Categoria(nombre,descripcion, id);
                
                arreglo.add(categoria);
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
