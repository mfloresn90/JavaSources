package modelo.dao;

import modelo.dto.BookDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDao extends ConnDbDao {
    
    /*Se crean variables con las consultas que se van a usar dentro de la aplicación*/

    private String SQL_CREATE = "INSERT INTO books (title, authorId, edition, editorialId, printingDate, categoryId, location, availability) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private String SQL_READ = "SELECT * FROM books WHERE bookId = ?";
    private String SQL_UPDATE = "UPDATE books SET title = ?, authorId = ?, edition = ?, editorialId = ?, printingDate = ?, categoryId = ?, location = ?, availability = ? WHERE bookId = ?";
    private String SQL_DELETE = "DELETE FROM books WHERE bookId = ?";
    
    public BookDao() {
        super();
    }
    
    /*Se crea metodo para crear retomando la variable de sql create y ejecutando la sentencia*/
    public void create(BookDto bdto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_CREATE);
        ps.setString(1, bdto.getTitle());
        ps.setInt(2, bdto.getAuthorId());
        ps.setString(3, bdto.getEdition());
        ps.setInt(4, bdto.getEditorialId());
        ps.setDate(5, bdto.getPrinting());
        ps.setInt(6, bdto.getCategoryId());
        ps.setString(7, bdto.getLocation());
        ps.setInt(8, bdto.getAvailability());
        ps.executeUpdate();
        closePS(ps);
    }
    
    /*Se crea metodo para leer un registro especific retomando la variable de sql read y ejecutando la sentencia*/
    public BookDto read(BookDto bdto) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        BookDto result = null;
        ps = conn.prepareStatement(SQL_READ);
        ps.setInt(1, bdto.getBookId());
        rs = ps.executeQuery();
        if (rs.next()) {
            result = getObject(rs);
        }
        closePS(ps);
        closeRS(rs);
        return result;
    }
    
    /*Se crea metodo para actualizar retomando la variable de sql update y ejecutando la sentencia*/
    public void update(BookDto bdto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_UPDATE);
        ps.setString(1, bdto.getTitle());
        ps.setInt(2, bdto.getAuthorId());
        ps.setString(3, bdto.getEdition());
        ps.setInt(4, bdto.getEditorialId());
        ps.setDate(5, bdto.getPrinting());
        ps.setInt(6, bdto.getCategoryId());
        ps.setString(7, bdto.getLocation());
        ps.setInt(8, bdto.getAvailability());
        ps.setInt(9, bdto.getBookId());
        ps.executeUpdate();
        closePS(ps);
    }
    
    /*Se crea metodo para eliminar retomando la variable de sql delete y ejecutando la sentencia*/
    public void delete(BookDto bdto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_DELETE);
        ps.setInt(1, bdto.getBookId());
        ps.executeUpdate();
        closePS(ps);
    }
    
    /*Se crea metodo para obtener los datos de MySQL especificando los campos de la tabla*/
    private BookDto getObject(ResultSet rs) throws Exception {
        BookDto dtoBoo = new BookDto();
        dtoBoo.setBookId(rs.getInt("bookId"));
        dtoBoo.setTitle(rs.getString("title"));
        dtoBoo.setAuthorId(rs.getInt("authorId"));
        dtoBoo.setEdition(rs.getString("edition"));
        dtoBoo.setEditorialId(rs.getInt("editorialId"));
        dtoBoo.setPrinting(rs.getDate("printing"));
        dtoBoo.setCategoryId(rs.getInt("categoryId"));
        dtoBoo.setLocation(rs.getString("location"));
        dtoBoo.setAvailability(rs.getInt("availability"));
        return dtoBoo;
    }

}