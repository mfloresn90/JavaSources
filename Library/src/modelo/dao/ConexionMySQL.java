package modelo.dao;

import java.sql.*;

public class ConexionMySQL {

    Connection conn = null;

    public Connection conectBdd() {
        try {
            /*Se ejecuta el driver que esta contenido en la libreria*/
            Class.forName("com.mysql.jdbc.Driver");
            /*Con la conexion del driver exitosa se puede realizar la conezion
            de la base de datos*/
            conn = DriverManager.getConnection("jdbc:mysql://localhost/librarydb", "root", "");
        } catch (Exception ex) {
            /*En caso de error se mostrara aqui*/
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return conn;
    }
}
