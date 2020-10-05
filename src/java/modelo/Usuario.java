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
public class Usuario {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int tipo;
    
    private String descripcionTipo;
    private String correo;
    

    public Usuario(){
        tipo = 0;   //Inicializa un usuario como tipo invitado sin datos
    }

    public Usuario(String nombre, String apellido1, String apellido2, String descripcionTipo, String correo) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.descripcionTipo = descripcionTipo;
        this.correo = correo;
    }
    
    public Usuario(int id, String nombre, String apellido1, String apellido2, int tipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.tipo = tipo;
    }
    

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
    
}
