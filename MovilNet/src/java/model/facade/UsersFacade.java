package model.facade;

import model.dao.UsersDao;
import hibernate.pojos.Users;
import java.util.List;

public class UsersFacade {
    
    UsersDao cdao = null;

    public UsersFacade() {
        cdao = new UsersDao();
    }
    
    public String createUsers(Users pUs) {
        return cdao.createUsers(pUs);
    }
    
    public List<Users> readAllUsers() {
        return cdao.readAllUsers();
    }
    
    public Users readUserById(Integer id) {
        return cdao.readUserById(id);
    }

    public String updateUsers(Users pUs) {
        return cdao.updateUsers(pUs);
    }
    
    public String deleteUsers(Integer idUser) {
        return cdao.deleteUsers(idUser);
    }
    
}