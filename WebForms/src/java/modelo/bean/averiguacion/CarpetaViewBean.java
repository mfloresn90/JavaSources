package modelo.bean.averiguacion;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.helper.CasoPuenteRespondiente;

/**
 *
 * @author dark_
 */
@ManagedBean
@ViewScoped
public class CarpetaViewBean implements java.io.Serializable {

    private CasoPuenteRespondiente viewCarpeta;

    public CasoPuenteRespondiente getViewCarpeta() {
        return viewCarpeta;
    }

    public void setViewCarpeta(CasoPuenteRespondiente viewCarpeta) {
        this.viewCarpeta = viewCarpeta;
    }

    public CarpetaViewBean() {
        viewCarpeta = new CasoPuenteRespondiente();
    }
    
}
