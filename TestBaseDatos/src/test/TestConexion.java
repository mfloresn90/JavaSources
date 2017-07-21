package test;

import modelo.dao.PruebaDAO;
import modelo.dto.PruebaDTO;

public class TestConexion {

    public static void main(String[] args) throws Exception{
        PruebaDAO pdao = new PruebaDAO();
        PruebaDTO dto = new PruebaDTO();
//        dto.setEmail("o@0.com");
//        dto.setNombre("o");
//        dto.setEdad(12);
//        System.out.println(pdao.create(dto));
//        pdao.read("a@a.com");
//        System.out.println(pdao.delete("CVLEON"));
        dto = pdao.read("cvleonardo@g.com");
        System.out.println(dto.getNombre());
    }
    
}
