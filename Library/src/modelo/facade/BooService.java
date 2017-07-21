package modelo.facade;

import modelo.dao.*;
import modelo.dto.*;

public class BooService {

    public BooService() {
    }

    /*Se le llama servicio ya que este seera el medio para
    que se ejecuten las operaciones de mysql*/
    
    /*Metodo para ejecutar la creacion de libros*/
    public void createBook(BookDto bdto) throws Exception {
        BookDao bdao = new BookDao();
        bdao.create(bdto);
    }
    
    /*Metodo para la lectura de un libro especifico*/
    public BookDto readBook(BookDto bdto) throws Exception {
        BookDao bdao = new BookDao();
        return bdao.read(bdto);
    }
    
    /*Metodo para la actualizacion de libro*/
    public void updateBook(BookDto bdto) throws Exception {
        BookDao bdao = new BookDao();
        bdao.update(bdto);
    }
    
    /*Metodo para la eliminacion de libro*/
    public void deleteBook(BookDto bdto) throws Exception {
        BookDao bdao = new BookDao();
        bdao.delete(bdto);
    }
    
}