package hibernate.pojos;
// Generated 25-nov-2015 20:27:10 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "Users", catalog = "movilNet"
)
public class Users implements java.io.Serializable {

    private Integer idUsers;
    private int userTypeIdUserType;
    private String userName;
    private String userLastName;
    private String userEmail;
    private Date userBirthday;
    private String userPhone;
    private String userMobile;
    private Date userRegistrationDate;

    public Users() {
    }

    public Users(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public Users(int userTypeIdUserType, String userName, String userLastName, String userEmail, Date userBirthday, String userPhone, String userMobile, Date userRegistrationDate) {
        this.userTypeIdUserType = userTypeIdUserType;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userBirthday = userBirthday;
        this.userPhone = userPhone;
        this.userMobile = userMobile;
        this.userRegistrationDate = userRegistrationDate;
    }

    public Users(Integer idUsers, int userTypeIdUserType, String userName, String userLastName, String userEmail, Date userBirthday, String userPhone, String userMobile, Date userRegistrationDate) {
        this.idUsers = idUsers;
        this.userTypeIdUserType = userTypeIdUserType;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userBirthday = userBirthday;
        this.userPhone = userPhone;
        this.userMobile = userMobile;
        this.userRegistrationDate = userRegistrationDate;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idUsers", unique = true, nullable = false)
    public Integer getIdUsers() {
        return this.idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }

    @Column(name = "UserType_idUserType", nullable = false)
    public int getUserTypeIdUserType() {
        return this.userTypeIdUserType;
    }

    public void setUserTypeIdUserType(int userTypeIdUserType) {
        this.userTypeIdUserType = userTypeIdUserType;
    }

    @Column(name = "userName", nullable = false, length = 45)
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "userLastName", nullable = false, length = 45)
    public String getUserLastName() {
        return this.userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @Column(name = "userEmail", nullable = false, length = 45)
    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "userBirthday", nullable = false, length = 10)
    public Date getUserBirthday() {
        return this.userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    @Column(name = "userPhone", length = 45)
    public String getUserPhone() {
        return this.userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Column(name = "userMobile", length = 45)
    public String getUserMobile() {
        return this.userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "userRegistrationDate", length = 19)
    public Date getUserRegistrationDate() {
        return this.userRegistrationDate;
    }

    public void setUserRegistrationDate(Date userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

}