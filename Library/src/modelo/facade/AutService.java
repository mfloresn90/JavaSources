package modelo.facade;

import modelo.dao.*;
import modelo.dto.*;

public class AutService {

    public AutService() {
    }
    
    /*Se le llama servicio ya que este seera el medio para
    que se ejecuten las operaciones de mysql*/
    
    /*Metodo para ejecutar la creacion de autores*/
    public void createAuthor(AuthorDto adto) throws Exception {
        AuthorDao adao = new AuthorDao();
        adao.create(adto);
    }
    
    /*Metodo para la lectura de un autor especifico*/
    public AuthorDto readAuthor(AuthorDto adto) throws Exception {
        AuthorDao adao = new AuthorDao();
        return adao.read(adto);
    }
    
    /*Metodo para la actualizacion de autor*/
    public void updateAuthor(AuthorDto adto) throws Exception {
        AuthorDao adao = new AuthorDao();
        adao.update(adto);
    }
    
    /*Metodo para la eliminacion de editorial*/
    public void deleteAuthor(AuthorDto adto) throws Exception {
        AuthorDao adao = new AuthorDao();
        adao.delete(adto);
    }
    
}