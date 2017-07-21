/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author fifa
 */
public class PruebaDTO3 implements Serializable
    {
    private int folio;
    private String idLeague;
    private Date fecha;
    private String email;

    /**
     * @return the folio
     */
    public int getFolio() {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     * @return the idLeague
     */
    public String getIdLeague() {
        return idLeague;
    }

    /**
     * @param idLeague the idLeague to set
     */
    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }


}
