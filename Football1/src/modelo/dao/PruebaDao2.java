package modelo.dao;

import modelo.dto.PruebaDTO2;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class PruebaDao2 extends ConexiodbDBDAO{

    private String SQL_INSERT = "insert into player" +
            "(email,name,password) values" +
            "(?,?,?)";
    private String SQL_READ= "select * from Playfootball where email=?";
    private String SQL_DELETE = "select * from Platfootball";
    public String create (PruebaDTO2 dto2){
         PreparedStatement ps2 = null;
         try{
            ps2 = conn.prepareStatement(SQL_INSERT);
            ps2.setString(1,dto2.getEmail());
            ps2.setString(2, dto2.getNombre());
            ps2.setString(3,dto2.getPassword());

            ps2.executeUpdate();
            return "Datos guardados";
         }catch(Exception e){
             return "Datos no guardados";
         }
    }
    public PruebaDTO2 read(String email){
        PruebaDTO2 dto = new PruebaDTO2();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {


            return dto;
        }catch(Exception E){
            return  null;

        }

    }

    public PruebaDTO2 delete(String email){
        PruebaDTO2 dto = new PruebaDTO2();




        return dto;
    }
}
