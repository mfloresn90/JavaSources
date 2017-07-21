package modelo.facade;

import modelo.dao.*;
import modelo.dto.*;

public class EdiService {

    public EdiService() {
    }

    /*Se le llama servicio ya que este seera el medio para
    que se ejecuten las operaciones de mysql*/
    
    /*Metodo para ejecutar la creacion de editoriales*/
    public void createEditorial(EditorialDto edto) throws Exception {
        EditorialDao edao = new EditorialDao();
        edao.create(edto);
    }
    
    /*Metodo para la lectura de uns editorial especifica*/
    public EditorialDto readEditorial(EditorialDto edto) throws Exception {
        EditorialDao edao = new EditorialDao();
        return edao.read(edto);
    }
    
    /*Metodo para la actualizacion de editorial*/
    public void updateEditorial(EditorialDto edto) throws Exception {
        EditorialDao edao = new EditorialDao();
        edao.update(edto);
    }
    
    /*Metodo para la eliminacion de editorial*/
    public void deleteEditorial(EditorialDto edto) throws Exception {
        EditorialDao edao = new EditorialDao();
        edao.delete(edto);
    }
    
}