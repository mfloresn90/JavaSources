/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;

/**
 *
 * @author Administrador
 */
public class PruebaDTO implements Serializable{
    private int  idLeague;
    private String nombre;


    /**
     * @return the email
     */
    public int getidLeague() {
        return idLeague;
    }

    /**
     * @param email the email to set
     */
    public void setidLeague(int league) {
        this.idLeague = league;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


   
}
