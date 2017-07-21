/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen.dao;

import imagen.pojos.Imagen;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Rata
 */
public class imagenDAO {
     
    public void ingresarImagen(Imagen i){
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx = null;
        
        try {
                sf = HibernateUtil.getSessionFactory();
                sesion= sf.openSession();
                tx = sesion.beginTransaction();
                sesion.save(i);
                tx.commit();
                sesion.close();
        } catch (Exception e) {
            
                tx.rollback();
                e.printStackTrace();
        }
    }
    
    public Imagen consultarImagen(int id){
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session sesion = sf.openSession();
            Imagen i = (Imagen)sesion.get(Imagen.class, id);
            
            if(i!= null){
            //        return "La imagen es " + i.getId() +i.getImagen() + "y su descripcion es:" + i.getDescripcion();
                return i;
            }
            else{
            //        return "Sorry my friend";
                return null;
            }     
     }
}
