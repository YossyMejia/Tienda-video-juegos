/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import DB.ConnectionMDB;
import DB.ConnectionORCL;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oracle.jdbc.OracleTypes;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author XPC
 */
public class MetodosProductos {
    
    ConnectionORCL connectionObj;
    CallableStatement stmt;
    Connection conn;
    ResultSet rs;
    DBCollection collection;
    Mongo mongoClient;
    DB database;
    
    public MetodosProductos(){
       
        
    }
    
    public boolean postProducto(String imagen, int codigo, String nombre, 
                                     String descripcion, int precio, int cantidad, 
                                     int idCategoria){
        
        boolean exito_operacion;
        try{
             connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            //INICIO SP
            stmt = conn.prepareCall("{call  TIENDAGG.sp_postProducto (?,?,?,?,?,?)}");
            stmt.setInt(1, codigo);
            stmt.setString(2, nombre);
            stmt.setString(3, descripcion);
            stmt.setInt(4, precio);
            stmt.setInt(5, cantidad);
            stmt.setInt(6, idCategoria);
            stmt.execute();
            stmt.close();
            
            //Guardando en mongo
            mongoClient = new Mongo("LocalHost",27017);
            database = mongoClient.getDB("local");
            collection = database.getCollection("productos");
            BasicDBObject producto = new BasicDBObject("_id", new ObjectId());
            producto.put("imagen", imagen);
            producto.put("id_producto", codigo);
            producto.put("nombre_producto", nombre);
            producto.put("precio", precio);
            producto.put("cantidad", cantidad);
            collection.insert(producto);
            mongoClient.close();
            
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
    
    public ArrayList<Producto> getProductos(){
        ArrayList<Producto> arreglo = new ArrayList();
        try{
            //TODO llamar el sp 
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
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
            conn.close();
            //FIN SP
        }
        catch(Exception e){ 
            System.out.println("ERROR: No se puede completar la operacion "+e);
        }
        return arreglo;
    }
    
    
    public ArrayList<Producto> getProductoDetalles(int id){
        ArrayList<Producto> arreglo = new ArrayList();
        try{
            //INICIO SP
             connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            stmt = conn.prepareCall("{call  TIENDAGG.sp_getProductoDetalles (?,?)}");
            stmt.setInt(1, id);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);
            while(rs.next()){
                int id_producto = rs.getInt("id_producto");
                String nombre = rs.getString("nombre_producto");
                int precio = rs.getInt("precio");
                int cantidad = rs.getInt("cantidad");
                String nombre_cat = rs.getString("nombre_cat"); 
                String descripcion_producto = rs.getString("descripcion_producto"); 
                Producto producto = new Producto(id_producto, nombre, 
                        descripcion_producto ,precio, cantidad, nombre_cat);
               
                arreglo.add(producto);
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
    
    public ArrayList<Producto> getProductosFitlrados(int precioFiltro, String categoriaNombre){
        ArrayList<Producto> arreglo = new ArrayList();
        try{
            //INICIO SP
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            stmt = conn.prepareCall("{? = call TIENDAGG.fn_getProductosFitlrados (?,?)}");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.setInt(2, precioFiltro);
            stmt.setString(3, categoriaNombre);
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
            conn.close();
            //FIN SP
        }
        catch(Exception e){ 
            System.out.println("ERROR: No se puede completar la operacion "+e);
        }
        return arreglo;
    }       
    
    
    public boolean putProducto(int codigo, String nombre ,int precio, int cantidad){
        
        boolean exito_operacion;
        try{
            //INICIO SP
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            stmt = conn.prepareCall("{call  TIENDAGG.sp_putProducto (?,?,?,?)}");
            stmt.setInt(1, codigo);
            stmt.setString(2, nombre);
            stmt.setInt(3, precio);
            stmt.setInt(4, cantidad);
            stmt.execute();
            stmt.close();
            exito_operacion = true;
            //FIN SP
            
            mongoClient = new Mongo("LocalHost",27017);
            database = mongoClient.getDB("local");
            collection = database.getCollection("productos");
            
            BasicDBObject query = new BasicDBObject();
            query.put("id_producto", codigo);
            
            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put("nombre_producto", nombre); 
            newDocument.put("precio", precio); 
            newDocument.put("cantidad", cantidad); 
            
            BasicDBObject updateObject = new BasicDBObject();
            updateObject.put("$set", newDocument);
            
            collection.update(query,updateObject);
            mongoClient.close();
            conn.close();
            
        }
        catch(Exception e){ 
            System.out.println("ERROR: No se puede completar la operacion "+e);
            exito_operacion = false;
        }
        return exito_operacion;
    }
    
    public boolean deleteProducto(int codigo){
        
        boolean exito_operacion;
        try{
            //INICIO SP
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            stmt = conn.prepareCall("{call  TIENDAGG.sp_deleteProducto (?)}");
            stmt.setInt(1, codigo);
            stmt.execute();
            stmt.close();
            exito_operacion = true;
            
            mongoClient = new Mongo("LocalHost",27017);
            database = mongoClient.getDB("local");
            collection = database.getCollection("productos");
            collection.remove(new BasicDBObject("id_producto", codigo));
            mongoClient.close();
            conn.close();
            
            //FIN SP
        }
        catch(Exception e){ 
            System.out.println("ERROR: No se puede completar la operacion "+e);
            exito_operacion = false;
        }
        return exito_operacion;
    }
    
    public ArrayList<Producto> getProductosOrden(int id_orden){
        ArrayList<Producto> arreglo = new ArrayList();
       try{
            //INICIO SP
            connectionObj = new ConnectionORCL();
            conn = connectionObj.getConnection();
            rs = null;
            stmt = conn.prepareCall("{call  TIENDAGG.sp_getProductosOrden (?,?)}");
            stmt.setInt(1, id_orden);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet) stmt.getObject(2);
            while(rs.next()){
                int id_producto = rs.getInt("id_producto");
                String nombre = rs.getString("nombre_producto");
                int precio = rs.getInt("precio");
                int cantidad = rs.getInt("cantidad");
                String nombre_cat = rs.getString("nombre_cat"); 
                String descripcion_producto = rs.getString("descripcion_producto"); 
                Producto producto = new Producto(id_producto, nombre, 
                        descripcion_producto ,precio, cantidad, nombre_cat);
               
                arreglo.add(producto);
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
