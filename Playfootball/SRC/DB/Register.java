/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yoshi_black90
 */
@Entity
@Table(name = "register")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Register.findAll", query = "SELECT r FROM Register r"),
    @NamedQuery(name = "Register.findByFolio", query = "SELECT r FROM Register r WHERE r.folio = :folio"),
    @NamedQuery(name = "Register.findByFecha", query = "SELECT r FROM Register r WHERE r.fecha = :fecha")})
public class Register implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "folio")
    private String folio;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "email", referencedColumnName = "email")
    @ManyToOne
    private Player email;
    @JoinColumn(name = "idLeague", referencedColumnName = "idLeague")
    @ManyToOne
    private League idLeague;

    public Register() {
    }

    public Register(String folio) {
        this.folio = folio;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        String oldFolio = this.folio;
        this.folio = folio;
        changeSupport.firePropertyChange("folio", oldFolio, folio);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public Player getEmail() {
        return email;
    }

    public void setEmail(Player email) {
        Player oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public League getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(League idLeague) {
        League oldIdLeague = this.idLeague;
        this.idLeague = idLeague;
        changeSupport.firePropertyChange("idLeague", oldIdLeague, idLeague);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (folio != null ? folio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Register)) {
            return false;
        }
        Register other = (Register) object;
        if ((this.folio == null && other.folio != null) || (this.folio != null && !this.folio.equals(other.folio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Register[ folio=" + folio + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
