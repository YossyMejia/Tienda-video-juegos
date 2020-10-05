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
public class MetodosSolicitud {
    ConnectionORCL connectionObj;
    CallableStatement stmt;
    Connection conn;
    ResultSet rs;
    
    public MetodosSolicitud(){
        connectionObj = new ConnectionORCL();
        conn = connectionObj.getConnection();
        rs = null;
    }
    
    public boolean postSolicitud(int id_usuario, String descripcion, String fecha_hora){
        
        boolean exito_operacion;
        try{
            //TODO llamar el sp que devuelve el usuario que hace match con los datos aqui.
            System.out.println(id_usuario+" "+descripcion+" "+fecha_hora);
            stmt = conn.prepareCall("{call  TIENDAGG.sp_postSolicitud (?,?,?)}");
            stmt.setInt(1, id_usuario);
            stmt.setString(2, descripcion);
            stmt.setString(3, fecha_hora);
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
    
    public boolean postSolucion(int id_tecnico, String respuesta, String fecha_hora,
            int id_solicitud){
        
        boolean exito_operacion;
        try{
            //TODO llamar el sp que devuelve el usuario que hace match con los datos aqui.
            stmt = conn.prepareCall("{call  TIENDAGG.sp_postSolucion (?,?,?, ?)}");
            stmt.setInt(1, id_tecnico);
            stmt.setString(2, respuesta);
            stmt.setString(3, fecha_hora);
            stmt.setInt(4, id_solicitud);
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
    
    public ArrayList<Solicitud> getSolicitudes(){
        ArrayList<Solicitud> arreglo = new ArrayList();
        try{
            //TODO llamar el sp 
            stmt = conn.prepareCall("{call  TIENDAGG.sp_getSolicitudes (?)}");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);
            while(rs.next()){
                int id = rs.getInt("id_solicitudTecnica");
                int id_usuario = rs.getInt("id_usuario");
                String descripcion = rs.getString("descripcion");
                String fecha_solicitud = rs.getString("fecha_solicitud");
                Solicitud solicitud = new Solicitud(id,descripcion,id_usuario,fecha_solicitud);
               
                arreglo.add(solicitud);
            }
            
            stmt.close();
            //FIN SP
        }
        catch(Exception e){ 
            System.out.println("ERROR: No se puede completar la operacion "+e);
        }
        return arreglo;
    }
    
    
    public ArrayList<Solicitud> getSolicitudesSoluciones(){
        ArrayList<Solicitud> arreglo = new ArrayList();
        try{
            //TODO llamar el sp 
            stmt = conn.prepareCall("{call  TIENDAGG.sp_getSolicitudesSoluciones (?)}");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);
            while(rs.next()){
                int id_solicitud = rs.getInt("id_solicitudTecnica");
                int id_usuario = rs.getInt("id_usuario");
                int id_tecnico = rs.getInt("id_tecnico");
                String descripcion = rs.getString("descripcion");
                String respuesta = rs.getString("respuesta");
                Solicitud solicitud = new Solicitud(id_solicitud, id_usuario,id_tecnico,descripcion,respuesta);
               
                arreglo.add(solicitud);
            }
            
            stmt.close();
            //FIN SP
        }
        catch(Exception e){ 
            System.out.println("ERROR: No se puede completar la operacion "+e);
        }
        return arreglo;
    }
    
    public ArrayList<Solicitud> getDetallesSolicitud(int id){
        ArrayList<Solicitud> arreglo = new ArrayList();
        try{
            //TODO llamar el sp 
            stmt = conn.prepareCall("{call  TIENDAGG.sp_getSolicitudDetalle (?,?)}");
            stmt.setInt(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);
            while(rs.next()){
                int id_usuario = rs.getInt("id_usuario");
                int id_tecnico = rs.getInt("id_tecnico");
                String descripcion = rs.getString("descripcion");
                String respuesta = rs.getString("respuesta");
                String fecha_solucion = rs.getString("fecha_solucion");
                
                Solicitud solicitud = new Solicitud(id_usuario,id_tecnico,descripcion,
                        respuesta, fecha_solucion);
               
                arreglo.add(solicitud);
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
