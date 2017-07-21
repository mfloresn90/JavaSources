/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen.bean;


import imagen.webservices.ImagenWS_Service;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;
import java.io.*;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;



/**
 *
 * @author Rata
 */
@ManagedBean
@SessionScoped
public class agregarImagen {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PruebaImagen/ImagenWS.wsdl")
    private ImagenWS_Service service;
    private Integer id;
    private byte[] imagen;
    private UploadedFile file;
    private String descripcion;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Creates a new instance of agregarImagen
     */  
    
    public String guardarImagen(){
  
        String salida = "";
        String filename = FilenameUtils.getName(file.getFileName());
        try {
            InputStream input = file.getInputstream();
            byte[] imagen = IOUtils.toByteArray(input);
            salida = agregar(imagen, descripcion);
        } catch (IOException ex) {
            Logger.getLogger(agregarImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("jjjjjjjjjj");
        return salida;
    } 
    private String agregar(byte[] nombre, java.lang.String descripcion) {

        Base64.Encoder encoder = Base64.getEncoder();
        String tmp = encoder.encodeToString(nombre);
        imagen.webservices.ImagenWS port = service.getImagenWSPort();
        System.out.println("prueba22j");
        return port.agregar(tmp, descripcion);
    }
}
