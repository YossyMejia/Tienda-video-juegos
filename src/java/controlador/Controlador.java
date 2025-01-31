/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DB.ConnectionMDB;
import java.util.ArrayList;
import modelo.Categoria;
import modelo.Login;
import modelo.MetodosCategoria;
import modelo.MetodosLogin;
import modelo.MetodosProductos;
import modelo.MetodosUsuario;
import modelo.Producto;
import modelo.Usuario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Carrito;
import modelo.Compra;
import modelo.Direccion;
import modelo.MetodosCompra;
import modelo.MetodosDireccion;
import modelo.MetodosSolicitud;
import modelo.MetodosTarjeta;
import modelo.Solicitud;
import modelo.Tarjeta;
/**
 *
 * @author XPC
 */
public class Controlador {
    static Login usuarioAplicacion;
    private MetodosLogin metodosLogin = new MetodosLogin();
    private MetodosUsuario metodosUsuario = new MetodosUsuario();
    private MetodosProductos metodosProducto = new MetodosProductos();
    private MetodosCategoria metodosCategoria = new MetodosCategoria();
    private MetodosSolicitud metodosSolicitud = new MetodosSolicitud();
    private MetodosTarjeta metodosTarjeta = new MetodosTarjeta();
    private MetodosDireccion metodosDireccion = new MetodosDireccion();
    private MetodosCompra metodosCompra = new MetodosCompra();
    
    public Controlador() {
    }

    public static Login getUsuarioAplicacion() {
        return usuarioAplicacion;
    }

    public static void setUsuarioAplicacion(Login usuarioAplicacion) {
        Controlador.usuarioAplicacion = usuarioAplicacion;
    }
    
    
    
    public String verificarLogin(String correo, String contrasena){                 //Funcion encargada de verificar que el login sea correcto
        ArrayList<Login> array = metodosLogin.login(correo, contrasena);
        if(!array.isEmpty()){
            Login datoslogin = array.get(0);
            Usuario usuario = metodosUsuario.getUser(datoslogin.getUser_id()).get(0);
            if(usuario.getTipo()== 1){
                usuarioAplicacion = array.get(0);                                   //Se agrega el usuario de la aplicacion
                return "Administrador";
            }
            else if(usuario.getTipo()== 2){
                usuarioAplicacion = array.get(0);                                   //Se agrega el usuario de la aplicacion
                return "Cliente";
            }
            else if(usuario.getTipo()== 3){
                usuarioAplicacion = array.get(0);                                   //Se agrega el usuario de la aplicacion
                return "Soporte Tecnico";
            }
            else if(usuario.getTipo()== 4){
                usuarioAplicacion = array.get(0);                                   //Se agrega el usuario de la aplicacion
                return "Repartidor";
            }
        }
        return "ERROR";
    }
    
    
    public boolean crearUsuario(String imagen, int identificacion, String nombre, String primer_apellido, //Funcion para guardar un usuario en la BD
            String segundo_apellido, String tipo, String correo, String contrasena){
        boolean estado = metodosUsuario.postUser(imagen, identificacion, nombre, primer_apellido, 
                    segundo_apellido, tipo, correo, contrasena);
       return estado;
    }
    
    
    public boolean crearCategoria(String nombre, String descripcion){               //Funcion para crear una categoria
        boolean estado = metodosCategoria.postCategoria(nombre, descripcion);
        return estado;
    }
    
    
    public boolean crearProducto(String imagen, int id,String nombre,int precio,int cantidad,      //Funcion para crear un producto 
        String descripcion,int categoria){
        boolean estado = metodosProducto.postProducto(imagen, id, nombre, descripcion, precio, cantidad, categoria);
        return estado;
    }
    
