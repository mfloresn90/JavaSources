package model.utils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yoshiblacke
 */

@ManagedBean
public class Utils {
    
    private static final String title = "MovilNet";
    
    public static void createObjectSession(Object obj, String name) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        session.setAttribute(name, obj);
    }
    
    public static void redirectPage(String page) {
        String url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url + "/" + page);
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void erroMsg(String txt) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, txt);
        FacesContext.getCurrentInstance().addMessage(txt, msg);
    }
    
    public static void infoMsg(String txt) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, title, txt);
        FacesContext.getCurrentInstance().addMessage(txt, msg);
    }
    
}
