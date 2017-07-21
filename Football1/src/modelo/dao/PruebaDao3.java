package modelo.dao;

import java.sql.Date;
import modelo.dto.PruebaDTO3;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class PruebaDao3 extends ConexiodbDBDAO{

    private String SQL_INSERT1 = "insert into Register"+
            "(folio,fecha,idLeague,email) values"+
            "(?,?,?,?)";
    private String SQL_READ= "select * from Playfootball where folio=?";
    private String SQL_DELETE = "select * from Playfootball";
    public String create (PruebaDTO3 dto){
         PreparedStatement ps = null;
         try{
            ps = conn.prepareStatement(SQL_INSERT1);
            ps.setInt(1,dto.getFolio());
            ps.setDate(2, (Date) dto.getFecha());
            ps.setString(3,dto.getIdLeague());
            ps.setString(4,dto.getEmail());

            ps.executeUpdate();
            return "Datos guardados";
         }catch(Exception e){
             return "Datos no guardados";
         }
    }
    public PruebaDTO3 read(int idLeague){
        PruebaDTO3 dto = new PruebaDTO3();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {


            return dto;
        }catch(Exception E){
            return  null;

        }

    }

    public PruebaDTO3 delete(String folio){
        PruebaDTO3 dto = new PruebaDTO3();




        return dto;
    }
}
