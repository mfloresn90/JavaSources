package modelo.helper;

/**
 *
 * @author yoshi
 */
public class CasoHelper implements java.io.Serializable {

    private Integer idCaso;
    private Integer idUsuario;
    private String casoFechaCreacion;
    private String casoDelito;
    private String casoDescripcion;
    private String casoStatus;
    private String casoAveriguacion;
    private String casoNumRegistro;

    public Integer getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(Integer idCaso) {
        this.idCaso = idCaso;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCasoFechaCreacion() {
        return casoFechaCreacion;
    }

    public void setCasoFechaCreacion(String casoFechaCreacion) {
        this.casoFechaCreacion = casoFechaCreacion;
    }

    public String getCasoDelito() {
        return casoDelito;
    }

    public void setCasoDelito(String casoDelito) {
        this.casoDelito = casoDelito;
    }

    public String getCasoDescripcion() {
        return casoDescripcion;
    }

    public void setCasoDescripcion(String casoDescripcion) {
        this.casoDescripcion = casoDescripcion;
    }

    public String getCasoStatus() {
        return casoStatus;
    }

    public void setCasoStatus(String casoStatus) {
        this.casoStatus = casoStatus;
    }

    public String getCasoAveriguacion() {
        return casoAveriguacion;
    }

    public void setCasoAveriguacion(String casoAveriguacion) {
        this.casoAveriguacion = casoAveriguacion;
    }

    public String getCasoNumRegistro() {
        return casoNumRegistro;
    }

    public void setCasoNumRegistro(String casoNumRegistro) {
        this.casoNumRegistro = casoNumRegistro;
    }

}
