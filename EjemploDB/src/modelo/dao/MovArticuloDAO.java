/*
 * MovArticuloDAO.java
 *
 * Created on 16 de diciembre 2009, 09:46 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package modelo.dao;

import java.sql.*;
import java.util.*;
import modelo.dto.MovArticuloDTO;

/**
 *
 * @author Administrador
 */
public class MovArticuloDAO extends BaseDAO {
    private static final String SELECT_ALL = "SELECT A.FOLIO, A.FECHA, A.TIPO_MOV, "+ 
            "A.CLAVE_ART, A.CANTIDAD, B.DESCRIPCION " + 
            "FROM MOV_ARTICULO A  "+
            " INNER JOIN ARTICULO B ON (A.CLAVE_ART = B.CLAVE_ART )";
    private static final String SQL_INSERT = " INSERT INTO MOV_ARTICULO "   +
            " (FOLIO, FECHA, TIPO_MOV, CLAVE_ART, CANTIDAD ) VALUES (?,?,?,?,? ) ";
    private static final String SQL_READ = "SELECT * FROM MOV_ARTICULO WHERE FOLIO = ?";
    private static final String SQL_DELETE = "DELETE FROM MOV_ARTICULO WHERE FOLIO = ?";
    private static final String SQL_UPDATE = "UPDATE MOV_ARTICULO SET " +
            " FECHA = ?, TIPO_MOV = ?, CLAVE_ART = ?, CANTIDAD = ? " +
            " WHERE FOLIO = ? ";
    
    private static final String SQL_NEXT_FOLIO = "SELECT MAX(FOLIO) AS NEXT_FOLIO FROM MOV_ARTICULO  ";
    
    /** Creates a new instance of MovArticuloDAO */
    public MovArticuloDAO() {
    }
    
    private int getNextFolio() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        // el objeto que se regresa
        int result = 0;
        // creamos la sentencia
        ps = conn.prepareStatement(SQL_NEXT_FOLIO);
        // ejecutar la consulta
        rs = ps.executeQuery();
        // si se encontro el registro
        if (rs.next()) {
            result = rs.getInt("NEXT_FOLIO");
        }
        cerrar(ps);
        cerrar(rs);
        // regresamos el siguiente folio
        return result+1;
        
    }
    
    public void append(MovArticuloDTO dto) throws Exception {
        PreparedStatement ps = null;
        // creamos la sentencia
        java.sql.Date fecha = new java.sql.Date(dto.getFecha().getTime());
        ps = conn.prepareStatement(SQL_INSERT);
        // asignamos valor a cada parametro
        ps.setInt(1, getNextFolio() );
        ps.setDate(2,fecha );
        ps.setString(3, dto.getTipoMov()); 
        ps.setString(4, dto.getClaveArt());
        ps.setInt(5,dto.getCantidad());
                
        // ejecutar la inserci�n
        ps.executeUpdate();
        
        cerrar(ps);
    }
   
    public void update(MovArticuloDTO dto) throws Exception {
        PreparedStatement ps = null;
        // creamos la sentencia
        ps = conn.prepareStatement(SQL_UPDATE);
        // asignamos valor a cada parametro
        ps.setDate(1,(java.sql.Date) dto.getFecha());
        ps.setString(2, dto.getTipoMov());
        ps.setString(3, dto.getClaveArt());
        ps.setInt(4, dto.getCantidad());
        ps.setInt(5,dto.getFolio());
        // ejecutar la actualizacion
        ps.executeUpdate();
        
        cerrar(ps);
    }
    
    public void delete(MovArticuloDTO dto) throws Exception {
        PreparedStatement ps = null;
        // creamos la sentencia
        ps = conn.prepareStatement(SQL_DELETE);
        // asignamos valor a cada parametro
        ps.setInt(1, dto.getFolio());
        // ejecutar la eliminacion
        ps.executeUpdate();
        
        cerrar(ps);
    }

    public MovArticuloDTO read(MovArticuloDTO dto) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        // el objeto que se regresa
        MovArticuloDTO result = null;
        // creamos la sentencia
        ps = conn.prepareStatement(SQL_READ);
        // asignamos valor a cada parametro
        ps.setInt(1, dto.getFolio());
        // ejecutar la consulta
        rs = ps.executeQuery();
        // si se encontro el registro
        if (rs.next()) {
            result = getObject(rs,false);
        }
        cerrar(ps);
        cerrar(rs);
        // regresamos el objeto lleno
        return result;
    }

    public List readAll(MovArticuloDTO dto) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        // el objeto que se regresa
        List result = new ArrayList();
        // creamos la sentencia
        ps = conn.prepareStatement( getQuery(dto) );
        // ejecutar la consulta
        rs = ps.executeQuery();
        // si se encontro el registro
        while (rs.next()) {
            // lo agregamos a la lista
            result.add(getObject(rs,true));
        }
        cerrar(ps);
        cerrar(rs);
        // regresamos el objeto lleno
        return result;
    }
    
    private String getQuery(MovArticuloDTO dto) {
        StringBuffer filtro = new StringBuffer(SELECT_ALL);
        filtro.append(" WHERE 1 = 1 " );
        // Construir el filtro
        if (dto.getTipoMov() != null && ! dto.getTipoMov().equals("") ) {
          filtro.append(" AND A.TIPO_MOV = '");
          filtro.append(dto.getTipoMov()).append("' ");
        }
        if (dto.getClaveArt() != null && ! dto.getClaveArt().equals("") ) {
          filtro.append(" AND A.CLAVE_ART = '");
          filtro.append(dto.getClaveArt()).append("' ");
        }
        return filtro.toString();
    }
    
    private MovArticuloDTO getObject(ResultSet rs, boolean detalle) throws Exception {
         MovArticuloDTO dto = new MovArticuloDTO();
         //llenar DTO con valores de la tabla
         dto.setFolio(rs.getInt("FOLIO"));
         dto.setFecha(rs.getDate("FECHA"));
         dto.setClaveArt(rs.getString("CLAVE_ART"));
         dto.setTipoMov(rs.getString("TIPO_MOV"));
         dto.setCantidad(rs.getInt("CANTIDAD"));        
         
         if (detalle) {
            dto.setDescripcion(rs.getString("DESCRIPCION"));
         }
         
         return dto;
    }
    
}
