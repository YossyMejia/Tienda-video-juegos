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
public class MetodosDireccion {
    ConnectionORCL connectionObj;
    CallableStatement stmt;
    Connection conn;
    ResultSet rs;
    
    public MetodosDireccion(){
        connectionObj = new ConnectionORCL();
        conn = connectionObj.getConnection();
        rs = null;
        
    }
    
    public boolean postDireccion(int id_usuario, String provincia, String canton, 
                                     String distrito, String datosExtra ){
        
        boolean exito_operacion;
        try{
            //INICIO SP
            
            stmt = conn.prepareCall("{call  TIENDAGG.sp_postDireccion (?,?,?,?,?)}");
            stmt.setString(1, provincia);
            stmt.setString(2, canton);
            stmt.setString(3, distrito);
            stmt.setString(4, datosExtra);
            stmt.setInt(5, id_usuario);
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
    
    public ArrayList<Direccion> getDirecciones(int id){
        ArrayList<Direccion> arreglo = new ArrayList();
        try{
            //TODO llamar el sp 
            stmt = conn.prepareCall("{call  TIENDAGG.sp_getDirecciones (?,?)}");
            stmt.setInt(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);
            while(rs.next()){
                int id_direccion = rs.getInt("id_direccion");
                String provincia = rs.getString("provincia");
                String canton = rs.getString("canton");
                String distrito = rs.getString("distrito");
                String datos_extra = rs.getString("datos_extra");
                System.out.println(provincia);
                Direccion direccion = new Direccion(id_direccion, provincia, canton, distrito, 
                        datos_extra);
               
                arreglo.add(direccion);
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
