package model.beans;

import hibernate.pojos.UserType;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.facade.UserTypeFacade;
import model.utils.Utils;

/**
 *
 * @author yoshiblacke
 */
@ManagedBean
@SessionScoped
public class UserTypeBean implements java.io.Serializable {

    private Integer idUserType;
    private String descType;
    private DataModel dataModelUserType;

    public Integer getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(Integer idUserType) {
        this.idUserType = idUserType;
    }

    public String getDescType() {
        return descType;
    }

    public void setDescType(String descType) {
        this.descType = descType;
    }

    public String addUserType() {
        UserType pUrTe = new UserType(getDescType());
        UserTypeFacade ltosFe = new UserTypeFacade();
        String msg = ltosFe.createUserType(pUrTe);
        Utils.infoMsg(msg);
        clearFields();
        return "";
    }

    public void prepareModifyUserType() {
        UserType pUrTe = (UserType) dataModelUserType.getRowData();
        this.setIdUserType(pUrTe.getIdUserType());
        this.setDescType(pUrTe.getDescType());
    }

    public void modifyUserType() {
        UserType pUrTe = new UserType(getIdUserType(), getDescType());
        UserTypeFacade ltosFe = new UserTypeFacade();
        String msg = ltosFe.updateUserType(pUrTe);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void dropUserType() {
        UserType pUrTe = (UserType) dataModelUserType.getRowData();
        Integer id = pUrTe.getIdUserType();
        UserTypeFacade ltosfe = new UserTypeFacade();
        String msg = ltosfe.deleteUserType(id);
        Utils.infoMsg(msg);
    }

    public DataModel getReadAllUserType() {
        List<UserType> list = new UserTypeFacade().readAllUserType();
        dataModelUserType = new ListDataModel(list);
        return dataModelUserType;
    }

    public UserType readUserTypeById(Integer id) {
        UserType pUrTe = new UserTypeFacade().readUserTypeById(id);
        return pUrTe;
    }

    public void clearFields() {
        this.setIdUserType(0);
        this.setDescType("");
    }

}
