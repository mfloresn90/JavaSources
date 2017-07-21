package model.dao;

import hibernate.pojos.Phone;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author yoshiblacke
 */
public class PhoneDao {
    
    SessionFactory sf = null;
    Session sn = null;
    
    public PhoneDao() {
        sf = HibernateUtil.getSessionFactory();
    }

    public String createPhone(Phone pPe) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.save(pPe);
            tx.commit();
            msg = "Telefono agregad@ correctamente!.";
        } catch (Exception e) {
            tx.rollback();
            msg = "No se pudo crear Telefono.";
            throw new RuntimeException("No se pudo guardar Telefono");
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public List<Phone> readAllPhone() {
        List<Phone> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM Phone AS tbl ORDER BY tbl.phoneSku";
            Query qry = sn.createQuery(hql);
            lst = qry.list();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            sn.flush();
            sn.close();
        }
        return lst;
    }
    
    public Phone readPhoneById(Integer id) {
        List<Phone> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM Phone AS tbl WHERE tbl.idPhone = :id";
            Query qry = sn.createQuery(hql);
            qry.setParameter("id", id);
            lst = qry.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sn.flush();
            sn.close();
        }
        return lst.get(0);
    }

    public String updatePhone(Phone pPe) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.update(pPe);
            tx.commit();
            msg = "Telefono actualizad@.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo actualizar Telefono.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public String deletePhone(Integer id) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            Phone lst = (Phone) sn.load(Phone.class, id);
            sn.delete(lst);
            tx.commit();
            msg = "Telefono eliminad@ con exito.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo eliminar Telefono.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

}