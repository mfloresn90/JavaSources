package model.facade;

import model.dao.LoginDao;
import hibernate.pojos.Login;
import java.util.List;

public class LoginFacade {
    
    LoginDao cdao = null;

    public LoginFacade() {
        cdao = new LoginDao();
    }
    
    public String createLogin(Login pLn) {
        return cdao.createLogin(pLn);
    }
    
    public List<Login> readAllLogin() {
        return cdao.readAllLogin();
    }
    
    public Login readLoginById(Integer id) {
        return cdao.readLoginById(id);
    }
    
    public Login findLoginUser(String name, String pass) {
        return cdao.findLoginUser(name, pass);
    }

    public String updateLogin(Login pLn) {
        return cdao.updateLogin(pLn);
    }
    
    public String deleteLogin(Integer idLn) {
        return cdao.deleteLogin(idLn);
    }
    
}