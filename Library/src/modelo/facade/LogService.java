package modelo.facade;

import modelo.dao.*;
import modelo.dto.*;

public class LogService {

    public LogService() {
    }
    /*Se le llama servicio ya que este seera el medio para
    que se ejecuten las operaciones de mysql*/
    
    /*Metodo para ejecutar la creacion de usuario*/
    public void createUser(LoginDto ldto) throws Exception {
        LoginDao ldao = new LoginDao();
        ldao.create(ldto);
    }

    /*Metodo para la lectura de un usuario especifico*/
    public LoginDto readUser(LoginDto ldto) throws Exception {
        LoginDao ldao = new LoginDao();
        return ldao.read(ldto);
    }
    
    /*Metodo para la actualizacion de usuario*/
    public void updateUser(LoginDto ldto) throws Exception {
        LoginDao ldao = new LoginDao();
        ldao.update(ldto);
    }
    
}