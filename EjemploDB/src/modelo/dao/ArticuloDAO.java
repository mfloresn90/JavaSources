/*
 * ArticuloDAO.java
 *
 * Created on 16 de diciembre 2009, 9:57 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modelo.dao;

import java.sql.*;
import java.util.*;
import modelo.dto.ArticuloDTO;
/**
 *
 * @author Administrador
 */
public class ArticuloDAO extends BaseDAO {
    private static final String SELECT_ALL = "SELECT * FROM ARTICULO";
    private static final String SQL_INSERT = " INSERT INTO ARTICULO "   +
            " (CLAVE_ART, DESCRIPCION, PRECIO, EXISTENCIA) VALUES (?,?,?,?) ";
    private static final String SQL_READ = "SELECT * FROM ARTICULO " +
            "WHERE CLAVE_ART = ?";
    private static final String SQL_DELETE = "DELETE FROM ARTICULO " +
            "WHERE CLAVE_ART = ?";
    private static final String SQL_UPDATE = "UPDATE ARTICULO SET " +
            "DESCRIPCION = ?, PRECIO = ?, EXISTENCIA = ? " +
            "WHERE CLAVE_ART = ? ";
            
    /** Creates a new instance of ArticuloDAO */
    public ArticuloDAO() {
       super();        
    }
    public void append(ArticuloDTO dto) throws Exception {
        PreparedStatement ps = null;
        // creamos la sentencia
        ps = conn.prepareStatement(SQL_INSERT);
        // asignamos valor a cada parametro
        ps.setString(1, dto.getClaveArt());
        ps.setString(2, dto.getDescripcion());
        ps.setDouble(3, dto.getPrecio());
        ps.setInt(4, dto.getExistencia());
        // ejecutar la inserci�n
        ps.executeUpdate();
        
        cerrar(ps);
    }
    public void update(ArticuloDTO dto) throws Exception {
        PreparedStatement ps = null;
        // creamos la sentencia
        ps = conn.prepareStatement(SQL_UPDATE);
        // asignamos valor a cada parametro
        ps.setString(1, dto.getDescripcion());
        ps.setDouble(2, dto.getPrecio());
        ps.setInt(3, dto.getExistencia());
        ps.setString(4, dto.getClaveArt());
        // ejecutar la actualizacion
        ps.executeUpdate();
        
        cerrar(ps);
    }
    public void delete(ArticuloDTO dto) throws Exception {
        PreparedStatement ps = null;
        // creamos la sentencia
        ps = conn.prepareStatement(SQL_DELETE);
        // asignamos valor a cada parametro
        ps.setString(1, dto.getClaveArt());
        // ejecutar la eliminacion
        ps.executeUpdate();
        
        cerrar(ps);
    }
    public ArticuloDTO read(ArticuloDTO dto) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        // el objeto que se regresa
        ArticuloDTO result = null;
        // creamos la sentencia
        ps = conn.prepareStatement(SQL_READ);
        // asignamos valor a cada parametro
        ps.setString(1, dto.getClaveArt());
        // ejecutar la consulta
        rs = ps.executeQuery();
        // si se encontro el registro
        if (rs.next()) {
            result = getObject(rs);
        }
        cerrar(ps);
        cerrar(rs);
        // regresamos el objeto lleno
        return result;
    }
    public List readAll() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        // el objeto que se regresa
        List result = new ArrayList();
        // creamos la sentencia
        ps = conn.prepareStatement(SELECT_ALL);
        // ejecutar la consulta
        rs = ps.executeQuery();
        // si se encontro el registro
        while (rs.next()) {
            // lo agregamos a la lista
            result.add(getObject(rs));
        }
        cerrar(ps);
        cerrar(rs);
        // regresamos el objeto lleno
        return result;
    }
    private ArticuloDTO getObject(ResultSet rs) throws Exception {
         ArticuloDTO dtoArt = new ArticuloDTO();
         //llenar DTO con valores de la tabla
         dtoArt.setClaveArt(rs.getString("CLAVE_ART"));
         dtoArt.setDescripcion(rs.getString("DESCRIPCION"));
         dtoArt.setPrecio(rs.getDouble("PRECIO"));
         dtoArt.setExistencia(rs.getInt("EXISTENCIA"));        
         return dtoArt;
    } 
}