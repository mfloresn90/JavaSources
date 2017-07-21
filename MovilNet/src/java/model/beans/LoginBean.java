package model.beans;

import hibernate.pojos.Login;
import hibernate.pojos.UserType;
import hibernate.pojos.Users;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.facade.LoginFacade;
import model.facade.UserTypeFacade;
import model.facade.UsersFacade;
import model.utils.Utils;

/**
 *
 * @author yoshiblacke
 */
@ManagedBean
@SessionScoped
public class LoginBean implements java.io.Serializable {

    private Integer idLogin;
    private int idUsers;
    private String loginName;
    private String loginPassword;
    private DataModel dataModelLogin;
    

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public void addLogin() {
        Login pLn = new Login(getIdUsers(), getLoginName(), getLoginPassword());
        LoginFacade ltosFe = new LoginFacade();
        String msg = ltosFe.createLogin(pLn);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void prepareModifyLogin() {
        Login pLn = (Login) dataModelLogin.getRowData();
        this.setIdLogin(pLn.getIdLogin());
        this.setIdUsers(pLn.getIdUsers());
        this.setLoginName(pLn.getLoginName());
        this.setLoginPassword(pLn.getLoginPassword());
    }

    public void modifyLogin() {
        Login pLn = new Login(getIdLogin(), getIdUsers(), getLoginName(), getLoginPassword());
        LoginFacade ltosFe = new LoginFacade();
        String msg = ltosFe.updateLogin(pLn);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void dropLogin() {
        Login pLn = (Login) dataModelLogin.getRowData();
        Integer id = pLn.getIdLogin();
        LoginFacade ltosfe = new LoginFacade();
        String msg = ltosfe.deleteLogin(id);
        Utils.infoMsg(msg);
    }

    public DataModel getReadAllLogin() {
        List<Login> list = new LoginFacade().readAllLogin();
        dataModelLogin = new ListDataModel(list);
        return dataModelLogin;
    }

    public Login readLoginById(Integer id) {
        Login pLn = new LoginFacade().readLoginById(id);
        return pLn;
    }

    public void clearFields() {
        this.setIdLogin(0);
        this.setIdUsers(0);
        this.setLoginName("");
        this.setLoginPassword("");
    }

    public void findLoginUser() {
        Login pLn = new LoginFacade().findLoginUser(getLoginName(), getLoginPassword());
        
        if (pLn.getIdUsers() != 0) {
            Users pUs = new UsersFacade().readUserById(pLn.getIdUsers());
            UserType pUrTe = new UserTypeFacade().readUserTypeById(pUs.getUserTypeIdUserType());
            
            if (Integer.parseInt(pUs.getUserTypeIdUserType() + "") != 1) {
                Utils.createObjectSession(pUs, "Users");
                Utils.createObjectSession(pUrTe, "UserType");
                Utils.redirectPage("faces/user/index.xhtml");
            } else {
                Utils.createObjectSession(pUs, "Users");
                Utils.createObjectSession(pUrTe, "UserType");
                Utils.redirectPage("faces/admin/index.xhtml");
            }
        } else {
            Utils.erroMsg("Usuario y/o contraseña incorrecto");
        }
    }
    
    public void faseLogout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        Utils.redirectPage("");
    }

}
