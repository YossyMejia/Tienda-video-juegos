/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.Producto;
/**
 *
 * @author XPC
 */
public class Carrito {
    private ArrayList<Producto> listadoProductos = new ArrayList();
    
    public void anadirProducto(int id, int cantidad, int precio){
        Producto producto = new Producto(id, cantidad, precio);
        listadoProductos.add(producto);
    }
    
    public int getTamano(){
        return listadoProductos.size();
    }
    
    public int codigoProducto(int producto){
        return listadoProductos.get(producto).codigo;
    }
    
    public boolean verificarProducto(int id){
        for(int i=0; i<listadoProductos.size(); i++){
            if(listadoProductos.get(i).getCodigo() == id){
                return false;
            }
        }
        return true;
    }
    
    public String obtenerProductos(){
        String productos = "";
        for(int i=0; i<listadoProductos.size(); i++){
            productos += listadoProductos.get(i).getCodigo()+" ";
        }
        return productos;
    }
    
    public int obtenerTotal(){
        int total = 0;
        for(int i=0; i<listadoProductos.size(); i++){
            total += listadoProductos.get(i).getPrecio();
        }
        return total;
    }
    
    public void limpiar(){
        listadoProductos.clear();
    }
    
}
