/*
 * InventarioDelegate.java
 *
 * Created on 16 de diciembre 2009, 10:02 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package modelo.delegate;

import modelo.dto.*;
import modelo.facade.*;

import java.util.List;

/**
 *
 * @author Administrador
 */
public class InventarioDelegate {

    /** Creates a new instance of InventarioDelegate */
    public InventarioDelegate() {
    }

    public void crearArticulo(ArticuloDTO dto) throws Exception {
        ServicioInventario serv = new ServicioInventario();
        serv.crearArticulo(dto);
    }

    public void actualizarArticulo(ArticuloDTO dto) throws Exception {
        ServicioInventario serv = new ServicioInventario();
        serv.actualizarArticulo(dto);
    }

    public void borrarArticulo(ArticuloDTO dto) throws Exception {
        ServicioInventario serv = new ServicioInventario();
        serv.borrarArticulo(dto);
    }

    public ArticuloDTO consultarArticulo(ArticuloDTO dto) throws Exception {
        ServicioInventario serv = new ServicioInventario();
        return serv.consultaArticulo(dto);
    }

    public List listarArticulos() throws Exception {
        ServicioInventario serv = new ServicioInventario();
        return serv.listarArticulos();
    }

    public void registrarMovimientoInventario(MovArticuloDTO dto) throws Exception {
        ServicioInventario serv = new ServicioInventario();
        serv.registrarMovimientoInventario(dto);
    }

    public List listarMovimientos(MovArticuloDTO dto) throws Exception {
        ServicioInventario serv = new ServicioInventario();
        return serv.listarMovimientos(dto);
    }
}








