package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDBDAO {
    protected Connection conn = null;
    public ConexionDBDAO(){
        String usr = "root";
        String pwd = "root";
        String url = "jdbc:mysql://localhost:3306/test";
        String driver = "com.mysql.jdbc.Driver";
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usr, pwd);
            System.out.println("Conexión exitosa");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error");
        }
    }
}
