/*
 * ServicioInventario.java
 *
 * Created on 16 de diciembre 2009, 10:02 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modelo.facade;

import modelo.dao.*;
import modelo.dto.*;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ServicioInventario {
    /** Creates a new instance of ServicioInventario */
    public ServicioInventario() {
    }
  
    public void crearArticulo(ArticuloDTO dto) throws Exception {
        ArticuloDAO dao = new ArticuloDAO();
        dao.append(dto);
    }

    public void actualizarArticulo(ArticuloDTO dto) throws Exception {
        ArticuloDAO dao = new ArticuloDAO();
        dao.update(dto);
    }

    public void borrarArticulo(ArticuloDTO dto) throws Exception {
        ArticuloDAO dao = new ArticuloDAO();
        dao.delete(dto);
    }
    
    public ArticuloDTO consultaArticulo(ArticuloDTO dto) throws Exception {
        ArticuloDAO dao = new ArticuloDAO();
        return dao.read(dto);
    }
    
    public List listarArticulos() throws Exception {
        ArticuloDAO dao = new ArticuloDAO();
        return dao.readAll();
    }
    
    public void registrarMovimientoInventario(MovArticuloDTO dto) throws Exception {
        ArticuloDAO daoArt = new ArticuloDAO();
        ArticuloDTO dtoArt = new ArticuloDTO();
        // asignando la llave 
        dtoArt.setClaveArt(dto.getClaveArt());
        // validar si hay existencias
        if (dto.getTipoMov().equals("S") &&  daoArt.read(dtoArt).getExistencia() < dto.getCantidad()) {
            throw new Exception("No hay existencia suficiente");
        }
        // primero registramos el movimiento del articulo
        MovArticuloDAO dao = new MovArticuloDAO();
        dao.append(dto);
        // obtenemos la informaci�n actual
        dtoArt = daoArt.read(dtoArt);
        // determinamos si sumamos o restamos al inventario
        if (dto.getTipoMov().equals("E")) {
           dtoArt.setExistencia( dtoArt.getExistencia() + dto.getCantidad() );
        } else {
           dtoArt.setExistencia( dtoArt.getExistencia() - dto.getCantidad() );            
        }
        // actualizamos el inventario
        daoArt.update(dtoArt);
    }
    
    public List listarMovimientos(MovArticuloDTO dto) throws Exception {
        MovArticuloDAO dao = new MovArticuloDAO();
        return dao.readAll(dto);
    }
    
}