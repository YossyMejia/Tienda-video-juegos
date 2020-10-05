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
public class Solicitud {
    private int id;
    private String pregunta;
    private int id_usuario;
    private int id_tecnico;
    private String respuesta;
    private String fecha;

    public Solicitud(int id, String pregunta, int id_usuario, String fecha) {
        this.id = id;
        this.pregunta = pregunta;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
    }

    public Solicitud(int id, int id_usuario, int id_tecnico, String pregunta, String respuesta ) {
        this.id = id;
        this.pregunta = pregunta;
        this.id_usuario = id_usuario;
        this.id_tecnico = id_tecnico;
        this.respuesta = respuesta;
    }

    public Solicitud(int id_usuario, int id_tecnico, String pregunta, String respuesta, String fecha) {
        this.pregunta = pregunta;
        this.id_usuario = id_usuario;
        this.id_tecnico = id_tecnico;
        this.respuesta = respuesta;
        this.fecha = fecha;
    }
    
    
    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(int id_tecnico) {
        this.id_tecnico = id_tecnico;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
