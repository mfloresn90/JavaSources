package modelo.helper;

/**
 *
 * @author yoshi
 */
public class CtoColoniaHelper implements java.io.Serializable {

    private Integer idCtoColonia;
    private String ctoColoniaNombre;
    private Integer idCtoMunicipio;
    private String ctoColoniaLatitud;
    private String ctoColoniaLongitud;

    public Integer getIdCtoColonia() {
        return idCtoColonia;
    }

    public void setIdCtoColonia(Integer idCtoColonia) {
        this.idCtoColonia = idCtoColonia;
    }

    public String getCtoColoniaNombre() {
        return ctoColoniaNombre;
    }

    public void setCtoColoniaNombre(String ctoColoniaNombre) {
        this.ctoColoniaNombre = ctoColoniaNombre;
    }

    public Integer getIdCtoMunicipio() {
        return idCtoMunicipio;
    }

    public void setIdCtoMunicipio(Integer idCtoMunicipio) {
        this.idCtoMunicipio = idCtoMunicipio;
    }

    public String getCtoColoniaLatitud() {
        return ctoColoniaLatitud;
    }

    public void setCtoColoniaLatitud(String ctoColoniaLatitud) {
        this.ctoColoniaLatitud = ctoColoniaLatitud;
    }

    public String getCtoColoniaLongitud() {
        return ctoColoniaLongitud;
    }

    public void setCtoColoniaLongitud(String ctoColoniaLongitud) {
        this.ctoColoniaLongitud = ctoColoniaLongitud;
    }

}
