package modelo.dao;
import java.sql.SQLException;
import modelo.dto.PruebaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PruebaDAO extends ConexionDBDAO {
    private String SQL_INSERT ="INSERT INTO prueba " +
            "(email, nombre, edad) VALUES" +
            "(?,?,?)";
    private String SQL_READ = "SELECT *FROM prueba WHERE email = ?";
    private String SQL_DELETE = "DELETE FROM Prueba where email = ?";
    public String create(PruebaDTO dto){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1,dto.getEmail());
            ps.setString(2,dto.getNombre());
            ps.setInt(3,dto.getEdad());
            ps.executeUpdate();
            ps.close();
            return "Datos almacenados correctamente!";
        }catch(Exception e){
            return "Datos NO almacenados!";
        }
    }

    public PruebaDTO read(String email){
        PruebaDTO dto = new PruebaDTO();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_READ);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while(rs==null){
                dto = getObject(rs);
            }
            return dto;
        } catch (Exception e) {
            return null;
        }
    }
    public PruebaDTO getObject(ResultSet rs) throws Exception {
        PruebaDTO dto = new PruebaDTO();
        dto.setEmail(rs.getString("EMAIL").toString());
        dto.setNombre(rs.getString("NOMBRE").toString());
        dto.setEdad(rs.getInt("EDAD"));
        return dto;
    }
    public String delete(String email){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setString(1, email);
            ps.executeUpdate();
            ps.close();
        return "Elemento eliminado exitosamente";
        }catch(Exception e){
            return "Elemento no eliminado";
        }
    }
}