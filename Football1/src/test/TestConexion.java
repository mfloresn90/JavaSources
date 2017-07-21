package test;

import modelo.dao.PruebaDao;
import modelo.dto.PruebaDTO;

public class TestConexion {
    public static void main(String[]args)throws Exception{
     
       PruebaDao pdao = new PruebaDao();
       PruebaDTO dto = new PruebaDTO();

       System.out.println(pdao.create(dto));
    }  
}
