/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen.bean;

import imagen.webservices.Imagen;
import imagen.webservices.ImagenWS_Service;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Rata
 */
@ManagedBean
@RequestScoped
public class Consultar {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PruebaImagen/ImagenWS.wsdl")
    private ImagenWS_Service service;
    private int id;

    public String getContenidoImagen() {
        return contenidoImagen;
    }

    public void setContenidoImagen(String contenidoImagen) {
        this.contenidoImagen = contenidoImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    private String contenidoImagen;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Consultar
     */
    
    
    public Imagen consultaImagen() {
        consulta(id);
        
        return null;
    }
    private Imagen consulta(int id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        imagen.webservices.ImagenWS port = service.getImagenWSPort();
        Imagen tmp = port.consulta(id);
        contenidoImagen = tmp.getImagen();
        descripcion = tmp.getDescripcion();
        return null;
    }  
}
