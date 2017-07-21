package modelo.helper;

/**
 *
 * @author yoshi
 */
public class CtoEstadoHelper implements java.io.Serializable {

    private Integer idCtoEstado;
    private String ctoEstadoNombre;
    private String ctoEstadoLatitud;
    private String ctoEstadoLongitud;

    public Integer getIdCtoEstado() {
        return idCtoEstado;
    }

    public void setIdCtoEstado(Integer idCtoEstado) {
        this.idCtoEstado = idCtoEstado;
    }

    public String getCtoEstadoNombre() {
        return ctoEstadoNombre;
    }

    public void setCtoEstadoNombre(String ctoEstadoNombre) {
        this.ctoEstadoNombre = ctoEstadoNombre;
    }

    public String getCtoEstadoLatitud() {
        return ctoEstadoLatitud;
    }

    public void setCtoEstadoLatitud(String ctoEstadoLatitud) {
        this.ctoEstadoLatitud = ctoEstadoLatitud;
    }

    public String getCtoEstadoLongitud() {
        return ctoEstadoLongitud;
    }

    public void setCtoEstadoLongitud(String ctoEstadoLongitud) {
        this.ctoEstadoLongitud = ctoEstadoLongitud;
    }

}
