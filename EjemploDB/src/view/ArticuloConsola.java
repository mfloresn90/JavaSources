/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import modelo.dto.ArticuloDTO;
import modelo.facade.ServicioInventario;

/**
 *
 * @author Administrador
 */
public class ArticuloConsola {

    public static void main(String args[]) {
        ArticuloDTO articuloDTO = new ArticuloDTO();
        articuloDTO.setClaveArt("fresas02");
        articuloDTO.setDescripcion("Fresas medianas");
        articuloDTO.setPrecio(10.30);
        articuloDTO.setExistencia(80);

        ServicioInventario servicioInventario = new ServicioInventario();

        try {
            servicioInventario.crearArticulo(articuloDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
