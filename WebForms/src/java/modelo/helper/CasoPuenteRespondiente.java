package modelo.helper;

/**
 *
 * @author yoshi
 */
public class CasoPuenteRespondiente implements java.io.Serializable {

    private Integer idCasoPuenteRespondiente;
    private Integer idCaso;
    private Integer idRespondiente;
    private String casoPuenteRespondienteDelito;
    private String casoPuenteRespondienteDescripcion;
    private String casoPuenteRespondienteFecha;

    public Integer getIdCasoPuenteRespondiente() {
        return idCasoPuenteRespondiente;
    }

    public void setIdCasoPuenteRespondiente(Integer idCasoPuenteRespondiente) {
        this.idCasoPuenteRespondiente = idCasoPuenteRespondiente;
    }

    public Integer getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(Integer idCaso) {
        this.idCaso = idCaso;
    }

    public Integer getIdRespondiente() {
        return idRespondiente;
    }

    public void setIdRespondiente(Integer idRespondiente) {
        this.idRespondiente = idRespondiente;
    }

    public String getCasoPuenteRespondienteDelito() {
        return casoPuenteRespondienteDelito;
    }

    public void setCasoPuenteRespondienteDelito(String casoPuenteRespondienteDelito) {
        this.casoPuenteRespondienteDelito = casoPuenteRespondienteDelito;
    }

    public String getCasoPuenteRespondienteDescripcion() {
        return casoPuenteRespondienteDescripcion;
    }

    public void setCasoPuenteRespondienteDescripcion(String casoPuenteRespondienteDescripcion) {
        this.casoPuenteRespondienteDescripcion = casoPuenteRespondienteDescripcion;
    }

    public String getCasoPuenteRespondienteFecha() {
        return casoPuenteRespondienteFecha;
    }

    public void setCasoPuenteRespondienteFecha(String casoPuenteRespondienteFecha) {
        this.casoPuenteRespondienteFecha = casoPuenteRespondienteFecha;
    }

}
