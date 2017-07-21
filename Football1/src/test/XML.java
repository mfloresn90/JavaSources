/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.io.*;
import modelo.dto.PruebaDTO;

public class XML {
   public String create(PruebaDTO persona){
	




	File arch = new File("f:\\Libro1.xls");
        FileWriter fw = null;
        PrintWriter pr = null;
        try {


            fw = new FileWriter(arch, true);

            pr = new PrintWriter(fw);

           //  pr.print("\n"+ "Num Liga"+"\t"+"Nombre Liga");
            pr.print("\n"+persona.getidLeague());
	    pr.print("\t"+persona.getNombre());
	 




        fw.close();

    return "Datos guardados satisfactoriamente";

        } catch(Exception e) {
            return "error";
	}

   }




}