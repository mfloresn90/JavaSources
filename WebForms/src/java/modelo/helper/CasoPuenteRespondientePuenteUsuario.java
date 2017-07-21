package modelo.helper;

/**
 *
 * @author yoshi
 */
public class CasoPuenteRespondientePuenteUsuario implements java.io.Serializable {

    private Integer idCasoPuenteRespondientePuenteUsuario;
    private Integer idUsuario;
    private Integer idCasoPuenteRespondiente;

    public Integer getIdCasoPuenteRespondientePuenteUsuario() {
        return idCasoPuenteRespondientePuenteUsuario;
    }

    public void setIdCasoPuenteRespondientePuenteUsuario(Integer idCasoPuenteRespondientePuenteUsuario) {
        this.idCasoPuenteRespondientePuenteUsuario = idCasoPuenteRespondientePuenteUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCasoPuenteRespondiente() {
        return idCasoPuenteRespondiente;
    }

    public void setIdCasoPuenteRespondiente(Integer idCasoPuenteRespondiente) {
        this.idCasoPuenteRespondiente = idCasoPuenteRespondiente;
    }

}
