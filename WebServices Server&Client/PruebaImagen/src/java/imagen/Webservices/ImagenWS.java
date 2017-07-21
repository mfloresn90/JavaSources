/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen.Webservices;

import imagen.dao.imagenDAO;
import imagen.pojos.Imagen;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Rata
 */
@WebService(serviceName = "ImagenWS")
public class ImagenWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregar")
    public String agregar(@WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion) {
        //TODO write your implementation code here:
        Imagen i = new Imagen(nombre, descripcion);
        imagenDAO imagenDAO = new imagenDAO();
        imagenDAO.ingresarImagen(i);
        
        System.out.println("3dsvsdf"+ nombre + descripcion);
        return "Imagen ingresada";
    }

    /**
     * Web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "consulta")
    public Imagen consulta(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        //Imagen i = new  im
        imagenDAO imagenDAO = new imagenDAO();
        Imagen im = imagenDAO.consultarImagen(id);
        return im;
    }
}
