/*
 * MovArticuloDTO.java
 *
 * Created on 16 de diciembre 2009, 09:42 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modelo.dto;

import java.util.Date;

/**
 *
 * @author Administrador
 */
public class MovArticuloDTO {
    private String claveArt;
    private int folio;
    private Date fecha;
    private String tipoMov;
    private int cantidad;
    
    /**
     * Para guardar la descripcion del articulo
     * */
    private String descripcion;
    
    /** Creates a new instance of MovArticuloDTO */
    public MovArticuloDTO() {
    }

    public String getClaveArt() {
        return claveArt;
    }

    public void setClaveArt(String claveArt) {
        this.claveArt = claveArt;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}