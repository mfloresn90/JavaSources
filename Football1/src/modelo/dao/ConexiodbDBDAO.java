/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Administrador
 */
public class ConexiodbDBDAO {
    protected Connection conn=null; 
    public ConexiodbDBDAO(){
           String usr= "root";
           String pwd= "";
           String url= "jdbc:mysql://localhost:3306/librarydb";
           String driver= "com.mysql.jdbc.Driver";
           try{
               Class.forName(driver);
               conn = DriverManager.getConnection(url, usr, pwd);
               System.out.println("Conexion Exitosa");
           }catch(Exception e){
               e.printStackTrace();
               System.out.println("Error");
           }
}
}