    public boolean CrearSolicitud(String descripcion){
        int id_usuario = usuarioAplicacion.getUser_id();
        String fecha_hora = fechaActual();
        boolean estado = metodosSolicitud.postSolicitud(id_usuario,descripcion, fecha_hora);
        return estado;
    }
    
    
    public boolean correoValido(String correo){                         //Funcion para verificar que un correo no este repetido
        ArrayList<Login> lista = metodosLogin.checkCorreo(correo);
        if(lista.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean crearSolucion(int id_solicitud, String respuesta){
        String fecha_hora = fechaActual();
        int id_tecnico = usuarioAplicacion.getUser_id();
        boolean estado = metodosSolicitud.postSolucion(id_tecnico,respuesta, 
                fecha_hora, id_solicitud);
        return estado;
    }
    
    public boolean creaTarjeta(String numero, String nombre, String fecha, int ccv){
        int id_usuario = usuarioAplicacion.getUser_id();
        boolean estado = metodosTarjeta.postTarjeta(id_usuario,numero, nombre,
                fecha, ccv);
        return estado;
    }
    
    public boolean creaDireccion(String provincia, String canton, String distrito, String datosExtra){
        int id_usuario = usuarioAplicacion.getUser_id();
        boolean estado = metodosDireccion.postDireccion(id_usuario,provincia, canton,
                distrito, datosExtra);
        return estado;
    }
    
    public boolean crearCompra(String tarjeta, int direccion){
        int id_usuario = usuarioAplicacion.getUser_id();
        String productos = usuarioAplicacion.getProductos();
        String fecha = fechaActual();
        int total = usuarioAplicacion.getTotalCarrito();
        boolean estado = metodosCompra.postCompra(id_usuario, direccion, productos,
                total, fecha, tarjeta);
        return estado;
    }
    
    public ArrayList<Categoria> obtenerCategorias(){                    //Funcion para obtener todas las categorias
        ArrayList<Categoria> lista = metodosCategoria.getCategorias();
        return lista;
    }
    
    public ArrayList<Producto> obtenerProductos(){                    //Funcion para obtener todOS los productos
        ArrayList<Producto> lista = metodosProducto.getProductos();
        return lista;
    }
    
    public ArrayList<Usuario> obtenerUsuarios(){                    //Funcion para obtener todoS los usuarios
        ArrayList<Usuario> lista = metodosUsuario.getUsers();
        return lista;
    }
    
    public ArrayList<Solicitud> obtenerConsultas(){                    //Funcion para obtener todas las consultas sin hacer
        ArrayList<Solicitud> lista = metodosSolicitud.getSolicitudes();
        return lista;
    }
    
    public ArrayList<Solicitud> obtenerSolicitudDetalle(){                    //Funcion para obtener todas las consultas con sus respuestas
        ArrayList<Solicitud> lista = metodosSolicitud.getSolicitudesSoluciones();
        return lista;
    }
    
    public ArrayList<Solicitud> obtenerDetallesSolicitud(int id){              //Funcion para obtener los detalles de una solicitud
        ArrayList<Solicitud> lista = metodosSolicitud.getDetallesSolicitud(id);
        return lista;
    }
    
    public ArrayList<Solicitud> obtenerSolicitudUsuario(){                    //Funcion para obtener todas las consultas con sus respuestas
        int id_usuario = usuarioAplicacion.getUser_id();
        ArrayList<Solicitud> lista = metodosSolicitud.getSolicitudesSolucionesUsuario(id_usuario);
        return lista;
    }
    
    public ArrayList<Producto> obtenerProducto(int id){
        ArrayList<Producto> lista = metodosProducto.getProductoDetalles(id);
        return lista;
    }
        
    public ArrayList<Producto> obtenerProductosCarrito(){
        ArrayList<Producto> listaFinal = new ArrayList();
        Carrito carrito = usuarioAplicacion.getCarritoCompras();
        for(int i=0; i<carrito.getTamano(); i++){
            int id = carrito.codigoProducto(i);
            listaFinal.addAll(metodosProducto.getProductoDetalles(id));
        }
        return listaFinal;
    }
    
     public ArrayList<Producto> obtenerProductosFiltrados(int precio, String nombreCategoria){
         ArrayList<Producto> lista = metodosProducto.getProductosFitlrados(precio, nombreCategoria);
        return lista;
    }
    
    public ArrayList<Direccion> obtenerDirecciones(){
        int id_usuario = usuarioAplicacion.getUser_id();
        ArrayList<Direccion> lista = metodosDireccion.getDirecciones(id_usuario);
        return lista;
    }
    
    public ArrayList<Tarjeta> obtenerTarjetas(){
        int id_usuario = usuarioAplicacion.getUser_id();
        ArrayList<Tarjeta> lista = metodosTarjeta.getTarjetas(id_usuario);
        return lista;
    }
     
    public ArrayList<Compra> obtenerComprasCliente(){
        int id_usuario = usuarioAplicacion.getUser_id();
        ArrayList<Compra> lista = metodosCompra.getComprasCliente(id_usuario);
        return lista;
    }
    
    public ArrayList<Producto> obtenerProductosOrden(int id_orden){
        ArrayList<Producto> lista = metodosProducto.getProductosOrden(id_orden);
        return lista;
    }
    
    public ArrayList<Compra> obtenerCompras(){
        ArrayList<Compra> lista = metodosCompra.getCompras();
        return lista;
    }
    
    
    public boolean modificarProducto(int id, String nombre, int precio, int cantidad){
        boolean estado = metodosProducto.putProducto(id, nombre, precio, cantidad);
        return estado;
    }
    
    public boolean entregarOrden(int id){
        boolean estado = metodosCompra.putOrdenEntregada(id);
        return estado;
    }
    
    public boolean eliminarProducto(int id){
        boolean estado = metodosProducto.deleteProducto(id);
        return estado;
    }
    
    public boolean aumentarCarrito(int id, int cantidad){
        ArrayList<Producto> producto = metodosProducto.getProductoDetalles(id);
        int precio = producto.get(0).getPrecio();
        boolean estado = usuarioAplicacion.agregarArticuloCarrito(id, cantidad, precio);
        return estado;
    }
    
    public boolean carritoVacio(){
        boolean estado = usuarioAplicacion.carritoVacio();
        return estado;
    }
    
    public void limpiarCarrito(){
        usuarioAplicacion.limpiarCarrito();
    }
    
    public String fechaActual(){
        Date objDate = new Date(); 
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fecha = hourdateFormat.format(objDate);
        return fecha;
    }
}
