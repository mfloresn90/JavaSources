package modelo.dao;

import modelo.dto.PruebaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class PruebaDao extends ConexiodbDBDAO{
    private String SQL_INSERT ="insert into League"+
            "(idLeague,name) values"+
            "(?,?)";

    private String SQL_READ= "select * from Playfootball where idLeague=?";
    private String SQL_DELETE = "select * from League";
    public String create (PruebaDTO dto){
         PreparedStatement ps = null;
         try{
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1,dto.getidLeague());
            ps.setString(2, dto.getNombre());

            ps.executeUpdate();
            return "Datos guardados";
         }catch(Exception e){
             return "Datos no guardados";
         }
    }
    public PruebaDTO read(int idLeague){
        PruebaDTO dto = new PruebaDTO();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {


            return dto;
        }catch(Exception E){
            return  null;

        }

    }

    public PruebaDTO delete(String email){
        PruebaDTO dto = new PruebaDTO();




        return dto;
    }
}
