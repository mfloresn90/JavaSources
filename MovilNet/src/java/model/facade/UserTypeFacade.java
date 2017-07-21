package model.facade;

import model.dao.UserTypeDao;
import hibernate.pojos.UserType;
import java.util.List;

public class UserTypeFacade {
    
    UserTypeDao cdao = null;

    public UserTypeFacade() {
        cdao = new UserTypeDao();
    }
    
    public String createUserType(UserType pUrTe) {
        return cdao.createUserType(pUrTe);
    }
    
    public List<UserType> readAllUserType() {
        return cdao.readAllUserType();
    }
    
    public UserType readUserTypeById(Integer id) {
        return cdao.readUserTypeById(id);
    }

    public String updateUserType(UserType pUrTe) {
        return cdao.updateUserType(pUrTe);
    }
    
    public String deleteUserType(Integer idUrTe) {
        return cdao.deleteUserType(idUrTe);
    }
    
}