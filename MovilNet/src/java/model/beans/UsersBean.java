package model.beans;

import hibernate.pojos.Users;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.facade.UsersFacade;
import model.utils.Utils;

/**
 *
 * @author yoshiblacke
 */
@ManagedBean
@SessionScoped
public class UsersBean implements java.io.Serializable {

    private Integer idUsers;
    private int userTypeIdUserType;
    private String userName;
    private String userLastName;
    private String userEmail;
    private Date userBirthday;
    private String userPhone;
    private String userMobile;
    private Date userRegistrationDate;
    private DataModel dataModelUsers;

    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public int getUserTypeIdUserType() {
        return userTypeIdUserType;
    }

    public void setUserTypeIdUserType(int userTypeIdUserType) {
        this.userTypeIdUserType = userTypeIdUserType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Date getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(Date userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

    public void addUsers() {
        Users pUs = new Users(getUserTypeIdUserType(), getUserName(), getUserLastName(), getUserEmail(), getUserBirthday(), getUserPhone(), getUserMobile(), new java.util.Date());
        UsersFacade ltosFe = new UsersFacade();
        String msg = ltosFe.createUsers(pUs);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void prepareModifyUsers() {
        Users pUs = (Users) dataModelUsers.getRowData();
        this.setIdUsers(pUs.getIdUsers());
        this.setUserTypeIdUserType(pUs.getUserTypeIdUserType());
        this.setUserName(pUs.getUserName());
        this.setUserLastName(pUs.getUserLastName());
        this.setUserEmail(pUs.getUserEmail());
        this.setUserBirthday(pUs.getUserBirthday());
        this.setUserPhone(pUs.getUserPhone());
        this.setUserMobile(pUs.getUserMobile());
        this.setUserRegistrationDate(pUs.getUserRegistrationDate());
    }

    public void modifyUsers() {
        Users pUs = new Users(getIdUsers(), getUserTypeIdUserType(), getUserName(), getUserLastName(), getUserEmail(), getUserBirthday(), getUserPhone(), getUserMobile(), new java.util.Date());
        UsersFacade ltosFe = new UsersFacade();
        String msg = ltosFe.updateUsers(pUs);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void dropUsers() {
        Users pUs = (Users) dataModelUsers.getRowData();
        Integer id = pUs.getIdUsers();
        UsersFacade ltosfe = new UsersFacade();
        String msg = ltosfe.deleteUsers(id);
        Utils.infoMsg(msg);
    }

    public DataModel getReadAllUsers() {
        List<Users> list = new UsersFacade().readAllUsers();
        dataModelUsers = new ListDataModel(list);
        return dataModelUsers;
    }

    public Users readUserById(Integer id) {
        Users pUs = new UsersFacade().readUserById(id);
        return pUs;
    }

    public void clearFields() {
        this.setIdUsers(0);
        this.setUserTypeIdUserType(0);
        this.setUserName("");
        this.setUserLastName("");
        this.setUserEmail("");
        this.setUserBirthday(null);
        this.setUserPhone("");
        this.setUserMobile("");
        this.setUserRegistrationDate(null);
    }

}
