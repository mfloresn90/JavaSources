package conn;

import java.sql.*;

public class ConexionMySQL {

    Connection conn = null;

    public Connection conectBdd() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dsschool", "root", "");

        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }

        return conn;
    }

}
