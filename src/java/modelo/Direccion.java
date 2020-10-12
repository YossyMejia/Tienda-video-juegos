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
public class Direccion {
    private int id;
    private String provincia;
    private String canton;
    private String distrito;
    private String datos_extra;

   

    public Direccion(int id, String provincia, String canton, String distrito, String datos_extra) {
        this.id = id;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.datos_extra = datos_extra;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDatos_extra() {
        return datos_extra;
    }

    public void setDatos_extra(String datos_extra) {
        this.datos_extra = datos_extra;
    }
    
    
}
