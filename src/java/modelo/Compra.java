/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author XPC
 */
public class Compra {
    private int id_usuario;
    private int id_orden;
    private String fecha_orden;
    private String estado_orden;
    private String detalles_orden;
    private int monto;

    public Compra(int id_usuario, int id_orden, String fecha_orden, String estado_orden, String detalles_orden, int monto) {
        this.id_usuario = id_usuario;
        this.id_orden = id_orden;
        this.fecha_orden = fecha_orden;
        this.estado_orden = estado_orden;
        this.detalles_orden = detalles_orden;
        this.monto = monto;
    }

    
    
    public Compra(int id_orden, String fecha_orden, String estado_orden, String detalles_orden, int monto) {
        this.id_orden = id_orden;
        this.fecha_orden = fecha_orden;
        this.estado_orden = estado_orden;
        this.detalles_orden = detalles_orden;
        this.monto = monto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    
    
    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public String getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(String fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public String getEstado_orden() {
        return estado_orden;
    }

    public void setEstado_orden(String estado_orden) {
        this.estado_orden = estado_orden;
    }

    public String getDetalles_orden() {
        return detalles_orden;
    }

    public void setDetalles_orden(String detalles_orden) {
        this.detalles_orden = detalles_orden;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    
    
}
