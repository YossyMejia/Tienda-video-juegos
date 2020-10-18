/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import DB.ConnectionORCL;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import oracle.jdbc.OracleTypes;
import org.bson.types.ObjectId;

/**
 *
 * @author XPC
 */
public class MetodosUsuario {
    
    ConnectionORCL connectionObj;
    CallableStatement stmt;
    Connection conn;
    ResultSet rs;
    DBCollection collection;
    Mongo mongoClient;
    DB database;
    
    public MetodosUsuario(){
        
        
    }
    
    public boolean postUser(String imagen, int id, String nombre, String apellido1, 
                                     String apellido2, String tipo, String correo,
                                     String contrasena ){
        
        boolean exito_operacion;
        try{
            //INICIO SP
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            System.out.println(id+" "+nombre+" "+apellido1+" "+apellido2+" "+tipo+" "+correo+" "+contrasena);
            stmt = conn.prepareCall("{call  TIENDAGG.sp_postUser (?,?,?,?,?,?,?)}");
            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido1);
            stmt.setString(4, apellido2);
            stmt.setString(5, tipo);
            stmt.setString(6, correo);
            stmt.setString(7, contrasena);
            stmt.execute();
            stmt.close();
            conn.close();
            
             //Guardando en mongo
            mongoClient = new Mongo("LocalHost",27017);
            database = mongoClient.getDB("local");
            collection = database.getCollection("usuario");
            BasicDBObject usuario = new BasicDBObject("_id", new ObjectId());
            usuario.put("id_usuario", id);
            usuario.put("imagenPerfil", imagen);
            collection.insert(usuario);
            mongoClient.close();
            
            exito_operacion = true;
            //FIN SP
        }
        catch(Exception e){ 
            System.out.println("ERROR: No se puede completar la operacion "+e);
            exito_operacion = false;
        }
        return exito_operacion;
    }
    
    public ArrayList<Usuario> getUser(int id){
        
        ArrayList<Usuario> arreglo = new ArrayList();
        try{
            //TODO llamar el sp 
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            stmt = conn.prepareCall("{call  TIENDAGG.sp_getUser (?,?)}");
            stmt.setInt(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);
            while(rs.next()){
                int id_user = rs.getInt("id_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String primer_apellido = rs.getString("primer_apellido");
                String segundo_apellido = rs.getString("segundo_apellido");
                int tipo_usuario = rs.getInt("tipo_usuario");
                
                Usuario usuario = new Usuario(id_user, nombre_usuario, 
                                              primer_apellido, segundo_apellido,
                                              tipo_usuario);
                
                arreglo.add(usuario);
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
    
    public ArrayList<Usuario> getUsers(){
        
        ArrayList<Usuario> arreglo = new ArrayList();
        try{
            //TODO llamar el sp 
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            stmt = conn.prepareCall("{call  TIENDAGG.sp_getUsers (?)}");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(1);
            while(rs.next()){
                String nombre_usuario = rs.getString("nombre_usuario");
                String primer_apellido = rs.getString("primer_apellido");
                String segundo_apellido = rs.getString("segundo_apellido");
                String tipo = rs.getString("descripcion");
                String correo = rs.getString("correo");
                
                Usuario usuario = new Usuario(nombre_usuario, primer_apellido, 
                                              segundo_apellido,tipo, correo);
                
                arreglo.add(usuario);
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