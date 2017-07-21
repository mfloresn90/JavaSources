/*
 * ArticuloDTO.java
 *
 * Created on 16 de diciembre 2009, 9:21 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;

/**
 *
 * @author Administrador
 */
public class ArticuloDTO implements Serializable {

    private String claveArt;
    private String descripcion;
    private int existencia;
    private double precio;

    /** Creates a new instance of ArticuloDTO */
    public ArticuloDTO() {
    }

    public String getClaveArt() {
        return claveArt;
    }

    public void setClaveArt(String claveArt) {
        this.claveArt = claveArt;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String toString() {
        StringBuffer resultado = new StringBuffer();
        resultado.append("ArticuloDTO:");
        resultado.append("\n claveart = ").append(claveArt);
        resultado.append("\n descripcion = ").append(descripcion);
        resultado.append("\n precio = ").append(precio);
        resultado.append("\n existencia = ").append(existencia);
        return resultado.toString();
    }
}