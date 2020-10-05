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
    
    public void anadirProducto(int id, int cantidad){
        Producto producto = new Producto(id, cantidad);
        listadoProductos.add(producto);
    }
}
