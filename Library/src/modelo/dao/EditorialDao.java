package modelo.dao;

import modelo.dto.EditorialDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EditorialDao extends ConnDbDao {
    
    /*Se crean variables con las consultas que se van a usar dentro de la aplicación*/

    private String SQL_CREATE = "INSERT INTO editorial (editorial) VALUES (?)";
    private String SQL_READ = "SELECT * FROM editorial WHERE editorialId = ?";
    private String SQL_UPDATE = "UPDATE editorial SET editorial = ? WHERE editorialId = ?";
    private String SQL_DELETE = "DELETE FROM editorial WHERE editorialId = ?";
    
    public EditorialDao() {
        super();
    }
    
    /*Se crea metodo para crear retomando la variable de sql create y ejecutando la sentencia*/
    public void create(EditorialDto edto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_CREATE);
        ps.setString(1, edto.getEditorial());
        ps.executeUpdate();
        closePS(ps);
    }
    
    /*Se crea metodo para leer un registro especific retomando la variable de sql read y ejecutando la sentencia*/
    public EditorialDto read(EditorialDto edto) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        EditorialDto result = null;
        ps = conn.prepareStatement(SQL_READ);
        ps.setInt(1, edto.getEditorialId());
        rs = ps.executeQuery();
        if (rs.next()) {
            result = getObject(rs);
        }
        closePS(ps);
        closeRS(rs);
        return result;
    }
    
    /*Se crea metodo para actualizar retomando la variable de sql update y ejecutando la sentencia*/
    public void update(EditorialDto edto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_UPDATE);
        ps.setString(1, edto.getEditorial());
        ps.setInt(2, edto.getEditorialId());
        ps.executeUpdate();
        closePS(ps);
    }
    
    /*Se crea metodo para eliminar retomando la variable de sql delete y ejecutando la sentencia*/
    public void delete(EditorialDto edto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_DELETE);
        ps.setInt(1, edto.getEditorialId());
        ps.executeUpdate();
        closePS(ps);
    }
    
    /*Se crea metodo para obtener los datos de MySQL especificando los campos de la tabla*/
    private EditorialDto getObject(ResultSet rs) throws Exception {
        EditorialDto dtoEdi = new EditorialDto();
        dtoEdi.setEditorialId(rs.getInt("editorialId"));
        dtoEdi.setEditorial(rs.getString("editorial"));
        return dtoEdi;
    }

}