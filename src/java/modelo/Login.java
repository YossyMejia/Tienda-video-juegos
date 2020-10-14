/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import modelo.Carrito;
/**
 *
 * @author XPC
 */
public class Login {
    private String user;
    private String password;
    private int user_id;
    private Carrito carritoCompras = new Carrito();
    
    public Login(String user, String password, int user_id){
        this.user = user;
        this.password = password;
        this.user_id = user_id;
    }

    public Login(String user) {
        this.user = user;
    }
    
    public Login(){
        
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Carrito getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(Carrito carritoCompras) {
        this.carritoCompras = carritoCompras;
    }
    
    
    
    public boolean agregarArticuloCarrito(int id, int cantidad, int precio){
        if(carritoCompras.verificarProducto(id) == true){
            carritoCompras.anadirProducto(id, cantidad, precio);
            return true;
        }
        return false;
    }
    
    public boolean carritoVacio(){
        if(carritoCompras.getTamano() == 0){
            return true;
        }
        return false;
    }
    
    public String getProductos(){
        String productos = carritoCompras.obtenerProductos();
        return productos;
    }
    
    public int getTotalCarrito(){
        int total = carritoCompras.obtenerTotal();
        return total;
    }
    
    public void limpiarCarrito(){
        carritoCompras.limpiar();
    }
    
    
}