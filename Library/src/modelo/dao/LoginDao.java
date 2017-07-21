package modelo.dao;

import modelo.dto.LoginDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao extends ConnDbDao {
    
    /*Se crean variables con las consultas que se van a usar dentro de la aplicación*/

    private String SQL_CREATE = "INSERT INTO users (name, email, password, userTypeId, birthday) VALUES (?, ?, ?, ?, ?)";
    private String SQL_READ = "SELECT * FROM users WHERE email = ?";
    private String SQL_UPDATE = "UPDATE users SET name = ?, email = ?, password = ?, birthday = ?  WHERE userId = ?";
    
    public LoginDao() {
        super();
    }
    
    /*Se crea metodo para crear retomando la variable de sql create y ejecutando la sentencia*/
    public void create(LoginDto ldto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_CREATE);
        ps.setString(1, ldto.getName());
        ps.setString(2, ldto.getEmail());
        ps.setString(3, ldto.getPassword());
        ps.setInt(4, ldto.getUserType());
        ps.setDate(5, ldto.getBirthday());
        ps.executeUpdate();
        closePS(ps);
    }

    /*Se crea metodo para leer un registro especific retomando la variable de sql read y ejecutando la sentencia*/
    public LoginDto read(LoginDto ldto) throws Exception {
        LoginDto result = new LoginDto();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ps = conn.prepareStatement(SQL_READ);
        ps.setString(1, ldto.getEmail());
        rs = ps.executeQuery();
        if (rs.next()) {
            result = getObject(rs);
        }
        closePS(ps);
        closeRS(rs);
        return result;
    }
    
    /*Se crea metodo para actualizar retomando la variable de sql update y ejecutando la sentencia*/
    public void update(LoginDto ldto) throws Exception {
        PreparedStatement ps = null;
        ps = conn.prepareStatement(SQL_UPDATE);
        ps.setString(1, ldto.getName());
        ps.setString(2, ldto.getEmail());
        ps.setString(3, ldto.getPassword());
        ps.setDate(4, ldto.getBirthday());
        ps.setInt(5, ldto.getUserId());
        ps.executeUpdate();
        closePS(ps);
    }

    /*Se crea metodo para obtener los datos de MySQL especificando los campos de la tabla*/
    private LoginDto getObject(ResultSet rs) throws Exception {
        LoginDto dtoLog = new LoginDto();
        dtoLog.setUserId(rs.getInt("userId"));
        dtoLog.setName(rs.getString("name"));
        dtoLog.setEmail(rs.getString("email"));
        dtoLog.setPassword(rs.getString("password"));
        dtoLog.setUserType(rs.getInt("userTypeId"));
        dtoLog.setRegistry(rs.getDate("registry"));
        dtoLog.setBirthday(rs.getDate("birthday"));
        return dtoLog;
    }

}