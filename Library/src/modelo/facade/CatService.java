package modelo.facade;

import modelo.dao.*;
import modelo.dto.*;

public class CatService {

    public CatService() {
    }

    /*Se le llama servicio ya que este seera el medio para
    que se ejecuten las operaciones de mysql*/
    
    /*Metodo para ejecutar la creacion de categorias*/
    public void createCategory(CategoryDto cdto) throws Exception {
        CategoryDao cdao = new CategoryDao();
        cdao.create(cdto);
    }
    
    /*Metodo para la lectura de una categoria especifica*/
    public CategoryDto readCategory(CategoryDto cdto) throws Exception {
        CategoryDao cdao = new CategoryDao();
        return cdao.read(cdto);
    }
    
    /*Metodo para la actualizacion de categoria*/
    public void updateCategory(CategoryDto cdto) throws Exception {
        CategoryDao cdao = new CategoryDao();
        cdao.update(cdto);
    }
    
    /*Metodo para la eliminacion de categoria*/
    public void deleteCategory(CategoryDto cdto) throws Exception {
        CategoryDao cdao = new CategoryDao();
        cdao.delete(cdto);
    }
    
}