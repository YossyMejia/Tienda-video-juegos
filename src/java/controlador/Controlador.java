/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
import modelo.MetodosSolicitud;
import modelo.Solicitud;
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
        }
        return "ERROR";
    }
    
    
    public boolean crearUsuario(int identificacion, String nombre, String primer_apellido, //Funcion para guardar un usuario en la BD
            String segundo_apellido, String tipo, String correo, String contrasena){
        boolean estado = metodosUsuario.postUser(identificacion, nombre, primer_apellido, 
                    segundo_apellido, tipo, correo, contrasena);
       return estado;
    }
    
    
    public boolean crearCategoria(String nombre, String descripcion){               //Funcion para crear una categoria
        boolean estado = metodosCategoria.postCategoria(nombre, descripcion);
        return estado;
    }
    
    
    public boolean crearProducto(int id,String nombre,int precio,int cantidad,      //Funcion para crear un producto
        String descripcion,int categoria){
        boolean estado = metodosProducto.postProducto(id, nombre, descripcion, precio, cantidad, categoria);
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
    
    public ArrayList<Solicitud> obtenerSolicitudDetalle(){                    //Funcion para obtener todas las consultas sin hacer
        ArrayList<Solicitud> lista = metodosSolicitud.getSolicitudesSoluciones();
        return lista;
    }
    
    public boolean modificarProducto(int id, String nombre, int precio, int cantidad){
        boolean estado = metodosProducto.putProducto(id, nombre, precio, cantidad);
        return estado;
    }
    
    public String fechaActual(){
        Date objDate = new Date(); 
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fecha = hourdateFormat.format(objDate);
        return fecha;
    }
}
