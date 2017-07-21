package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnDbDao {

    protected Connection conn = null;

    public ConnDbDao() {
        /*Se procede a realizar la conexion de la base de datos*/
        String usr = "root";
        String pwd = "";
        String url = "jdbc:mysql://localhost:3306/librarydb";
        String driver = "com.mysql.jdbc.Driver";
        try {
            /*Se ejecuta el driver que esta contenido en la libreria*/
            Class.forName(driver);
            /*Con la conexion del driver exitosa se puede realizar la conezion
            de la base de datos*/
            conn = DriverManager.getConnection(url, usr, pwd);
            //System.out.println("Conexion Exitosa");
        } catch (Exception e) {
            /*En caso de error se mostrara aqui*/
            e.printStackTrace();
            //System.out.println("Error");
        }
    }
    
    /*Metodo para cerrar la preparacion de sentencia*/
    protected void closePS(PreparedStatement ps) throws Exception {
        if (ps != null) {
            ps.close();
        }
    }

    /*Metodo para cerrar el resultado de la sentencia*/
    protected void closeRS(ResultSet rs) throws Exception {
        if (rs != null) {
            rs.close();
        }
    }
}
