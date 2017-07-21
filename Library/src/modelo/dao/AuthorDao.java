package modelo.dao;

import modelo.dto.AuthorDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthorDao extends ConnDbDao {
    
    /*Se crean variables con las consultas que se van a usar dentro de la aplicación*/

    private String SQL_CREATE = "INSERT INTO authors (name, birthday) VALUES (?, ?)";
    private String SQL_READ = "SELECT * FROM authors WHERE authorId = ?";
    private String SQL_UPDATE = "UPDATE authors SET name = ?, birthday = ? WHERE authorId = ?";
    private String SQL_DELETE = "DELETE FROM authors WHERE authorId = ?";
    
    public AuthorDao() {
        super();
    }
    
    /*Se crea metodo para crear retomando la variable de sql create y ejecutando la sentencia*/
    public void create(AuthorDto adto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_CREATE);
        ps.setString(1, adto.getName());
        ps.setDate(2, adto.getBirthday());
        ps.executeUpdate();
        closePS(ps);
    }
    
    /*Se crea metodo para leer un registro especific retomando la variable de sql read y ejecutando la sentencia*/
    public AuthorDto read(AuthorDto adto) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorDto result = null;
        ps = conn.prepareStatement(SQL_READ);
        ps.setInt(1, adto.getAuthorId());
        rs = ps.executeQuery();
        if (rs.next()) {
            result = getObject(rs);
        }
        closePS(ps);
        closeRS(rs);
        return result;
    }
    
    /*Se crea metodo para actualizar retomando la variable de sql update y ejecutando la sentencia*/
    public void update(AuthorDto adto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_UPDATE);
        ps.setString(1, adto.getName());
        ps.setDate(2, adto.getBirthday());
        ps.setInt(3, adto.getAuthorId());
        ps.executeUpdate();
        closePS(ps);
    }
    
    /*Se crea metodo para eliminar retomando la variable de sql delete y ejecutando la sentencia*/
    public void delete(AuthorDto adto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_DELETE);
        ps.setInt(1, adto.getAuthorId());
        ps.executeUpdate();
        closePS(ps);
    }
    
    /*Se crea metodo para obtener los datos de MySQL especificando los campos de la tabla*/
    private AuthorDto getObject(ResultSet rs) throws Exception {
        AuthorDto dtoAut = new AuthorDto();
        dtoAut.setAuthorId(rs.getInt("authorId"));
        dtoAut.setName(rs.getString("name"));
        dtoAut.setBirthday(rs.getDate("birthday"));
        return dtoAut;
    }

}