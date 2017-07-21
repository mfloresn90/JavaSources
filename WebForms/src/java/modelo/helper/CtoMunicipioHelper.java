package modelo.helper;

/**
 *
 * @author yoshi
 */
public class CtoMunicipioHelper implements java.io.Serializable {

    private Integer idCtoMunicipio;
    private String ctoMunicipioNombre;
    private Integer idCtoEstado;
    private String ctoMunicipioLatitud;
    private String ctoMunicipioLongitud;

    public Integer getIdCtoMunicipio() {
        return idCtoMunicipio;
    }

    public void setIdCtoMunicipio(Integer idCtoMunicipio) {
        this.idCtoMunicipio = idCtoMunicipio;
    }

    public String getCtoMunicipioNombre() {
        return ctoMunicipioNombre;
    }

    public void setCtoMunicipioNombre(String ctoMunicipioNombre) {
        this.ctoMunicipioNombre = ctoMunicipioNombre;
    }

    public Integer getIdCtoEstado() {
        return idCtoEstado;
    }

    public void setIdCtoEstado(Integer idCtoEstado) {
        this.idCtoEstado = idCtoEstado;
    }

    public String getCtoMunicipioLatitud() {
        return ctoMunicipioLatitud;
    }

    public void setCtoMunicipioLatitud(String ctoMunicipioLatitud) {
        this.ctoMunicipioLatitud = ctoMunicipioLatitud;
    }

    public String getCtoMunicipioLongitud() {
        return ctoMunicipioLongitud;
    }

    public void setCtoMunicipioLongitud(String ctoMunicipioLongitud) {
        this.ctoMunicipioLongitud = ctoMunicipioLongitud;
    }

}
