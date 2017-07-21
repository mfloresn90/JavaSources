package modelo.dao;

import modelo.dto.CategoryDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CategoryDao extends ConnDbDao {
    
    /*Se crean variables con las consultas que se van a usar dentro de la aplicación*/

    private String SQL_CREATE = "INSERT INTO categories (category, counter) VALUES (?, ?)";
    private String SQL_READ = "SELECT * FROM categories WHERE categoryId = ?";
    private String SQL_UPDATE = "UPDATE categories SET category = ? WHERE categoryId = ?";
    private String SQL_DELETE = "DELETE FROM categories WHERE categoryId = ?";
    
    public CategoryDao() {
        super();
    }
    
    /*Se crea metodo para crear retomando la variable de sql create y ejecutando la sentencia*/
    public void create(CategoryDto cdto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_CREATE);
        ps.setString(1, cdto.getCategory());
        ps.setInt(2, cdto.getCounter());
        ps.executeUpdate();
        closePS(ps);
    }
    
    /*Se crea metodo para leer un registro especific retomando la variable de sql read y ejecutando la sentencia*/
    public CategoryDto read(CategoryDto cdto) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        CategoryDto result = null;
        ps = conn.prepareStatement(SQL_READ);
        ps.setInt(1, cdto.getCategoryId());
        rs = ps.executeQuery();
        if (rs.next()) {
            result = getObject(rs);
        }
        closePS(ps);
        closeRS(rs);
        return result;
    }
    
    /*Se crea metodo para actualizar retomando la variable de sql update y ejecutando la sentencia*/
    public void update(CategoryDto cdto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_UPDATE);
        ps.setString(1, cdto.getCategory());
        ps.setInt(2, cdto.getCategoryId());
        ps.executeUpdate();
        closePS(ps);
    }
    
    /*Se crea metodo para eliminar retomando la variable de sql delete y ejecutando la sentencia*/
    public void delete(CategoryDto cdto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_DELETE);
        ps.setInt(1, cdto.getCategoryId());
        ps.executeUpdate();
        closePS(ps);
    }
    
    /*Se crea metodo para obtener los datos de MySQL especificando los campos de la tabla*/
    private CategoryDto getObject(ResultSet rs) throws Exception {
        CategoryDto dtoCat = new CategoryDto();
        dtoCat.setCategoryId(rs.getInt("categoryId"));
        dtoCat.setCategory(rs.getString("category"));
        dtoCat.setCounter(rs.getInt("counter"));
        return dtoCat;
    }

}